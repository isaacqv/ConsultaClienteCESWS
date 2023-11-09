
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.com.claro.eai.ws.baseschema.AuditRequestType;
import pe.com.claro.eai.ws.baseschema.ParametrosType;


/**
 * <p>Clase Java para consultarEquipoRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarEquipoRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auditRequest" type="{http://claro.com.pe/eai/ws/baseschema}auditRequestType"/>
 *         &lt;element name="tecnologia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codSolot" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listaRequestOpcional" type="{http://claro.com.pe/eai/ws/baseschema}parametrosType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarEquipoRequestType", propOrder = {
    "auditRequest",
    "tecnologia",
    "customerId",
    "codSolot",
    "coId",
    "listaRequestOpcional"
})
public class ConsultarEquipoRequestType {

    @XmlElement(required = true)
    protected AuditRequestType auditRequest;
    @XmlElement(required = true)
    protected String tecnologia;
    @XmlElement(required = true)
    protected String customerId;
    @XmlElement(required = true)
    protected String codSolot;
    @XmlElement(required = true)
    protected String coId;
    @XmlElement(required = true)
    protected ParametrosType listaRequestOpcional;

    /**
     * Obtiene el valor de la propiedad auditRequest.
     * 
     * @return
     *     possible object is
     *     {@link AuditRequestType }
     *     
     */
    public AuditRequestType getAuditRequest() {
        return auditRequest;
    }

    /**
     * Define el valor de la propiedad auditRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditRequestType }
     *     
     */
    public void setAuditRequest(AuditRequestType value) {
        this.auditRequest = value;
    }

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
     * Obtiene el valor de la propiedad customerId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Define el valor de la propiedad customerId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerId(String value) {
        this.customerId = value;
    }

    /**
     * Obtiene el valor de la propiedad codSolot.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSolot() {
        return codSolot;
    }

    /**
     * Define el valor de la propiedad codSolot.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSolot(String value) {
        this.codSolot = value;
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
     * Obtiene el valor de la propiedad listaRequestOpcional.
     * 
     * @return
     *     possible object is
     *     {@link ParametrosType }
     *     
     */
    public ParametrosType getListaRequestOpcional() {
        return listaRequestOpcional;
    }

    /**
     * Define el valor de la propiedad listaRequestOpcional.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametrosType }
     *     
     */
    public void setListaRequestOpcional(ParametrosType value) {
        this.listaRequestOpcional = value;
    }

}
