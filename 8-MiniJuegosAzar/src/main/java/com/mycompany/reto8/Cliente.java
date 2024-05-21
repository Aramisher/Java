package com.mycompany.reto8;

public class Cliente {
 
    String nombre;
    String correo;
    String telefono;
    String fechaNacimiento;
    
    public Cliente(String nombre, String correo, String telefono, String fechaNacimiento){
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getNombre() {
        return nombre;
    }

    // Getter para correo
    public String getCorreo() {
        return correo;
    }

    // Getter para teléfono
    public String getTelefono() {
        return telefono;
    }

    // Getter para fecha de nacimiento
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }    
    
}
