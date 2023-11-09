package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ConsultarSeaChangeResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codRespuesta;
	private String msgRespuesta;
	private ListaSeaChange listSeaChange;

	public String getCodRespuesta() {
		return codRespuesta;
	}

	public void setCodRespuesta(String codRespuesta) {
		this.codRespuesta = codRespuesta;
	}

	public String getMsgRespuesta() {
		return msgRespuesta;
	}

	public void setMsgRespuesta(String msgRespuesta) {
		this.msgRespuesta = msgRespuesta;
	}

	public ListaSeaChange getListSeaChange() {
		return listSeaChange;
	}

	public void setListSeaChange(ListaSeaChange listSeaChange) {
		this.listSeaChange = listSeaChange;
	}

}
