package com.mycompany.reto4;

import java.util.Scanner;
import java.util.ArrayList;

public class Reto4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                         **Programa asistente para registro de venta de boletos**
                         A. Realizar venta de boleto
                         B. Mostrar datos de la lista de ventas
                         S. Finalizar programa
                         """);
        char opcion = ' ';
        ArrayList<String> listaPasajeros = new ArrayList<>();  //Nombres de todos los pasajeros
        ArrayList<String> listaTicket = new ArrayList<>();   //Nombres de los pasajeros en un ticket
        ArrayList<Integer> numPasajerosPorTicket = new ArrayList<>(); //Numero de pasajeros en cada ticket
        
        do{
            System.out.print("\nOpción (A, B o S): ");
            opcion = scanner.next().toUpperCase().charAt(0);

            switch(opcion){
                case 'A':
                    listaTicket = metodos.pedirInformacionYMostrarTicket(listaTicket); 
                    numPasajerosPorTicket.add(listaTicket.size()); // Guardamos la cantidad de pasajeros en el ticket n
                    listaPasajeros.addAll(listaTicket); //Agregamos los pasajeros en el ticket a la lista total de pasajeros
                    listaTicket.clear(); //Limpiamos la lista para que el metodo pueda usarla otra vez en caso de ser necesario             
                    break;
                case 'B':
                    metodos.mostrarListaPasajeros(listaPasajeros, numPasajerosPorTicket); // Se muestra la lista de todos los pasajeros indicando cuales son los compradores
                    System.out.println("Total de pasajeros: " + listaPasajeros.size());
                    System.out.println("Monto total de las ventas: $" + (listaPasajeros.size() * 1250.50));
                    System.out.print("---------------------------------------\n");
                    break;
                case 'S':
                    System.out.print("\n----------Fin del programa------------");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        }while(opcion != 'S');
    }
}
