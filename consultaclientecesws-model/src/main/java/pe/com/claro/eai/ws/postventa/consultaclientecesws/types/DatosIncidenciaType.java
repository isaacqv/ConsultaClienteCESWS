
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para DatosIncidenciaType complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DatosIncidenciaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nroIncidencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoSubCategoria" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoIncidencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clasificacionIncidencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroTicket" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaRegistro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoCaso" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoCaso" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroServicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="areaRegistro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="usuarioRegistro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="areaUltimaDerivacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="usuarioUltimaDerivacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaUlitmaSecuencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="solucion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="familia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosIncidenciaType", propOrder = { "nroIncidencia", "codigoSubCategoria", "tipoIncidencia",
		"clasificacionIncidencia", "nroTicket", "fechaRegistro", "codigoCaso", "tipoCaso", "estado", "nroServicio",
		"areaRegistro", "usuarioRegistro", "areaUltimaDerivacion", "usuarioUltimaDerivacion", "fechaUlitmaSecuencia",
		"solucion", "familia" })
public class DatosIncidenciaType {

	@XmlElement(required = true)
	protected String nroIncidencia;
	@XmlElement(required = true)
	protected String codigoSubCategoria;
	@XmlElement(required = true)
	protected String tipoIncidencia;
	@XmlElement(required = true)
	protected String clasificacionIncidencia;
	@XmlElement(required = true)
	protected String nroTicket;
	@XmlElement(required = true)
	protected String fechaRegistro;
	@XmlElement(required = true)
	protected String codigoCaso;
	@XmlElement(required = true)
	protected String tipoCaso;
	@XmlElement(required = true)
	protected String estado;
	@XmlElement(required = true)
	protected String nroServicio;
	@XmlElement(required = true)
	protected String areaRegistro;
	@XmlElement(required = true)
	protected String usuarioRegistro;
	@XmlElement(required = true)
	protected String areaUltimaDerivacion;
	@XmlElement(required = true)
	protected String usuarioUltimaDerivacion;
	@XmlElement(required = true)
	protected String fechaUlitmaSecuencia;
	@XmlElement(required = true)
	protected String solucion;
	@XmlElement(required = true)
	protected String familia;

	/**
	 * Obtiene el valor de la propiedad nroIncidencia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNroIncidencia() {
		return nroIncidencia;
	}

	/**
	 * Define el valor de la propiedad nroIncidencia.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNroIncidencia(String value) {
		this.nroIncidencia = value;
	}

	/**
	 * Obtiene el valor de la propiedad codigoSubCategoria.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodigoSubCategoria() {
		return codigoSubCategoria;
	}

	/**
	 * Define el valor de la propiedad codigoSubCategoria.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodigoSubCategoria(String value) {
		this.codigoSubCategoria = value;
	}

	/**
	 * Obtiene el valor de la propiedad tipoIncidencia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTipoIncidencia() {
		return tipoIncidencia;
	}

	/**
	 * Define el valor de la propiedad tipoIncidencia.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTipoIncidencia(String value) {
		this.tipoIncidencia = value;
	}

	/**
	 * Obtiene el valor de la propiedad clasificacionIncidencia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getClasificacionIncidencia() {
		return clasificacionIncidencia;
	}

	/**
	 * Define el valor de la propiedad clasificacionIncidencia.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setClasificacionIncidencia(String value) {
		this.clasificacionIncidencia = value;
	}

	/**
	 * Obtiene el valor de la propiedad nroTicket.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNroTicket() {
		return nroTicket;
	}

	/**
	 * Define el valor de la propiedad nroTicket.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNroTicket(String value) {
		this.nroTicket = value;
	}

	/**
	 * Obtiene el valor de la propiedad fechaRegistro.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Define el valor de la propiedad fechaRegistro.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFechaRegistro(String value) {
		this.fechaRegistro = value;
	}

	/**
	 * Obtiene el valor de la propiedad codigoCaso.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodigoCaso() {
		return codigoCaso;
	}

	/**
	 * Define el valor de la propiedad codigoCaso.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodigoCaso(String value) {
		this.codigoCaso = value;
	}

	/**
	 * Obtiene el valor de la propiedad tipoCaso.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTipoCaso() {
		return tipoCaso;
	}

	/**
	 * Define el valor de la propiedad tipoCaso.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTipoCaso(String value) {
		this.tipoCaso = value;
	}

	/**
	 * Obtiene el valor de la propiedad estado.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Define el valor de la propiedad estado.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEstado(String value) {
		this.estado = value;
	}

	/**
	 * Obtiene el valor de la propiedad nroServicio.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNroServicio() {
		return nroServicio;
	}

	/**
	 * Define el valor de la propiedad nroServicio.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNroServicio(String value) {
		this.nroServicio = value;
	}

	/**
	 * Obtiene el valor de la propiedad areaRegistro.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAreaRegistro() {
		return areaRegistro;
	}

	/**
	 * Define el valor de la propiedad areaRegistro.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAreaRegistro(String value) {
		this.areaRegistro = value;
	}

	/**
	 * Obtiene el valor de la propiedad usuarioRegistro.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	/**
	 * Define el valor de la propiedad usuarioRegistro.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUsuarioRegistro(String value) {
		this.usuarioRegistro = value;
	}

	/**
	 * Obtiene el valor de la propiedad areaUltimaDerivacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAreaUltimaDerivacion() {
		return areaUltimaDerivacion;
	}

	/**
	 * Define el valor de la propiedad areaUltimaDerivacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAreaUltimaDerivacion(String value) {
		this.areaUltimaDerivacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad usuarioUltimaDerivacion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUsuarioUltimaDerivacion() {
		return usuarioUltimaDerivacion;
	}

	/**
	 * Define el valor de la propiedad usuarioUltimaDerivacion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUsuarioUltimaDerivacion(String value) {
		this.usuarioUltimaDerivacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad fechaUlitmaSecuencia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFechaUlitmaSecuencia() {
		return fechaUlitmaSecuencia;
	}

	/**
	 * Define el valor de la propiedad fechaUlitmaSecuencia.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFechaUlitmaSecuencia(String value) {
		this.fechaUlitmaSecuencia = value;
	}

	/**
	 * Obtiene el valor de la propiedad solucion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSolucion() {
		return solucion;
	}

	/**
	 * Define el valor de la propiedad solucion.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSolucion(String value) {
		this.solucion = value;
	}

	/**
	 * Obtiene el valor de la propiedad familia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFamilia() {
		return familia;
	}

	/**
	 * Define el valor de la propiedad familia.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFamilia(String value) {
		this.familia = value;
	}

}