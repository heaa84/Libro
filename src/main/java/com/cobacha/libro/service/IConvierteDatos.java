package com.cobacha.libro.service;

public interface IConvierteDatos {
    /*
    * Metodo obtenerDatos de lipo generico osea:
    * <T> T obtenerDatos
    * a este metodo le pasamos 2 parametros un json que sera el que consumismo de la API  y un clase de tipo generica osea:
    * (String json, Class <T> clase)
    * */
    <T> T obtenerDatos (String json, Class <T> clase);
}
