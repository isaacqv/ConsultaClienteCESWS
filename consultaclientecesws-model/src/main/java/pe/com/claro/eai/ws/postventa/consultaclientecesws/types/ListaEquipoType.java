
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaEquipoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaEquipoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="equipo" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}EquipoType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaEquipoType", propOrder = {
    "equipo"
})
public class ListaEquipoType {

    @XmlElement(required = true)
    protected List<EquipoType> equipo;

    /**
     * Gets the value of the equipo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the equipo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEquipo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EquipoType }
     * 
     * 
     */
    public List<EquipoType> getEquipo() {
        if (equipo == null) {
            equipo = new ArrayList<EquipoType>();
        }
        return this.equipo;
    }

	public void setEquipo(List<EquipoType> equipo) {
		this.equipo = equipo;
	}
}
