package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarRespuesta.DTORespuesta;

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

public class RespuestaDTORespuesta {  
    private int id_respuesta;
    private String descripcion;
    private Pregunta objPregunta;
    private Docente objDocente;
}
