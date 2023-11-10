package pe.com.claro.eai.ws.postventa.consultaclientecesws.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.ws.rs.core.HttpHeaders;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ClaroUtil {
	private static final Logger log = Logger.getLogger(ClaroUtil.class);

	Propiedades propertiesExternos;

	public static String getAllHttpHeaders(HttpHeaders httpHeaders) {
		StringBuffer data = new StringBuffer();

		Set<String> headerKeys = httpHeaders.getRequestHeaders().keySet();
		for (String header : headerKeys) {
			data.append(header + ":" + httpHeaders.getRequestHeader(header).get(Constantes.CERO) + "\n");
		}
		return data.toString().trim();
	}

	public static String getHttpHeadersNoNull(HttpHeaders httpHeaders) {

		String idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(0)
				: "";
		String msgid = httpHeaders.getRequestHeader(Constantes.MSGID) != null
				? httpHeaders.getRequestHeader(Constantes.MSGID).get(0)
				: "";
		String timestamp = "";
		Calendar a = ClaroUtil.toCalendar(httpHeaders.getRequestHeader(Constantes.TIMESTAMP) != null
				? httpHeaders.getRequestHeader(Constantes.TIMESTAMP).get(0).toString()
				: Constantes.constanteVacio);
		if (a != null) {
			timestamp = a.getTime().toString();
		}
		String userId = httpHeaders.getRequestHeader(Constantes.USRID) != null
				? httpHeaders.getRequestHeader(Constantes.USRID).get(0)
				: "";
		String accept = httpHeaders.getRequestHeader(Constantes.ACCEPT) != null
				? httpHeaders.getRequestHeader(Constantes.ACCEPT).get(0)
				: "";
		StringBuffer data = new StringBuffer();
		data.append("[" + Constantes.IDTRANSACCION + "=");
		data.append(idTransaccion);
		data.append(" " + Constantes.MSGID + "=");
		data.append(msgid);
		data.append(" " + Constantes.TIMESTAMP + "=");
		data.append(timestamp);
		data.append(" " + Constantes.USRID + "=");
		data.append(userId);
		data.append(" " + Constantes.ACCEPT + "=");
		data.append(accept);
		data.append(Constantes.CHAR_CORCHETE_IZQUIERDO);
		return data.toString();
	}

	public static String getHttpHeaders(HttpHeaders httpHeaders) {

		if (httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) == null) {
			return null;
		}
		if (httpHeaders.getRequestHeader(Constantes.MSGID) == null) {
			return null;
		}
		if (httpHeaders.getRequestHeader(Constantes.TIMESTAMP) == null) {
			return null;
		}
		if (httpHeaders.getRequestHeader(Constantes.USRID) == null) {
			return null;
		}

		String idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(0)
				: "";
		String msgid = httpHeaders.getRequestHeader(Constantes.MSGID) != null
				? httpHeaders.getRequestHeader(Constantes.MSGID).get(0)
				: "";
		String timestamp = httpHeaders.getRequestHeader(Constantes.TIMESTAMP) != null
				? httpHeaders.getRequestHeader(Constantes.TIMESTAMP).get(0)
				: "";
		String userId = httpHeaders.getRequestHeader(Constantes.USRID) != null
				? httpHeaders.getRequestHeader(Constantes.USRID).get(0)
				: "";

		StringBuffer data = new StringBuffer();
		data.append("[" + Constantes.IDTRANSACCION + "=");
		data.append(idTransaccion);
		data.append(" " + Constantes.MSGID + "=");
		data.append(msgid);
		data.append(" " + Constantes.TIMESTAMP + "=");
		data.append(timestamp);
		data.append(" " + Constantes.USRID + "=");
		data.append(userId);
		data.append(" " + Constantes.ACCEPT + "=");
		data.append(httpHeaders.getMediaType());
		data.append(Constantes.constanteVacio);
		return data.toString();
	}

	public static String getExceptionToMensaje(Exception e) {
		String msg = Constantes.constanteVacio;
		if (e.getCause() != null) {
			msg = e.getCause().toString();
		} else {
			msg = e.toString();
		}
		return msg;
	}

	public static DateFormat getLocalFormat() {
		DateFormat dateFormat = new SimpleDateFormat(Constantes.FORMATOFECHACABECERA);
		dateFormat.setTimeZone(TimeZone.getDefault());
		return dateFormat;
	}

	public static String printPrettyJSONString(Object o) throws JsonProcessingException {
		return new ObjectMapper().setDateFormat(ClaroUtil.getLocalFormat())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writerWithDefaultPrettyPrinter()
				.writeValueAsString(o);
	}

	public static String printJSONString(Object o) {
		try {
			return new ObjectMapper().setDateFormat(ClaroUtil.getLocalFormat())
					.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writeValueAsString(o);
		} catch (JsonProcessingException e) {
			log.error("Ocurrio un error al convertir JSON", e);
			return Constantes.constanteVacio;
		}
	}

	public static String nuloAVacio(Object object) {

		if (object == null) {
			return Constantes.constanteVacio;
		} else {
			return object.toString();
		}
	}

	public static Object nuloAVacioObject(Object object) {
		if (object == null) {
			return Constantes.constanteVacio;
		} else {
			return object;
		}
	}

	public static String verifiyNull(Object object) {
		String a = null;
		if (object != null) {
			a = object.toString();
		}
		return a;
	}

	public static String convertProperties(Object object) {
		String a = null;
		if (object != null) {
			a = object.toString();
			try {
				a = new String(a.getBytes(Constantes.DEFAULTENCONDIGPROPERTIES), Constantes.DEFAULTENCONDINGAPI);
			} catch (Exception e) {
				log.error("Error getProperties Encoding Failed, trayendo Encoding por defecto", e);
			}
		}
		return a;
	}

	public static Integer convertirInteger(Object object) {

		Integer res = null;
		if (object != null) {
			if (object instanceof BigDecimal) {
				BigDecimal bd = (BigDecimal) object;
				res = bd.intValueExact();
			} else {
				log.error(object.getClass().getSimpleName());
			}
		}
		return res;
	}

	public static Float convertirFloat(Object object) {
		Float res = null;
		if (object != null) {
			if (object instanceof BigDecimal) {
				BigDecimal bd = (BigDecimal) object;
				res = bd.floatValue();
			}
		}
		return res;
	}

	/**
	 * Genera un String a partir de un Date, si fecha es NULL retorna "" (vacio).
	 *
	 * @param fecha tipo Date
	 * @return String de la forma dd/MM/yyyy
	 */
	public static String dateAString(Date fecha) {
		if (fecha == null) {
			return Constantes.constanteVacio;
		}
		return dateAString(fecha, Constantes.FORMATOFECHACABECERA);
	}

	/**
	 * Genera un String a partir de un Date de acuerdo al fomrato enviado, si fecha
	 * es NULL toma la fecha actual.
	 *
	 * @param fecha
	 * @param formato
	 * @return
	 */
	public static String dateAString(Date fecha, String formato) {

		if (fecha != null) {
			SimpleDateFormat formatoDF = new SimpleDateFormat(formato, Locale.ROOT);
			return formatoDF.format(fecha);
		} else {
			return null;
		}

	}

	public static Calendar toCalendar(final String iso8601string) {
		Calendar calendar = GregorianCalendar.getInstance();
		String s = iso8601string.replace("Z", "+00:00");
		try {
			s = s.substring(0, 22) + s.substring(23); // to get rid of the ":"
			Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ROOT).parse(s);
			calendar.setTime(date);
		} catch (IndexOutOfBoundsException e) {
			log.error("Ocurrio un error al recorrer la cadena de Fecha", e);
			calendar = null;
		} catch (ParseException e) {
			log.error("Ocurrio un error al convertir a Date la cadena de la fecha", e);
			calendar = null;
		}
		return calendar;
	}

	public static boolean isValidFormat(String format, String value) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ROOT);
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException ex) {
			date = null;
		}
		return date != null;
	}

	public static Date getValidFormatDate(String format, String value) {
		Date date = null;
		if (value != null && !value.isEmpty()) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ROOT);
				date = sdf.parse(value);
				if (!value.equals(sdf.format(date))) {
					date = null;
				}
			} catch (ParseException ex) {
				date = null;
			}
		}
		return date;
	}

	public static Date stringADate(String fecha, String formatoFecha) {
		Date fechaGenerada = null;
		if (fecha != null) {
			try {
				SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);
				fechaGenerada = formato.parse(fecha);
			} catch (Exception e) {
				log.error("Error al formatear fecha :" + fecha, e);
			}
		}

		return fechaGenerada;
	}

	public static String transformacion(String properties, String request) {
		String salida = "";
		String array[] = properties.split("\\|");

		for (String objeto : array) {

			String otro[] = objeto.split("\\:");

			for (int i = 0; i < otro.length; i++) {
				if (request.equals(otro[0])) {
					salida = otro[1];
				}
			}

		}
		return salida;

	}
	
	public static String quitarPalote(String codigoRazon) {
		
		codigoRazon = StringUtils.removeEnd(codigoRazon, "|");
		return codigoRazon;
	}

	public static XMLGregorianCalendar convertDateToGregorianCalendar(Date fecha) {
		GregorianCalendar calender = new GregorianCalendar();
		calender.setTime(fecha);

		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendarDate(calender.get(Calendar.YEAR),
					calender.get(Calendar.MONTH) + 1, calender.get(Calendar.DAY_OF_MONTH),
					DatatypeConstants.FIELD_UNDEFINED);
		} catch (DatatypeConfigurationException e) {
			log.error("Error al modificar fecha : " + fecha, e);
			e.printStackTrace();
		}
		return null;
	}

	public static String[] devolverValoresConfigurables(String datoBuscar, String variableProperties) {
		boolean flagEncontroTipo = false;
		String[] arregloDatos = null;
		String[] tipos = variableProperties.split(Constantes.BUSCARPIPELINE);
		log.info("Se buscar la informacion para el siguiente dato: " + datoBuscar);
		log.info("Se buscar en el siguiente bloque: " + variableProperties);
		for (String bean : tipos) {
			String[] datosFin = bean.split(";");
			if (datosFin[0].equals(datoBuscar)) {
				arregloDatos = datosFin;
				flagEncontroTipo = true;
				break;
			}
		}
		if (!flagEncontroTipo) {
			log.info("No se encontro el dato a buscar " + datoBuscar);
		}
		return arregloDatos;
	}

	public static String convertProp(Object object) {
		String a = null;
		if (object != null) {
			a = object.toString();
			try {
				a = new String(a.getBytes(Constantes.DEFAULTENCONDIGPROPERTIES), Constantes.DEFAULTENCONDINGAPI);
			} catch (Exception e) {
				log.error("Error getProperties Encoding Failed, trayendo Encoding por defecto", e);
			}
		}
		return a;
	}

	public static String getStoredProcedureByParameters(Object owner, Object packg, Object name) {
		StringBuffer storedProcedure = new StringBuffer();
		if (owner != null && !owner.toString().isEmpty()) {
			storedProcedure.append(owner.toString());
			storedProcedure.append(Constantes.SEPARADORPUNTO);
		}
		if (packg != null && !packg.toString().isEmpty()) {
			storedProcedure.append(packg.toString());
			storedProcedure.append(Constantes.SEPARADORPUNTO);
		}
		if (name != null && !name.toString().isEmpty()) {
			storedProcedure.append(name.toString());
		}
		return storedProcedure.toString();
	}

	public static String getStoredProcedureByParameters(Object owner, Object name) {
		StringBuffer storedProcedure = new StringBuffer();
		if (owner != null && !owner.toString().isEmpty()) {
			storedProcedure.append(owner.toString());
			storedProcedure.append(Constantes.SEPARADORPUNTO);
		}
		if (name != null && !name.toString().isEmpty()) {
			storedProcedure.append(name.toString());
		}
		return storedProcedure.toString();
	}

	public static String obtnerIp() {
		String ip = Constantes.constanteVacio;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			log.error("Error al obtener IP: " + e.getMessage(), e);
		}
		return ip;
	}

	public static XMLGregorianCalendar toXMLGregorianCalendarTimeStamp(Timestamp timeStamp)
			throws DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(timeStamp);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
	}


	public static TreeMap<String, String> obtenerMapReemplazos(String cadenaValores, String delimitadorRegistros,
			String delimitadorCampos) {
		TreeMap<String, String> mapReemplazo = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		try {
			String strReemplazo = cadenaValores;
			if (strReemplazo != null && !strReemplazo.isEmpty()) {
				String[] arrayReemplazoBolsas = strReemplazo.split(delimitadorRegistros);
				String strNombre;
				String strNombreReemplazo;
				for (int i = 0; i < arrayReemplazoBolsas.length; i++) {
					strNombre = arrayReemplazoBolsas[i].split(delimitadorCampos)[0];
					strNombreReemplazo = arrayReemplazoBolsas[i].split(delimitadorCampos)[1];
					mapReemplazo.put(strNombre, strNombreReemplazo);
				}
			}
		} catch (Exception e) {
			log.error("Error al obtener el Map de Reemplazos: [" + cadenaValores + "]", e);
		}
		return mapReemplazo;
	}

	public static String getTipoDocumento(String typeCode, String paramTipoDoc) {
		String[] parts = paramTipoDoc.split(Constantes.PUNTO_COMA);
		String tipoDocumento = Constantes.constanteVacio;

		for (int i = 0; i < parts.length; i++) {

			String[] parts3 = parts[i].split(Constantes.BARRA);

			if (parts3[0].equals(typeCode)) {
				tipoDocumento = parts3[1];
			}
		}
		return tipoDocumento;
	}

	public static String validarMensaje(String menasje) {
		return menasje == null ? Constantes.constanteVacio : menasje;
	}

	public static String dateAndZoneToString(Date fecha, String formato, String zone) {

		if (fecha != null) {
			SimpleDateFormat formatoDF = new SimpleDateFormat(formato, Locale.ROOT);
			formatoDF.setTimeZone(TimeZone.getTimeZone(zone));

			return formatoDF.format(fecha);
		} else {
			return null;
		}

	}

	public static String newDate() {
		Date date = new Date();
		DateFormat sdf = null;
		try {
			sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

		} catch (Exception e) {
			log.error("Ocurrio un error al recorrer la cadena de Fecha", e);

		}

		return sdf.format(date);
	}

