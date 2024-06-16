package co.edu.unicauca.asae.JpaHexagonal.aplicacion.output;

import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Cuestionario;

import java.util.List;

public interface GestionarCuestionarioGatewayIntPort {
    
    public boolean existeCuestionarioPorTitulo(String titulo);

    public Cuestionario guardar(Cuestionario objCuestionario);

    public List<Cuestionario> listar();
   
}