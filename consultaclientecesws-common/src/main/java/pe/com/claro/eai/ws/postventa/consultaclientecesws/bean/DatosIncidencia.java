package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class DatosIncidencia implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nroIncidencia;
	private String codigoSubCategoria;
	private String tipoIncidencia;
	private String clasificacionIncidencia;
	private String nroTicket;
	private String fechaRegistro;
	private String codigoCaso;
	private String tipoCaso;
	private String estado;
	private String nroServicio;
	private String areaRegistro;
	private String usuarioRegistro;
	private String areaUltimaDerivacion;
	private String usuarioUltimaDerivacion;
	private String fechaUlitmaSecuencia;
	private String solucion;
	private String familia;

	public String getNroIncidencia() {
		return nroIncidencia;
	}

	public void setNroIncidencia(String nroIncidencia) {
		this.nroIncidencia = nroIncidencia;
	}

	public String getCodigoSubCategoria() {
		return codigoSubCategoria;
	}

	public void setCodigoSubCategoria(String codigoSubCategoria) {
		this.codigoSubCategoria = codigoSubCategoria;
	}

	public String getTipoIncidencia() {
		return tipoIncidencia;
	}

	public void setTipoIncidencia(String tipoIncidencia) {
		this.tipoIncidencia = tipoIncidencia;
	}

	public String getClasificacionIncidencia() {
		return clasificacionIncidencia;
	}

	public void setClasificacionIncidencia(String clasificacionIncidencia) {
		this.clasificacionIncidencia = clasificacionIncidencia;
	}

	public String getNroTicket() {
		return nroTicket;
	}

	public void setNroTicket(String nroTicket) {
		this.nroTicket = nroTicket;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getCodigoCaso() {
		return codigoCaso;
	}

	public void setCodigoCaso(String codigoCaso) {
		this.codigoCaso = codigoCaso;
	}

	public String getTipoCaso() {
		return tipoCaso;
	}

	public void setTipoCaso(String tipoCaso) {
		this.tipoCaso = tipoCaso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNroServicio() {
		return nroServicio;
	}

	public void setNroServicio(String nroServicio) {
		this.nroServicio = nroServicio;
	}

	public String getAreaRegistro() {
		return areaRegistro;
	}

	public void setAreaRegistro(String areaRegistro) {
		this.areaRegistro = areaRegistro;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getAreaUltimaDerivacion() {
		return areaUltimaDerivacion;
	}

	public void setAreaUltimaDerivacion(String areaUltimaDerivacion) {
		this.areaUltimaDerivacion = areaUltimaDerivacion;
	}

	public String getUsuarioUltimaDerivacion() {
		return usuarioUltimaDerivacion;
	}

	public void setUsuarioUltimaDerivacion(String usuarioUltimaDerivacion) {
		this.usuarioUltimaDerivacion = usuarioUltimaDerivacion;
	}

	public String getFechaUlitmaSecuencia() {
		return fechaUlitmaSecuencia;
	}

	public void setFechaUlitmaSecuencia(String fechaUlitmaSecuencia) {
		this.fechaUlitmaSecuencia = fechaUlitmaSecuencia;
	}

	public String getSolucion() {
		return solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}
}
