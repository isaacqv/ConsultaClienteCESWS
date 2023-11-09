package pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IptvResponse {
	
	@JsonProperty("querySerieOttResponse")
	private QuerySerieOttResponse querySerieOttResponse;

	public QuerySerieOttResponse getQuerySerieOttResponse() {
		return querySerieOttResponse;
	}

	public void setQuerySerieOttResponse(QuerySerieOttResponse querySerieOttResponse) {
		this.querySerieOttResponse = querySerieOttResponse;
	}

}
