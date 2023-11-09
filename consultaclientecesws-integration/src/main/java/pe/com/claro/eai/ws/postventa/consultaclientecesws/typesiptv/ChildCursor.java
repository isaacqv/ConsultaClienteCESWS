package pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChildCursor {
	
	@JsonProperty("susv_CUSTOMERID")
	private String susvCustomerId;
	
	@JsonProperty("disclv_DEVICEID")
	private String disclvDeviceid;
	
	@JsonProperty("discld_FECHA_ACT")
	private String discldFechaAct;
	
	@JsonProperty("discln_USUARIOID")
	private Integer disclnUsuarioId;
	
	@JsonProperty("disclc_ESTADO")
	private String disclcEstado;

	public String getSusvCustomerId() {
		return susvCustomerId;
	}

	public void setSusvCustomerId(String susvCustomerId) {
		this.susvCustomerId = susvCustomerId;
	}

	public String getDisclvDeviceid() {
		return disclvDeviceid;
	}

	public void setDisclvDeviceid(String disclvDeviceid) {
		this.disclvDeviceid = disclvDeviceid;
	}

	public String getDiscldFechaAct() {
		return discldFechaAct;
	}

	public void setDiscldFechaAct(String discldFechaAct) {
		this.discldFechaAct = discldFechaAct;
	}

	public Integer getDisclnUsuarioId() {
		return disclnUsuarioId;
	}

	public void setDisclnUsuarioId(Integer disclnUsuarioId) {
		this.disclnUsuarioId = disclnUsuarioId;
	}

	public String getDisclcEstado() {
		return disclcEstado;
	}

	public void setDisclcEstado(String disclcEstado) {
		this.disclcEstado = disclcEstado;
	}

}
