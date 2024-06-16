package co.edu.unicauca.asae.JpaHexagonal.aplicacion.output;

import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Docente;
import java.util.List;

public interface GestionarDocenteGatewayIntPort {
    public Docente guardar(Docente objDocente);
    public List<Docente> listar();
    public boolean existeDocentePorCorreo(String correo);
    public boolean existeDocentePorIdentificacion(String numero_id);
    public Docente docenteId(Integer id);
}