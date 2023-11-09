package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class RegistrarAuditoriaRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userApplication;
	private String userSession;
	private String idESBTransaction;

	public String getUserApplication() {
		return userApplication;
	}

	public void setUserApplication(String userApplication) {
		this.userApplication = userApplication;
	}

	public String getUserSession() {
		return userSession;
	}

	public void setUserSession(String userSession) {
		this.userSession = userSession;
	}

	public String getIdESBTransaction() {
		return idESBTransaction;
	}

	public void setIdESBTransaction(String idESBTransaction) {
		this.idESBTransaction = idESBTransaction;
	}

}
