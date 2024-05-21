package com.mycompany.reto6;


public class Empleado {
    private String nombre;
    private int horasTrabajadas;
    private int horasExtraTrabajadas;
    private String telefono;
    private Categoria categoria;
    
    public Empleado(String nombre, int horasTrabajadas, int horasExtraTrabajadas, String telefono, Categoria categoria){
    
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtraTrabajadas = horasExtraTrabajadas;
        this.telefono = telefono;
        this.categoria = categoria;  
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getHorasTrabajadas(){
        return horasTrabajadas;
    }
    
    public int getHorasExtraTrabajadas(){
        return horasExtraTrabajadas;
    }
    
    public String getTelefono(){
        return telefono;        
    }
    
    public double getSueldo(){
        return horasTrabajadas * categoria.getSueldoBase();
    }
    
    public double getSueldoExtra(){
        return horasExtraTrabajadas * categoria.getSueldoExtraBase();
    }

    public double getSueldoNeto(){
        return getSueldo() + getSueldoExtra();
    }
}
