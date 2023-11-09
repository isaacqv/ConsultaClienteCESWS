
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaSeaChangeType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaSeaChangeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listaSeaChange" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}SeaChangeType" maxOccurs="unbounded"/>
 *         &lt;element name="avOutCodError" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="avOutDesError" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaSeaChangeType", propOrder = {
    "listaSeaChange",
    "avOutCodError",
    "avOutDesError"
})
public class ListaSeaChangeType {

    @XmlElement(required = true)
    protected List<SeaChangeType> listaSeaChange;
    @XmlElement(required = true)
    protected String avOutCodError;
    @XmlElement(required = true)
    protected String avOutDesError;

    /**
     * Gets the value of the listaSeaChange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaSeaChange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaSeaChange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SeaChangeType }
     * 
     * 
     */
    public List<SeaChangeType> getListaSeaChange() {
        if (listaSeaChange == null) {
            listaSeaChange = new ArrayList<SeaChangeType>();
        }
        return this.listaSeaChange;
    }

    public void setListaSeaChange(List<SeaChangeType> listaSeaChange) {
        this.listaSeaChange = listaSeaChange;
    }

    /**
     * Obtiene el valor de la propiedad avOutCodError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvOutCodError() {
        return avOutCodError;
    }

    /**
     * Define el valor de la propiedad avOutCodError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvOutCodError(String value) {
        this.avOutCodError = value;
    }

    /**
     * Obtiene el valor de la propiedad avOutDesError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvOutDesError() {
        return avOutDesError;
    }

    /**
     * Define el valor de la propiedad avOutDesError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvOutDesError(String value) {
        this.avOutDesError = value;
    }

}
