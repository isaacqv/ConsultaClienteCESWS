package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.util.List;

public class Services {
	private Device device;
	private String serviceType;
	private String status;
	private String startDate;
	private List<Attributes> attributes;
	
//	private String id;
//	private String entityId;
//	private String identifier;
//	private String description;
//	private String lastModifiedBy;
//	private String creationDate;
//	private String lastModified;


	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

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

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public List<Attributes> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attributes> attributes) {
		this.attributes = attributes;
	}

}
