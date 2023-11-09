package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.util.List;

public class Devices {
	 private String type;
     private String status;
     private List<AttributesDevices> attributes;
     private String  parentId;
     private String  id;
     private String  entityId;
     private String  identifier;
     private String  description;
     private String  lastModifiedBy;
     private String  creationDate;
     private String  lastModified;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getId() {
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
	}
	public List<AttributesDevices> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<AttributesDevices> attributes) {
		this.attributes = attributes;
	}
	
     
}
