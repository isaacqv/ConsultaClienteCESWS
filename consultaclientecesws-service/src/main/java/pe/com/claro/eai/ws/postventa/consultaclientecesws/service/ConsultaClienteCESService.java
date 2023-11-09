package pe.com.claro.eai.ws.postventa.consultaclientecesws.service;

import javax.xml.ws.Holder;

import pe.com.claro.eai.ws.baseschema.AuditRequestType;
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
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.HeaderRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.HeaderResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ReconectarNcosRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ReconectarNcosResponseType;

public interface ConsultaClienteCESService {

	ConsultarClienteResponseType consultarCliente(ConsultarClienteRequestType objConsultarClienteRequestType);
	ConsultarClientePorNombreResponseType consultarClientePorNombre(ConsultarClientePorNombreRequestType objConsultarClientePorNombreRequestType);
	ConsultarSucursalDetalleResponseType consultarSucursalDetalle(ConsultarSucursalDetalleRequestType objConsultarSucursalDetalleRequestType);
	ConsultarJanusResponseType consultarJanus(HeaderRequest objHeaderRequest, ConsultarJanusRequestType objConsultarJanusRequestType, Holder<HeaderResponse> headerResponse);
	void registrarAuditoria(AuditRequestType objAuditRequestType);
	ConsultarServicioResponseType consultarServicio(ConsultarServicioRequestType objConsultarServicioRequestType);
	ConsultarSeaChangeResponseType consultarSeaChange(HeaderRequest objHeaderRequest, ConsultarSeaChangeRequestType objConsultarSeaChangeRequestType, Holder<HeaderResponse> headerResponse);
	ConsultarInteraccionCasosResponseType consultarInteraccionCasos(ConsultarInteraccionCasosRequestType objConsultarInteraccionCasosRequestType);
	ConsultarFallaResponseType consultarFalla(ConsultarFallaRequestType objConsultarFallaRequestType);
	ConsultarEquipoResponseType consultarEquipo(ConsultarEquipoRequestType objConsultarEquipoRequestType);
	ConsultarReglaResponseType consultarRegla(HeaderRequest objHeaderRequest, ConsultarReglaRequestType objConsultarReglaRequestType, Holder<HeaderResponse> headerResponse);
	ReconectarNcosResponseType reconectarNcos(ReconectarNcosRequestType objReconectarNcosRequestType);

}
