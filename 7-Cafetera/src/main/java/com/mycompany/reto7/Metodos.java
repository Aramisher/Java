package com.mycompany.reto7;

import java.util.Scanner;

public class Metodos {
    static Scanner scanner = new Scanner(System.in);
    
    //Metodo para solicitar Int sin que de error
    public static int solicitarInt(){
        while (true) {
            String intValue = scanner.nextLine();
            try {
                return Integer.parseInt(intValue);
            }catch (NumberFormatException e){
                System.out.println("\nError: No has introducido un valor INT \n");
                // No es necesario hacer nada aquí, el bucle continuará automáticamente
                System.out.print("Numero int: ");
            }
        }
    }    
    
    //Metodo para solicitar double sin que de error
    public static double solicitarDouble(){
        while(true){
            String doubleValue = scanner.nextLine();
            try{
                return Double.parseDouble(doubleValue);
            }catch(NumberFormatException e){
                System.out.println("Error: No has introducido un valor DOUBLE");
                System.out.println("Valor double: ");
            }
        }
    }
    
    //Metodo para solicitar boolean sin que de error
    public static boolean solicitarBoolean() {
        while (true) {
            String boolValue = scanner.nextLine(); // Elimina espacios en blanco adicionales
            // Comprueba si la entrada es '1' o '0'
            if (boolValue.equals("1") || boolValue.equals("s") || boolValue.equals("si") || boolValue.equals("true")){
                return true; // Retorna verdadero si el usuario ingresa 1, s, si o true
            } else if (boolValue.equals("0")|| boolValue.equals("n") || boolValue.equals("no") || boolValue.equals("false")) {
                return false; // Retorna falso si el usuario ingresa 0, n, no o false
            } else {
                // Informa al usuario sobre una entrada inválida y repite el bucle
                System.out.println("\nError: La entrada no es válida. Por favor, ingresa '1' para verdadero o '0' para falso.\n");
                System.out.print("Valor boolean: ");
            }
        }
    }
    
    //Sistema para regresar cambio al usuario en monedas
    public static void sistemaCambio(double pago, double precio){
        double cambio = pago - precio;
        int monedas = 0;
        //Si cambio es mayor o igual que 50 centavos desplegamos la ventana de cambio
        if (cambio >= .5){
            System.out.println("\n  ***Cambio***   ");
            System.out.println("Cantidad: " + cambio);
        }
        //Si es mayor o igual a 10 dara cambio de monedas de 10
        if(cambio >= 10){
            while(cambio >= 10){
                cambio -= 10;
                monedas++;
            }
            System.out.println("Monedas de 10: " + monedas);
            monedas = 0;
        }
        //Si es mayor o igual a 10 dara cambio de monedas de 10        
        if(cambio >= 5){
            while(cambio >= 5){
                cambio -= 5;
                monedas++;
            }
            System.out.println("Monedas de 5: " + monedas);            
            monedas = 0;
        }
        //Si es mayor o igual a 2 dara cambio de monedas de 2              
        if(cambio >= 2){
            while(cambio >= 2){
                cambio -= 2;
                monedas++;
            }
            System.out.println("Monedas de 2: " + monedas);            
        }                 
        //Si es mayor o igual a 1 dara cambio de una moneda de 1              
        if(cambio >= 1){
                cambio -= 1;
            System.out.println("Monedas de 1: 1");            
        }        
        //Si es igual a .5 dara cambio de una moneda de 50 centavoz                
        if(cambio == .5){
            System.out.println("Monedas de .5: 1");            
        }        
    }
}