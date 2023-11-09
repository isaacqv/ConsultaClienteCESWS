package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class DatosSot implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fecRegistro;
	private String usuRegistro;
	private String codSolot;
	private String codTipoTrabajo;
	private String tipoTrabajo;
	private String cliente;
	private String codMotivo;
	private String motivo;
	private String estadoSot;
	private String codId;
	private String fecAgendamiento;
	private String estadoAgenda;
	private String observacion;

	public String getFecRegistro() {
		return fecRegistro;
	}
	public void setFecRegistro(String fecRegistro) {
		this.fecRegistro = fecRegistro;
	}
	public String getUsuRegistro() {
		return usuRegistro;
	}
	public void setUsuRegistro(String usuRegistro) {
		this.usuRegistro = usuRegistro;
	}
	public String getCodSolot() {
		return codSolot;
	}
	public void setCodSolot(String codSolot) {
		this.codSolot = codSolot;
	}
	public String getCodTipoTrabajo() {
		return codTipoTrabajo;
	}
	public void setCodTipoTrabajo(String codTipoTrabajo) {
		this.codTipoTrabajo = codTipoTrabajo;
	}
	public String getTipoTrabajo() {
		return tipoTrabajo;
	}
	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCodMotivo() {
		return codMotivo;
	}
	public void setCodMotivo(String codMotivo) {
		this.codMotivo = codMotivo;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getEstadoSot() {
		return estadoSot;
	}
	public void setEstadoSot(String estadoSot) {
		this.estadoSot = estadoSot;
	}
	public String getCodId() {
		return codId;
	}
	public void setCodId(String codId) {
		this.codId = codId;
	}
	public String getFecAgendamiento() {
		return fecAgendamiento;
	}
	public void setFecAgendamiento(String fecAgendamiento) {
		this.fecAgendamiento = fecAgendamiento;
	}
	public String getEstadoAgenda() {
		return estadoAgenda;
	}
	public void setEstadoAgenda(String estadoAgenda) {
		this.estadoAgenda = estadoAgenda;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}	
}
