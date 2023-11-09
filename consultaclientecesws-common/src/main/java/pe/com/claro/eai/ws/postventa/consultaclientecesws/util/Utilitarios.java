package pe.com.claro.eai.ws.postventa.consultaclientecesws.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

@Component
public class Utilitarios {

	String vacio = "";
	public static  String isNullOrBlankToString(String cadena) {
		return (cadena == null || cadena.equalsIgnoreCase("")) ? "" : cadena;
	}

	public static String isNullOrBlankToString(Object cadena) {
		return (cadena == null) ? "" : cadena.toString();
	}

	public Double isNullOrBlankToDouble(Double valor) {
		return valor == null ? 0.0 : valor;
	}

	public Integer isNullOrBlankToInt(Integer valor) {
		return valor == null ? 0 : valor;
	}
	
	public static Object isNullOrBlankToObjectInteger(Object object) {
	    return (object == null) ? Integer.valueOf(-1) : object;
	}

	public Date isNullOrBlankToDate(java.util.Date cadena) {
		Date fecha = null;
		if (cadena == null) {
			return fecha;
		} else {
			return cadena;
		}

	}

	public int isNullOrBlankToInti(Object cadena) {
		return cadena == null ? 0 : Integer.parseInt(cadena.toString());
	}

	public boolean validarPatron(String cadena, String ListaValores, String separador) {

		String patron[] = ListaValores.split(separador);
		boolean rtpa = false;
		byte b;
	    int i;
	    String[] arrayOfString1;
	    for (i = (arrayOfString1 = patron).length, b = 0; b < i; ) {
	      String arg = arrayOfString1[b];
			if (cadena.contains(arg)) {
				rtpa = true;
				break;
			}
			b++;
		}
		return rtpa;

	}

	public static XMLGregorianCalendar getGregorianCalnedarFromString(String fecha) {
		XMLGregorianCalendar calendar = null;
		try {
			String format = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(new SimpleDateFormat(format).parse(fecha));
			calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return calendar;		
	}

	public static XMLGregorianCalendar getXmlGregorianCalnedar() {
		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal = null;
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return xgcal;

	}
	
	public static XMLGregorianCalendar getXmlGregorianCalendarFromDate(final Date date) throws DatatypeConfigurationException{
	    GregorianCalendar calendar = new GregorianCalendar();
	    calendar.setTime(date);
	    return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
	}
	
	public String removeLastChar(String str) {
	    return str.substring(0, str.length() - 1);
	}
}
