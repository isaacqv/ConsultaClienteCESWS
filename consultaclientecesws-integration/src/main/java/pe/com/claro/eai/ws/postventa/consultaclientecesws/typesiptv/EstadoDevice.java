package pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv;

public class EstadoDevice {
	
	private String codigoIptv;
	
	private String codigo;
	
	private String descripcion;
	
	public EstadoDevice() {
	}

	public EstadoDevice(String codigoIptv, String codigo, String descripcion) {
		this.codigoIptv = codigoIptv;
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigoIptv() {
		return codigoIptv;
	}

	public void setCodigoIptv(String codigoIptv) {
		this.codigoIptv = codigoIptv;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
