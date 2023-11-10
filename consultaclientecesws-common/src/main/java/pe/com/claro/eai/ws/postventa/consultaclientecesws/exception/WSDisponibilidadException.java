package pe.com.claro.eai.ws.postventa.consultaclientecesws.exception;

public class WSDisponibilidadException extends BaseException{

	private static final long	serialVersionUID	= 1L;
	private String				nombreWS;

	/**
	 * Constructores
	 */
	public WSDisponibilidadException( String codError, String nombreWS, String msjError, Exception objException ){
		super( codError, msjError, objException );
		this.nombreWS = nombreWS;
	}

	/**
	 * Constructores
	 */
	public WSDisponibilidadException( String codError, String nombreWS, String msjError, Throwable objException ){
		super( codError, msjError);
		this.nombreWS = nombreWS;
	}

	/**
	 * Constructores
	 */
	/*public WSDisponibilidadException( String msjError, Exception objException ){
		super( msjError, objException );
	}*/

	/**
	 * Constructores
	 */
	/*public WSDisponibilidadException( Exception objException ){
		super( objException );
	}*/

	/**
	 * Constructores
	 */
	public WSDisponibilidadException( String msjError ){
		super( msjError );
	}

	public String getNombreWS(){
		return nombreWS;
	}

	public void setNombreWS( String nombreWS ){
		this.nombreWS = nombreWS;
	}

}
