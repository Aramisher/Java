package com.mycompany.reto1;

import java.io.*;

public class Metodos {
    static boolean error;
    public static float peso;
    public static int estatura;
    public static char genero;
    public static int edad;
    
    public static char solicitarOpcion(BufferedReader reader) throws IOException {
        char opcion;
        do {
            System.out.print("¿A, B o C?: ");
            String stringOpcion = reader.readLine();
            opcion = (stringOpcion.length() > 0) ? stringOpcion.charAt(0) : '\0';  // Toma el primer carácter si existe

            if (opcion != 'A' && opcion != 'B' && opcion != 'C') {
                System.out.println("\nOpción no válida. Por favor, intenta de nuevo");
            }    
        } while(opcion != 'A' && opcion != 'B' && opcion != 'C');
        return opcion;
    }
    
    //Peso y estatura seran usadas por todas las opciones
    public static float solicitarPeso(BufferedReader reader) throws IOException {
        do{
            error = false;
            System.out.print("\n¿Cual es tu peso en kg? Ejemplo(75.10): ");
            String pesoString = reader.readLine();
            
            try{
                peso = Float.parseFloat(pesoString);
            } catch(NumberFormatException e){
                System.out.println("\nError: no has introducido un valor decimal \nEjemplo de valores validos: 56.32, 45, 36.00:");
                error = true;
            }
        } while(error == true);
        return peso;
    }
    
    public static int solicitarEstatura(BufferedReader reader) throws IOException {
    
        do{
            error = false;
            System.out.print("\n¿Cual es tu altura en cm? Ejemplo(183, 154, 167): ");
            String estaturaString = reader.readLine();
            
            try{
                estatura = Integer.parseInt(estaturaString);
            }catch(NumberFormatException e){
                System.out.println("\nError: No has introducido un numero entero \nEjemplo de valores validos: 137, 120, 201");
                error = true;
            }
        } while(error == true);
        return estatura;
    }
    
    //Genero sera usado por las opciones B y C
    public static char solicitarGenero(BufferedReader reader) throws IOException {

        System.out.print("""
                         
                         M = Masculino
                         F = Femenino
                         """);
        do {
            System.out.print("Genero: ");
            String generoString = reader.readLine();
            genero = (generoString.length() > 0) ? generoString.charAt(0) : '\0';  // Toma el primer carácter si existe

            if (genero != 'M' && genero != 'F') {
                System.out.println("\nOpción no válida. Por favor, intenta de nuevo");
            }    
        } while(genero != 'M' && genero != 'F');
        return genero;
    }
    
    //Edad sera usada solo por la opción C
    public static int solicitarEdad(BufferedReader reader) throws IOException {
        
        do{
            error = false;
            System.out.print("\n¿Que edad tienes? (0-100): ");
            String edadString = reader.readLine();
            
            try{
                edad = Integer.parseInt(edadString);
                if (edad > 100 || edad < 1) { // Asegúrate de que el rango incluya el 1
                    System.out.println("Error: Tiene que ser un número del 1 al 100\n");
                    error = true; 
                }
            }catch(NumberFormatException e){
                System.out.println("\nError: No has introducido un numero entero \nEjemplo de valores validos: 34, 8, 99");
                error = true;
            }   
        } while(error == true);
        return edad;
    }
    
    //Opción A
    public static String indiceMasaCorporal(float peso, int estatura){
        
        System.out.println("""
                           
                           Tabla del IMC:
                           Menor a 18.9 = peso bajo 
                           18.9 a 24.99 = peso normal 
                           25.00 a 29.99 = sobrepeso 
                           30.00 a 34.99 = obesidad leve 
                           35.00 a 39.99 = obesidad media 
                           Mayor a 40.0 = obesidad mórbida 
                           """);
        
        float imc = peso / ((estatura/100f) * (estatura/100f));
        String condicion;
        
        if (imc < 18.9) {
           condicion = "(peso bajo)";
        }else if (imc < 25) {
           condicion = "(peso normal)";
        }else if (imc < 30) {
           condicion = "(sobrepeso)";
        }else if (imc < 35) {
           condicion = "(obesidad leve)";
        }else if (imc < 40) {
           condicion = "(obesidad media)";
        }else {
           condicion = "(obesidad mórbida)";
        }
        
        String resultado = ("\nTu Indice de Masa Corporal (IMC) es : " + imc + condicion);
        System.out.println(resultado);
        return resultado;
    }

    //Opción B
    public static String masaCorporalMagra(float peso, int estatura, char genero){
        double mcm;
        if(genero == 'M'){
            mcm = ((1.10 * peso)- 128 * ((peso * peso)/(estatura * estatura)));
        }else{
            mcm = ((1.07 * peso)- 148 * ((peso * peso)/(estatura * estatura)));
        }
        
        String resultado = "\nTu masa corporal magra segun tu genero, estatura y peso es de " + mcm + " kg";
        System.out.println(resultado);
        return resultado;
    }
    
    //Opción C
    public static String metabolismoBasal(float peso, int estatura, char genero, int edad){
        double mb;
        if(genero == 'M'){
            mb = (655.1 + (9.563 * peso) + (1.85 * estatura) - (4.676 * edad));
        }else{
            mb = (66.5 + (13.75 * peso) + (5.003 * estatura) - (6.775 * edad));
        }
        
        String resultado = "\nTu metabolismo basal segun tu genero, estatura, peso y edad es de " + mb + " kcal/dia.";
        System.out.println(resultado);
        return resultado;
    }
}

