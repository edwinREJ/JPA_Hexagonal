package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarRespuesta.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarRespuesta.DTOPeticion.RespuestaDTOPeticion;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestaDTORespuesta;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Respuesta;

@Mapper(componentModel = "spring")

public interface RespuestaMapperInfraestructuraDominio {
    Respuesta mappearDePeticionARespuesta(RespuestaDTOPeticion peticion);
    RespuestaDTORespuesta mappearDeRespuestaARespuesta(Respuesta objRespuesta);
    List<RespuestaDTORespuesta> mappearDeRespuestasARespuesta(List<Respuesta> objRespuesta);
}