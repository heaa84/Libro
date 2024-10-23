package com.cobacha.libro.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
