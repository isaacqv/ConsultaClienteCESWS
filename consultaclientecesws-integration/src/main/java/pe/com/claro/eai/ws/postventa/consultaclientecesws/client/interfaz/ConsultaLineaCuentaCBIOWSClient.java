package pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.WSException;
import pe.com.claro.soa.message.consultalineacuentaws.ConsultarLineaCuentaRequest;
import pe.com.claro.soa.message.consultalineacuentaws.ConsultarLineaCuentaResponse;

public interface ConsultaLineaCuentaCBIOWSClient {

	public ConsultarLineaCuentaResponse consultarLineaCuenta(String mensajeTransaccion,
			ConsultarLineaCuentaRequest request) throws WSException;

}
