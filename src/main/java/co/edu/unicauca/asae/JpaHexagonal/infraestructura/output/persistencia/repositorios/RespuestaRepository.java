package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.RespuestaEntity;

public interface RespuestaRepository extends CrudRepository<RespuestaEntity, Integer> {
    @Query("SELECT count(*) FROM RespuestaEntity c  WHERE c.descripcion=?1")
    Integer existeRespuestaPorDescripcion(String descripcion);
}