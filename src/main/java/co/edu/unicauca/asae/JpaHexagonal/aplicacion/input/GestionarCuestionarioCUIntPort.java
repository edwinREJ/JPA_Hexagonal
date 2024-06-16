
package co.edu.unicauca.asae.JpaHexagonal.aplicacion.input;

import java.util.List;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Cuestionario;

public interface GestionarCuestionarioCUIntPort {
    
    public Cuestionario crear(Cuestionario objCuestionario);

    public List<Cuestionario> listar();

}