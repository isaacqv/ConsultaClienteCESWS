
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ServicioType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ServicioType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="grupo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="servicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="validoDesde" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoServicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codBloqueo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bloqueo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cargoFijo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServicioType", propOrder = {
    "grupo",
    "servicio",
    "estado",
    "validoDesde",
    "tipoServicio",
    "codBloqueo",
    "bloqueo",
    "cargoFijo"
})
public class ServicioType {

    @XmlElement(required = true)
    protected String grupo;
    @XmlElement(required = true)
    protected String servicio;
    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    protected String validoDesde;
    @XmlElement(required = true)
    protected String tipoServicio;
    @XmlElement(required = true)
    protected String codBloqueo;
    @XmlElement(required = true)
    protected String bloqueo;
    @XmlElement(required = true)
    protected String cargoFijo;

    /**
     * Obtiene el valor de la propiedad grupo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * Define el valor de la propiedad grupo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrupo(String value) {
        this.grupo = value;
    }

    /**
     * Obtiene el valor de la propiedad servicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicio() {
        return servicio;
    }

    /**
     * Define el valor de la propiedad servicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicio(String value) {
        this.servicio = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad validoDesde.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidoDesde() {
        return validoDesde;
    }

    /**
     * Define el valor de la propiedad validoDesde.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidoDesde(String value) {
        this.validoDesde = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoServicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Define el valor de la propiedad tipoServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoServicio(String value) {
        this.tipoServicio = value;
    }

    /**
     * Obtiene el valor de la propiedad codBloqueo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodBloqueo() {
        return codBloqueo;
    }

    /**
     * Define el valor de la propiedad codBloqueo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodBloqueo(String value) {
        this.codBloqueo = value;
    }

    /**
     * Obtiene el valor de la propiedad bloqueo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBloqueo() {
        return bloqueo;
    }

    /**
     * Define el valor de la propiedad bloqueo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBloqueo(String value) {
        this.bloqueo = value;
    }

    /**
     * Obtiene el valor de la propiedad cargoFijo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCargoFijo() {
        return cargoFijo;
    }

    /**
     * Define el valor de la propiedad cargoFijo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCargoFijo(String value) {
        this.cargoFijo = value;
    }

}
