package pe.com.claro.eai.ws.postventa.consultaclientecesws.response;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ClaroFaultType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ObtenerServiciosResponseType;

import java.io.Serializable;
import javax.validation.Valid;

public class ObtenerServiciosResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Valid
	private ObtenerServiciosResponseType obtenerServiciosResponseType;

	@Valid
	private ClaroFaultType claroFaultType;

	public ObtenerServiciosResponseType getObtenerServiciosResponseType() {
		return obtenerServiciosResponseType;
	}

	public void setObtenerServiciosResponseType(ObtenerServiciosResponseType obtenerServiciosResponseType) {
		this.obtenerServiciosResponseType = obtenerServiciosResponseType;
	}

	public ClaroFaultType getClaroFaultType() {
		return claroFaultType;
	}

	public void setClaroFaultType(ClaroFaultType claroFaultType) {
		this.claroFaultType = claroFaultType;
	}

}
