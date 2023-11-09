package pe.com.claro.eai.ws.postventa.consultaclientecesws.dao;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarEquipoRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarEquipoResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.DBException;

public interface PvuDao {
	
	ConsultarEquipoResponse consultarEquipo(String mensajeTransaccion, ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException;

}
