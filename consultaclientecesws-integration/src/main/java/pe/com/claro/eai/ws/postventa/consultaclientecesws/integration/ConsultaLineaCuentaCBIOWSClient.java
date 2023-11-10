package pe.com.claro.eai.ws.postventa.consultaclientecesws.integration;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.WSException;
import pe.com.claro.soa.message.consultalineacuentaws.ConsultarLineaCuentaRequest;
import pe.com.claro.soa.message.consultalineacuentaws.ConsultarLineaCuentaResponse;

public interface ConsultaLineaCuentaCBIOWSClient {

	public ConsultarLineaCuentaResponse consultarLineaCuenta(String mensajeTransaccion,
			ConsultarLineaCuentaRequest request) throws WSException;

}
