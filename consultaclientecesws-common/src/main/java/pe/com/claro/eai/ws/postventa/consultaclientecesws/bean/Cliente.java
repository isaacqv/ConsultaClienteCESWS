package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private String customerid;
	private String cuenta;
	private String codCli;
	private String billcycle;
	private String nomCli;
	private String ccname;
	private String nombres;
	private String apellidos;
	private String tipoDoc;
	private String numDoc;
	private String tipoPersona;
	private String direccion;
	private String distrito;
	private String provincia;
	private String departamento;
	private String mail;
	private String telefReferencia;
	private String estadoCliente;
	private String correspElectronica;
	private String categoria;
	private String codSuc;
	private String numSlc;
	
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getCodCli() {
		return codCli;
	}
	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}
	public String getBillcycle() {
		return billcycle;
	}
	public void setBillcycle(String billcycle) {
		this.billcycle = billcycle;
	}
	public String getNomCli() {
		return nomCli;
	}
	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}
	public String getCcname() {
		return ccname;
	}
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefReferencia() {
		return telefReferencia;
	}
	public void setTelefReferencia(String telefReferencia) {
		this.telefReferencia = telefReferencia;
	}
	public String getEstadoCliente() {
		return estadoCliente;
	}
	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}
	public String getCorrespElectronica() {
		return correspElectronica;
	}
	public void setCorrespElectronica(String correspElectronica) {
		this.correspElectronica = correspElectronica;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCodSuc() {
		return codSuc;
	}
	public void setCodSuc(String codSuc) {
		this.codSuc = codSuc;
	}
	public String getNumSlc() {
		return numSlc;
	}
	public void setNumSlc(String numSlc) {
		this.numSlc = numSlc;
	}
}
