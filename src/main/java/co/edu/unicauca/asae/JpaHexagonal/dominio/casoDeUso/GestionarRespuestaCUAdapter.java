package co.edu.unicauca.asae.JpaHexagonal.dominio.casoDeUso;

import java.util.List;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.input.GestionarRespuestaCUIntPort;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.GestionarRespuestaGatewayIntPort;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Respuesta;

public class GestionarRespuestaCUAdapter implements GestionarRespuestaCUIntPort{

     private final GestionarRespuestaGatewayIntPort objGestionarRespuestaGateway;
    private final FormateadorResultadosIntPort objRespuestaFormateadorResultados;
    
    public GestionarRespuestaCUAdapter(GestionarRespuestaGatewayIntPort objRegistrarRespuestaGateway,
    FormateadorResultadosIntPort objRespuestaFormateadorResultados) {
        this.objGestionarRespuestaGateway = objRegistrarRespuestaGateway;
        this.objRespuestaFormateadorResultados = objRespuestaFormateadorResultados;   
    }

    @Override
    public Respuesta crear(Respuesta objRespuesta) {
        Respuesta objRespuestaCreado = null;
        if (this.objGestionarRespuestaGateway.existeRespuestaPorDescripcion(objRespuesta.getDescripcion())) {
            this.objRespuestaFormateadorResultados.retornarRespuestaErrorEntidadExiste("Error, ya existe un Respuesta con esa descripcion.");
            } 
        else {
            objRespuestaCreado = this.objGestionarRespuestaGateway.guardar(objRespuesta);
        }
        return objRespuestaCreado;
    }

    @Override
    public List<Respuesta> listar() {
        List<Respuesta> listaObtenida = objGestionarRespuestaGateway.listar();
        return listaObtenida;
    }

    
}
