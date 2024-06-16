package co.edu.unicauca.asae.JpaHexagonal.aplicacion.input;

import java.util.List;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Respuesta;

public interface GestionarRespuestaCUIntPort {
    
    public Respuesta crear(Respuesta objRespuesta);

    public List<Respuesta> listar();
}
