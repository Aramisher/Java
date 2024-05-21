package com.mycompany.evidencia1;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Metodos {
    static Scanner scanner = new Scanner(System.in);
    
    //Metodo usado para validar el usuario y contrasena del usuario
    public static boolean validarCredenciales(String usuario, String contra){
        String usuarioCorrecto = "profe";
        String contraCorrecta = "password";
        boolean acceso;
        
        if(usuarioCorrecto.equals(usuario) && contraCorrecta.equals(contra)){
            acceso = true;
            System.out.println("\n¡Inicio de sesión exitoso!");
        }else{
            acceso = false;
            System.out.println("\nUsuario o contraseña incorrectos. Intenta de nuevo");
        }   
        return acceso;
    }
    
    //Metodo usado para validar el valor de entrada double y que no termine el programa en un error
    public static double solicitarDouble(){
        while(true){
            String doubleValue = scanner.next();
            scanner.nextLine(); 
            try{
                return Double.parseDouble(doubleValue);
            }catch(NumberFormatException e){
                System.out.println("Error: No has introducido un valor DOUBLE");
                System.out.print("Numero double: ");
            }
        }
    }
    
    //Metodo que retorna la fecha y hora
    public static String fechaYHora(){
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");    
        
        return ahora.format(formato); 
    }
}
