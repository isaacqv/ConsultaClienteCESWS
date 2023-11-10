package pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.response;

import java.io.Serializable;
import javax.validation.Valid;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.types.ClaroFaultType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.types.ObtenerServiciosResponseType;

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
