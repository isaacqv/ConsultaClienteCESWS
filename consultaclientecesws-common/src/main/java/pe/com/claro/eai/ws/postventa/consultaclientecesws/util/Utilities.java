package pe.com.claro.eai.ws.postventa.consultaclientecesws.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import com.google.gson.GsonBuilder;

public class Utilities {

	private static Logger logger = Logger.getLogger(Utilities.class);

	private Utilities() {
	}

	public static String obtnerIpServer()
	{
		String ipServer=Constantes.constanteVacio;
		
		InetAddress ip;
        try {
        	ip = InetAddress.getLocalHost();
        	ipServer= ip.getHostAddress();
		} catch (UnknownHostException e) {
			logger.error("Error:"+e);
		} 
        
        return ipServer;
	}
	
	public static XMLGregorianCalendar fechaActualCalendar()
	{
		XMLGregorianCalendar now=null;
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = null;
		try {
			datatypeFactory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			logger.error("Error:"+e);
		}
          now = 
            datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        
        return now;
	}
	
	public static Calendar toCalendar(final String iso8601string) {
		Calendar calendar = GregorianCalendar.getInstance();
		String s = iso8601string.replace("Z", "+00:00");
		try {
			s = s.substring(0, 22) + s.substring(23); // to get rid of the ":"
			Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ROOT).parse(s);
			calendar.setTime(date);
		} catch (IndexOutOfBoundsException e) {
			calendar = null;
		} catch (ParseException e) {
			calendar = null;
		}
		return calendar;
	}
	
	public static boolean isNumeric(String cadena) {
		try {
			Long.parseLong(cadena);
			return true;
		} catch (Exception nfe) {
			logger.error("Error parseando isNumeric:", nfe);
			return false;
		}
	}

	public static String convertirDateAStringFormat(Date fecha, String format) {
		String textoFormateado = "";
		if (fecha == null) {
			return textoFormateado;
		}
		DateFormat fechaFormato = new SimpleDateFormat(format);
		textoFormateado = fechaFormato.format(fecha);

		return textoFormateado;
	}

	public static Map<String, String> getMapOfString(String cadena) {
		Map<String, String> map = new HashMap<>();
		String[] parts = cadena.split(Constantes.SEPARADOR_MAP_PUNTOS);
		for (int i = 0; i < parts.length; i += 2) {
			map.put(parts[i], parts[i + 1]);
		}
		return map;
	}

	public static String[] getArrayOfString(String paqueteNormalesTipo) {
		return paqueteNormalesTipo.split(":");
	}

	public static boolean isTodayThisStringDate(String fechaCadena, String formato) {
		if (fechaCadena == null) {
			return false;
		}
		try {
			Date fecha;
			fecha = new SimpleDateFormat(formato).parse(fechaCadena);
			return DateUtils.isSameDay(fecha, new Date());
		} catch (ParseException e) {
			logger.warn(e.getMessage(), e);
			return false;
		}
	}

	public static String printPrettyJSONString(Object obj) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(obj);
	}

	public static String convertirStringDateToStringDateFormat(String stringDate, String formatOrigin,
			String formatTarget) {
		Date date;
		try {
			date = new SimpleDateFormat(formatOrigin).parse(stringDate);
		} catch (ParseException e) {
			return null;
		}
		return convertirDateAStringFormat(date, formatTarget);
	}
}
