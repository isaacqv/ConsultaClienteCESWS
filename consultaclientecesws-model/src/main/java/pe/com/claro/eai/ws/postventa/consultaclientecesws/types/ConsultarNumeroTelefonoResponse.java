package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

public class ConsultarNumeroTelefonoResponse {

	private String poCodigoSalida;
	private String poMensajeSalida;
	private ListaNumeroTelefono poCursorNumeroTelefono;
	
	public String getPoCodigoSalida() {
		return poCodigoSalida;
	}
	public void setPoCodigoSalida(String poCodigoSalida) {
		this.poCodigoSalida = poCodigoSalida;
	}
	public String getPoMensajeSalida() {
		return poMensajeSalida;
	}
	public void setPoMensajeSalida(String poMensajeSalida) {
		this.poMensajeSalida = poMensajeSalida;
	}
	public ListaNumeroTelefono getPoCursorNumeroTelefono() {
		return poCursorNumeroTelefono;
	}
	public void setPoCursorNumeroTelefono(ListaNumeroTelefono poCursorNumeroTelefono) {
		this.poCursorNumeroTelefono = poCursorNumeroTelefono;
	}
	
}
