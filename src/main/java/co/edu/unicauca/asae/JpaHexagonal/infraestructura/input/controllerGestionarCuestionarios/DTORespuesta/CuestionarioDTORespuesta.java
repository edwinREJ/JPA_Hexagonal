package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarCuestionarios.DTORespuesta;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Pregunta;;

@Getter
@Setter
@AllArgsConstructor
public class CuestionarioDTORespuesta {
    
    private int id_cuestionario;
    private String titulo;
    private String descripcion;  
    private List<Pregunta> listaPreguntas;

    public CuestionarioDTORespuesta() {

    }
}