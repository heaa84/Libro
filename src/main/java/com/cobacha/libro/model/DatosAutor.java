package com.cobacha.libro.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias ("name") String Nombre,
        @JsonAlias ("birth_year") String fechaNacimiento,
        @JsonAlias ("death_year") String fechaDefincion
) {

}
