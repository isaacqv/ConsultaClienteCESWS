package pe.com.claro.eai.ws.postventa.consultaclientecesws.integration.client.types;

public class AuditResponseType {

  private String idTransaccion;

  private String codigoRespuesta;

  private String mensajeRespuesta;

  public String getIdTransaccion() {
    return idTransaccion;
  }

  public void setIdTransaccion(String idTransaccion) {
    this.idTransaccion = idTransaccion;
  }

  public String getCodigoRespuesta() {
    return codigoRespuesta;
  }

  public void setCodigoRespuesta(String codigoRespuesta) {
    this.codigoRespuesta = codigoRespuesta;
  }

  public String getMensajeRespuesta() {
    return mensajeRespuesta;
  }

  public void setMensajeRespuesta(String mensajeRespuesta) {
    this.mensajeRespuesta = mensajeRespuesta;
  }

}
