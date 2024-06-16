package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.util.List;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Table (name = "Preguntas")
public class PreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pregunta;

    @NotNull
    @NotBlank
    @Column(nullable = false, length = 250)
    private String enunciado;
    

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.LAZY, mappedBy = "objPregunta")
    private List<RespuestaEntity> respuestas;

    @ManyToOne
    @JoinColumn(name="id_cuestionario", nullable = false)
    private CuestionarioEntity objCuestionario;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name="id_tipo_pregunta", nullable = false)
    private Tipo_preguntaEntity objTipoPregunta;
   
    public PreguntaEntity() {
    }

    public PreguntaEntity(String enunciado) {
        this.enunciado = enunciado;
        
    }
     
}
