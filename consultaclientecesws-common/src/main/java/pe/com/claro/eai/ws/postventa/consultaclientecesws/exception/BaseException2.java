package pe.com.claro.eai.ws.postventa.consultaclientecesws.exception;

public class BaseException2 extends Exception {

	private static final long serialVersionUID = 1L;

	private Exception exception;
	private String code;
	private String message;
	private String messageDeveloper;
	private int status;

	public BaseException2(String code, String message, Exception exception) {
		super(message);
		this.exception = exception;
		this.code = code;
		this.message = message;
	}

	public BaseException2(String code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public BaseException2(String message, Exception exception) {
		super(message);
		this.exception = exception;
		this.message = message;
	}

	public BaseException2(String code, String message, String messageDeveloper, Exception exception, int status) {
		super(message);
		this.code = code;
		this.message = message;
		this.messageDeveloper = messageDeveloper;
		this.exception = exception;
		this.status = status;
	}

	public BaseException2(Exception exception) {
		this.exception = exception;
	}

	public BaseException2(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public String getCode() {
		return code;
	}

	public String getMessageDeveloper() {
		return messageDeveloper;
	}

	public void setMessageDeveloper(String messageDeveloper) {
		this.messageDeveloper = messageDeveloper;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
