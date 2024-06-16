package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.gateway;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.repositorios.CuestionarioRepository;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.TypeToken;

@Service
public class GestionarCuestionarioGatewayImplAdapter implements GestionarCuestionarioGatewayIntPort {

    private final CuestionarioRepository objCuestionarioRepository;
    private final ModelMapper cuestionarioModelMapper;

    public GestionarCuestionarioGatewayImplAdapter(CuestionarioRepository objCuestionarioRepository,
        @Qualifier("mapperCuestionario") ModelMapper cuestionarioModelMapper) {
        this.objCuestionarioRepository = objCuestionarioRepository;
        this.cuestionarioModelMapper = cuestionarioModelMapper;
    }

    @Override
    public boolean existeCuestionarioPorTitulo(String titulo) {
        return this.objCuestionarioRepository.existeCuestionarioPorTitulo(titulo) == 1;
    }

    @Transactional
    @Override
    public Cuestionario guardar(Cuestionario objCuestionario) {
        CuestionarioEntity objCuestionarioEntity = this.cuestionarioModelMapper.map(objCuestionario, CuestionarioEntity.class);
        for (PreguntaEntity objPregunta : objCuestionarioEntity.getListaPreguntas()) {
            objPregunta.setObjCuestionario(objCuestionarioEntity);
        }
        CuestionarioEntity objCuestionarioEntityRegistrado = this.objCuestionarioRepository.save(objCuestionarioEntity);
        Cuestionario objCuestionarioRespuesta = this.cuestionarioModelMapper.map(objCuestionarioEntityRegistrado, Cuestionario.class);
        return objCuestionarioRespuesta;
    }

    @Override
    public List<Cuestionario> listar() {
        Iterable<CuestionarioEntity> lista = this.objCuestionarioRepository.findAll();
        List<Cuestionario> listaObtenida = this.cuestionarioModelMapper.map(lista, new TypeToken<List<Cuestionario>>() {
        }.getType());
        return listaObtenida;
    }

    

}