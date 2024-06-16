package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarDocentes.mappers;
import org.mapstruct.Mapper;

import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import java.util.List;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {
    Docente mapperPeticionDocente(DocenteDTOPeticion peticion);

    DocenteDTORespuesta mapperDocenteRespuesta(Docente objDocente);

    List<DocenteDTORespuesta> mapperDocentesRespuesta(List<Docente> docentes);

}
