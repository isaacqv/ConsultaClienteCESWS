
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DatosSotType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DatosSotType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fecRegistro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="usuRegistro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codSolot" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codTipoTrabajo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoTrabajo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codMotivo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="motivo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estadoSot" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fecAgendamiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estadoAgenda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="observacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosSotType", propOrder = {
    "fecRegistro",
    "usuRegistro",
    "codSolot",
    "codTipoTrabajo",
    "tipoTrabajo",
    "cliente",
    "codMotivo",
    "motivo",
    "estadoSot",
    "codId",
    "fecAgendamiento",
    "estadoAgenda",
    "observacion"
})
public class DatosSotType {

    @XmlElement(required = true)
    protected String fecRegistro;
    @XmlElement(required = true)
    protected String usuRegistro;
    @XmlElement(required = true)
    protected String codSolot;
    @XmlElement(required = true)
    protected String codTipoTrabajo;
    @XmlElement(required = true)
    protected String tipoTrabajo;
    @XmlElement(required = true)
    protected String cliente;
    @XmlElement(required = true)
    protected String codMotivo;
    @XmlElement(required = true)
    protected String motivo;
    @XmlElement(required = true)
    protected String estadoSot;
    @XmlElement(required = true)
    protected String codId;
    @XmlElement(required = true)
    protected String fecAgendamiento;
    @XmlElement(required = true)
    protected String estadoAgenda;
    @XmlElement(required = true)
    protected String observacion;

    /**
     * Obtiene el valor de la propiedad fecRegistro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecRegistro() {
        return fecRegistro;
    }

    /**
     * Define el valor de la propiedad fecRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecRegistro(String value) {
        this.fecRegistro = value;
    }

    /**
     * Obtiene el valor de la propiedad usuRegistro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuRegistro() {
        return usuRegistro;
    }

    /**
     * Define el valor de la propiedad usuRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuRegistro(String value) {
        this.usuRegistro = value;
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
     * Obtiene el valor de la propiedad codTipoTrabajo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoTrabajo() {
        return codTipoTrabajo;
    }

    /**
     * Define el valor de la propiedad codTipoTrabajo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoTrabajo(String value) {
        this.codTipoTrabajo = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoTrabajo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    /**
     * Define el valor de la propiedad tipoTrabajo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTrabajo(String value) {
        this.tipoTrabajo = value;
    }

    /**
     * Obtiene el valor de la propiedad cliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Define el valor de la propiedad cliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCliente(String value) {
        this.cliente = value;
    }

    /**
     * Obtiene el valor de la propiedad codMotivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMotivo() {
        return codMotivo;
    }

    /**
     * Define el valor de la propiedad codMotivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMotivo(String value) {
        this.codMotivo = value;
    }

    /**
     * Obtiene el valor de la propiedad motivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Define el valor de la propiedad motivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivo(String value) {
        this.motivo = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoSot.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoSot() {
        return estadoSot;
    }

    /**
     * Define el valor de la propiedad estadoSot.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoSot(String value) {
        this.estadoSot = value;
    }

    /**
     * Obtiene el valor de la propiedad codId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodId() {
        return codId;
    }

    /**
     * Define el valor de la propiedad codId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodId(String value) {
        this.codId = value;
    }

    /**
     * Obtiene el valor de la propiedad fecAgendamiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecAgendamiento() {
        return fecAgendamiento;
    }

    /**
     * Define el valor de la propiedad fecAgendamiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecAgendamiento(String value) {
        this.fecAgendamiento = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoAgenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoAgenda() {
        return estadoAgenda;
    }

    /**
     * Define el valor de la propiedad estadoAgenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoAgenda(String value) {
        this.estadoAgenda = value;
    }

    /**
     * Obtiene el valor de la propiedad observacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Define el valor de la propiedad observacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservacion(String value) {
        this.observacion = value;
    }

}
