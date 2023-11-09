package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.util.List;

public class ConsultarEstadoServiciosResponse {

	private String po_code_result;
	private String po_message_result;
	private List<EstadoServicio> listaEstadoServicio;

	public String getPo_code_result() {
		return po_code_result;
	}

	public void setPo_code_result(String po_code_result) {
		this.po_code_result = po_code_result;
	}

	public String getPo_message_result() {
		return po_message_result;
	}

	public void setPo_message_result(String po_message_result) {
		this.po_message_result = po_message_result;
	}

	public List<EstadoServicio> getListaEstadoServicio() {
		return listaEstadoServicio;
	}

	public void setListaEstadoServicio(List<EstadoServicio> listaEstadoServicio) {
		this.listaEstadoServicio = listaEstadoServicio;
	}

	@Override
	public String toString() {
		return "[po_code_result=" + po_code_result + ", po_message_result=" + po_message_result
				+ ", listaEstadoServicio=" + listaEstadoServicio + "]";
	}
}
