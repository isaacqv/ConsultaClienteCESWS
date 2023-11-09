
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.com.claro.eai.ws.baseschema.AuditRequestType;
import pe.com.claro.eai.ws.baseschema.ParametrosType;


/**
 * <p>Clase Java para consultarClientePorNombreRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarClientePorNombreRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auditRequest" type="{http://claro.com.pe/eai/ws/baseschema}auditRequestType"/>
 *         &lt;element name="tipoBusqueda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="valorBusqueda" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "consultarClientePorNombreRequestType", propOrder = {
    "auditRequest",
    "tipoBusqueda",
    "valorBusqueda",
    "listaRequestOpcional"
})
public class ConsultarClientePorNombreRequestType {

    @XmlElement(required = true)
    protected AuditRequestType auditRequest;
    @XmlElement(required = true)
    protected String tipoBusqueda;
    @XmlElement(required = true)
    protected String valorBusqueda;
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
     * Obtiene el valor de la propiedad tipoBusqueda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoBusqueda() {
        return tipoBusqueda;
    }

    /**
     * Define el valor de la propiedad tipoBusqueda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoBusqueda(String value) {
        this.tipoBusqueda = value;
    }

    /**
     * Obtiene el valor de la propiedad valorBusqueda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorBusqueda() {
        return valorBusqueda;
    }

    /**
     * Define el valor de la propiedad valorBusqueda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorBusqueda(String value) {
        this.valorBusqueda = value;
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
