package pe.com.claro.eai.ws.postventa.consultaclientecesws.integration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ericsson.services.ws_cil_7.TicklersSearchService;
import com.ericsson.services.ws_cil_7.ticklerssearch.TicklersSearchRequest;
import com.ericsson.services.ws_cil_7.ticklerssearch.TicklersSearchResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.WSException;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Constantes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.JAXBUtilitarios;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;

@Service
public class TicketSearchClientImpl implements TicklersSearchClient {

	private static final Logger logger = Logger.getLogger(TicketSearchClientImpl.class);

	@Autowired
	private TicklersSearchService portTypeConTicketsSearchWS;

	@Autowired
	Propiedades propiedadesExterna;

	@Override
	public TicklersSearchResponse ticklersSearch(TicklersSearchRequest request, String msgTxIn) throws WSException {

		long tiempoInicio = System.currentTimeMillis();
		String urlWS = propiedadesExterna.WS_SOAP_TICKLERSNWS_URI;
		String metodoWSLinea = propiedadesExterna.WS_SOAP_TICKLERSNWS_METODO;
		String msjTx = msgTxIn + "[" + metodoWSLinea + "]";
		TicklersSearchResponse response = new TicklersSearchResponse();

		try {

			logger.info(msjTx + "[INICIO de metodo " + metodoWSLinea + "]");
			int connectionTimeout = Integer.parseInt(propiedadesExterna.WS_SOAP_TICKLERS_CONECTIONTIMEOUT);
			int readTimeout = Integer.parseInt(propiedadesExterna.WS_SOAP_TICKLERS_READTIMEOUT);

			logger.info(msjTx + " URL del Servicio a invocar: " + urlWS);
			logger.info(msjTx + " Datos de Entrada: " + JAXBUtilitarios.anyObjectToXmlText(request));
			logger.info(msjTx + " Tiempo permitido de conexion (ms)= " + connectionTimeout);
			logger.info(msjTx + " Tiempo permitido de ejecucion (ms)= " + readTimeout);

			response = this.portTypeConTicketsSearchWS.ticklersSearch(request);

			logger.info(msjTx + " Datos de Salida: " + JAXBUtilitarios.anyObjectToXmlText(response));

		} catch (Exception e) {

			logger.error(e, e);
			String error = (e + Constantes.constanteVacio);

			if (error.contains(Constantes.TIMEOUT)) {
				throw new WSException(propiedadesExterna.idt1Codigo, String.format(propiedadesExterna.idt1Mensaje,
						propiedadesExterna.WS_SOAP_TICKLERSNWS_NOMBRE, propiedadesExterna.WS_SOAP_TICKLERSNWS_METODO),
						e);

			} else {
				throw new WSException(propiedadesExterna.idt2Codigo, String.format(propiedadesExterna.idt2Mensaje,
						propiedadesExterna.WS_SOAP_TICKLERSNWS_NOMBRE, propiedadesExterna.WS_SOAP_TICKLERSNWS_METODO),
						e);
			}

		} finally {
			logger.info(msjTx + " [FIN] - Metodo[ticklersSearch] - Tiempo Total del proceso(ms)= "
					+ (System.currentTimeMillis() - tiempoInicio));
		}

		return response;
	}

}
