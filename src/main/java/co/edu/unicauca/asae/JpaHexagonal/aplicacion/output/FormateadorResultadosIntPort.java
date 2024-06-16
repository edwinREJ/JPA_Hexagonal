package co.edu.unicauca.asae.JpaHexagonal.aplicacion.output;

public interface FormateadorResultadosIntPort {

    public void retornarRespuestaErrorEntidadExiste(String mensaje);
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
    public void retornarRespuestaErrorCorreoExiste(String mensaje);
    public void retornarRespuestaErrorCuestionarioRespondido(String mensaje);
}