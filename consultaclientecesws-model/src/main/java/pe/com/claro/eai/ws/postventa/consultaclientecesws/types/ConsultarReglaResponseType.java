
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para consultarReglaResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarReglaResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responseStatus" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}ResponseStatus"/>
 *         &lt;element name="responseData" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}listaReglaType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarReglaResponseType", propOrder = {
    "responseStatus",
    "responseData"
})
public class ConsultarReglaResponseType {

    @XmlElement(required = true)
    protected ResponseStatus responseStatus;
    @XmlElement(required = true)
    protected ListaReglaType responseData;

    /**
     * Obtiene el valor de la propiedad responseStatus.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStatus }
     *     
     */
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    /**
     * Define el valor de la propiedad responseStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStatus }
     *     
     */
    public void setResponseStatus(ResponseStatus value) {
        this.responseStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad responseData.
     * 
     * @return
     *     possible object is
     *     {@link ListaReglaType }
     *     
     */
    public ListaReglaType getResponseData() {
        return responseData;
    }

    /**
     * Define el valor de la propiedad responseData.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaReglaType }
     *     
     */
    public void setResponseData(ListaReglaType value) {
        this.responseData = value;
    }

}
