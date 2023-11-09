
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JanusType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JanusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codPlan" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="producto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoPlan" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fecIni" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flgEstado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ciclo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JanusType", propOrder = {
    "numero",
    "customerid",
    "codPlan",
    "producto",
    "tipoPlan",
    "fecIni",
    "flgEstado",
    "estado",
    "ciclo"
})
public class JanusType {

    @XmlElement(required = true)
    protected String numero;
    @XmlElement(required = true)
    protected String customerid;
    @XmlElement(required = true)
    protected String codPlan;
    @XmlElement(required = true)
    protected String producto;
    @XmlElement(required = true)
    protected String tipoPlan;
    @XmlElement(required = true)
    protected String fecIni;
    @XmlElement(required = true)
    protected String flgEstado;
    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    protected String ciclo;

    /**
     * Obtiene el valor de la propiedad numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define el valor de la propiedad numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtiene el valor de la propiedad customerid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerid() {
        return customerid;
    }

    /**
     * Define el valor de la propiedad customerid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerid(String value) {
        this.customerid = value;
    }

    /**
     * Obtiene el valor de la propiedad codPlan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPlan() {
        return codPlan;
    }

    /**
     * Define el valor de la propiedad codPlan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPlan(String value) {
        this.codPlan = value;
    }

    /**
     * Obtiene el valor de la propiedad producto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducto() {
        return producto;
    }

    /**
     * Define el valor de la propiedad producto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducto(String value) {
        this.producto = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoPlan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPlan() {
        return tipoPlan;
    }

    /**
     * Define el valor de la propiedad tipoPlan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPlan(String value) {
        this.tipoPlan = value;
    }

    /**
     * Obtiene el valor de la propiedad fecIni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecIni() {
        return fecIni;
    }

    /**
     * Define el valor de la propiedad fecIni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecIni(String value) {
        this.fecIni = value;
    }

    /**
     * Obtiene el valor de la propiedad flgEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgEstado() {
        return flgEstado;
    }

    /**
     * Define el valor de la propiedad flgEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgEstado(String value) {
        this.flgEstado = value;
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
     * Obtiene el valor de la propiedad ciclo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiclo() {
        return ciclo;
    }

    /**
     * Define el valor de la propiedad ciclo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiclo(String value) {
        this.ciclo = value;
    }

}
