package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.mappers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.DocenteEntity;


@Configuration
public class DocenteMapper {
    @Bean
    @Qualifier("mapperDocente")
    public ModelMapper mapperDocente() {
      ModelMapper objMapper = new ModelMapper();

     /*  TypeMap<DocenteEntity, Docente> mapperDocente = objMapper.emptyTypeMap
      (DocenteEntity.class, Docente.class);
      mapperDocente.addMappings(m -> {
        //m.skip(Docente::setObjTelefono);
        //m.skip(Docente::setDepartamentos);
       // m.skip(Docente::setRespuestas);
    }).implicitMappings(); */

      return objMapper;
  } 
}
