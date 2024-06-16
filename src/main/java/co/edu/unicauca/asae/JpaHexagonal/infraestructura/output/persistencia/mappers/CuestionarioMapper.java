package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.mappers;

import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarCuestionarios.DTOPeticion.*;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.CuestionarioEntity;

@Configuration
public class CuestionarioMapper {
    @Bean
    @Qualifier("mapperCuestionario")
    public ModelMapper crearCuestionarioMapper() {
        ModelMapper objMapper = new ModelMapper();
       
        return objMapper;
    }
}
