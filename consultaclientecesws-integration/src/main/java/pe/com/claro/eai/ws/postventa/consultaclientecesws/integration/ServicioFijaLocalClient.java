package pe.com.claro.eai.ws.postventa.consultaclientecesws.integration;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.WSException;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.request.HeaderRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.request.ObtenerServiciosRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.response.ObtenerServiciosResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;

public interface ServicioFijaLocalClient {

	public ObtenerServiciosResponse obtenerServicios(ObtenerServiciosRequest request, String msgTxIn,
			HeaderRequest header, Propiedades propiedadesExterna) throws WSException;

}
