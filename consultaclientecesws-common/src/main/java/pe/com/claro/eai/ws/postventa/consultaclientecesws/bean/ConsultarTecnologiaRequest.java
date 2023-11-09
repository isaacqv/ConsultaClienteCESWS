package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

public class ConsultarTecnologiaRequest {

	private String pi_documento;

	public ConsultarTecnologiaRequest() {
		super();
	}

	public ConsultarTecnologiaRequest(String pi_documento) {
		super();
		this.pi_documento = pi_documento;
	}

	public String getPi_documento() {
		return pi_documento;
	}

	public void setPi_documento(String pi_documento) {
		this.pi_documento = pi_documento;
	}

	@Override
	public String toString() {
		return "[pi_documento=" + pi_documento + "]";
	}
}
