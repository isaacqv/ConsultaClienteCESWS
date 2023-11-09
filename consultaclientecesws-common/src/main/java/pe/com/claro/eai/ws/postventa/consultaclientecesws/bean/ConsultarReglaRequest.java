package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ConsultarReglaRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String customerId;
	private String codSolot;
	private String telefono;
	private String coId;
	private String cicloOAC;
	private String rulers;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCodSolot() {
		return codSolot;
	}
	public void setCodSolot(String codSolot) {
		this.codSolot = codSolot;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCoId() {
		return coId;
	}
	public void setCoId(String coId) {
		this.coId = coId;
	}
	public String getCicloOAC() {
		return cicloOAC;
	}
	public void setCicloOAC(String cicloOAC) {
		this.cicloOAC = cicloOAC;
	}
	public String getRulers() {
		return rulers;
	}
	public void setRulers(String rulers) {
		this.rulers = rulers;
	}
}