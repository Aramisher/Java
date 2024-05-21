package com.mycompany.evidencia2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Playlist {
    private LocalDateTime fechaRegistro;
    private String nombre;
    private String clave;
    private ArrayList<Cancion> canciones;
    
    public Playlist(String nombre, LocalDateTime fechaRegistro, Cancion[] cancionesIniciales) {
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.canciones = new ArrayList<>(Arrays.asList(cancionesIniciales));
        this.clave = generarClave(nombre);
    }
    
    private String generarClave(String nombre) {
        String[] palabras = nombre.split(" ");
        StringBuilder claveBuilder = new StringBuilder();
        for (String palabra : palabras) {
            claveBuilder.append(palabra.charAt(0));
        }
        return claveBuilder.toString().toUpperCase();
    }
    
    public void agregarCancion(Cancion cancion) {
        this.canciones.add(cancion);
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }
    
    public ArrayList<Cancion> getCanciones() {
        return this.canciones;
    }
}
