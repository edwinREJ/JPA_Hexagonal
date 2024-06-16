package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Departamento;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Respuesta;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Telefono;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTOPeticion  extends PersonaDTOPeticion{
 
    @NotNull(message = "{docente.correo.emply}")
    @Email(message = "{docente.correo.format}")
    private String correo;

    @NotNull(message = "{docente.vinculacion.emply}")
    private String vinculacion;
    
    @NotNull(message = "{docente.objTelefono.emply}")
   // @Pattern(regexp = "[3][0-9]{10}", message = "El número de teléfono debe tener 10 dígitos y empezar por 3. Ejemplo: 3001234567")
    private Telefono objTelefono;

    //@NotNull(message = "{docente.objRespuesta.emply}")
    private List<Respuesta> respuestas;

    @NotNull(message = "{docente.objDepartamento.emply}")
    private List<Departamento> departamentos;
}