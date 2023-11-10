package pe.com.claro.eai.ws.postventa.consultaclientecesws.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Cliente;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClienteRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClienteResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ListaCliente;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Tecnologia;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.dao.util.Utilitario;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.DBException;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Constantes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.JAXBUtilitarios;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.PropertiesInternos;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Utilitarios;

@Repository
public class Bscs9DaoImpl implements Bscs9Dao {

	private final static Logger logger = Logger.getLogger(Bscs9DaoImpl.class);

	@Autowired
	@Qualifier(value = "bscs9DS")
	private DataSource bscsDS;

	@Autowired
	Propiedades propiedadesExterna;

	@Override
	public ConsultarClienteResponse consultarCliente(String mensajeTransaccion, ConsultarClienteRequest objConsultarClienteRequest) throws DBException {
		String metodo = "consultarCliente";
		String mensajeLog = mensajeTransaccion + "[" + metodo + "]-";
		ConsultarClienteResponse response = new ConsultarClienteResponse();
		logger.info(mensajeLog + " == Inicio del metodo " + metodo);
		Connection conexion = null;
		try {
			
			logger.info(mensajeLog + "Consultando BD " + this.propiedadesExterna.dbBSCSDB9 + ", con JNDI = [" + this.propiedadesExterna.cJNDI_BSCS9 + "]");
			bscsDS.setLoginTimeout(this.propiedadesExterna.dbBscsDB9LoginTimeout);
			conexion = bscsDS.getConnection();
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(bscsDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.propiedadesExterna.dbBSCSDB9Owner)
					.withProcedureName(this.propiedadesExterna.pkg014SicesfConsultasBSCS9.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.bscs9SpSicessCustomerBSCS9))
					.declareParameters(
							new SqlParameter("PI_TIPO", OracleTypes.VARCHAR),
							new SqlParameter("PI_VALOR", OracleTypes.VARCHAR),
							
							new SqlOutParameter("PO_CURSOR", OracleTypes.CURSOR, new RowMapper<Cliente>() {
								public Cliente mapRow(ResultSet rs, int arg1) throws SQLException {
									Cliente cliente = new Cliente();
									cliente.setCustomerid(rs.getString("CUSTOMER_ID") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("CUSTOMER_ID"));
									cliente.setCuenta(rs.getString("CUSTCODE") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("CUSTCODE"));
									cliente.setCodCli(PropertiesInternos.STRING_EMPTY);
									cliente.setBillcycle(rs.getString("BILLCYCLE") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("BILLCYCLE"));
									cliente.setNomCli(rs.getString("NOMCLI") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("NOMCLI"));
									cliente.setCcname(rs.getString("CCNAME") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("CCNAME"));
									cliente.setNombres(rs.getString("NOMBRE") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("NOMBRE"));
									cliente.setApellidos(rs.getString("APELLIDO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("APELLIDO"));
									cliente.setTipoDoc(rs.getString("TIPODOC") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("TIPODOC"));
									cliente.setNumDoc(rs.getString("DOCUMENTO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("DOCUMENTO"));
									cliente.setTipoPersona(rs.getString("TIPOPERSONA") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("TIPOPERSONA"));
									cliente.setCategoria(PropertiesInternos.STRING_EMPTY);
									cliente.setDireccion(rs.getString("DIRECCION") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("DIRECCION"));
									cliente.setDistrito(rs.getString("DISTRITO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("DISTRITO"));
									cliente.setProvincia(rs.getString("PROVINCIA") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("PROVINCIA"));
									cliente.setDepartamento(rs.getString("DEPARTAMENTO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("DEPARTAMENTO"));
									cliente.setMail(rs.getString("MAIL") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("MAIL"));
									cliente.setTelefReferencia(rs.getString("TELEF_REFERENCIA") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("TELEF_REFERENCIA"));
									cliente.setEstadoCliente(rs.getString("ESTADOCLIENTE") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("ESTADOCLIENTE"));
									cliente.setCorrespElectronica(rs.getString("CORRESP_ELECTRONICA") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("CORRESP_ELECTRONICA"));
									cliente.setCodSuc(PropertiesInternos.STRING_EMPTY);
									cliente.setNumSlc(PropertiesInternos.STRING_EMPTY);
									return cliente;
								}
							}) ,new SqlOutParameter("PO_ERRNUM", OracleTypes.INTEGER),
							new SqlOutParameter("PO_ERRMSJ", OracleTypes.VARCHAR));

			logger.info(mensajeLog + "Se invocara el SP : " + this.propiedadesExterna.dbBSCSDB9Owner.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.pkg014SicesfConsultasBSCS9).concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.bscs9SpSicessCustomerBSCS9));
			logger.info(mensajeLog + "PARAMETROS [INPUT]: ");
			logger.info(mensajeLog + "[PI_TIPO] = " + objConsultarClienteRequest.getTipoBusqueda());
			logger.info(mensajeLog + "[PI_VALOR] = " + objConsultarClienteRequest.getValorBusqueda());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("PI_TIPO", objConsultarClienteRequest.getTipoBusqueda())
					.addValue("PI_VALOR", objConsultarClienteRequest.getValorBusqueda());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_BSCS9);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(mensajeLog + "PARAMETROS [OUTPUT]: ");
			logger.info(mensajeLog + "[PO_ERRNUM] = " + resultMap.get("PO_ERRNUM"));
			logger.info(mensajeLog + "[PO_ERRMSJ] = " + resultMap.get("PO_ERRMSJ"));

			ListaCliente listaCliente = new ListaCliente();
			response.setCodRespuesta(resultMap.get("PO_ERRNUM") != null ? resultMap.get("PO_ERRNUM").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaCliente.setListCliente((List<Cliente>) resultMap.get("PO_CURSOR"));
		
			logger.info(mensajeLog + "[Cantidad PO_CURSOR] = " + (listaCliente.getListCliente() != null ? listaCliente.getListCliente().size() : 0));

			String mensaje = PropertiesInternos.STRING_EMPTY;
			if (listaCliente.getListCliente() != null) {
				if (!listaCliente.getListCliente().isEmpty()) {
					logger.info(mensajeLog + Constantes.LISTA_NO_VACIA);
					response.setListCliente(listaCliente);
					mensaje = resultMap.get("PO_ERRMSJ") != null ? resultMap.get("PO_ERRMSJ").toString() : PropertiesInternos.STRING_EMPTY;
					logger.info(mensajeLog + "[SALIDA] = " 
							+ JAXBUtilitarios.anyObjectToXmlText(response));				
				} else {
					logger.info(mensajeLog + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("PO_ERRMSJ") != null ? resultMap.get("PO_ERRMSJ").toString() : PropertiesInternos.STRING_EMPTY;
			}
			response.setMsgRespuesta(mensaje);
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
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbBSCSDB9).replace("$sp", propiedadesExterna.bscs9SpSicessCustomerBSCS9).replace("$msg", error));
		} finally {
            try {
                Utilitario.close(mensajeLog, conexion);
            } catch (SQLException e) {
                logger.info(mensajeLog + "ERROR al cerrar la conexion: [Exception] - [" + e.getMessage() + "]", e);
            }
		}

		logger.info(mensajeLog + " == Fin del metodo " + metodo);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ConsultarTecnologiaResponse consultarTecnologia(String mensajeTransaccion,
			ConsultarTecnologiaRequest objConsultarTecnologiaRequest) throws DBException {
		String metodo = "consultarTecnologia";
		String mensajeLog = mensajeTransaccion + "[" + metodo + "]-";
		ConsultarTecnologiaResponse objResponse = new ConsultarTecnologiaResponse();
		logger.info(mensajeLog + " == Inicio del metodo " + metodo);
		
		List<Tecnologia> listaTecnologia = new ArrayList<>();
		Connection conexion = null;
		try {
			
			logger.info(mensajeLog + "Consultando BD " + propiedadesExterna.dbBSCSDB9 + ", con JNDI = [" + propiedadesExterna.cJNDI_BSCS9 + "]");
			bscsDS.setLoginTimeout(propiedadesExterna.dbBscsDB9LoginTimeout);
			conexion = bscsDS.getConnection();
			String outCursor = "PO_CURSOR";

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(bscsDS)
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(propiedadesExterna.dbBSCSDB9Owner)
					.withCatalogName(propiedadesExterna.pkg014SicesfConsultasBSCS9)
					.withProcedureName(propiedadesExterna.bscs9SpSicessTecnologia)
					.declareParameters(new SqlParameter("PI_DOCUMENTO", OracleTypes.VARCHAR),
							
							new SqlOutParameter(outCursor, OracleTypes.CURSOR, new RowMapper<Tecnologia>() {
								public Tecnologia mapRow(ResultSet rs, int arg1) throws SQLException {
									Tecnologia objTecnologia = new Tecnologia();
									objTecnologia.setTecnologia(Utilitarios.isNullOrBlankToString(rs.getString("TECNOLOGIA")));
									objTecnologia.setCustomer_id(Utilitarios.isNullOrBlankToString(rs.getString("CUSTOMER_ID")));
									objTecnologia.setCo_id(Utilitarios.isNullOrBlankToString(rs.getString("CO_ID")));
									objTecnologia.setPlan(Utilitarios.isNullOrBlankToString(rs.getString("PLAN")));
									objTecnologia.setNumero(Utilitarios.isNullOrBlankToString(rs.getString("NUMERO")));
									objTecnologia.setNro_pago(Utilitarios.isNullOrBlankToString(rs.getString("NRO_PAGO")));
									objTecnologia.setDistrito(Utilitarios.isNullOrBlankToString(rs.getString("DISTRITO")));
									objTecnologia.setDireccion(Utilitarios.isNullOrBlankToString(rs.getString("DIRECCION")));
									objTecnologia.setEstado(Utilitarios.isNullOrBlankToString(rs.getString("ESTADO")));
									objTecnologia.setMotivo_estado(Utilitarios.isNullOrBlankToString(rs.getString("MOTIVO_ESTADO")));
									objTecnologia.setValido_desde(Utilitarios.isNullOrBlankToString(rs.getString("VALIDO_DESDE")));
									return objTecnologia;
								}
							}),new SqlOutParameter("PO_ERRNUM", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_ERRMSJ", OracleTypes.VARCHAR));

			logger.info(mensajeLog + "Se invocara el SP : " + this.propiedadesExterna.dbBSCSDB9Owner.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.pkg014SicesfConsultasBSCS9).concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.bscs9SpSicessTecnologia));
			logger.info(mensajeLog + "PARAMETROS [INPUT]: ");
			logger.info(mensajeLog + "[PI_DOCUMENTO] = " + objConsultarTecnologiaRequest.getPi_documento());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("PI_DOCUMENTO", objConsultarTecnologiaRequest.getPi_documento());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_BSCS9);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);
			
			logger.info(mensajeLog + "PARAMETROS [OUTPUT]: ");
			logger.info(mensajeLog + "[PO_ERRNUM] = " + resultMap.get("PO_ERRNUM"));
			logger.info(mensajeLog + "[PO_ERRMSJ] = " + resultMap.get("PO_ERRMSJ"));
			
			listaTecnologia = (List<Tecnologia>) Optional.ofNullable(resultMap.get(outCursor)).orElse(Collections.emptyList());

			logger.info(mensajeLog + "[Cantidad "+ outCursor +"] = " + (listaTecnologia != null ? listaTecnologia.size() : 0));
			
			objResponse.setPo_sourceout(Utilitarios.isNullOrBlankToString(resultMap.get("PO_ERRNUM")));
			objResponse.setPo_message(Utilitarios.isNullOrBlankToString(resultMap.get("PO_ERRMSJ")));
			
			objResponse.setListaTecnologia(listaTecnologia);
			logger.info(mensajeLog + "[SALIDA] = " 
					+ JAXBUtilitarios.anyObjectToXmlText(objResponse));
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
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbBSCSDB).replace("$sp", propiedadesExterna.spSicess_tecnologia).replace("$msg", error));
		} finally {
            try {
                Utilitario.close(mensajeLog, conexion);
            } catch (SQLException e) {
                logger.info(mensajeLog + "ERROR al cerrar la conexion: [Exception] - [" + e.getMessage() + "]", e);
            }
		}
		return objResponse;
	}
	
}
