package pe.com.claro.eai.ws.postventa.consultaclientecesws.dao;

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
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaSGARequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaSGAResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ReconectarNcosRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ReconectarNcosResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.RegistrarAuditoriaRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.RegistrarAuditoriaResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.DBException;

public interface SgaDao {

	ConsultarClienteResponse consultarCliente(String mensajeTransaccion, ConsultarClienteRequest objConsultarClienteRequest) throws DBException;
	ConsultarDetalleSucursalResponse consultarDetalleSucursal(String mensajeTransaccion, ConsultarDetalleSucursalRequest objConsultarDetalleSucursalRequest) throws DBException;
	ConsultarEstadoServiciosResponse consultarEstadoServicios(String mensajeTransaccion, ConsultarEstadoServiciosRequest objConsultarEstadoServiciosRequest) throws DBException;
	ConsultarDetalleSucursalDTHResponse consultarDetalleSucursalDTH(String mensajeTransaccion, ConsultarDetalleSucursalDTHRequest objConsultarDetalleSucursalDthRequest) throws DBException;
	ConsultarJanusResponse consultarJanus(String mensajeTransaccion, ConsultarJanusRequest objConsultarJanusRequest) throws DBException;
	RegistrarAuditoriaResponse registrarAuditoria(String mensajeTransaccion, RegistrarAuditoriaRequest objRegistrarAuditoriaRequest) throws DBException;
	ConsultarServicioResponse consultarServicio(String mensajeTransaccion, ConsultarServicioRequest objConsultarServicioRequest) throws DBException;
	ConsultarSeaChangeResponse consultarSeaChange(String mensajeTransaccion, ConsultarSeaChangeRequest objConsultarSeaChangeRequest) throws DBException;
	ConsultarInteraccionCasosResponse consultarSot(String mensajeTransaccion, ConsultarInteraccionCasosRequest objConsultarInteraccionCasosRequest) throws DBException;
	ConsultarInteraccionCasosResponse consultarIncidencia(String mensajeTransaccion, ConsultarInteraccionCasosRequest objConsultarInteraccionCasosRequest) throws DBException;
	ConsultarFallaResponse consultarFalla(String mensajeTransaccion, ConsultarFallaRequest objConsultarFallaRequest) throws DBException;
	ConsultarEquipoResponse consultarEquipoInternet(String mensajeTransaccion, ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException;
	ConsultarEquipoResponse consultarEquipoTelefonia(String mensajeTransaccion, ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException;
	ConsultarEquipoResponse consultarEquipoCable(String mensajeTransaccion, ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException;
	ConsultarEquipoResponse consultarEquipoComplemento(String mensajeTransaccion, ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException;
	ConsultarReglaResponse consultarRegla(String mensajeTransaccion, ConsultarReglaRequest objConsultarReglaRequest) throws DBException;
	ConsultarReglaResponse consultarReglaComplemento(String mensajeTransaccion, ConsultarReglaRequest objConsultarReglaRequest) throws DBException;
	ReconectarNcosResponse reconectarNcos(String mensajeTransaccion, ReconectarNcosRequest objReconectarNcosRequest) throws DBException;
	ConsultarEquipoResponse consultarEquipoLte(String mensajeTransaccion, ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException;
	ConsultarEquipoResponse consultarEquipoComplementoLTEDTH(String mensajeTransaccion, ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException;
	ConsultarServicioSucursalResponse consultarServicioSucursal(String mensajeTransaccion, ConsultarServicioSucursalRequest ConsultarServicioSucursalRequest) throws DBException;
	ConsultarClienteResponse consultarClienteComplemento(String mensajeTransaccion, ConsultarClienteRequest objConsultarClienteRequest) throws DBException;
	String obtenerNumeroDocumento(String mensajeTransaccion, String strCodCli) throws DBException;
	ConsultarClientePorNombreResponse consultarClientePorNombre(String mensajeTransaccion, ConsultarClientePorNombreRequest objConsultarClientePorNombreRequest) throws DBException;
	ConsultarTecnologiaSGAResponse consultarTecnologia(String paramString, ConsultarTecnologiaSGARequest paramConsultarTecnologiaSGARequest) throws DBException;
}
