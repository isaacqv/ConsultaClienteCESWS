package pe.com.claro.eai.ws.postventa.consultaclientecesws.exception;

public class WSException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	public WSException(String codError, String msjError, Exception objException, String nombreUrl, String nombreWS) {
		super(codError, msjError, objException, nombreUrl, nombreWS);
	}

	public WSException(String codError, String msjError, Exception objException) {
		super(codError, msjError, objException);
	}

	public WSException(String codError, String msjError) {
		super(codError, msjError);
	}

	public WSException(String msjError) {
		super(msjError);
	}
	
}