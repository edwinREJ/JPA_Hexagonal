package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarDocentes.DTORespuesta;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDTORespuesta {

    private int id_persona;
    private String tipo_id;
    private String numero_id;
    private String nombres;
    private String apellidos;
}