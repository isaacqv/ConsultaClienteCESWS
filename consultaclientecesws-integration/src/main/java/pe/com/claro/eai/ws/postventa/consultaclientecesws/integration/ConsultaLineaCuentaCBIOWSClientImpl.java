package pe.com.claro.eai.ws.postventa.consultaclientecesws.integration;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.WSException;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Constantes;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.JAXBUtilitarios;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.soa.message.consultalineacuentaws.ConsultarLineaCuentaRequest;
import pe.com.claro.soa.message.consultalineacuentaws.ConsultarLineaCuentaResponse;
import pe.com.claro.soa.service.consultalineacuentaws.ConsultaLineaCuentaWSPortType;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ConsultaLineaCuentaCBIOWSClientImpl implements ConsultaLineaCuentaCBIOWSClient {

	private final Logger logger = Logger.getLogger(ConsultaLineaCuentaCBIOWSClientImpl.class);

	@Autowired
	Propiedades propiedadesExterna;

	@Autowired
	private ConsultaLineaCuentaWSPortType portType;

	@Override
	public ConsultarLineaCuentaResponse consultarLineaCuenta(String idTransaccion, ConsultarLineaCuentaRequest request)
			throws WSException {
		ConsultarLineaCuentaResponse response = new ConsultarLineaCuentaResponse();

		String urlWS = propiedadesExterna.wsConsultaLineaCuentaCbiowsUrl;
		String nombreServicioWS = propiedadesExterna.wsConsultaLineaCuentaCbiowsNombre;
		String metodoWSLinea = propiedadesExterna.wsConsultaLineaCuentaCbiowsMetodo;
		String mensajeLog = idTransaccion + "[consultarLineaCuenta] ";

		try {
			logger.info(mensajeLog + "Servicio a usar: " + nombreServicioWS);
			logger.info(mensajeLog + "Metodo: " + metodoWSLinea);
			logger.info(mensajeLog + "Url: " + urlWS);
			this.logger.info(mensajeLog + "XML [REQUEST]: \n" + JAXBUtilitarios.anyObjectToXmlText(request));
			response = this.portType.consultarLineaCuenta(request);
			this.logger.info(mensajeLog + "XML [RESPONSE]: \n" + JAXBUtilitarios.anyObjectToXmlText(response));

		} catch (Exception e) {
			logger.error(mensajeLog + Constantes.ERROR_EXCEPTION + nombreServicioWS + Constantes.ESPACIO + "Metodo: "
					+ metodoWSLinea + ": ", e);
			String error = e.toString();
			String msjErrorLinea = Constantes.constanteVacio;
			String codErrorLinea = Constantes.constanteVacio;
			if (e.getMessage().contains(Constantes.TIMEOUT)) {
				logger.error(mensajeLog + Constantes.TIMEOUT);
				codErrorLinea = propiedadesExterna.idt1Codigov2;
				msjErrorLinea = propiedadesExterna.idt1Mensajev2.replace("$ws", urlWS);
			} else {
				logger.error(mensajeLog + Constantes.TEXTOERRORDISPONIBILIDAD);
				codErrorLinea = propiedadesExterna.idt2Codigov2;
				msjErrorLinea = propiedadesExterna.idt2Mensajev2.replace("$ws", urlWS);
			}
			logger.error(mensajeLog + Constantes.TEXTO_CODIGO_ERROR + codErrorLinea + Constantes.TEXTO_ERROR
					+ msjErrorLinea);
			throw new WSException(codErrorLinea, msjErrorLinea.replace("$bd", nombreServicioWS)
					.replace("$sp", metodoWSLinea).replace("$msg", error));
		} finally {
			this.logger.info(mensajeLog + "[FIN] - METODO: [consultarLineaCuenta] ");
		}

		return response;
	}

}
