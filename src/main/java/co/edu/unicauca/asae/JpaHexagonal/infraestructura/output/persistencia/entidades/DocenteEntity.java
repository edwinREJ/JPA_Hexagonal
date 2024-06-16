package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table (name = "Docentes")

public class DocenteEntity extends PersonaEntity {


    @NotNull
    @Email
    @Size(min = 1, max = 100)
    @Column(unique = true, nullable = false, length = 100)
    private String correo;

    @NotNull
    @Size(min = 5, max = 50)
    @Column(nullable = false, length = 50)
    private String vinculacion;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "objDocente")
    private TelefonoEntity objTelefono;
  
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "objDocente")
    private List<RespuestaEntity> respuestas;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JoinTable(name="Departameto_Docente",
               joinColumns = @JoinColumn(name="id_persona"),
               inverseJoinColumns = @JoinColumn(name="id_departamento"))
    private List<DepartamentoEntity> departamentos;


    public DocenteEntity() {
        super();
    }

    public DocenteEntity(String tipo_id, String numero_id, String nombres,String apellidos,String correo, 
        String vinculacion) {
        super(tipo_id,numero_id,nombres,apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
    }

}
