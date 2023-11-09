
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para consultarReglaRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarReglaRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codSolot" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cicloOAC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rulers" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarReglaRequestType", propOrder = {
    "customerId",
    "codSolot",
    "telefono",
    "coId",
    "cicloOAC",
    "rulers"
})
public class ConsultarReglaRequestType {

    @XmlElement(required = true)
    protected String customerId;
    @XmlElement(required = true)
    protected String codSolot;
    @XmlElement(required = true)
    protected String telefono;
    @XmlElement(required = true)
    protected String coId;
    @XmlElement(required = true)
    protected String cicloOAC;
    @XmlElement(required = true)
    protected String rulers;

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
     * Obtiene el valor de la propiedad telefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Define el valor de la propiedad telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
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
     * Obtiene el valor de la propiedad cicloOAC.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCicloOAC() {
        return cicloOAC;
    }

    /**
     * Define el valor de la propiedad cicloOAC.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCicloOAC(String value) {
        this.cicloOAC = value;
    }

    /**
     * Obtiene el valor de la propiedad rulers.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRulers() {
        return rulers;
    }

    /**
     * Define el valor de la propiedad rulers.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRulers(String value) {
        this.rulers = value;
    }

}
