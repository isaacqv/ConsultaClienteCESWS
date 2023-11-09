package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarServicioRequestType;

public class ConsultarServicioRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String co_id;
	private String cod_sucursal;
	private String plataforma;
	private int codplataforma;

	public ConsultarServicioRequest() {
		super();
	}

	public ConsultarServicioRequest(ConsultarServicioRequestType request, String plataformaSGA, String plataformaBSCS) {
		this.cod_sucursal = request.getCodSucursal();
		this.co_id = request.getCoId();
		this.plataforma = request.getPlataforma();

		if (request.getPlataforma().equals(plataformaSGA)) {
			this.codplataforma = 0;
		} else if (request.getPlataforma().equals(plataformaBSCS)) {
			this.codplataforma = 1;
		} else {
			this.codplataforma = -1;
		}
	}

	public String getCo_id() {
		return co_id;
	}

	public void setCo_id(String co_id) {
		this.co_id = co_id;
	}

	public String getCod_sucursal() {
		return cod_sucursal;
	}

	public void setCod_sucursal(String cod_sucursal) {
		this.cod_sucursal = cod_sucursal;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getCodplataforma() {
		return codplataforma;
	}

	public void setCodplataforma(int codplataforma) {
		this.codplataforma = codplataforma;
	}

}
