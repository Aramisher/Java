package com.mycompany.evidencia2;

public class Cancion {
    private String nombre;
    private int duracionSegundos;
    private GeneroMusical genero;
    private String cantante;
    private String autor[];
    
    public Cancion(String nombre, int duracionSegundos, GeneroMusical genero, String cantante, String autor[]){
        this.nombre = nombre;
        this.duracionSegundos = duracionSegundos;
        this.genero = genero;
        this.cantante = cantante;
        this.autor = autor;      
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public String getDuracionFormateada() {
        int minutos = duracionSegundos / 60;
        int segundos = duracionSegundos % 60;
        return String.format("%d:%02d", minutos, segundos);
    }

    public GeneroMusical getGenero() {
        return genero;
    }

    public String getCantante() {
        return cantante;
    }

    public String[] getAutor() {
        return autor;
    }        
}
