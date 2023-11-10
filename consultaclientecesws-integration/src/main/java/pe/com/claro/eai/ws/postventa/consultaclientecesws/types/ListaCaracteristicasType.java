package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.io.Serializable;

public class ListaCaracteristicasType implements Serializable {

	private static final long serialVersionUID = 1L;
	private String descripcionGrupo;
	private String numeroGrupo;
	private String poServicio;
	private String spcodedes;
	private String tipoPO;
	private String categoriaServicio;
	private String validoDesde;
	private String estado;
	private String tipoServicio;
	private String monto;
	
	public String getDescripcionGrupo() {
		return descripcionGrupo;
	}
	public void setDescripcionGrupo(String descripcionGrupo) {
		this.descripcionGrupo = descripcionGrupo;
	}
	public String getNumeroGrupo() {
		return numeroGrupo;
	}
	public void setNumeroGrupo(String numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
	}
	public String getPoServicio() {
		return poServicio;
	}
	public void setPoServicio(String poServicio) {
		this.poServicio = poServicio;
	}
	public String getSpcodedes() {
		return spcodedes;
	}
	public void setSpcodedes(String spcodedes) {
		this.spcodedes = spcodedes;
	}
	public String getTipoPO() {
		return tipoPO;
	}
	public void setTipoPO(String tipoPO) {
		this.tipoPO = tipoPO;
	}
	public String getCategoriaServicio() {
		return categoriaServicio;
	}
	public void setCategoriaServicio(String categoriaServicio) {
		this.categoriaServicio = categoriaServicio;
	}
	public String getValidoDesde() {
		return validoDesde;
	}
	public void setValidoDesde(String validoDesde) {
		this.validoDesde = validoDesde;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}
}
