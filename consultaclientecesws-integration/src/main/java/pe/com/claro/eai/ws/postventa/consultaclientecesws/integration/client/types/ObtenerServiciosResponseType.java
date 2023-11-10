package pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.types;

import java.io.Serializable;

public class ObtenerServiciosResponseType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AuditResponseType responseAudit;

	private ObtenerServicioResponseDataType responseData;

	public AuditResponseType getResponseAudit() {
		return responseAudit;
	}

	public void setResponseAudit(AuditResponseType responseAudit) {
		this.responseAudit = responseAudit;
	}

	public ObtenerServicioResponseDataType getResponseData() {
		return responseData;
	}

	public void setResponseData(ObtenerServicioResponseDataType responseData) {
		this.responseData = responseData;
	}
}
