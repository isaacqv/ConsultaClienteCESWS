package pe.com.claro.eai.ws.postventa.consultaclientecesws.dao;

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
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarInteraccionCasosRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarInteraccionCasosResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.DatosInfVar;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.DatosProblema;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ListaDatosInfVar;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ListaDatosProblema;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.DBException;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Constantes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.PropertiesInternos;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Utilitarios;

@Repository
public class ClarifyDaoImpl implements ClarifyDao {

	private final static Logger logger = Logger.getLogger(ClarifyDaoImpl.class);

	@Autowired
	@Qualifier(value = "clarifyDS")
	private DataSource clarifyDS;

	@Autowired
	Propiedades propiedadesExterna;

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarInteraccionCasosResponse consultarInformacionVariacion(String mensajeTransaccion,
			ConsultarInteraccionCasosRequest objConsultarInteraccionCasosRequest) throws DBException {
		String metodo = "consultarInformacionVariacion";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarInteraccionCasosResponse response = new ConsultarInteraccionCasosResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbCLARIFYDB + ", con JNDI = [" + this.propiedadesExterna.cJNDI_CLARIFY + "]");
			clarifyDS.setLoginTimeout(this.propiedadesExterna.dbClarifyDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(clarifyDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.propiedadesExterna.dbCLARIFYDBOwner)
					.withProcedureName(this.propiedadesExterna.pckInteractClfyHfc.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spQuery_interact_hfc))
					.declareParameters(
							new SqlParameter("P_PHONE", OracleTypes.VARCHAR),
							new SqlParameter("P_ACCOUNT", OracleTypes.VARCHAR),
							new SqlParameter("P_SITEOBJID_1", OracleTypes.VARCHAR),
							new SqlParameter("P_CONTACTOBJID_1", OracleTypes.VARCHAR),
							new SqlParameter("P_TIPIFICACION", OracleTypes.VARCHAR),
							new SqlOutParameter("FLAG_CREACION", OracleTypes.VARCHAR),
							new SqlOutParameter("MSG_TEXT", OracleTypes.VARCHAR),
							new SqlOutParameter("INTERACT", OracleTypes.CURSOR, new RowMapper<DatosInfVar>() {
								public DatosInfVar mapRow(ResultSet rs, int arg1) throws SQLException {
									DatosInfVar datosInfVar = new DatosInfVar();
									datosInfVar.setInteraccion(Utilitarios.isNullOrBlankToString(rs.getString("ID_INTERACCION")));
									datosInfVar.setFecCreacion(Utilitarios.isNullOrBlankToString(rs.getString("FECHA_CREACION")));
									datosInfVar.setFecInicio(Utilitarios.isNullOrBlankToString(rs.getString("START_DATE")));
									datosInfVar.setTelefono(Utilitarios.isNullOrBlankToString(rs.getString("TELEFONO")));
									datosInfVar.setTipo(Utilitarios.isNullOrBlankToString(rs.getString("TIPO")));
									datosInfVar.setClase(Utilitarios.isNullOrBlankToString(rs.getString("CLASE")));
									datosInfVar.setSubClase(Utilitarios.isNullOrBlankToString(rs.getString("SUBCLASE")));
									datosInfVar.setTipificacion(Utilitarios.isNullOrBlankToString(rs.getString("TIPIFICACION")));
									datosInfVar.setTipoCodigo(Utilitarios.isNullOrBlankToString(rs.getString("TIPO_CODIGO")));
									datosInfVar.setClaseCodigo(Utilitarios.isNullOrBlankToString(rs.getString("CLASE_CODIGO")));
									datosInfVar.setSubClaseCodigo(Utilitarios.isNullOrBlankToString(rs.getString("SUBCLASE_CODIGO")));
									datosInfVar.setInsertadoPor(Utilitarios.isNullOrBlankToString(rs.getString("INSERTADO_POR")));
									datosInfVar.setTipoInter(Utilitarios.isNullOrBlankToString(rs.getString("TIPO_INTER")));
									datosInfVar.setMetodo(Utilitarios.isNullOrBlankToString(rs.getString("METODO")));
									datosInfVar.setResultado(Utilitarios.isNullOrBlankToString(rs.getString("RESULTADO")));
									datosInfVar.setHechoEnUno(Utilitarios.isNullOrBlankToString(rs.getString("HECHO_EN_UNO")));
									datosInfVar.setAgente(Utilitarios.isNullOrBlankToString(rs.getString("AGENTE")));
									datosInfVar.setNombreAgente(Utilitarios.isNullOrBlankToString(rs.getString("NOMBRE_AGENTE")));
									datosInfVar.setApellidoAgente(Utilitarios.isNullOrBlankToString(rs.getString("APELLIDO_AGENTE")));
									datosInfVar.setIdCaso(Utilitarios.isNullOrBlankToString(rs.getString("ID_CASO")));
									datosInfVar.setEstado(Utilitarios.isNullOrBlankToString(rs.getString("ESTADO")));
									datosInfVar.setServicio(Utilitarios.isNullOrBlankToString(rs.getString("SERVICIO")));
									datosInfVar.setInconveniente(Utilitarios.isNullOrBlankToString(rs.getString("INCONVENIENTE")));
									datosInfVar.setContrato(Utilitarios.isNullOrBlankToString(rs.getString("CONTRATO")));
									datosInfVar.setPlano(Utilitarios.isNullOrBlankToString(rs.getString("PLANO")));
									datosInfVar.setPlataforma(PropertiesInternos.STRING_EMPTY);
									
									return datosInfVar;
								}
							}));

