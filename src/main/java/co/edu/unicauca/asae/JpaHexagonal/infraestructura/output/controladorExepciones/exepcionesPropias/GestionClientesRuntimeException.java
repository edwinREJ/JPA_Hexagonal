package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.controladorExepciones.exepcionesPropias;

import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.controladorExepciones.estructuraExepciones.CodigoError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionClientesRuntimeException extends RuntimeException {

  protected CodigoError codigoError;

  public abstract String formatException();
}
