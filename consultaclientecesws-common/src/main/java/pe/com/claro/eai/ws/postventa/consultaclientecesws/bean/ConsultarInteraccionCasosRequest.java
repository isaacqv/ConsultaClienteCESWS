package pe.com.claro.eai.ws.postventa.consultaclientecesws.bean;

import java.io.Serializable;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.ConsultarInteraccionCasosRequestType;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Constantes;

public class ConsultarInteraccionCasosRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tecnologia;
	private String proceso;
	private String telefono;
	private String customerId;
	private String codSucursal;
	private String codCliente;
	private int codProceso;
	private String plataforma;
	private String storeProcedure;
	private String codSucursalDTH;

	private String tipoPlataforma;

	public ConsultarInteraccionCasosRequest() {
		super();
	}

	public ConsultarInteraccionCasosRequest(ConsultarInteraccionCasosRequestType request) {
		this.tipoPlataforma = request.getPlataforma();
		this.tecnologia = request.getTecnologia().toUpperCase();
		this.proceso = request.getProceso().toUpperCase();
		this.telefono = request.getTelefono();
		this.customerId = request.getCustomerId();
		this.codSucursal = request.getCodSucursal();
		this.codCliente = request.getCodCliente();

		if (this.proceso.equals(Constantes.INTERACCION_INFORMACION)
				|| this.proceso.equals(Constantes.INTERACCION_VARIACION)) {
			this.codProceso = 0;
		} else if (this.proceso.equals(Constantes.INTERACCION_SOT)) {
			this.codProceso = 1;
		} else if (this.proceso.equals(Constantes.INTERACCION_INCIDENCIAS)) {
			this.codProceso = 2;
		} else if (this.proceso.equals(Constantes.INTERACCION_PROBLEMAS)) {
			this.codProceso = 3;
		} else if (this.proceso.equals(Constantes.INTERACCION_TODOS)) {
			this.codProceso = 4;
		} else {
			this.codProceso = -1;
		}
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCodSucursal() {
		return codSucursal;
	}

	public void setCodSucursal(String codSucursal) {
		this.codSucursal = codSucursal;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public int getCodProceso() {
		return codProceso;
	}

	public void setCodProceso(int codProceso) {
		this.codProceso = codProceso;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getStoreProcedure() {
		return storeProcedure;
	}

	public void setStoreProcedure(String storeProcedure) {
		this.storeProcedure = storeProcedure;
	}

	public String getCodSucursalDTH() {
		return codSucursalDTH;
	}

	public void setCodSucursalDTH(String codSucursalDTH) {
		this.codSucursalDTH = codSucursalDTH;
	}

	public String getTipoPlataforma() {
		return tipoPlataforma;
	}

	public void setTipoPlataforma(String tipoPlataforma) {
		this.tipoPlataforma = tipoPlataforma;
	}
}
