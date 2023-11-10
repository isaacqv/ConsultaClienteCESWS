package pe.com.claro.eai.ws.postventa.consultaclientecesws.response;

import java.util.List;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.Subscribers;

public class IncognitoResponse {
	private String status;
	private String startDate;
	private String serviceProvider;
	private List<Subscribers> subscribers;
	
//	private String id;
//	private String entityId;
//	private String identifier;
//	private String description;
//	private String lastModifiedBy;
//	private String creationDate;
//	private String lastModified;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	
	public List<Subscribers> getSubscribers() {
		return subscribers;
	}
	public void setSubscribers(List<Subscribers> subscribers) {
		this.subscribers = subscribers;
	}
	
	
	
	
}
