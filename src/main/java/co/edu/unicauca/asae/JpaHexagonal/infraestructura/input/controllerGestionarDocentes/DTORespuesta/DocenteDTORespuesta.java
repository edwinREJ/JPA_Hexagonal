package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarDocentes.DTORespuesta;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Departamento;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Respuesta;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Telefono;

@Getter
@Setter
@NoArgsConstructor
public class DocenteDTORespuesta extends PersonaDTORespuesta {

    private String correo;
    private String vinculacion;
    private Telefono objTelefono;
    private List<Respuesta> respuestas;
    private List<Departamento> departamentos;
}