package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ConsultarSucursalDetalleRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	// Para Sucursales (HFC, LTE, DTH, IFI)
	private String nrodocumento;
	// Para Complemento HFC, LTE
	private String customerId;
	// Para Estado de Servicios
	private String plano;
	private String internet;
	private String telefonia;
	private String cable;
	// Para Complemento DTH
	private String co_id;

	public String getNrodocumento() {
		return nrodocumento;
	}

	public void setNrodocumento(String nrodocumento) {
		this.nrodocumento = nrodocumento;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public String getTelefonia() {
		return telefonia;
	}

	public void setTelefonia(String telefonia) {
		this.telefonia = telefonia;
	}

	public String getCable() {
		return cable;
	}

	public void setCable(String cable) {
		this.cable = cable;
	}

	public String getCo_id() {
		return co_id;
	}

	public void setCo_id(String co_id) {
		this.co_id = co_id;
	}

}