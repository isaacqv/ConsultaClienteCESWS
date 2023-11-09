package pe.com.claro.eai.ws.postventa.consultaclientecesws.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.ws.Holder;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.claro.eai.ws.baseschema.AuditRequestType;
import pe.com.claro.eai.ws.baseschema.AuditResponseType;
import pe.com.claro.eai.ws.baseschema.ParametrosType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Cliente;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ClientePorNombre;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClientePorNombreRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClientePorNombreResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClienteRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClienteResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarDetalleSucursalDTHRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarDetalleSucursalDTHResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarDetalleSucursalRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarDetalleSucursalResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarEquipoRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarEquipoResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarEstadoServiciosRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarEstadoServiciosResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarFallaRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarFallaResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarInteraccionCasosRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarInteraccionCasosResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarJanusRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarJanusResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarReglaRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarReglaResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarSeaChangeRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarSeaChangeResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarServicioRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarServicioResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarServicioSucursalRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarServicioSucursalResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaSGARequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaSGAResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.DatosIncidencia;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.DatosInfVar;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.DatosProblema;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.DatosSot;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.DetalleSucursal;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.DetalleSucursalDTH;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Equipo;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.EstadoServicio;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Falla;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Janus;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ReconectarNcosRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ReconectarNcosResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.RegistrarAuditoriaRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.RegistrarAuditoriaResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Regla;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.SeaChange;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Servicio;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ServicioSucursal;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.Tecnologia;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.TecnologiaSGA;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz.AuthenticationRest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz.IncognitoRest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz.IptvRest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.dao.BscsDao;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.dao.ClarifyDao;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.dao.PvuDao;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.dao.SgaDao;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.DBException;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.request.AuthenticationRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.request.IncognitoRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.response.AuthenticationResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.response.IncognitoResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ClientePorNombreType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ClienteType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarClientePorNombreRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarClientePorNombreResponseType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarClienteRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarClienteResponseType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarEquipoRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarEquipoResponseType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarFallaRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarFallaResponseType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarInteraccionCasosRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarInteraccionCasosResponseType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarJanusRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarJanusResponseType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarReglaRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarReglaResponseType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarSeaChangeRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarSeaChangeResponseType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarServicioRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarServicioResponseType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarSucursalDetalleRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarSucursalDetalleResponseType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.DatosIncidenciaType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.DatosInfVarType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.DatosProblemaType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.DatosSotType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.EquipoType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.FallaType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.HeaderRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.HeaderResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.IncognitoHeader;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.JanusType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ListaClienteType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ListaEquipoType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ListaJanusType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ListaReglaType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ListaSeaChangeType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ListaServicioSucursalType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ListaServicioType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ListaSucursalesType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ReconectarNcosRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ReconectarNcosResponseType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ReglaType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ResponseStatus;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.SeaChangeType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.Services;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ServicioSucursalType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ServicioType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.Subscribers;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.SucursalType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv.ChildCursor;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv.IptvHeader;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv.IptvResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv.IptvResquest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Constantes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.JAXBUtilitarios;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.PropertiesInternos;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Utilitarios;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.WSException;

@Service
public class ConsultaClienteCESServiceImpl implements ConsultaClienteCESService {

	private final static Logger LOGGER = Logger.getLogger(ConsultaClienteCESServiceImpl.class);

	@Autowired
	Propiedades propiedadesExterna;

	@Autowired
	private SgaDao sgaDao;

	@Autowired
	private BscsDao bscsDao;

	@Autowired
	private ClarifyDao clarifyDao;
	
	@Autowired
	private PvuDao pvuDao;
	
	@Autowired
	private AuthenticationRest authenticationRest;

	@Autowired
	private IncognitoRest incognitoRest;

	@Autowired
	private IptvRest iptvRest;

