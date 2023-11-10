package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class ObtenerDatosClienteResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String o_error;
	private String o_msg;
	private ListaDatosCliente listDatosCliente;
		
	public ObtenerDatosClienteResponse() {
		super();
	}
	
	public ObtenerDatosClienteResponse(String o_error, String o_msg, ListaDatosCliente listDatosCliente) {
		super();
		this.o_error = o_error;
		this.o_msg = o_msg;
		this.listDatosCliente = listDatosCliente;
	}
	
	public String getO_error() {
		return o_error;
	}
	public void setO_error(String o_error) {
		this.o_error = o_error;
	}
	public String getO_msg() {
		return o_msg;
	}
	public void setO_msg(String o_msg) {
		this.o_msg = o_msg;
	}
	public ListaDatosCliente getListDatosCliente() {
		return listDatosCliente;
	}
	public void setListDatosCliente(ListaDatosCliente listDatosCliente) {
		this.listDatosCliente = listDatosCliente;
	}
	
	
}
