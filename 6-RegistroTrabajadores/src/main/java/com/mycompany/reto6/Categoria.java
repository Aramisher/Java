package com.mycompany.reto6;

public class Categoria {

    public static final Categoria ventas = new Categoria("Ventas", 100.0, 50.0);
    public static final Categoria administrador = new Categoria("Administrador", 180.0, 100.0);
    public static final Categoria gerente = new Categoria("Gerente", 250.0, 150.0);
    
    private String nombre;
    private double sueldoBase;
    private double sueldoExtra;
                    
    public Categoria(String nombre, double sueldoBase, double sueldoExtraBase){
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.sueldoExtra = sueldoExtraBase;
    }

    public static Categoria getCategoria(String nombreCategoria){
        switch(nombreCategoria){
            case "ventas":
                return ventas;
            case "administrador":
                return administrador;
            case "gerente":
                return gerente;
            default:
                return null;
        }
    }
    
    public String getNombreCategoria(){
        return nombre;
    }
    
    public double getSueldoBase(){
        return sueldoBase;
    }
    
    public double getSueldoExtraBase(){
        return sueldoExtra;
    }
    
}
