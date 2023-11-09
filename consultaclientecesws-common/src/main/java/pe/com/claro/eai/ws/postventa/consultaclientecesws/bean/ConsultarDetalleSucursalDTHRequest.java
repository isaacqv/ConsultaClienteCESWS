package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

public class ConsultarDetalleSucursalDTHRequest {

	private Double pi_co_id;

	public ConsultarDetalleSucursalDTHRequest() {
		super();
	}

	public ConsultarDetalleSucursalDTHRequest(Double pi_co_id) {
		super();
		this.pi_co_id = pi_co_id;
	}

	public Double getPi_co_id() {
		return pi_co_id;
	}

	public void setPi_co_id(Double pi_co_id) {
		this.pi_co_id = pi_co_id;
	}

	@Override
	public String toString() {
		return "[pi_co_id=" + pi_co_id + "]";
	}

}
