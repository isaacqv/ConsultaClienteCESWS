package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.io.Serializable;
import java.util.List;

public class ObtenerServiciosRequestType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String coId;
	public String msisdn;
	public String coIdPub;
	public String codTecnologia;
	public String codProd;
	public String flagServAdicional;

	private List<ListOpcionalType> listaOpcional;

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getCoIdPub() {
		return coIdPub;
	}

	public void setCoIdPub(String coIdPub) {
		this.coIdPub = coIdPub;
	}

	public String getCodTecnologia() {
		return codTecnologia;
	}

	public void setCodTecnologia(String codTecnologia) {
		this.codTecnologia = codTecnologia;
	}

	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public String getFlagServAdicional() {
		return flagServAdicional;
	}

	public void setFlagServAdicional(String flagServAdicional) {
		this.flagServAdicional = flagServAdicional;
	}

	public List<ListOpcionalType> getListaOpcional() {
		return listaOpcional;
	}

	public void setListaOpcional(List<ListOpcionalType> listaOpcional) {
		this.listaOpcional = listaOpcional;
	}
}
