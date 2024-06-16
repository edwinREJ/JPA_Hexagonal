package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarRespuesta.controladores;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.input.GestionarRespuestaCUIntPort;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Respuesta;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarRespuesta.DTOPeticion.RespuestaDTOPeticion;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestaDTORespuesta;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarRespuesta.mappers.RespuestaMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class RespuestaRestController {

    private final GestionarRespuestaCUIntPort objGestionarRespuestasCUInt;
    private final RespuestaMapperInfraestructuraDominio objMapeador;

    @PostMapping("/respuestas")
    public ResponseEntity<RespuestaDTORespuesta> create(@Valid @RequestBody RespuestaDTOPeticion objRespuestaP) {
        Respuesta objRespuestaCrear = objMapeador.mappearDePeticionARespuesta(objRespuestaP);
        Respuesta objRespuestaCreado = objGestionarRespuestasCUInt.crear(objRespuestaCrear);
        ResponseEntity<RespuestaDTORespuesta> objRespuesta = new ResponseEntity<RespuestaDTORespuesta>(
                objMapeador.mappearDeRespuestaARespuesta(objRespuestaCreado),
                HttpStatus.CREATED);
        return objRespuesta;
    }

   @GetMapping("/respuestas")
    public ResponseEntity<List<RespuestaDTORespuesta>> listar() {
        ResponseEntity<List<RespuestaDTORespuesta>> objRespuesta = new ResponseEntity<List<RespuestaDTORespuesta>>(
                objMapeador.mappearDeRespuestasARespuesta(this.objGestionarRespuestasCUInt.listar()),
                HttpStatus.OK);
        return objRespuesta;
    }
   
    
}
