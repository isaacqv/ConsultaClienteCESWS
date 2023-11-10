package pe.com.claro.eai.ws.postventa.consultaclientecesws.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz.DatosRazonClient;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Constantes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.JAXBUtilitarios;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.WSException;
import pe.com.claro.eai.ws.postventa.datosrazonws.DatosRazonWSPortType;
import pe.com.claro.eai.ws.postventa.datosrazonws.types.ObtenerDatosRequest;
import pe.com.claro.eai.ws.postventa.datosrazonws.types.ObtenerDatosResponse;

@Service
public class DatosRazonClientImpl implements DatosRazonClient {

	private static final Logger logger = Logger.getLogger(DatosRazonClientImpl.class);

	@Autowired
	private DatosRazonWSPortType portTypeDatosRazonWS;

	@Autowired
	Propiedades propiedadesExterna;

	@Override
	public ObtenerDatosResponse obtenerDatos(ObtenerDatosRequest request, String msgTxIn) throws WSException {

		long tiempoInicio = System.currentTimeMillis();
		String urlWS = propiedadesExterna.WS_SOAP_DATOSRAZONWS_URI;
		String metodoWSLinea = propiedadesExterna.WS_SOAP_DATOSRAZONWS_METODO;
		String msjTx = msgTxIn + "[" + metodoWSLinea + "]";
		ObtenerDatosResponse response = new ObtenerDatosResponse();

		try {

			logger.info(msjTx + "[INICIO de metodo " + metodoWSLinea + "]");
			logger.info(msjTx + " URL del Servicio a invocar: " + urlWS);
			logger.info(msjTx + " Datos de Entrada: " + JAXBUtilitarios.anyObjectToXmlText(request));
			logger.info(msjTx + " Tiempo permitido de conexion (ms)= "
					+ propiedadesExterna.WS_SOAP_DATOSRAZONWS_CONECTIONTIMEOUT);
			logger.info(msjTx + " Tiempo permitido de ejecucion (ms)= "
					+ propiedadesExterna.WS_SOAP_DATOSRAZONWS_READTIMEOUT);

			response = this.portTypeDatosRazonWS.obtenerDatos(request);

			logger.info(msjTx + " Datos de Salida: " + JAXBUtilitarios.anyObjectToXmlText(response));

		} catch (Exception e) {

			logger.error(e, e);
			String error = (e + Constantes.constanteVacio);

			if (error.contains(Constantes.TIMEOUT)) {
				throw new WSException(propiedadesExterna.idt1Codigo, String.format(propiedadesExterna.idt1Mensaje,
						propiedadesExterna.WS_SOAP_DATOSRAZONWS_NOMBRE, propiedadesExterna.WS_SOAP_DATOSRAZONWS_METODO),
						e);

			} else {
				throw new WSException(propiedadesExterna.idt2Codigo, String.format(propiedadesExterna.idt2Mensaje,
						propiedadesExterna.WS_SOAP_DATOSRAZONWS_NOMBRE, propiedadesExterna.WS_SOAP_DATOSRAZONWS_METODO),
						e);
			}

		} finally {
			logger.info(msjTx + " [FIN] - Metodo[obtenerDatos] - Tiempo Total del proceso(ms)= "
					+ (System.currentTimeMillis() - tiempoInicio));
		}

		return response;
	}

}
