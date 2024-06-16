package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;


@Entity
@Getter
@Setter
@Table(name = "Respuesta")

public class RespuestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_respuesta;

    @NotNull
    @NotBlank
    @Column(nullable = false, length = 250)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="id_persona", nullable = false)
    private DocenteEntity objDocente;

    @ManyToOne
    @JoinColumn(name="id_pregunta", nullable = false)
    private PreguntaEntity objPregunta;

    public RespuestaEntity() {
        
    }
    public RespuestaEntity(String descripcion) {
        this.descripcion = descripcion;
    }

}
