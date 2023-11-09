package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ConsultarFallaResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private ListaFalla listFalla;
	private String codRespuesta;
	private String msgRespuesta;

	public ListaFalla getListFalla() {
		return listFalla;
	}

	public void setListFalla(ListaFalla listFalla) {
		this.listFalla = listFalla;
	}

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

}
