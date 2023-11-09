package pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.request.IncognitoRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.response.IncognitoResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.IncognitoHeader;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.WSException;

public interface IncognitoRest {
	 public IncognitoResponse incognito(IncognitoRequest  incognitoRequest,IncognitoHeader incognitoHeader,Propiedades propiedades) throws WSException;
}
