package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarCuestionarios.DTORespuesta;

import java.util.List;

import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TipoPreguntaDTORespuesta {
    private int setId_tipo_pregunta;
    private String descripcion;  
    private String nombre;
    private List<Pregunta> listaPreguntas;
}
