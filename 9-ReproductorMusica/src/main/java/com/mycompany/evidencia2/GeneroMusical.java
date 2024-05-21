package com.mycompany.evidencia2;

public class GeneroMusical {
    private String nombre;
    private String clave;
    
    public GeneroMusical(String nombre){
        this.nombre = nombre;
        this.clave = generarClaveGenero(nombre);
    }
    
    private String generarClaveGenero(String nombre) {
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1, 3).toLowerCase();
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }
}
