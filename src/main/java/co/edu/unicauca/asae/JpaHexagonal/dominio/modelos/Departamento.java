package co.edu.unicauca.asae.JpaHexagonal.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Departamento {
    
    private int id_departamento;
    private String nombre_dep;
    private String descripcion;

    public Departamento(){
        
    }
}
