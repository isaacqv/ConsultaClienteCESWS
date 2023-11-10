package pe.com.claro.eai.ws.postventa.consultaclientecesws.types;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.util.ConstantesValidacion;

public class AuditRequestType {

  @NotNull(message = ConstantesValidacion.NOT_NULL)
  @NotEmpty(message = ConstantesValidacion.NOT_NULL)
  @Valid
  private String idTransaccion;

  @NotNull(message = ConstantesValidacion.NOT_NULL)
  @NotEmpty(message = ConstantesValidacion.NOT_NULL)
  @Valid
  private String idAplicacion;

  @NotNull(message = ConstantesValidacion.NOT_NULL)
  @NotEmpty(message = ConstantesValidacion.NOT_NULL)
  @Valid
  private String nombreAplicacion;

  @NotNull(message = ConstantesValidacion.NOT_NULL)
  @NotEmpty(message = ConstantesValidacion.NOT_NULL)
  @Valid
  private String usuarioAplicacion;

  public String getIdTransaccion() {
    return idTransaccion;
  }

  public void setIdTransaccion(String idTransaccion) {
    this.idTransaccion = idTransaccion;
  }

  public String getIdAplicacion() {
    return idAplicacion;
  }

  public void setIdAplicacion(String idAplicacion) {
    this.idAplicacion = idAplicacion;
  }

  public String getNombreAplicacion() {
    return nombreAplicacion;
  }

  public void setNombreAplicacion(String nombreAplicacion) {
    this.nombreAplicacion = nombreAplicacion;
  }

  public String getUsuarioAplicacion() {
    return usuarioAplicacion;
  }

  public void setUsuarioAplicacion(String usuarioAplicacion) {
    this.usuarioAplicacion = usuarioAplicacion;
  }

}
