package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ConsultarJanusRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sucursal;

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

}