			String strPhone = PropertiesInternos.STRING_EMPTY;
			if (objConsultarInteraccionCasosRequest.getTecnologia().trim().equals(propiedadesExterna.tecnologiaDTH) ||
				objConsultarInteraccionCasosRequest.getTecnologia().trim().equals(propiedadesExterna.tecnologiaIFI)) {
				strPhone = objConsultarInteraccionCasosRequest.getTelefono();
			} else {
				// HFC, LTE
				strPhone = Constantes.IDENTIFICADOR_FIJO + objConsultarInteraccionCasosRequest.getCustomerId();
			}
			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : " + this.propiedadesExterna.dbCLARIFYDBOwner.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.pckInteractClfyHfc).concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spQuery_interact_hfc));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[P_PHONE] = " + strPhone);
			logger.info(String.valueOf(mensajeLog) + "[P_ACCOUNT] = ");
			logger.info(String.valueOf(mensajeLog) + "[P_SITEOBJID_1] = ");
			logger.info(String.valueOf(mensajeLog) + "[P_CONTACTOBJID_1] = ");
			logger.info(String.valueOf(mensajeLog) + "[P_TIPIFICACION] = ");

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("P_PHONE", strPhone)
					.addValue("P_ACCOUNT", PropertiesInternos.NULL)
					.addValue("P_SITEOBJID_1", PropertiesInternos.NULL)
					.addValue("P_CONTACTOBJID_1", PropertiesInternos.NULL)
					.addValue("P_TIPIFICACION", PropertiesInternos.NULL);

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_CLARIFY);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[FLAG_CREACION] = " + resultMap.get("FLAG_CREACION"));
			logger.info(String.valueOf(mensajeLog) + "[MSG_TEXT] = " + resultMap.get("MSG_TEXT"));

			ListaDatosInfVar listaDatosInfVar = new ListaDatosInfVar();
			
			listaDatosInfVar.setListDatosInfVar((List<DatosInfVar>) Optional.ofNullable(resultMap.get("INTERACT")).orElse(Collections.emptyList()));
			
			response.setListDatosInfVar(listaDatosInfVar);
			response.setCodRespuesta(Utilitarios.isNullOrBlankToString(resultMap.get("FLAG_CREACION")));
			response.setMsgRespuesta(Utilitarios.isNullOrBlankToString(resultMap.get("MSG_TEXT")));
			logger.info(String.valueOf(mensajeLog) + "[Cantidad interact] = " + (listaDatosInfVar.getListDatosInfVar().size()));
		} catch (Exception e) {
			logger.error(String.valueOf(mensajeLog) + "Error en la ejecucion del SP : ", e);
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
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbCLARIFYDB).replace("$sp", propiedadesExterna.spQuery_interact_hfc).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarInteraccionCasosResponse consultarProblemas(String mensajeTransaccion,
			ConsultarInteraccionCasosRequest objConsultarInteraccionCasosRequest) throws DBException {
		String metodo = "consultarProblemas";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarInteraccionCasosResponse response = new ConsultarInteraccionCasosResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbCLARIFYDB + ", con JNDI = [" + this.propiedadesExterna.cJNDI_CLARIFY + "]");
			clarifyDS.setLoginTimeout(this.propiedadesExterna.dbClarifyDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(clarifyDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.propiedadesExterna.dbCLARIFYDBOwner)
					.withProcedureName(this.propiedadesExterna.pckCaseClfyHfc.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spQuery_case_hfc))
					.declareParameters(
							new SqlParameter("ACCOUNT", OracleTypes.VARCHAR),
							new SqlParameter("TELEPHONE", OracleTypes.VARCHAR),
							new SqlParameter("CONTACT_OBJID1", OracleTypes.VARCHAR),
							new SqlParameter("TIPIFICACION", OracleTypes.VARCHAR),
							new SqlParameter("ESTADO", OracleTypes.VARCHAR),
							new SqlParameter("P_SERVICE", OracleTypes.VARCHAR),
							new SqlParameter("P_TIPO_QUERY", OracleTypes.VARCHAR),
							new SqlParameter("P_FECHA_INICIO", OracleTypes.VARCHAR),
							new SqlParameter("P_FECHA_FIN", OracleTypes.VARCHAR),
							new SqlOutParameter("P_FLAG_CONSULTA", OracleTypes.VARCHAR),
							new SqlOutParameter("P_MSG_TEXT", OracleTypes.VARCHAR),
							new SqlOutParameter("OUT_CURSOR", OracleTypes.CURSOR, new RowMapper<DatosProblema>() {
								public DatosProblema mapRow(ResultSet rs, int arg1) throws SQLException {
									DatosProblema datosProblema = new DatosProblema();
									datosProblema.setCodigoCliente(rs.getString("CODIGO_CLIENTE"));
									datosProblema.setSitio(rs.getString("SITIO"));
									datosProblema.setIdCaso(rs.getString("ID_CASO"));
									datosProblema.setFechaCreacion(rs.getString("FECHA_CREACION"));
									datosProblema.setTelefono(rs.getString("TELEFONO"));
									datosProblema.setTipificacion(rs.getString("TIPIFICACION"));
									datosProblema.setOrigen(rs.getString("ORIGEN"));
									datosProblema.setEstado(rs.getString("ESTADO"));
									datosProblema.setPrioridad(rs.getString("PRIORIDAD"));
									datosProblema.setSeveridad(rs.getString("SEVERIDAD"));
									datosProblema.setFase(rs.getString("FASE"));
									datosProblema.setNroReporte(rs.getString("NRO_REPORTE"));
									datosProblema.setNroReclamo(rs.getString("NRO_RECLAMO"));
									datosProblema.setCondicion(rs.getString("CONDICION"));
									datosProblema.setCola(rs.getString("COLA"));
									datosProblema.setPropietario(rs.getString("PROPIETARIO"));
									datosProblema.setNombreAgente(rs.getString("NOMBRE_AGENTE"));
									datosProblema.setApellidoAgente(rs.getString("APELLIDO_AGENTE"));
									datosProblema.setResultado(rs.getString("RESULTADO"));
									datosProblema.setResolucion(rs.getString("RESOLUCION"));
									datosProblema.setBandeja(rs.getString("BANDEJA"));
									datosProblema.setTipoCode(rs.getString("TIPO_CODE"));
									datosProblema.setClaseCode(rs.getString("CLASE_CODE"));
									datosProblema.setSubClaseCode(rs.getString("SUBCLASE_CODE"));
									datosProblema.setServicio(rs.getString("SERVICIO"));
									datosProblema.setInconveniente(rs.getString("INCONVENIENTE"));
									datosProblema.setContrato(rs.getString("CONTRATO"));
									datosProblema.setPlano(rs.getString("PLANO"));
									datosProblema.setIdInteraccion(rs.getString("ID_INTERACCION"));
									datosProblema.setUsuarioAplicacion(rs.getString("USUARIO_APLICACION"));
									datosProblema.setPlataforma(PropertiesInternos.STRING_EMPTY);
									datosProblema.setSentido(rs.getString("SENTIDO"));
									datosProblema.setMontoAjustado(rs.getString("MONTO_AJUSTADO"));
									return datosProblema;
								}
							}));

			String strPhone = PropertiesInternos.STRING_EMPTY;
			String srtService = PropertiesInternos.STRING_EMPTY;
			
			if (!objConsultarInteraccionCasosRequest.getTipoPlataforma().equals(Constantes.PLATAFORMA_IFI)) {
				strPhone = Constantes.IDENTIFICADOR_SGA + objConsultarInteraccionCasosRequest.getCodCliente();
				srtService = objConsultarInteraccionCasosRequest.getTelefono();
			} else {
				if (objConsultarInteraccionCasosRequest.getTecnologia().trim().equals(propiedadesExterna.tecnologiaDTH) 
						|| objConsultarInteraccionCasosRequest.getTecnologia().trim().equals(propiedadesExterna.tecnologiaIFI)) {
					strPhone = objConsultarInteraccionCasosRequest.getTelefono();
				} else {
					strPhone = Constantes.IDENTIFICADOR_FIJO + objConsultarInteraccionCasosRequest.getCustomerId();
				}
			}

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : " + this.propiedadesExterna.dbCLARIFYDBOwner.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.pckCaseClfyHfc).concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spQuery_case_hfc));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[ACCOUNT] = " + PropertiesInternos.STRING_EMPTY);
			logger.info(String.valueOf(mensajeLog) + "[TELEPHONE] = " + strPhone);
			logger.info(String.valueOf(mensajeLog) + "[CONTACT_OBJID1] = " + PropertiesInternos.STRING_EMPTY);
			logger.info(String.valueOf(mensajeLog) + "[TIPIFICACION] = " + PropertiesInternos.STRING_EMPTY);
			logger.info(String.valueOf(mensajeLog) + "[ESTADO] = " + PropertiesInternos.STRING_EMPTY);
			logger.info(String.valueOf(mensajeLog) + "[P_SERVICE] = " + srtService);
			logger.info(String.valueOf(mensajeLog) + "[P_TIPO_QUERY] = " + PropertiesInternos.STRING_EMPTY);
			logger.info(String.valueOf(mensajeLog) + "[P_FECHA_INICIO] = " + PropertiesInternos.STRING_EMPTY);
			logger.info(String.valueOf(mensajeLog) + "[P_FECHA_FIN] = " + PropertiesInternos.STRING_EMPTY);

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("ACCOUNT", PropertiesInternos.NULL)
					.addValue("TELEPHONE", strPhone)
					.addValue("CONTACT_OBJID1", PropertiesInternos.NULL)
					.addValue("TIPIFICACION", PropertiesInternos.NULL)
					.addValue("ESTADO", PropertiesInternos.NULL)
					.addValue("P_SERVICE", srtService)
					.addValue("P_TIPO_QUERY", PropertiesInternos.NULL)
					.addValue("P_FECHA_INICIO", PropertiesInternos.NULL)
					.addValue("P_FECHA_FIN", PropertiesInternos.NULL);

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_CLARIFY);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[P_FLAG_CONSULTA] = " + resultMap.get("P_FLAG_CONSULTA"));
			logger.info(String.valueOf(mensajeLog) + "[P_MSG_TEXT] = " + resultMap.get("P_MSG_TEXT"));

			ListaDatosProblema listaDatosProblema = new ListaDatosProblema();
			response.setCodRespuesta(Utilitarios.isNullOrBlankToString(resultMap.get("P_FLAG_CONSULTA")));
			
			listaDatosProblema.setListDatosProblema((List<DatosProblema>) Optional.ofNullable(resultMap.get("OUT_CURSOR")).orElse(Collections.emptyList()));
			
			logger.info(String.valueOf(mensajeLog) + "[Cantidad OUT_CURSOR] = " + listaDatosProblema.getListDatosProblema().size());

			String mensaje = PropertiesInternos.STRING_EMPTY;
			
			if (!listaDatosProblema.getListDatosProblema().isEmpty()) {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_VACIA);
				response.setListDatosProblema(listaDatosProblema);
				mensaje = Utilitarios.isNullOrBlankToString(resultMap.get("P_MSG_TEXT"));
			} else {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_VACIA);
				mensaje = Constantes.CURSOR_VACIO;
			}			
			response.setMsgRespuesta(mensaje);
		} catch (Exception e) {
			logger.error(String.valueOf(mensajeLog) + "Error en la ejecucion del SP : ", e);
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
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbCLARIFYDB).replace("$sp", propiedadesExterna.spQuery_interact_hfc).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

}
