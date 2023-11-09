package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ResponseDataConsultaInteraccionCasos implements Serializable {

	private static final long serialVersionUID = 1L;

	private ListaDatosInfVar listDatosInfVar;
	private ListaDatosSot listDatosSot;
	private ListaDatosIncidencia listDatosIncidencia;
	private ListaDatosProblema listDatosProblema;

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
}
