package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.DepartamentoEntity;

public interface DepartamentoRepository extends CrudRepository<DepartamentoEntity, Integer> {

}
