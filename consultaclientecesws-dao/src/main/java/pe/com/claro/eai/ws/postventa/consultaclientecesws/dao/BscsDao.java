package pe.com.claro.eai.ws.postventa.consultaclientecesws.dao;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClientePorNombreRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClientePorNombreResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClienteRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarClienteResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarEquipoRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarEquipoResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarServicioRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarServicioResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.bean.ConsultarTecnologiaResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.DBException;

public interface BscsDao {

	ConsultarClienteResponse consultarCliente(String mensajeTransaccion, ConsultarClienteRequest objConsultarClienteRequest) throws DBException;
	ConsultarClientePorNombreResponse consultarClientePorNombre(String mensajeTransaccion, ConsultarClientePorNombreRequest objConsultarClientePorNombreRequest) throws DBException;
	ConsultarTecnologiaResponse consultarTecnologia(String mensajeTransaccion, ConsultarTecnologiaRequest objConsultarTecnologiaRequest) throws DBException;
	ConsultarServicioResponse consultarServicio(String mensajeTransaccion, ConsultarServicioRequest objConsultarServicioRequest) throws DBException;
	ConsultarEquipoResponse consultarEquipoCable(String mensajeTransaccion, ConsultarEquipoRequest objConsultarEquipoRequest) throws DBException;

}
