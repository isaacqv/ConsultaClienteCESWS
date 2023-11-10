package pe.com.claro.eai.ws.postventa.consultaclientecesws.request;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ObtenerServiciosRequestType;

import java.io.Serializable;

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
