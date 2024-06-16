package co.edu.unicauca.asae.JpaHexagonal.dominio.modelos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cuestionario {

    private int id_cuestionario;
    private String titulo;
    private String descripcion;
    //private List<Pregunta> listaPreguntas;
   
    public Cuestionario() {
    }
    
}
