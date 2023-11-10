package pe.com.claro.eai.ws.postventa.consultaclientecesws.util;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.RestClient.RestClientBuilder;

public class AbstractRestClient {
	protected RestClient restClient;

	protected void loadRestClient(String url, int connectionTimeout) {
		restClient = new RestClientBuilder(url).connectionTimeout(connectionTimeout).build();
	}

	public RestClient getRestClient() {
		return restClient;
	}

}
