package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarCuestionarios.DTOPeticion;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.TipoPregunta;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTOPeticion {

    @NotNull(message = "{pregunta.enunciado.emply}")
    @Size(min = 1, max = 100, message = "la cantidad de caracteres del enunciado debe estar entre 1 y 100")
    private String enunciado;

    //@NotNull(message = "{pregunta.puntaje.emply}")
    private Cuestionario objCuestionario;

    @NotNull(message = "{pregunta.tipoPregunta.emply}")
    private TipoPregunta objTipoPregunta;
   
    public PreguntaDTOPeticion(){

    }
}
