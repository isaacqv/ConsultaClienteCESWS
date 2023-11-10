package pe.com.claro.eai.ws.postventa.consultaclientecesws.integration;

import com.ericsson.services.ws_cil_7.ticklerssearch.TicklersSearchRequest;
import com.ericsson.services.ws_cil_7.ticklerssearch.TicklersSearchResponse;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.exception.WSException;

public interface TicklersSearchClient {

	public TicklersSearchResponse ticklersSearch (TicklersSearchRequest request, String msgTxIn) throws WSException;
}