package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ConsultarServicioResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codRespuesta;
	private String msgRespuesta;
	private ListaServicio listServicio;

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

	public ListaServicio getListServicio() {
		return listServicio;
	}

	public void setListServicio(ListaServicio listServicio) {
		this.listServicio = listServicio;
	}

}
