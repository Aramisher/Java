package com.mycompany.reto3;

import java.util.Scanner;

public class MetodosParte1 {
    static Scanner scanner = new Scanner(System.in);
   
        public static void mostrarArreglo(String arreglo[]){ 
            for(int i = 0; i < arreglo.length; i++){
                System.out.println((i + 1) + ". " + arreglo[i]);   
            }
        }
 
        
        // Método que cumple con la funcionalidad de mostrar una lista de elementos y luego buscar y mostrar la información correspondiente a un elemento seleccionado por el usuario
        public static void buscarYMostrarInformacion(String elemento[], String detalle[]){            

            boolean encontrado; // Si el usuario introduce un valor que este dentro de elementos la variable cambia a true
            String elementoBuscado; //Variable de entrada usada para buscar su informacion en detalle[] 
            
            do{
                encontrado = false;
                System.out.print("\nIngresa palabra a buscar: ");
                elementoBuscado = scanner.nextLine();
                
                for(int i = 0; i < elemento.length; i++){
                    if(elemento[i].equalsIgnoreCase(elementoBuscado)){
                        System.out.println("Significado: " + detalle[i]);
                        encontrado = true;
                        break;
                    }
                }   
                if (!encontrado){
                    System.out.println("La palabra " + elementoBuscado + " no existe. Intenta nuevamente.");
                }
            }while(!encontrado);
        }
        
        
        // Metodo que imprime la longitud de cada cadena en dos arreglos elemento y detalle, junto con sus índices.

        public static void totalCaracteresEnElementoArreglo(String elemento[], String detalle[]) {
            int longitudElemento;
            int longitudDetalle;
            
            for(int i = 0; i < elemento.length; i++){
                longitudElemento = elemento[i].length();
                longitudDetalle = detalle[i].length();
                System.out.println((i + 1) + ". " + elemento[i] + " tiene " + longitudElemento + " caracteres, su significado tiene " + longitudDetalle + " caracteres");                        
            } 
        }
        
        
}
