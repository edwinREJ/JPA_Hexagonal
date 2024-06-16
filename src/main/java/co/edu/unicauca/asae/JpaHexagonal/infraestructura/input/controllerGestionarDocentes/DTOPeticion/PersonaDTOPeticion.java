package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDTOPeticion {
    private int id_persona;
    //@NotNull(message = "{docente.tipoIdentificacion.emply}")
    private String tipoIdentificacion;

   @NotNull(message = "{docente.tipo_id.emply}")
    private String tipo_id;

    @NotNull(message = "{docente.numero_id.emply}")
    private String numero_id;

    @NotNull(message = "{docente.nombre.emply}")
    @Size(min = 5, max = 45, message = "El tamaño del nombre debe estar entre 5 y 45 caracteres")
    private String nombres;

    @NotNull(message = "{docente.apellido.emply}")
    @Size(min = 5, max = 45, message = "El tamaño del apellido debe estar entre 5 y 45 caracteres")
    private String apellidos;
}