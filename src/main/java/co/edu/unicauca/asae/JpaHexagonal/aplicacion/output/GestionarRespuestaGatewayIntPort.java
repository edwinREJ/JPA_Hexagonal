package co.edu.unicauca.asae.JpaHexagonal.aplicacion.output;

import java.util.List;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Respuesta;


public interface GestionarRespuestaGatewayIntPort {

    public boolean existeRespuestaPorDescripcion(String descripcion);

    public Respuesta guardar(Respuesta objRespuesta);

    public List<Respuesta> listar();

}
