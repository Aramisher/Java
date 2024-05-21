package com.mycompany.reto8;

import java.util.Scanner;

public class Metodos {
    static Scanner scanner = new Scanner(System.in);
    public static int solicitarInt(){
        while (true) {
            String intValue = scanner.nextLine();
            try {
                return Integer.parseInt(intValue);
            }catch (NumberFormatException e){
                System.out.println("\nError: No has introducido un valor INT\n");
                System.out.print("Numero int: ");
                // No es necesario hacer nada aquí, el bucle continuará automáticamente
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


}
