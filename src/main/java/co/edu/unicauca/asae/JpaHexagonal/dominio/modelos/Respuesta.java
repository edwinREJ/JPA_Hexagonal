package co.edu.unicauca.asae.JpaHexagonal.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Respuesta {
    
    private int id_respuesta;
    private String descripcion;
    //private Docente objDocente;
    private Pregunta objPregunta;

    public Respuesta() {
    }
}
