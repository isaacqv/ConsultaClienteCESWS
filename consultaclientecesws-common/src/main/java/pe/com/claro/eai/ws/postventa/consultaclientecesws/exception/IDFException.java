package pe.com.claro.eai.ws.postventa.consultaclientecesws.exception;

public class IDFException extends BaseException2 {

  private static final long serialVersionUID = 1L;

  public IDFException(String string) {
    super(string);
  }

  public IDFException(Exception exception) {
    super(exception);
  }

  public IDFException(String string, Exception exception) {
    super(string, exception);
  }

  public IDFException(String code, String message, Exception exception) {
    super(code, message, exception);
  }

  public IDFException(String code, String message, String messageDeveloper, Exception exception, int status) {
    super(code, message, messageDeveloper, exception, status);
  }

  public IDFException(String code, String message) {
    super(code, message);
  }

}
