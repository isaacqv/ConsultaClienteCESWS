package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.util.List;

public class Subscribers {
	private String title;
	private String lastName;
	private String firstName;
	private String type;
	private String middleName;
	private String homePhoneNumber;
	private String workPhoneNumber;
	private String otherPhoneNumber;
	private List<Services> services;
	private List<Devices> devices;
//	private String id;
//	private String entityId;
//	private String identifier;
//	private String description;
//	private String lastModifiedBy;
//	private String creationDate;
//	private String lastModified;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	public String getOtherPhoneNumber() {
		return otherPhoneNumber;
	}

	public void setOtherPhoneNumber(String otherPhoneNumber) {
		this.otherPhoneNumber = otherPhoneNumber;
	}

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}


//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getEntityId() {
//		return entityId;
//	}
//
//	public void setEntityId(String entityId) {
//		this.entityId = entityId;
//	}
//
//	public String getIdentifier() {
//		return identifier;
//	}
//
//	public void setIdentifier(String identifier) {
//		this.identifier = identifier;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getLastModifiedBy() {
//		return lastModifiedBy;
//	}
//
//	public void setLastModifiedBy(String lastModifiedBy) {
//		this.lastModifiedBy = lastModifiedBy;
//	}
//
//	public String getCreationDate() {
//		return creationDate;
//	}
//
//	public void setCreationDate(String creationDate) {
//		this.creationDate = creationDate;
//	}
//
//	public String getLastModified() {
//		return lastModified;
//	}
//
//	public void setLastModified(String lastModified) {
//		this.lastModified = lastModified;
//	}

	public List<Devices> getDevices() {
		return devices;
	}

	public void setDevices(List<Devices> devices) {
		this.devices = devices;
	}

}
