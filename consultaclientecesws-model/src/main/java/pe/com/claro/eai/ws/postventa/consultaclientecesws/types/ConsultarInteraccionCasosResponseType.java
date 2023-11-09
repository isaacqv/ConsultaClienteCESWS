
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.com.claro.eai.ws.baseschema.AuditResponseType;
import pe.com.claro.eai.ws.baseschema.ParametrosType;


/**
 * <p>Clase Java para consultarInteraccionCasosResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarInteraccionCasosResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auditResponse" type="{http://claro.com.pe/eai/ws/baseschema}auditResponseType"/>
 *         &lt;element name="listaDatosInfVar" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}DatosInfVarType" maxOccurs="unbounded"/>
 *         &lt;element name="listaDatosSot" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}DatosSotType" maxOccurs="unbounded"/>
 *         &lt;element name="listaDatosIncidencia" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}DatosIncidenciaType" maxOccurs="unbounded"/>
 *         &lt;element name="listaDatosProblema" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}DatosProblemaType" maxOccurs="unbounded"/>
 *         &lt;element name="listaResponseOpcional" type="{http://claro.com.pe/eai/ws/baseschema}parametrosType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarInteraccionCasosResponseType", propOrder = {
    "auditResponse",
    "listaDatosInfVar",
    "listaDatosSot",
    "listaDatosIncidencia",
    "listaDatosProblema",
    "listaResponseOpcional"
})
public class ConsultarInteraccionCasosResponseType {

    @XmlElement(required = true)
    protected AuditResponseType auditResponse;
    @XmlElement(required = true)
    protected List<DatosInfVarType> listaDatosInfVar;
    @XmlElement(required = true)
    protected List<DatosSotType> listaDatosSot;
    @XmlElement(required = true)
    protected List<DatosIncidenciaType> listaDatosIncidencia;
    @XmlElement(required = true)
    protected List<DatosProblemaType> listaDatosProblema;
    @XmlElement(required = true)
    protected ParametrosType listaResponseOpcional;

    /**
     * Obtiene el valor de la propiedad auditResponse.
     * 
     * @return
     *     possible object is
     *     {@link AuditResponseType }
     *     
     */
    public AuditResponseType getAuditResponse() {
        return auditResponse;
    }

    /**
     * Define el valor de la propiedad auditResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditResponseType }
     *     
     */
    public void setAuditResponse(AuditResponseType value) {
        this.auditResponse = value;
    }

    /**
     * Gets the value of the listaDatosInfVar property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaDatosInfVar property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaDatosInfVar().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatosInfVarType }
     * 
     * 
     */
    public List<DatosInfVarType> getListaDatosInfVar() {
        if (listaDatosInfVar == null) {
            listaDatosInfVar = new ArrayList<DatosInfVarType>();
        }
        return this.listaDatosInfVar;
    }

    /**
     * Gets the value of the listaDatosSot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaDatosSot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaDatosSot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatosSotType }
     * 
     * 
     */
    public List<DatosSotType> getListaDatosSot() {
        if (listaDatosSot == null) {
            listaDatosSot = new ArrayList<DatosSotType>();
        }
        return this.listaDatosSot;
    }

    /**
     * Gets the value of the listaDatosIncidencia property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaDatosIncidencia property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaDatosIncidencia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatosIncidenciaType }
     * 
     * 
     */
    public List<DatosIncidenciaType> getListaDatosIncidencia() {
        if (listaDatosIncidencia == null) {
            listaDatosIncidencia = new ArrayList<DatosIncidenciaType>();
        }
        return this.listaDatosIncidencia;
    }

    /**
     * Gets the value of the listaDatosProblema property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaDatosProblema property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaDatosProblema().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatosProblemaType }
     * 
     * 
     */
    public List<DatosProblemaType> getListaDatosProblema() {
        if (listaDatosProblema == null) {
            listaDatosProblema = new ArrayList<DatosProblemaType>();
        }
        return this.listaDatosProblema;
    }

    /**
     * Obtiene el valor de la propiedad listaResponseOpcional.
     * 
     * @return
     *     possible object is
     *     {@link ParametrosType }
     *     
     */
    public ParametrosType getListaResponseOpcional() {
        return listaResponseOpcional;
    }

    /**
     * Define el valor de la propiedad listaResponseOpcional.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametrosType }
     *     
     */
    public void setListaResponseOpcional(ParametrosType value) {
        this.listaResponseOpcional = value;
    }

	public void setListaDatosInfVar(List<DatosInfVarType> listaDatosInfVar) {
		this.listaDatosInfVar = listaDatosInfVar;
	}

	public void setListaDatosSot(List<DatosSotType> listaDatosSot) {
		this.listaDatosSot = listaDatosSot;
	}

	public void setListaDatosIncidencia(List<DatosIncidenciaType> listaDatosIncidencia) {
		this.listaDatosIncidencia = listaDatosIncidencia;
	}

	public void setListaDatosProblema(List<DatosProblemaType> listaDatosProblema) {
		this.listaDatosProblema = listaDatosProblema;
	}

}
