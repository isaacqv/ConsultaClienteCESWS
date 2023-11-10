
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SucursalType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SucursalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tecnologia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="co_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoPago" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="motivoEstado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codcli" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codsuc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codsolot" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plano" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ubigeo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="departamento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="provincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="distrito" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="internet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="telefonia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="faspid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="faspmessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="seraffected" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listaServicioSucursal" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}listaServicioSucursalType"/>
 *         &lt;element name="flgPortable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numSlc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plataforma" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SucursalType", propOrder = {
    "tecnologia",
    "customerid",
    "coId",
    "numero",
    "codigoPago",
    "estado",
    "motivoEstado",
    "codcli",
    "codsuc",
    "codsolot",
    "direccion",
    "plano",
    "ubigeo",
    "departamento",
    "provincia",
    "distrito",
    "internet",
    "telefonia",
    "cable",
    "faspid",
    "faspmessage",
    "seraffected",
    "listaServicioSucursal",
    "flgPortable",
    "numSlc",
    "plataforma"
})
public class SucursalType {

	@XmlElement(nillable=true, required = true)
    protected String tecnologia;
	@XmlElement(nillable=true, required = true)
    protected String customerid;
    @XmlElement(name = "co_id", nillable=true, required = true)
    protected String coId;
    @XmlElement(nillable=true, required = true)
    protected String numero;
    @XmlElement(nillable=true, required = true)
    protected String codigoPago;
    @XmlElement(nillable=true, required = true)
    protected String estado;
    @XmlElement(nillable=true, required = true)
    protected String motivoEstado;
    @XmlElement(nillable=true, required = true)
    protected String codcli;
    @XmlElement(nillable=true, required = true)
    protected String codsuc;
    @XmlElement(nillable=true, required = true)
    protected String codsolot;
    @XmlElement(nillable=true, required = true)
    protected String direccion;
    @XmlElement(nillable=true, required = true)
    protected String plano;
    @XmlElement(nillable=true, required = true)
    protected String ubigeo;
    @XmlElement(nillable=true, required = true)
    protected String departamento;
    @XmlElement(nillable=true, required = true)
    protected String provincia;
    @XmlElement(nillable=true, required = true)
    protected String distrito;
    @XmlElement(nillable=true, required = true)
    protected String internet;
    @XmlElement(nillable=true, required = true)
    protected String telefonia;
    @XmlElement(nillable=true, required = true)
    protected String cable;
    @XmlElement(nillable=true, required = true)
    protected String faspid;
    @XmlElement(nillable=true, required = true)
    protected String faspmessage;
    @XmlElement(nillable=true, required = true)
    protected String seraffected;
    @XmlElement(required = true)
    protected ListaServicioSucursalType listaServicioSucursal;
    @XmlElement(nillable=true, required = true)
    protected String flgPortable;
    @XmlElement(nillable=true, required = true)
    protected String numSlc;
    @XmlElement(nillable=true, required = true)
    protected String plataforma;

    /**
     * Obtiene el valor de la propiedad tecnologia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTecnologia() {
        return tecnologia;
    }

    /**
     * Define el valor de la propiedad tecnologia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTecnologia(String value) {
        this.tecnologia = value;
    }

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
     * Obtiene el valor de la propiedad coId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoId() {
        return coId;
    }

    /**
     * Define el valor de la propiedad coId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoId(String value) {
        this.coId = value;
    }

    /**
     * Obtiene el valor de la propiedad numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define el valor de la propiedad numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPago() {
        return codigoPago;
    }

    /**
     * Define el valor de la propiedad codigoPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPago(String value) {
        this.codigoPago = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad motivoEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivoEstado() {
        return motivoEstado;
    }

    /**
     * Define el valor de la propiedad motivoEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivoEstado(String value) {
        this.motivoEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad codcli.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodcli() {
        return codcli;
    }

    /**
     * Define el valor de la propiedad codcli.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodcli(String value) {
        this.codcli = value;
    }

    /**
     * Obtiene el valor de la propiedad codsuc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodsuc() {
        return codsuc;
    }

    /**
     * Define el valor de la propiedad codsuc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodsuc(String value) {
        this.codsuc = value;
    }

    /**
     * Obtiene el valor de la propiedad codsolot.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodsolot() {
        return codsolot;
    }

    /**
     * Define el valor de la propiedad codsolot.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodsolot(String value) {
        this.codsolot = value;
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
     * Obtiene el valor de la propiedad plano.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlano() {
        return plano;
    }

    /**
     * Define el valor de la propiedad plano.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlano(String value) {
        this.plano = value;
    }

    /**
     * Obtiene el valor de la propiedad ubigeo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbigeo() {
        return ubigeo;
    }

    /**
     * Define el valor de la propiedad ubigeo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbigeo(String value) {
        this.ubigeo = value;
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
     * Obtiene el valor de la propiedad internet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternet() {
        return internet;
    }

    /**
     * Define el valor de la propiedad internet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternet(String value) {
        this.internet = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonia() {
        return telefonia;
    }

    /**
     * Define el valor de la propiedad telefonia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonia(String value) {
        this.telefonia = value;
    }

    /**
     * Obtiene el valor de la propiedad cable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCable() {
        return cable;
    }

    /**
     * Define el valor de la propiedad cable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCable(String value) {
        this.cable = value;
    }

    /**
     * Obtiene el valor de la propiedad faspid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaspid() {
        return faspid;
    }

    /**
     * Define el valor de la propiedad faspid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaspid(String value) {
        this.faspid = value;
    }

    /**
     * Obtiene el valor de la propiedad faspmessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaspmessage() {
        return faspmessage;
    }

    /**
     * Define el valor de la propiedad faspmessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaspmessage(String value) {
        this.faspmessage = value;
    }

    /**
     * Obtiene el valor de la propiedad seraffected.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeraffected() {
        return seraffected;
    }

    /**
     * Define el valor de la propiedad seraffected.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeraffected(String value) {
        this.seraffected = value;
    }

    /**
     * Obtiene el valor de la propiedad listaServicioSucursal.
     * 
     * @return
     *     possible object is
     *     {@link ListaServicioSucursalType }
     *     
     */
    public ListaServicioSucursalType getListaServicioSucursal() {
        return listaServicioSucursal;
    }

    /**
     * Define el valor de la propiedad listaServicioSucursal.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaServicioSucursalType }
     *     
     */
    public void setListaServicioSucursal(ListaServicioSucursalType value) {
        this.listaServicioSucursal = value;
    }

    /**
     * Obtiene el valor de la propiedad flgPortable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgPortable() {
        return flgPortable;
    }

    /**
     * Define el valor de la propiedad flgPortable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgPortable(String value) {
        this.flgPortable = value;
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

    /**
     * Obtiene el valor de la propiedad plataforma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * Define el valor de la propiedad plataforma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlataforma(String value) {
        this.plataforma = value;
    }

}