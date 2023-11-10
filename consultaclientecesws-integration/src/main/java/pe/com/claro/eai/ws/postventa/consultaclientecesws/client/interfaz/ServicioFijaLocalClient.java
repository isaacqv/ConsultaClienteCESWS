package pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.request.HeaderRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.request.ObtenerServiciosRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.response.ObtenerServiciosResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.WSException;


public interface ServicioFijaLocalClient {

	public ObtenerServiciosResponse obtenerServicios(ObtenerServiciosRequest request, String msgTxIn,
													 HeaderRequest header, Propiedades propiedadesExterna) throws WSException;

}
