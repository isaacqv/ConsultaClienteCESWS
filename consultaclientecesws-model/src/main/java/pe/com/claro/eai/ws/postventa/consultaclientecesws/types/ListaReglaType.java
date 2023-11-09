
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaReglaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaReglaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listaRegla" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}reglaType" maxOccurs="unbounded"/>
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
@XmlType(name = "listaReglaType", propOrder = {
    "listaRegla",
    "avOutCodError",
    "avOutDesError"
})
public class ListaReglaType {

    @XmlElement(required = true)
    protected List<ReglaType> listaRegla;
    @XmlElement(required = true)
    protected String avOutCodError;
    @XmlElement(required = true)
    protected String avOutDesError;

    /**
     * Gets the value of the listaRegla property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaRegla property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaRegla().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReglaType }
     * 
     * 
     */
    public List<ReglaType> getListaRegla() {
        if (listaRegla == null) {
            listaRegla = new ArrayList<ReglaType>();
        }
        return this.listaRegla;
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

	public void setListaRegla(List<ReglaType> listaRegla) {
		this.listaRegla = listaRegla;
	}
    
    

}
