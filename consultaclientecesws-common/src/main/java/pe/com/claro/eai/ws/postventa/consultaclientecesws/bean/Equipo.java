package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class Equipo implements Serializable {

	private static final long serialVersionUID = 1L;
	// Output General
	private String type;
	private String customerId;
	private String model;
	private String macAddress;
	private String serialNumber;
	private String equipmentCodeInc;
	private String modelCodeInc;
	private String cardNumber;
	private String uaNumber;
	// Output Internet
	private String hub;
	private String nodo;
	private String activationCode;
	private String cantPcs;
	// Output Telefonia
	private String idProducto;
	private String profileCrmId;
	// Output Cable
	private String idVenta;
	private String disabled;
	private String serviceName;
	private String channelMap;
	// Output Complementario
	private String identifier;
	private String descModelInc;
	private String descMarkInc;
	private String parentId;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getEquipmentCodeInc() {
		return equipmentCodeInc;
	}
	public void setEquipmentCodeInc(String equipmentCodeInc) {
		this.equipmentCodeInc = equipmentCodeInc;
	}
	public String getModelCodeInc() {
		return modelCodeInc;
	}
	public void setModelCodeInc(String modelCodeInc) {
		this.modelCodeInc = modelCodeInc;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getUaNumber() {
		return uaNumber;
	}
	public void setUaNumber(String uaNumber) {
		this.uaNumber = uaNumber;
	}
	public String getHub() {
		return hub;
	}
	public void setHub(String hub) {
		this.hub = hub;
	}
	public String getNodo() {
		return nodo;
	}
	public void setNodo(String nodo) {
		this.nodo = nodo;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public String getCantPcs() {
		return cantPcs;
	}
	public void setCantPcs(String cantPcs) {
		this.cantPcs = cantPcs;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getProfileCrmId() {
		return profileCrmId;
	}
	public void setProfileCrmId(String profileCrmId) {
		this.profileCrmId = profileCrmId;
	}
	public String getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getChannelMap() {
		return channelMap;
	}
	public void setChannelMap(String channelMap) {
		this.channelMap = channelMap;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getDescModelInc() {
		return descModelInc;
	}
	public void setDescModelInc(String descModelInc) {
		this.descModelInc = descModelInc;
	}
	public String getDescMarkInc() {
		return descMarkInc;
	}
	public void setDescMarkInc(String descMarkInc) {
		this.descMarkInc = descMarkInc;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
