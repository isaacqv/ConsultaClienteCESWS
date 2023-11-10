package pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cursor {
	
	@JsonProperty("cursor")
	private List<ChildCursor> cursor = null;

	public List<ChildCursor> getCursor() {
		return cursor;
	}

	public void setCursor(List<ChildCursor> cursor) {
		this.cursor = cursor;
	}

}
