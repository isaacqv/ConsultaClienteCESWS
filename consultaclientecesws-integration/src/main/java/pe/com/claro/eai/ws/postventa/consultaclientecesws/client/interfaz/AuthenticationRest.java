package pe.com.claro.eai.ws.postventa.consultaclientecesws.client.interfaz;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.request.AuthenticationRequest;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.response.AuthenticationResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.IncognitoHeader;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.Propiedades;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.WSException;

public interface AuthenticationRest {
  public AuthenticationResponse authentication(AuthenticationRequest  authenticationRequest,IncognitoHeader incognitoHeader,Propiedades propiedades) throws WSException;
}
