package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ConsultarClientePorNombreRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tipobusqueda;
	private String valor_busqueda;

	public String getTipobusqueda() {
		return tipobusqueda;
	}

	public void setTipobusqueda(String tipobusqueda) {
		this.tipobusqueda = tipobusqueda;
	}

	public String getValor_busqueda() {
		return valor_busqueda;
	}

	public void setValor_busqueda(String valor_busqueda) {
		this.valor_busqueda = valor_busqueda;
	}

}
