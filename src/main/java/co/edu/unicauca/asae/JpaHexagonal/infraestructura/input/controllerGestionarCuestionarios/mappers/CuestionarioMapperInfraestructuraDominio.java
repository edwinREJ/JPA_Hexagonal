package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarCuestionarios.mappers;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarCuestionarios.DTOPeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarCuestionarios.DTORespuesta.CuestionarioDTORespuesta;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CuestionarioMapperInfraestructuraDominio {
    
    Cuestionario mappearDePeticionACuestionario(CuestionarioDTOPeticion peticion);
    CuestionarioDTORespuesta mappearDeCuestionarioARespuesta(Cuestionario objCuestionario);
    List<CuestionarioDTORespuesta> mappearDeCuestionariosARespuesta(List<Cuestionario> objCuestionario);
}