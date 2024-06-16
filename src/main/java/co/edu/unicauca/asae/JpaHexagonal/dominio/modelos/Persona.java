package co.edu.unicauca.asae.JpaHexagonal.dominio.modelos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persona {

    private int id_persona;
    private String tipo_id;
    private String numero_id;
    private String nombres;
    private String apellidos;
}
