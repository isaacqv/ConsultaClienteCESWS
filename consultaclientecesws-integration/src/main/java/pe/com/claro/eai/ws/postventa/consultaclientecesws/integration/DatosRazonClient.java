package pe.com.claro.eai.ws.postventa.consultaclientecesws.integration;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.WSException;
import pe.com.claro.eai.ws.postventa.datosrazonws.types.ObtenerDatosRequest;
import pe.com.claro.eai.ws.postventa.datosrazonws.types.ObtenerDatosResponse;

public interface DatosRazonClient {

	ObtenerDatosResponse obtenerDatos (ObtenerDatosRequest request, String msgTxIn) throws WSException;;
}
