
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.com.claro.eai.ws.baseschema.AuditRequestType;
import pe.com.claro.eai.ws.baseschema.ParametrosType;


/**
 * <p>Clase Java para consultarServicioRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarServicioRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auditRequest" type="{http://claro.com.pe/eai/ws/baseschema}auditRequestType"/>
 *         &lt;element name="co_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cod_sucursal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plataforma" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "consultarServicioRequestType", propOrder = {
    "auditRequest",
    "coId",
    "codSucursal",
    "plataforma",
    "listaRequestOpcional"
})
public class ConsultarServicioRequestType {

    @XmlElement(required = true)
    protected AuditRequestType auditRequest;
    @XmlElement(name = "co_id", required = true)
    protected String coId;
    @XmlElement(name = "cod_sucursal", required = true)
    protected String codSucursal;
    @XmlElement(required = true)
    protected String plataforma;
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
     * Obtiene el valor de la propiedad codSucursal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSucursal() {
        return codSucursal;
    }

    /**
     * Define el valor de la propiedad codSucursal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSucursal(String value) {
        this.codSucursal = value;
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
