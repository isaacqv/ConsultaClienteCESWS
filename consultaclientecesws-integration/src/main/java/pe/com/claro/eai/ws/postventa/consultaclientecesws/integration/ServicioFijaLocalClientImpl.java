package pe.com.claro.eai.ws.postventa.consultaclientecesws.integration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.WSException;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.request.HeaderRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.request.ObtenerServiciosRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.response.ObtenerServiciosResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Constantes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Utilities;

@Service
public class ServicioFijaLocalClientImpl implements ServicioFijaLocalClient {

	private static final Logger logger = Logger.getLogger(ServicioFijaLocalClientImpl.class);

	@Autowired
	Propiedades propertiesExterno;

	@Override
	public ObtenerServiciosResponse obtenerServicios(ObtenerServiciosRequest request, String msgTxIn, HeaderRequest header, Propiedades propiedadesExterna)
			throws WSException{
		
		long tiempoInicio = System.currentTimeMillis();
		String nombreComponente = propertiesExterno.WS_REST_serviciosFija_NOMBRE;
		String nombreMetodo = "/" + propertiesExterno.WS_REST_serviciosFija_METODO;
		String url = propertiesExterno.WS_REST_serviciosFija_URI;
		String msjTx = msgTxIn + "[" + propertiesExterno.WS_REST_serviciosFija_METODO + "]";
	
		ObtenerServiciosResponse response = null;
		
		try {
			logger.info(msjTx + "Componente: " + nombreComponente);
			logger.info(msjTx + "Metodo: " + nombreMetodo);
			logger.info(msjTx + "URL: " + url);
			logger.info(msjTx + Constantes.REQUEST_HEADER + Utilities.printPrettyJSONString(header));
			logger.info(msjTx + Constantes.REQUEST_BODY + Utilities.printPrettyJSONString(request));

			Client client;
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, Integer.parseInt(propertiesExterno.WS_REST_serviciosFija_CONECTIONTIMEOUT));
			clientConfig.getProperties().put(ClientConfig.PROPERTY_READ_TIMEOUT, Integer.parseInt(propertiesExterno.WS_REST_serviciosFija_READTIMEOUT));
			client = Client.create(clientConfig);

			Builder builder = client.resource(url).type(MediaType.APPLICATION_JSON);

			builder.header(Constantes.IDTRANSACCION, header.getIdTransaccion());
			builder.header(Constantes.MSGID, header.getMsgid());
			builder.header(Constantes.TIMESTAMP, header.getTimestamp());
			builder.header(Constantes.USERID, header.getUserId());
			builder.header(Constantes.ACCEPT, MediaType.APPLICATION_JSON);
			builder.header(Constantes.APPLICATION, header.getAplicacion());

			response = builder.method(HttpMethod.POST, ObtenerServiciosResponse.class, request);

			logger.info(msjTx + "RESPONSE_BODY" + Utilities.printPrettyJSONString(response));

		} catch (Exception e) {
			logger.error(e, e);
			String error = (e + Constantes.constanteVacio);

			if (error.contains(Constantes.TIMEOUT)) {
				throw new WSException(propertiesExterno.idt1Codigo, String.format(propertiesExterno.idt1Mensaje,
						propertiesExterno.WS_REST_serviciosFija_NOMBRE, propertiesExterno.WS_REST_serviciosFija_METODO),
						e);

			} else {
				throw new WSException(propertiesExterno.idt2Codigo, String.format(propertiesExterno.idt2Mensaje,
						propertiesExterno.WS_REST_serviciosFija_NOMBRE, propertiesExterno.WS_REST_serviciosFija_METODO),
						e);
			}
		}finally {
		      logger.info("[ FIN metodo "+ nombreMetodo + "]");
		      logger.info(" Tiempo total de proceso (ms): " + (System.currentTimeMillis() - tiempoInicio) + " milisegundos");
		 }
		return response;
	}

}
