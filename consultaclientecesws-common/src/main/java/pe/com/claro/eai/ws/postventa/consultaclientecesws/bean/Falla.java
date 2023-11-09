package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class Falla implements Serializable {

	private static final long serialVersionUID = 1L;

	private String numeroFalla;
	private String detalleProblema;
	private String motivo;
	private String observacion;
	private String tiempoSolucion;
	private String fechaInicio;

	public String getNumeroFalla() {
		return numeroFalla;
	}

	public void setNumeroFalla(String numeroFalla) {
		this.numeroFalla = numeroFalla;
	}

	public String getDetalleProblema() {
		return detalleProblema;
	}

	public void setDetalleProblema(String detalleProblema) {
		this.detalleProblema = detalleProblema;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTiempoSolucion() {
		return tiempoSolucion;
	}

	public void setTiempoSolucion(String tiempoSolucion) {
		this.tiempoSolucion = tiempoSolucion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

}
