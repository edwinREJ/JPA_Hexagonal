package co.edu.unicauca.asae.JpaHexagonal.dominio.modelos;

import java.util.List;

import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.PreguntaEntity;
import lombok.Data;

@Data
public class TipoPregunta {
    private int id_tipo_pregunta;
    private String nombre;
    private String descripcion;
   //private List<Pregunta> preguntas;
 
    public TipoPregunta(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public TipoPregunta(){

    }
}
