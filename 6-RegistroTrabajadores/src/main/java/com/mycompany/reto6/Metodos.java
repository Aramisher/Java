package com.mycompany.reto6;

import java.util.Scanner;

public class Metodos {
    static Scanner scanner = new Scanner (System.in);
    
    public static int solicitarInt(){
        while (true) {
            String intValue = scanner.nextLine();
            try {
                return Integer.parseInt(intValue);
            }catch (NumberFormatException e){
                System.out.println("\nError: No has introducido un valor INT\nEjemplo de valores validos: 34, 858, 99999 \n");
                System.out.print("Numero int: ");
                // No es necesario hacer nada aquí, el bucle continuará automáticamente
            }
        }
    }
    
}
