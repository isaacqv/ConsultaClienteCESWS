package pe.com.claro.eai.ws.postventa.consultaclientecesws.dao;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClienteRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClienteResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.DBException;

public interface Bscs9Dao {

	ConsultarClienteResponse consultarCliente(String mensajeTransaccion, ConsultarClienteRequest objConsultarClienteRequest) throws DBException;
	ConsultarTecnologiaResponse consultarTecnologia(String mensajeTransaccion, ConsultarTecnologiaRequest objConsultarTecnologiaRequest) throws DBException;
	
}
