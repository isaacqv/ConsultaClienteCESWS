package pe.com.claro.eai.ws.postventa.consultaclientecesws.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz.IptvRest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv.IptvHeader;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv.IptvResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv.IptvResquest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.AbstractRestClient;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.ClaroUtil;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Constantes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.JAXBUtilitarios;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.UtilIntegration;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.WSException;

@Service
public class IptvRestImpl extends AbstractRestClient implements IptvRest {
	private static final Logger log = LoggerFactory.getLogger(IptvRestImpl.class);
	private UtilIntegration util = new UtilIntegration();

	public IptvResponse consultaSerieIptv(Propiedades propertiesExternos, IptvHeader iptvHeader,
			IptvResquest iptvRequest) throws WSException {
		long tiempoInicio = System.currentTimeMillis();
		IptvResponse iptvResponse = new IptvResponse();
		String idTransaccion=iptvHeader.getTransactionId();
		log.info("Inicio Invocación Servicio Iptv \n");
		try {
			String nombreUrl = propertiesExternos.iptvUrl;
			ObjectMapper mapper = new ObjectMapper();
			log.info(idTransaccion +" HEADER REQUEST: " + JAXBUtilitarios.anyObjectToXmlText(iptvHeader));
			log.info(idTransaccion+ " REGISTRA REQUEST: \n" + JAXBUtilitarios.anyObjectToXmlText(iptvRequest));
			log.info(idTransaccion+"  Url del Servicio IPTV [" + nombreUrl + "]");
			Client clientRest = Client.create();
			Integer readTimeOut = Integer.parseInt(propertiesExternos.iptvReadTimeOut);
			Integer connectTimeOut = Integer.parseInt(propertiesExternos.iptvConnectTimeOut);
			clientRest.setReadTimeout(readTimeOut);
			clientRest.setConnectTimeout(connectTimeOut);
			WebResource webResource = clientRest.resource(nombreUrl);
			log.info(idTransaccion +"Tiempo de Conexión " + connectTimeOut);
			log.info(idTransaccion +" Tiempo de Ejecución" + readTimeOut);
			
			Builder builder = webResource.type(Constantes.TYPEREQUEST);
			util.setHeaderBuilderIPTV(builder, iptvHeader);

			String requestPrint = ClaroUtil.printPrettyJSONString(iptvRequest);
			log.info(idTransaccion+" SERVICIO IPTV request " + requestPrint);

			ClientResponse response = builder.post(ClientResponse.class,
					mapper.writeValueAsString(iptvRequest));
			String data = response.getEntity(String.class);
			iptvResponse = mapper.readValue(data, IptvResponse.class);

			String responsePrint = ClaroUtil.printPrettyJSONString(iptvResponse);
			log.info(idTransaccion+" SERVICIO IPTV response: " + responsePrint);
		} catch (Exception e) {
			if (e.getMessage().toUpperCase().contains(Constantes.TIMEOUTEXCEPTION.toUpperCase())
					|| e.getMessage().toUpperCase().contains(Constantes.TIMEOUTEXCEPTION2.toUpperCase())) {
				log.error("ERROR DE TIME OUT EXCEPTION" + e.getStackTrace().toString());

				throw new WSException(propertiesExternos.codigoIdt1,
						propertiesExternos.mensajeIdt1.replace("$n", Constantes.SERVICIO_IPTV), e);
			} else {
				log.error(" ERROR EXCEPTION DISPONIBILIDAD" + e.getStackTrace().toString());

				throw new WSException(propertiesExternos.codigoIdt2,
						propertiesExternos.mensajeIdt2.replace("$n", Constantes.SERVICIO_IPTV), e);
			}
		} finally {
			log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
			log.info("Fin Invocación Servicio IPTV \n");
		}
		return iptvResponse;
	}

}
