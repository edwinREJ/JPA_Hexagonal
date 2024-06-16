package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.CuestionarioEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CuestionarioRepository extends CrudRepository<CuestionarioEntity, Integer> {

    //Aqui se realizan la implementacion de las keys bord 
    @Query("SELECT count(*) FROM CuestionarioEntity c  WHERE c.titulo=?1")
    Integer existeCuestionarioPorTitulo(String titulo);

  /* @Query("SELECT c FROM Cuestionario c WHERE LOWER(c.titulo) LIKE LOWER(CONCAT('%', :tituloC, '%')) ORDER BY c.id DESC")
    List<Cuestionario> findByTituloIgnoreCaseContainingOrderByidDesc(@Param("nombreC") String tituloCuestionario); */
    
}
