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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.driver.OracleTypes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Cliente;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ClientePorNombre;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClientePorNombreRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClientePorNombreResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClienteRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClienteResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarEquipoRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarEquipoResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarServicioRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarServicioResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarSucursalDetalleRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarSucursalDetalleResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Equipo;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ListaCliente;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ListaClientePorNombre;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ListaServicio;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ListaSucursal;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Servicio;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Sucursal;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Tecnologia;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.dao.util.Utilitario;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.DBException;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Constantes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.PropertiesInternos;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Utilitarios;

@Repository
public class BscsDaoImpl implements BscsDao {

	private final static Logger logger = Logger.getLogger(BscsDaoImpl.class);

	@Autowired
	@Qualifier(value = "bscsDS")
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
			
			logger.info(mensajeLog + "Consultando BD " + this.propiedadesExterna.dbBSCSDB + ", con JNDI = [" + this.propiedadesExterna.cJNDI_BSCS + "]");
			bscsDS.setLoginTimeout(this.propiedadesExterna.dbBscsDBLoginTimeout);
			conexion = bscsDS.getConnection();
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(bscsDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.propiedadesExterna.dbBSCSDBOwner)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailureBSCS.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_customerBSCS))
					.declareParameters(
							new SqlParameter("aiv_typesearch", OracleTypes.VARCHAR),
							new SqlParameter("aiv_stringsearch", OracleTypes.VARCHAR),
							new SqlOutParameter("aon_sourceout", OracleTypes.INTEGER),
							new SqlOutParameter("aov_message", OracleTypes.VARCHAR),
							new SqlOutParameter("aoc_refcursorcliente", OracleTypes.CURSOR, new RowMapper<Cliente>() {
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
							}));

			logger.info(mensajeLog + "Se invocara el SP : " + this.propiedadesExterna.dbBSCSDBOwner.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.pkgSicesFailureBSCS).concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_customerBSCS));
			logger.info(mensajeLog + "PARAMETROS [INPUT]: ");
			logger.info(mensajeLog + "[aiv_typesearch] = " + objConsultarClienteRequest.getTipoBusqueda());
			logger.info(mensajeLog + "[aiv_stringsearch] = " + objConsultarClienteRequest.getValorBusqueda());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("aiv_typesearch", objConsultarClienteRequest.getTipoBusqueda())
					.addValue("aiv_stringsearch", objConsultarClienteRequest.getValorBusqueda());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_BSCS);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(mensajeLog + "PARAMETROS [OUTPUT]: ");
			logger.info(mensajeLog + "[aon_sourceout] = " + resultMap.get("aon_sourceout"));
			logger.info(mensajeLog + "[aov_message] = " + resultMap.get("aov_message"));

			ListaCliente listaCliente = new ListaCliente();
			response.setCodRespuesta(resultMap.get("aon_sourceout") != null ? resultMap.get("aon_sourceout").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaCliente.setListCliente((List<Cliente>) resultMap.get("aoc_refcursorcliente"));
			logger.info(mensajeLog + "[Cantidad aoc_refcursorcliente] = " + (listaCliente.getListCliente() != null ? listaCliente.getListCliente().size() : 0));

			String mensaje = PropertiesInternos.STRING_EMPTY;
			if (listaCliente.getListCliente() != null) {
				logger.info(mensajeLog + Constantes.LISTA_NO_NULA);
				if (!listaCliente.getListCliente().isEmpty()) {
					logger.info(mensajeLog + Constantes.LISTA_NO_VACIA);
					response.setListCliente(listaCliente);
					mensaje = resultMap.get("aov_message") != null ? resultMap.get("aov_message").toString() : PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(mensajeLog + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("aov_message") != null ? resultMap.get("aov_message").toString() : PropertiesInternos.STRING_EMPTY;
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
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbBSCSDB).replace("$sp", propiedadesExterna.spSicess_customerBSCS).replace("$msg", error));
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

	@Override
	public ConsultarClientePorNombreResponse consultarClientePorNombre(String mensajeTransaccion, ConsultarClientePorNombreRequest objConsultarClientePorNombreRequest) throws DBException {
		String metodo = "consultarClientePorNombre";
		String mensajeLog = mensajeTransaccion + "[" + metodo + "]-";
		ConsultarClientePorNombreResponse response = new ConsultarClientePorNombreResponse();
		logger.info(mensajeLog + " == Inicio del metodo " + metodo);
		Connection conexion = null;
		try {
			
			logger.info(mensajeLog + "Consultando BD " + this.propiedadesExterna.dbBSCSDB + ", con JNDI = [" + this.propiedadesExterna.cJNDI_BSCS + "]");
			bscsDS.setLoginTimeout(this.propiedadesExterna.dbBscsDBLoginTimeout);
			conexion = bscsDS.getConnection();
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(bscsDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.propiedadesExterna.dbBSCSDBOwner)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailureBSCS.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_customer_rs_nom))
					.declareParameters(
							new SqlParameter("aiv_typesearch", OracleTypes.VARCHAR),
							new SqlParameter("aiv_stringsearch", OracleTypes.VARCHAR),
							new SqlOutParameter("aon_sourceout", OracleTypes.INTEGER),
							new SqlOutParameter("aov_message", OracleTypes.VARCHAR),
							new SqlOutParameter("aoc_refcursorcliente", OracleTypes.CURSOR, new RowMapper<ClientePorNombre>() {
								public ClientePorNombre mapRow(ResultSet rs, int arg1) throws SQLException {
									ClientePorNombre clientePorNombre = new ClientePorNombre();
									clientePorNombre.setNombres(rs.getString("NOMBRES") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("NOMBRES"));
									clientePorNombre.setApellidos(rs.getString("APELLIDOS") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("APELLIDOS"));
									clientePorNombre.setCcname(rs.getString("CCNAME") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("CCNAME"));
									clientePorNombre.setTipoDoc(rs.getString("TIPODOC") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("TIPODOC"));
									clientePorNombre.setNumDoc(rs.getString("DOCUMENTO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("DOCUMENTO"));
									return clientePorNombre;
								}
							}));

			logger.info(mensajeLog + "Se invocara el SP : " + this.propiedadesExterna.dbBSCSDBOwner.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.pkgSicesFailureBSCS).concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_customer_rs_nom));
			logger.info(mensajeLog + "PARAMETROS [INPUT]: ");
			logger.info(mensajeLog + "[aiv_typesearch] = " + objConsultarClientePorNombreRequest.getTipobusqueda());
			logger.info(mensajeLog + "[aiv_stringsearch] = " + objConsultarClientePorNombreRequest.getValor_busqueda());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("aiv_typesearch", objConsultarClientePorNombreRequest.getTipobusqueda())
					.addValue("aiv_stringsearch", objConsultarClientePorNombreRequest.getValor_busqueda());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_BSCS);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(mensajeLog + "PARAMETROS [OUTPUT]: ");
			logger.info(mensajeLog + "[aon_sourceout] = " + resultMap.get("aon_sourceout"));
			logger.info(mensajeLog + "[aov_message] = " + resultMap.get("aov_message"));

			ListaClientePorNombre listaClientePorNombre = new ListaClientePorNombre();
			response.setCodRespuesta(resultMap.get("aon_sourceout") != null ? resultMap.get("aon_sourceout").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaClientePorNombre.setListClientePorNombre((List<ClientePorNombre>) resultMap.get("aoc_refcursorcliente"));
			logger.info(mensajeLog + "[Cantidad aoc_refcursorcliente] = " + (listaClientePorNombre.getListClientePorNombre() != null ? listaClientePorNombre.getListClientePorNombre().size() : 0));

			String mensaje = PropertiesInternos.STRING_EMPTY;
			if (listaClientePorNombre.getListClientePorNombre() != null) {
				logger.info(mensajeLog + Constantes.LISTA_NO_NULA);
				if (!listaClientePorNombre.getListClientePorNombre().isEmpty()) {
					logger.info(mensajeLog + Constantes.LISTA_NO_VACIA);
					response.setListClientePorNombre(listaClientePorNombre);
					mensaje = resultMap.get("aov_message") != null ? resultMap.get("aov_message").toString() : PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(mensajeLog + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("aov_message") != null ? resultMap.get("aov_message").toString() : PropertiesInternos.STRING_EMPTY;
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
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbBSCSDB).replace("$sp", propiedadesExterna.spSicess_customer_rs_nom).replace("$msg", error));
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
		Connection conexion =null;
		try {
			
			logger.info(mensajeLog + "Consultando BD " + propiedadesExterna.dbBSCSDB + ", con JNDI = [" + propiedadesExterna.cJNDI_BSCS + "]");
			bscsDS.setLoginTimeout(propiedadesExterna.dbBscsDBLoginTimeout);
			conexion  = bscsDS.getConnection();
			String outCursor = "PO_REFCURSORTECNO";

			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(bscsDS)
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(propiedadesExterna.dbBSCSDBOwner)
					.withCatalogName(propiedadesExterna.pkgSicesFailureBSCS)
					.withProcedureName(propiedadesExterna.spSicess_tecnologia)
					.declareParameters(new SqlParameter("PI_DOCUMENTO", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_SOURCEOUT", OracleTypes.VARCHAR),
							new SqlOutParameter("PO_MESSAGE", OracleTypes.VARCHAR),
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
							}));

			logger.info(mensajeLog + "Se invocara el SP : " + this.propiedadesExterna.dbBSCSDBOwner.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.pkgSicesFailureBSCS).concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_tecnologia));
			logger.info(mensajeLog + "PARAMETROS [INPUT]: ");
			logger.info(mensajeLog + objConsultarTecnologiaRequest.toString());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_BSCS);
			
			SqlParameterSource paramatersIn = new BeanPropertySqlParameterSource(objConsultarTecnologiaRequest);
			
			Map<String, Object> resultMap = jdbcCall.execute(paramatersIn);
			
			listaTecnologia = (List<Tecnologia>) Optional.ofNullable(resultMap.get(outCursor)).orElse(Collections.emptyList());

			objResponse.setPo_sourceout(Utilitarios.isNullOrBlankToString(resultMap.get("PO_SOURCEOUT")));
			objResponse.setPo_message(Utilitarios.isNullOrBlankToString(resultMap.get("PO_MESSAGE")));
			objResponse.setListaTecnologia(listaTecnologia);
			
			logger.info(mensajeLog + "PARAMETROS [OUTPUT]: ");
			logger.info(mensajeLog + objResponse.toString());
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

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarServicioResponse consultarServicio(String mensajeTransaccion, ConsultarServicioRequest objConsultarServicioRequest) throws DBException {
		String metodo = "consultarServicio";
		String mensajeLog = mensajeTransaccion + "[" + metodo + "]-";
		ConsultarServicioResponse response = new ConsultarServicioResponse();
		logger.info(mensajeLog + " == Inicio del metodo " + metodo);
		Connection conexion =null;
		try {
			
			logger.info(mensajeLog + "Consultando BD " + this.propiedadesExterna.dbBSCSDB + ", con JNDI = [" + this.propiedadesExterna.cJNDI_BSCS + "]");
			bscsDS.setLoginTimeout(this.propiedadesExterna.dbBscsDBLoginTimeout);
			conexion  = bscsDS.getConnection();
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(bscsDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.propiedadesExterna.dbBSCSDBOwner)
					.withProcedureName(this.propiedadesExterna.pkgSicesFailureBSCS.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_servicebscs))
					.declareParameters(
							new SqlParameter("pi_i_contracid", OracleTypes.VARCHAR),
							new SqlOutParameter("po_code_result", OracleTypes.INTEGER),
							new SqlOutParameter("po_message_result", OracleTypes.VARCHAR),
							new SqlOutParameter("po_cursor", OracleTypes.CURSOR, new RowMapper<Servicio>() {
								public Servicio mapRow(ResultSet rs, int arg1) throws SQLException {
									Servicio servicio = new Servicio();
									servicio.setGrupo(rs.getString("GRUPO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("GRUPO"));
									servicio.setServicio(rs.getString("SERVICIO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("SERVICIO"));
									servicio.setEstado(rs.getString("ESTADO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("ESTADO"));
									servicio.setValidoDesde(rs.getString("VALIDO_DESDE") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("VALIDO_DESDE"));
									servicio.setTipoServicio(rs.getString("TIPO_SERVICIO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("TIPO_SERVICIO"));
									servicio.setCodBloqueo(rs.getString("COD_BLOQUEO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("COD_BLOQUEO"));
									servicio.setBloqueo(rs.getString("BLOQUEO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("BLOQUEO"));
									servicio.setCargoFijo(rs.getString("CARGOFIJO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("CARGOFIJO"));
									return servicio;
								}
							}));

			logger.info(mensajeLog + "Se invocara el SP : " + this.propiedadesExterna.dbBSCSDBOwner.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.pkgSicesFailureBSCS).concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spSicess_servicebscs));
			logger.info(mensajeLog + "PARAMETROS [INPUT]: ");
			logger.info(mensajeLog + "[pi_i_contracid] = " + objConsultarServicioRequest.getCo_id());

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("pi_i_contracid", objConsultarServicioRequest.getCo_id());

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_BSCS);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(mensajeLog + "PARAMETROS [OUTPUT]: ");
			logger.info(mensajeLog + "[po_code_result] = " + resultMap.get("po_code_result"));
			logger.info(mensajeLog + "[po_message_result] = " + resultMap.get("po_message_result"));

			ListaServicio listaServicio = new ListaServicio();
			response.setCodRespuesta(resultMap.get("po_code_result") != null ? resultMap.get("po_code_result").toString() : PropertiesInternos.STRING_EMPTY);
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO))
				listaServicio.setListServicio((List<Servicio>) resultMap.get("po_cursor"));
			logger.info(mensajeLog + "[Cantidad po_cursor] = " + (listaServicio.getListServicio() != null ? listaServicio.getListServicio().size() : 0));

			String mensaje = PropertiesInternos.STRING_EMPTY;
			if (listaServicio.getListServicio() != null) {
				logger.info(mensajeLog + Constantes.LISTA_NO_NULA);
				if (!listaServicio.getListServicio().isEmpty()) {
					logger.info(mensajeLog + Constantes.LISTA_NO_VACIA);
					response.setListServicio(listaServicio);
					mensaje = resultMap.get("po_message_result") != null ? resultMap.get("po_message_result").toString() : PropertiesInternos.STRING_EMPTY;
				} else {
					logger.info(mensajeLog + Constantes.LISTA_VACIA);
					mensaje = Constantes.CURSOR_VACIO;
				}
			} else {
				mensaje = resultMap.get("po_message_result") != null ? resultMap.get("po_message_result").toString() : PropertiesInternos.STRING_EMPTY;
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
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbBSCSDB).replace("$sp", propiedadesExterna.spSicess_servicebscs).replace("$msg", error));
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

	@Override
	public ConsultarEquipoResponse consultarEquipoCable(String mensajeTransaccion,
			ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException {
		String metodo = "consultarEquipoCable";
		String mensajeLog = mensajeTransaccion + "[" + metodo + "]-";
		ConsultarEquipoResponse response = new ConsultarEquipoResponse();
		logger.info(mensajeLog + " == Inicio del metodo " + metodo);
		Connection conexion = null;
		try {
			
			logger.info(mensajeLog + "Consultando BD " + this.propiedadesExterna.dbBSCSDB + ", con JNDI = [" + this.propiedadesExterna.cJNDI_BSCS + "]");
			bscsDS.setLoginTimeout(this.propiedadesExterna.dbBscsDBLoginTimeout);
			conexion = bscsDS.getConnection();
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(bscsDS).withoutProcedureColumnMetaDataAccess()
					.withoutProcedureColumnMetaDataAccess()
					.withSchemaName(this.propiedadesExterna.dbBSCSDBOwner)
					.withProcedureName(this.propiedadesExterna.pkgProvDth.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spConsultaDeco))
					.declareParameters(
							new SqlParameter("p_co_id", OracleTypes.VARCHAR),
							new SqlParameter("p_msisdn", OracleTypes.VARCHAR),
							new SqlOutParameter("p_resultado", OracleTypes.NUMBER),
							new SqlOutParameter("p_msgerr", OracleTypes.VARCHAR),
							new SqlOutParameter("p_cursor", OracleTypes.CURSOR, new RowMapper<Equipo>() {
								public Equipo mapRow(ResultSet rs, int arg1) throws SQLException {
									Equipo equipo = new Equipo();
									equipo.setType(propiedadesExterna.tecnologiaDTH);
									equipo.setModel(PropertiesInternos.STRING_EMPTY);
									equipo.setSerialNumber(PropertiesInternos.STRING_EMPTY);
									equipo.setUaNumber(rs.getString("NRO_DECO") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("NRO_DECO"));
									equipo.setCardNumber(rs.getString("NRO_TARJETA") == null ? PropertiesInternos.STRING_EMPTY : rs.getString("NRO_TARJETA"));
									return equipo;
								}
							}));

			logger.info(mensajeLog + "Se invocara el SP : " + this.propiedadesExterna.dbBSCSDBOwner.concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.pkgProvDth).concat(PropertiesInternos.PUNTO).concat(this.propiedadesExterna.spConsultaDeco));
			logger.info(mensajeLog + "PARAMETROS [INPUT]: ");
			logger.info(mensajeLog + "[p_co_id] = " + objConsultarEquipoRequest.getCoId());
			logger.info(mensajeLog + "[p_msisdn] = " + PropertiesInternos.STRING_EMPTY);

			SqlParameterSource objParametrosIN = new MapSqlParameterSource()
					.addValue("p_co_id", objConsultarEquipoRequest.getCoId())
					.addValue("p_msisdn", PropertiesInternos.STRING_EMPTY);

			jdbcCall.getJdbcTemplate().setQueryTimeout(this.propiedadesExterna.cEXECUTION_TIMEOUT_BSCS);
			Map<String, Object> resultMap = jdbcCall.execute(objParametrosIN);

			logger.info(mensajeLog + "PARAMETROS [OUTPUT]: ");
			logger.info(mensajeLog + "[p_resultado] = " + resultMap.get("p_resultado"));
			logger.info(mensajeLog + "[p_msgerr] = " + resultMap.get("p_msgerr"));

			
			response.setCodRespuesta(resultMap.get("p_resultado") != null ? resultMap.get("p_resultado").toString() : PropertiesInternos.STRING_EMPTY);
			response.setMsgRespuesta(resultMap.get("p_msgerr") != null ? resultMap.get("p_msgerr").toString() : PropertiesInternos.STRING_EMPTY);
			
			if (response.getCodRespuesta().trim().equals(propiedadesExterna.IDF0CODIGO)){
				@SuppressWarnings("unchecked")
				List<Equipo> listaEquipo = (List<Equipo>) resultMap.get("p_cursor");
				response.setListEquipo(listaEquipo);
				logger.info(mensajeLog + "[Cantidad p_cursor] = " + (listaEquipo != null ? listaEquipo.size() : 0));
			}
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
			throw new DBException(codError, msjError.replace("$bd", propiedadesExterna.dbBSCSDB).replace("$sp", propiedadesExterna.spConsultaDeco).replace("$msg", error));
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
