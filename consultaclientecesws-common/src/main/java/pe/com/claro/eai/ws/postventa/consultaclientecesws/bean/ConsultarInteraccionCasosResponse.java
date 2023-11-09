package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ConsultarInteraccionCasosResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private ListaDatosInfVar listDatosInfVar;
	private ListaDatosSot listDatosSot;
	private ListaDatosIncidencia listDatosIncidencia;
	private ListaDatosProblema listDatosProblema;
	private String codRespuesta;
	private String msgRespuesta;

	public ListaDatosInfVar getListDatosInfVar() {
		return listDatosInfVar;
	}

	public void setListDatosInfVar(ListaDatosInfVar listDatosInfVar) {
		this.listDatosInfVar = listDatosInfVar;
	}

	public ListaDatosSot getListDatosSot() {
		return listDatosSot;
	}

	public void setListDatosSot(ListaDatosSot listDatosSot) {
		this.listDatosSot = listDatosSot;
	}

	public ListaDatosIncidencia getListDatosIncidencia() {
		return listDatosIncidencia;
	}

	public void setListDatosIncidencia(ListaDatosIncidencia listDatosIncidencia) {
		this.listDatosIncidencia = listDatosIncidencia;
	}

	public ListaDatosProblema getListDatosProblema() {
		return listDatosProblema;
	}

	public void setListDatosProblema(ListaDatosProblema listDatosProblema) {
		this.listDatosProblema = listDatosProblema;
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
