
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para reglaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="reglaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codRegla" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codRespuesta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reglaType", propOrder = {
    "codRegla",
    "codRespuesta"
})
public class ReglaType {

    @XmlElement(required = true)
    protected String codRegla;
    @XmlElement(required = true)
    protected String codRespuesta;

    /**
     * Obtiene el valor de la propiedad codRegla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRegla() {
        return codRegla;
    }

    /**
     * Define el valor de la propiedad codRegla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRegla(String value) {
        this.codRegla = value;
    }

    /**
     * Obtiene el valor de la propiedad codRespuesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRespuesta() {
        return codRespuesta;
    }

    /**
     * Define el valor de la propiedad codRespuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRespuesta(String value) {
        this.codRespuesta = value;
    }

}
