package pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuerySerieOttResponse {
	
	@JsonProperty("cursor")
	private Cursor cursor;
	
	@JsonProperty("resultCode")
	private String resultCode;
	
	@JsonProperty("resultMessage")
	private String resultMessage;

	public Cursor getCursor() {
		return cursor;
	}

	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
}
