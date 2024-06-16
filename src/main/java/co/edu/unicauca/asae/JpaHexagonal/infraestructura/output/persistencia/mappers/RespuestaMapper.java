package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.RespuestaEntity;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Respuesta;

@Configuration
public class RespuestaMapper {
    @Bean
    @Qualifier("mapperRespuesta")
    public ModelMapper mapperRespuesta() {
      ModelMapper objMapper = new ModelMapper();

     /*  TypeMap<RespuestaEntity, Respuesta> mapperRespuesta = objMapper.emptyTypeMap
      (RespuestaEntity.class, Respuesta.class);
      mapperRespuesta.addMappings(m -> {
        //m.skip(Respuesta::setObjDocente);
        //m.skip(Respuesta::setObjPregunta);
    }).implicitMappings();*/

      return objMapper;
      }
    }