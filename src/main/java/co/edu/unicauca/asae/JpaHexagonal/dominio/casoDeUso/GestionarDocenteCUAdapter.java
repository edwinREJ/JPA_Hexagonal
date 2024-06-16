package co.edu.unicauca.asae.JpaHexagonal.dominio.casoDeUso;

import co.edu.unicauca.asae.JpaHexagonal.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Docente;
import java.util.List;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort {

    private final GestionarDocenteGatewayIntPort objDocenteGatewayInt;
    private final FormateadorResultadosIntPort objFormateadorResultadosInt;

    

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objDocenteGatewayInt,

        FormateadorResultadosIntPort objFormateadorResultadosInt) {

        this.objDocenteGatewayInt = objDocenteGatewayInt;
        
        this.objFormateadorResultadosInt = objFormateadorResultadosInt;
    }

    @Override
    public Docente crear(Docente objDocente) {

        Docente objDocenteCreado = null;

        if (this.objDocenteGatewayInt.existeDocentePorIdentificacion(objDocente.getNumero_id())) {

            this.objFormateadorResultadosInt
                    .retornarRespuestaErrorEntidadExiste(

                            "Error, ya existe un docente con esa identificación registrada en el sistema.");

        } else if (this.objDocenteGatewayInt.existeDocentePorCorreo(objDocente.getCorreo())) {

            this.objFormateadorResultadosInt.retornarRespuestaErrorCorreoExiste(

                    "Error, ya existe un docente con ese correo registrado en el sistema.");
        } else {

            objDocenteCreado = this.objDocenteGatewayInt.guardar(objDocente);
        }
        return objDocenteCreado;
    }

    @Override
    public List<Docente> listar() {
        List<Docente> listaObtenida = objDocenteGatewayInt.listar();
        return listaObtenida;
    }

    public Docente docenteId(Integer id){
        Docente docenteObtenido = objDocenteGatewayInt.docenteId(id);
        return docenteObtenido;
    }
  
}