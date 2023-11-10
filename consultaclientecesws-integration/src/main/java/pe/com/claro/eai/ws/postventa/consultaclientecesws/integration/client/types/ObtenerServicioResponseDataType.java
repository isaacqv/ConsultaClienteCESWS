package pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.types;

import java.io.Serializable;
import java.util.List;

public class ObtenerServicioResponseDataType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String coId;
	public String coIdPub;
	public String estado;
	public String codProd;
	public List<ListaServiciosAsignadosType> listaServiciosAsignados;
	public List<ListaServiciosCatalogoType> listaServiciosAdicionalesCatalogo;
	private List<ListaCaracteristicasType> listaCaracteristicas;
	public List<ListOpcionalType> listaOpcional;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public String getCoIdPub() {
		return coIdPub;
	}

	public void setCoIdPub(String coIdPub) {
		this.coIdPub = coIdPub;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public List<ListaServiciosAsignadosType> getListaServiciosAsignados() {
		return listaServiciosAsignados;
	}

	public void setListaServiciosAsignados(List<ListaServiciosAsignadosType> listaServiciosAsignados) {
		this.listaServiciosAsignados = listaServiciosAsignados;
	}

	public List<ListaServiciosCatalogoType> getListaServiciosAdicionalesCatalogo() {
		return listaServiciosAdicionalesCatalogo;
	}

	public void setListaServiciosAdicionalesCatalogo(
			List<ListaServiciosCatalogoType> listaServiciosAdicionalesCatalogo) {
		this.listaServiciosAdicionalesCatalogo = listaServiciosAdicionalesCatalogo;
	}

	public List<ListOpcionalType> getListaOpcional() {
		return listaOpcional;
	}

	public void setListaOpcional(List<ListOpcionalType> listaOpcional) {
		this.listaOpcional = listaOpcional;
	}
    public List<ListaCaracteristicasType> getListaCaracteristicas() {
      return listaCaracteristicas;
    }

    public void setListaCaracteristicas(List<ListaCaracteristicasType> listaCaracteristicas) {
      this.listaCaracteristicas = listaCaracteristicas;
    }
}
