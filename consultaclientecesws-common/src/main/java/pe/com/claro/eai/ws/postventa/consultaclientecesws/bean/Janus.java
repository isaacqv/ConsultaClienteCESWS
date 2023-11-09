package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class Janus implements Serializable {

	private static final long serialVersionUID = 1L;

	private String numero;
	private String customerid;
	private String codPlan;
	private String producto;
	private String tipoPlan;
	private String fecIni;
	private String flgEstado;
	private String estado;
	private String ciclo;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCodPlan() {
		return codPlan;
	}

	public void setCodPlan(String codPlan) {
		this.codPlan = codPlan;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getTipoPlan() {
		return tipoPlan;
	}

	public void setTipoPlan(String tipoPlan) {
		this.tipoPlan = tipoPlan;
	}

	public String getFecIni() {
		return fecIni;
	}

	public void setFecIni(String fecIni) {
		this.fecIni = fecIni;
	}

	public String getFlgEstado() {
		return flgEstado;
	}

	public void setFlgEstado(String flgEstado) {
		this.flgEstado = flgEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

}
