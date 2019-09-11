package com.carpoollp.ruta;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data //Crea getters, setters, hash y toString
@Entity //Hace que la clase este lista para guardarse en la base de datos JPA
public class Ruta {
    private @Id @GeneratedValue Long id;
    private String zonaInicio;
    private String zonaFinal;

    //Constructor Vacio
    Ruta(){}

    //Constructor por defecto
    Ruta(String zonaInicio,String zonaFinal){
        this.zonaInicio = zonaInicio;
        this.zonaFinal = zonaFinal;
    }
}
