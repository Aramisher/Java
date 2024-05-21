package com.mycompany.reto7;

import java.util.HashMap;
import java.util.Map;

public class Cafetera {

    // Variables donde controlamos el maximo de cada ingrediente que puede contener la cafetera
    double capacidadMaxCafe = 2000; //gramos
    int capacidadMaxAgua = 3000; //mililitros
    double capacidadMaxAzucar = 2000; //gramos
    
    // Variables del objeto Cafetera
    double actualCafe;
    double actualAgua;
    double actualAzucar;
    
    //Objeto Cafetera que se usara para tener el registro de los insumos que usan los usuarios    
    public Cafetera(){
        this.actualCafe = 2000;
        this.actualAgua = 3000;
        this.actualAzucar = 2000;
    }
    
    //Se crea un HashMap para saber que precio del cafe que quiere el usuario segun 2 caracteristicas, su tamaño y si tiene azucar
    private static final Map<String, Double> preciosCafe = new HashMap<>();
    
    //Precio de diferentes tipos de cafe    
    static{
        preciosCafe.put("pequeñoSinAzucar", 10.50);
        preciosCafe.put("pequeñoConAzucar", 14.50);
        preciosCafe.put("medianoSinAzucar", 24.50);
        preciosCafe.put("medianoConAzucar", 34.50);
        preciosCafe.put("grandeSinAzucar", 34.50);
        preciosCafe.put("grandeConAzucar", 39.50);
    }
    
    //Metodo para obtener el precio de cada cafe
    public static double obtenerPrecio(String tamaño, boolean azucar){
        String clave = tamaño + (azucar ? "ConAzucar" : "SinAzucar"); //Dependiendo de si azucar es true o false se genera una clave
        return preciosCafe.getOrDefault(clave, 0.0);//Retornamos el precio del cafe
    }    

    //Servimos el cafe verificando la disponibilidad de los insumos
    public boolean servirCafe(int mlAgua, boolean azucar){
        double cafeNecesario = (mlAgua / 12.0); //Se servira 1 gramo de cafe por cada 15 mililitro de agua
        double azucarNecesaria = azucar ? (mlAgua / 20.0) : 0; //Se servira 1 gramo de azucar por cada 100 mililitros de agua
        boolean suficientesInsumos; //Variable donde guardaremos si quedan insumos o no
        // Se verifica si aun hay insumos
        if (this.actualCafe >= cafeNecesario && this.actualAgua >= mlAgua && (!azucar || this.actualAzucar >= azucarNecesaria)) {
            this.actualCafe -= cafeNecesario; //Quitamos el cafe que se sirvio del inventario
            this.actualAgua -= mlAgua; //Quitamos el agua que se sirvio del inventario
            if (azucar) {
                this.actualAzucar -= azucarNecesaria; //Quitamos el azucar que se sirvio del inventario
            }
            suficientesInsumos = true;
            return suficientesInsumos; //Si tenemos todos los ingredientes retornamos true
        } else {
            suficientesInsumos = false;
            return suficientesInsumos; //En caso de que falte alguno de los ingredientes retornamos false
        }
    }
    
    //Opciones del menu del administrador
    
    //Metodo para añadir cafe a la maquina
    public void añadirCafe(double cantidad){
        double posibleTotal = this.actualCafe + cantidad; //Variable usada para saber si podremos agregar lo que da el usuario
        if(posibleTotal <= capacidadMaxCafe){ //En caso de que el posible total sea menos que la capacidad maxima se agrega a actualCafe
            this.actualCafe += cantidad;
            System.out.println("Agregando cafe...\nEl cafe se agrego exitosamente");
            System.out.println("Cafe en cafetera: " + this.actualCafe + " gramos");            
        }else{ //En caso de que el posible total sea mayor actualizamos actualCafe para que tenga el maximo posible
            System.out.print("Se ha agregado la cantidad maxima, se rellenara el contenedor a su capacidad maxima \nLa capacidad maxima de cafe es de " + capacidadMaxCafe + " gramos.\n");
            this.actualCafe = capacidadMaxCafe;
        }
    }
    
    //Metodo para añadir agua a la maquina    
    public void añadirAgua(double cantidad){
        double posibleTotal = this.actualAgua + cantidad; //Variable usada para saber si podremos agregar lo que da el usuario
        if(posibleTotal <= capacidadMaxAgua){ //En caso de que el posible total sea menos que la capacidad maxima se agrega a actualAgua
            this.actualAgua += cantidad;         
            System.out.println("Agregando agua...\nEl agua se agrego exitosamente"); 
            System.out.println("Agua en cafetera: " + this.actualAgua + " mililitros");    
        }else{ //En caso de que el posible total sea mayor actualizamos actualAgua para que tenga el maximo posible
            System.out.print("Se ha agregado la cantidad maxima, se rellenara el contenedor a su capacidad maxima \nLa capacidad maxima de agua es de " + capacidadMaxAgua + " mililitros.\n");
            this.actualAgua = capacidadMaxAgua;            
        }
    }
    
    //Metodo para añadir azucar a la maquina    
    public void añadirAzucar(double cantidad){
        double posibleTotal = this.actualAzucar + cantidad; //Variable usada para saber si podremos agregar lo que da el usuario
        if(posibleTotal <= capacidadMaxAzucar){ //En caso de que el posible total sea menos que la capacidad maxima se agrega a actualAzucar
            this.actualAzucar += cantidad;
            System.out.println("Agregando azucar...\nEl azucar se agrego exitosamente\n");
            System.out.println("Azucar en cafetera: " + this.actualAzucar + " gramos");    
        }else{ //En caso de que el posible total sea mayor actualizamos actualAzucar para que tenga el maximo posible
            System.out.print("Se ha agregado la cantidad maxima, se rellenara el contenedor a su capacidad maxima \nLa capacidad maxima de azucar es de " + capacidadMaxAzucar + " gramos.\n");
            this.actualAzucar = capacidadMaxAzucar;            
        }
    }
    
    
    //Getters
    public double getCapacidadMaxCafe(){
        return capacidadMaxCafe;
    }
    
    public double getCapacidadMaxAgua(){
        return capacidadMaxAgua;
    }
    
    public double getCapacidadMaxAzucar(){
        return capacidadMaxAzucar;
    }
    
    public double getActualCafe(){
        return actualCafe;
    }
    
    public double getActualAgua(){
        return actualAgua;
    }
    
    public double getActualAzucar(){
        return actualAzucar;
    }   
}