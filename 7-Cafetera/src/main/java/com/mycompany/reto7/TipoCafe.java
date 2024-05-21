package com.mycompany.reto7;

public class TipoCafe {
    String tamaño;
    boolean azucar;
    double precio;
    
    // Objeto TipoCafe para guardar el registro de todos los pedidos
    public TipoCafe(String tamaño, boolean azucar, double precio){
        this.tamaño = tamaño;
        this.azucar = azucar;
        this.precio = precio;
    }

    // Metodo para calcular los mililitros de agua que se usan por tamaño 
    public int calcularMlAgua(){
        switch(this.tamaño){
            case "pequeño":
                return 120;
            case "mediano":
                return 220;
            case "grande":
                return 320;
            default:
                return 100; //Manejo de error
        }
    }
    
    // Getters
    public String getTamaño(){
        return tamaño;
    }
    public boolean getAzucar(){
        return azucar;
    }    
    public double getPrecio(){
        return precio;
    }
}