package pe.com.claro.eai.ws.postventa.consultaclientecesws.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Propiedades {

	@Value("${consultarSucursalDetalle.idf1.codigo}")
	public String consultarSucursalDetalleIdf1Codigo;
	@Value("${consultarSucursalDetalle.idf1.mensaje}")
	public String consultarSucursalDetalleIdf1Mensaje;
	
	@Value("${consultarSucursalDetalle.idf2.codigo}")
	public String consultarSucursalDetalleIdf2Codigo;
	@Value("${consultarSucursalDetalle.idf2.mensaje}")
	public String consultarSucursalDetalleIdf2Mensaje;
	
	// DATA_SOURCE SGA
	@Value("${bd.sga.jndi}")
	public String cJNDI_SGA;
	@Value("${bd.sga.ejecucion.timeout}")
	public Integer cEXECUTION_TIMEOUT_SGA;
	@Value("${bd.sga.pkgSicesFailure}")
	public String pkgSicesFailure;
	@Value("${bd.sga.pkgRegistroReclamo}")
	public String pkgRegistroReclamo;
	@Value("${bd.sga.pkgEquipo}")
	public String pkgEquipo;
	@Value("${bd.sga.pkgpostventaone}")
	public String pkgPostventaOne;
	
	@Value("${bd.sga.spSicess_customer}")
	public String spSicess_customer;
	@Value("${bd.sga.spSicess_Subsidiarydet_All}")
	public String spSicess_Subsidiarydet_All;
	@Value("${bd.sga.spSicess_Subsidiarydet_DTH}")
	public String spSicess_Subsidiarydet_DTH;
	@Value("${bd.sga.spSicess_FailbyLocation}")
	public String spSicess_FailbyLocation;
	@Value("${bd.sga.spSicess_Janus}")
	public String spSicess_Janus;
	@Value("${bd.sga.spSicess_Auditoria}")
	public String spSicess_Auditoria;
	@Value("${bd.sga.spSicess_servicesga}")
	public String spSicess_servicesga;
	@Value("${bd.sga.spSicess_seaChange}")
	public String spSicess_seaChange;
	@Value("${bd.sga.spSicess_Solot_Cliente}")
	public String spSicess_Solot_Cliente;
	@Value("${bd.sga.spSicess_Incidencia}")
	public String spSicess_Incidencia;
	@Value("${bd.sga.spSicess_Falla}")
	public String spSicess_Falla;
	@Value("${bd.sga.spSicess_EquipoInternet}")
	public String spSicess_EquipoInternet;
	@Value("${bd.sga.spSicess_EquipoTelefonia}")
	public String spSicess_EquipoTelefonia;
	@Value("${bd.sga.spSicess_EquipoCable}")
	public String spSicess_EquipoCable;
	@Value("${bd.sga.spSicess_EquipoInc}")
	public String spSicess_EquipoInc;
	@Value("${bd.sga.spSicess_validateservice}")
	public String spSicess_validateservice;
	@Value("${bd.sga.spSicess_reconect_ncos_inc}")
	public String spSicess_reconect_ncos_inc;
	@Value("${bd.sga.spSicess_EquipoLte}")
	public String spSicess_EquipoLte;
	@Value("${bd.sga.spSicessEquipmentDth}")
	public String spSicessEquipmentDth;
	@Value("${bd.sga.spSicessServicePrinc}")
	public String spSicessServicePrinc;
	@Value("${bd.sga.spSicessDatosCliente}")
	public String spSicessDatosCliente;
	@Value("${bd.sga.fnSiceFunDocumento}")
	public String fnSiceFunDocumento;
	@Value("${bd.sga.spSicessCustomerRsNom}")
	public String spSicessCustomerRsNom;
	@Value("${bd.sga.spSicessTecnologia}")
	public String spSicessTecnologia;
	@Value("${bd.sga.pkgpostventaone.listadatoscliente}")
	public String spsgassListaDatosCLiente;
	
	
	@Value("${db.dbsgadb.logintimeout}")
	public Integer dbSgaDBLoginTimeout;
	@Value("${db.sgadb.name}")
	public String dbSGADB;
	@Value("${db.sga.owner}")
	public String dbSGADBOwner;
	@Value("${db.sga.owner.operacion}")
	public String dbSGADBOwnerOperacion;
	@Value("${db.sga.owner.intraway}")
	public String dbSGADBOwnerIntraway;
	@Value("${db.sga.owner.atccorp}")
	public String dbSGADBOwnerAtccorp;

	// DATA_SOURCE BSCS70_DESA.TIM.COM.PE
	@Value("${bd.bscs.jndi}")
	public String cJNDI_BSCS;
	@Value("${bd.bscs.ejecucion.timeout}")
	public Integer cEXECUTION_TIMEOUT_BSCS;
	@Value("${bd.bscs.pkgSicesFailure}")
	public String pkgSicesFailureBSCS;
	@Value("${bd.bscs.pkgProvDth}")
	public String pkgProvDth;
	@Value("${bd.bscs.spSicess_customer}")
	public String spSicess_customerBSCS;
	@Value("${bd.bscs.spSicess_customer_rs_nom}")
	public String spSicess_customer_rs_nom;
	@Value("${bd.bscs.spSicess_tecnologia}")
	public String spSicess_tecnologia;
	@Value("${bd.bscs.spSicess_servicebscs}")
	public String spSicess_servicebscs;
	@Value("${bd.bscs.spConsultaDeco}")
	public String spConsultaDeco;

	@Value("${db.dbbscsdb.logintimeout}")
	public Integer dbBscsDBLoginTimeout;
	@Value("${db.bscsdb.name}")
	public String dbBSCSDB;
	@Value("${db.bscs.owner}")
	public String dbBSCSDBOwner;

	// DATA_SOURCE CLARIFY
	@Value("${bd.clarify.jndi}")
	public String cJNDI_CLARIFY;
	@Value("${bd.clarify.ejecucion.timeout}")
	public Integer cEXECUTION_TIMEOUT_CLARIFY;
	@Value("${bd.clarify.pckInteractClfyHfc}")
	public String pckInteractClfyHfc;
	@Value("${bd.clarify.pckCaseClfyHfc}")
	public String pckCaseClfyHfc;
	@Value("${bd.clarify.spQuery_interact_hfc}")
	public String spQuery_interact_hfc;
	@Value("${bd.clarify.spQuery_case_hfc}")
	public String spQuery_case_hfc;

	@Value("${db.dbclarifydb.logintimeout}")
	public Integer dbClarifyDBLoginTimeout;
	@Value("${db.clarifydb.name}")
	public String dbCLARIFYDB;
	@Value("${db.clarify.owner}")
	public String dbCLARIFYDBOwner;
	
	//DATA_SOURCE PUV
	@Value("${bd.pvu.jndi}")
	public String cJNDI_PVU;
	
	@Value("${db.pvu.name}")
	public String dbPVU;
	
	@Value("${db.pvu.owner}")
	public String dbPVUOwner;
	
	@Value("${bd.pvu.spSicess_equipment_ifi}")
	public String spSicess_equipment_ifi;
	
	@Value("${db.pvu.login.timeout}")
	public int dbPVULoginTimeout;
	
	@Value("${bd.pvu.execution.timeout}")
	public Integer dbPVUExecutionTimeout;
	

	// Tecnico
	@Value("${cod.consultaClienteCES.idt1}")
	public String codConsultaClienteCESIdt1;
	@Value("${msj.consultaClienteCES.idt1}")
	public String msjConsultaClienteCESIdt1;
	@Value("${cod.consultaClienteCES.idt2}")
	public String codConsultaClienteCESIdt2;
	@Value("${msj.consultaClienteCES.idt2}")
	public String msjConsultaClienteCESIdt2;

	// Parametros
	@Value("${consultaClienteCES.criterioBscsDni}")
	public String criterioBscsDni;
	@Value("${consultaClienteCES.criterioSgaDni}")
	public String criterioSgaDni;
	@Value("${consultaClienteCES.criterioSgaCodcli}")
	public String criterioSgaCodcli;
	@Value("${consultaClienteCES.tecnologiaHFC}")
	public String tecnologiaHFC;
	@Value("${consultaClienteCES.tecnologiaLTE}")
	public String tecnologiaLTE;
	@Value("${consultaClienteCES.tecnologiaDTH}")
	public String tecnologiaDTH;
	@Value("${consultaClienteCES.tecnologiaIFI}")
	public String tecnologiaIFI;
	@Value("${consultaClienteCES.tecnologiaFTTH}")
	public String tecnologiaFTTH;
	@Value("${consultaClienteCES.plataforma.bscs}")
	public String plataformaBscs;
	@Value("${consultaClienteCES.plataforma.sga}")
	public String plataformaSga;
	@Value("${consultaClienteCES.janus.gepaCode}")
	public String janusGepaCode;
	@Value("${consultaClienteCES.janus.gepaValue}")
	public String janusGepaValue;
	@Value("${consultaClienteCES.serviceSga.gepaCode}")
	public String serviceSgaGepaCode;
	@Value("${consultaClienteCES.serviceSga.gepaValue}")
	public String serviceSgaGepaValue;

	// Excepciones
	@Value("${db.errorSqlTimeoutException}")
	public String dbErrorSqlTimeOutException;

	@Value("${idf0.codigo}")
	public String IDF0CODIGO;
	@Value("${idf0.mensaje}")
	public String IDF0MENSAJE;
	@Value("${idf1.codigo}")
	public String IDF1CODIGO;
	@Value("${idf1.mensaje}")
	public String IDF1MENSAJE;
	@Value("${idf2.codigo}")
	public String IDF2CODIGO;
	@Value("${idf2.mensaje}")
	public String IDF2MENSAJE;

	// DATA_SOURCE BSCS9
	@Value("${bd.bscs9.jndi}")
	public String cJNDI_BSCS9;
	@Value("${bd.bscs9.ejecucion.timeout}")
	public Integer cEXECUTION_TIMEOUT_BSCS9;
	@Value("${bd.bscs9.pkg014SicesfConsultas}")
	public String pkg014SicesfConsultasBSCS9;
	@Value("${bd.bscs9.spSicessCustomer}")
	public String bscs9SpSicessCustomerBSCS9;
	@Value("${bd.bscs9.spSicessTecnologia}")
	public String bscs9SpSicessTecnologia;
	
	@Value("${db.dbbscsdb9.logintimeout}")
	public Integer dbBscsDB9LoginTimeout;
	@Value("${db.bscsdb9.name}")
	public String dbBSCSDB9;
	@Value("${db.bscs9.owner}")
	public String dbBSCSDB9Owner;
	
	@Value("${bd.sga.spSicessNumberPhone}")
	public String spSicessNumberPhone;
	
	@Value("${ws.consulta.linea.cuenta.cbiows.url}")
	public String wsConsultaLineaCuentaCbiowsUrl;
	@Value("${ws.consulta.linea.cuenta.cbiows.nombre}")
	public String wsConsultaLineaCuentaCbiowsNombre;
	@Value("${ws.consulta.linea.cuenta.cbiows.metodo}")
	public String wsConsultaLineaCuentaCbiowsMetodo;
	@Value("${ws.consulta.linea.cuenta.cbiows.request.timeout}")
	public String wsConsultaLineaCuentaCbiowsRequestTimeout;
	@Value("${ws.consulta.linea.cuenta.cbiows.connection.timeout}")
	public String wsConsultaLineaCuentaCbiowsConnectionTimeout;
	
	@Value("${flag.convivencia}")
	public String flagConvivencia;
	@Value("${spSicessNumberPhone.tipo.busqueda}")
	public String spSicessNumberPhoneTipoBusqueda;
	@Value("${consultarLineaCuenta.tipo.busqueda}")
	public String consultarLineaCuentaTipoBusqueda;
	
	@Value("${codigo.pais}")
	public String codigoPais;
	
	//[INICIATIVA-592] - consultarServicio/v24.0 - 16/02/2021	
	@Value("${flag.convivencia.consultarServicio}")
	public String flagConvivenciaConServicio;	
	@Value("${valor.tipo.consulta.consultarServicio}")
	public String valorTipoConsultaConServicio;
	
	
	
	// ------------ DatosRazonWS ------------//
	@Value("${ws.soap.datosRazonWS.uri}")
	public String WS_SOAP_DATOSRAZONWS_URI;
	@Value("${ws.soap.datosRazonWS.connectionTimeout}")
	public String WS_SOAP_DATOSRAZONWS_CONECTIONTIMEOUT;
	@Value("${ws.soap.datosRazonWS.readTimeout}")
	public String WS_SOAP_DATOSRAZONWS_READTIMEOUT;
	@Value("${ws.soap.datosRazonWS.nombre}")
	public String WS_SOAP_DATOSRAZONWS_NOMBRE;
	@Value("${ws.soap.datosRazonWS.metodo}")
	public String WS_SOAP_DATOSRAZONWS_METODO;
	
	@Value("${ws.soap.datosRazonWS.header.nombreAplicacion")
	public String WS_SOAP_datosRazonWS_header_nombreAplicacion;
	@Value("${ws.soap.datosRazonWS.header.ipAplicacion")
	public String WS_SOAP_datosRazonWS_header_ipAplicacion;
	@Value("${ws.soap.datosRazonWS.header.usuarioAplicacion")
	public String WS_SOAP_datosRazonWS_header_usuarioAplicacion;
	
	// ------------ CON_TICKLERS_SEARCH ------------//
	@Value("${ws.soap.ticklersSearchWS.uri}")
	public String WS_SOAP_TICKLERSNWS_URI; 
	@Value("${ws.soap.ticklersSearchWS.connectionTimeout}")
	public String WS_SOAP_TICKLERS_CONECTIONTIMEOUT;
	@Value("${ws.soap.ticklersSearchWS.readTimeout}")
	public String WS_SOAP_TICKLERS_READTIMEOUT;
	@Value("${ws.soap.ticklersSearchWS.nombre}")
	public String WS_SOAP_TICKLERSNWS_NOMBRE;
	@Value("${ws.soap.ticklersSearchWS.metodo}")
	public String WS_SOAP_TICKLERSNWS_METODO;
	
	// ------------ EXTRAS ------------//
	@Value("${ticket.status}")
	public String TICKET_STATUS;
	@Value("${ws.bloqueodesbloqueo.key}")
	public String key;
	@Value("${ws.bloqueodesbloqueo.value}")
	public String value;
	
	// ------------ claro-post-serviciosFija ------------//
	@Value("${ws.rest.serviciosFija.uri}")
	public String WS_REST_serviciosFija_URI; 
	@Value("${ws.rest.serviciosFija.connectionTimeout}")
	public String WS_REST_serviciosFija_CONECTIONTIMEOUT;
	@Value("${ws.rest.serviciosFija.readTimeout}")
	public String WS_REST_serviciosFija_READTIMEOUT;
	@Value("${ws.rest.serviciosFija.nombre}")
	public String WS_REST_serviciosFija_NOMBRE;
	@Value("${ws.rest.serviciosFija.metodo}")
	public String WS_REST_serviciosFija_METODO;
	
	
	@Value("${ws.rest.serviciosFija.header.accept}")
	public String WS_REST_serviciosFija_header_Accept;
	@Value("${ws.rest.serviciosFija.header.aplicacion}")
	public String WS_REST_serviciosFija_header_Aplicacion;
	@Value("${ws.rest.serviciosFija.header.userId}")
	public String WS_REST_serviciosFija_header_UserId;
	
	@Value("${ws.rest.serviciosFija.request.codTecnologia}")
	public String WS_REST_serviciosFija_request_codTecnologia;
	@Value("${ws.rest.serviciosFija.request.FlagServAdicional}")
	public String WS_REST_serviciosFija_request_FlagServAdicional;
	
	// ------------ Otros ------------//
	@Value("${idt1.codigo}")
	public String idt1Codigo; 
	@Value("${idt1.mensaje}")
	public String idt1Mensaje; 
	@Value("${idt2.codigo}")
	public String idt2Codigo;
	@Value("${idt2.mensaje}")
	public String idt2Mensaje;
	@Value("${idt3.codigo}")
	public String idt3Codigo;
	@Value("${idt3.mensaje}")
	public String idt3Mensaje;
	
	@Value("${idt1.codigo.v2}")
	public String idt1Codigov2; 
	@Value("${idt1.mensaje.v2}")
	public String idt1Mensajev2; 
	@Value("${idt2.codigo.v2}")
	public String idt2Codigov2;
	@Value("${idt2.mensaje.v2}")
	public String idt2Mensajev2;
	
	@Value("${header.timestamp.formato}")
	public String headerTimeStampFormato;
	@Value("${idf1.mensaje.v2}")
	public String IDF1MENSAJEV2;
	
	@Value("${idf3.codigo}")
	public String IDF3CODIGO;
	@Value("${idf3.mensaje}")
	public String IDF3MENSAJE;
	
	@Value("${idf4.codigo}")
	public String IDF4CODIGO;
	@Value("${idf4.mensaje}")
	public String IDF4MENSAJE;
	
	@Value("${param.tipoPO.excluido}")
	public String paramTipoPOExcluido;
	@Value("${param.numerogrupo.telefono}")
	public String paramNumerogrupoTelefono;
	@Value("${param.numerogrupo.cable}")
	public String paramNumerogrupoCable;
	@Value("${param.numerogrupo.internet}")
	public String paramNumerogrupoInternet;
	

	@Value("${param.servicioFija.clave.estado}")
	public String paramServicioFijaClaveEstado;

	@Value("${param.servicioFija.valor.estado}")
	public String paramServicioFijaValorEstado;

	@Value("${param.servicioFija.clave.caracteristicas}")
	public String paramServicioFijaClaveCaracteristicas;

	@Value("${param.servicioFija.valor.caracteristicas}")
	public String paramServicioFijaValorCaracteristicas;

}
