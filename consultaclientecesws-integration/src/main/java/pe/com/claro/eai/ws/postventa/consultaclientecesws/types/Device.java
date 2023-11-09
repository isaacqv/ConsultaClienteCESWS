package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.util.List;

public class Device {

	private String type;

	private String status;
	
	private String parentId;

	private String domainName;

	private String oldDomainName;

	private String lastKnownServer;

	private Modem modem;

	private String ipAddress;

	private String gatewayAddress;

	private List<AttributesDevice> attributes;

	private Child child;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getOldDomainName() {
		return oldDomainName;
	}

	public void setOldDomainName(String oldDomainName) {
		this.oldDomainName = oldDomainName;
	}

	public String getLastKnownServer() {
		return lastKnownServer;
	}

	public void setLastKnownServer(String lastKnownServer) {
		this.lastKnownServer = lastKnownServer;
	}

	public Modem getModem() {
		return modem;
	}

	public void setModem(Modem modem) {
		this.modem = modem;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getGatewayAddress() {
		return gatewayAddress;
	}

	public void setGatewayAddress(String gatewayAddress) {
		this.gatewayAddress = gatewayAddress;
	}

	public List<AttributesDevice> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<AttributesDevice> attributes) {
		this.attributes = attributes;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

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

}
