package co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.gateway;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.entidades.DocenteEntity;

import co.edu.unicauca.asae.JpaHexagonal.infraestructura.output.persistencia.repositorios.DocenteRepository;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.TypeToken;

@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {
    
    private  DocenteRepository objDocenteRepository;
    private final ModelMapper docenteModelMapper;
   
    public GestionarDocenteGatewayImplAdapter(DocenteRepository objDocenteRepository,
        @Qualifier("mapperDocente") ModelMapper docenteModelMapper) {
        this.objDocenteRepository = objDocenteRepository;
        this.docenteModelMapper = docenteModelMapper;
    }

    @Override
    public boolean existeDocentePorCorreo(String correo) {
        return this.objDocenteRepository.existeDocentePorcoreo(correo) == 1;
    }
    @Override
    public boolean existeDocentePorIdentificacion(String numero_id) {
        System.out.println("identificacion del docente: "+numero_id);
        return this.objDocenteRepository.existeDocentePorIdentificacion(numero_id) == 1; //com devuelve un entero
    }
    
    @Transactional
    @Override
    public Docente guardar(Docente objDocente) {
        DocenteEntity objDocenteEntity = this.docenteModelMapper.map(objDocente, DocenteEntity.class);
        objDocenteEntity.getObjTelefono().setObjDocente(objDocenteEntity);
        DocenteEntity objDocenteEntityRegistrado = this.objDocenteRepository.save(objDocenteEntity);  
        Docente objDocenteRespuesta = this.docenteModelMapper.map(objDocenteEntityRegistrado, Docente.class);
        return objDocenteRespuesta;
    }

    @Override
    public List<Docente> listar() {
        Iterable<DocenteEntity> lista = this.objDocenteRepository.findAll();
        List<Docente> listaObtenida = this.docenteModelMapper.map(lista, new TypeToken<List<Docente>>() {
        }.getType());
        return listaObtenida;
    }

    public Docente docenteId(Integer id_persona) {
        java.util.Optional<DocenteEntity> objDocente = this.objDocenteRepository.findById(id_persona);

        if (objDocente.isPresent()) {
            DocenteEntity docenteEntity = objDocente.get();
            return this.docenteModelMapper.map(docenteEntity, Docente.class);
        } else {
            throw new EntityNotFoundException("Docente no encontrado con id: " + id_persona);
        }
    }

}