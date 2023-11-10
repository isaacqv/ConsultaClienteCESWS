package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

public class Modem {
	
	private String deviceModel;
	
	private String status;
	
	private String type;

	private String lastKnownServer;

	private String maxCpe;
	
	/*@JsonProperty("id")
	private String id;
	@JsonProperty("entityId")
	private String entityId;
	@JsonProperty("identifier")
	private String identifier;
	@JsonProperty("description")
	private String description;
	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy;
	@JsonProperty("creationDate")
	private String creationDate;
	@JsonProperty("lastModified")
	private String lastModified;*/

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLastKnownServer() {
		return lastKnownServer;
	}

	public void setLastKnownServer(String lastKnownServer) {
		this.lastKnownServer = lastKnownServer;
	}

	public String getMaxCpe() {
		return maxCpe;
	}

	public void setMaxCpe(String maxCpe) {
		this.maxCpe = maxCpe;
	}

	/*public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}*/
}
