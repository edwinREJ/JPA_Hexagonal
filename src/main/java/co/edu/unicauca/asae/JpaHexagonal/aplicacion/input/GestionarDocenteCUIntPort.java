
package co.edu.unicauca.asae.JpaHexagonal.aplicacion.input;

import java.util.List;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Docente;

public interface GestionarDocenteCUIntPort {
    
    public Docente crear(Docente objDocente);
    
    public List<Docente> listar();

    public Docente docenteId(Integer id);

}