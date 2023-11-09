package pe.com.claro.eai.ws.postventa.consultaclientecesws.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz.AuthenticationRest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.request.AuthenticationRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.response.AuthenticationResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.IncognitoHeader;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.AbstractRestClient;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.ClaroUtil;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Constantes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.JAXBUtilitarios;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.UtilIntegration;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.WSException;

@Service
public class AuthenticationRestImpl extends AbstractRestClient implements AuthenticationRest {
	private static final Logger log = LoggerFactory.getLogger(AuthenticationRestImpl.class);

	private UtilIntegration util = new UtilIntegration();
	AuthenticationResponse authenticationResponse = new AuthenticationResponse();

	public AuthenticationResponse authentication(AuthenticationRequest authenticationRequest, IncognitoHeader incognitoHeader,
			Propiedades propiedades) throws WSException {
		long tiempoInicio = System.currentTimeMillis();
		log.info("Inicio Invocación Servicio Authentication \n");
		try {
			String nombreUrl = propiedades.autheticationNombreUrl;
			ObjectMapper mapper = new ObjectMapper();
			log.info("HEADER REQUEST: " + JAXBUtilitarios.anyObjectToXmlText(incognitoHeader));
			log.info("REGISTRA REQUEST: \n" + JAXBUtilitarios.anyObjectToXmlText(authenticationRequest));
			log.info("Url del Servicio authentication [" + nombreUrl + "]");

			Client clientRest = Client.create();
			Integer readTimeOut = Integer.parseInt(propiedades.autheticationReadTimeOut);
			Integer connectTimeOut = Integer.parseInt(propiedades.authenticationConnectTimeOut);
			clientRest.setReadTimeout(readTimeOut);
			clientRest.setConnectTimeout(connectTimeOut);
			WebResource webResource = clientRest.resource(nombreUrl);
			log.info("Tiempo de Conexión " + connectTimeOut);
			log.info("Tiempo de Ejecución" + readTimeOut);

			Builder builder = webResource.type(Constantes.TYPEREQUEST);
			util.setHeaderBuilder(builder, incognitoHeader);

			String requestPrint = ClaroUtil.printPrettyJSONString(authenticationRequest);
			log.info("SERVICIO Authentication request " + requestPrint);

			ClientResponse response = builder.post(ClientResponse.class,
					mapper.writeValueAsString(authenticationRequest));
			String data = response.getEntity(String.class);
			authenticationResponse = mapper.readValue(data, AuthenticationResponse.class);

			String responsePrint = ClaroUtil.printPrettyJSONString(authenticationResponse);
			log.info("SERVICIO Authentication response: " + responsePrint);

		} catch (Exception e) {
			if (e.getMessage().toUpperCase().contains(Constantes.TIMEOUTEXCEPTION.toUpperCase())
					|| e.getMessage().toUpperCase().contains(Constantes.TIMEOUTEXCEPTION2.toUpperCase())) {
				log.error("ERROR DE TIME OUT EXCEPTION" + e.getStackTrace().toString());

				throw new WSException(propiedades.codigoIdt1,
						propiedades.mensajeIdt1.replace("$n", Constantes.SERVICIO_AUTHENTICATION), e);
			} else {
				log.error(" ERROR EXCEPTION DISPONIBILIDAD" + e.getStackTrace().toString());

				throw new WSException(propiedades.codigoIdt2,
						propiedades.mensajeIdt2.replace("$n", Constantes.SERVICIO_AUTHENTICATION), e);
			}
		} finally {
			log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
			log.info("Fin Invocación Servicio Authentication \n");
		}
		return authenticationResponse;
	}

}
