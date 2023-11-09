package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ReconectarNcosResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String callBarringType;
	private String codRespuesta;
	private String msgRespuesta;
	
	public String getCallBarringType() {
		return callBarringType;
	}
	public void setCallBarringType(String callBarringType) {
		this.callBarringType = callBarringType;
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
