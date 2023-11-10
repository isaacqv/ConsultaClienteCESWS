package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.ConstantesValidacion;

public class ResponseStatusType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message = ConstantesValidacion.NOT_NULL)
	private String idTransaccion;
	@NotNull(message = ConstantesValidacion.NOT_NULL)
	private String codigoRespuesta;
	@NotNull(message = ConstantesValidacion.NOT_NULL)
	private String mensajeRespuesta;

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

}
