package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarCuestionarios.DTOPeticion;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CuestionarioDTOPeticion {
 
    //@NotNull(message = "{cuestionario.titulo.emply}")
    @Size(min = 1, max = 20, message = "la cantidad de caracteres del titulo debe estar entre 1 y 20")
    private String titulo;

    @NotNull(message = "{cuestionario.descripcion.emply}")
    @Size(min = 1, max = 100, message = "la cantidad de caracteres de la descripcion debe estar entre 1 y 100")
    private String descripcion;

    private List<Pregunta> listaPreguntas;

}