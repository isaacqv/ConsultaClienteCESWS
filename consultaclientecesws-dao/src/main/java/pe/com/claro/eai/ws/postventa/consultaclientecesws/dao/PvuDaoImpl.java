package pe.com.claro.eai.ws.postventa.consultaclientecesws.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.driver.OracleTypes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarEquipoRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarEquipoResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Equipo;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.dao.util.Utilitario;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.DBException;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.PropertiesInternos;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Utilitarios;

@Repository
public class PvuDaoImpl implements PvuDao{
	
	private final static Logger logger = Logger.getLogger(PvuDaoImpl.class);
	
	@Autowired
	@Qualifier(value = "pvuDS")
	private DataSource pvuDS;
	
	@Autowired
	Propiedades propiedadesExterna;

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarEquipoResponse consultarEquipo(String mensajeTransaccion,
			ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException {
		String metodo = "consultarEquipo";
		String mensajeLog = mensajeTransaccion + "[" + metodo + "]-";
		ConsultarEquipoResponse response = new ConsultarEquipoResponse();
		logger.info(mensajeLog + " == Inicio del metodo " + metodo);
		Connection conexion = null;
		try {
			
			logger.info(mensajeLog + "Consultando BD " + propiedadesExterna.dbPVU + ", con JNDI = [" + propiedadesExterna.cJNDI_PVU + "]");
			pvuDS.setLoginTimeout(propiedadesExterna.dbPVULoginTimeout);
			conexion = pvuDS.getConnection();
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(pvuDS)
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(propiedadesExterna.dbPVUOwner)
					.withProcedureName(propiedadesExterna.spSicess_equipment_ifi)
					.declareParameters(
							new SqlParameter("PI_CO_ID", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CODIGO_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_MENSAJE_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CURSOR_EQUIPO", OracleTypes.CURSOR, new RowMapper<Equipo>() {
								public Equipo mapRow(ResultSet rs, int arg1) throws SQLException {
									Equipo equipo = new Equipo();
									equipo.setType(Utilitarios.isNullOrBlankToString(rs.getString("TYPE")));
									equipo.setModel(Utilitarios.isNullOrBlankToString(rs.getString("MODEL")));
									equipo.setSerialNumber(Utilitarios.isNullOrBlankToString(rs.getString("SERIALNUMBER")));
									return equipo;
								}
							}));
			
			logger.info(mensajeLog + "Se invocara el SP : " + this.propiedadesExterna.dbPVUOwner.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_equipment_ifi));
			logger.info(mensajeLog + "PARAMETROS [INPUT]: ");
			logger.info(mensajeLog + "[PI_CO_ID] = " + objConsultarEquipoRequest.getCoId());
			
			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("PI_CO_ID", objConsultarEquipoRequest.getCoId());
			
			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.dbPVUExecutionTimeout);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);
			
			logger.info(mensajeLog + "PARAMETROS [OUTPUT]: ");
			logger.info(mensajeLog + "[PO_CODIGO_SALIDA] = " + resultMap.get("PO_CODIGO_SALIDA"));
			logger.info(mensajeLog + "[PO_MENSAJE_SALIDA] = " + resultMap.get("PO_MENSAJE_SALIDA"));
			
			List<Equipo> listaEquipos = (List<Equipo>) Optional.ofNullable(resultMap.get("PO_CURSOR_EQUIPO")).orElse(Collections.emptyList());
			
			response.setCodRespuesta(Utilitarios.isNullOrBlankToString(resultMap.get("PO_CODIGO_SALIDA")));
			response.setMsgRespuesta(Utilitarios.isNullOrBlankToString(resultMap.get("PO_MENSAJE_SALIDA")));
			response.setListEquipo(listaEquipos);
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault()).contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbPVU).replace("$sp", propiedadesExterna.spSicess_equipment_ifi).replace("$msg", error));
		} finally {
            try {
                Utilitario.close(mensajeLog, conexion);
            } catch (SQLException e) {
                logger.info(mensajeLog + "ERROR al cerrar la conexion: [Exception] - [" + e.getMessage() + "]", e);
            }
			logger.info(mensajeLog + " == Fin del metodo " + metodo);
		}
		return response;
	}

}
