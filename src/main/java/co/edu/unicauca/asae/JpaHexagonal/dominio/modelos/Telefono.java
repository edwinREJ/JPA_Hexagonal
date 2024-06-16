package co.edu.unicauca.asae.JpaHexagonal.dominio.modelos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Telefono {
    
    private int id_telefono;
    private String tipo_telefono;
    private String numero;
    //private Docente objDocente;
}
