package com.mycompany.evidencia2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Metodos {
    static Scanner scanner = new Scanner(System.in);
    
    public static String fechaYHora(){
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");    

        return ahora.format(formato); 
    }
    
    public static int solicitarInt(){
        while (true) {
            String intValue = scanner.next();
            try {
                return Integer.parseInt(intValue);
            }catch (NumberFormatException e){
                System.out.println("\nError: No has introducido un valor INT\nEjemplo de valores validos: 34, 858, 99999 \n");
                System.out.print("Numero int: ");
            }
        }
    }        
}
