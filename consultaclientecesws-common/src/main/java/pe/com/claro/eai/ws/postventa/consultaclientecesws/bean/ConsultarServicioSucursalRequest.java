package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

public class ConsultarServicioSucursalRequest {

	private String pi_tecnologia;
	private String pi_codsolot;

	public ConsultarServicioSucursalRequest() {
		super();
	}

	public ConsultarServicioSucursalRequest(String pi_tecnologia, String pi_codsolot) {
		super();
		this.pi_tecnologia = pi_tecnologia;
		this.pi_codsolot = pi_codsolot;
	}

	public String getPi_tecnologia() {
		return pi_tecnologia;
	}

	public void setPi_tecnologia(String pi_tecnologia) {
		this.pi_tecnologia = pi_tecnologia;
	}

	public String getPi_codsolot() {
		return pi_codsolot;
	}

	public void setPi_codsolot(String pi_codsolot) {
		this.pi_codsolot = pi_codsolot;
	}

	@Override
	public String toString() {
		return "[pi_tecnologia=" + pi_tecnologia + ", pi_codsolot=" + pi_codsolot + "]";
	}

}
