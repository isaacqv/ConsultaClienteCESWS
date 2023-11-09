package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;
import java.util.List;

public class ConsultarEquipoResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codRespuesta;
	private String msgRespuesta;
	private List<Equipo> listEquipo;
	
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
	public List<Equipo> getListEquipo() {
		return listEquipo;
	}
	public void setListEquipo(List<Equipo> listEquipo) {
		this.listEquipo = listEquipo;
	}
}
