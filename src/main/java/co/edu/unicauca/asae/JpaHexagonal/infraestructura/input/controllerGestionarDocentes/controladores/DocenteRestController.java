package co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarDocentes.controladores;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unicauca.asae.JpaHexagonal.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.JpaHexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;

import co.edu.unicauca.asae.JpaHexagonal.infraestructura.input.controllerGestionarDocentes.mappers.DocenteMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class DocenteRestController {

    private final GestionarDocenteCUIntPort objGestionarDocentesCUInt;
    private final DocenteMapperInfraestructuraDominio objMapeador;

    @PostMapping("/docente")
    public ResponseEntity<DocenteDTORespuesta> create(@Valid @RequestBody DocenteDTOPeticion objDocente) {
        Docente objDocenteCrear = objMapeador.mapperPeticionDocente(objDocente);
        Docente objDocenteCreado = objGestionarDocentesCUInt.crear(objDocenteCrear);
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(
                objMapeador.mapperDocenteRespuesta(objDocenteCreado),
                HttpStatus.CREATED);
        return objRespuesta;
    }

   @GetMapping("/docentes")
    public ResponseEntity<List<DocenteDTORespuesta>> listar() {
        ResponseEntity<List<DocenteDTORespuesta>> objRespuesta = new ResponseEntity<List<DocenteDTORespuesta>>(
            objMapeador.mapperDocentesRespuesta(this.objGestionarDocentesCUInt.listar()),
            HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/docentes/{id}")
	public ResponseEntity<DocenteDTORespuesta> docenteId(@PathVariable Integer id) {
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(
            objMapeador.mapperDocenteRespuesta(this.objGestionarDocentesCUInt.docenteId(id)),
            HttpStatus.OK);
        return objRespuesta;
    }    
}