package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

public class ConsultarDetalleSucursalRequest {

	private Double pi_customer_id;

	public ConsultarDetalleSucursalRequest() {
		super();
	}

	public ConsultarDetalleSucursalRequest(Double pi_customer_id) {
		super();
		this.pi_customer_id = pi_customer_id;
	}

	public Double getPi_customer_id() {
		return pi_customer_id;
	}

	public void setPi_customer_id(Double pi_customer_id) {
		this.pi_customer_id = pi_customer_id;
	}

	@Override
	public String toString() {
		return "[pi_customer_id=" + pi_customer_id + "]";
	}

}
