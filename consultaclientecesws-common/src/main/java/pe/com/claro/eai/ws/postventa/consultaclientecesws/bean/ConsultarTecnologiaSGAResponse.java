package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.util.List;

public class ConsultarTecnologiaSGAResponse {

	private String po_codigo_salida;
	private String po_mensaje_salida;
	private List<TecnologiaSGA> listaTecnologiaSGA;

	public String getPo_codigo_salida() {
		return po_codigo_salida;
	}

	public void setPo_codigo_salida(String po_codigo_salida) {
		this.po_codigo_salida = po_codigo_salida;
	}

	public String getPo_mensaje_salida() {
		return po_mensaje_salida;
	}

	public void setPo_mensaje_salida(String po_mensaje_salida) {
		this.po_mensaje_salida = po_mensaje_salida;
	}

	public List<TecnologiaSGA> getListaTecnologiaSGA() {
		return listaTecnologiaSGA;
	}

	public void setListaTecnologiaSGA(List<TecnologiaSGA> listaTecnologiaSGA) {
		this.listaTecnologiaSGA = listaTecnologiaSGA;
	}

	@Override
	public String toString() {
		return "[po_codigo_salida=" + po_codigo_salida + ", po_mensaje_salida=" + po_mensaje_salida
				+ ", Total listaTecnologiaSGA=" + listaTecnologiaSGA.size() + "]";
	}

}
