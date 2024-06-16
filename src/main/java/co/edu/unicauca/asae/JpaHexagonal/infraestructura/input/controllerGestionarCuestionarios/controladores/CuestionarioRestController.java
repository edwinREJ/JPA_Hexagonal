package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarCuestionarios.controladores;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.JpaHexagonal.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarCuestionarios.DTOPeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarCuestionarios.DTORespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarCuestionarios.mappers.CuestionarioMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class CuestionarioRestController {

    private final GestionarCuestionarioCUIntPort objGestionarCuestionariosCUInt;
    private final CuestionarioMapperInfraestructuraDominio objMapeador;

    @PostMapping("/cuestionarios")
    public ResponseEntity<CuestionarioDTORespuesta> create(@Valid @RequestBody CuestionarioDTOPeticion objCuestionario) {
        Cuestionario objCuestionarioCrear = objMapeador.mappearDePeticionACuestionario(objCuestionario);
        Cuestionario objCuestionarioCreado = objGestionarCuestionariosCUInt.crear(objCuestionarioCrear);
        ResponseEntity<CuestionarioDTORespuesta> objRespuesta = new ResponseEntity<CuestionarioDTORespuesta>(
                objMapeador.mappearDeCuestionarioARespuesta(objCuestionarioCreado),
                HttpStatus.CREATED);
        return objRespuesta;
    }

   @GetMapping("/cuestionarios")
    public ResponseEntity<List<CuestionarioDTORespuesta>> listar() {
        ResponseEntity<List<CuestionarioDTORespuesta>> objRespuesta = new ResponseEntity<List<CuestionarioDTORespuesta>>(
                objMapeador.mappearDeCuestionariosARespuesta(this.objGestionarCuestionariosCUInt.listar()),
                HttpStatus.OK);
        return objRespuesta;
    }
}