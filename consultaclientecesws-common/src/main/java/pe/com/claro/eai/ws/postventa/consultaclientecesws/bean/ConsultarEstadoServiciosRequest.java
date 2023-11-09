package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.SucursalType;

public class ConsultarEstadoServiciosRequest {

	private String pi_v_plans;
	private Double pi_internet;
	private Double pi_cable;
	private Double pi_telephone;

	public ConsultarEstadoServiciosRequest() {
		super();
	}

	public ConsultarEstadoServiciosRequest(SucursalType request) {
		this.pi_v_plans = request.getPlano();
		this.pi_internet = Double.valueOf(request.getInternet());
		this.pi_cable = Double.valueOf(request.getCable());
		this.pi_telephone = Double.valueOf(request.getTelefonia());
	}

	public String getPi_v_plans() {
		return pi_v_plans;
	}

	public void setPi_v_plans(String pi_v_plans) {
		this.pi_v_plans = pi_v_plans;
	}

	public Double getPi_internet() {
		return pi_internet;
	}

	public void setPi_internet(Double pi_internet) {
		this.pi_internet = pi_internet;
	}

	public Double getPi_cable() {
		return pi_cable;
	}

	public void setPi_cable(Double pi_cable) {
		this.pi_cable = pi_cable;
	}

	public Double getPi_telephone() {
		return pi_telephone;
	}

	public void setPi_telephone(Double pi_telephone) {
		this.pi_telephone = pi_telephone;
	}

	@Override
	public String toString() {
		return "[pi_v_plans=" + pi_v_plans + ", pi_internet=" + pi_internet
				+ ", pi_cable=" + pi_cable + ", pi_telephone=" + pi_telephone + "]";
	}
}
