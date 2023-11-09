package pe.com.claro.eai.ws.postventa.consultaclientecesws.exception;

public class DBException extends BaseException {

	private static final long serialVersionUID = 1L;

	public DBException(String codError, String msjError, Exception objException, String nombreSP, String nombreBD) {
		super(codError, msjError, objException, nombreSP, nombreBD);
	}

	public DBException(String codError, String msjError, Exception objException) {
		super(codError, msjError, objException);
	}

	public DBException(String codError, String msjError) {
		super(codError, msjError);
	}

	public DBException(String msjError) {
		super(msjError);
	}
}
