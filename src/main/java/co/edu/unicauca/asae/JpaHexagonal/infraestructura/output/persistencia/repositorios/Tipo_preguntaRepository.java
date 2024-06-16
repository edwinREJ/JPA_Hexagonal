package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.Tipo_preguntaEntity;

public interface Tipo_preguntaRepository extends CrudRepository<Tipo_preguntaEntity, Integer> {

}