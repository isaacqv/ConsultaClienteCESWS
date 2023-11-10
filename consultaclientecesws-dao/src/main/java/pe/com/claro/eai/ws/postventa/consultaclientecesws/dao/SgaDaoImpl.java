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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.driver.OracleTypes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.*;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.dao.util.Utilitario;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.DBException;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.*;

@Repository
public class SgaDaoImpl implements SgaDao {

	private final static Logger logger = Logger.getLogger(SgaDaoImpl.class);

	@Autowired
	@Qualifier(value = "sgaDS")
	private DataSource sgaDS;

	@Autowired
	Propiedades propiedadesExterna;

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarClienteResponse consultarCliente(String mensajeTransaccion,
			ConsultarClienteRequest objConsultarClienteRequest) throws DBException {
		String metodo = "consultarCliente";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarClienteResponse response = new ConsultarClienteResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwner)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_customer))
					.declareParameters(new SqlParameter("PI_TIPOBUSQUEDA", OracleTypes.VARCHAR),
							new SqlParameter("PI_VALOR_BUSQUEDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CODIGO_SALIDA", OracleTypes.INTEGER),
							new SqlOutParameter("PO_MENSAJE_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CURSOR_CLIENTE", OracleTypes.CURSOR, new RowMapper<Cliente>() {
								public Cliente mapRow(ResultSet rs, int arg1) throws SQLException {
									Cliente cliente = new Cliente();
									cliente.setCustomerid(PropertiesInternos.STRING_EMPTY);
									cliente.setCuenta(PropertiesInternos.STRING_EMPTY);
									cliente.setCodCli(rs.getString("CODCLI") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("CODCLI"));
									cliente.setBillcycle(rs.getString("BILLCYCLE") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("BILLCYCLE"));
									cliente.setNomCli(rs.getString("NOMCLI") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("NOMCLI"));
									cliente.setCcname(PropertiesInternos.STRING_EMPTY);
									cliente.setNombres(PropertiesInternos.STRING_EMPTY);
									cliente.setApellidos(PropertiesInternos.STRING_EMPTY);
									cliente.setTipoDoc(rs.getString("TIPODOC") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("TIPODOC"));
									cliente.setNumDoc(rs.getString("DOCUMENTO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("DOCUMENTO"));
									cliente.setTipoPersona(rs.getString("TIPOPERSONA") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("TIPOPERSONA"));
									cliente.setCategoria(rs.getString("CATEGORIA") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("CATEGORIA"));
									cliente.setDireccion(rs.getString("DIRECCION") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("DIRECCION"));
									cliente.setDistrito(PropertiesInternos.STRING_EMPTY);
									cliente.setProvincia(PropertiesInternos.STRING_EMPTY);
									cliente.setDepartamento(PropertiesInternos.STRING_EMPTY);
									cliente.setMail(rs.getString("MAIL") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("MAIL"));
									cliente.setTelefReferencia(PropertiesInternos.STRING_EMPTY);
									cliente.setEstadoCliente(rs.getString("ESTADOCLIENTE") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("ESTADOCLIENTE"));
									cliente.setCorrespElectronica(rs.getString("CORRESP_ELECTRONICA") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("CORRESP_ELECTRONICA"));
									cliente.setCodSuc(rs.getString("CODSUC") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("CODSUC"));
									cliente.setNumSlc(rs.getString("NUMSLC") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("NUMSLC"));
									return cliente;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_customer));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PI_TIPOBUSQUEDA] = " + objConsultarClienteRequest.getTipoBusqueda());
			logger.info(String.valueOf(mensajeLog) + "[PI_VALOR_BUSQUEDA] = " + objConsultarClienteRequest.getValorBusqueda());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("PI_TIPOBUSQUEDA", objConsultarClienteRequest.getTipoBusqueda())
					.addValue("PI_VALOR_BUSQUEDA", objConsultarClienteRequest.getValorBusqueda());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PO_CODIGO_SALIDA] = " + resultMap.get("PO_CODIGO_SALIDA"));
			logger.info(String.valueOf(mensajeLog) + "[PO_MENSAJE_SALIDA] = " + resultMap.get("PO_MENSAJE_SALIDA"));

			ListaCliente listaCliente = new ListaCliente();
			response.setCodRespuesta(resultMap.get("PO_CODIGO_SALIDA") != null
					? resultMap.get("PO_CODIGO_SALIDA").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaCliente.setListCliente((List<Cliente>) resultMap.get("PO_CURSOR_CLIENTE"));
			logger.info(String.valueOf(mensajeLog) + "[Cantidad PO_CURSOR_CLIENTE] = "
					+ (listaCliente.getListCliente() != null ? listaCliente.getListCliente().size() : 0));

			String mensaje;
			if (listaCliente.getListCliente() != null) {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_NULA);
				if (!listaCliente.getListCliente().isEmpty()) {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_VACIA);
					response.setListCliente(listaCliente);
					mensaje = resultMap.get("PO_MENSAJE_SALIDA") != null ? resultMap.get("PO_MENSAJE_SALIDA").toString()
							: PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("PO_MENSAJE_SALIDA") != null ? resultMap.get("PO_MENSAJE_SALIDA").toString()
						: PropertiesInternos.STRING_EMPTY;
			}
			response.setMsgRespuesta(mensaje);
		} catch (Exception e) {
			logger.error(String.valueOf(mensajeLog) + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError;
			String msjError;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_customer).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}
	@SuppressWarnings("unchecked")
	@Override
	public ConsultarDetalleSucursalResponse consultarDetalleSucursal(String mensajeTransaccion,
			ConsultarDetalleSucursalRequest objConsultarDetalleSucursalRequest) throws DBException {
		String metodo = "consultarDetalleSucursal";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarDetalleSucursalResponse objResponse = new ConsultarDetalleSucursalResponse();
		List<DetalleSucursal> listaDetalleSucursal = new ArrayList<>();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);
		try {
			String outCursor = "PO_CURSOR_SUCURSALES";
			
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = [" + this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS)
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(propiedadesExterna.dbSGADBOwner)
					.withCatalogName(propiedadesExterna.pkgSicesFailure)
					.withProcedureName(propiedadesExterna.spSicess_Subsidiarydet_All)
					.declareParameters(
							new SqlParameter("PI_CUSTOMER_ID", OracleTypes.FLOAT),
							new SqlOutParameter("PO_CODIGO_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_MENSAJE_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter(outCursor, OracleTypes.CURSOR, new RowMapper<DetalleSucursal>() {
								public DetalleSucursal mapRow(ResultSet rs, int arg1) throws SQLException {
									DetalleSucursal objDetSucursal = new DetalleSucursal();
									objDetSucursal.setTecnologia(Utilitarios.isNullOrBlankToString(rs.getString("TECNOLOGIA")));
									objDetSucursal.setCodcli(Utilitarios.isNullOrBlankToString(rs.getString("CODCLI")));
									objDetSucursal.setCodsuc(Utilitarios.isNullOrBlankToString(rs.getString("CODSUC")));
									objDetSucursal.setNumslc(Utilitarios.isNullOrBlankToString(rs.getString("NUMSLC")));
									objDetSucursal.setCodsolot(Utilitarios.isNullOrBlankToString(rs.getString("CODSOLOT")));
									objDetSucursal.setDireccion(Utilitarios.isNullOrBlankToString(rs.getString("DIRECCION")));
									objDetSucursal.setPlano(Utilitarios.isNullOrBlankToString(rs.getString("PLANO")));
									objDetSucursal.setUbigeo(Utilitarios.isNullOrBlankToString(rs.getString("UBIGEO")));
									objDetSucursal.setDepartamento(Utilitarios.isNullOrBlankToString(rs.getString("DEPARTAMENTO")));
									objDetSucursal.setProvincia(Utilitarios.isNullOrBlankToString(rs.getString("PROVINCIA")));
									objDetSucursal.setDistrito(Utilitarios.isNullOrBlankToString(rs.getString("DISTRITO")));
									objDetSucursal.setFlg_portable(Utilitarios.isNullOrBlankToString(rs.getString("FLG_PORTABLE")));
									objDetSucursal.setInternet(Utilitarios.isNullOrBlankToString(rs.getString("INTERNET")));
									objDetSucursal.setTelefonia(Utilitarios.isNullOrBlankToString(rs.getString("TELEFONIA")));
									objDetSucursal.setCable(Utilitarios.isNullOrBlankToString(rs.getString("CABLE")));
									objDetSucursal.setEstado(Utilitarios.isNullOrBlankToString(rs.getString("ESTADO")));
									objDetSucursal.setPlataforma(Utilitarios.isNullOrBlankToString(rs.getString("PLATAFORMA")));
									return objDetSucursal;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : " + this.propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_Subsidiarydet_All));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + objConsultarDetalleSucursalRequest.toString());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			
			SqlParameterSource paramatersIn = new BeanPropertySqlParameterSource(objConsultarDetalleSucursalRequest);
			
			Map<String, Object> resultMap = jdbcCall.execute(paramatersIn);

			listaDetalleSucursal = (List<DetalleSucursal>) Optional.ofNullable(resultMap.get(outCursor)).orElse(Collections.emptyList());

			objResponse.setPo_codigo_salida(Utilitarios.isNullOrBlankToString(resultMap.get("PO_CODIGO_SALIDA")));
			objResponse.setPo_mensaje_salida(Utilitarios.isNullOrBlankToString(resultMap.get("PO_MENSAJE_SALIDA")));
			objResponse.setListaDetalleSucursal(listaDetalleSucursal);
			
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + objResponse.toString());
		} catch (Exception e) {
			logger.error(String.valueOf(mensajeLog) + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_Subsidiarydet_All).replace("$msg", error));
		}
		return objResponse;
	}
	@SuppressWarnings("unchecked")
	@Override
	public ConsultarEstadoServiciosResponse consultarEstadoServicios(String mensajeTransaccion,
			ConsultarEstadoServiciosRequest objConsultarEstadoServiciosRequest) throws DBException {
		String metodo = "consultarEstadoServicios";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarEstadoServiciosResponse objResponse = new ConsultarEstadoServiciosResponse();
		List<EstadoServicio> listaEstadoServicio = new ArrayList<>();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			String outCursor = "PO_CURSOR";
			
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + propiedadesExterna.dbSGADB + ", con JNDI = [" + propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS)
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(propiedadesExterna.dbSGADBOwner)
					.withCatalogName(propiedadesExterna.pkgSicesFailure)
					.withProcedureName(propiedadesExterna.spSicess_FailbyLocation)
					.declareParameters(
							new SqlParameter("PI_V_PLANS", OracleTypes.VARCHAR),
							new SqlParameter("PI_INTERNET", OracleTypes.FLOAT),
							new SqlParameter("PI_CABLE", OracleTypes.FLOAT),
							new SqlParameter("PI_TELEPHONE", OracleTypes.FLOAT),
							new SqlOutParameter("PO_CODE_RESULT", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_MESSAGE_RESULT", OracleTypes.VARCHAR),
							new SqlOutParameter(outCursor, OracleTypes.CURSOR, new RowMapper<EstadoServicio>() {
								public EstadoServicio mapRow(ResultSet rs, int arg1) throws SQLException {
									EstadoServicio objServicio = new EstadoServicio();
									objServicio.setI_faspid(rs.getString("I_FASPID"));
									objServicio.setV_faspmessage(rs.getString("V_FASPMESSAGE"));
									objServicio.setV_seraffected(rs.getString("V_SERAFFECTED"));
									return objServicio;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : " + propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.spSicess_FailbyLocation));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + objConsultarEstadoServiciosRequest.toString());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			
			SqlParameterSource paramatersIn = new BeanPropertySqlParameterSource(objConsultarEstadoServiciosRequest);
			
			Map<String, Object> resultMap = jdbcCall.execute(paramatersIn);

			listaEstadoServicio = (List<EstadoServicio>) Optional.ofNullable(resultMap.get(outCursor)).orElse(Collections.emptyList());
			
			objResponse.setPo_code_result(Utilitarios.isNullOrBlankToString(resultMap.get("PO_CODE_RESULT")));
			objResponse.setPo_message_result(Utilitarios.isNullOrBlankToString(resultMap.get("PO_MESSAGE_RESULT")));
			objResponse.setListaEstadoServicio(listaEstadoServicio);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + objResponse.toString());
		} catch (Exception e) {
			logger.error(String.valueOf(mensajeLog) + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_FailbyLocation).replace("$msg", error));
		}
		return objResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarDetalleSucursalDTHResponse consultarDetalleSucursalDTH(String mensajeTransaccion,
			ConsultarDetalleSucursalDTHRequest objConsultarDetalleSucursalDthRequest) throws DBException {
		String metodo = "consultarDetalleSucursalDTH";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarDetalleSucursalDTHResponse objResponse = new ConsultarDetalleSucursalDTHResponse();
		List<DetalleSucursalDTH> listaDetalleSucursalDTH = new ArrayList<>();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			String outCursor = "PO_CURSOR_SUCURSALES";
			
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + propiedadesExterna.dbSGADB + ", con JNDI = [" + propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS)
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(propiedadesExterna.dbSGADBOwner)
					.withCatalogName(propiedadesExterna.pkgSicesFailure)
					.withProcedureName(propiedadesExterna.spSicess_Subsidiarydet_DTH)
					.declareParameters(
							new SqlParameter("PI_CO_ID", OracleTypes.FLOAT),
							new SqlOutParameter("PO_CODIGO_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_MENSAJE_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter(outCursor, OracleTypes.CURSOR, new RowMapper<DetalleSucursalDTH>() {
								public DetalleSucursalDTH mapRow(ResultSet rs, int arg1) throws SQLException {
									DetalleSucursalDTH objDetSucursalDTH = new DetalleSucursalDTH();
									objDetSucursalDTH.setCodcli(Utilitarios.isNullOrBlankToString(rs.getString("CODCLI")));
									objDetSucursalDTH.setCodsuc(Utilitarios.isNullOrBlankToString(rs.getString("CODSUC")));
									objDetSucursalDTH.setNumslc(Utilitarios.isNullOrBlankToString(rs.getString("NUMSLC")));
									objDetSucursalDTH.setDireccion(Utilitarios.isNullOrBlankToString(rs.getString("DIRECCION")));
									objDetSucursalDTH.setCodsolot(Utilitarios.isNullOrBlankToString(rs.getString("CODSOLOT")));
									objDetSucursalDTH.setUbigeo(Utilitarios.isNullOrBlankToString(rs.getString("UBIGEO")));
									objDetSucursalDTH.setDepartamento(Utilitarios.isNullOrBlankToString(rs.getString("DEPARTAMENTO")));
									objDetSucursalDTH.setProvincia(Utilitarios.isNullOrBlankToString(rs.getString("PROVINCIA")));
									objDetSucursalDTH.setDistrito(Utilitarios.isNullOrBlankToString(rs.getString("DISTRITO")));
									objDetSucursalDTH.setInternet(Utilitarios.isNullOrBlankToString(rs.getString("INTERNET")));
									objDetSucursalDTH.setTelefonia(Utilitarios.isNullOrBlankToString(rs.getString("TELEFONIA")));
									objDetSucursalDTH.setCable(Utilitarios.isNullOrBlankToString(rs.getString("CABLE")));
									objDetSucursalDTH.setEstado(Utilitarios.isNullOrBlankToString(rs.getString("ESTADO")));
									objDetSucursalDTH.setPlataforma(Utilitarios.isNullOrBlankToString(rs.getString("PLATAFORMA")));
									return objDetSucursalDTH;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : " + propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.spSicess_Subsidiarydet_DTH));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + objConsultarDetalleSucursalDthRequest.toString());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			
			SqlParameterSource paramatersIn = new BeanPropertySqlParameterSource(objConsultarDetalleSucursalDthRequest);
			
			Map<String, Object> resultMap = jdbcCall.execute(paramatersIn);

			listaDetalleSucursalDTH = (List<DetalleSucursalDTH>) Optional.ofNullable(resultMap.get(outCursor)).orElse(Collections.emptyList());
			
			objResponse.setPo_codigo_salida(Utilitarios.isNullOrBlankToString(resultMap.get("PO_CODIGO_SALIDA")));
			objResponse.setPo_mensaje_salida(Utilitarios.isNullOrBlankToString(resultMap.get("PO_MENSAJE_SALIDA")));
			objResponse.setListaDetalleSucursalDTH(listaDetalleSucursalDTH);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + objResponse.toString());
		} catch (Exception e) {
			logger.error(String.valueOf(mensajeLog) + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_Subsidiarydet_DTH).replace("$msg", error));
		}

		return objResponse;
	}
	@Override
	public ConsultarJanusResponse consultarJanus(String mensajeTransaccion,
			ConsultarJanusRequest objConsultarJanusRequest) throws DBException {
		String metodo = "consultarJanus";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarJanusResponse response = new ConsultarJanusResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.propiedadesExterna.dbSGADBOwnerOperacion)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_Janus))
					.declareParameters(new SqlParameter("pi_v_sucursal", OracleTypes.VARCHAR),
							new SqlParameter("pi_gepacode", OracleTypes.VARCHAR),
							new SqlParameter("pi_gepavalue", OracleTypes.INTEGER),
							new SqlOutParameter("po_code_result", OracleTypes.INTEGER),
							new SqlOutParameter("po_message_result", OracleTypes.VARCHAR),
							new SqlOutParameter("po_cursor", OracleTypes.CURSOR, new RowMapper<Janus>() {
								public Janus mapRow(ResultSet rs, int arg1) throws SQLException {
									Janus janus = new Janus();
									janus.setNumero(rs.getString("NUMERO") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("NUMERO"));
									janus.setCustomerid(rs.getString("CUSTOMER_ID") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("CUSTOMER_ID"));
									janus.setCodPlan(rs.getString("CODPLAN") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("CODPLAN"));
									janus.setProducto(rs.getString("PRODUCTO") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("PRODUCTO"));
									janus.setTipoPlan(rs.getString("TIPOPLAN") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("TIPOPLAN"));
									janus.setFecIni(rs.getString("FECINI") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("FECINI"));
									janus.setFlgEstado(rs.getString("FLG_ESTADO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("FLG_ESTADO"));
									janus.setEstado(rs.getString("ESTADO") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("ESTADO"));
									janus.setCiclo(rs.getString("CICLO") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("CICLO"));
									return janus;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwnerOperacion.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_Janus));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[pi_v_sucursal] = " + objConsultarJanusRequest.getSucursal());
			logger.info(String.valueOf(mensajeLog) + "[pi_gepacode] = " + propiedadesExterna.janusGepaCode);
			logger.info(String.valueOf(mensajeLog) + "[pi_gepavalue] = " + propiedadesExterna.janusGepaValue);

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("pi_v_sucursal", objConsultarJanusRequest.getSucursal())
					.addValue("pi_gepacode", propiedadesExterna.janusGepaCode)
					.addValue("pi_gepavalue", propiedadesExterna.janusGepaValue);

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[po_code_result] = " + resultMap.get("po_code_result"));
			logger.info(String.valueOf(mensajeLog) + "[po_message_result] = " + resultMap.get("po_message_result"));

			ListaJanus listaJanus = new ListaJanus();
			response.setCodRespuesta(resultMap.get("po_code_result") != null
					? resultMap.get("po_code_result").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaJanus.setListJanus((List<Janus>) resultMap.get("po_cursor"));
			logger.info(String.valueOf(mensajeLog) + "[Cantidad po_cursor] = "
					+ (listaJanus.getListJanus() != null ? listaJanus.getListJanus().size() : 0));

			String mensaje = PropertiesInternos.STRING_EMPTY;
			if (listaJanus.getListJanus() != null) {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_NULA);
				if (!listaJanus.getListJanus().isEmpty()) {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_VACIA);
					response.setListJanus(listaJanus);
					mensaje = resultMap.get("po_message_result") != null ? resultMap.get("po_message_result").toString()
							: PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("po_message_result") != null ? resultMap.get("po_message_result").toString()
						: PropertiesInternos.STRING_EMPTY;
			}
			response.setMsgRespuesta(mensaje);
		} catch (Exception e) {
			logger.error(String.valueOf(mensajeLog) + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_Janus).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@Override
	public RegistrarAuditoriaResponse registrarAuditoria(String mensajeTransaccion,
			RegistrarAuditoriaRequest objRegistrarAuditoriaRequest) throws DBException {
		String metodo = "registrarAuditoria";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		RegistrarAuditoriaResponse response = new RegistrarAuditoriaResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwner)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_Auditoria))
					.declareParameters(new SqlParameter("pi_userapplication", OracleTypes.VARCHAR),
							new SqlParameter("pi_usersession", OracleTypes.VARCHAR),
							new SqlParameter("pi_idesbtransaction", OracleTypes.VARCHAR),
							new SqlOutParameter("po_output_code", OracleTypes.INTEGER),
							new SqlOutParameter("po_output_message", OracleTypes.VARCHAR));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_Auditoria));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[pi_userapplication] = " + objRegistrarAuditoriaRequest.getUserApplication());
			logger.info(String.valueOf(mensajeLog) + "[pi_usersession] = " + objRegistrarAuditoriaRequest.getUserSession());
			logger.info(String.valueOf(mensajeLog) + "[pi_idesbtransaction] = " + objRegistrarAuditoriaRequest.getIdESBTransaction());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("pi_userapplication", objRegistrarAuditoriaRequest.getUserApplication())
					.addValue("pi_usersession", objRegistrarAuditoriaRequest.getUserSession())
					.addValue("pi_idesbtransaction", objRegistrarAuditoriaRequest.getIdESBTransaction());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[po_output_code] = " + resultMap.get("po_output_code"));
			logger.info(String.valueOf(mensajeLog) + "[po_output_message] = " + resultMap.get("po_output_message"));

			response.setCodRespuesta(resultMap.get("po_output_code") != null
					? resultMap.get("po_output_code").toString() : PropertiesInternos.STRING_EMPTY);
			response.setMsgRespuesta(resultMap.get("po_output_message") != null
					? resultMap.get("po_output_message").toString() : PropertiesInternos.STRING_EMPTY);
		} catch (Exception e) {
			logger.error(String.valueOf(mensajeLog) + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_Auditoria).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@Override
	public ConsultarServicioResponse consultarServicio(String mensajeTransaccion,
			ConsultarServicioRequest objConsultarServicioRequest) throws DBException {
		String metodo = "consultarServicio";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarServicioResponse response = new ConsultarServicioResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwner)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_servicesga))
					.declareParameters(new SqlParameter("PI_COD_SUCURSAL", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CODIGO_SALIDA", OracleTypes.INTEGER),
							new SqlOutParameter("PO_MENSAJE_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CURSOR_SERVICIO", OracleTypes.CURSOR, new RowMapper<Servicio>() {
								public Servicio mapRow(ResultSet rs, int arg1) throws SQLException {
									Servicio servicio = new Servicio();
									servicio.setServicio(rs.getString("SERVICIO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("SERVICIO"));
									servicio.setEstado(rs.getString("ESTADO") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("ESTADO"));
									servicio.setTipoServicio(rs.getString("TIPO_SERVICIO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("TIPO_SERVICIO"));
									servicio.setCodBloqueo(rs.getString("COD_BLOQUEO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("COD_BLOQUEO"));
									servicio.setBloqueo(rs.getString("BLOQUEO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("BLOQUEO"));
									return servicio;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_customer));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PI_COD_SUCURSAL] = " + objConsultarServicioRequest.getCod_sucursal());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource().addValue("PI_COD_SUCURSAL",
					objConsultarServicioRequest.getCod_sucursal());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PO_CODIGO_SALIDA] = " + resultMap.get("PO_CODIGO_SALIDA"));
			logger.info(String.valueOf(mensajeLog) + "[PO_MENSAJE_SALIDA] = " + resultMap.get("PO_MENSAJE_SALIDA"));

			ListaServicio listaServicio = new ListaServicio();
			response.setCodRespuesta(resultMap.get("PO_CODIGO_SALIDA") != null
					? resultMap.get("PO_CODIGO_SALIDA").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaServicio.setListServicio((List<Servicio>) resultMap.get("PO_CURSOR_SERVICIO"));
			logger.info(String.valueOf(mensajeLog) + "[Cantidad PO_CURSOR_SERVICIO] = "
					+ (listaServicio.getListServicio() != null ? listaServicio.getListServicio().size() : 0));

			String mensaje = PropertiesInternos.STRING_EMPTY;
			if (listaServicio.getListServicio() != null) {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_NULA);
				if (!listaServicio.getListServicio().isEmpty()) {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_VACIA);
					response.setListServicio(listaServicio);
					mensaje = resultMap.get("PO_MENSAJE_SALIDA") != null ? resultMap.get("PO_MENSAJE_SALIDA").toString()
							: PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("PO_MENSAJE_SALIDA") != null ? resultMap.get("PO_MENSAJE_SALIDA").toString()
						: PropertiesInternos.STRING_EMPTY;
			}
			response.setMsgRespuesta(mensaje);
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_servicesga).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@Override
	public ConsultarSeaChangeResponse consultarSeaChange(String mensajeTransaccion,
			ConsultarSeaChangeRequest objConsultarSeaChangeRequest) throws DBException {
		String metodo = "consultarSeaChange";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarSeaChangeResponse response = new ConsultarSeaChangeResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwner)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_seaChange))
					.declareParameters(new SqlParameter("pi_client_id", OracleTypes.VARCHAR),
							new SqlParameter("pi_platform", OracleTypes.VARCHAR),
							new SqlOutParameter("po_output_code", OracleTypes.INTEGER),
							new SqlOutParameter("po_output_message", OracleTypes.VARCHAR),
							new SqlOutParameter("po_output_cursor", OracleTypes.CURSOR, new RowMapper<SeaChange>() {
								public SeaChange mapRow(ResultSet rs, int arg1) throws SQLException {
									SeaChange seaChange = new SeaChange();
									seaChange.setClientId(rs.getString("CLIENT_ID") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("CLIENT_ID"));
									seaChange.setCredit(rs.getString("CREDIT") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("CREDIT"));
									seaChange.setMac(rs.getString("MAC") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("MAC"));
									seaChange.setSerialNumber(rs.getString("SERIAL_NUMBER") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("SERIAL_NUMBER"));
									seaChange.setLoadDate(rs.getString("LOAD_DATE") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("LOAD_DATE"));
									seaChange.setPlatformType(rs.getString("PLATFORM_TYPE") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("PLATFORM_TYPE"));
									return seaChange;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_seaChange));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[pi_client_id] = " + objConsultarSeaChangeRequest.getClientId());
			logger.info(String.valueOf(mensajeLog) + "[pi_platform] = " + objConsultarSeaChangeRequest.getPlatform());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("pi_client_id", objConsultarSeaChangeRequest.getClientId())
					.addValue("pi_platform", objConsultarSeaChangeRequest.getPlatform());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[po_output_code] = " + resultMap.get("po_output_code"));
			logger.info(String.valueOf(mensajeLog) + "[po_output_message] = " + resultMap.get("po_output_message"));

			ListaSeaChange listaSeaChange = new ListaSeaChange();
			response.setCodRespuesta(resultMap.get("po_output_code") != null
					? resultMap.get("po_output_code").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaSeaChange.setListSeaChange((List<SeaChange>) resultMap.get("po_output_cursor"));
			logger.info(String.valueOf(mensajeLog) + "[Cantidad po_output_cursor] = "
					+ (listaSeaChange.getListSeaChange() != null ? listaSeaChange.getListSeaChange().size() : 0));

			String mensaje = PropertiesInternos.STRING_EMPTY;
			if (listaSeaChange.getListSeaChange() != null) {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_NULA);
				if (!listaSeaChange.getListSeaChange().isEmpty()) {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_VACIA);
					response.setListSeaChange(listaSeaChange);
					mensaje = resultMap.get("po_output_message") != null ? resultMap.get("po_output_message").toString()
							: PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("po_output_message") != null ? resultMap.get("po_output_message").toString()
						: PropertiesInternos.STRING_EMPTY;
			}
			response.setMsgRespuesta(mensaje);
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_seaChange).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarInteraccionCasosResponse consultarSot(String mensajeTransaccion,
			ConsultarInteraccionCasosRequest objConsultarInteraccionCasosRequest) throws DBException {
		String metodo = "consultarSot";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarInteraccionCasosResponse response = new ConsultarInteraccionCasosResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["	+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS)
					.withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.propiedadesExterna.dbSGADBOwner)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_Solot_Cliente))
					.declareParameters(
							new SqlParameter("PI_TECNOLOGIA", OracleTypes.VARCHAR),
							new SqlParameter("PI_CUSTOMER_ID", OracleTypes.VARCHAR),
							new SqlParameter("PI_CODSUC", OracleTypes.VARCHAR),
							new SqlParameter("PI_SERVICE", OracleTypes.VARCHAR),
							new SqlParameter("PI_CODCLI", OracleTypes.VARCHAR),
							new SqlParameter("PI_PLATAFORMA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CODIGO_SALIDA", OracleTypes.INTEGER),
							new SqlOutParameter("PO_MENSAJE_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CURSOR_SOTS", OracleTypes.CURSOR, new RowMapper<DatosSot>() {
								public DatosSot mapRow(ResultSet rs, int arg1) throws SQLException {
									DatosSot datosSot = new DatosSot();
									datosSot.setFecRegistro(rs.getString("FECHA_REGISTRO"));
									datosSot.setUsuRegistro(rs.getString("USUARIO_REGISTRO"));
									datosSot.setCodSolot(rs.getString("CODSOLOT"));
									datosSot.setCodTipoTrabajo(rs.getString("TIPTRA"));
									datosSot.setTipoTrabajo(rs.getString("TIPO_TRABAJO"));
									datosSot.setCliente(rs.getString("CLIENTE"));
									datosSot.setCodMotivo(rs.getString("CODMOTOT"));
									datosSot.setMotivo(rs.getString("MOTIVO"));
									datosSot.setEstadoSot(rs.getString("ESTADO_SOT"));
									datosSot.setCodId(rs.getString("COD_ID"));
									datosSot.setFecAgendamiento(rs.getString("FECHA_AGENDAMIENTO"));
									datosSot.setEstadoAgenda(rs.getString("ESTADO_AGENDA"));
									datosSot.setObservacion(rs.getString("OBSERVACION"));
									return datosSot;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : " + this.propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_Solot_Cliente));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PI_TECNOLOGIA] = " + objConsultarInteraccionCasosRequest.getTecnologia());
			logger.info(String.valueOf(mensajeLog) + "[PI_CUSTOMER_ID] = " + objConsultarInteraccionCasosRequest.getCustomerId());
			logger.info(String.valueOf(mensajeLog) + "[PI_CODSUC] = " + objConsultarInteraccionCasosRequest.getCodSucursal());
			logger.info(String.valueOf(mensajeLog) + "[PI_SERVICE] = " + objConsultarInteraccionCasosRequest.getTelefono());
			logger.info(String.valueOf(mensajeLog) + "[PI_CODCLI] = " + objConsultarInteraccionCasosRequest.getCodCliente());
			logger.info(String.valueOf(mensajeLog) + "[PI_PLATAFORMA] = " + objConsultarInteraccionCasosRequest.getTipoPlataforma());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("PI_TECNOLOGIA", objConsultarInteraccionCasosRequest.getTecnologia())
					.addValue("PI_CUSTOMER_ID", objConsultarInteraccionCasosRequest.getCustomerId())
					.addValue("PI_CODSUC", objConsultarInteraccionCasosRequest.getCodSucursal())
					.addValue("PI_SERVICE", objConsultarInteraccionCasosRequest.getTelefono())
					.addValue("PI_CODCLI", objConsultarInteraccionCasosRequest.getCodCliente())
					.addValue("PI_PLATAFORMA", objConsultarInteraccionCasosRequest.getTipoPlataforma());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PO_CODIGO_SALIDA] = " + resultMap.get("PO_CODIGO_SALIDA"));
			logger.info(String.valueOf(mensajeLog) + "[PO_MENSAJE_SALIDA] = " + resultMap.get("PO_MENSAJE_SALIDA"));

			ListaDatosSot listaDatosSot = new ListaDatosSot();
			response.setCodRespuesta(resultMap.get("PO_CODIGO_SALIDA").toString());
			
			listaDatosSot.setListDatosSot((List<DatosSot>) Optional.ofNullable(resultMap.get("PO_CURSOR_SOTS")).orElse(Collections.emptyList()));
			
			logger.info(String.valueOf(mensajeLog) + "[Cantidad PO_CURSOR_SOTS] = " + listaDatosSot.getListDatosSot().size());

			String mensaje = PropertiesInternos.STRING_EMPTY;
			
			if (!listaDatosSot.getListDatosSot().isEmpty()) {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_VACIA);
				response.setListDatosSot(listaDatosSot);
				mensaje = resultMap.get("PO_MENSAJE_SALIDA").toString();
			} else {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_VACIA);
				mensaje = Constantes.CURSOR_VACIO;
			}
			
			response.setMsgRespuesta(mensaje);

		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_Solot_Cliente).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarInteraccionCasosResponse consultarIncidencia(String mensajeTransaccion,
			ConsultarInteraccionCasosRequest objConsultarInteraccionCasosRequest) throws DBException {
		String metodo = "consultarIncidencia";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarInteraccionCasosResponse response = new ConsultarInteraccionCasosResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS)
					.withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.propiedadesExterna.dbSGADBOwnerAtccorp)
					.withProcedureName(this.propiedadesExterna.pkgRegistroReclamo.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_Incidencia))
					.declareParameters(
							new SqlParameter("PI_CODCLI", OracleTypes.VARCHAR),
							new SqlParameter("PI_SERVICE", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CURSOR", OracleTypes.CURSOR, new RowMapper<DatosIncidencia>() {
								public DatosIncidencia mapRow(ResultSet rs, int arg1) throws SQLException {
									DatosIncidencia datosIncidencia = new DatosIncidencia();
									datosIncidencia.setNroIncidencia(Utilitarios.isNullOrBlankToString(rs.getString("NRO_INCIDENCIA")));
									datosIncidencia.setCodigoSubCategoria(Utilitarios.isNullOrBlankToString(rs.getString("CODSUBTYPE")));
									datosIncidencia.setTipoIncidencia(Utilitarios.isNullOrBlankToString(rs.getString("TIPO_INCIDENCIA")));
									datosIncidencia.setClasificacionIncidencia(Utilitarios.isNullOrBlankToString(rs.getString("CLASIFICACION_INCIDENCIA")));
									datosIncidencia.setNroTicket(Utilitarios.isNullOrBlankToString(rs.getString("NRO_TICKET")));
									datosIncidencia.setFechaRegistro(Utilitarios.isNullOrBlankToString(rs.getString("FECHA_REGISTRO")));
									datosIncidencia.setCodigoCaso(Utilitarios.isNullOrBlankToString(rs.getString("CODCASE")));
									datosIncidencia.setTipoCaso(Utilitarios.isNullOrBlankToString(rs.getString("TIPO_CASO")));
									datosIncidencia.setEstado(Utilitarios.isNullOrBlankToString(rs.getString("ESTADO")));
									datosIncidencia.setNroServicio(Utilitarios.isNullOrBlankToString(rs.getString("NRO_SERVICIO")));
									datosIncidencia.setAreaRegistro(Utilitarios.isNullOrBlankToString(rs.getString("AREA_REGISTRO")));
									datosIncidencia.setUsuarioRegistro(Utilitarios.isNullOrBlankToString(rs.getString("USUARIO_REGISTRO")));
									datosIncidencia.setAreaUltimaDerivacion(Utilitarios.isNullOrBlankToString(rs.getString("AREA_ULTIMA_DERIVACION")));
									datosIncidencia.setUsuarioUltimaDerivacion(Utilitarios.isNullOrBlankToString(rs.getString("USUARIO_ULTIMA_DERIVACION")));
									datosIncidencia.setFechaUlitmaSecuencia(Utilitarios.isNullOrBlankToString(rs.getString("FECHA_ULTIMA_SECUENCIA")));
									datosIncidencia.setSolucion(Utilitarios.isNullOrBlankToString(rs.getString("SOLUCION")));
									datosIncidencia.setFamilia(Utilitarios.isNullOrBlankToString(rs.getString("FAMILIA")));
									return datosIncidencia;
								}
							}), 
							new SqlOutParameter("PO_CODERROR", OracleTypes.INTEGER),
							new SqlOutParameter("PO_DESCERROR", OracleTypes.VARCHAR));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : " + this.propiedadesExterna.dbSGADBOwnerAtccorp.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.pkgRegistroReclamo).concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_Incidencia));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PI_CODCLI] = " + objConsultarInteraccionCasosRequest.getCodCliente());
			logger.info(String.valueOf(mensajeLog) + "[PI_SERVICE] = " + objConsultarInteraccionCasosRequest.getTelefono());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("PI_CODCLI", objConsultarInteraccionCasosRequest.getCodCliente())
					.addValue("PI_SERVICE", objConsultarInteraccionCasosRequest.getTelefono());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PO_CODERROR] = " + resultMap.get("PO_CODERROR"));
			logger.info(String.valueOf(mensajeLog) + "[PO_DESCERROR] = " + resultMap.get("PO_DESCERROR"));

			ListaDatosIncidencia listaDatosIncidencia = new ListaDatosIncidencia();
			
			response.setCodRespuesta(resultMap.get("PO_CODERROR").toString());
			
			listaDatosIncidencia.setListDatosIncidencia((List<DatosIncidencia>) Optional.ofNullable(resultMap.get("PO_CURSOR")).orElse(Collections.emptyList()));
							
			logger.info(String.valueOf(mensajeLog) + "[Cantidad PO_CURSOR] = " + listaDatosIncidencia.getListDatosIncidencia().size());

			String mensaje = PropertiesInternos.STRING_EMPTY;
			
			if (!listaDatosIncidencia.getListDatosIncidencia().isEmpty()) {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_VACIA);
				response.setListDatosIncidencia(listaDatosIncidencia);
				mensaje = resultMap.get("PO_DESCERROR").toString();
			} else {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_VACIA);
				mensaje = Constantes.CURSOR_VACIO;
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
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB).replace("$sp", propiedadesExterna.spSicess_Incidencia).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@Override
	public ConsultarFallaResponse consultarFalla(String mensajeTransaccion,
			ConsultarFallaRequest objConsultarFallaRequest) throws DBException {
		String metodo = "consultarFalla";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarFallaResponse response = new ConsultarFallaResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwner)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_Falla))
					.declareParameters(new SqlParameter("pi_v_plan", OracleTypes.VARCHAR),
							new SqlParameter("pi_v_fail", OracleTypes.VARCHAR),
							new SqlOutParameter("po_code_result", OracleTypes.INTEGER),
							new SqlOutParameter("po_message_result", OracleTypes.VARCHAR),
							new SqlOutParameter("po_cursor", OracleTypes.CURSOR, new RowMapper<Falla>() {
								public Falla mapRow(ResultSet rs, int arg1) throws SQLException {
									Falla falla = new Falla();
									falla.setNumeroFalla(rs.getString("NUMERO_FALLA") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("NUMERO_FALLA"));
									falla.setDetalleProblema(rs.getString("DETALLE_PROBLEMA") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("DETALLE_PROBLEMA"));
									falla.setMotivo(rs.getString("MOTIVO") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("MOTIVO"));
									falla.setObservacion(rs.getString("OBSERVACION") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("OBSERVACION"));
									falla.setTiempoSolucion(rs.getString("TIEMPO_SOLUCION") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("TIEMPO_SOLUCION"));
									falla.setFechaInicio(rs.getString("FECHA_INICIO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("FECHA_INICIO"));
									return falla;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_Falla));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[pi_v_plan] = " + objConsultarFallaRequest.getPlano());
			logger.info(String.valueOf(mensajeLog) + "[pi_v_fail] = " + objConsultarFallaRequest.getTipo());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("pi_v_plan", objConsultarFallaRequest.getPlano())
					.addValue("pi_v_fail", objConsultarFallaRequest.getTipo());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[po_code_result] = " + resultMap.get("po_code_result"));
			logger.info(String.valueOf(mensajeLog) + "[po_message_result] = " + resultMap.get("po_message_result"));

			ListaFalla listaFalla = new ListaFalla();
			response.setCodRespuesta(resultMap.get("po_code_result") != null
					? resultMap.get("po_code_result").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaFalla.setListFalla((List<Falla>) resultMap.get("po_cursor"));
			logger.info(String.valueOf(mensajeLog) + "[Cantidad po_cursor] = "
					+ (listaFalla.getListFalla() != null ? listaFalla.getListFalla().size() : 0));

			String mensaje = PropertiesInternos.STRING_EMPTY;
			if (listaFalla.getListFalla() != null) {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_NULA);
				if (!listaFalla.getListFalla().isEmpty()) {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_VACIA);
					response.setListFalla(listaFalla);
					mensaje = resultMap.get("po_message_result") != null ? resultMap.get("po_message_result").toString()
							: PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("po_message_result") != null ? resultMap.get("po_message_result").toString()
						: PropertiesInternos.STRING_EMPTY;
			}
			response.setMsgRespuesta(mensaje);
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_Falla).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@Override
	public ConsultarEquipoResponse consultarEquipoInternet(String mensajeTransaccion,
			ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException {
		String metodo = "consultarEquipoInternet";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarEquipoResponse response = new ConsultarEquipoResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwnerIntraway)
					.withProcedureName(this.propiedadesExterna.pkgEquipo.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_EquipoInternet))
					.declareParameters(new SqlParameter("l_cliente", OracleTypes.VARCHAR),
							new SqlOutParameter("l_iderr", OracleTypes.NUMBER),
							new SqlOutParameter("l_mens", OracleTypes.VARCHAR),
							new SqlOutParameter("o_mensaje", OracleTypes.CURSOR, new RowMapper<Equipo>() {
								public Equipo mapRow(ResultSet rs, int arg1) throws SQLException {
									Equipo equipo = new Equipo();
									equipo.setHub(rs.getString("HUB") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("HUB"));
									equipo.setNodo(rs.getString("NODO") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("NODO"));
									equipo.setMacAddress(rs.getString("MACADDRESS") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("MACADDRESS"));
									equipo.setActivationCode(rs.getString("ACTIVATIONCODE") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("ACTIVATIONCODE"));
									equipo.setCantPcs(rs.getString("CANTPCS") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("CANTPCS"));
									equipo.setModel(rs.getString("SERVICEPACKAGENAME") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("SERVICEPACKAGENAME"));
									equipo.setSerialNumber(rs.getString("SERIALNUMBER") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("SERIALNUMBER"));
									equipo.setIdProducto(PropertiesInternos.STRING_EMPTY);
									equipo.setProfileCrmId(PropertiesInternos.STRING_EMPTY);
									equipo.setIdVenta(PropertiesInternos.STRING_EMPTY);
									equipo.setDisabled(PropertiesInternos.STRING_EMPTY);
									equipo.setServiceName(PropertiesInternos.STRING_EMPTY);
									equipo.setChannelMap(PropertiesInternos.STRING_EMPTY);
									equipo.setEquipmentCodeInc(PropertiesInternos.STRING_EMPTY);
									equipo.setIdentifier(PropertiesInternos.STRING_EMPTY);
									equipo.setModelCodeInc(PropertiesInternos.STRING_EMPTY);
									equipo.setDescModelInc(PropertiesInternos.STRING_EMPTY);
									equipo.setDescMarkInc(PropertiesInternos.STRING_EMPTY);
									equipo.setType(Constantes.EQUIPO_INTERNET);
									equipo.setCustomerId(objConsultarEquipoRequest.getCustomerId());
									return equipo;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwnerIntraway.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_EquipoInternet));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[l_cliente] = " + objConsultarEquipoRequest.getCustomerId());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource().addValue("l_cliente",
					objConsultarEquipoRequest.getCustomerId());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[l_iderr] = " + resultMap.get("l_iderr"));
			logger.info(String.valueOf(mensajeLog) + "[l_mens] = " + resultMap.get("l_mens"));

			response.setCodRespuesta(resultMap.get("l_iderr") != null ? resultMap.get("l_iderr").toString()
					: PropertiesInternos.STRING_EMPTY);
			response.setMsgRespuesta(resultMap.get("l_mens") != null ? resultMap.get("l_mens").toString()
					: PropertiesInternos.STRING_EMPTY);

			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF1CODIGO)) {
				@SuppressWarnings("unchecked")
				List<Equipo> listaEquipo = (List<Equipo>) resultMap.get("o_mensaje");
				response.setListEquipo(listaEquipo);
				logger.info(String.valueOf(mensajeLog) + "[Cantidad o_mensaje] = " + (listaEquipo != null ? listaEquipo.size() : 0));
			}
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_EquipoInternet).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@Override
	public ConsultarEquipoResponse consultarEquipoTelefonia(String mensajeTransaccion,
			ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException {
		String metodo = "consultarEquipoTelefonia";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarEquipoResponse response = new ConsultarEquipoResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwnerIntraway)
					.withProcedureName(this.propiedadesExterna.pkgEquipo.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_EquipoTelefonia))
					.declareParameters(new SqlParameter("l_cliente", OracleTypes.VARCHAR),
							new SqlOutParameter("l_iderr", OracleTypes.NUMBER),
							new SqlOutParameter("l_mens", OracleTypes.VARCHAR),
							new SqlOutParameter("o_mensaje", OracleTypes.CURSOR, new RowMapper<Equipo>() {
								public Equipo mapRow(ResultSet rs, int arg1) throws SQLException {
									Equipo equipo = new Equipo();
									equipo.setIdProducto(rs.getString("ID_PRODUCTO_PADRE") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("ID_PRODUCTO_PADRE"));
									equipo.setMacAddress(rs.getString("IDENTIFIER") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("IDENTIFIER"));
									equipo.setModel(rs.getString("EQUIPMENTYPEDESCRIPTION") == null
											? PropertiesInternos.STRING_EMPTY
											: rs.getString("EQUIPMENTYPEDESCRIPTION"));
									equipo.setProfileCrmId(rs.getString("PROFILECRMID") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("PROFILECRMID"));
									equipo.setHub(PropertiesInternos.STRING_EMPTY);
									equipo.setNodo(PropertiesInternos.STRING_EMPTY);
									equipo.setActivationCode(PropertiesInternos.STRING_EMPTY);
									equipo.setCantPcs(PropertiesInternos.STRING_EMPTY);
									equipo.setIdVenta(PropertiesInternos.STRING_EMPTY);
									equipo.setDisabled(PropertiesInternos.STRING_EMPTY);
									equipo.setServiceName(PropertiesInternos.STRING_EMPTY);
									equipo.setChannelMap(PropertiesInternos.STRING_EMPTY);
									equipo.setEquipmentCodeInc(PropertiesInternos.STRING_EMPTY);
									equipo.setIdentifier(PropertiesInternos.STRING_EMPTY);
									equipo.setModelCodeInc(PropertiesInternos.STRING_EMPTY);
									equipo.setDescModelInc(PropertiesInternos.STRING_EMPTY);
									equipo.setDescMarkInc(PropertiesInternos.STRING_EMPTY);
									equipo.setType(Constantes.EQUIPO_TELEFONIA);
									equipo.setCustomerId(objConsultarEquipoRequest.getCustomerId());
									equipo.setSerialNumber(PropertiesInternos.STRING_EMPTY);
									return equipo;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwnerIntraway.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_EquipoTelefonia));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[l_cliente] = " + objConsultarEquipoRequest.getCustomerId());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource().addValue("l_cliente",
					objConsultarEquipoRequest.getCustomerId());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[l_iderr] = " + resultMap.get("l_iderr"));
			logger.info(String.valueOf(mensajeLog) + "[l_mens] = " + resultMap.get("l_mens"));

			response.setCodRespuesta(resultMap.get("l_iderr") != null ? resultMap.get("l_iderr").toString()
					: PropertiesInternos.STRING_EMPTY);
			response.setMsgRespuesta(resultMap.get("l_mens") != null ? resultMap.get("l_mens").toString()
					: PropertiesInternos.STRING_EMPTY);

			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF1CODIGO)) {
				@SuppressWarnings("unchecked")
				List<Equipo> listaEquipo = (List<Equipo>) resultMap.get("o_mensaje");
				response.setListEquipo(listaEquipo);
				logger.info(String.valueOf(mensajeLog) + "[Cantidad o_mensaje] = " + (listaEquipo != null ? listaEquipo.size() : 0));
			}
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_EquipoTelefonia).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@Override
	public ConsultarEquipoResponse consultarEquipoCable(String mensajeTransaccion,
			ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException {
		String metodo = "consultarEquipoCable";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarEquipoResponse response = new ConsultarEquipoResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwnerIntraway)
					.withProcedureName(this.propiedadesExterna.pkgEquipo.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_EquipoCable))
					.declareParameters(new SqlParameter("l_cliente", OracleTypes.VARCHAR),
							new SqlOutParameter("l_iderr", OracleTypes.NUMBER),
							new SqlOutParameter("l_mens", OracleTypes.VARCHAR),
							new SqlOutParameter("o_mensaje", OracleTypes.CURSOR, new RowMapper<Equipo>() {
								public Equipo mapRow(ResultSet rs, int arg1) throws SQLException {
									Equipo equipo = new Equipo();
									equipo.setIdProducto(rs.getString("ID_PRODUCTO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("ID_PRODUCTO"));
									equipo.setIdVenta(rs.getString("ID_VENTA") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("ID_VENTA"));
									equipo.setActivationCode(rs.getString("ACTIVATIONCODE") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("ACTIVATIONCODE"));
									equipo.setSerialNumber(rs.getString("SERIALNUMBER") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("SERIALNUMBER"));
									equipo.setNodo(rs.getString("DTV_NODE") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("DTV_NODE"));
									equipo.setModel(rs.getString("STBTYPECRMID") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("STBTYPECRMID"));
									equipo.setDisabled(rs.getString("DISABLED") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("DISABLED"));
									equipo.setServiceName(rs.getString("SERVICENAME") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("SERVICENAME"));
									equipo.setChannelMap(rs.getString("DTV_CHANNEL_MAP") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("DTV_CHANNEL_MAP"));
									equipo.setHub(PropertiesInternos.STRING_EMPTY);
									equipo.setCantPcs(PropertiesInternos.STRING_EMPTY);
									equipo.setProfileCrmId(PropertiesInternos.STRING_EMPTY);
									equipo.setEquipmentCodeInc(PropertiesInternos.STRING_EMPTY);
									equipo.setIdentifier(PropertiesInternos.STRING_EMPTY);
									equipo.setModelCodeInc(PropertiesInternos.STRING_EMPTY);
									equipo.setDescModelInc(PropertiesInternos.STRING_EMPTY);
									equipo.setDescMarkInc(PropertiesInternos.STRING_EMPTY);
									equipo.setType(Constantes.EQUIPO_CABLE);
									equipo.setCustomerId(objConsultarEquipoRequest.getCustomerId());
									equipo.setMacAddress(PropertiesInternos.STRING_EMPTY);
									return equipo;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwnerIntraway.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_EquipoCable));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[l_cliente] = " + objConsultarEquipoRequest.getCustomerId());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource().addValue("l_cliente",
					objConsultarEquipoRequest.getCustomerId());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[l_iderr] = " + resultMap.get("l_iderr"));
			logger.info(String.valueOf(mensajeLog) + "[l_mens] = " + resultMap.get("l_mens"));

			response.setCodRespuesta(resultMap.get("l_iderr") != null ? resultMap.get("l_iderr").toString()
					: PropertiesInternos.STRING_EMPTY);
			response.setMsgRespuesta(resultMap.get("l_mens") != null ? resultMap.get("l_mens").toString()
					: PropertiesInternos.STRING_EMPTY);

			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF1CODIGO)) {
				@SuppressWarnings("unchecked")
				List<Equipo> listaEquipo = (List<Equipo>) resultMap.get("o_mensaje");
				response.setListEquipo(listaEquipo);
				logger.info(String.valueOf(mensajeLog) + "[Cantidad o_mensaje] = " + (listaEquipo != null ? listaEquipo.size() : 0));
			}
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_EquipoCable).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@Override
	public ConsultarEquipoResponse consultarEquipoComplemento(String mensajeTransaccion,
			ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException {
		String metodo = "consultarEquipoComplemento";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarEquipoResponse response = new ConsultarEquipoResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwnerIntraway)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_EquipoInc))
					.declareParameters(new SqlParameter("pi_desc_modelo", OracleTypes.VARCHAR),
							new SqlParameter("pi_mac_serial", OracleTypes.VARCHAR),
							new SqlOutParameter("po_codigo_salida", OracleTypes.INTEGER),
							new SqlOutParameter("po_mensaje_salida", OracleTypes.VARCHAR),
							new SqlOutParameter("po_cursor_equipo", OracleTypes.CURSOR, new RowMapper<Equipo>() {
								public Equipo mapRow(ResultSet rs, int arg1) throws SQLException {
									Equipo equipo = new Equipo();
									equipo.setEquipmentCodeInc(rs.getString("CODIGOEQUIPOINC") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("CODIGOEQUIPOINC"));
									equipo.setIdentifier(rs.getString("IDENTIFIER") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("IDENTIFIER"));
									equipo.setModelCodeInc(rs.getString("CODIGO_MODELO_INC") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("CODIGO_MODELO_INC"));
									equipo.setDescModelInc(rs.getString("DESC_MODELO_INC") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("DESC_MODELO_INC"));
									equipo.setDescMarkInc(rs.getString("DESC_MARCA_INC") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("DESC_MARCA_INC"));
									equipo.setParentId(rs.getString("PARENTID") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("PARENTID"));
									/*
									 * equipo.setType(PropertiesInternos.
									 * STRING_EMPTY);
									 * equipo.setCustomerId(PropertiesInternos.
									 * STRING_EMPTY);
									 * equipo.setModel(PropertiesInternos.
									 * STRING_EMPTY);
									 * equipo.setMacAddress(PropertiesInternos.
									 * STRING_EMPTY);
									 * equipo.setSerialNumber(PropertiesInternos
									 * .STRING_EMPTY);
									 * equipo.setHub(PropertiesInternos.
									 * STRING_EMPTY);
									 * equipo.setNodo(PropertiesInternos.
									 * STRING_EMPTY); equipo.setActivationCode(
									 * PropertiesInternos.STRING_EMPTY);
									 * equipo.setCantPcs(PropertiesInternos.
									 * STRING_EMPTY);
									 * equipo.setIdProducto(PropertiesInternos.
									 * STRING_EMPTY);
									 * equipo.setProfileCrmId(PropertiesInternos
									 * .STRING_EMPTY);
									 * equipo.setIdVenta(PropertiesInternos.
									 * STRING_EMPTY);
									 * equipo.setDisabled(PropertiesInternos.
									 * STRING_EMPTY);
									 * equipo.setServiceName(PropertiesInternos.
									 * STRING_EMPTY);
									 * equipo.setChannelMap(PropertiesInternos.
									 * STRING_EMPTY);
									 */
									return equipo;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwnerIntraway.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_EquipoInc));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[pi_desc_modelo] = " + objConsultarEquipoRequest.getModel());
			logger.info(String.valueOf(mensajeLog) + "[pi_mac_serial] = " + objConsultarEquipoRequest.getMacSerial());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("pi_desc_modelo", objConsultarEquipoRequest.getModel())
					.addValue("pi_mac_serial", objConsultarEquipoRequest.getMacSerial());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[po_codigo_salida] = " + resultMap.get("po_codigo_salida"));
			logger.info(String.valueOf(mensajeLog) + "[po_mensaje_salida] = " + resultMap.get("po_mensaje_salida"));

			response.setCodRespuesta(resultMap.get("po_codigo_salida") != null
					? resultMap.get("po_codigo_salida").toString() : PropertiesInternos.STRING_EMPTY);
			response.setMsgRespuesta(resultMap.get("po_mensaje_salida") != null
					? resultMap.get("po_mensaje_salida").toString() : PropertiesInternos.STRING_EMPTY);

			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO)) {
				@SuppressWarnings("unchecked")
				List<Equipo> listaEquipo = (List<Equipo>) resultMap.get("po_cursor_equipo");
				response.setListEquipo(listaEquipo);
				logger.info(
						mensajeLog + "[Cantidad po_cursor_equipo] = " + (listaEquipo != null ? listaEquipo.size() : 0));
			}
		} catch (Exception e) {
			logger.info(String.valueOf(mensajeLog) + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_EquipoInc).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarReglaResponse consultarRegla(String mensajeTransaccion,
			ConsultarReglaRequest objConsultarReglaRequest) throws DBException {

		String metodo = "consultarRegla";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarReglaResponse response = new ConsultarReglaResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.propiedadesExterna.dbSGADBOwnerOperacion)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_validateservice))
					.declareParameters(new SqlParameter("pi_customerid", OracleTypes.VARCHAR),
							new SqlParameter("pi_coid", OracleTypes.VARCHAR),
							new SqlParameter("pi_codsolot", OracleTypes.INTEGER),
							new SqlParameter("pi_telefono", OracleTypes.VARCHAR),
							new SqlParameter("pi_ciclooac", OracleTypes.VARCHAR),
							new SqlParameter("pi_rulers", OracleTypes.VARCHAR),
							new SqlOutParameter("po_code_result", OracleTypes.INTEGER),
							new SqlOutParameter("po_message_result", OracleTypes.VARCHAR),
							new SqlOutParameter("po_cursor_rulers", OracleTypes.CURSOR, new RowMapper<Regla>() {
								public Regla mapRow(ResultSet rs, int arg1) throws SQLException {
									Regla regla = new Regla();
									regla.setCodRegla(rs.getString("RULER") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("RULER"));
									regla.setCodRespuesta(rs.getString("RESULT") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("RESULT"));
									return regla;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwnerOperacion.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_validateservice));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[pi_customerid] = " + objConsultarReglaRequest.getCustomerId());
			logger.info(String.valueOf(mensajeLog) + "[pi_coid] = " + objConsultarReglaRequest.getCoId());
			logger.info(String.valueOf(mensajeLog) + "[pi_codsolot] = " + objConsultarReglaRequest.getCodSolot());
			logger.info(String.valueOf(mensajeLog) + "[pi_telefono] = " + objConsultarReglaRequest.getTelefono());
			logger.info(String.valueOf(mensajeLog) + "[pi_ciclooac] = " + objConsultarReglaRequest.getCicloOAC());
			logger.info(String.valueOf(mensajeLog) + "[pi_rulers] = " + objConsultarReglaRequest.getRulers());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("pi_customerid", objConsultarReglaRequest.getCustomerId())
					.addValue("pi_coid", objConsultarReglaRequest.getCoId())
					.addValue("pi_codsolot", objConsultarReglaRequest.getCodSolot())
					.addValue("pi_telefono", objConsultarReglaRequest.getTelefono())
					.addValue("pi_ciclooac", objConsultarReglaRequest.getCicloOAC())
					.addValue("pi_rulers", objConsultarReglaRequest.getRulers());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[po_code_result] = " + resultMap.get("po_code_result"));
			logger.info(String.valueOf(mensajeLog) + "[po_message_result] = " + resultMap.get("po_message_result"));

			ListaRegla listaRegla = new ListaRegla();
			response.setCodRespuesta(resultMap.get("po_code_result") != null
					? resultMap.get("po_code_result").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaRegla.setListRegla((List<Regla>) resultMap.get("po_cursor_rulers"));
			logger.info(String.valueOf(mensajeLog) + "[Cantidad po_cursor_rulers] = "
					+ (listaRegla.getListRegla() != null ? listaRegla.getListRegla().size() : 0));

			String mensaje = PropertiesInternos.STRING_EMPTY;
			if (listaRegla.getListRegla() != null) {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_NULA);
				if (!listaRegla.getListRegla().isEmpty()) {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_VACIA);
					response.setListRegla(listaRegla);
					mensaje = resultMap.get("po_message_result") != null ? resultMap.get("po_message_result").toString()
							: PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("po_message_result") != null ? resultMap.get("po_message_result").toString()
						: PropertiesInternos.STRING_EMPTY;
			}
			response.setMsgRespuesta(mensaje);
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_validateservice).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarReglaResponse consultarReglaComplemento(String mensajeTransaccion,
			ConsultarReglaRequest objConsultarReglaRequest) throws DBException {

		String metodo = "consultarReglaComplemento";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarReglaResponse response = new ConsultarReglaResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwnerIntraway)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_validateservice))
					.declareParameters(new SqlParameter("pi_customerid", OracleTypes.VARCHAR),
							new SqlParameter("pi_codsolot", OracleTypes.INTEGER),
							new SqlParameter("pi_telefono", OracleTypes.VARCHAR),
							new SqlParameter("pi_coid", OracleTypes.VARCHAR),
							new SqlParameter("pi_rulers", OracleTypes.VARCHAR),
							new SqlOutParameter("po_code_result", OracleTypes.INTEGER),
							new SqlOutParameter("po_message_result", OracleTypes.VARCHAR),
							new SqlOutParameter("po_cursor_rulers", OracleTypes.CURSOR, new RowMapper<Regla>() {
								public Regla mapRow(ResultSet rs, int arg1) throws SQLException {
									Regla regla = new Regla();
									regla.setCodRegla(rs.getString("RULER") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("RULER"));
									regla.setCodRespuesta(rs.getString("RESULT") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("RESULT"));
									return regla;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwnerIntraway.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_validateservice));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[pi_customerid] = " + objConsultarReglaRequest.getCustomerId());
			logger.info(String.valueOf(mensajeLog) + "[pi_codsolot] = " + objConsultarReglaRequest.getCodSolot());
			logger.info(String.valueOf(mensajeLog) + "[pi_telefono] = " + objConsultarReglaRequest.getTelefono());
			logger.info(String.valueOf(mensajeLog) + "[pi_coid] = " + objConsultarReglaRequest.getCoId());
			logger.info(String.valueOf(mensajeLog) + "[pi_rulers] = " + objConsultarReglaRequest.getRulers());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("pi_customerid", objConsultarReglaRequest.getCustomerId())
					.addValue("pi_codsolot", objConsultarReglaRequest.getCodSolot())
					.addValue("pi_telefono", objConsultarReglaRequest.getTelefono())
					.addValue("pi_coid", objConsultarReglaRequest.getCoId())
					.addValue("pi_rulers", objConsultarReglaRequest.getRulers());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[po_code_result] = " + resultMap.get("po_code_result"));
			logger.info(String.valueOf(mensajeLog) + "[po_message_result] = " + resultMap.get("po_message_result"));

			ListaRegla listaRegla = new ListaRegla();
			response.setCodRespuesta(resultMap.get("po_code_result") != null
					? resultMap.get("po_code_result").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaRegla.setListRegla((List<Regla>) resultMap.get("po_cursor_rulers"));
			logger.info(String.valueOf(mensajeLog) + "[Cantidad po_cursor_rulers] = "
					+ (listaRegla.getListRegla() != null ? listaRegla.getListRegla().size() : 0));

			String mensaje = PropertiesInternos.STRING_EMPTY;
			if (listaRegla.getListRegla() != null) {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_NULA);
				if (!listaRegla.getListRegla().isEmpty()) {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_VACIA);
					response.setListRegla(listaRegla);
					mensaje = resultMap.get("po_message_result") != null ? resultMap.get("po_message_result").toString()
							: PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("po_message_result") != null ? resultMap.get("po_message_result").toString()
						: PropertiesInternos.STRING_EMPTY;
			}
			response.setMsgRespuesta(mensaje);
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_validateservice).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@Override
	public ReconectarNcosResponse reconectarNcos(String mensajeTransaccion,
			ReconectarNcosRequest objReconectarNcosRequest) throws DBException {
		String metodo = "reconectarNcos";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ReconectarNcosResponse response = new ReconectarNcosResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwnerIntraway)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_reconect_ncos_inc))
					.declareParameters(new SqlParameter("PI_CUSTOMERID", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CALL_BARRING_TYPE", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CODIGO_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_MENSAJE_SALIDA", OracleTypes.VARCHAR));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwnerIntraway.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_reconect_ncos_inc));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PI_CUSTOMERID] = " + objReconectarNcosRequest.getCustomerId());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource().addValue("PI_CUSTOMERID",
					objReconectarNcosRequest.getCustomerId());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PO_CALL_BARRING_TYPE] = " + resultMap.get("PO_CALL_BARRING_TYPE"));
			logger.info(String.valueOf(mensajeLog) + "[PO_CODIGO_SALIDA] = " + resultMap.get("PO_CODIGO_SALIDA"));
			logger.info(String.valueOf(mensajeLog) + "[PO_MENSAJE_SALIDA] = " + resultMap.get("PO_MENSAJE_SALIDA"));

			response.setCallBarringType(resultMap.get("PO_CALL_BARRING_TYPE") != null
					? resultMap.get("PO_CALL_BARRING_TYPE").toString() : PropertiesInternos.STRING_EMPTY);
			response.setCodRespuesta(resultMap.get("PO_CODIGO_SALIDA") != null
					? resultMap.get("PO_CODIGO_SALIDA").toString() : PropertiesInternos.STRING_EMPTY);
			response.setMsgRespuesta(resultMap.get("PO_MENSAJE_SALIDA") != null
					? resultMap.get("PO_MENSAJE_SALIDA").toString() : PropertiesInternos.STRING_EMPTY);

		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_validateservice).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@Override
	public ConsultarEquipoResponse consultarEquipoLte(String mensajeTransaccion,
			ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException {
		String metodo = "consultarEquipoLteDth";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarEquipoResponse response = new ConsultarEquipoResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwner)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_EquipoLte))
					.declareParameters(new SqlParameter("PI_CODSOLOT", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CODIGO_SALIDA", OracleTypes.NUMBER),
							new SqlOutParameter("PO_MENSAJE_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CURSOR_EQUIPO", OracleTypes.CURSOR, new RowMapper<Equipo>() {
								public Equipo mapRow(ResultSet rs, int arg1) throws SQLException {
									Equipo equipo = new Equipo();
									equipo.setType(rs.getString("TYPE") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("TYPE"));
									equipo.setModel(rs.getString("MODEL") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("MODEL"));
									equipo.setSerialNumber(rs.getString("SERIALNUMBER") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("SERIALNUMBER"));
									equipo.setCardNumber(rs.getString("CARDNUMBER") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("CARDNUMBER"));
									equipo.setUaNumber(rs.getString("UANUMBER") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("UANUMBER"));
									return equipo;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicess_EquipoLte));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PI_CODSOLOT] = " + objConsultarEquipoRequest.getCodSolot());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource().addValue("PI_CODSOLOT",
					objConsultarEquipoRequest.getCodSolot());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PO_CODIGO_SALIDA] = " + resultMap.get("PO_CODIGO_SALIDA"));
			logger.info(String.valueOf(mensajeLog) + "[PO_MENSAJE_SALIDA] = " + resultMap.get("PO_MENSAJE_SALIDA"));

			response.setCodRespuesta(resultMap.get("PO_CODIGO_SALIDA") != null
					? resultMap.get("PO_CODIGO_SALIDA").toString() : PropertiesInternos.STRING_EMPTY);
			response.setMsgRespuesta(resultMap.get("PO_MENSAJE_SALIDA") != null
					? resultMap.get("PO_MENSAJE_SALIDA").toString() : PropertiesInternos.STRING_EMPTY);

			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO)) {
				@SuppressWarnings("unchecked")
				List<Equipo> listaEquipo = (List<Equipo>) resultMap.get("PO_CURSOR_EQUIPO");
				response.setListEquipo(listaEquipo);
				logger.info(String.valueOf(mensajeLog) + "[Cantidad o_mensaje] = " + (listaEquipo != null ? listaEquipo.size() : 0));
			}
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicess_EquipoLte).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@Override
	public ConsultarEquipoResponse consultarEquipoComplementoLTEDTH(String mensajeTransaccion,
			ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException {
		String metodo = "consultarEquipoComplementoLTEDTH";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarEquipoResponse response = new ConsultarEquipoResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwner)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicessEquipmentDth))
					.declareParameters(new SqlParameter("PI_IMEI_ESN_UA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CODIGO_SALIDA", OracleTypes.NUMBER),
							new SqlOutParameter("PO_MENSAJE_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CURSOR_EQUIPO", OracleTypes.CURSOR, new RowMapper<Equipo>() {
								public Equipo mapRow(ResultSet rs, int arg1) throws SQLException {
									Equipo equipo = new Equipo();
									equipo.setModel(rs.getString("MODEL") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("MODEL"));
									equipo.setSerialNumber(rs.getString("SERIALNUMBER") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("SERIALNUMBER"));
									return equipo;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicessEquipmentDth));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PI_IMEI_ESN_UA] = " + objConsultarEquipoRequest.getUaNumber());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource().addValue("PI_IMEI_ESN_UA",
					objConsultarEquipoRequest.getUaNumber());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PO_CODIGO_SALIDA] = " + resultMap.get("PO_CODIGO_SALIDA"));
			logger.info(String.valueOf(mensajeLog) + "[PO_MENSAJE_SALIDA] = " + resultMap.get("PO_MENSAJE_SALIDA"));

			response.setCodRespuesta(resultMap.get("PO_CODIGO_SALIDA") != null
					? resultMap.get("PO_CODIGO_SALIDA").toString() : PropertiesInternos.STRING_EMPTY);
			response.setMsgRespuesta(resultMap.get("PO_MENSAJE_SALIDA") != null
					? resultMap.get("PO_MENSAJE_SALIDA").toString() : PropertiesInternos.STRING_EMPTY);

			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO)) {
				@SuppressWarnings("unchecked")
				List<Equipo> listaEquipo = (List<Equipo>) resultMap.get("PO_CURSOR_EQUIPO");
				response.setListEquipo(listaEquipo);
				logger.info(String.valueOf(mensajeLog) + "[Cantidad o_mensaje] = " + (listaEquipo != null ? listaEquipo.size() : 0));
			}
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicessEquipmentDth).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarServicioSucursalResponse consultarServicioSucursal(String mensajeTransaccion,
			ConsultarServicioSucursalRequest ConsultarServicioSucursalRequest) throws DBException {
		String metodo = "consultarServicioSucursal";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarServicioSucursalResponse objResponse = new ConsultarServicioSucursalResponse();
		List<ServicioSucursal> listaServicioSucursal = new ArrayList<>();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			String outCursor = "PO_CURSOR_SERVICIO";
			
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + propiedadesExterna.dbSGADB + ", con JNDI = [" + propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS)
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(propiedadesExterna.dbSGADBOwner)
					.withCatalogName(propiedadesExterna.pkgSicesFailure)
					.withProcedureName(propiedadesExterna.spSicessServicePrinc)
					.declareParameters(
							new SqlParameter("PI_TECNOLOGIA", OracleTypes.VARCHAR),
							new SqlParameter("PI_CODSOLOT", OracleTypes.INTEGER),
							new SqlOutParameter("PO_CODIGO_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_MENSAJE_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter(outCursor, OracleTypes.CURSOR, new RowMapper<ServicioSucursal>() {
								public ServicioSucursal mapRow(ResultSet rs, int arg1) throws SQLException {
									ServicioSucursal objServicioSuc = new ServicioSucursal();
									objServicioSuc.setTipo_servicio(Utilitarios.isNullOrBlankToString(rs.getString("TIPO_SERVICIO")));
									objServicioSuc.setCodinssrv(Utilitarios.isNullOrBlankToString(rs.getString("CODINSSRV")));
									objServicioSuc.setNumero(Utilitarios.isNullOrBlankToString(rs.getString("NUMERO")));
									objServicioSuc.setServicio(Utilitarios.isNullOrBlankToString(rs.getString("SERVICIO")));
									objServicioSuc.setValido_desde(Utilitarios.isNullOrBlankToString(rs.getString("VALIDO_DESDE")));
									return objServicioSuc;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : " + propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.spSicessServicePrinc));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + ConsultarServicioSucursalRequest.toString());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			
			SqlParameterSource paramatersIn = new BeanPropertySqlParameterSource(ConsultarServicioSucursalRequest);
			
			Map<String, Object> resultMap = jdbcCall.execute(paramatersIn);
			
			listaServicioSucursal = (List<ServicioSucursal>) Optional.ofNullable(resultMap.get(outCursor)).orElse(Collections.emptyList());
			
			objResponse.setPo_codigo_salida(Utilitarios.isNullOrBlankToString(resultMap.get("PO_CODIGO_SALIDA")));
			objResponse.setPo_mensaje_salida(Utilitarios.isNullOrBlankToString(resultMap.get("PO_MENSAJE_SALIDA")));
			objResponse.setListaServicioSucursal(listaServicioSucursal);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + objResponse.toString());
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicessEquipmentDth).replace("$msg", error));
		}
		return objResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarClienteResponse consultarClienteComplemento(String mensajeTransaccion,
			ConsultarClienteRequest objConsultarClienteRequest) throws DBException {
		String metodo = "consultarClienteComplemento";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarClienteResponse response = new ConsultarClienteResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.propiedadesExterna.dbSGADBOwner)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailure.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicessDatosCliente))
					.declareParameters(new SqlParameter("PI_DOCUMENTO", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CURSOR", OracleTypes.CURSOR, new RowMapper<Cliente>() {
								public Cliente mapRow(ResultSet rs, int arg1) throws SQLException {
									Cliente cliente = new Cliente();
									cliente.setCodCli(rs.getString("CODCLI") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("CODCLI"));
									cliente.setCategoria(rs.getString("CATEGORIA") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("CATEGORIA"));
									return cliente;
								}
							}), new SqlOutParameter("PO_CODIGO_SALIDA", OracleTypes.INTEGER),
							new SqlOutParameter("PO_MENSAJE_SALIDA", OracleTypes.VARCHAR));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicessDatosCliente));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PI_DOCUMENTO] = " + objConsultarClienteRequest.getValorBusqueda());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource().addValue("PI_DOCUMENTO",
					objConsultarClienteRequest.getValorBusqueda());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PO_CODIGO_SALIDA] = " + resultMap.get("PO_CODIGO_SALIDA"));
			logger.info(String.valueOf(mensajeLog) + "[PO_MENSAJE_SALIDA] = " + resultMap.get("PO_MENSAJE_SALIDA"));

			ListaCliente listaCliente = new ListaCliente();
			response.setCodRespuesta(resultMap.get("PO_CODIGO_SALIDA") != null
					? resultMap.get("PO_CODIGO_SALIDA").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaCliente.setListCliente((List<Cliente>) resultMap.get("PO_CURSOR"));
			logger.info(String.valueOf(mensajeLog) + "[Cantidad PO_CURSOR] = "
					+ (listaCliente.getListCliente() != null ? listaCliente.getListCliente().size() : 0));

			String mensaje;
			if (listaCliente.getListCliente() != null) {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_NULA);
				if (!listaCliente.getListCliente().isEmpty()) {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_VACIA);
					response.setListCliente(listaCliente);
					mensaje = resultMap.get("PO_MENSAJE_SALIDA") != null ? resultMap.get("PO_MENSAJE_SALIDA").toString()
							: PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("PO_MENSAJE_SALIDA") != null ? resultMap.get("PO_MENSAJE_SALIDA").toString()
						: PropertiesInternos.STRING_EMPTY;
			}
			response.setMsgRespuesta(mensaje);
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError;
			String msjError;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicessDatosCliente).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@Override
	public String obtenerNumeroDocumento(String mensajeTransaccion, String strCodCli) throws DBException {

		String metodo = "obtenerNumeroDocumento";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		String strNumDoc = "";
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			JdbcTemplate jdbcTemplate = new JdbcTemplate(sgaDS);
			jdbcTemplate.setResultsMapCaseInsensitive(true);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
					.withSchemaName(this.propiedadesExterna.dbSGADBOwner)
					.withCatalogName(this.propiedadesExterna.pkgSicesFailure)
					.withFunctionName(this.propiedadesExterna.fnSiceFunDocumento);

			logger.info(String.valueOf(mensajeLog) + "Se invocara a la Funcion : "
					+ this.propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.fnSiceFunDocumento));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PI_CODCLI] = " + strCodCli);

			SqlParameterSource objParametrosIN = new MapSqlParameterSource().addValue("pi_codcli", strCodCli);

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			strNumDoc = jdbcCall.executeFunction(String.class, objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[RESULT] = " + strNumDoc);

		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError;
			String msjError;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.fnSiceFunDocumento).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return strNumDoc;
	}

	@Override
	public ConsultarClientePorNombreResponse consultarClientePorNombre(String mensajeTransaccion,
			ConsultarClientePorNombreRequest objConsultarClientePorNombreRequest) throws DBException {
		String metodo = "consultarClientePorNombre";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarClientePorNombreResponse response = new ConsultarClientePorNombreResponse();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withSchemaName(this.propiedadesExterna.dbSGADBOwner)
					.withCatalogName(this.propiedadesExterna.pkgSicesFailure)
					.withProcedureName(this.propiedadesExterna.spSicessCustomerRsNom)
					.declareParameters(new SqlOutParameter("PO_CURSOR_CLIENTE", OracleTypes.CURSOR,
							new RowMapper<ClientePorNombre>() {
								public ClientePorNombre mapRow(ResultSet rs, int arg1) throws SQLException {
									ClientePorNombre ClientePorNombre = new ClientePorNombre();
									ClientePorNombre.setNombres(rs.getString("NOMBRES") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("NOMBRES"));
									ClientePorNombre.setApellidos(rs.getString("APELLIDOS") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("APELLIDOS"));
									ClientePorNombre.setCcname(rs.getString("CCNAME") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("CCNAME"));
									ClientePorNombre.setTipoDoc(rs.getString("TIPODOC") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("TIPODOC"));
									ClientePorNombre.setNumDoc(rs.getString("DOCUMENTO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("DOCUMENTO"));
									return ClientePorNombre;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spSicessCustomerRsNom));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PI_TIPOBUSQUEDA] = " + objConsultarClientePorNombreRequest.getTipobusqueda());
			logger.info(
					mensajeLog + "[PI_VALOR_BUSQUEDA] = " + objConsultarClientePorNombreRequest.getValor_busqueda());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("PI_TIPOBUSQUEDA", objConsultarClientePorNombreRequest.getTipobusqueda())
					.addValue("PI_VALOR_BUSQUEDA", objConsultarClientePorNombreRequest.getValor_busqueda());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + "[PO_CODIGO_SALIDA] = " + resultMap.get("PO_CODIGO_SALIDA"));
			logger.info(String.valueOf(mensajeLog) + "[PO_MENSAJE_SALIDA] = " + resultMap.get("PO_MENSAJE_SALIDA"));

			ListaClientePorNombre listaClientePorNombre = new ListaClientePorNombre();
			response.setCodRespuesta(resultMap.get("PO_CODIGO_SALIDA") != null
					? resultMap.get("PO_CODIGO_SALIDA").toString() : PropertiesInternos.STRING_EMPTY);
			response.setMsgRespuesta(resultMap.get("PO_MENSAJE_SALIDA") != null
					? resultMap.get("PO_MENSAJE_SALIDA").toString() : PropertiesInternos.STRING_EMPTY);

			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaClientePorNombre
						.setListClientePorNombre((List<ClientePorNombre>) resultMap.get("PO_CURSOR_CLIENTE"));
			logger.info(String.valueOf(mensajeLog) + "[Cantidad PO_CURSOR_CLIENTE] = "
					+ (listaClientePorNombre.getListClientePorNombre() != null
							? listaClientePorNombre.getListClientePorNombre().size() : 0));

			String mensaje;
			if (listaClientePorNombre.getListClientePorNombre() != null) {
				logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_NULA);
				if (!listaClientePorNombre.getListClientePorNombre().isEmpty()) {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_NO_VACIA);
					response.setListClientePorNombre(listaClientePorNombre);
					mensaje = resultMap.get("PO_MENSAJE_SALIDA") != null ? resultMap.get("PO_MENSAJE_SALIDA").toString()
							: PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(String.valueOf(mensajeLog) + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("PO_MENSAJE_SALIDA") != null ? resultMap.get("PO_MENSAJE_SALIDA").toString()
						: PropertiesInternos.STRING_EMPTY;
			}
			response.setMsgRespuesta(mensaje);
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError;
			String msjError;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicessCustomerRsNom).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarTecnologiaSGAResponse consultarTecnologia(String mensajeTransaccion,
			ConsultarTecnologiaSGARequest objConsultarTecnologiaSGARequest) throws DBException {
		String metodo = "consultarTecnologia";
		String mensajeLog = String.valueOf(mensajeTransaccion) + "[" + metodo + "]-";
		ConsultarTecnologiaSGAResponse objResponse = new ConsultarTecnologiaSGAResponse();
		List<TecnologiaSGA> listaTecnologiaSGA = new ArrayList<>();
		logger.info(String.valueOf(mensajeLog) + " == Inicio del metodo " + metodo);

		try {
			String outCursor = "PO_CURSOR_SUCURSALES";
			
			logger.info(String.valueOf(mensajeLog) + "Consultando BD " + propiedadesExterna.dbSGADB + ", con JNDI = [" + propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(propiedadesExterna.dbSgaDBLoginTimeout);

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS)
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(propiedadesExterna.dbSGADBOwner)
					.withCatalogName(propiedadesExterna.pkgSicesFailure)
					.withProcedureName(propiedadesExterna.spSicessTecnologia)
					.declareParameters(
							new SqlParameter("PI_DOCUMENTO", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_CODIGO_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_MENSAJE_SALIDA", OracleTypes.VARCHAR),
							new SqlOutParameter(outCursor, OracleTypes.CURSOR, new RowMapper<TecnologiaSGA>() {
								public TecnologiaSGA mapRow(ResultSet rs, int arg1) throws SQLException {
									TecnologiaSGA objTecnologia = new TecnologiaSGA();
									objTecnologia.setTecnologia(Utilitarios.isNullOrBlankToString(rs.getString("TECNOLOGIA")));
									objTecnologia.setCodcli(Utilitarios.isNullOrBlankToString(rs.getString("CODCLI")));
									objTecnologia.setCodsuc(Utilitarios.isNullOrBlankToString(rs.getString("CODSUC")));
									objTecnologia.setNumero(Utilitarios.isNullOrBlankToString(rs.getString("NUMERO")));
									objTecnologia.setNro_pago(Utilitarios.isNullOrBlankToString(rs.getString("NRO_PAGO")));
									objTecnologia.setNumslc(Utilitarios.isNullOrBlankToString(rs.getString("NUMSLC")));
									objTecnologia.setCodsolot(Utilitarios.isNullOrBlankToString(rs.getString("CODSOLOT")));
									objTecnologia.setDireccion(Utilitarios.isNullOrBlankToString(rs.getString("DIRECCION")));
									objTecnologia.setPlano(Utilitarios.isNullOrBlankToString(rs.getString("PLANO")));
									objTecnologia.setUbigeo(Utilitarios.isNullOrBlankToString(rs.getString("UBIGEO")));
									objTecnologia.setDepartamento(Utilitarios.isNullOrBlankToString(rs.getString("DEPARTAMENTO")));
									objTecnologia.setProvincia(Utilitarios.isNullOrBlankToString(rs.getString("PROVINCIA")));
									objTecnologia.setDistrito(Utilitarios.isNullOrBlankToString(rs.getString("DISTRITO")));
									objTecnologia.setFlg_portable(Utilitarios.isNullOrBlankToString(rs.getString("FLG_PORTABLE")));
									objTecnologia.setInternet(Utilitarios.isNullOrBlankToString(rs.getString("INTERNET")));
									objTecnologia.setTelefonia(Utilitarios.isNullOrBlankToString(rs.getString("TELEFONIA")));
									objTecnologia.setCable(Utilitarios.isNullOrBlankToString(rs.getString("CABLE")));
									objTecnologia.setEstado(Utilitarios.isNullOrBlankToString(rs.getString("ESTADO")));
									objTecnologia.setPlataforma(Utilitarios.isNullOrBlankToString(rs.getString("PLATAFORMA")));
									return objTecnologia;
								}
							}));

			logger.info(String.valueOf(mensajeLog) + "Se invocara el SP : " + propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.spSicessTecnologia));
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [INPUT]: ");
			logger.info(String.valueOf(mensajeLog) + objConsultarTecnologiaSGARequest.toString());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_BSCS);
			
			SqlParameterSource paramatersIn = new BeanPropertySqlParameterSource(objConsultarTecnologiaSGARequest);
			
			Map<String, Object> resultMap = jdbcCall.execute(paramatersIn);

			listaTecnologiaSGA = (List<TecnologiaSGA>) Optional.ofNullable(resultMap.get(outCursor)).orElse(Collections.emptyList());

			objResponse.setPo_codigo_salida(Utilitarios.isNullOrBlankToString(resultMap.get("PO_CODIGO_SALIDA")));
			objResponse.setPo_mensaje_salida(Utilitarios.isNullOrBlankToString(resultMap.get("PO_MENSAJE_SALIDA")));
			objResponse.setListaTecnologiaSGA(listaTecnologiaSGA);
			
			logger.info(String.valueOf(mensajeLog) + "PARAMETROS [OUTPUT]: ");
			logger.info(String.valueOf(mensajeLog) + objResponse.toString());
		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spSicessTecnologia).replace("$msg", error));
		}

		logger.info(String.valueOf(mensajeLog) + " == Fin del metodo " + metodo);
		return objResponse;
	}

	@Override
	public ObtenerDatosClienteResponse obtenerDatosCliente(String mensajeTransaccion,
														   String i_codId) throws DBException {
		// TODO Auto-generated method stub
		String metodo = "obtenerTecnologia";
		String mensajeLog = mensajeTransaccion + "[" + metodo + "]-";
		ObtenerDatosClienteResponse response = new ObtenerDatosClienteResponse();
		logger.info(mensajeLog + " == Inicio del metodo " + metodo);
		Connection conexion = null;
		try {

			logger.info(mensajeLog + "Consultando BD " + this.propiedadesExterna.dbSGADB + ", con JNDI = ["
					+ this.propiedadesExterna.cJNDI_SGA + "]");
			sgaDS.setLoginTimeout(this.propiedadesExterna.dbSgaDBLoginTimeout);
			conexion = sgaDS.getConnection();
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(sgaDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess().withSchemaName(this.propiedadesExterna.dbSGADBOwnerOperacion)
					.withProcedureName(this.propiedadesExterna.pkgPostventaOne.concat(PropertiesInternos.PUNTO)
							.concat(this.propiedadesExterna.spsgassListaDatosCLiente))
					.declareParameters(new SqlParameter("P_COD_ID", OracleTypes.INTEGER),
							new SqlOutParameter("P_ERROR", OracleTypes.INTEGER),
							new SqlOutParameter("P_MENSAJE", OracleTypes.VARCHAR),
							new SqlOutParameter("P_DAT_CLI", OracleTypes.CURSOR, new RowMapper<DatosCliente>() {
								public DatosCliente mapRow(ResultSet rs, int arg1) throws SQLException {
									DatosCliente datosCliente= new DatosCliente();
									datosCliente.setC_contrato(rs.getString("CONTRATO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("CONTRATO"));
									datosCliente.setC_codcliente(rs.getString("CODCLIENTE") == null ? PropertiesInternos.STRING_EMPTY
											: rs.getString("CODCLIENTE"));
									datosCliente.setC_plano(rs.getString("PLANO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("PLANO"));
									datosCliente.setC_ubigeo(rs.getString("UBIGEO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("UBIGEO"));
									datosCliente.setC_estadoservicio(rs.getString("ESTADOSERVICIO") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("ESTADOSERVICIO"));
									datosCliente.setC_cargoreconx(rs.getString("CARGORECONX") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("CARGORECONX"));
									datosCliente.setC_tecnologia(rs.getString("TECNOLOGIA") == null
											? PropertiesInternos.STRING_EMPTY : rs.getString("TECNOLOGIA"));
									return datosCliente;
								}
							}));

			logger.info(mensajeLog + "Se invocara el SP : "
					+ this.propiedadesExterna.dbSGADBOwnerOperacion.concat(PropertiesInternos.PUNTO)
					.concat(this.propiedadesExterna.pkgPostventaOne).concat(PropertiesInternos.PUNTO)
					.concat(this.propiedadesExterna.spsgassListaDatosCLiente));
			logger.info(mensajeLog + "PARAMETROS [INPUT]: ");
			logger.info(mensajeLog + "[P_COD_ID] = " + i_codId);

			SqlParameterSource objParametrosIN = new MapSqlParameterSource().addValue("P_COD_ID", i_codId);

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_SGA);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(mensajeLog + "PARAMETROS [OUTPUT]: ");
			logger.info(mensajeLog + "[P_ERROR] = " + resultMap.get("P_ERROR"));
			logger.info(mensajeLog + "[P_MENSAJE] = " + resultMap.get("P_MENSAJE"));

			ListaDatosCliente listaDatosCliente = new ListaDatosCliente();
			response.setO_error(resultMap.get("P_ERROR") != null
					? resultMap.get("P_ERROR").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getO_error().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaDatosCliente.setListDatosCliente((List<DatosCliente>) resultMap.get("P_DAT_CLI")) ;
			logger.info(mensajeLog + "[Cantidad PO_CURSOR_SERVICIO] = "
					+ (listaDatosCliente.getListDatosCliente() != null ? listaDatosCliente.getListDatosCliente().size() : 0));

			String mensaje = PropertiesInternos.STRING_EMPTY;
			if (listaDatosCliente.getListDatosCliente() != null) {
				if (!listaDatosCliente.getListDatosCliente().isEmpty()) {
					logger.info(mensajeLog + Constantes.LISTA_NO_VACIA);
					response.setListDatosCliente(listaDatosCliente);
					mensaje = resultMap.get("P_MENSAJE") != null ? resultMap.get("P_MENSAJE").toString()
							: PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(mensajeLog + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("P_MENSAJE") != null ? resultMap.get("P_MENSAJE").toString()
						: PropertiesInternos.STRING_EMPTY;
			}
			response.setO_msg(mensaje);
			logger.info(mensajeLog + "[SALIDA] = "
					+ JAXBUtilitarios.anyObjectToXmlText(response));

		} catch (Exception e) {
			logger.error(mensajeLog + "Error en la ejecucion del SP : ", e);
			String error = e.toString();
			String codError = PropertiesInternos.STRING_EMPTY;
			String msjError = PropertiesInternos.STRING_EMPTY;
			if (error.toUpperCase(Locale.getDefault())
					.contains(propiedadesExterna.dbErrorSqlTimeOutException.toUpperCase(Locale.getDefault()))) {
				codError = propiedadesExterna.codConsultaClienteCESIdt1;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt1;
			} else {
				codError = propiedadesExterna.codConsultaClienteCESIdt2;
				msjError = propiedadesExterna.msjConsultaClienteCESIdt2;
			}
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbSGADB)
					.replace("$sp", propiedadesExterna.spsgassListaDatosCLiente).replace("$msg", error));
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

}
