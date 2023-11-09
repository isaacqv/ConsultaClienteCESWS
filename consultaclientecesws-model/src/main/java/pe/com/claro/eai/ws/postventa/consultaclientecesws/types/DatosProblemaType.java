
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DatosProblemaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DatosProblemaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoCliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sitio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idCaso" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaCreacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipificacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="origen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prioridad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="severidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fase" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroReporte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroReclamo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="condicion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cola" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="propietario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreAgente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apellidoAgente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resolucion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bandeja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="claseCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subClaseCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="servicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="inconveniente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contrato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plano" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idInteraccion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="usuarioAplicacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plataforma" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sentido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="montoAjustado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosProblemaType", propOrder = {
    "codigoCliente",
    "sitio",
    "idCaso",
    "fechaCreacion",
    "telefono",
    "tipificacion",
    "origen",
    "estado",
    "prioridad",
    "severidad",
    "fase",
    "nroReporte",
    "nroReclamo",
    "condicion",
    "cola",
    "propietario",
    "nombreAgente",
    "apellidoAgente",
    "resultado",
    "resolucion",
    "bandeja",
    "tipoCode",
    "claseCode",
    "subClaseCode",
    "servicio",
    "inconveniente",
    "contrato",
    "plano",
    "idInteraccion",
    "usuarioAplicacion",
    "plataforma",
    "sentido",
    "montoAjustado"
})
public class DatosProblemaType {

    @XmlElement(required = true)
    protected String codigoCliente;
    @XmlElement(required = true)
    protected String sitio;
    @XmlElement(required = true)
    protected String idCaso;
    @XmlElement(required = true)
    protected String fechaCreacion;
    @XmlElement(required = true)
    protected String telefono;
    @XmlElement(required = true)
    protected String tipificacion;
    @XmlElement(required = true)
    protected String origen;
    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    protected String prioridad;
    @XmlElement(required = true)
    protected String severidad;
    @XmlElement(required = true)
    protected String fase;
    @XmlElement(required = true)
    protected String nroReporte;
    @XmlElement(required = true)
    protected String nroReclamo;
    @XmlElement(required = true)
    protected String condicion;
    @XmlElement(required = true)
    protected String cola;
    @XmlElement(required = true)
    protected String propietario;
    @XmlElement(required = true)
    protected String nombreAgente;
    @XmlElement(required = true)
    protected String apellidoAgente;
    @XmlElement(required = true)
    protected String resultado;
    @XmlElement(required = true)
    protected String resolucion;
    @XmlElement(required = true)
    protected String bandeja;
    @XmlElement(required = true)
    protected String tipoCode;
    @XmlElement(required = true)
    protected String claseCode;
    @XmlElement(required = true)
    protected String subClaseCode;
    @XmlElement(required = true)
    protected String servicio;
    @XmlElement(required = true)
    protected String inconveniente;
    @XmlElement(required = true)
    protected String contrato;
    @XmlElement(required = true)
    protected String plano;
    @XmlElement(required = true)
    protected String idInteraccion;
    @XmlElement(required = true)
    protected String usuarioAplicacion;
    @XmlElement(required = true)
    protected String plataforma;
    @XmlElement(required = true)
    protected String sentido;
    @XmlElement(required = true)
    protected String montoAjustado;

