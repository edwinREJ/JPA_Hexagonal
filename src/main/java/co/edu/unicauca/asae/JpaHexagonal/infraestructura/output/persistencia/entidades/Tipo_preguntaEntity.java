package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Table (name = "tipopregunta")


public class Tipo_preguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_pregunta;

    @NotNull
    @NotBlank
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotNull
    @NotBlank
    @Column(nullable = false, length = 250)
    private String descripcion;
    
    @OneToMany(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER, mappedBy = "objTipoPregunta")
    private List<PreguntaEntity> preguntas;
   
    public Tipo_preguntaEntity() {
    }

    public Tipo_preguntaEntity(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.preguntas = new ArrayList<PreguntaEntity>();
    }
   
}
