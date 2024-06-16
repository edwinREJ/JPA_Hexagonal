package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.gateway;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.GestionarRespuestaGatewayIntPort;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Respuesta;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.RespuestaEntity;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.repositorios.CuestionarioRepository;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.repositorios.DocenteRepository;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.repositorios.PreguntaRepository;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.repositorios.RespuestaRepository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.TypeToken;

@Service
public class GestionarRespuestaGatewayImplAdapter implements GestionarRespuestaGatewayIntPort {

    private final RespuestaRepository objRespuestaRepository;
    private final ModelMapper RespuestaModelMapper;
   
    @Autowired
	private DocenteRepository servicioBDDocenetes;

	@Autowired
	private CuestionarioRepository servicioBDCuestionario;

    @Autowired
	private PreguntaRepository servicioBDPregunta;

    public GestionarRespuestaGatewayImplAdapter(RespuestaRepository objRespuestaRepository,
        @Qualifier("mapperRespuesta") ModelMapper RespuestaModelMapper) {
        this.objRespuestaRepository = objRespuestaRepository;
        this.RespuestaModelMapper = RespuestaModelMapper;
    }

    @Override
    public boolean existeRespuestaPorDescripcion(String descripcion) {
        return this.objRespuestaRepository.existeRespuestaPorDescripcion(descripcion) == 1;
    }

    @Transactional
    @Override
    public Respuesta guardar(Respuesta objRespuesta) {
        RespuestaEntity objRespuestaEntity = this.RespuestaModelMapper.map(objRespuesta, RespuestaEntity.class);

        DocenteEntity objDocente = this.servicioBDDocenetes.findById(objRespuestaEntity.getObjDocente().getId_persona()).orElse(null);
		objDocente.setId_persona(objRespuestaEntity.getObjDocente().getId_persona()); 

        System.out.println("Docente: "+objDocente.getNombres());

        CuestionarioEntity objCuestionario = this.servicioBDCuestionario.findById(objRespuestaEntity.getObjPregunta().getObjCuestionario().getId_cuestionario()).orElse(null);
		objCuestionario.setId_cuestionario(objRespuestaEntity.getObjPregunta().getObjCuestionario().getId_cuestionario()); 
        
        System.out.println("Cuestionario: "+objCuestionario.getTitulo());

        PreguntaEntity objPregunta= this.servicioBDPregunta.findById(objRespuestaEntity.getObjPregunta().getId_pregunta()).orElse(null);
		objPregunta.setId_pregunta(objRespuestaEntity.getObjPregunta().getId_pregunta());
        
        System.out.println("Pregunta: "+objPregunta.getEnunciado());
        
      /*   List<PreguntaEntity> preguntas = new ArrayList<>();
        preguntas.add(objPregunta);

        List<RespuestaEntity> respuestas =new ArrayList<>();
        respuestas.add(objRespuestaEntity); */

        objRespuestaEntity.setObjDocente(objDocente);
        objRespuestaEntity.setObjPregunta(objPregunta);
       // objCuestionario.setListaPreguntas(preguntas);
       // objPregunta.setRespuestas(respuestas);  
        
        RespuestaEntity objRespuestaEntityRegistrado = this.objRespuestaRepository.save(objRespuestaEntity);
        Respuesta objRespuestaRespuesta = this.RespuestaModelMapper.map(objRespuestaEntityRegistrado, Respuesta.class);
        return objRespuestaRespuesta;
    }

    @Override
    public List<Respuesta> listar() {
        Iterable<RespuestaEntity> lista = this.objRespuestaRepository.findAll();
        List<Respuesta> listaObtenida = this.RespuestaModelMapper.map(lista, new TypeToken<List<Respuesta>>() {
        }.getType());
        return listaObtenida;
    }

}
