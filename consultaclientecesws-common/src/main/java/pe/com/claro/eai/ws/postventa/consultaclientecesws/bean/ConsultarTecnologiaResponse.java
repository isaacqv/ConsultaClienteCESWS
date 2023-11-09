package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.util.List;

public class ConsultarTecnologiaResponse {

	private String po_sourceout;
	private String po_message;
	private List<Tecnologia> listaTecnologia;

	public String getPo_sourceout() {
		return po_sourceout;
	}

	public void setPo_sourceout(String po_sourceout) {
		this.po_sourceout = po_sourceout;
	}

	public String getPo_message() {
		return po_message;
	}

	public void setPo_message(String po_message) {
		this.po_message = po_message;
	}

	public List<Tecnologia> getListaTecnologia() {
		return listaTecnologia;
	}

	public void setListaTecnologia(List<Tecnologia> listaTecnologia) {
		this.listaTecnologia = listaTecnologia;
	}

	@Override
	public String toString() {
		return "[po_sourceout=" + po_sourceout + ", po_message=" + po_message + ", Total listaTecnologia="
				+ listaTecnologia.size() + "]";
	}
}
