package co.edu.unicauca.asae.JpaHexagonal.dominio.casoDeUso;

import co.edu.unicauca.asae.JpaHexagonal.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Cuestionario;

import java.util.List;

public class GestionarCuestionarioCUAdapter implements GestionarCuestionarioCUIntPort {

    private final GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway;
    private final FormateadorResultadosIntPort objCuestionarioFormateadorResultados;
    
    public GestionarCuestionarioCUAdapter(GestionarCuestionarioGatewayIntPort objRegistrarCuestionarioGateway,
    FormateadorResultadosIntPort objCuestionarioFormateadorResultados) {
        this.objGestionarCuestionarioGateway = objRegistrarCuestionarioGateway;
        this.objCuestionarioFormateadorResultados = objCuestionarioFormateadorResultados;   
    }

    @Override
    public Cuestionario crear(Cuestionario objCuestionario) {
        Cuestionario objCuestionarioCreado = null;
        System.out.println("holi "+this.objGestionarCuestionarioGateway.existeCuestionarioPorTitulo(objCuestionario.getTitulo()));
        if (this.objGestionarCuestionarioGateway.existeCuestionarioPorTitulo(objCuestionario.getTitulo())) {
            this.objCuestionarioFormateadorResultados.retornarRespuestaErrorEntidadExiste("Error, ya existe un cuestionario con ese titulo.");
            } 
        else {
            objCuestionarioCreado = this.objGestionarCuestionarioGateway.guardar(objCuestionario);
        }
        return objCuestionarioCreado;
    }

    @Override
    public List<Cuestionario> listar() {
        List<Cuestionario> listaObtenida = objGestionarCuestionarioGateway.listar();
        return listaObtenida;
    }

}