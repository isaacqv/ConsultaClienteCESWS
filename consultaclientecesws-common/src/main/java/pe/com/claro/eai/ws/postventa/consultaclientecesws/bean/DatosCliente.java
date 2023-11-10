package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class DatosCliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String c_contrato;
	private String c_codcliente;
	private String c_plano;
	private String c_ubigeo;
	private String c_estadoservicio;
	private String c_cargoreconx;
	private String c_tecnologia;
	
	
	public DatosCliente() {
		super();
	}

	public DatosCliente(String c_contrato, String c_codcliente, String c_plano, String c_ubigeo,
			String c_estadoservicio, String c_cargoreconx, String c_tecnologia) {
		super();
		this.c_contrato = c_contrato;
		this.c_codcliente = c_codcliente;
		this.c_plano = c_plano;
		this.c_ubigeo = c_ubigeo;
		this.c_estadoservicio = c_estadoservicio;
		this.c_cargoreconx = c_cargoreconx;
		this.c_tecnologia = c_tecnologia;
	}
	
	public String getC_contrato() {
		return c_contrato;
	}
	public void setC_contrato(String c_contrato) {
		this.c_contrato = c_contrato;
	}
	public String getC_codcliente() {
		return c_codcliente;
	}
	public void setC_codcliente(String c_codcliente) {
		this.c_codcliente = c_codcliente;
	}
	public String getC_plano() {
		return c_plano;
	}
	public void setC_plano(String c_plano) {
		this.c_plano = c_plano;
	}
	public String getC_ubigeo() {
		return c_ubigeo;
	}
	public void setC_ubigeo(String c_ubigeo) {
		this.c_ubigeo = c_ubigeo;
	}
	public String getC_estadoservicio() {
		return c_estadoservicio;
	}
	public void setC_estadoservicio(String c_estadoservicio) {
		this.c_estadoservicio = c_estadoservicio;
	}
	public String getC_cargoreconx() {
		return c_cargoreconx;
	}
	public void setC_cargoreconx(String c_cargoreconx) {
		this.c_cargoreconx = c_cargoreconx;
	}
	public String getC_tecnologia() {
		return c_tecnologia;
	}
	public void setC_tecnologia(String c_tecnologia) {
		this.c_tecnologia = c_tecnologia;
	}
	
}
