package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ConsultarEquipoRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	// Input principal
	private String tecnologia;
	private String customerId;
	private String codSolot;
	// Input secundario para traer datos complementarios
	private String model;
	private String macSerial;
	private String coId;
	private String uaNumber;

	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMacSerial() {
		return macSerial;
	}
	public void setMacSerial(String macSerial) {
		this.macSerial = macSerial;
	}
	public String getCoId() {
		return coId;
	}
	public void setCoId(String coId) {
		this.coId = coId;
	}
	public String getUaNumber() {
		return uaNumber;
	}
	public void setUaNumber(String uaNumber) {
		this.uaNumber = uaNumber;
	}
	
}
