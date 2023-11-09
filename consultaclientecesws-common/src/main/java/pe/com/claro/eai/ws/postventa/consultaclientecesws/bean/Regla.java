package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

public class Regla implements Serializable{
	
	private static final long serialVersionUID = 1L;
    protected String codRegla;
    protected String codRespuesta;
    
	public String getCodRegla() {
		return codRegla;
	}
	public void setCodRegla(String codRegla) {
		this.codRegla = codRegla;
	}
	public String getCodRespuesta() {
		return codRespuesta;
	}
	public void setCodRespuesta(String codRespuesta) {
		this.codRespuesta = codRespuesta;
	}
     
}