	@Override
	public ConsultarClienteResponseType consultarCliente(ConsultarClienteRequestType objConsultarClienteRequestType) {		
		final long tiempoInicial = System.currentTimeMillis();
		
		String metodo = "consultarCliente";
		String idTransaccion = objConsultarClienteRequestType.getAuditRequest().getIdTransaccion();
		String msgTransaccion = "[ " + metodo + " idTx=" + idTransaccion + " ] - ";
		String mensajeLog = idTransaccion + "[" + metodo + "]-";
		
		LOGGER.info(msgTransaccion + "===== INICIO de la operacion " + metodo + " =====");
		LOGGER.info(mensajeLog + "Datos de Request: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarClienteRequestType));
		
		ConsultarClienteResponseType response = new ConsultarClienteResponseType();
		AuditResponseType objAuditResponseType = new AuditResponseType();
		ListaClienteType objListaClienteType = new ListaClienteType();
		ParametrosType objParametrosType = new ParametrosType();
		ClienteType objClienteType;
		List<ClienteType> listClienteType = new ArrayList<>();

		try {
			ConsultarClienteResponse objConsultarClienteSgaResponse = new ConsultarClienteResponse();
			ConsultarClienteResponse objConsultarClienteBscsResponse = new ConsultarClienteResponse();
			ConsultarClienteResponse objConsultarClienteResponse = new ConsultarClienteResponse();

			ConsultarClienteRequest objConsultarClienteRequest = new ConsultarClienteRequest();
			objConsultarClienteRequest.setTipoBusqueda(objConsultarClienteRequestType.getTipoBusqueda());
			objConsultarClienteRequest.setValorBusqueda(objConsultarClienteRequestType.getValorBusqueda());

			LOGGER.info(mensajeLog + "--------- Inicio Actividad Nro 1 - ConsultarCliente en SGA ---------");
			objConsultarClienteSgaResponse = sgaDao.consultarCliente(idTransaccion, objConsultarClienteRequest);
			LOGGER.info(mensajeLog + "--------- Fin Actividad Nro 1 - ConsultarCliente en SGA ---------");

			if (propiedadesExterna.criterioSgaCodcli.trim().equals(objConsultarClienteRequest.getTipoBusqueda().trim())) {
				LOGGER.info(mensajeLog + "--------- Inicio Actividad Nro 1.5 - Obtener datos complementarios de clientes en :" + propiedadesExterna.dbSGADB + " --------- ");
				String strNumDoc = sgaDao.obtenerNumeroDocumento(idTransaccion, objConsultarClienteRequestType.getValorBusqueda());
				objConsultarClienteRequest.setTipoBusqueda(propiedadesExterna.criterioBscsDni);
				objConsultarClienteRequest.setValorBusqueda(strNumDoc);
			}
			
			LOGGER.info(mensajeLog + "--------- Inicio Actividad Nro 1 - ConsultarCliente en BSCS --------- ");
			objConsultarClienteBscsResponse = bscsDao.consultarCliente(idTransaccion, objConsultarClienteRequest);
			LOGGER.info(mensajeLog + "--------- Fin Actividad Nro 1 - ConsultarCliente en BSCS --------- ");
			
			objConsultarClienteBscsResponse = consultarClienteComplemento(idTransaccion, mensajeLog, objConsultarClienteBscsResponse);
			objConsultarClienteResponse = unificarCliente(objConsultarClienteSgaResponse, objConsultarClienteBscsResponse);
			
			if (objConsultarClienteResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO) || objConsultarClienteResponse.getListCliente() == null) {
				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
				objAuditResponseType.setMensajeRespuesta(propiedadesExterna.IDF1MENSAJE
						.replace("$bd", propiedadesExterna.criterioSgaCodcli.trim().equals(objConsultarClienteRequest.getTipoBusqueda().trim()) ? propiedadesExterna.dbSGADB : propiedadesExterna.dbBSCSDB)
						.replace("$sp", propiedadesExterna.criterioSgaCodcli.trim().equals(objConsultarClienteRequest.getTipoBusqueda().trim()) ? propiedadesExterna.spSicess_customer : propiedadesExterna.spSicess_customerBSCS)
						.replace("$cod", objConsultarClienteResponse.getCodRespuesta())
						.replace("$msg", objConsultarClienteResponse.getMsgRespuesta()));
				objAuditResponseType.setIdTransaccion(objConsultarClienteRequestType.getAuditRequest().getIdTransaccion());
				
				response.setAuditResponse(objAuditResponseType);
				response.setListaCliente(objListaClienteType);
				response.setListaResponseOpcional(objParametrosType);				
			} else {
				for (Cliente item : objConsultarClienteResponse.getListCliente().getListCliente()) {
					objClienteType = new ClienteType();
					objClienteType.setCustomerid(item.getCustomerid());
					objClienteType.setCuenta(item.getCuenta());
					objClienteType.setCodCli(item.getCodCli());
					objClienteType.setBillcycle(item.getBillcycle());
					objClienteType.setNomCli(item.getNomCli());
					objClienteType.setCcname(item.getCcname());
					objClienteType.setNombres(item.getNombres());
					objClienteType.setApellidos(item.getApellidos());
					objClienteType.setTipoDoc(item.getTipoDoc());
					objClienteType.setNumDoc(item.getNumDoc());
					objClienteType.setTipoPersona(item.getTipoPersona());
					objClienteType.setCategoria(item.getCategoria());
					objClienteType.setDireccion(item.getDireccion());
					objClienteType.setDistrito(item.getDistrito());
					objClienteType.setProvincia(item.getProvincia());
					objClienteType.setDepartamento(item.getDepartamento());
					objClienteType.setMail(item.getMail());
					objClienteType.setTelefReferencia(item.getTelefReferencia());
					objClienteType.setEstadoCliente(item.getEstadoCliente());
					objClienteType.setCorrespElectronica(item.getCorrespElectronica());
					objClienteType.setCodSuc(item.getCodSuc());
					objClienteType.setNumSlc(item.getNumSlc());
					listClienteType.add(objClienteType);
				}
				
				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF0CODIGO);
				objAuditResponseType.setMensajeRespuesta(objConsultarClienteResponse.getMsgRespuesta().trim().equals(PropertiesInternos.STRING_EMPTY) ? propiedadesExterna.IDF0MENSAJE : objConsultarClienteResponse.getMsgRespuesta());
				objAuditResponseType.setIdTransaccion(objConsultarClienteRequestType.getAuditRequest().getIdTransaccion());

				objListaClienteType.setCliente(listClienteType);

				response.setAuditResponse(objAuditResponseType);
				response.setListaCliente(objListaClienteType);
				response.setListaResponseOpcional(objParametrosType);

				// Registrar auditoria
				LOGGER.info(msgTransaccion + "--------- Inicio Registrar Auditoria ---------");
				registrarAuditoria(objConsultarClienteRequestType.getAuditRequest());
				LOGGER.info(msgTransaccion + "----------- Fin Registrar Auditoria ----------");
			}
		} catch (DBException ex) {
			objAuditResponseType.setIdTransaccion(objConsultarClienteRequestType.getAuditRequest().getIdTransaccion());
			objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
			objAuditResponseType.setMensajeRespuesta(ex.getMessage());
			response.setAuditResponse(objAuditResponseType);
			LOGGER.info(mensajeLog + "Exception de Base de Datos " + ex);
		} finally {
			LOGGER.info(mensajeLog + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(mensajeLog + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(mensajeLog + "===== FIN de la operacion " + metodo + " =====");
		}
		return response;
	}

	@Override
	public ConsultarClientePorNombreResponseType consultarClientePorNombre(ConsultarClientePorNombreRequestType objConsultarClientePorNombreRequestType) {

		final long tiempoInicial = System.currentTimeMillis();

		String metodo = "consultarClientePorNombre";
		String idTransaccion = objConsultarClientePorNombreRequestType.getAuditRequest().getIdTransaccion();
		String msgTransaccion = "[ " + metodo + " idTx=" + idTransaccion + " ] - ";
		String mensajeLog = idTransaccion + "[" + metodo + "]-";

		LOGGER.info(msgTransaccion + "===== INICIO de la operacion " + metodo + " =====");
		LOGGER.info(mensajeLog + "Datos de Request: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarClientePorNombreRequestType));
		LOGGER.info(mensajeLog + "Datos de HeaderRequest: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarClientePorNombreRequestType.getAuditRequest()));

		ConsultarClientePorNombreResponseType response = new ConsultarClientePorNombreResponseType();
		AuditResponseType objAuditResponseType = new AuditResponseType();
		ParametrosType objParametrosType = new ParametrosType();
		ClientePorNombreType objClientePorNombreType;
		List<ClientePorNombreType> listClientePorNombreType = new ArrayList<ClientePorNombreType>();
		try {
			ConsultarClientePorNombreResponse objConsultarClientePorNombreResponse = new ConsultarClientePorNombreResponse();
			ConsultarClientePorNombreResponse objConsultarClientePorNombreResponseBscs = new ConsultarClientePorNombreResponse();
			ConsultarClientePorNombreResponse objConsultarClientePorNombreResponseSga = new ConsultarClientePorNombreResponse();
			ConsultarClientePorNombreRequest objConsultarClientePorNombreRequest = new ConsultarClientePorNombreRequest();
			objConsultarClientePorNombreRequest.setTipobusqueda(objConsultarClientePorNombreRequestType.getTipoBusqueda());
			objConsultarClientePorNombreRequest.setValor_busqueda(objConsultarClientePorNombreRequestType.getValorBusqueda());
			
			objConsultarClientePorNombreResponseBscs = bscsDao.consultarClientePorNombre(idTransaccion, objConsultarClientePorNombreRequest);
			objConsultarClientePorNombreResponseSga = sgaDao.consultarClientePorNombre(idTransaccion, objConsultarClientePorNombreRequest);
			
			objConsultarClientePorNombreResponse = unificarClientePorNombre(objConsultarClientePorNombreResponseBscs, objConsultarClientePorNombreResponseSga);
			objConsultarClientePorNombreResponse = quitarDuplicadosClientePorNombre(objConsultarClientePorNombreResponse);
			
			if (objConsultarClientePorNombreResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
					|| objConsultarClientePorNombreResponse.getListClientePorNombre() == null) {
				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
				objAuditResponseType.setMensajeRespuesta(propiedadesExterna.IDF1MENSAJE
						.replace("$bd", propiedadesExterna.dbBSCSDB)
						.replace("$sp", propiedadesExterna.spSicess_customer_rs_nom)
						.replace("$cod", objConsultarClientePorNombreResponse.getCodRespuesta())
						.replace("$msg", objConsultarClientePorNombreResponse.getMsgRespuesta()));
				objAuditResponseType.setIdTransaccion(idTransaccion);
				
				response.setAuditResponse(objAuditResponseType);
				response.setListaResponseOpcional(objParametrosType);
				response.setListaClientePorNombre(listClientePorNombreType);
				LOGGER.info(msgTransaccion + "Datos de salida (responseTransacciones.getErrorMsg().equalsIgnoreCase): " + JAXBUtilitarios.anyObjectToXmlText(response));
				LOGGER.info(msgTransaccion + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
				LOGGER.info(msgTransaccion + "===== FIN de la operacion " + metodo + " =====");
			} else {
				for (ClientePorNombre item : objConsultarClientePorNombreResponse.getListClientePorNombre().getListClientePorNombre()) {
					objClientePorNombreType = new ClientePorNombreType();
					objClientePorNombreType.setNombres(item.getNombres());
					objClientePorNombreType.setApellidos(item.getApellidos());
					objClientePorNombreType.setCcname(item.getCcname());
					objClientePorNombreType.setTipoDoc(item.getTipoDoc());
					objClientePorNombreType.setNumDoc(item.getNumDoc());
					listClientePorNombreType.add(objClientePorNombreType);
				}

				objAuditResponseType.setCodigoRespuesta(objConsultarClientePorNombreResponse.getCodRespuesta());
				objAuditResponseType.setMensajeRespuesta(objConsultarClientePorNombreResponse.getMsgRespuesta().trim().equals(PropertiesInternos.STRING_EMPTY) ? propiedadesExterna.IDF0MENSAJE : objConsultarClientePorNombreResponse.getMsgRespuesta());
				objAuditResponseType.setIdTransaccion(idTransaccion);

				response.setAuditResponse(objAuditResponseType);
				response.setListaResponseOpcional(objParametrosType);
				response.setListaClientePorNombre(listClientePorNombreType);

			}
		} catch (DBException ex) {
			objAuditResponseType.setIdTransaccion(idTransaccion);
			objAuditResponseType.setCodigoRespuesta(ex.getCodError());
			objAuditResponseType.setMensajeRespuesta(ex.getMessage());
			response.setAuditResponse(objAuditResponseType);
			LOGGER.info(mensajeLog + "Exception de Base de Datos " + ex.getMessage());
		} finally {
			LOGGER.info(mensajeLog + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(mensajeLog + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(mensajeLog + "===== FIN de la operacion " + metodo + " =====");
		}

		return response;
	}

	@Override
	public ConsultarSucursalDetalleResponseType consultarSucursalDetalle(ConsultarSucursalDetalleRequestType objConsultarSucursalDetalleRequestType) {
		final long tiempoInicial = System.currentTimeMillis();

		String metodo = "consultarSucursalDetalle";
		String idTransaccion = objConsultarSucursalDetalleRequestType.getAuditRequest().getIdTransaccion();
		String msgTransaccion = "[ " + metodo + " idTx=" + idTransaccion + " ] - ";
		String mensajeLog = idTransaccion + "[" + metodo + "]-";

		LOGGER.info(msgTransaccion + "===== INICIO de la operacion " + metodo + " =====");
		LOGGER.info(mensajeLog + "Datos de Request: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarSucursalDetalleRequestType));

		ConsultarSucursalDetalleResponseType response = new ConsultarSucursalDetalleResponseType();
		AuditResponseType objAuditResponseType = new AuditResponseType();
		ParametrosType objParametrosType = new ParametrosType();
		ListaSucursalesType objListaSucursalesType = new ListaSucursalesType();
		
		List<SucursalType> listaSucursalesType = new ArrayList<>();
		
		try {
			ConsultarDetalleSucursalResponse objConsultarDetalleSucursalResponse = null;
			ConsultarDetalleSucursalDTHResponse objConsultarDetalleSucursalDTHResponse = null;
			
			LOGGER.info(msgTransaccion + "----- INICIO DE LA ACTIVIDAD 1. -----");
			ConsultarTecnologiaRequest objConsultarTecnologiaRequest = new ConsultarTecnologiaRequest(objConsultarSucursalDetalleRequestType.getNrodocumento());
			ConsultarTecnologiaResponse objConsultarTecnologiaResponse = bscsDao.consultarTecnologia(msgTransaccion, objConsultarTecnologiaRequest);
			
			listaSucursalesType = objConsultarTecnologiaResponse.getListaTecnologia().stream().map(t -> {
				SucursalType objSucursalType = new SucursalType();
				
				ListaServicioSucursalType listaServicioSucursalType = new ListaServicioSucursalType();
				List<ServicioSucursalType> listaServicioSucursal = new ArrayList<>();
				
				objSucursalType.setTecnologia(t.getTecnologia().trim());
				objSucursalType.setCustomerid(t.getCustomer_id());
				objSucursalType.setCoId(t.getCo_id());
				objSucursalType.setNumero(t.getNumero());
				objSucursalType.setCodigoPago(t.getNro_pago());
				objSucursalType.setDistrito(t.getDistrito());
				objSucursalType.setDireccion(t.getDireccion());
				objSucursalType.setEstado(t.getEstado());
				objSucursalType.setMotivoEstado(t.getMotivo_estado());
				
				if(t.getTecnologia().equalsIgnoreCase(Constantes.TECNOLOGIA_IFI)){
					objSucursalType.setPlataforma(Constantes.PLATAFORMA_IFI);
					objSucursalType.setCodcli(Constantes.constanteVacio);
					ServicioSucursalType servicioSucursal = new ServicioSucursalType();
					servicioSucursal.setTipoServicio(Constantes.EQUIPO_INTERNET);
					servicioSucursal.setServicio(t.getPlan());
					servicioSucursal.setValidoDesde(t.getValido_desde());
					listaServicioSucursal.add(servicioSucursal);
					listaServicioSucursalType.setServicioSucursal(listaServicioSucursal);
				}
				
				objSucursalType.setListaServicioSucursal(listaServicioSucursalType);

				return objSucursalType;
				
			}).collect(Collectors.toList());
			
			if(objConsultarTecnologiaResponse.getPo_sourceout().equalsIgnoreCase(Constantes.EJECUCION_CORRECTA_STRING) && 
					listaSucursalesType.size() > Constantes.CERO){
				
				LOGGER.info(msgTransaccion + "----- INICIO DE LA ACTIVIDAD 2. -----");
				listaSucursalesType.removeIf(t -> t.getEstado().equalsIgnoreCase(Constantes.ESTADO_CONTRATO));
				
				for (SucursalType sucursal : listaSucursalesType) {
					switch (sucursal.getTecnologia()) {

					case Constantes.TECNOLOGIA_HFC:
					case Constantes.TECNOLOGIA_LTE:
						ConsultarDetalleSucursalRequest objConsultarDetalleSucursalRequest = new ConsultarDetalleSucursalRequest(Double.valueOf(sucursal.getCustomerid()));
						objConsultarDetalleSucursalResponse = sgaDao.consultarDetalleSucursal(msgTransaccion, objConsultarDetalleSucursalRequest);
						
						sucursal.setCodcli(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getCodcli());
						sucursal.setCodsuc(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getCodsuc());
						sucursal.setNumSlc(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getNumslc());
						sucursal.setCodsolot(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getCodsolot());
						sucursal.setDireccion(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getDireccion());
						sucursal.setPlano(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getPlano());
						sucursal.setUbigeo(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getUbigeo());
						sucursal.setDepartamento(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getDepartamento());
						sucursal.setProvincia(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getProvincia());
						sucursal.setDistrito(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getDistrito());
						sucursal.setFlgPortable(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getFlg_portable());
						sucursal.setInternet(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getInternet());
						sucursal.setTelefonia(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getTelefonia());
						sucursal.setCable(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getCable());
						sucursal.setEstado(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getEstado());
						sucursal.setPlataforma(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getPlataforma());

						if (sucursal.getTecnologia().trim().equals(Constantes.TECNOLOGIA_HFC)) {
							sucursal.setTecnologia(objConsultarDetalleSucursalResponse.getListaDetalleSucursal().get(0).getTecnologia());
						}
						
						break;

					case Constantes.TECNOLOGIA_DTH:
						ConsultarDetalleSucursalDTHRequest objConsultarDetalleSucursalDTHRequest = new ConsultarDetalleSucursalDTHRequest(Double.valueOf(sucursal.getCoId()));
						objConsultarDetalleSucursalDTHResponse = sgaDao.consultarDetalleSucursalDTH(msgTransaccion, objConsultarDetalleSucursalDTHRequest);
						
						sucursal.setCodcli(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getCodcli());
						sucursal.setCodsuc(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getCodsuc());
						sucursal.setNumSlc(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getNumslc());
						sucursal.setDireccion(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getDireccion());
						sucursal.setCodsolot(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getCodsolot());
						sucursal.setUbigeo(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getUbigeo());
						sucursal.setDepartamento(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getDepartamento());
						sucursal.setProvincia(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getProvincia());
						sucursal.setDistrito(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getDistrito());
						sucursal.setInternet(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getInternet());
						sucursal.setTelefonia(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getTelefonia());
						sucursal.setCable(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getCable());
						sucursal.setPlataforma(objConsultarDetalleSucursalDTHResponse.getListaDetalleSucursalDTH().get(0).getPlataforma());
						
						break;

					default:
						LOGGER.error("La Tecnologia no ha podido ser identificada");

					}
				}				
			}
			
			LOGGER.info(msgTransaccion + "----- INICIO DE LA ACTIVIDAD 1.1 -----");
			ConsultarTecnologiaSGARequest objConsultarTecnologiaSGARequest = new ConsultarTecnologiaSGARequest(objConsultarSucursalDetalleRequestType.getNrodocumento());
			ConsultarTecnologiaSGAResponse objConsultarTecnologiaSGAResponse = sgaDao.consultarTecnologia(msgTransaccion, objConsultarTecnologiaSGARequest);
			
			LOGGER.info(msgTransaccion + "----- INICIO DE LA ACTIVIDAD 5 -----");			
			listaSucursalesType = joinResponses(listaSucursalesType, objConsultarTecnologiaSGAResponse);
			
			LOGGER.info(msgTransaccion + "----- INICIO DE LA ACTIVIDAD 6 -----");
			listaSucursalesType.stream().filter(s -> !Utilitarios.isNullOrBlankToString(s.getPlano()).equals(Constantes.constanteVacio)).forEach(s -> {
				ConsultarEstadoServiciosRequest objConsultarEstadoServiciosRequest = new ConsultarEstadoServiciosRequest(s);
				try {
					ConsultarEstadoServiciosResponse objConsultarEstadoServiciosResponse = sgaDao.consultarEstadoServicios(msgTransaccion, objConsultarEstadoServiciosRequest);
					s.setFaspid(objConsultarEstadoServiciosResponse.getListaEstadoServicio().stream().findFirst().map(EstadoServicio::getI_faspid).orElse(Constantes.constanteVacio));
					s.setFaspmessage(objConsultarEstadoServiciosResponse.getListaEstadoServicio().stream().findFirst().map(EstadoServicio::getV_faspmessage).orElse(Constantes.constanteVacio));
					s.setSeraffected(objConsultarEstadoServiciosResponse.getListaEstadoServicio().stream().findFirst().map(EstadoServicio::getV_seraffected).orElse(Constantes.constanteVacio));
				} catch (DBException e) {
					
				}
			});
			
			LOGGER.info(msgTransaccion + "----- INICIO DE LA ACTIVIDAD 7 -----");								
			listaSucursalesType.stream().forEach(s ->{
				ListaServicioSucursalType objListaServicioSucursal = new ListaServicioSucursalType();
				try {
					if(!s.getTecnologia().equals(Constantes.TECNOLOGIA_IFI)){
						ConsultarServicioSucursalRequest objConsultarServicioSucursalRequest = new ConsultarServicioSucursalRequest(s.getTecnologia(), s.getCodsolot());
						ConsultarServicioSucursalResponse objConsultarServicioSucursalResponse = sgaDao.consultarServicioSucursal(msgTransaccion, objConsultarServicioSucursalRequest);
						
						List<ServicioSucursalType> listaServicioSucursalType = objConsultarServicioSucursalResponse.getListaServicioSucursal().stream().map(c -> {
							ServicioSucursalType servicioSucursal = new ServicioSucursalType();
							servicioSucursal.setTipoServicio(c.getTipo_servicio());
							servicioSucursal.setCodigoServicio(c.getCodinssrv());
							servicioSucursal.setNumero(c.getNumero());
							servicioSucursal.setServicio(c.getServicio());
							servicioSucursal.setValidoDesde(c.getValido_desde());
							
							return servicioSucursal;
							
						}).collect(Collectors.toList());
						
						objListaServicioSucursal.setServicioSucursal(listaServicioSucursalType);
						s.setListaServicioSucursal(objListaServicioSucursal);
					}
					
				} catch (DBException e) {
					List<ServicioSucursalType> listaServicioSucursalType = new ArrayList<ServicioSucursalType>();
					objListaServicioSucursal.setServicioSucursal(listaServicioSucursalType);
					s.setListaServicioSucursal(objListaServicioSucursal);
				}
			});
			
			objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF0CODIGO);
			objAuditResponseType.setMensajeRespuesta(propiedadesExterna.IDF0MENSAJE);
			objAuditResponseType.setIdTransaccion(objConsultarSucursalDetalleRequestType.getAuditRequest().getIdTransaccion());
			
			objListaSucursalesType.setSucursal(listaSucursalesType);
			
			response.setAuditResponse(objAuditResponseType);
			response.setListaSucursal(objListaSucursalesType);
			response.setListaResponseOpcional(objParametrosType);
			
			
		} catch (DBException ex) {
			objAuditResponseType.setIdTransaccion(objConsultarSucursalDetalleRequestType.getAuditRequest().getIdTransaccion());
			objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
			objAuditResponseType.setMensajeRespuesta(ex.getMessage());
			response.setAuditResponse(objAuditResponseType);
			LOGGER.info(mensajeLog + "Exception de Base de Datos " + ex);
		} finally {
			LOGGER.info(mensajeLog + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(mensajeLog + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(mensajeLog + "===== FIN de la operacion " + metodo + " =====");
		}

		return response;
	}

	private List<SucursalType> joinResponses(List<SucursalType> listaSucursalesType,
			ConsultarTecnologiaSGAResponse objConsultarTecnologiaSGAResponse) {

		objConsultarTecnologiaSGAResponse.getListaTecnologiaSGA().stream().map(t -> {
			SucursalType objSucursalType = new SucursalType();

			objSucursalType.setTecnologia(t.getTecnologia());
			objSucursalType.setCodcli(t.getCodcli());
			objSucursalType.setCodsuc(t.getCodsuc());
			objSucursalType.setNumero(t.getNumero());
			objSucursalType.setCodigoPago(t.getNro_pago());
			objSucursalType.setNumSlc(t.getNumslc());
			objSucursalType.setCodsolot(t.getCodsolot());
			objSucursalType.setDireccion(t.getDireccion());
			objSucursalType.setPlano(t.getPlano());
			objSucursalType.setUbigeo(t.getUbigeo());
			objSucursalType.setDepartamento(t.getDepartamento());
			objSucursalType.setProvincia(t.getProvincia());
			objSucursalType.setDistrito(t.getDistrito());
			objSucursalType.setFlgPortable(t.getFlg_portable());
			objSucursalType.setInternet(t.getInternet());
			objSucursalType.setTelefonia(t.getTelefonia());
			objSucursalType.setCable(t.getCable());
			objSucursalType.setEstado(t.getEstado());
			objSucursalType.setPlataforma(t.getPlataforma());

			return objSucursalType;

		}).collect(Collectors.toCollection(() -> listaSucursalesType));

		return listaSucursalesType;
	}

	@Override
	public ConsultarJanusResponseType consultarJanus(HeaderRequest objHeaderRequest,
			ConsultarJanusRequestType objConsultarJanusRequestType, Holder<HeaderResponse> headerResponse) {

		final long tiempoInicial = System.currentTimeMillis();

		String metodo = "consultarJanus";
		String idTransaccion = objHeaderRequest.getIdESBTransaction();
		String msgTransaccion = "[ " + metodo + " idTx=" + idTransaccion + " ] - ";
		String mensajeLog = idTransaccion + "[" + metodo + "]-";

		LOGGER.info(msgTransaccion + "===== INICIO de la operacion " + metodo + " =====");
		LOGGER.info(mensajeLog + "Datos de Request: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarJanusRequestType));
		LOGGER.info(mensajeLog + "Datos de HeaderRequest: " + JAXBUtilitarios.anyObjectToXmlText(objHeaderRequest));

		ConsultarJanusResponseType response = new ConsultarJanusResponseType();
		ResponseStatus objResponseStatus = new ResponseStatus();
		ListaJanusType objListaJanusType = new ListaJanusType();
		JanusType objJanusType;
		List<JanusType> listJanusType = new ArrayList<JanusType>();

		HeaderResponse objHeaderRes = new HeaderResponse();
		XMLGregorianCalendar xgcal = JAXBUtilitarios.getXmlGregorianCalnedar();

		try {
			ConsultarJanusResponse objConsultarJanusResponse = new ConsultarJanusResponse();
			ConsultarJanusRequest objConsultarJanusRequest = new ConsultarJanusRequest();
			objConsultarJanusRequest.setSucursal(objConsultarJanusRequestType.getSucursal());
			objConsultarJanusResponse = sgaDao.consultarJanus(idTransaccion, objConsultarJanusRequest);

			if (objConsultarJanusResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
					|| objConsultarJanusResponse.getListJanus() == null) {
				objResponseStatus.setCodeResponse(propiedadesExterna.IDF1CODIGO);
				objResponseStatus.setDescriptionResponse(propiedadesExterna.IDF1MENSAJE
						.replace("$bd", propiedadesExterna.dbSGADB)
						.replace("$sp", propiedadesExterna.spSicess_Janus)
						.replace("$cod", objConsultarJanusResponse.getCodRespuesta())
						.replace("$msg", objConsultarJanusResponse.getMsgRespuesta()));
				response.setResponseStatus(objResponseStatus);
				response.setResponseData(objListaJanusType);

				LOGGER.info(msgTransaccion + "Datos de salida (responseTransacciones.getErrorMsg().equalsIgnoreCase): " + JAXBUtilitarios.anyObjectToXmlText(response));
				LOGGER.info(msgTransaccion + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
				LOGGER.info(msgTransaccion + "===== FIN de la operacion " + metodo + " =====");
			} else {
				for (Janus item : objConsultarJanusResponse.getListJanus().getListJanus()) {
					objJanusType = new JanusType();
					objJanusType.setNumero(item.getNumero());
					objJanusType.setCustomerid(item.getCustomerid());
					objJanusType.setCodPlan(item.getCodPlan());
					objJanusType.setProducto(item.getProducto());
					objJanusType.setTipoPlan(item.getTipoPlan());
					objJanusType.setFecIni(item.getFecIni());
					objJanusType.setFlgEstado(item.getFlgEstado());
					objJanusType.setEstado(item.getEstado());
					objJanusType.setCiclo(item.getCiclo());
					listJanusType.add(objJanusType);
				}

				objResponseStatus.setCodeResponse(objConsultarJanusResponse.getCodRespuesta());
				objResponseStatus.setDescriptionResponse(objConsultarJanusResponse.getMsgRespuesta().trim().equals(PropertiesInternos.STRING_EMPTY) ? propiedadesExterna.IDF0MENSAJE : objConsultarJanusResponse.getMsgRespuesta());
				objResponseStatus.setStatus(Integer.valueOf(propiedadesExterna.IDF0CODIGO));
				objResponseStatus.setDate(xgcal);

				objListaJanusType.setListaJanus(listJanusType);

				response.setResponseStatus(objResponseStatus);
				response.setResponseData(objListaJanusType);

				LOGGER.info(msgTransaccion + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
				LOGGER.info(msgTransaccion + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
				LOGGER.info(msgTransaccion + "===== FIN de la operacion " + metodo + " =====");
			}
		} catch (DBException ex) {
			objResponseStatus.setStatus(Integer.parseInt((propiedadesExterna.IDF1CODIGO)));
			objResponseStatus.setCodeResponse(ex.getCodError());
			objResponseStatus.setDescriptionResponse(ex.getMessage());
			objResponseStatus.setDate(xgcal);
			response.setResponseStatus(objResponseStatus);
			LOGGER.info(mensajeLog + "Exception de Base de Datos " + ex.getMessage());
		} finally {
			objHeaderRes.setIdBusinessTransaction(objHeaderRequest.getIdBusinessTransaction());
			objHeaderRes.setIdESBTransaction(objHeaderRequest.getIdESBTransaction());
			objHeaderRes.setStartDate(objHeaderRequest.getStartDate());
			objHeaderRes.setEndDate(xgcal);

			headerResponse.value = objHeaderRes;
			LOGGER.info(mensajeLog + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(mensajeLog + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(mensajeLog + "===== FIN de la operacion " + metodo + " =====");
		}

		return response;
	}

	@Override
	public void registrarAuditoria(AuditRequestType objAuditRequestType) {
		final long tiempoInicial = System.currentTimeMillis();

		String metodo = "registrarAuditoria";
		String idTransaccion = objAuditRequestType.getIdTransaccion();
		String msgTransaccion = "[ " + metodo + " idTx=" + idTransaccion + " ] - ";
		String mensajeLog = idTransaccion + "[" + metodo + "]-";

		LOGGER.info(msgTransaccion + "===== INICIO de la operacion " + metodo + " =====");
		LOGGER.info(mensajeLog + "Datos de HeaderRequest: " + JAXBUtilitarios.anyObjectToXmlText(objAuditRequestType));

		ConsultarClienteResponseType response = new ConsultarClienteResponseType();
		AuditResponseType objAuditResponseType = new AuditResponseType();

		XMLGregorianCalendar xgcal = JAXBUtilitarios.getXmlGregorianCalnedar();

		try {
			RegistrarAuditoriaResponse objRegistrarAuditoriaResponse = new RegistrarAuditoriaResponse();
			RegistrarAuditoriaRequest objRegistrarAuditoriaRequest = new RegistrarAuditoriaRequest();
			objRegistrarAuditoriaRequest.setUserApplication(objAuditRequestType.getUsuarioAplicacion());
			//objRegistrarAuditoriaRequest.setUserSession(objAuditRequestType.getUsuarioAplicacion());
			objRegistrarAuditoriaRequest.setIdESBTransaction(objAuditRequestType.getIdTransaccion());
			objRegistrarAuditoriaResponse = sgaDao.registrarAuditoria(idTransaccion, objRegistrarAuditoriaRequest);

			if (objRegistrarAuditoriaResponse.getCodRespuesta().equalsIgnoreCase("-1")) {
				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
				objAuditResponseType.setMensajeRespuesta(propiedadesExterna.IDF1MENSAJE
						.replace("$bd", propiedadesExterna.dbSGADB)
						.replace("$sp", propiedadesExterna.spSicess_Auditoria)
						.replace("$cod", objRegistrarAuditoriaResponse.getCodRespuesta())
						.replace("$msg", objRegistrarAuditoriaResponse.getMsgRespuesta()));
				objAuditResponseType.setIdTransaccion(objAuditRequestType.getIdTransaccion());
				
				response.setAuditResponse(objAuditResponseType);
			} else {				
				objAuditResponseType.setCodigoRespuesta(objRegistrarAuditoriaResponse.getCodRespuesta());
				objAuditResponseType.setMensajeRespuesta(objRegistrarAuditoriaResponse.getMsgRespuesta().trim().equals(PropertiesInternos.STRING_EMPTY) ? propiedadesExterna.IDF0MENSAJE : objRegistrarAuditoriaResponse.getMsgRespuesta());
				objAuditResponseType.setIdTransaccion(objAuditRequestType.getIdTransaccion());

				response.setAuditResponse(objAuditResponseType);
			}
		} catch (DBException ex) {			
			objAuditResponseType.setIdTransaccion(objAuditRequestType.getIdTransaccion());
			objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
			objAuditResponseType.setMensajeRespuesta(ex.getMessage());
			response.setAuditResponse(objAuditResponseType);
			LOGGER.info(mensajeLog + "Exception de Base de Datos " + ex);
		} finally {
			LOGGER.info(mensajeLog + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(mensajeLog + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(mensajeLog + "===== FIN de la operacion " + metodo + " =====");
		}
	}

	@Override
	public ConsultarServicioResponseType consultarServicio(ConsultarServicioRequestType objConsultarServicioRequestType) {
		final long tiempoInicial = System.currentTimeMillis();

		String metodo = "consultarServicio";
		String idTransaccion = objConsultarServicioRequestType.getAuditRequest().getIdTransaccion();
		String msgTransaccion = "[ " + metodo + " idTx=" + idTransaccion + " ] - ";
		String mensajeLog = idTransaccion + "[" + metodo + "]-";

		LOGGER.info(msgTransaccion + "===== INICIO de la operacion " + metodo + " =====");
		LOGGER.info(mensajeLog + "Datos de Request: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarServicioRequestType));

		ConsultarServicioResponseType response = new ConsultarServicioResponseType();
		AuditResponseType objAuditResponseType = new AuditResponseType();
		ListaServicioType objListaServicioType = new ListaServicioType();
		ParametrosType objParametrosType = new ParametrosType();
		ServicioType objServicioType;
		List<ServicioType> listServicioType = new ArrayList<ServicioType>();

		try {			
			ConsultarServicioRequest objConsultarServicioRequest = new ConsultarServicioRequest(objConsultarServicioRequestType, propiedadesExterna.plataformaSga, propiedadesExterna.plataformaBscs);
			ConsultarServicioResponse objConsultarServicioResponse = new ConsultarServicioResponse();

			switch (objConsultarServicioRequest.getCodplataforma()) {
				case 0: {
					objConsultarServicioResponse = sgaDao.consultarServicio(idTransaccion, objConsultarServicioRequest);
					break;
				}
				case 1: {
					objConsultarServicioResponse = bscsDao.consultarServicio(idTransaccion, objConsultarServicioRequest);
					break;
				}
				case -1: {
					String strMsg = "Se requiere el valor de PLATAFORMA [" + propiedadesExterna.plataformaBscs + " o " + propiedadesExterna.plataformaSga + "]";
					LOGGER.info(mensajeLog + strMsg);
					objConsultarServicioResponse.setCodRespuesta(propiedadesExterna.IDF1CODIGO);
					objConsultarServicioResponse.setMsgRespuesta(strMsg);
					objConsultarServicioResponse.setListServicio(null);
					break;
				}
			}

			if (objConsultarServicioResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO) || objConsultarServicioResponse.getListServicio() == null) {
				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
				objAuditResponseType.setMensajeRespuesta(propiedadesExterna.IDF1MENSAJE
						.replace("$bd", objConsultarServicioRequest.getCodplataforma() == 0 ? propiedadesExterna.dbSGADB : propiedadesExterna.dbBSCSDB)
						.replace("$sp", objConsultarServicioRequest.getCodplataforma() == 0 ? propiedadesExterna.spSicess_servicesga : propiedadesExterna.spSicess_servicebscs)
						.replace("$cod", objConsultarServicioResponse.getCodRespuesta())
						.replace("$msg", objConsultarServicioResponse.getMsgRespuesta()));
				objAuditResponseType.setIdTransaccion(objConsultarServicioRequestType.getAuditRequest().getIdTransaccion());
				
				response.setAuditResponse(objAuditResponseType);
				response.setListaServicio(objListaServicioType);
				response.setListaResponseOpcional(objParametrosType);
				
			} else {
				for (Servicio item : objConsultarServicioResponse.getListServicio().getListServicio()) {
					objServicioType = new ServicioType();					
					objServicioType.setGrupo(item.getGrupo());
					objServicioType.setServicio(item.getServicio());
					objServicioType.setEstado(item.getEstado());
					objServicioType.setValidoDesde(item.getValidoDesde());
					objServicioType.setTipoServicio(item.getTipoServicio());
					objServicioType.setCodBloqueo(item.getCodBloqueo());
					objServicioType.setBloqueo(item.getBloqueo());
					objServicioType.setCargoFijo(item.getCargoFijo());
					listServicioType.add(objServicioType);
				}

				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF0CODIGO);
				objAuditResponseType.setMensajeRespuesta(objConsultarServicioResponse.getMsgRespuesta().trim().equals(PropertiesInternos.STRING_EMPTY) ? propiedadesExterna.IDF0MENSAJE : objConsultarServicioResponse.getMsgRespuesta());
				objAuditResponseType.setIdTransaccion(objConsultarServicioRequestType.getAuditRequest().getIdTransaccion());

				objListaServicioType.setServicio(listServicioType);	
				
				response.setAuditResponse(objAuditResponseType);
				response.setListaServicio(objListaServicioType);
				response.setListaResponseOpcional(objParametrosType);
			}
		} catch (DBException ex) {
			objAuditResponseType.setIdTransaccion(objConsultarServicioRequestType.getAuditRequest().getIdTransaccion());
			objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
			objAuditResponseType.setMensajeRespuesta(ex.getMessage());
			response.setAuditResponse(objAuditResponseType);
			LOGGER.info(mensajeLog + "Exception de Base de Datos " + ex.getMessage());
		} finally {
			LOGGER.info(mensajeLog + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(mensajeLog + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(mensajeLog + "===== FIN de la operacion " + metodo + " =====");
		}

		return response;
	}

	@Override
	public ConsultarSeaChangeResponseType consultarSeaChange(HeaderRequest objHeaderRequest,
			ConsultarSeaChangeRequestType objConsultarSeaChangeRequestType, Holder<HeaderResponse> headerResponse) {

		final long tiempoInicial = System.currentTimeMillis();

		String metodo = "consultarSeaChange";
		String idTransaccion = objHeaderRequest.getIdESBTransaction();
		String msgTransaccion = "[ " + metodo + " idTx=" + idTransaccion + " ] - ";
		String mensajeLog = idTransaccion + "[" + metodo + "]-";

		LOGGER.info(msgTransaccion + "===== INICIO de la operacion " + metodo + " =====");
		LOGGER.info(mensajeLog + "Datos de Request: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarSeaChangeRequestType));
		LOGGER.info(mensajeLog + "Datos de HeaderRequest: " + JAXBUtilitarios.anyObjectToXmlText(objHeaderRequest));

		ConsultarSeaChangeResponseType response = new ConsultarSeaChangeResponseType();
		ResponseStatus objResponseStatus = new ResponseStatus();
		ListaSeaChangeType objListaSeaChangeType = new ListaSeaChangeType();
		SeaChangeType objSeaChangeType;
		List<SeaChangeType> listSeaChangeType = new ArrayList<SeaChangeType>();

		HeaderResponse objHeaderRes = new HeaderResponse();
		XMLGregorianCalendar xgcal = JAXBUtilitarios.getXmlGregorianCalnedar();

		try {
			ConsultarSeaChangeResponse objConsultarSeaChangeResponse = new ConsultarSeaChangeResponse();
			ConsultarSeaChangeRequest objConsultarSeaChangeRequest = new ConsultarSeaChangeRequest();
			objConsultarSeaChangeRequest.setClientId(objConsultarSeaChangeRequestType.getClientId());
			objConsultarSeaChangeRequest.setPlatform(objConsultarSeaChangeRequestType.getPlatform());
			objConsultarSeaChangeResponse = sgaDao.consultarSeaChange(idTransaccion, objConsultarSeaChangeRequest);

			if (objConsultarSeaChangeResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
					|| objConsultarSeaChangeResponse.getListSeaChange() == null) {
				objResponseStatus.setCodeResponse(propiedadesExterna.IDF1CODIGO);
				objResponseStatus.setDescriptionResponse(propiedadesExterna.IDF1MENSAJE
						.replace("$bd", propiedadesExterna.dbSGADB)
						.replace("$sp", propiedadesExterna.spSicess_seaChange)
						.replace("$cod", objConsultarSeaChangeResponse.getCodRespuesta())
						.replace("$msg", objConsultarSeaChangeResponse.getMsgRespuesta()));
				response.setResponseStatus(objResponseStatus);
				response.setResponseData(objListaSeaChangeType);

				LOGGER.info(msgTransaccion + "Datos de salida (responseTransacciones.getErrorMsg().equalsIgnoreCase): " + JAXBUtilitarios.anyObjectToXmlText(response));
				LOGGER.info(msgTransaccion + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
				LOGGER.info(msgTransaccion + "===== FIN de la operacion " + metodo + " =====");
			} else {
				for (SeaChange item : objConsultarSeaChangeResponse.getListSeaChange().getListSeaChange()) {
					objSeaChangeType = new SeaChangeType();
					objSeaChangeType.setClientId(item.getClientId());
					objSeaChangeType.setCredit(item.getCredit());
					objSeaChangeType.setMac(item.getMac());
					objSeaChangeType.setSerialNumber(item.getSerialNumber());
					objSeaChangeType.setLoadDate(item.getLoadDate());
					objSeaChangeType.setPlatformType(item.getPlatformType());
					listSeaChangeType.add(objSeaChangeType);
				}

				objResponseStatus.setCodeResponse(objConsultarSeaChangeResponse.getCodRespuesta());
				objResponseStatus.setDescriptionResponse(objConsultarSeaChangeResponse.getMsgRespuesta().trim().equals(PropertiesInternos.STRING_EMPTY) ? propiedadesExterna.IDF0MENSAJE : objConsultarSeaChangeResponse.getMsgRespuesta());
				objResponseStatus.setStatus(Integer.valueOf(propiedadesExterna.IDF0CODIGO));
				objResponseStatus.setDate(xgcal);

				objListaSeaChangeType.setListaSeaChange(listSeaChangeType);

				response.setResponseStatus(objResponseStatus);
				response.setResponseData(objListaSeaChangeType);

				LOGGER.info(msgTransaccion + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
				LOGGER.info(msgTransaccion + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
				LOGGER.info(msgTransaccion + "===== FIN de la operacion " + metodo + " =====");
			}
		} catch (DBException ex) {
			objResponseStatus.setStatus(Integer.parseInt((propiedadesExterna.IDF1CODIGO)));
			objResponseStatus.setCodeResponse(ex.getCodError());
			objResponseStatus.setDescriptionResponse(ex.getMessage());
			objResponseStatus.setDate(xgcal);
			response.setResponseStatus(objResponseStatus);
			LOGGER.info(mensajeLog + "Exception de Base de Datos " + ex.getMessage());
		} finally {
			objHeaderRes.setIdBusinessTransaction(objHeaderRequest.getIdBusinessTransaction());
			objHeaderRes.setIdESBTransaction(objHeaderRequest.getIdESBTransaction());
			objHeaderRes.setStartDate(objHeaderRequest.getStartDate());
			objHeaderRes.setEndDate(xgcal);

			headerResponse.value = objHeaderRes;
			LOGGER.info(mensajeLog + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(mensajeLog + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(mensajeLog + "===== FIN de la operacion " + metodo + " =====");
		}

		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsultarInteraccionCasosResponseType consultarInteraccionCasos(ConsultarInteraccionCasosRequestType objConsultarInteraccionCasosRequestType) {

		final long tiempoInicial = System.currentTimeMillis();

		String metodo = "consultarInteraccionCasos";
		String idTransaccion = objConsultarInteraccionCasosRequestType.getAuditRequest().getIdTransaccion();
		String msgTransaccion = "[ " + metodo + " idTx=" + idTransaccion + " ] - ";
		String mensajeLog = idTransaccion + "[" + metodo + "]-";

		LOGGER.info(msgTransaccion + "===== INICIO de la operacion " + metodo + " =====");
		LOGGER.info(mensajeLog + "Datos de Request: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarInteraccionCasosRequestType));

		ConsultarInteraccionCasosResponseType response = new ConsultarInteraccionCasosResponseType();
		List<DatosInfVarType> listDatosInfVarType = new ArrayList<DatosInfVarType>();
		List<DatosSotType> listDatosSotType = new ArrayList<DatosSotType>();
		List<DatosIncidenciaType> listDatosIncidenciaType = new ArrayList<DatosIncidenciaType>();
		List<DatosProblemaType> listDatosProblemaType = new ArrayList<DatosProblemaType>();

		AuditResponseType objAuditResponseType = new AuditResponseType();
		ParametrosType objParametrosType = new ParametrosType();
		boolean cursorVacio = true;
		List<Integer> errorCode = new ArrayList<>();
		String msgError = Constantes.constanteVacio;

		try {
			ConsultarInteraccionCasosResponse objConsultarInteraccionCasosResponse = new ConsultarInteraccionCasosResponse();
			ConsultarInteraccionCasosRequest objConsultarInteraccionCasosRequest = new ConsultarInteraccionCasosRequest(objConsultarInteraccionCasosRequestType);
			switch (objConsultarInteraccionCasosRequest.getCodProceso()) {
			case 0: {
				objConsultarInteraccionCasosRequest.setPlataforma(propiedadesExterna.dbCLARIFYDB);
				objConsultarInteraccionCasosRequest.setStoreProcedure(propiedadesExterna.spQuery_interact_hfc);
				objConsultarInteraccionCasosResponse = clarifyDao.consultarInformacionVariacion(idTransaccion, objConsultarInteraccionCasosRequest);

				if (objConsultarInteraccionCasosResponse.getListDatosInfVar() != null) {
					listDatosInfVarType = ((ArrayList<DatosInfVarType>) listasInteraccionesCasos(objConsultarInteraccionCasosRequest.getCodProceso(), objConsultarInteraccionCasosResponse));
					errorCode.add(Constantes.EJECUCION_CORRECTA);
					response.setListaDatosInfVar(listDatosInfVarType);
				}
				break;
			}
			case 1: {
				objConsultarInteraccionCasosRequest.setPlataforma(propiedadesExterna.dbSGADB);
				objConsultarInteraccionCasosRequest.setStoreProcedure(propiedadesExterna.spSicess_Solot_Cliente);
				objConsultarInteraccionCasosResponse = sgaDao.consultarSot(idTransaccion, objConsultarInteraccionCasosRequest);

				if (objConsultarInteraccionCasosResponse.getListDatosSot() != null) {
					listDatosSotType = ((ArrayList<DatosSotType>) listasInteraccionesCasos(objConsultarInteraccionCasosRequest.getCodProceso(), objConsultarInteraccionCasosResponse));
					errorCode.add(Constantes.EJECUCION_CORRECTA);
					response.setListaDatosSot(listDatosSotType);
				}
				break;
			}
			case 2: {
				objConsultarInteraccionCasosRequest.setPlataforma(propiedadesExterna.dbSGADB);
				objConsultarInteraccionCasosRequest.setStoreProcedure(propiedadesExterna.spSicess_Incidencia);
				objConsultarInteraccionCasosResponse = sgaDao.consultarIncidencia(idTransaccion, objConsultarInteraccionCasosRequest);

				if (objConsultarInteraccionCasosResponse.getListDatosIncidencia() != null) {
					listDatosIncidenciaType = ((ArrayList<DatosIncidenciaType>) listasInteraccionesCasos(objConsultarInteraccionCasosRequest.getCodProceso(), objConsultarInteraccionCasosResponse));
					errorCode.add(Constantes.EJECUCION_CORRECTA);
					response.setListaDatosIncidencia(listDatosIncidenciaType);
				}
				break;
			}
			case 3: {
				objConsultarInteraccionCasosRequest.setPlataforma(propiedadesExterna.dbCLARIFYDB);
				objConsultarInteraccionCasosRequest.setStoreProcedure(propiedadesExterna.spQuery_case_hfc);
				objConsultarInteraccionCasosResponse = clarifyDao.consultarProblemas(idTransaccion, objConsultarInteraccionCasosRequest);

				if (objConsultarInteraccionCasosResponse.getListDatosProblema() != null) {
					listDatosProblemaType = ((ArrayList<DatosProblemaType>) listasInteraccionesCasos(objConsultarInteraccionCasosRequest.getCodProceso(), objConsultarInteraccionCasosResponse));
					errorCode.add(Constantes.EJECUCION_CORRECTA);
					response.setListaDatosProblema(listDatosProblemaType);
				}
				break;
			}
			case 4: {				
				if(objConsultarInteraccionCasosRequestType.getPlataforma().equals(Constantes.PLATAFORMA_IFI)){
					objConsultarInteraccionCasosResponse = new ConsultarInteraccionCasosResponse();
					objConsultarInteraccionCasosRequest.setPlataforma(propiedadesExterna.dbCLARIFYDB);
					objConsultarInteraccionCasosRequest.setStoreProcedure(propiedadesExterna.spQuery_interact_hfc);
					objConsultarInteraccionCasosResponse = clarifyDao.consultarInformacionVariacion(idTransaccion, objConsultarInteraccionCasosRequest);
					
					if (objConsultarInteraccionCasosResponse.getCodRespuesta().equalsIgnoreCase(Constantes.FLAG_EXITO)) {
						listDatosInfVarType = ((ArrayList<DatosInfVarType>) listasInteraccionesCasos(0, objConsultarInteraccionCasosResponse));
						response.setListaDatosInfVar(listDatosInfVarType);
						errorCode.add(Constantes.EJECUCION_CORRECTA);
					} else {
						errorCode.add(Constantes.EJECUCION_CON_ERRORES);
						msgError = propiedadesExterna.IDF1MENSAJE
								.replace("$bd", objConsultarInteraccionCasosRequest.getPlataforma())
								.replace("$sp", objConsultarInteraccionCasosRequest.getStoreProcedure())
								.replace("$cod", objConsultarInteraccionCasosResponse.getCodRespuesta())
								.replace("$msg", objConsultarInteraccionCasosResponse.getMsgRespuesta());
					}
				}

				objConsultarInteraccionCasosResponse = new ConsultarInteraccionCasosResponse();
				objConsultarInteraccionCasosRequest.setPlataforma(propiedadesExterna.dbSGADB);
				objConsultarInteraccionCasosRequest.setStoreProcedure(propiedadesExterna.spSicess_Solot_Cliente);
				objConsultarInteraccionCasosResponse = sgaDao.consultarSot(idTransaccion, objConsultarInteraccionCasosRequest);
				
				if (objConsultarInteraccionCasosResponse.getListDatosSot() != null) {
					listDatosSotType = ((ArrayList<DatosSotType>) listasInteraccionesCasos(1, objConsultarInteraccionCasosResponse));
					response.setListaDatosSot(listDatosSotType);
					errorCode.add(Constantes.EJECUCION_CORRECTA);
				} else {
					errorCode.add(Constantes.EJECUCION_CON_ERRORES);
					msgError = msgError + Constantes.ESPACIO + PropertiesInternos.STICK + propiedadesExterna.IDF1MENSAJE
									.replace("$bd", objConsultarInteraccionCasosRequest.getPlataforma())
									.replace("$sp", objConsultarInteraccionCasosRequest.getStoreProcedure())
									.replace("$cod", objConsultarInteraccionCasosResponse.getCodRespuesta())
									.replace("$msg", objConsultarInteraccionCasosResponse.getMsgRespuesta());
				}

				if (!objConsultarInteraccionCasosRequest.getTipoPlataforma().equals(Constantes.PLATAFORMA_IFI)) {
					objConsultarInteraccionCasosResponse = new ConsultarInteraccionCasosResponse();
					objConsultarInteraccionCasosRequest.setPlataforma(propiedadesExterna.dbSGADB);
					objConsultarInteraccionCasosRequest.setStoreProcedure(propiedadesExterna.spSicess_Incidencia);
					objConsultarInteraccionCasosResponse = sgaDao.consultarIncidencia(idTransaccion, objConsultarInteraccionCasosRequest);
					
					if (objConsultarInteraccionCasosResponse.getListDatosIncidencia() != null) {
						listDatosIncidenciaType = ((ArrayList<DatosIncidenciaType>) listasInteraccionesCasos(2, objConsultarInteraccionCasosResponse));
						response.setListaDatosIncidencia(listDatosIncidenciaType);
						errorCode.add(Constantes.EJECUCION_CORRECTA);
					} else {
						errorCode.add(Constantes.EJECUCION_CON_ERRORES);
						msgError = msgError + Constantes.ESPACIO + PropertiesInternos.STICK + propiedadesExterna.IDF1MENSAJE
										.replace("$bd", objConsultarInteraccionCasosRequest.getPlataforma())
										.replace("$sp", objConsultarInteraccionCasosRequest.getStoreProcedure())
										.replace("$cod", objConsultarInteraccionCasosResponse.getCodRespuesta())
										.replace("$msg", objConsultarInteraccionCasosResponse.getMsgRespuesta());
					}
				}

				objConsultarInteraccionCasosResponse = new ConsultarInteraccionCasosResponse();
				objConsultarInteraccionCasosRequest.setPlataforma(propiedadesExterna.dbCLARIFYDB);
				objConsultarInteraccionCasosRequest.setStoreProcedure(propiedadesExterna.spQuery_case_hfc);
				objConsultarInteraccionCasosResponse = clarifyDao.consultarProblemas(idTransaccion, objConsultarInteraccionCasosRequest);
				
				if (objConsultarInteraccionCasosResponse.getListDatosProblema() != null) {
					listDatosProblemaType = ((ArrayList<DatosProblemaType>) listasInteraccionesCasos(3, objConsultarInteraccionCasosResponse));
					response.setListaDatosProblema(listDatosProblemaType);
					errorCode.add(Constantes.EJECUCION_CORRECTA);
				} else {
					errorCode.add(Constantes.EJECUCION_CON_ERRORES);
					msgError = msgError + Constantes.ESPACIO + PropertiesInternos.STICK + propiedadesExterna.IDF1MENSAJE
									.replace("$bd", objConsultarInteraccionCasosRequest.getPlataforma())
									.replace("$sp", objConsultarInteraccionCasosRequest.getStoreProcedure())
									.replace("$cod", objConsultarInteraccionCasosResponse.getCodRespuesta())
									.replace("$msg", objConsultarInteraccionCasosResponse.getMsgRespuesta());
				}

				//objConsultarInteraccionCasosResponse.setMsgRespuesta(msg);				
				break;
			}
			case -1: {
				objConsultarInteraccionCasosRequest.setPlataforma(PropertiesInternos.STRING_EMPTY);
				objConsultarInteraccionCasosRequest.setStoreProcedure(PropertiesInternos.STRING_EMPTY);
				String strMsg = "Se requiere un tipo de INTERACCI�N [INFORMACION: " + Constantes.INTERACCION_INFORMACION
						+ ", " + "VARIACION: " + Constantes.INTERACCION_VARIACION + ", " + "SOT: "
						+ Constantes.INTERACCION_SOT + ", " + "INCIDENCIAS: " + Constantes.INTERACCION_INCIDENCIAS
						+ ", " + "PROBLEMAS: " + Constantes.INTERACCION_PROBLEMAS + ", " + "TODOS: "
						+ Constantes.INTERACCION_TODOS + "]";
				LOGGER.info(mensajeLog + strMsg);
				objConsultarInteraccionCasosResponse.setCodRespuesta(propiedadesExterna.IDF1CODIGO);
				objConsultarInteraccionCasosResponse.setMsgRespuesta(strMsg);
				objConsultarInteraccionCasosResponse.setListDatosInfVar(null);
				objConsultarInteraccionCasosResponse.setListDatosSot(null);
				objConsultarInteraccionCasosResponse.setListDatosIncidencia(null);
				objConsultarInteraccionCasosResponse.setListDatosProblema(null);
				break;
			}
			}

			objAuditResponseType.setIdTransaccion(idTransaccion);
			
			boolean listaError = errorCode.contains(1);
			
			if(listaError){
				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
				objAuditResponseType.setMensajeRespuesta(msgError);
			} else{
				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF0CODIGO);
				objAuditResponseType.setMensajeRespuesta(propiedadesExterna.IDF0MENSAJE);
			}

		} catch (DBException ex) {
			objAuditResponseType.setIdTransaccion(idTransaccion);
			objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
			objAuditResponseType.setMensajeRespuesta(ex.getMessage());
			LOGGER.info(mensajeLog + "Exception de Base de Datos " + ex);
		} finally {
			response.setListaResponseOpcional(objParametrosType);
			response.setAuditResponse(objAuditResponseType);
			LOGGER.info(mensajeLog + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(mensajeLog + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(mensajeLog + "===== FIN de la operacion " + metodo + " =====");
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	public Object listasInteraccionesCasos(int listType, ConsultarInteraccionCasosResponse objConsultarInteraccionCasosResponse) {
		Object myList = null;
		switch (listType) {
			case 0: {
				DatosInfVarType objDatosInfVarType;
				myList = new ArrayList<DatosInfVarType>();
				for (DatosInfVar item : objConsultarInteraccionCasosResponse.getListDatosInfVar().getListDatosInfVar()) {
					objDatosInfVarType = new DatosInfVarType();
					objDatosInfVarType.setInteraccion(item.getInteraccion());
					objDatosInfVarType.setFecCreacion(item.getFecCreacion());
					objDatosInfVarType.setFecInicio(item.getFecInicio());
					objDatosInfVarType.setTelefono(item.getTelefono());
					objDatosInfVarType.setTipo(item.getTipo());
					objDatosInfVarType.setClase(item.getClase());
					objDatosInfVarType.setSubClase(item.getSubClase());
					objDatosInfVarType.setTipificacion(item.getTipificacion());
					objDatosInfVarType.setTipoCodigo(item.getTipoCodigo());
					objDatosInfVarType.setClaseCodigo(item.getClaseCodigo());
					objDatosInfVarType.setSubClaseCodigo(item.getSubClaseCodigo());
					objDatosInfVarType.setInsertadoPor(item.getInsertadoPor());
					objDatosInfVarType.setTipoInter(item.getTipoInter());
					objDatosInfVarType.setMetodo(item.getMetodo());
					objDatosInfVarType.setResultado(item.getResultado());
					objDatosInfVarType.setHechoEnUno(item.getHechoEnUno());
					objDatosInfVarType.setAgente(item.getAgente());
					objDatosInfVarType.setNombreAgente(item.getNombreAgente());
					objDatosInfVarType.setApellidoAgente(item.getApellidoAgente());
					objDatosInfVarType.setIdCaso(item.getIdCaso());
					objDatosInfVarType.setEstado(item.getEstado());
					objDatosInfVarType.setServicio(item.getServicio());
					objDatosInfVarType.setInconveniente(item.getInconveniente());
					objDatosInfVarType.setContrato(item.getContrato());
					objDatosInfVarType.setPlano(item.getPlano());
					objDatosInfVarType.setPlataforma(item.getPlataforma());
					((ArrayList<DatosInfVarType>) myList).add(objDatosInfVarType);
				}
				break;
			}
			case 1: {
				DatosSotType objDatosSotType;
				myList = new ArrayList<DatosSotType>();
				for (DatosSot item : objConsultarInteraccionCasosResponse.getListDatosSot().getListDatosSot()) {
					objDatosSotType = new DatosSotType();
					objDatosSotType.setFecRegistro(item.getFecRegistro());
					objDatosSotType.setUsuRegistro(item.getUsuRegistro());
					objDatosSotType.setCodSolot(item.getCodSolot());
					objDatosSotType.setCodTipoTrabajo(item.getCodTipoTrabajo());
					objDatosSotType.setTipoTrabajo(item.getTipoTrabajo());
					objDatosSotType.setCliente(item.getCliente());
					objDatosSotType.setCodMotivo(item.getCodMotivo());
					objDatosSotType.setMotivo(item.getMotivo());
					objDatosSotType.setEstadoSot(item.getEstadoSot());
					objDatosSotType.setCodId(item.getCodId());
					objDatosSotType.setFecAgendamiento(item.getFecAgendamiento());
					objDatosSotType.setEstadoAgenda(item.getEstadoAgenda());
					objDatosSotType.setObservacion(item.getObservacion());

					((ArrayList<DatosSotType>) myList).add(objDatosSotType);
				}
				break;
			}
			case 2: {
				DatosIncidenciaType objDatosIncidenciaType;
				myList = new ArrayList<DatosIncidenciaType>();
				for (DatosIncidencia item : objConsultarInteraccionCasosResponse.getListDatosIncidencia().getListDatosIncidencia()) {
					objDatosIncidenciaType = new DatosIncidenciaType();
					objDatosIncidenciaType.setNroIncidencia(item.getNroIncidencia());
					objDatosIncidenciaType.setCodigoSubCategoria(item.getCodigoSubCategoria());
					objDatosIncidenciaType.setTipoIncidencia(item.getTipoIncidencia());
					objDatosIncidenciaType.setClasificacionIncidencia(item.getClasificacionIncidencia());
					objDatosIncidenciaType.setNroTicket(item.getNroTicket());
					objDatosIncidenciaType.setFechaRegistro(item.getFechaRegistro());
					objDatosIncidenciaType.setCodigoCaso(item.getCodigoCaso());
					objDatosIncidenciaType.setTipoCaso(item.getTipoCaso());
					objDatosIncidenciaType.setEstado(item.getEstado());
					objDatosIncidenciaType.setNroServicio(item.getNroServicio());
					objDatosIncidenciaType.setAreaRegistro(item.getAreaRegistro());
					objDatosIncidenciaType.setUsuarioRegistro(item.getUsuarioRegistro());
					objDatosIncidenciaType.setAreaUltimaDerivacion(item.getAreaUltimaDerivacion());
					objDatosIncidenciaType.setUsuarioUltimaDerivacion(item.getUsuarioUltimaDerivacion());
					objDatosIncidenciaType.setFechaUlitmaSecuencia(item.getFechaUlitmaSecuencia());
					objDatosIncidenciaType.setSolucion(item.getSolucion());
					objDatosIncidenciaType.setFamilia(item.getFamilia());
					((ArrayList<DatosIncidenciaType>) myList).add(objDatosIncidenciaType);
				}
				break;
			}
			case 3: {
				DatosProblemaType objDatosProblemaType;
				myList = new ArrayList<DatosProblemaType>();
				for (DatosProblema item : objConsultarInteraccionCasosResponse.getListDatosProblema().getListDatosProblema()) {
					objDatosProblemaType = new DatosProblemaType();
					objDatosProblemaType.setCodigoCliente(item.getCodigoCliente());
					objDatosProblemaType.setSitio(item.getSitio());
					objDatosProblemaType.setIdCaso(item.getIdCaso());
					objDatosProblemaType.setFechaCreacion(item.getFechaCreacion());
					objDatosProblemaType.setTelefono(item.getTelefono());
					objDatosProblemaType.setTipificacion(item.getTipificacion());
					objDatosProblemaType.setOrigen(item.getOrigen());
					objDatosProblemaType.setEstado(item.getEstado());
					objDatosProblemaType.setPrioridad(item.getPrioridad());
					objDatosProblemaType.setSeveridad(item.getSeveridad());
					objDatosProblemaType.setFase(item.getFase());
					objDatosProblemaType.setNroReporte(item.getNroReporte());
					objDatosProblemaType.setNroReclamo(item.getNroReclamo());
					objDatosProblemaType.setCondicion(item.getCondicion());
					objDatosProblemaType.setCola(item.getCola());
					objDatosProblemaType.setPropietario(item.getPropietario());
					objDatosProblemaType.setNombreAgente(item.getNombreAgente());
					objDatosProblemaType.setApellidoAgente(item.getApellidoAgente());
					objDatosProblemaType.setResultado(item.getResultado());
					objDatosProblemaType.setResolucion(item.getResolucion());
					objDatosProblemaType.setBandeja(item.getBandeja());
					objDatosProblemaType.setTipoCode(item.getTipoCode());
					objDatosProblemaType.setClaseCode(item.getClaseCode());
					objDatosProblemaType.setSubClaseCode(item.getSubClaseCode());
					objDatosProblemaType.setServicio(item.getServicio());
					objDatosProblemaType.setInconveniente(item.getInconveniente());
					objDatosProblemaType.setContrato(item.getContrato());
					objDatosProblemaType.setPlano(item.getPlano());
					objDatosProblemaType.setIdInteraccion(item.getIdInteraccion());
					objDatosProblemaType.setUsuarioAplicacion(item.getUsuarioAplicacion());
					objDatosProblemaType.setPlataforma(item.getPlataforma());
					objDatosProblemaType.setSentido(item.getSentido());
					objDatosProblemaType.setMontoAjustado(item.getMontoAjustado());

					((ArrayList<DatosProblemaType>) myList).add(objDatosProblemaType);
				}
				break;
			}
		}
		return myList;
	}

	@Override
	public ConsultarFallaResponseType consultarFalla(ConsultarFallaRequestType objConsultarFallaRequestType) {

		final long tiempoInicial = System.currentTimeMillis();

		String metodo = "consultarFalla";
		String idTransaccion = objConsultarFallaRequestType.getAuditRequest().getIdTransaccion();
		String msgTransaccion = "[ " + metodo + " idTx=" + idTransaccion + " ] - ";
		String mensajeLog = idTransaccion + "[" + metodo + "]-";
		String tipoFalla;
		boolean flgEjecucion = true;

		LOGGER.info(msgTransaccion + "===== INICIO de la operacion " + metodo + " =====");
		LOGGER.info(mensajeLog + "Datos de Request: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarFallaRequestType));

		AuditResponseType objAuditResponseType = new AuditResponseType();
		ConsultarFallaResponseType response = new ConsultarFallaResponseType();
		ParametrosType objParametrosType = new ParametrosType();

		List<FallaType> listFallaCrqType = new ArrayList<FallaType>();
		List<FallaType> listFallaIncType = new ArrayList<FallaType>();

		try {
			ConsultarFallaResponse objConsultarFallaResponse = new ConsultarFallaResponse();
			ConsultarFallaRequest objConsultarFallaRequest = new ConsultarFallaRequest();
			objConsultarFallaRequest.setPlano(objConsultarFallaRequestType.getPlano());
			tipoFalla = objConsultarFallaRequestType.getTipo().toUpperCase();
			
			
			if(tipoFalla.equals(Constantes.FALLA_CRQ) || tipoFalla.equals(Constantes.FALLA_TODOS)){
				flgEjecucion = false;
				objConsultarFallaRequest.setTipo(Constantes.FALLA_CRQ);
				objConsultarFallaResponse = sgaDao.consultarFalla(idTransaccion, objConsultarFallaRequest);
				if (objConsultarFallaResponse.getListFalla() != null) 
					listFallaCrqType = listasFalla(objConsultarFallaResponse);
				
			}
			
			if(tipoFalla.equals(Constantes.FALLA_INC) || tipoFalla.equals(Constantes.FALLA_TODOS)){
				flgEjecucion = false;
				objConsultarFallaRequest.setTipo(Constantes.FALLA_INC);
				objConsultarFallaResponse = sgaDao.consultarFalla(idTransaccion, objConsultarFallaRequest);
				if (objConsultarFallaResponse.getListFalla() != null) 
					listFallaIncType = listasFalla(objConsultarFallaResponse);
			}
			
			if(flgEjecucion){
				String strMsg = "Se requiere un tipo de FALLA [CRQ: " + Constantes.FALLA_CRQ + ", " +
                        "INC: " + Constantes.FALLA_INC + ", " +
                        "TODOS: " + Constantes.FALLA_TODOS + "]";
				LOGGER.info(mensajeLog + strMsg);
				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
				objAuditResponseType.setMensajeRespuesta(strMsg);
			}else if (listFallaCrqType.isEmpty() && listFallaIncType.isEmpty()) {
				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
				objAuditResponseType.setMensajeRespuesta(propiedadesExterna.IDF1MENSAJE
						.replace("$bd", propiedadesExterna.dbSGADB)
						.replace("$sp", propiedadesExterna.spSicess_Falla)
						.replace("$cod", objConsultarFallaResponse.getCodRespuesta())
						.replace("$msg", objConsultarFallaResponse.getMsgRespuesta()));
			}else{
				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF0CODIGO);
				objAuditResponseType.setMensajeRespuesta(propiedadesExterna.IDF0MENSAJE
						.replace("$bd", propiedadesExterna.dbSGADB)
						.replace("$sp", propiedadesExterna.spSicess_Falla)
						.replace("$cod", objConsultarFallaResponse.getCodRespuesta())
						.replace("$msg", objConsultarFallaResponse.getMsgRespuesta()));
			}
						
			objAuditResponseType.setIdTransaccion(objConsultarFallaRequestType.getAuditRequest().getIdTransaccion());
			response.setAuditResponse(objAuditResponseType);
			response.setListaFallaCrq(listFallaCrqType);
			response.setListaFallaInc(listFallaIncType);
			response.setListaResponseOpcional(objParametrosType);


			LOGGER.info(msgTransaccion + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(msgTransaccion + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(msgTransaccion + "===== FIN de la operacion " + metodo + " =====");

		} catch (DBException ex) {
			objAuditResponseType.setIdTransaccion(objConsultarFallaRequestType.getAuditRequest().getIdTransaccion());
			objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
			objAuditResponseType.setMensajeRespuesta(ex.getMessage());
			response.setAuditResponse(objAuditResponseType);
			LOGGER.info(mensajeLog + "Exception de Base de Datos " + ex);
		} finally {
			LOGGER.info(mensajeLog + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(mensajeLog + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(mensajeLog + "===== FIN de la operacion " + metodo + " =====");
		}

		return response;
	}

	public ArrayList<FallaType> listasFalla(ConsultarFallaResponse objConsultarFallaResponse) {
		ArrayList<FallaType> myList = new ArrayList<FallaType>();
		FallaType objFallaType;
		for (Falla item : objConsultarFallaResponse.getListFalla().getListFalla()) {
			objFallaType = new FallaType();
			objFallaType.setNumeroFalla(item.getNumeroFalla());
			objFallaType.setDetalleProblema(item.getDetalleProblema());
			objFallaType.setMotivo(item.getMotivo());
			objFallaType.setObservacion(item.getObservacion());
			objFallaType.setTiempoSolucion(item.getTiempoSolucion());
			objFallaType.setFechaInicio(item.getFechaInicio());
			myList.add(objFallaType);
		}
		return myList;
	}

	@Override
	public ConsultarEquipoResponseType consultarEquipo(ConsultarEquipoRequestType objConsultarEquipoRequestType) {

		final long tiempoInicial = System.currentTimeMillis();

		String metodo = "consultarEquipo";
		String idTransaccion = objConsultarEquipoRequestType.getAuditRequest().getIdTransaccion();
		String msgTransaccion = "[ " + metodo + " idTx=" + idTransaccion + " ] - ";
		String mensajeLog = idTransaccion + "[" + metodo + "]-";
		
		LOGGER.info(msgTransaccion + "===== INICIO de la operacion " + metodo + " =====");
		LOGGER.info(mensajeLog + "Datos de Request: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarEquipoRequestType));
		
		AuditResponseType objAuditResponseType = new AuditResponseType();
		ConsultarEquipoResponseType response = new ConsultarEquipoResponseType();
		ParametrosType objParametrosType = new ParametrosType();
		
		EquipoType objEquipoType;		
		ListaEquipoType objListaEquipoType = new ListaEquipoType();		
		List<EquipoType> listEquipo = new ArrayList<EquipoType>();

		try {
			switch (objConsultarEquipoRequestType.getTecnologia()) {
			case Constantes.TECNOLOGIA_HFC:
			case Constantes.TECNOLOGIA_FTTH:
				ConsultarEquipoRequest objConsultarEquipoRequest = new ConsultarEquipoRequest();
				objConsultarEquipoRequest.setCustomerId(objConsultarEquipoRequestType.getCustomerId());
				// Equipos - Internet
				ConsultarEquipoResponse objConsultarEquipoIResponse = new ConsultarEquipoResponse();
				objConsultarEquipoIResponse = sgaDao.consultarEquipoInternet(idTransaccion, objConsultarEquipoRequest);
				// Equipos - Telefonia
				ConsultarEquipoResponse objConsultarEquipoTResponse = new ConsultarEquipoResponse();
				objConsultarEquipoTResponse = sgaDao.consultarEquipoTelefonia(idTransaccion, objConsultarEquipoRequest);
				// Equipos - Cable
				ConsultarEquipoResponse objConsultarEquipoCResponse = new ConsultarEquipoResponse();
				objConsultarEquipoCResponse = sgaDao.consultarEquipoCable(idTransaccion, objConsultarEquipoRequest);
				
				if(objConsultarEquipoIResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.FLAG_EXITO)){
					// Equipos - Internet
					if (!objConsultarEquipoIResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO) && objConsultarEquipoIResponse.getListEquipo() != null) {
						for (Equipo item : objConsultarEquipoIResponse.getListEquipo()) {
							objEquipoType = new EquipoType();
							objEquipoType.setType(item.getType());
							objEquipoType.setCustomerId(item.getCustomerId());
							objEquipoType.setModel(item.getModel());
							objEquipoType.setMacAddress(item.getMacAddress());
							objEquipoType.setSerialNumber(item.getSerialNumber());
							objEquipoType.setEquipmentCodeInc(item.getEquipmentCodeInc());
							objEquipoType.setModelCodeInc(item.getModelCodeInc());

							String metodo2 = "consultarEquipoComplemento";
							LOGGER.info(msgTransaccion + "----- INICIO de la operacion " + metodo2 + " -----");
							ConsultarEquipoResponse objConsultarEquipoCmtoResponse = new ConsultarEquipoResponse();
							ConsultarEquipoRequest objConsultarEquipoCmtoRequest = new ConsultarEquipoRequest();
							objConsultarEquipoCmtoRequest.setModel(objEquipoType.getModel().trim());
							objConsultarEquipoCmtoRequest.setMacSerial(objEquipoType.getMacAddress());
							objConsultarEquipoCmtoResponse = sgaDao.consultarEquipoComplemento(idTransaccion, objConsultarEquipoCmtoRequest);
							
							if(objConsultarEquipoCmtoResponse.getListEquipo() != null){
								if(objConsultarEquipoCmtoResponse.getListEquipo().size() > Constantes.CERO){
									objEquipoType.setEquipmentCodeInc(objConsultarEquipoCmtoResponse.getListEquipo().get(0).getEquipmentCodeInc());
									objEquipoType.setModelCodeInc(objConsultarEquipoCmtoResponse.getListEquipo().get(0).getModelCodeInc());
									objEquipoType.setParentId(objConsultarEquipoCmtoResponse.getListEquipo().get(0).getParentId());
									objEquipoType.setModel(item.getModel() + 
											(objConsultarEquipoCmtoResponse.getListEquipo().get(0).getDescModelInc().equals("") ? "":
												PropertiesInternos.STICK + objConsultarEquipoCmtoResponse.getListEquipo().get(0).getDescModelInc())
											);
								}							
							}
							LOGGER.info(msgTransaccion + "----- FIN de la operacion " + metodo2 + " -----");
							listEquipo.add(objEquipoType);
						}
					}
				}
				
				if(objConsultarEquipoTResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.FLAG_EXITO)){
					// Equipos - Telefonia
					if (!objConsultarEquipoTResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
							&& objConsultarEquipoTResponse.getListEquipo() != null) {

						for (Equipo item : objConsultarEquipoTResponse.getListEquipo()) {
							objEquipoType = new EquipoType();
							objEquipoType.setType(item.getType());
							objEquipoType.setCustomerId(item.getCustomerId());
							objEquipoType.setModel(item.getModel());
							objEquipoType.setMacAddress(item.getMacAddress());
							objEquipoType.setSerialNumber(item.getSerialNumber());
							objEquipoType.setEquipmentCodeInc(item.getEquipmentCodeInc());
							objEquipoType.setModelCodeInc(item.getModelCodeInc());

							String metodo2 = "consultarEquipoComplemento";
							LOGGER.info(msgTransaccion + "----- INICIO de la operacion " + metodo2 + " -----");
							ConsultarEquipoResponse objConsultarEquipoCmtoResponse = new ConsultarEquipoResponse();
							ConsultarEquipoRequest objConsultarEquipoCmtoRequest = new ConsultarEquipoRequest();
							objConsultarEquipoCmtoRequest.setModel(objEquipoType.getModel().trim());
							objConsultarEquipoCmtoRequest.setMacSerial(objEquipoType.getMacAddress());
							objConsultarEquipoCmtoResponse = sgaDao.consultarEquipoComplemento(idTransaccion, objConsultarEquipoCmtoRequest);
							
							if(objConsultarEquipoCmtoResponse.getListEquipo() != null){
								if(objConsultarEquipoCmtoResponse.getListEquipo().size() > Constantes.CERO){
									objEquipoType.setEquipmentCodeInc(objConsultarEquipoCmtoResponse.getListEquipo().get(0).getEquipmentCodeInc());
									objEquipoType.setModelCodeInc(objConsultarEquipoCmtoResponse.getListEquipo().get(0).getModelCodeInc());
									objEquipoType.setParentId(objConsultarEquipoCmtoResponse.getListEquipo().get(0).getParentId());
								}
								
							}
							LOGGER.info(msgTransaccion + "----- FIN de la operacion " + metodo2 + " -----");
							listEquipo.add(objEquipoType);
						}
					}
				}
				
				if (objConsultarEquipoCResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.FLAG_EXITO)) {
					// Equipos - Cable
					if (!objConsultarEquipoCResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
							&& objConsultarEquipoCResponse.getListEquipo() != null) {

						for (Equipo item : objConsultarEquipoCResponse.getListEquipo()) {
							objEquipoType = new EquipoType();
							objEquipoType.setType(item.getType());
							objEquipoType.setCustomerId(item.getCustomerId());
							objEquipoType.setModel(item.getModel());
							objEquipoType.setMacAddress(item.getMacAddress());
							objEquipoType.setSerialNumber(item.getSerialNumber());
							objEquipoType.setEquipmentCodeInc(item.getEquipmentCodeInc());
							objEquipoType.setModelCodeInc(item.getModelCodeInc());

							String metodo2 = "consultarEquipoComplemento";
							LOGGER.info(msgTransaccion + "----- INICIO de la operacion " + metodo2 + " -----");
							ConsultarEquipoResponse objConsultarEquipoCmtoResponse = new ConsultarEquipoResponse();
							ConsultarEquipoRequest objConsultarEquipoCmtoRequest = new ConsultarEquipoRequest();
							objConsultarEquipoCmtoRequest.setModel(objEquipoType.getModel().trim());
							objConsultarEquipoCmtoRequest.setMacSerial(objEquipoType.getSerialNumber());
							objConsultarEquipoCmtoResponse = sgaDao.consultarEquipoComplemento(idTransaccion, objConsultarEquipoCmtoRequest);

							if (objConsultarEquipoCmtoResponse.getListEquipo() != null) {
								if (objConsultarEquipoCmtoResponse.getListEquipo().size() > Constantes.CERO) {
									objEquipoType.setEquipmentCodeInc(objConsultarEquipoCmtoResponse.getListEquipo().get(0).getEquipmentCodeInc());
									objEquipoType.setModelCodeInc(objConsultarEquipoCmtoResponse.getListEquipo().get(0).getModelCodeInc());
									objEquipoType.setParentId(objConsultarEquipoCmtoResponse.getListEquipo().get(0).getParentId());
								}
							}

							LOGGER.info(msgTransaccion + "----- FIN de la operacion " + metodo2 + " -----");
							listEquipo.add(objEquipoType);
						}
						
						LOGGER.info(msgTransaccion + " Inicio Adicionando la lista de decos IPTV a la lista principal");
						
						List<EquipoType> lstEquipoIPTV = getListEquipoIPTV(objAuditResponseType,
								objConsultarEquipoRequestType, idTransaccion, propiedadesExterna);
						
						if (lstEquipoIPTV != null) {
							for (EquipoType x : lstEquipoIPTV) {
								listEquipo.add(x);
							}
						}

						LOGGER.info(msgTransaccion + " Fin Adicionando la lista de decos IPTV a la lista principal");
					}
				}
				
				LOGGER.info(msgTransaccion + " Exito al obtener los datos de respuesta ");
				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF0CODIGO);
				objAuditResponseType.setMensajeRespuesta(Constantes.FLAG_EXITO);
				objAuditResponseType.setIdTransaccion(objConsultarEquipoRequestType.getAuditRequest().getIdTransaccion());
				
				objListaEquipoType.setEquipo(listEquipo);
				
				response.setAuditResponse(objAuditResponseType);
				response.setListaEquipo(objListaEquipoType);
				response.setListaResponseOpcional(objParametrosType);
				break;

			case Constantes.TECNOLOGIA_LTE:
			case Constantes.TECNOLOGIA_DTH:
				ConsultarEquipoRequest consultarEquipoRequest = new ConsultarEquipoRequest();
				ConsultarEquipoResponse objConsultarEquipoResponse = new ConsultarEquipoResponse();
				ConsultarEquipoResponse objConsultarEquipoLTEResponse = new ConsultarEquipoResponse();
				ConsultarEquipoResponse objConsultarEquipoCableResponse = new ConsultarEquipoResponse();
				
				consultarEquipoRequest.setCodSolot(objConsultarEquipoRequestType.getCodSolot());
				consultarEquipoRequest.setCoId(objConsultarEquipoRequestType.getCoId());

				if(objConsultarEquipoRequestType.getTecnologia().equalsIgnoreCase(propiedadesExterna.tecnologiaLTE))
					objConsultarEquipoLTEResponse = sgaDao.consultarEquipoLte(idTransaccion, consultarEquipoRequest);

				objConsultarEquipoCableResponse = bscsDao.consultarEquipoCable(idTransaccion, consultarEquipoRequest);
				objConsultarEquipoResponse = unificarEquipo(objConsultarEquipoLTEResponse, objConsultarEquipoCableResponse);

				if (!objConsultarEquipoResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
						&& objConsultarEquipoResponse.getCodRespuesta().equalsIgnoreCase(propiedadesExterna.IDF0CODIGO)) {
					for (Equipo item : objConsultarEquipoResponse.getListEquipo()) {
						objEquipoType = new EquipoType();
						objEquipoType.setType(item.getType());
						objEquipoType.setModel(item.getModel());
						objEquipoType.setSerialNumber(item.getSerialNumber());
						objEquipoType.setCardNumber(item.getCardNumber());
						objEquipoType.setUaNumber(item.getUaNumber());
						
						String metodo3 = "consultarEquipoComplementoLTEDTH";
						LOGGER.info(msgTransaccion + "----- INICIO de la operacion " + metodo3 + " -----");
						ConsultarEquipoResponse objConsultarEquipoCmtLTEDTHResponse = new ConsultarEquipoResponse();
						ConsultarEquipoRequest objConsultarEquipoCmtLTEDTHRequest = new ConsultarEquipoRequest();
						objConsultarEquipoCmtLTEDTHRequest.setUaNumber(objEquipoType.getUaNumber().trim());
						objConsultarEquipoCmtLTEDTHResponse = sgaDao.consultarEquipoComplementoLTEDTH(idTransaccion, objConsultarEquipoCmtLTEDTHRequest);
						
						if(objConsultarEquipoCmtLTEDTHResponse.getListEquipo() != null){
							if(objConsultarEquipoCmtLTEDTHResponse.getListEquipo().size() > Constantes.CERO){
								objEquipoType.setModel(objConsultarEquipoCmtLTEDTHResponse.getListEquipo().get(0).getModel());
								objEquipoType.setSerialNumber(objConsultarEquipoCmtLTEDTHResponse.getListEquipo().get(0).getSerialNumber());
							}
						}
						
						LOGGER.info(msgTransaccion + "----- FIN de la operacion " + metodo3 + " -----");
						
						listEquipo.add(objEquipoType);
					}

					LOGGER.info(msgTransaccion + " Exito al obtener los datos de respuesta ");
					objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF0CODIGO);
					objAuditResponseType.setMensajeRespuesta(Constantes.FLAG_EXITO);
					objAuditResponseType.setIdTransaccion(objConsultarEquipoRequestType.getAuditRequest().getIdTransaccion());
					
					objListaEquipoType.setEquipo(listEquipo);
					
					response.setAuditResponse(objAuditResponseType);
					response.setListaEquipo(objListaEquipoType);
					response.setListaResponseOpcional(objParametrosType);

				}else{
					LOGGER.error(msgTransaccion + " Error al obtener los datos de respuesta ");
					objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
					objAuditResponseType.setMensajeRespuesta(propiedadesExterna.IDF1MENSAJE
							.replace("$bd", objConsultarEquipoRequestType.getTecnologia().equalsIgnoreCase(propiedadesExterna.tecnologiaLTE) ? propiedadesExterna.dbSGADB : propiedadesExterna.dbBSCSDB)
							.replace("$sp", objConsultarEquipoRequestType.getTecnologia().equalsIgnoreCase(propiedadesExterna.tecnologiaLTE) ? 
										(propiedadesExterna.dbSGADBOwner.concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.pkgEquipo).concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.spSicess_EquipoLte)):
											(propiedadesExterna.dbBSCSDBOwner.concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.pkgProvDth).concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.spConsultaDeco))	
												)
							.replace("$cod", objConsultarEquipoResponse.getCodRespuesta())
							.replace("$msg", objConsultarEquipoResponse.getMsgRespuesta()));
					objAuditResponseType.setIdTransaccion(objConsultarEquipoRequestType.getAuditRequest().getIdTransaccion());
					
					response.setAuditResponse(objAuditResponseType);
					response.setListaResponseOpcional(objParametrosType);
				}
				break;
				
			case Constantes.TECNOLOGIA_IFI:
				ConsultarEquipoRequest objEquiposIfiRequest = new ConsultarEquipoRequest();
				objEquiposIfiRequest.setCoId(objConsultarEquipoRequestType.getCoId());
				
				ConsultarEquipoResponse objEquiposIfiResponse = pvuDao.consultarEquipo(idTransaccion, objEquiposIfiRequest);
				
				if(objEquiposIfiResponse.getCodRespuesta().equals(Constantes.EJECUCION_CORRECTA_STRING)){
					
					objListaEquipoType.setEquipo(objEquiposIfiResponse.getListEquipo().stream().map(e -> {
						EquipoType equipo = new EquipoType();
						equipo.setType(e.getType());
						equipo.setModel(e.getModel());
						equipo.setSerialNumber(e.getSerialNumber());

						return equipo;
					}).collect(Collectors.toList()));
										
					objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF0CODIGO);
					objAuditResponseType.setMensajeRespuesta(Constantes.FLAG_EXITO);
					objAuditResponseType.setIdTransaccion(objConsultarEquipoRequestType.getAuditRequest().getIdTransaccion());
					
					response.setAuditResponse(objAuditResponseType);
					response.setListaEquipo(objListaEquipoType);
					response.setListaResponseOpcional(objParametrosType);
				} else{
					LOGGER.error(msgTransaccion + " Error al obtener los datos de respuesta ");
					objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
					objAuditResponseType.setMensajeRespuesta(propiedadesExterna.IDF1MENSAJE
							.replace("$bd", propiedadesExterna.dbPVU)
							.replace("$sp", propiedadesExterna.spSicess_equipment_ifi)
							.replace("$cod", objEquiposIfiResponse.getCodRespuesta())
							.replace("$msg", objEquiposIfiResponse.getMsgRespuesta()));
					objAuditResponseType.setIdTransaccion(objConsultarEquipoRequestType.getAuditRequest().getIdTransaccion());
					
					response.setAuditResponse(objAuditResponseType);
					response.setListaResponseOpcional(objParametrosType);
				}
				break;
			default:
				String strMsg = "Se requiere un tipo de tecnologia [" + propiedadesExterna.tecnologiaHFC + ", " + propiedadesExterna.tecnologiaLTE + ", " + propiedadesExterna.tecnologiaDTH + ", " + propiedadesExterna.tecnologiaIFI + "]";
				LOGGER.info(mensajeLog + strMsg);
				
				LOGGER.error(msgTransaccion + " Error al obtener los datos de respuesta ");
				objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
				objAuditResponseType.setMensajeRespuesta(strMsg);
				objAuditResponseType.setIdTransaccion(objConsultarEquipoRequestType.getAuditRequest().getIdTransaccion());
				
				response.setAuditResponse(objAuditResponseType);
				response.setListaResponseOpcional(objParametrosType);
				break;
			}
									
		} catch (DBException ex) {
			objAuditResponseType.setIdTransaccion(objConsultarEquipoRequestType.getAuditRequest().getIdTransaccion());
			objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
			objAuditResponseType.setMensajeRespuesta(ex.getMessage());
			response.setAuditResponse(objAuditResponseType);
			LOGGER.info(mensajeLog + "Exception de Base de Datos " + ex);
		} finally {
			LOGGER.info(mensajeLog + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(mensajeLog + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(mensajeLog + "===== FIN de la operacion " + metodo + " =====");
		}
		return response;
	}

	public ConsultarEquipoResponse unificarEquipo(ConsultarEquipoResponse objConsultarEquipoResponse1, ConsultarEquipoResponse objConsultarEquipoResponse2){
		String metodo = "unificarEquipo";
		LOGGER.info("----- INICIO de la operacion " + metodo + " -----");
		ConsultarEquipoResponse objConsultarEquipoResponse = new ConsultarEquipoResponse();
		objConsultarEquipoResponse = objConsultarEquipoResponse2;
		if(objConsultarEquipoResponse1.getCodRespuesta()!=null){
			if(objConsultarEquipoResponse1.getCodRespuesta().equalsIgnoreCase(propiedadesExterna.IDF0CODIGO)){
				if (!objConsultarEquipoResponse1.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
						&& objConsultarEquipoResponse1.getListEquipo() != null) {
					objConsultarEquipoResponse = objConsultarEquipoResponse1;
					if(objConsultarEquipoResponse2.getCodRespuesta().equalsIgnoreCase(propiedadesExterna.IDF0CODIGO)){
						if (!objConsultarEquipoResponse2.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
								&& objConsultarEquipoResponse2.getListEquipo() != null) {
							for (Equipo equipo : objConsultarEquipoResponse2.getListEquipo()) {
								objConsultarEquipoResponse.getListEquipo().add(equipo);
							}
						}
					}
				}
			}
		}
		LOGGER.info("Datos unificados: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarEquipoResponse));
		LOGGER.info("----- Fin de la operacion " + metodo + " -----");
		return objConsultarEquipoResponse;
	}
	
	@Override
	public ConsultarReglaResponseType consultarRegla(HeaderRequest objHeaderRequest,
			ConsultarReglaRequestType objConsultarReglaRequestType, Holder<HeaderResponse> headerResponse) {
		
		final long tiempoInicial = System.currentTimeMillis();

		String metodo = "consultarRegla";
		String idTransaccion = objHeaderRequest.getIdESBTransaction();
		String msgTransaccion = "[ " + metodo + " idTx=" + idTransaccion + " ] - ";
		String mensajeLog = idTransaccion + "[" + metodo + "]-";

		LOGGER.info(msgTransaccion + "===== INICIO de la operacion " + metodo + " =====");
		LOGGER.info(mensajeLog + "Datos de Request: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarReglaRequestType));
		LOGGER.info(mensajeLog + "Datos de HeaderRequest: " + JAXBUtilitarios.anyObjectToXmlText(objHeaderRequest));

		ConsultarReglaResponseType response = new ConsultarReglaResponseType();
		ResponseStatus objResponseStatus = new ResponseStatus();
		ListaReglaType objListaReglaType = new ListaReglaType();
		ReglaType objReglaType;
		List<ReglaType> listReglaType = new ArrayList<ReglaType>();

		HeaderResponse objHeaderRes = new HeaderResponse();
		XMLGregorianCalendar xgcal = JAXBUtilitarios.getXmlGregorianCalnedar();
		
		try {
			ConsultarReglaResponse objReglaResponse = new ConsultarReglaResponse();
			ConsultarReglaResponse objReglaComplementoResponse = new ConsultarReglaResponse();

			ConsultarReglaRequest objConsultarReglaRequest = new ConsultarReglaRequest();
			objConsultarReglaRequest.setCustomerId(objConsultarReglaRequestType.getCustomerId());
			objConsultarReglaRequest.setCodSolot(objConsultarReglaRequestType.getCodSolot());
			objConsultarReglaRequest.setTelefono(objConsultarReglaRequestType.getTelefono());
			objConsultarReglaRequest.setCoId(objConsultarReglaRequestType.getCoId());
			objConsultarReglaRequest.setCicloOAC(objConsultarReglaRequestType.getCicloOAC());
			objConsultarReglaRequest.setRulers(objConsultarReglaRequestType.getRulers());

			
			objReglaResponse = sgaDao.consultarRegla(idTransaccion, objConsultarReglaRequest);
			objReglaComplementoResponse = sgaDao.consultarReglaComplemento(idTransaccion, objConsultarReglaRequest);


			if ((objReglaResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO) || objReglaResponse.getListRegla() == null) && 
					(objReglaComplementoResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO) || objReglaComplementoResponse.getListRegla() == null)) {
					objResponseStatus.setCodeResponse(propiedadesExterna.IDF1CODIGO);
					objResponseStatus.setDescriptionResponse(propiedadesExterna.IDF1MENSAJE
							.replace("$bd", propiedadesExterna.dbSGADB)
							.replace("$sp", propiedadesExterna.dbSGADBOwnerOperacion.concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.spSicess_validateservice).concat(" | ")
									.concat(propiedadesExterna.dbSGADBOwnerIntraway).concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.pkgSicesFailure).concat(PropertiesInternos.PUNTO).concat(propiedadesExterna.spSicess_validateservice))
							.replace("$cod", objReglaResponse.getCodRespuesta().concat(" | ").concat(objReglaComplementoResponse.getCodRespuesta()) )
							.replace("$msg", objReglaResponse.getMsgRespuesta().concat(" | ").concat(objReglaComplementoResponse.getMsgRespuesta())));
					response.setResponseStatus(objResponseStatus);
					response.setResponseData(objListaReglaType);

					LOGGER.info(msgTransaccion + "Datos de salida (responseTransacciones.getErrorMsg().equalsIgnoreCase): " + JAXBUtilitarios.anyObjectToXmlText(response));
					LOGGER.info(msgTransaccion + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
					LOGGER.info(msgTransaccion + "===== FIN de la operacion " + metodo + " =====");
			}else {
				// Equipos - Internet
				if (!objReglaResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
						&& objReglaResponse.getListRegla() != null) {
					for (Regla item : objReglaResponse.getListRegla().getListRegla()) {
						objReglaType = new ReglaType();
						objReglaType.setCodRegla(item.getCodRegla());
						objReglaType.setCodRespuesta(item.getCodRespuesta());
						listReglaType.add(objReglaType);
					}
				}
				
				if (!objReglaComplementoResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
						&& objReglaComplementoResponse.getListRegla() != null) {
					for (Regla item : objReglaComplementoResponse.getListRegla().getListRegla()) {
						objReglaType = new ReglaType();
						objReglaType.setCodRegla(item.getCodRegla());
						objReglaType.setCodRespuesta(item.getCodRespuesta());
						listReglaType.add(objReglaType);
					}
				}
				
				objResponseStatus.setCodeResponse(propiedadesExterna.IDF0CODIGO);
				objResponseStatus.setDescriptionResponse(Constantes.FLAG_EXITO);
				objResponseStatus.setStatus(Integer.valueOf(propiedadesExterna.IDF0CODIGO));
				objResponseStatus.setDate(xgcal);

				objListaReglaType.setListaRegla(listReglaType);

				response.setResponseStatus(objResponseStatus);
				response.setResponseData(objListaReglaType);

				LOGGER.info(msgTransaccion + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
				LOGGER.info(msgTransaccion + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
				LOGGER.info(msgTransaccion + "===== FIN de la operacion " + metodo + " =====");
			}
			
		} catch (DBException ex) {
			objResponseStatus.setStatus(Integer.parseInt((propiedadesExterna.IDF1CODIGO)));
			objResponseStatus.setCodeResponse(ex.getCodError());
			objResponseStatus.setDescriptionResponse(ex.getMessage());
			objResponseStatus.setDate(xgcal);
			response.setResponseStatus(objResponseStatus);
			LOGGER.info(mensajeLog + "Exception de Base de Datos " + ex.getMessage());
		} finally {
			objHeaderRes.setIdBusinessTransaction(objHeaderRequest.getIdBusinessTransaction());
			objHeaderRes.setIdESBTransaction(objHeaderRequest.getIdESBTransaction());
			objHeaderRes.setStartDate(objHeaderRequest.getStartDate());
			objHeaderRes.setEndDate(xgcal);

			headerResponse.value = objHeaderRes;
			LOGGER.info(mensajeLog + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(mensajeLog + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(mensajeLog + "===== FIN de la operacion " + metodo + " =====");
		}

		return response;
	}

	@Override
	public ReconectarNcosResponseType reconectarNcos(ReconectarNcosRequestType objReconectarNcosRequestType) {
		final long tiempoInicial = System.currentTimeMillis();

		String metodo = "reconectarNcos";
		String idTransaccion = objReconectarNcosRequestType.getAuditRequest().getIdTransaccion();
		String msgTransaccion = "[ " + metodo + " idTx=" + idTransaccion + " ] - ";
		String mensajeLog = idTransaccion + "[" + metodo + "]-";

		LOGGER.info(msgTransaccion + "===== INICIO de la operacion " + metodo + " =====");
		LOGGER.info(mensajeLog + "Datos de Request: " + JAXBUtilitarios.anyObjectToXmlText(objReconectarNcosRequestType));

		ReconectarNcosResponseType response = new ReconectarNcosResponseType();
		AuditResponseType objAuditResponseType = new AuditResponseType();

		HeaderResponse objHeaderRes = new HeaderResponse();
		XMLGregorianCalendar xgcal = JAXBUtilitarios.getXmlGregorianCalnedar();
		
		try {
			ReconectarNcosResponse objReconectarNcosResponse = new ReconectarNcosResponse();
			
			ReconectarNcosRequest objReconectarNcosRequest = new ReconectarNcosRequest();
			objReconectarNcosRequest.setCustomerId(objReconectarNcosRequestType.getCustomerId());

			objReconectarNcosResponse = sgaDao.reconectarNcos(idTransaccion, objReconectarNcosRequest);
			
			objAuditResponseType.setIdTransaccion(objReconectarNcosRequestType.getAuditRequest().getIdTransaccion());
			objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF0CODIGO);
			objAuditResponseType.setMensajeRespuesta(objReconectarNcosResponse.getMsgRespuesta());

			response.setAuditResponse(objAuditResponseType);
			response.setCallBarringType(objReconectarNcosResponse.getCallBarringType());

			LOGGER.info(msgTransaccion + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(msgTransaccion + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(msgTransaccion + "===== FIN de la operacion " + metodo + " =====");
			
		} catch (DBException ex) {
			objAuditResponseType.setIdTransaccion(objReconectarNcosRequestType.getAuditRequest().getIdTransaccion());
			objAuditResponseType.setCodigoRespuesta(propiedadesExterna.IDF1CODIGO);
			objAuditResponseType.setMensajeRespuesta(ex.getMessage());
			response.setAuditResponse(objAuditResponseType);
			LOGGER.info(mensajeLog + "Exception de Base de Datos " + ex.getMessage());
		} finally {
			LOGGER.info(mensajeLog + "Datos de salida: " + JAXBUtilitarios.anyObjectToXmlText(response));
			LOGGER.info(mensajeLog + "Tiempo TOTAL Proceso: [" + (System.currentTimeMillis() - tiempoInicial) + " milisegundos ]");
			LOGGER.info(mensajeLog + "===== FIN de la operacion " + metodo + " =====");
		}

		return response;
	}
	
	public ConsultarClienteResponse consultarClienteComplemento(String mensajeTransaccion, String mensajeLog, ConsultarClienteResponse objConsultarClienteBscsResponse) throws DBException{
		
		String strCodCli = "";
		String strCategoria = "";
		LOGGER.info(mensajeLog + "Inicio Actividad Nro 2 - Obtener datos complementarios de clientes en BD:" + propiedadesExterna.dbSGADB);
		if(objConsultarClienteBscsResponse.getListCliente() != null){
			if(objConsultarClienteBscsResponse.getListCliente().getListCliente() != null){
				if(objConsultarClienteBscsResponse.getListCliente().getListCliente().size() > 0){
					String strNumDoc = objConsultarClienteBscsResponse.getListCliente().getListCliente().get(0).getNumDoc();
					LOGGER.info(mensajeLog + "Inicio Actividad Nro 2 - Obtener datos complementarios de SGA, nro Documento: " + strNumDoc);
					ConsultarClienteResponse responseCodCli = new ConsultarClienteResponse();
					ConsultarClienteRequest requestCodCli = new ConsultarClienteRequest();
					requestCodCli.setValorBusqueda(strNumDoc);
					responseCodCli = sgaDao.consultarClienteComplemento(mensajeTransaccion, requestCodCli);
					if (!responseCodCli.getMsgRespuesta().trim().equals(Constantes.CURSOR_VACIO) && responseCodCli.getListCliente() != null) {
						strCodCli = responseCodCli.getListCliente().getListCliente().get(0).getCodCli();
						strCategoria = responseCodCli.getListCliente().getListCliente().get(0).getCategoria();
						for (Cliente item : objConsultarClienteBscsResponse.getListCliente().getListCliente()) {
							item.setCodCli(strCodCli);
							item.setCategoria(strCategoria);
						}
					}
				}
			}
		}

		LOGGER.info("Datos complementarios: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarClienteBscsResponse));
		LOGGER.info(mensajeLog + "Fin Actividad Nro 2 - Obtener datos complementarios de clientes en BD:" + propiedadesExterna.dbSGADB);
		return objConsultarClienteBscsResponse;
	}

	public ConsultarClienteResponse unificarCliente(ConsultarClienteResponse objConsultarClienteResponse1, ConsultarClienteResponse objConsultarClienteResponse2){
		String metodo = "unificarCliente";
		LOGGER.info("----- INICIO de la operacion " + metodo + " -----");
		ConsultarClienteResponse objConsultarClienteResponse = new ConsultarClienteResponse();
		objConsultarClienteResponse = objConsultarClienteResponse2;
		if(objConsultarClienteResponse1.getCodRespuesta()!=null){
			if(objConsultarClienteResponse1.getCodRespuesta().equalsIgnoreCase(propiedadesExterna.IDF0CODIGO)){
				if (!objConsultarClienteResponse1.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
						&& objConsultarClienteResponse1.getListCliente() != null) {
					objConsultarClienteResponse = objConsultarClienteResponse1;
					if(objConsultarClienteResponse2.getCodRespuesta().equalsIgnoreCase(propiedadesExterna.IDF0CODIGO)){
						if (!objConsultarClienteResponse2.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
								&& objConsultarClienteResponse2.getListCliente() != null) {
							for (Cliente cliente : objConsultarClienteResponse2.getListCliente().getListCliente()) {
								objConsultarClienteResponse.getListCliente().getListCliente().add(cliente);
							}
						}
					}
				}
			}
		}
		LOGGER.info("Datos unificados: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarClienteResponse));
		LOGGER.info("----- Fin de la operacion " + metodo + " -----");
		return objConsultarClienteResponse;
	}

	public ConsultarClientePorNombreResponse unificarClientePorNombre(ConsultarClientePorNombreResponse objConsultarClientePorNombreResponse1, ConsultarClientePorNombreResponse objConsultarClientePorNombreResponse2){
		String metodo = "unificarClientePorNombre";
		LOGGER.info("----- INICIO de la operacion " + metodo + " -----");
		ConsultarClientePorNombreResponse objConsultarClientePorNombreResponse = new ConsultarClientePorNombreResponse();
		objConsultarClientePorNombreResponse = objConsultarClientePorNombreResponse2;
		if(objConsultarClientePorNombreResponse1.getCodRespuesta()!=null){
			if(objConsultarClientePorNombreResponse1.getCodRespuesta().equalsIgnoreCase(propiedadesExterna.IDF0CODIGO)){
				if (!objConsultarClientePorNombreResponse1.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
						&& objConsultarClientePorNombreResponse1.getListClientePorNombre() != null) {
					objConsultarClientePorNombreResponse = objConsultarClientePorNombreResponse1;
					if(objConsultarClientePorNombreResponse2.getCodRespuesta().equalsIgnoreCase(propiedadesExterna.IDF0CODIGO)){
						if (!objConsultarClientePorNombreResponse2.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
								&& objConsultarClientePorNombreResponse2.getListClientePorNombre() != null) {
							for (ClientePorNombre clientePorNombre : objConsultarClientePorNombreResponse2.getListClientePorNombre().getListClientePorNombre()) {
								objConsultarClientePorNombreResponse.getListClientePorNombre().getListClientePorNombre().add(clientePorNombre);
							}
						}
					}
				}
			}
		}
		LOGGER.info("Datos unificados: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarClientePorNombreResponse));
		LOGGER.info("----- Fin de la operacion " + metodo + " -----");
		return objConsultarClientePorNombreResponse;
	}

	public ConsultarClientePorNombreResponse quitarDuplicadosClientePorNombre(ConsultarClientePorNombreResponse objConsultarClientePorNombreResponse){
		String metodo = "quitarDuplicadosClientePorNombre";
		LOGGER.info("----- INICIO de la operacion " + metodo + " -----");
		
		if(objConsultarClientePorNombreResponse.getCodRespuesta()!=null){
			if(objConsultarClientePorNombreResponse.getCodRespuesta().equalsIgnoreCase(propiedadesExterna.IDF0CODIGO)){
				if (!objConsultarClientePorNombreResponse.getMsgRespuesta().equalsIgnoreCase(Constantes.CURSOR_VACIO)
						&& objConsultarClientePorNombreResponse.getListClientePorNombre() != null) {
					ArrayList<ClientePorNombre> lstClientePorNombre = new ArrayList<>();
					int nFlagExiste;
					for (ClientePorNombre clientePorNombre : objConsultarClientePorNombreResponse.getListClientePorNombre().getListClientePorNombre()) {
						nFlagExiste = 0;
						for (ClientePorNombre item : lstClientePorNombre) {
							if(clientePorNombre.getNumDoc().equalsIgnoreCase(item.getNumDoc())){
								nFlagExiste = 1;
							}
						}
					    if(nFlagExiste == 0){
					    	lstClientePorNombre.add(clientePorNombre);
					    }
					}
					objConsultarClientePorNombreResponse.getListClientePorNombre().setListClientePorNombre(lstClientePorNombre);
				}
			}
		}
		LOGGER.info("Datos no duplicados: " + JAXBUtilitarios.anyObjectToXmlText(objConsultarClientePorNombreResponse));
		LOGGER.info("----- Fin de la operacion " + metodo + " -----");
		return objConsultarClientePorNombreResponse;
	}
	
	public List<EquipoType> getListEquipoIPTV(AuditResponseType objAuditResponseType,
			ConsultarEquipoRequestType objConsultarEquipoRequestType, String idTransaccion,
			Propiedades propiedadesExterna) {
		
		String msgTransaccion = "[ getListEquipoIPTV idTx=" + idTransaccion + " ] - ";
		List<EquipoType> lstEquipoTypeITPV = null;
		AuthenticationResponse authenticationResponse = new AuthenticationResponse();
		AuthenticationRequest authenticationRequest = new AuthenticationRequest();
		authenticationRequest.setLanguage(propiedadesExterna.language);
		authenticationRequest.setPassword(propiedadesExterna.password);
		authenticationRequest.setServiceProvider(propiedadesExterna.serviceProvider);
		authenticationRequest.setUsername(propiedadesExterna.userName);
		LOGGER.info(msgTransaccion + "====Invocando al Servicio de Authentication ====");
		LOGGER.info(msgTransaccion + "Language [" + authenticationRequest.getLanguage() + " ] Password ["
				+ authenticationRequest.getPassword() + " ] Service Provider ["
				+ authenticationRequest.getServiceProvider() + " ] User Name [" + authenticationRequest.getUsername()
				+ "]");
		IncognitoResponse incognitoResponse = new IncognitoResponse();
		IncognitoRequest incognitoRequest = new IncognitoRequest();
		IncognitoHeader incognitoHeader = new IncognitoHeader();
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(Constantes.FORMATTIMESTAMP);
		String timeStamp = dtf2.format(LocalDateTime.now());
		incognitoHeader.setTransactionId(objConsultarEquipoRequestType.getAuditRequest().getIdTransaccion());
		incognitoHeader.setUserId(objConsultarEquipoRequestType.getAuditRequest().getUsuarioAplicacion());
		incognitoHeader.setAccept(Constantes.TYPEREQUEST);
		incognitoHeader.setTimestamp(timeStamp);
		incognitoHeader.setMsgid(objConsultarEquipoRequestType.getAuditRequest().getNombreAplicacion());
		/*******************
		 * Adicion del Servicio Incognico o lista de decos
		 *************/
		boolean existeFtthVideo = false;
		try {
			authenticationResponse = authenticationRest.authentication(authenticationRequest, incognitoHeader,
					propiedadesExterna);
			if (authenticationResponse.getAuthorization() != null
					|| !authenticationResponse.getAuthorization().equals(Constantes.TEXTO_VACIO)) {
				// INVOCAMOS AL SERVICIO DE INCOGNITO
				incognitoRequest.setAuthorization(authenticationResponse.getAuthorization());
				incognitoRequest.setCustomerId(objConsultarEquipoRequestType.getCustomerId());
				incognitoRequest.setTransactionId(idTransaccion);
				incognitoRequest.setSource(propiedadesExterna.source);
				LOGGER.info(msgTransaccion + "====Invocando al Servicio de Incognito ====");
				LOGGER.info(msgTransaccion + "Authorization [ " + incognitoRequest.getAuthorization()
						+ " ] Customer ID [" + incognitoRequest + " ] Source [" + incognitoRequest.getSource() + "]");
				incognitoResponse = incognitoRest.incognito(incognitoRequest, incognitoHeader, propiedadesExterna);
				if (!incognitoResponse.getStatus().equals(Constantes.CODIGO_IDT3)
						|| !incognitoResponse.getStatus().equals(Constantes.TEXTO_VACIO)) {

					if (incognitoResponse.getSubscribers() != null) {
						for (Subscribers lstSubscribers : incognitoResponse.getSubscribers()) {
							if (lstSubscribers.getServices() != null) {
								for (Services lstServices : lstSubscribers.getServices()) {
									if (lstServices.getServiceType().equalsIgnoreCase(Constantes.FTTH_VIDEO)) {
										LOGGER.info(msgTransaccion + "FTTH_VIDEO [" + lstServices.getServiceType() + " ]");
										existeFtthVideo = true;
										break;
									}
								}
							}
						}
					}

				}

				// INVOVACION AL SERVICIO IPTV
				if (existeFtthVideo) {

					IptvHeader iptvHeader = new IptvHeader();
					iptvHeader.setAccept(Constantes.TYPEREQUEST);
					iptvHeader.setMsgid(objConsultarEquipoRequestType.getAuditRequest().getNombreAplicacion());
					iptvHeader.setTimestamp(timeStamp);
					iptvHeader.setTransactionId(objConsultarEquipoRequestType.getAuditRequest().getIdTransaccion());
					iptvHeader.setUserId(objConsultarEquipoRequestType.getAuditRequest().getUsuarioAplicacion());

					IptvResquest iptvRequest = new IptvResquest();
					iptvRequest.setCustomer(objConsultarEquipoRequestType.getCustomerId());
					iptvRequest.setTipo(Constantes.TIPO_IPTV);
					LOGGER.info(msgTransaccion + "====Invocando al Servicio de IPTV ====");
					LOGGER.info(msgTransaccion + "Customer ID [ " + iptvRequest.getCustomer() + " ] TIPO [ " + iptvRequest.getTipo()
					+ " ] ");

					IptvResponse iptvResponse = iptvRest.consultaSerieIptv(propiedadesExterna, iptvHeader, iptvRequest);

					List<ChildCursor> listCursor = null;

					if (null != iptvResponse && null != iptvResponse.getQuerySerieOttResponse()
							&& null != iptvResponse.getQuerySerieOttResponse().getCursor()
							&& null != iptvResponse.getQuerySerieOttResponse().getCursor().getCursor()) {

						lstEquipoTypeITPV = new ArrayList<EquipoType>();
						listCursor = iptvResponse.getQuerySerieOttResponse().getCursor().getCursor();

						for (ChildCursor lstChildCursor : listCursor) {
							EquipoType equipoTypeIPTV = new EquipoType();
							equipoTypeIPTV.setType(Constantes.EQUIPO_CABLE);
							LOGGER.info(msgTransaccion + "Serial Number " + lstChildCursor.getDisclvDeviceid());
							equipoTypeIPTV.setSerialNumber(lstChildCursor.getDisclvDeviceid());
							equipoTypeIPTV.setModel(Constantes.MODELIPTV);
							lstEquipoTypeITPV.add(equipoTypeIPTV);
						}

						LOGGER.info(msgTransaccion + "====Lista de equipoITPV====");

						if (lstEquipoTypeITPV != null) {
							for (EquipoType lista : lstEquipoTypeITPV) {
								LOGGER.info(msgTransaccion + "Type" + lista.getType() + " Serial Number" + lista.getSerialNumber()
								+ "Model " + lista.getModel());
							}
						}
					} else {
						LOGGER.info(msgTransaccion + "Error: el servicio IPTV retorna null o vacio");
					}
				}

			}
		} catch (WSException e) {
			objAuditResponseType.setIdTransaccion(objConsultarEquipoRequestType.getAuditRequest().getIdTransaccion());
			objAuditResponseType.setCodigoRespuesta(e.getCode());
			objAuditResponseType.setMensajeRespuesta(e.getMessage() + Constantes.GUION + e.getMessageDeveloper());

			LOGGER.info(msgTransaccion + "Exception en servicio " + e);
		}

		/*************************/

		return lstEquipoTypeITPV;
	}
}