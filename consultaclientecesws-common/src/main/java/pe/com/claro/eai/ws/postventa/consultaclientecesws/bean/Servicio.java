package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String grupo;
	private String servicio;
	private String estado;
	private String validoDesde;
	private String tipoServicio;
	private String codBloqueo;
	private String bloqueo;
	private String cargoFijo;
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getValidoDesde() {
		return validoDesde;
	}
	public void setValidoDesde(String validoDesde) {
		this.validoDesde = validoDesde;
	}
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public String getCodBloqueo() {
		return codBloqueo;
	}
	public void setCodBloqueo(String codBloqueo) {
		this.codBloqueo = codBloqueo;
	}
	public String getBloqueo() {
		return bloqueo;
	}
	public void setBloqueo(String bloqueo) {
		this.bloqueo = bloqueo;
	}
	public String getCargoFijo() {
		return cargoFijo;
	}
	public void setCargoFijo(String cargoFijo) {
		this.cargoFijo = cargoFijo;
	}
}
