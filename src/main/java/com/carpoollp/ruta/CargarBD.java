package com.carpoollp.ruta;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CargarBD{
    @Bean
    CommandLineRunner iniciarDB(RutaRepositorio repositorio){
        return args -> {
            log.info("Preloading "+repositorio.save(new Ruta("Miraflores","Obrajes")));
            log.info("Preloading "+repositorio.save(new Ruta("Irpavi","Los Pinos")));
        };
    }
}
