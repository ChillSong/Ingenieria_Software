package mx.unam.aragon.ico.is.televisionapi.controllers;

import mx.unam.aragon.ico.is.televisionapi.entities.Television;
import mx.unam.aragon.ico.is.televisionapi.services.Interfaces.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/televisiones")
public class TelevisionController {

    @Autowired
    private TelevisionService televisionService;

    @GetMapping
    public ResponseEntity<Iterable<Television>> getTelevisiones(){
        //return televisionService.listarTodas();
        //return new ResponseEntity<>(televisionService.listarTodas(), HttpStatus.CREATED);
        return ResponseEntity.ok().body(televisionService.listarTodas());
    }

    @GetMapping("/{clave}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long clave){
        //return televisionService.buscarPorId(clave).orElse(null);
        return ResponseEntity.ok(televisionService.buscarPorId(clave).orElse(null));
    }

    @PostMapping
    public ResponseEntity<Television> crearTelevision(@RequestBody Television television) throws URISyntaxException {
        //return televisionService.crear(television);
        return ResponseEntity.created(new URI("http://localhost:8080/api/v1/televisiones")).body(televisionService.crear(television));
    }
}
