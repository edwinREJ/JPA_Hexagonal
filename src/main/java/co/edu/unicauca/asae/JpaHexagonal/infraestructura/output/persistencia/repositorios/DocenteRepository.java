package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepository extends CrudRepository<DocenteEntity, Integer> {
  //Aqui se realizan la implementacion de las keys bord 
    @Query("SELECT count(*) FROM DocenteEntity d  WHERE d.correo=?1")
    Integer existeDocentePorcoreo(String correo);
    
    @Query("SELECT count(*) FROM DocenteEntity d  WHERE d.numero_id=?1")
    Integer existeDocentePorIdentificacion(String numero_id);
}
