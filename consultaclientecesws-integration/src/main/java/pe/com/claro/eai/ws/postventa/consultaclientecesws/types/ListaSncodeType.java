package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import java.io.Serializable;

public class ListaSncodeType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sncode;
	private String sncodeDes;
	private String pop;
	private String cfss;

	public String getSncode() {
		return sncode;
	}

	public void setSncode(String sncode) {
		this.sncode = sncode;
	}

	public String getSncodeDes() {
		return sncodeDes;
	}

	public void setSncodeDes(String sncodeDes) {
		this.sncodeDes = sncodeDes;
	}

	public String getPop() {
		return pop;
	}

	public void setPop(String pop) {
		this.pop = pop;
	}

	public String getCfss() {
		return cfss;
	}

	public void setCfss(String cfss) {
		this.cfss = cfss;
	}

	
}
