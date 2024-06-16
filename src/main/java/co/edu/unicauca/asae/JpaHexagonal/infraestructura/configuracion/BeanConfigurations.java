package co.edu.unicauca.asae.JpaHexagonal.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.GestionarRespuestaGatewayIntPort;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.JpaHexagonal.dominio.casoDeUso.GestionarCuestionarioCUAdapter;
import co.edu.unicauca.asae.JpaHexagonal.dominio.casoDeUso.GestionarDocenteCUAdapter;
import co.edu.unicauca.asae.JpaHexagonal.dominio.casoDeUso.GestionarRespuestaCUAdapter;

@Configuration
public class BeanConfigurations {

    @Bean
    public GestionarCuestionarioCUAdapter crearGestionarCuestionarioCUInt(
        GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway,
        FormateadorResultadosIntPort objCuestionarioFormateadorResultados) {
        GestionarCuestionarioCUAdapter objGestionarCuestionarioCU = new GestionarCuestionarioCUAdapter(objGestionarCuestionarioGateway,
        objCuestionarioFormateadorResultados);
        return objGestionarCuestionarioCU;
    }
     @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(
        GestionarDocenteGatewayIntPort objDocenteGateway,
        FormateadorResultadosIntPort objDocenteFormateadoResultados) {
        GestionarDocenteCUAdapter objGestionarDocenteCU = new GestionarDocenteCUAdapter(objDocenteGateway,
        objDocenteFormateadoResultados);
        return objGestionarDocenteCU;
    }

        @Bean
    public GestionarRespuestaCUAdapter crearGestionarRespuestaCUInt(
            GestionarRespuestaGatewayIntPort objRespuestaGateway,
            FormateadorResultadosIntPort objRespuestaFormateadoResultados) {
        GestionarRespuestaCUAdapter objGestionarRespuestaCU = new GestionarRespuestaCUAdapter(objRespuestaGateway,
                objRespuestaFormateadoResultados);
        return objGestionarRespuestaCU;
    }
}