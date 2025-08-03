package com.example.LiteraturaReto.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
