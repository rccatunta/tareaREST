package com.carpoollp.ruta;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RutaControlador {
    private final RutaRepositorio repositorio;
    RutaControlador(RutaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/rutas")
    List<Ruta> todo(){
        return repositorio.findAll();
    }

    //@RequestMapping(value = "/rutas", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PostMapping("/rutas")
    Ruta nuevaRuta(@RequestBody Ruta rutanueva){
        System.out.println(rutanueva);
        return repositorio.save(rutanueva);
    }

    @GetMapping("/rutas/{id}")
    Ruta uno(@PathVariable Long id){
        return repositorio.findById(id).orElseThrow(()-> new ExcepcionRutaNoEncontrada(id));
    }
    @PutMapping("/rutas/{id}")
    Ruta reemplazarRuta(@RequestBody Ruta nuevaRuta, @PathVariable Long id){
        return repositorio.findById(id).map(
                ruta -> {
                    ruta.setZonaInicio(nuevaRuta.getZonaInicio());
                    ruta.setZonaFinal(nuevaRuta.getZonaFinal());
                    return repositorio.save(ruta);
                })
                .orElseGet(()->{
                    nuevaRuta.setId(id);
                    return repositorio.save(nuevaRuta);
                });
    }

    @DeleteMapping("/rutas/{id}")
    void borrarRuta(@PathVariable Long id){
        repositorio.deleteById(id);
    }

}
