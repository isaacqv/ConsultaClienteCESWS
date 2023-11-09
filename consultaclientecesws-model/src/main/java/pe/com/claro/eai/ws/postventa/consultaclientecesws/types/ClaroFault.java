
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para ClaroFault complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ClaroFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idAudit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeError" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descriptionError" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="locationError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="originError" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClaroFault", propOrder = {
    "idAudit",
    "codeError",
    "descriptionError",
    "locationError",
    "date",
    "originError"
})
public class ClaroFault {

    @XmlElement(required = true)
    protected String idAudit;
    @XmlElement(required = true)
    protected String codeError;
    @XmlElement(required = true)
    protected String descriptionError;
    protected String locationError;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected Object originError;

    /**
     * Obtiene el valor de la propiedad idAudit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAudit() {
        return idAudit;
    }

    /**
     * Define el valor de la propiedad idAudit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAudit(String value) {
        this.idAudit = value;
    }

    /**
     * Obtiene el valor de la propiedad codeError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeError() {
        return codeError;
    }

    /**
     * Define el valor de la propiedad codeError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeError(String value) {
        this.codeError = value;
    }

    /**
     * Obtiene el valor de la propiedad descriptionError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriptionError() {
        return descriptionError;
    }

    /**
     * Define el valor de la propiedad descriptionError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriptionError(String value) {
        this.descriptionError = value;
    }

    /**
     * Obtiene el valor de la propiedad locationError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationError() {
        return locationError;
    }

    /**
     * Define el valor de la propiedad locationError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationError(String value) {
        this.locationError = value;
    }

    /**
     * Obtiene el valor de la propiedad date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Define el valor de la propiedad date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtiene el valor de la propiedad originError.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getOriginError() {
        return originError;
    }

    /**
     * Define el valor de la propiedad originError.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setOriginError(Object value) {
        this.originError = value;
    }

}
