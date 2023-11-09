
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.com.claro.eai.ws.baseschema.AuditResponseType;
import pe.com.claro.eai.ws.baseschema.ParametrosType;


/**
 * <p>Clase Java para consultarEquipoResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarEquipoResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auditResponse" type="{http://claro.com.pe/eai/ws/baseschema}auditResponseType"/>
 *         &lt;element name="listaEquipo" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}listaEquipoType"/>
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
@XmlType(name = "consultarEquipoResponseType", propOrder = {
    "auditResponse",
    "listaEquipo",
    "listaResponseOpcional"
})
public class ConsultarEquipoResponseType {

    @XmlElement(required = true)
    protected AuditResponseType auditResponse;
    @XmlElement(required = true)
    protected ListaEquipoType listaEquipo;
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
     * Obtiene el valor de la propiedad listaEquipo.
     * 
     * @return
     *     possible object is
     *     {@link ListaEquipoType }
     *     
     */
    public ListaEquipoType getListaEquipo() {
        return listaEquipo;
    }

    /**
     * Define el valor de la propiedad listaEquipo.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaEquipoType }
     *     
     */
    public void setListaEquipo(ListaEquipoType value) {
        this.listaEquipo = value;
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

}
