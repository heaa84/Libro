package com.cobacha.libro.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {
    //cramos instancia de OdjectMapper que nos sirve para mapear el json
    private final ObjectMapper mapper = new ObjectMapper();

    //implementamos la interface IConvertirDatos
    @Override
    public <T> T obtenerDatos (String json, Class <T> clase){
     try {
         //si todo sale bien retornamos el mapeo del json
         return mapper.readValue(json, clase);
     }catch (JsonProcessingException e){
         throw new RuntimeException(e);
     }
    }
}
