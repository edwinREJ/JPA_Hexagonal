package co.edu.unicauca.asae.JpaHexagonal.dominio.modelos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pregunta {
    private int id_pregunta;
    private String enunciado;
    private Cuestionario objCuestionario;
    private TipoPregunta objTipoPregunta;
    //private List<Respuesta> respuestas;
   
    public Pregunta(){

    }



}
