package pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.request;

import java.io.Serializable;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.types.ObtenerServiciosRequestType;

public class ObtenerServiciosRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ObtenerServiciosRequestType obtenerServiciosRequestType;

	public ObtenerServiciosRequestType getObtenerServiciosRequestType() {
		return obtenerServiciosRequestType;
	}

	public void setObtenerServiciosRequestType(ObtenerServiciosRequestType obtenerServiciosRequestType) {
		this.obtenerServiciosRequestType = obtenerServiciosRequestType;
	}

}
