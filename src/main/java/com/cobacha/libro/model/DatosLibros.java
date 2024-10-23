package com.cobacha.libro.model;

import com.cobacha.libro.service.IConvierteDatos;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosLibros(
        @JsonAlias ("results") List<Result> results
        )
{
}

