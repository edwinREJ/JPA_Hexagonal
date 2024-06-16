package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Departamentos")

public class DepartamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_departamento;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String nombre_dep;

    @NotNull
    @Size(min = 1, max = 250)
    @Column(nullable = true, length = 250)
    private String descripcion;

    
    public DepartamentoEntity (){
    }

    public DepartamentoEntity (String nombre_dep, String descripcion){
        this.nombre_dep = nombre_dep;
        this.descripcion = descripcion;
    }

}