//	public static HttpURLConnection connectionHttpRest(HttpURLConnection connection, HeaderRequest header,
//			String metodo) throws ProtocolException {
//
//		connection.setRequestMethod(metodo);
//		DateFormat hourdateFormat = new SimpleDateFormat(Constantes.FORMATOFECHACABECERA);
//		String ts = hourdateFormat.format(header.getTimestamp());
//		connection.setRequestProperty(Constantes.ACCEPT, Constantes.APPLICATION_JSON);
//		connection.setRequestProperty(Constantes.IDTRANSACCION, header.getIdTransaccion());
//		connection.setRequestProperty(Constantes.MSGID, header.getMsgid());
//		connection.setRequestProperty(Constantes.TIMESTAMP, ts);
//		connection.setRequestProperty(Constantes.USERID, header.getUserId());
//		connection.setRequestProperty(Constantes.CONTENTTYPE, Constantes.APPLICATION_JSON);
//		return connection;
//	}

	public static void stringBuild(HttpURLConnection connection, Object obj) throws IOException {
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write((new ObjectMapper()).writeValueAsString(obj));// here i sent the parameter
		out.close();
	}

	public static String bufferedReader(HttpURLConnection connection) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}
		br.close();
		return sb.toString();

	}

	public static boolean getStatusParameter(String valor) {
		boolean resultado = false;
		try {
			if (valor != null && !valor.equals(Constantes.constanteVacio)) {
				resultado = true;
			}
		} catch (Exception e) {

		}
		return resultado;

	}

}