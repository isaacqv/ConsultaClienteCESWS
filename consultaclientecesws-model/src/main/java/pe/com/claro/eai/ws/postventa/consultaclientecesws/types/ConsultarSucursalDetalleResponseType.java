
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.com.claro.eai.ws.baseschema.AuditResponseType;
import pe.com.claro.eai.ws.baseschema.ParametrosType;


/**
 * <p>Clase Java para consultarSucursalDetalleResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarSucursalDetalleResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auditResponse" type="{http://claro.com.pe/eai/ws/baseschema}auditResponseType"/>
 *         &lt;element name="listaSucursal" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}listaSucursalesType"/>
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
@XmlType(name = "consultarSucursalDetalleResponseType", propOrder = {
    "auditResponse",
    "listaSucursal",
    "listaResponseOpcional"
})
public class ConsultarSucursalDetalleResponseType {

    @XmlElement(required = true)
    protected AuditResponseType auditResponse;
    @XmlElement(required = true)
    protected ListaSucursalesType listaSucursal;
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
     * Obtiene el valor de la propiedad listaSucursal.
     * 
     * @return
     *     possible object is
     *     {@link ListaSucursalesType }
     *     
     */
    public ListaSucursalesType getListaSucursal() {
        return listaSucursal;
    }

    /**
     * Define el valor de la propiedad listaSucursal.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaSucursalesType }
     *     
     */
    public void setListaSucursal(ListaSucursalesType value) {
        this.listaSucursal = value;
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
