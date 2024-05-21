package com.mycompany.reto3;

import java.util.Scanner;
import java.util.Random;

public class MetodosParte2 {
    static Scanner scanner = new Scanner(System.in);

    // Metodo para solicitar int sin que de error
    public static int solicitarInt(){
        while (true) {
            String intValue = scanner.next();
            try {
                return Integer.parseInt(intValue);
            }catch (NumberFormatException e){
                System.out.println("\nError: No has introducido un valor valido\n");
                // No es necesario hacer nada aquí, el bucle continuará automáticamente
            }
        }
    }
    
    // Metodo para generar arreglos bidimensionales con dimensiones dadas por el usuario y genera valores random del 1 al 10 
    public static int[][] generarArregloBidimensionalRandom(int filas, int columnas){
        Random random = new Random();
        int[][] arreglo = new int[filas][columnas];
        for(int i=0;i < filas; i++){
            for(int j=0;j < columnas; j++){
                arreglo[i][j] = random.nextInt(100)+1;
            }
        }     
        return arreglo;
    }
    
    //Metodo para mostrar el arreglo proporsionado
    public static void mostrarArregloBidimensional(int[][] arreglo){
        for(int i=0;i < arreglo.length;i++){
            for(int j=0;j < arreglo[i].length;j++){
                System.out.print(String.format("%4d", arreglo[i][j])); // Formatea cada número para que ocupe un mínimo de 4 espacios
            }
            System.out.println();
        }
    }
    
    // Metodo que cuenta e imprime la cantidad de pares e impares de cada fila y de cada columna
    public static void contarParesImparesArregloBidimensional(int[][] arreglo){
        int pares;
        int impares;
        
        System.out.println("-------------------------------------------------");
        //Pares e impares de filas
        for(int i=0;i < arreglo.length;i++){
            pares = 0;
            impares = 0;
            for(int j=0;j < arreglo[i].length;j++){
                if(arreglo[i][j] % 2 == 0){
                    pares++;
                }else{
                    impares++;
                }
            }
            System.out.println("Cantidad de pares: " + pares + ", impares: " + impares + " en la fila " + (i+1));
        }             
        System.out.println("-------------------------------------------------");
        
        //Pares e impares de columnas
        for(int i=0;i < arreglo[0].length;i++){
            pares = 0;
            impares = 0;
            for(int j=0;j < arreglo.length;j++){
                if(arreglo[j][i] % 2 == 0){
                    pares++;
                }else{
                    impares++;
                }
            }
            System.out.println("Cantidad de pares: " + pares + ", impares: " + impares + " en la columna " + (i+1));
        }        
        System.out.println("-------------------------------------------------");
    }
}
