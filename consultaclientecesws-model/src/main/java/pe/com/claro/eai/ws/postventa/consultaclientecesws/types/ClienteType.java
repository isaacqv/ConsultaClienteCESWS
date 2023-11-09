
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clienteType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clienteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cuenta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codCli" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="billcycle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nomCli" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombres" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apellidos" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoDoc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numDoc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoPersona" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="categoria" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="distrito" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="provincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="departamento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="telefReferencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estadoCliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="correspElectronica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codSuc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numSlc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clienteType", propOrder = {
    "customerid",
    "cuenta",
    "codCli",
    "billcycle",
    "nomCli",
    "ccname",
    "nombres",
    "apellidos",
    "tipoDoc",
    "numDoc",
    "tipoPersona",
    "categoria",
    "direccion",
    "distrito",
    "provincia",
    "departamento",
    "mail",
    "telefReferencia",
    "estadoCliente",
    "correspElectronica",
    "codSuc",
    "numSlc"
})
public class ClienteType {

    @XmlElement(required = true)
    protected String customerid;
    @XmlElement(required = true)
    protected String cuenta;
    @XmlElement(required = true)
    protected String codCli;
    @XmlElement(required = true)
    protected String billcycle;
    @XmlElement(required = true)
    protected String nomCli;
    @XmlElement(required = true)
    protected String ccname;
    @XmlElement(required = true)
    protected String nombres;
    @XmlElement(required = true)
    protected String apellidos;
    @XmlElement(required = true)
    protected String tipoDoc;
    @XmlElement(required = true)
    protected String numDoc;
    @XmlElement(required = true)
    protected String tipoPersona;
    @XmlElement(required = true)
    protected String categoria;
    @XmlElement(required = true)
    protected String direccion;
    @XmlElement(required = true)
    protected String distrito;
    @XmlElement(required = true)
    protected String provincia;
    @XmlElement(required = true)
    protected String departamento;
    @XmlElement(required = true)
    protected String mail;
    @XmlElement(required = true)
    protected String telefReferencia;
    @XmlElement(required = true)
    protected String estadoCliente;
    @XmlElement(required = true)
    protected String correspElectronica;
    @XmlElement(required = true)
    protected String codSuc;
    @XmlElement(required = true)
    protected String numSlc;

    /**
     * Obtiene el valor de la propiedad customerid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerid() {
        return customerid;
    }

    /**
     * Define el valor de la propiedad customerid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerid(String value) {
        this.customerid = value;
    }

    /**
     * Obtiene el valor de la propiedad cuenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * Define el valor de la propiedad cuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuenta(String value) {
        this.cuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad codCli.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCli() {
        return codCli;
    }

    /**
     * Define el valor de la propiedad codCli.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCli(String value) {
        this.codCli = value;
    }

    /**
     * Obtiene el valor de la propiedad billcycle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillcycle() {
        return billcycle;
    }

    /**
     * Define el valor de la propiedad billcycle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillcycle(String value) {
        this.billcycle = value;
    }

    /**
     * Obtiene el valor de la propiedad nomCli.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomCli() {
        return nomCli;
    }

    /**
     * Define el valor de la propiedad nomCli.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomCli(String value) {
        this.nomCli = value;
    }

    /**
     * Obtiene el valor de la propiedad ccname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcname() {
        return ccname;
    }

    /**
     * Define el valor de la propiedad ccname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcname(String value) {
        this.ccname = value;
    }

    /**
     * Obtiene el valor de la propiedad nombres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Define el valor de la propiedad nombres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombres(String value) {
        this.nombres = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Define el valor de la propiedad apellidos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidos(String value) {
        this.apellidos = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * Define el valor de la propiedad tipoDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDoc(String value) {
        this.tipoDoc = value;
    }

    /**
     * Obtiene el valor de la propiedad numDoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumDoc() {
        return numDoc;
    }

    /**
     * Define el valor de la propiedad numDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumDoc(String value) {
        this.numDoc = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoPersona.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPersona() {
        return tipoPersona;
    }

    /**
     * Define el valor de la propiedad tipoPersona.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPersona(String value) {
        this.tipoPersona = value;
    }

    /**
     * Obtiene el valor de la propiedad categoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define el valor de la propiedad categoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoria(String value) {
        this.categoria = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad distrito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Define el valor de la propiedad distrito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrito(String value) {
        this.distrito = value;
    }

    /**
     * Obtiene el valor de la propiedad provincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Define el valor de la propiedad provincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvincia(String value) {
        this.provincia = value;
    }

    /**
     * Obtiene el valor de la propiedad departamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Define el valor de la propiedad departamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartamento(String value) {
        this.departamento = value;
    }

    /**
     * Obtiene el valor de la propiedad mail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMail() {
        return mail;
    }

    /**
     * Define el valor de la propiedad mail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMail(String value) {
        this.mail = value;
    }

    /**
     * Obtiene el valor de la propiedad telefReferencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefReferencia() {
        return telefReferencia;
    }

    /**
     * Define el valor de la propiedad telefReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefReferencia(String value) {
        this.telefReferencia = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoCliente() {
        return estadoCliente;
    }

    /**
     * Define el valor de la propiedad estadoCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoCliente(String value) {
        this.estadoCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad correspElectronica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrespElectronica() {
        return correspElectronica;
    }

    /**
     * Define el valor de la propiedad correspElectronica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrespElectronica(String value) {
        this.correspElectronica = value;
    }

    /**
     * Obtiene el valor de la propiedad codSuc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSuc() {
        return codSuc;
    }

    /**
     * Define el valor de la propiedad codSuc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSuc(String value) {
        this.codSuc = value;
    }

    /**
     * Obtiene el valor de la propiedad numSlc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSlc() {
        return numSlc;
    }

    /**
     * Define el valor de la propiedad numSlc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSlc(String value) {
        this.numSlc = value;
    }

}
