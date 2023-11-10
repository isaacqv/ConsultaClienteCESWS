package pe.com.claro.eai.ws.postventa.consultaclientecesws.util;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.HttpHeaders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ClaroUtil {

	private static final Logger LOG = LoggerFactory.getLogger(ClaroUtil.class);

	public static String getAllHttpHeaders(HttpHeaders httpHeaders) {
		StringBuilder data = new StringBuilder();

		Set<String> headerKeys = httpHeaders.getRequestHeaders().keySet();
		for (String header : headerKeys) {
			data.append(header + ":" + httpHeaders.getRequestHeader(header).get(Constantes.CERO) + "\n");
		}
		return data.toString().trim();
	}

	public static String getAllProperties(Configuration configuration) {

		StringBuilder data = new StringBuilder();
		Set<String> properties = configuration.getProperties().keySet();
		for (String prop : properties) {
			data.append(prop + ":" + configuration.getProperty(prop).toString() + "\n");
		}
		return data.toString().trim();
	}

	public static String nuloAVacio(Object object) {

		if (object == null) {
			return Constantes.TEXTO_VACIO;
		} else {
			return object.toString();
		}
	}

	public static Object nuloAVacioObject(Object object) {
		if (object == null) {
			return Constantes.TEXTO_VACIO;
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
				a = new String(a.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
			} catch (Exception e) {
				LOG.error("Error getProperties Encoding Failed, trayendo Encoding por defecto", e);
			}
		}
		return a;
	}

	public static Float convertirFloat(Object object) {
		Float res = null;
		if (object instanceof BigDecimal) {
			BigDecimal bd = (BigDecimal) object;
			res = bd.floatValue();
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
			return Constantes.TEXTO_VACIO;
		}
		return dateAString(fecha, Constantes.FORMATO_FECHA_DEFAULT);
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
		SimpleDateFormat formatoDF = new SimpleDateFormat(formato, Locale.getDefault());
		return formatoDF.format(fecha);
	}

	public static boolean isValidFormat(String format, String value) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
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
				SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
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

	public static String getStoredProcedureByParameters(Object owner, Object packg, Object name) {
		StringBuilder storedProcedure = new StringBuilder();
		if (owner != null && !owner.toString().isEmpty()) {
			storedProcedure.append(owner.toString());
			storedProcedure.append(Constantes.SEPARADOR_PUNTO);
		}
		if (packg != null && !packg.toString().isEmpty()) {
			storedProcedure.append(packg.toString());
			storedProcedure.append(Constantes.SEPARADOR_PUNTO);
		}
		if (name != null && !name.toString().isEmpty()) {
			storedProcedure.append(name.toString());
		}
		return storedProcedure.toString();
	}

	public static String getExceptionToMensaje(Exception e) {
		String msg = "";
		if (e.getCause() != null) {
			msg = e.getCause().toString();
		} else {
			msg = e.toString();
		}
		return msg;
	}

	public static Float floatParse(String object) {
		if (object != null && !object.isEmpty()) {
			return Float.parseFloat(object);
		}
		return null;
	}

	public static String getStoredProcedureJDBC(String sp, int parameters) {
		StringBuilder call = new StringBuilder();
		call.append("call ");
		call.append(sp);
		call.append(Constantes.CHAR_PARENTESIS_IZQUIERDO);
		for (int i = 0; i < parameters; i++) {
			call.append(Constantes.CHAR_INTERROGACION);
			if (i + 1 < parameters)
				call.append(Constantes.CHAR_COMA);
		}
		call.append(Constantes.CHAR_PARENTESIS_DERECHO);
		return call.toString();
	}

	public static DateFormat getLocalFormat() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
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
			return Constantes.TEXTO_VACIO;
		}
	}

	public static Date convertirStringADate(String fecha, String formato) {

		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat(formato);
			return formatoFecha.parse(fecha);
		} catch (Exception e) {

			return null;
		}
	}

	public static double redondear(Object valor) {
		double dblValor = Double.parseDouble(valor.toString());
		return (double) Math.round(dblValor * 10) / 10;
	}

	public static String decimalesCadenasRound(Double valor) {
		valor = (double) Math.round(valor * 100) / 100.0;
		DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.US);
		DecimalFormat decimalFormat = new DecimalFormat("###0.00", simbolos);
		return decimalFormat.format(valor);
	}

	public static Date modificarFecha(Date fecha, int campo, int cantidad) {
		try {
			Calendar fechaFinal = Calendar.getInstance();
			fechaFinal.setTime(fecha);
			fechaFinal.add(campo, cantidad);
			return fechaFinal.getTime();
		} catch (Exception e) {
			return fecha;
		}
	}

	public static String dateToString(Date fecha, String formato) {
		try {
			return new SimpleDateFormat(formato, Locale.getDefault()).format(fecha);
		} catch (Exception e) {
			return Constantes.TEXTO_VACIO;
		}
	}

	public static boolean existStringSplitValue(String[] array, String value) {
		boolean existe = false;
		if (array != null) {
			for (String val : array) {
				if (val.equals(value)) {
					existe = true;
					break;
				}
			}
		}
		return existe;
	}

	


}