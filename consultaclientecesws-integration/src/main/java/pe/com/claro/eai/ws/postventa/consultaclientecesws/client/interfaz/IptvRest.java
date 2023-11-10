package pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv.IptvHeader;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv.IptvResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv.IptvResquest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.WSException;

public interface IptvRest {

	public IptvResponse consultaSerieIptv(Propiedades propiedadesExterna, IptvHeader iptvHeader,IptvResquest iptvRequest) throws  WSException;

}
