package pe.com.claro.eai.ws.postventa.consultaclientecesws.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz.IncognitoRest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.request.IncognitoRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.response.IncognitoResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.IncognitoHeader;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.AbstractRestClient;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.ClaroUtil;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Constantes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.JAXBUtilitarios;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.WSException;

@Service
public class IncognitoRestImpl extends AbstractRestClient implements IncognitoRest {
	private static final Logger log = LoggerFactory.getLogger(AuthenticationRestImpl.class);

	IncognitoResponse incognitoResponse = new IncognitoResponse();

	public IncognitoResponse incognito(IncognitoRequest incognitoRequest, IncognitoHeader incognitoHeader, Propiedades propiedades)
			throws WSException {
		long tiempoInicio = System.currentTimeMillis();
		log.info("Inicio Invocación Servicio Incognito \n");
		try {
			String nombreUrl = propiedades.incognitoNombreUrl+"{customerId}";
			String idTransaccion = incognitoHeader.getTransactionId();
			Response response = null;
			Integer readTimeOut = Integer.parseInt(propiedades.incognitoReadTimeOut);
			Integer connectTimeOut = Integer.parseInt(propiedades.incognitoConnectTimeOut);
			Client client = ClientBuilder.newClient();
			client.property(ClientProperties.CONNECT_TIMEOUT, connectTimeOut);
			client.property(ClientProperties.READ_TIMEOUT, readTimeOut);
			
			log.info("REGISTRA REQUEST: \n" + JAXBUtilitarios.anyObjectToXmlText(incognitoRequest));
			log.info("Url del Servicio Incognito [" + nombreUrl + "]");

			log.info("Tiempo de Conexión " + connectTimeOut);
			log.info("Tiempo de Ejecución" + readTimeOut);

			WebTarget webTarget = client.target(nombreUrl)
					.resolveTemplate("customerId", incognitoRequest.getCustomerId());
			
			MultivaluedMap<String, Object> multivaluedMap = new MultivaluedHashMap<String, Object>();
			multivaluedMap.add(Constantes.AUTHORIZATION, incognitoRequest.getAuthorization());
			multivaluedMap.add(Constantes.TRANSACTIONID, incognitoRequest.getTransactionId());

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).headers(multivaluedMap);

			response = invocationBuilder.get();
			
			log.info("{} Response: {}", idTransaccion, response);
			
			Gson gson = new Gson();
			
			String respuesta = response.readEntity(String.class);
			
			incognitoResponse = gson.fromJson(respuesta, IncognitoResponse.class);
			
			String responsePrint = ClaroUtil.printPrettyJSONString(incognitoResponse);
			log.info("SERVICIO Authentication response: " + responsePrint);

		} catch (Exception e) {
			if (e.getMessage().toUpperCase().contains(Constantes.TIMEOUTEXCEPTION.toUpperCase())
					|| e.getMessage().toUpperCase().contains(Constantes.TIMEOUTEXCEPTION2.toUpperCase())) {
				log.error("ERROR DE TIME OUT EXCEPTION" + e.getStackTrace().toString());
				throw new WSException(propiedades.codigoIdt1,
						propiedades.mensajeIdt1.replace("$n", Constantes.SERVICIO_INCOGNITO), e);
			} else {
				log.error(" ERROR EXCEPTION DISPONIBILIDAD" + e.getStackTrace().toString());
				throw new WSException(propiedades.codigoIdt2,
						propiedades.mensajeIdt2.replace("$n", Constantes.SERVICIO_INCOGNITO), e);
			}
		} finally {
			log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
			log.info("Fin Invocación Servicio Incognito \n");
		}
		return incognitoResponse;
	}

	/*
	public IncognitoResponse incognito2(IncognitoRequest incognitoRequest, IncognitoHeader incognitoHeader, Propiedades propiedades)
			throws WSException {
		long tiempoInicio = System.currentTimeMillis();
		log.info("Inicio Invocación Servicio Incognito \n");
		try {
			String nombreUrl = propiedades.incognitoNombreUrl;
			ObjectMapper mapper = new ObjectMapper();
			String idTransaccion = incognitoHeader.getTransactionId();
			log.info("REGISTRA REQUEST: \n" + JAXBUtilitarios.anyObjectToXmlText(incognitoRequest));
			log.info("Url del Servicio Incognito [" + nombreUrl + "]");

			Client clientRest = Client.create();
			Integer readTimeOut = Integer.parseInt(propiedades.incognitoReadTimeOut);
			Integer connectTimeOut = Integer.parseInt(propiedades.incognitoConnectTimeOut);
			clientRest.setReadTimeout(readTimeOut);
			clientRest.setConnectTimeout(connectTimeOut);
			WebResource webResource = clientRest.resource(nombreUrl);
			log.info("Tiempo de Conexión " + connectTimeOut);
			log.info("Tiempo de Ejecución" + readTimeOut);

			MultivaluedMap queryParams = new MultivaluedMapImpl();
			queryParams.add("customerId", incognitoRequest.getCustomerId());

			ClientResponse response = webResource.queryParams(queryParams)
					.header(Constantes.AUTHORIZATION, incognitoRequest.getAuthorization())
					.header(Constantes.SOURCE, incognitoRequest.getSource())
					.header(Constantes.TRANSACTIONID, incognitoRequest.getTransactionId()).get(ClientResponse.class);

			String data = response.getEntity(String.class);
			incognitoResponse = mapper.readValue(data, IncognitoResponse.class);

			String responsePrint = ClaroUtil.printPrettyJSONString(incognitoResponse);
			log.info("SERVICIO Authentication response: " + responsePrint);

			if (incognitoResponse != null) {
				log.info("[" + idTransaccion + "] RESPONSE DIFERENTE DE NULLO ");
				incognitoResponse = mapper.readValue(responsePrint, new TypeReference<IncognitoResponse>() {
				});
			} else {
				incognitoResponse = new IncognitoResponse();
				log.info("[" + idTransaccion + "] RESPONSE  NULLO");
				incognitoResponse.setStatus(propiedades.codigoIdt3);

			}
		} catch (Exception e) {
			if (e.getMessage().toUpperCase().contains(Constantes.TIMEOUTEXCEPTION.toUpperCase())
					|| e.getMessage().toUpperCase().contains(Constantes.TIMEOUTEXCEPTION2.toUpperCase())) {
				log.error("ERROR DE TIME OUT EXCEPTION" + e.getStackTrace().toString());
				throw new WSException(propiedades.codigoIdt1,
						propiedades.mensajeIdt1.replace("$n", Constantes.SERVICIO_INCOGNITO), e);
			} else {
				log.error(" ERROR EXCEPTION DISPONIBILIDAD" + e.getStackTrace().toString());
				throw new WSException(propiedades.codigoIdt2,
						propiedades.mensajeIdt2.replace("$n", Constantes.SERVICIO_INCOGNITO), e);
			}
		} finally {
			log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
			log.info("Fin Invocación Servicio Incognito \n");
		}
		return incognitoResponse;
	}*/

}
