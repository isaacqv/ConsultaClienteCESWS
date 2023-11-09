
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DatosInfVarType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DatosInfVarType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="interaccion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fecCreacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fecInicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clase" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subClase" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipificacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoCodigo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="claseCodigo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subClaseCodigo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="insertadoPor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoInter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="metodo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hechoEnUno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="agente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreAgente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apellidoAgente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idCaso" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="servicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="inconveniente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contrato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plano" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plataforma" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosInfVarType", propOrder = {
    "interaccion",
    "fecCreacion",
    "fecInicio",
    "telefono",
    "tipo",
    "clase",
    "subClase",
    "tipificacion",
    "tipoCodigo",
    "claseCodigo",
    "subClaseCodigo",
    "insertadoPor",
    "tipoInter",
    "metodo",
    "resultado",
    "hechoEnUno",
    "agente",
    "nombreAgente",
    "apellidoAgente",
    "idCaso",
    "estado",
    "servicio",
    "inconveniente",
    "contrato",
    "plano",
    "plataforma"
})
public class DatosInfVarType {

    @XmlElement(required = true)
    protected String interaccion;
    @XmlElement(required = true)
    protected String fecCreacion;
    @XmlElement(required = true)
    protected String fecInicio;
    @XmlElement(required = true)
    protected String telefono;
    @XmlElement(required = true)
    protected String tipo;
    @XmlElement(required = true)
    protected String clase;
    @XmlElement(required = true)
    protected String subClase;
    @XmlElement(required = true)
    protected String tipificacion;
    @XmlElement(required = true)
    protected String tipoCodigo;
    @XmlElement(required = true)
    protected String claseCodigo;
    @XmlElement(required = true)
    protected String subClaseCodigo;
    @XmlElement(required = true)
    protected String insertadoPor;
    @XmlElement(required = true)
    protected String tipoInter;
    @XmlElement(required = true)
    protected String metodo;
    @XmlElement(required = true)
    protected String resultado;
    @XmlElement(required = true)
    protected String hechoEnUno;
    @XmlElement(required = true)
    protected String agente;
    @XmlElement(required = true)
    protected String nombreAgente;
    @XmlElement(required = true)
    protected String apellidoAgente;
    @XmlElement(required = true)
    protected String idCaso;
    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    protected String servicio;
    @XmlElement(required = true)
    protected String inconveniente;
    @XmlElement(required = true)
    protected String contrato;
    @XmlElement(required = true)
    protected String plano;
    @XmlElement(required = true)
    protected String plataforma;

    /**
     * Obtiene el valor de la propiedad interaccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInteraccion() {
        return interaccion;
    }

    /**
     * Define el valor de la propiedad interaccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInteraccion(String value) {
        this.interaccion = value;
    }

    /**
     * Obtiene el valor de la propiedad fecCreacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecCreacion() {
        return fecCreacion;
    }

    /**
     * Define el valor de la propiedad fecCreacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecCreacion(String value) {
        this.fecCreacion = value;
    }

    /**
     * Obtiene el valor de la propiedad fecInicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecInicio() {
        return fecInicio;
    }

    /**
     * Define el valor de la propiedad fecInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecInicio(String value) {
        this.fecInicio = value;
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
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad clase.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClase() {
        return clase;
    }

    /**
     * Define el valor de la propiedad clase.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClase(String value) {
        this.clase = value;
    }

    /**
     * Obtiene el valor de la propiedad subClase.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubClase() {
        return subClase;
    }

    /**
     * Define el valor de la propiedad subClase.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubClase(String value) {
        this.subClase = value;
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
     * Obtiene el valor de la propiedad tipoCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCodigo() {
        return tipoCodigo;
    }

    /**
     * Define el valor de la propiedad tipoCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCodigo(String value) {
        this.tipoCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad claseCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaseCodigo() {
        return claseCodigo;
    }

    /**
     * Define el valor de la propiedad claseCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaseCodigo(String value) {
        this.claseCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad subClaseCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubClaseCodigo() {
        return subClaseCodigo;
    }

    /**
     * Define el valor de la propiedad subClaseCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubClaseCodigo(String value) {
        this.subClaseCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad insertadoPor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsertadoPor() {
        return insertadoPor;
    }

    /**
     * Define el valor de la propiedad insertadoPor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsertadoPor(String value) {
        this.insertadoPor = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoInter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoInter() {
        return tipoInter;
    }

    /**
     * Define el valor de la propiedad tipoInter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoInter(String value) {
        this.tipoInter = value;
    }

    /**
     * Obtiene el valor de la propiedad metodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetodo() {
        return metodo;
    }

    /**
     * Define el valor de la propiedad metodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetodo(String value) {
        this.metodo = value;
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
     * Obtiene el valor de la propiedad hechoEnUno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHechoEnUno() {
        return hechoEnUno;
    }

    /**
     * Define el valor de la propiedad hechoEnUno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHechoEnUno(String value) {
        this.hechoEnUno = value;
    }

    /**
     * Obtiene el valor de la propiedad agente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgente() {
        return agente;
    }

    /**
     * Define el valor de la propiedad agente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgente(String value) {
        this.agente = value;
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

}
