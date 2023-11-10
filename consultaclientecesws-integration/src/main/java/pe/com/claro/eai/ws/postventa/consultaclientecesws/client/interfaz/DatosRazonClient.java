package pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.WSException;
import pe.com.claro.eai.ws.postventa.datosrazonws.types.ObtenerDatosRequest;
import pe.com.claro.eai.ws.postventa.datosrazonws.types.ObtenerDatosResponse;

public interface DatosRazonClient {

	ObtenerDatosResponse obtenerDatos (ObtenerDatosRequest request, String msgTxIn) throws WSException;
}
