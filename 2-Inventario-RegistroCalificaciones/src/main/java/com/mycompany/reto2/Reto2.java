package com.mycompany.reto2;

import java.util.Scanner;

public class Reto2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("""
                         Elige un programa:
                         a) Registro de calificaciones
                         b) Inventario de cajas 
                         """);
        char programa = Metodos.solicitarPrograma(scanner);
        
        if(programa == 'a'){
            System.out.print("""
                             
                            **Programa Asistente para Registro de Calificaciones**
                             """);
            Metodos.solicitarNumeroCalificaciones(scanner);
            Metodos.introducirCalificaciones(scanner);
            Metodos.mostrarPromedio(Metodos.calificacion);
        }else{
            System.out.print("""
                             
                             **Programa Asistente para Registro de compra y venta de cajas**
                             a) Comprar cajas de papel
                             b) Vender cajas de papel
                             c) Mostrar reporte
                             d) Salir del programa
                             """);
            char opcion;
            do{
                opcion = Metodos.solicitarOpcion(scanner);
                switch(opcion){
                    case 'a':
                        Metodos.compraCajas(scanner);
                        break;
                    case 'b':
                        Metodos.ventaCajas(scanner);
                        break;
                    case 'c':
                        Metodos.mostrarReporte();
                        break;
                    case 'd':
                        Metodos.resumenActividad();
                        break;  
                }
            }while(opcion != 'd');
        }
        scanner.close();
    }
    
    
    
}
