package pe.com.claro.eai.ws.postventa.consultaclientecesws.dao;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarInteraccionCasosRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarInteraccionCasosResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.DBException;

public interface ClarifyDao {

	ConsultarInteraccionCasosResponse consultarInformacionVariacion(String mensajeTransaccion, ConsultarInteraccionCasosRequest objConsultarInteraccionCasosRequest) throws DBException;
	ConsultarInteraccionCasosResponse consultarProblemas(String mensajeTransaccion, ConsultarInteraccionCasosRequest objConsultarInteraccionCasosRequest) throws DBException;

}
