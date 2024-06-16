package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@Table (name = "Telefono")

public class TelefonoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_telefono;

    @NotNull
    @NotBlank
   @Column(nullable = false, length = 20)
    private String tipo_telefono;

    @NotNull
    @NotBlank
    @Pattern(regexp = "[3][0-9]{8}") // Estructura que debe tener el número de teléfono
    @Column(unique = true, nullable = false, length = 20)
    private String numero;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private DocenteEntity objDocente;

    public TelefonoEntity() {
    }

    public TelefonoEntity(String tipo_telefono, String numero){
        this.tipo_telefono = tipo_telefono;
        this.numero = numero;
    }
    
}
