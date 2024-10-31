package com.cobacha.libro.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/*En este record vamos a guardar los datos que mapeamos del json, los datos que estan en la lista de results.
* los pasamos como parametro de  la clase: Datos
* */

@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
        @JsonAlias ("results") List<DatosLibro> libros //lista de DatosLibro que es un record

) {


}
