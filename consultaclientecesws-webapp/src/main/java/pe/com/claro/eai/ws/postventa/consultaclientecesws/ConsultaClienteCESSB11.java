package pe.com.claro.eai.ws.postventa.consultaclientecesws;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.Holder;
import javax.xml.ws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.service.ConsultaClienteCESService;
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

@WebService(portName = "ebsconsultaClienteCESSB11", serviceName = "ConsultaClienteCESWSService", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws", wsdlLocation = "/WEB-INF/wsdl/ConsultaClienteCESWS.wsdl", endpointInterface = "pe.com.claro.eai.ws.postventa.consultaclientecesws.ConsultaClienteCESWSPortType")
@BindingType(SOAPBinding.SOAP11HTTP_BINDING)
public class ConsultaClienteCESSB11 implements ConsultaClienteCESWSPortType {

	@Autowired
	private ConsultaClienteCESService service;

	@PostConstruct
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@WebMethod(action = "http://claro.com.pe/eai/postventa/consultaclientecesws/consultarCliente")
    @WebResult(name = "consultarClienteResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarClienteResponseMsg")
    public ConsultarClienteResponseType consultarCliente(
        @WebParam(name = "consultarClienteRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarClienteRequestMsg")
        ConsultarClienteRequestType consultarClienteRequestMsg){
		return service.consultarCliente(consultarClienteRequestMsg);
	}

    @WebMethod(action = "http://claro.com.pe/eai/postventa/consultaclientecesws/consultarClientePorNombre")
    @WebResult(name = "consultarClientePorNombreResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarClientePorNombreResponseMsg")
	public ConsultarClientePorNombreResponseType consultarClientePorNombre(
		@WebParam(name = "consultarClientePorNombreRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarClientePorNombreRequestMsg")
        ConsultarClientePorNombreRequestType consultarClientePorNombreRequestMsg){
		// TODO Auto-generated method stub
		return service.consultarClientePorNombre(consultarClientePorNombreRequestMsg);
	}

	@WebMethod(action = "http://claro.com.pe/eai/postventa/consultaclientecesws/consultarSucursalDetalle")
    @WebResult(name = "consultarSucursalDetalleResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarSucursalDetalleResponseMsg")
    public ConsultarSucursalDetalleResponseType consultarSucursalDetalle(
        @WebParam(name = "consultarSucursalDetalleRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarSucursalDetalleRequestMsg")
        ConsultarSucursalDetalleRequestType consultarSucursalDetalleRequestMsg){
		return service.consultarSucursalDetalle(consultarSucursalDetalleRequestMsg);
	}

	@WebMethod(action = "http://claro.com.pe/eai/postventa/consultaclientecesws/consultarJanus")
	@WebResult(name = "consultarJanusResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarJanusResponseMsg")
	public ConsultarJanusResponseType consultarJanus(
			@WebParam(name = "consultarJanusRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarJanusRequestMsg") ConsultarJanusRequestType consultarJanusRequestMsg,
			@WebParam(name = "headerRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", header = true, partName = "headerRequest") HeaderRequest headerRequest,
			@WebParam(name = "headerResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", header = true, mode = WebParam.Mode.OUT, partName = "headerResponse") Holder<HeaderResponse> headerResponse)
			throws ClaroFault {
		// TODO Auto-generated method stub
		return service.consultarJanus(headerRequest, consultarJanusRequestMsg, headerResponse);
	}
	
	@WebMethod(action = "http://claro.com.pe/eai/postventa/consultaclientecesws/consultarServicio")
    @WebResult(name = "consultarServicioResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarServicioResponseMsg")
    public ConsultarServicioResponseType consultarServicio(
        @WebParam(name = "consultarServicioRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarServicioRequestMsg")
        ConsultarServicioRequestType consultarServicioRequestMsg){
		return service.consultarServicio(consultarServicioRequestMsg);
	}

	@WebMethod(action = "http://claro.com.pe/eai/postventa/consultaclientecesws/consultarSeaChange")
	@WebResult(name = "consultarSeaChangeResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarSeaChangeResponseMsg")
	public ConsultarSeaChangeResponseType consultarSeaChange(
			@WebParam(name = "consultarSeaChangeRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarSeaChangeRequestMsg") ConsultarSeaChangeRequestType consultarSeaChangeRequestMsg,
			@WebParam(name = "headerRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", header = true, partName = "headerRequest") HeaderRequest headerRequest,
			@WebParam(name = "headerResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", header = true, mode = WebParam.Mode.OUT, partName = "headerResponse") Holder<HeaderResponse> headerResponse)
			throws ClaroFault {
		// TODO Auto-generated method stub
		return service.consultarSeaChange(headerRequest, consultarSeaChangeRequestMsg, headerResponse);
	}

	@WebMethod(action = "http://claro.com.pe/eai/postventa/consultaclientecesws/consultarInteraccionCasos")
	@WebResult(name = "consultarInteraccionCasosResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarInteraccionCasosResponseMsg")
	public ConsultarInteraccionCasosResponseType consultarInteraccionCasos(
			@WebParam(name = "consultarInteraccionCasosRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarInteraccionCasosRequestMsg")
	        ConsultarInteraccionCasosRequestType consultarInteraccionCasosRequestMsg)
			throws ClaroFault {
		return service.consultarInteraccionCasos(consultarInteraccionCasosRequestMsg);
	}

	@WebMethod(action = "http://claro.com.pe/eai/postventa/consultaclientecesws/consultarFalla")
	@WebResult(name = "consultarFallaResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarFallaResponseMsg")
	public ConsultarFallaResponseType consultarFalla(
			@WebParam(name = "consultarFallaRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarFallaRequestMsg") ConsultarFallaRequestType consultarFallaRequestMsg)
			throws ClaroFault {
		// TODO Auto-generated method stub
		return service.consultarFalla(consultarFallaRequestMsg);
	}

	@WebMethod(action = "http://claro.com.pe/eai/postventa/consultaclientecesws/consultarEquipo")
    @WebResult(name = "consultarEquipoResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarEquipoResponseMsg")
    public ConsultarEquipoResponseType consultarEquipo(
        @WebParam(name = "consultarEquipoRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarEquipoRequestMsg")
        ConsultarEquipoRequestType consultarEquipoRequestMsg){
		return service.consultarEquipo(consultarEquipoRequestMsg);
	}

    @WebMethod(action = "http://claro.com.pe/eai/postventa/consultaclientecesws/consultarRegla")
    @WebResult(name = "consultarReglaResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarReglaResponseMsg")
	public ConsultarReglaResponseType consultarRegla(
	        @WebParam(name = "consultarReglaRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "consultarReglaRequestMsg") ConsultarReglaRequestType consultarReglaRequestMsg,
	        @WebParam(name = "headerRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", header = true, partName = "headerRequest") HeaderRequest headerRequest,
	        @WebParam(name = "headerResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", header = true, mode = WebParam.Mode.OUT, partName = "headerResponse") Holder<HeaderResponse> headerResponse) 
	        throws ClaroFault {
		// TODO Auto-generated method stub
		return service.consultarRegla(headerRequest, consultarReglaRequestMsg, headerResponse);
	}
    
    @WebMethod(action = "http://claro.com.pe/eai/postventa/consultaclientecesws/reconectarNcos")
    @WebResult(name = "reconectarNcosResponse", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "reconectarNcosResponseMsg")
    public ReconectarNcosResponseType reconectarNcos(
        @WebParam(name = "reconectarNcosRequest", targetNamespace = "http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types", partName = "reconectarNcosRequestMsg")
        ReconectarNcosRequestType reconectarNcosRequestMsg){
    	return service.reconectarNcos(reconectarNcosRequestMsg);
    }

}