    /**
     * Obtiene el valor de la propiedad codigoCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * Define el valor de la propiedad codigoCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoCliente(String value) {
        this.codigoCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad sitio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSitio() {
        return sitio;
    }

    /**
     * Define el valor de la propiedad sitio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSitio(String value) {
        this.sitio = value;
    }

    /**
     * Obtiene el valor de la propiedad idCaso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCaso() {
        return idCaso;
    }

    /**
     * Define el valor de la propiedad idCaso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCaso(String value) {
        this.idCaso = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaCreacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Define el valor de la propiedad fechaCreacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCreacion(String value) {
        this.fechaCreacion = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Define el valor de la propiedad telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Obtiene el valor de la propiedad tipificacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipificacion() {
        return tipificacion;
    }

    /**
     * Define el valor de la propiedad tipificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipificacion(String value) {
        this.tipificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad origen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Define el valor de la propiedad origen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigen(String value) {
        this.origen = value;
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
     * Obtiene el valor de la propiedad prioridad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Define el valor de la propiedad prioridad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrioridad(String value) {
        this.prioridad = value;
    }

    /**
     * Obtiene el valor de la propiedad severidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeveridad() {
        return severidad;
    }

    /**
     * Define el valor de la propiedad severidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeveridad(String value) {
        this.severidad = value;
    }

    /**
     * Obtiene el valor de la propiedad fase.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFase() {
        return fase;
    }

    /**
     * Define el valor de la propiedad fase.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFase(String value) {
        this.fase = value;
    }

    /**
     * Obtiene el valor de la propiedad nroReporte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroReporte() {
        return nroReporte;
    }

    /**
     * Define el valor de la propiedad nroReporte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroReporte(String value) {
        this.nroReporte = value;
    }

    /**
     * Obtiene el valor de la propiedad nroReclamo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroReclamo() {
        return nroReclamo;
    }

    /**
     * Define el valor de la propiedad nroReclamo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroReclamo(String value) {
        this.nroReclamo = value;
    }

    /**
     * Obtiene el valor de la propiedad condicion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCondicion() {
        return condicion;
    }

    /**
     * Define el valor de la propiedad condicion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCondicion(String value) {
        this.condicion = value;
    }

    /**
     * Obtiene el valor de la propiedad cola.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCola() {
        return cola;
    }

    /**
     * Define el valor de la propiedad cola.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCola(String value) {
        this.cola = value;
    }

    /**
     * Obtiene el valor de la propiedad propietario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * Define el valor de la propiedad propietario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropietario(String value) {
        this.propietario = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreAgente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAgente() {
        return nombreAgente;
    }

    /**
     * Define el valor de la propiedad nombreAgente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAgente(String value) {
        this.nombreAgente = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoAgente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoAgente() {
        return apellidoAgente;
    }

    /**
     * Define el valor de la propiedad apellidoAgente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoAgente(String value) {
        this.apellidoAgente = value;
    }

    /**
     * Obtiene el valor de la propiedad resultado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Define el valor de la propiedad resultado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultado(String value) {
        this.resultado = value;
    }

    /**
     * Obtiene el valor de la propiedad resolucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolucion() {
        return resolucion;
    }

    /**
     * Define el valor de la propiedad resolucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolucion(String value) {
        this.resolucion = value;
    }

    /**
     * Obtiene el valor de la propiedad bandeja.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBandeja() {
        return bandeja;
    }

    /**
     * Define el valor de la propiedad bandeja.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBandeja(String value) {
        this.bandeja = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCode() {
        return tipoCode;
    }

    /**
     * Define el valor de la propiedad tipoCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCode(String value) {
        this.tipoCode = value;
    }

    /**
     * Obtiene el valor de la propiedad claseCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaseCode() {
        return claseCode;
    }

    /**
     * Define el valor de la propiedad claseCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaseCode(String value) {
        this.claseCode = value;
    }

    /**
     * Obtiene el valor de la propiedad subClaseCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubClaseCode() {
        return subClaseCode;
    }

    /**
     * Define el valor de la propiedad subClaseCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubClaseCode(String value) {
        this.subClaseCode = value;
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
     * Obtiene el valor de la propiedad inconveniente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInconveniente() {
        return inconveniente;
    }

    /**
     * Define el valor de la propiedad inconveniente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInconveniente(String value) {
        this.inconveniente = value;
    }

    /**
     * Obtiene el valor de la propiedad contrato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContrato() {
        return contrato;
    }

    /**
     * Define el valor de la propiedad contrato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContrato(String value) {
        this.contrato = value;
    }

    /**
     * Obtiene el valor de la propiedad plano.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlano() {
        return plano;
    }

    /**
     * Define el valor de la propiedad plano.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlano(String value) {
        this.plano = value;
    }

    /**
     * Obtiene el valor de la propiedad idInteraccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdInteraccion() {
        return idInteraccion;
    }

    /**
     * Define el valor de la propiedad idInteraccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdInteraccion(String value) {
        this.idInteraccion = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioAplicacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioAplicacion() {
        return usuarioAplicacion;
    }

    /**
     * Define el valor de la propiedad usuarioAplicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioAplicacion(String value) {
        this.usuarioAplicacion = value;
    }

    /**
     * Obtiene el valor de la propiedad plataforma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * Define el valor de la propiedad plataforma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlataforma(String value) {
        this.plataforma = value;
    }

    /**
     * Obtiene el valor de la propiedad sentido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSentido() {
        return sentido;
    }

    /**
     * Define el valor de la propiedad sentido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSentido(String value) {
        this.sentido = value;
    }

    /**
     * Obtiene el valor de la propiedad montoAjustado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoAjustado() {
        return montoAjustado;
    }

    /**
     * Define el valor de la propiedad montoAjustado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoAjustado(String value) {
        this.montoAjustado = value;
    }

}
