package pe.com.claro.eai.ws.postventa.consultaclientecesws.util;

import java.io.StringWriter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;

/**
 * @author Jose David Villanueva Villalobos.
 * @clase: RegistroMetricasVentaUtil.java
 * @descripcion Clase util para el servicio.
 * @author_company: CLARO.
 * @fecha_de_creacion: 01-04-2014.
 * @fecha_de_ultima_actualizacion: dd-mm-yyyy.
 * @version 1.0
 */
public class JAXBUtilitarios {

	private static Logger logger = Logger.getLogger(JAXBUtilitarios.class);
	@SuppressWarnings("rawtypes")
	private static HashMap<Class, JAXBContext> mapContexts = new HashMap<Class, JAXBContext>();

	/**
	 * Contexto de la clase
	 * 
	 * @param Clase
	 *            java
	 * @return JAXBContext
	 */
	@SuppressWarnings("rawtypes")
	private static JAXBContext obtainJaxBContextFromClass(Class clas) {

		JAXBContext context;
		context = mapContexts.get(clas);

		if (context == null) {
			try {
				context = JAXBContext.newInstance(clas);
				mapContexts.put(clas, context);
			} catch (Exception e) {
				logger.error("Error creando JAXBContext:" + e);
			}
		}
		return context;
	}

	/**
	 * Convertir request/response a Texto
	 * 
	 * @param Objeto
	 *            Java
	 * @return String
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String anyObjectToXmlText(Object objJaxB) {
		String commandoRequestEnXml = null;

		JAXBContext context;

		try {
			if (objJaxB != null) {
				context = obtainJaxBContextFromClass(objJaxB.getClass());
				Marshaller marshaller = context.createMarshaller();
				StringWriter xmlWriter = new StringWriter();
				marshaller.marshal(
						new JAXBElement(new QName("", objJaxB.getClass().getName()), objJaxB.getClass(), objJaxB),
						xmlWriter);
				XmlObject xmlObj = XmlObject.Factory.parse(xmlWriter.toString());
				commandoRequestEnXml = xmlObj.toString();
			}
		} catch (Exception e) {
			logger.error("Error parseando object to xml:" + e);
		}
		return commandoRequestEnXml;
	}

	/**
	 * Metodo que permite obtener la representacion XML de un objeto JAX-B *
	 * 
	 * @param objJaxB
	 *            Objeto JAX-B
	 * @return XML Text
	 */
	public static String getXmlTextFromJaxB(Object objJaxB) {
		String commandoRequestEnXml = null;

		JAXBContext context;

		try {
			if (objJaxB != null) {
				context = JAXBContext.newInstance(objJaxB.getClass());
				Marshaller marshaller = context.createMarshaller();
				StringWriter xmlWriter = new StringWriter();
				marshaller.marshal(objJaxB, xmlWriter);

				XmlObject xmlObj = XmlObject.Factory.parse(xmlWriter.toString());

				commandoRequestEnXml = xmlObj.toString();
			}
		} catch (Exception e) {
			logger.error("Error parsendo objeto a XML:", e);
		}

		return commandoRequestEnXml;
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

}
