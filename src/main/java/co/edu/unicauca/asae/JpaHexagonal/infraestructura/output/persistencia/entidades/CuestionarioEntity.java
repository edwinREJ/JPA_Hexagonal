package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import java.util.List;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;  
import javax.validation.constraints.NotBlank;


@Entity
@Getter
@Setter
@Table(name = "Cuestionarios")
//Un cuestionario puede tener muhcas preguntas

public class CuestionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cuestionario;

    @NotNull
    @NotBlank
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotNull
    @NotBlank
    @Column(nullable = true, length = 250)
    private String descripcion;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.LAZY,mappedBy = "objCuestionario")
    private List<PreguntaEntity> listaPreguntas;
    
    public CuestionarioEntity() {
        
    }

    public CuestionarioEntity( String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;;
    } 
      
}
