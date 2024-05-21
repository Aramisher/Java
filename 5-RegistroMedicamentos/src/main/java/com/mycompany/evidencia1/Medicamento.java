package com.mycompany.evidencia1;

public class Medicamento {
    //Declaramos todos los atributos de Medicamento
    private String nombreQuimico;
    private String nombreGenerico;
    private String nombreRegistrado;
    private double precioPublico;
    private String tipoPresentacion;
    private double precioVenta;
    
    // Creamos un objeto Medicamento que tendra 5 parametros 
    public Medicamento(String nombreQuimico, String nombreGenerico, String nombreRegistrado, double precioPublico, String tipoPresentacion){
        this.nombreQuimico = nombreQuimico;
        this.nombreGenerico = nombreGenerico;
        this.nombreRegistrado = nombreRegistrado;
        this.precioPublico = precioPublico;
        this.tipoPresentacion = tipoPresentacion;
        this.precioVenta = calcularPrecioVenta();

    }
    
    //Calculamos el precio de venta segun la presentacion de cada medicamento
    private double calcularPrecioVenta(){
        double porcentajeAdicional = 0;
        switch(this.tipoPresentacion){
            case"solido":
                porcentajeAdicional = 0.09;
                break;
            case"semisolido":
                porcentajeAdicional = 0.12;
                break;
            case"liquido":
                porcentajeAdicional = 0.13;
                break;                
        }
        return this.precioPublico * (1 + porcentajeAdicional);
    }
    
    
    // Creamos los getters para poder mostrarle al usuario el reporte final con todos los datos
    public String getNombreQuimico(){
        return nombreQuimico;
    }

    public String getNombreGenerico() {
        return nombreGenerico;
    }

    public String getNombreRegistrado() {
        return nombreRegistrado;
    }

    public double getPrecioPublico() {
        return precioPublico;
    }

    public String getTipoPresentacion() {
        return tipoPresentacion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }   
}
