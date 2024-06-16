package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.PersonaEntity;

public interface PersonaRepository extends CrudRepository<PersonaEntity, Integer> {

}
