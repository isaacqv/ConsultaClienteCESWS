package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ConsultarServicioSucursalRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tecnologia;
	private String codSolot;
	
	public ConsultarServicioSucursalRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConsultarServicioSucursalRequest(String tecnologia, String codSolot) {
		super();
		this.tecnologia = tecnologia;
		this.codSolot = codSolot;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	public String getCodSolot() {
		return codSolot;
	}
	public void setCodSolot(String codSolot) {
		this.codSolot = codSolot;
	}
	
	
}
