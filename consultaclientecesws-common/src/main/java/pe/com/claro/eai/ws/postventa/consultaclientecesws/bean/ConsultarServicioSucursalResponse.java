package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.util.List;

public class ConsultarServicioSucursalResponse {

	private String po_codigo_salida;
	private String po_mensaje_salida;
	private List<ServicioSucursal> listaServicioSucursal;

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

	public List<ServicioSucursal> getListaServicioSucursal() {
		return listaServicioSucursal;
	}

	public void setListaServicioSucursal(List<ServicioSucursal> listaServicioSucursal) {
		this.listaServicioSucursal = listaServicioSucursal;
	}

	@Override
	public String toString() {
		return "[po_codigo_salida=" + po_codigo_salida + ", po_mensaje_salida=" + po_mensaje_salida
				+ ", Total listaServicioSucursal=" + listaServicioSucursal.size() + "]";
	}
}
