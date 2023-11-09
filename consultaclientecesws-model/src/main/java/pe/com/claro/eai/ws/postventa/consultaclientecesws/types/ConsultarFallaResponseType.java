
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.com.claro.eai.ws.baseschema.AuditResponseType;
import pe.com.claro.eai.ws.baseschema.ParametrosType;


/**
 * <p>Clase Java para consultarFallaResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarFallaResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auditResponse" type="{http://claro.com.pe/eai/ws/baseschema}auditResponseType"/>
 *         &lt;element name="listaFallaCrq" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}FallaType" maxOccurs="unbounded"/>
 *         &lt;element name="listaFallaInc" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}FallaType" maxOccurs="unbounded"/>
 *         &lt;element name="listaResponseOpcional" type="{http://claro.com.pe/eai/ws/baseschema}parametrosType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarFallaResponseType", propOrder = {
    "auditResponse",
    "listaFallaCrq",
    "listaFallaInc",
    "listaResponseOpcional"
})
public class ConsultarFallaResponseType {

    @XmlElement(required = true)
    protected AuditResponseType auditResponse;
    @XmlElement(required = true)
    protected List<FallaType> listaFallaCrq;
    @XmlElement(required = true)
    protected List<FallaType> listaFallaInc;
    @XmlElement(required = true)
    protected ParametrosType listaResponseOpcional;

    /**
     * Obtiene el valor de la propiedad auditResponse.
     * 
     * @return
     *     possible object is
     *     {@link AuditResponseType }
     *     
     */
    public AuditResponseType getAuditResponse() {
        return auditResponse;
    }

    /**
     * Define el valor de la propiedad auditResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditResponseType }
     *     
     */
    public void setAuditResponse(AuditResponseType value) {
        this.auditResponse = value;
    }

    /**
     * Gets the value of the listaFallaCrq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaFallaCrq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaFallaCrq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FallaType }
     * 
     * 
     */
    public List<FallaType> getListaFallaCrq() {
        if (listaFallaCrq == null) {
            listaFallaCrq = new ArrayList<FallaType>();
        }
        return this.listaFallaCrq;
    }

    /**
     * Gets the value of the listaFallaInc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaFallaInc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaFallaInc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FallaType }
     * 
     * 
     */
    public List<FallaType> getListaFallaInc() {
        if (listaFallaInc == null) {
            listaFallaInc = new ArrayList<FallaType>();
        }
        return this.listaFallaInc;
    }

    /**
     * Obtiene el valor de la propiedad listaResponseOpcional.
     * 
     * @return
     *     possible object is
     *     {@link ParametrosType }
     *     
     */
    public ParametrosType getListaResponseOpcional() {
        return listaResponseOpcional;
    }

    /**
     * Define el valor de la propiedad listaResponseOpcional.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametrosType }
     *     
     */
    public void setListaResponseOpcional(ParametrosType value) {
        this.listaResponseOpcional = value;
    }

	public void setListaFallaCrq(List<FallaType> listaFallaCrq) {
		this.listaFallaCrq = listaFallaCrq;
	}

	public void setListaFallaInc(List<FallaType> listaFallaInc) {
		this.listaFallaInc = listaFallaInc;
	}
    
    

}
