package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.formateador;

import org.springframework.stereotype.Service;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.controladorExepciones.exepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.controladorExepciones.exepcionesPropias.ReglaNegocioExcepcion;

@Service
public class FormateadorResultadosImplAdapter implements FormateadorResultadosIntPort {

    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        ReglaNegocioExcepcion objException = new ReglaNegocioExcepcion(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorCorreoExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorCuestionarioRespondido(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retornarRespuestaErrorCuestionarioRespondido'");
    }
}