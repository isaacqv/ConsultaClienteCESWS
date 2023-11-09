
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FallaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FallaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroFalla" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="detalleProblema" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="motivo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="observacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tiempoSolucion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaInicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FallaType", propOrder = {
    "numeroFalla",
    "detalleProblema",
    "motivo",
    "observacion",
    "tiempoSolucion",
    "fechaInicio"
})
public class FallaType {

    @XmlElement(required = true)
    protected String numeroFalla;
    @XmlElement(required = true)
    protected String detalleProblema;
    @XmlElement(required = true)
    protected String motivo;
    @XmlElement(required = true)
    protected String observacion;
    @XmlElement(required = true)
    protected String tiempoSolucion;
    @XmlElement(required = true)
    protected String fechaInicio;

    /**
     * Obtiene el valor de la propiedad numeroFalla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroFalla() {
        return numeroFalla;
    }

    /**
     * Define el valor de la propiedad numeroFalla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroFalla(String value) {
        this.numeroFalla = value;
    }

    /**
     * Obtiene el valor de la propiedad detalleProblema.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetalleProblema() {
        return detalleProblema;
    }

    /**
     * Define el valor de la propiedad detalleProblema.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetalleProblema(String value) {
        this.detalleProblema = value;
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

    /**
     * Obtiene el valor de la propiedad tiempoSolucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTiempoSolucion() {
        return tiempoSolucion;
    }

    /**
     * Define el valor de la propiedad tiempoSolucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTiempoSolucion(String value) {
        this.tiempoSolucion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaInicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Define el valor de la propiedad fechaInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaInicio(String value) {
        this.fechaInicio = value;
    }

}
