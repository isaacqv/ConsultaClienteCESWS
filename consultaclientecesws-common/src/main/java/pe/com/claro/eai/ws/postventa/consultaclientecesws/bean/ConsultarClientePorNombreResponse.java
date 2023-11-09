package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ConsultarClientePorNombreResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codRespuesta;
	private String msgRespuesta;
	private ListaClientePorNombre listClientePorNombre;

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

	public ListaClientePorNombre getListClientePorNombre() {
		return listClientePorNombre;
	}

	public void setListClientePorNombre(ListaClientePorNombre listClientePorNombre) {
		this.listClientePorNombre = listClientePorNombre;
	}

}
