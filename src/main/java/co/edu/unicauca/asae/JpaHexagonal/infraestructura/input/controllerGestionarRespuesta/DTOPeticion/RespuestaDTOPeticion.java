package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarRespuesta.DTOPeticion;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RespuestaDTOPeticion {
    

    private int id_respuesta;

    @NotNull(message = "{respuesta.respuesta.emply}")
    @Size(min = 1, max = 100, message = "la cantidad de caracteres de la respuesta debe estar entre 1 y 100")
    private String descripcion;

    @NotNull(message = "{respuesta.objDocente.emply}")
    private Docente objDocente;
    
    @NotNull(message = "{respuesta.objPregunta.emply}")
    private Pregunta objPregunta;

}

