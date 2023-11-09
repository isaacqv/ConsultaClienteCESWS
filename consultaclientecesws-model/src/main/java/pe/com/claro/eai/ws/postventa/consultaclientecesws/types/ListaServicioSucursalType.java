
package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaServicioSucursalType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaServicioSucursalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="servicioSucursal" type="{http://claro.com.pe/eai/ws/postventa/consultaclientecesws/types}ServicioSucursalType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaServicioSucursalType", propOrder = {
    "servicioSucursal"
})
public class ListaServicioSucursalType {

    @XmlElement(required = true)
    protected List<ServicioSucursalType> servicioSucursal;

    /**
     * Gets the value of the servicioSucursal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the servicioSucursal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServicioSucursal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServicioSucursalType }
     * 
     * 
     */
    public List<ServicioSucursalType> getServicioSucursal() {
        if (servicioSucursal == null) {
            servicioSucursal = new ArrayList<ServicioSucursalType>();
        }
        return this.servicioSucursal;
    }

	public void setServicioSucursal(List<ServicioSucursalType> servicioSucursal) {
		this.servicioSucursal = servicioSucursal;
	}

}
