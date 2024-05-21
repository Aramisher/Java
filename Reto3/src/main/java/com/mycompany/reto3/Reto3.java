
package com.mycompany.reto3;

import java.util.Scanner;

public class Reto3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        System.out.print("""
                         Elige un programa:
                         1) Diccionario
                         2) Generador de arreglo bidimensional
                         """);
        int programa;
        
        do{
            System.out.print("Programa (Valores validos 1 o 2): ");
            programa = MetodosParte2.solicitarInt();  
        }while(programa != 1 && programa != 2);
        
        if(programa == 1){
            
            //Programa 1
            
            String[] diccionario = {
                "Altruismo",
                "Benevolente",
                "Conciso",
                "Diligencia",
                "Efímero",
                "Ferviente",
                "Gregario",
                "Heterogéneo",
                "Inexorable",
                "Jovial"
            };
            String[] significado = {
                "Desinterés por el bienestar de los demás.",
                "Que muestra deseo de ayudar a los demás.",
                "Que expresa mucho en pocas palabras.",
                "Cuidado y rapidez en realizar algo.",
                "Que dura poco tiempo.",
                "Que muestra pasión intensa.",
                "Que disfruta estando en grupos.",
                "Compuesto de elementos diferentes.",
                "Que no se puede detener o cambiar.",
                "Caracterizado por un espíritu alegre."
            };  

            System.out.print("""

                                         **Diccionario**
                               A. Enlistar palabras del diccionario
                               B. Buscar palabras en el diccionario
                               C. Detalle del diccionario
                               S. Finalizar programa
                               """);

            char opcion; 
            do {
                opcion = ' ';
                while (opcion != 'A' && opcion != 'B' && opcion != 'C' && opcion != 'S'){
                    System.out.print("\nOpción(Valores validos A, B, C o S): ");
                    opcion = scanner.next().toUpperCase().charAt(0);
                }
                switch(opcion){
                    case 'A':
                        MetodosParte1.mostrarArreglo(diccionario);
                        break;
                    case 'B':
                        MetodosParte1.mostrarArreglo(diccionario);
                        MetodosParte1.buscarYMostrarInformacion(diccionario, significado);
                        break;
                    case 'C':
                        System.out.println("\nCantidad de palabras en el diccionario: " + diccionario.length);
                        MetodosParte1.totalCaracteresEnElementoArreglo(diccionario, significado);
                        break;                
                }
            }while(opcion != 'S');

            System.out.print("Saliendo del programa...");
            scanner.close(); 
        
        }else{ 
        
        //Programa 2
            
            System.out.print("""
                             
                             **Programa generador de arreglos bidimensionales con numeros random**
                             """);

            int filas, columnas;
            //Se piden los valores de filas y columnas hasta que ambos sean iguales
            do{
                System.out.println("\n(Las filas y columnas deben de ser iguales)");

                System.out.print("\nIndica la cantidad de filas: ");
                filas = MetodosParte2.solicitarInt();

                System.out.print("\nIndica la cantidad de columnas: ");
                columnas = MetodosParte2.solicitarInt();       
            }while(filas != columnas);

            //Se genera un arreglo con los valores dados por el usuario y se llena de numero random del 1 al 100
            int[][] arreglo = MetodosParte2.generarArregloBidimensionalRandom(filas, columnas);

            //Se muestra el creado arreglo al usuario
            MetodosParte2.mostrarArregloBidimensional(arreglo);

            //Se cuentan los pares e impares de cada fila y de cada columna
            MetodosParte2.contarParesImparesArregloBidimensional(arreglo);
       }
    }
}
