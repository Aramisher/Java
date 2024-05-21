package com.mycompany.reto2;

import java.util.Scanner;

public class Metodos {

    public static char solicitarPrograma(Scanner scanner){
        char programa;
        do{
            System.out.print("Opción: ");
            programa = scanner.next().charAt(0);
                if (programa != 'a' && programa != 'b'){
                System.out.println("Error: Introduce un valor valido (a o b)");
            } 
        }while(programa != 'a' && programa != 'b');
        return programa;
    }
    
    static boolean error;
    
    //Los siguientes 3 Metodos seran usados en el primer programa
    static int numCal;
    static float[] calificacion;
    static float sumaCal;     
    
    public static int solicitarNumeroCalificaciones(Scanner scanner) {
        do {
            error = false;
            System.out.print("\n¿Cuántas calificaciones deseas introducir? ");
            String numCalString = scanner.next();

            try {
                numCal = Integer.parseInt(numCalString);
            } catch (NumberFormatException e) {
                System.out.println("\nError: No has introducido un número entero \nEjemplo de valores válidos: 10, 30, 2");
                error = true;
            }
        } while (error);
        return numCal;
    }

    public static float[] introducirCalificaciones(Scanner scanner) {
        calificacion = new float[numCal];

        for (int i = 0; i < numCal; i++) {
            do {
                error = false;
                System.out.print("\nCalificación " + (i + 1) + ": ");
                if (scanner.hasNextFloat()) {
                    calificacion[i] = scanner.nextFloat();
                    scanner.nextLine(); // Consumir el resto de la línea
                    if (calificacion[i] > 100 || calificacion[i] < 0) {
                        System.out.println("Error: Tiene que ser un número del 0 al 100 para que sea una calificación válida\n");
                        error = true;
                    }
                } else {
                    System.out.println("\nError: no has introducido un valor válido \nEjemplo de valores válidos: 96.32, 45, 80.00:");
                    error = true;
                    scanner.nextLine(); // Consumir entrada no válida
                }
                //En caso de que no haya error sumar a la variable para posteriormente sacar el promedio
                if(error == false){
                    sumaCal += calificacion[i];
                }
            } while (error);
        }
        return calificacion;
    }

    public static String mostrarPromedio(float[] calificacion) {
        float promedio = sumaCal / numCal;
        String resultado = ("\nEl promedio de todas las calificaciones es: " + promedio);
        System.out.print(resultado);
        return resultado;
    }
    
    static char opcion;
    
    
    
    //Metodos que se usaran para el segundo programa
    
    public static char solicitarOpcion(Scanner scanner){

        do{
            error = false;
            System.out.print("\nOpcion: ");
            opcion = scanner.next().charAt(0);

            if (!(opcion == 'a' || opcion == 'b' || opcion == 'c' || opcion == 'd')){
                System.out.println("Error: Introduce un valor valido (a, b, c o d)");
                error = true;
            }            
        }while(error == true);
        return opcion;
    } 
    
    static int operacion; //Se guarda la cantidad de operaciones realizadas
    static int numCajasCompra; 
    static float costoCajasCompra;
    static float egresoCajasCompra;
    static int acumuladoNumCajasCompra;
    static float acumuladoEgresoCajasCompra;
    
    public static String compraCajas (Scanner scanner){
        
        operacion++;//Se agrega al total de las operaciones realizadas
        
        do{
            error = false;
            System.out.print("\n¿Cuantas cajas deseas comprar? ");
            String numCajasComprarString = scanner.next();
            
            try{
                numCajasCompra = Integer.parseInt(numCajasComprarString);
                if(numCajasCompra < 0){
                    System.out.println("\nError: Introduce un numero entero positivo");
                    error = true;
                }
            } catch (NumberFormatException e){
                System.out.println("\nError: El valor introducido no es valido, tiene que ser un numero entero positivo\n");
                error = true;
            }
        }while(error == true);
        
        acumuladoNumCajasCompra += numCajasCompra; //Se agrega al total de las cajas compradas
        
        do{        
            error = false;
            System.out.print("\nCual es el precio de las cajas? " );
            String costoCajasComprarString = scanner.next();
            try{
                costoCajasCompra = Float.parseFloat(costoCajasComprarString);
                if(costoCajasCompra < 0){
                    System.out.println("\nError: Introduce un numero positivo");
                    error = true;
                }
            } catch (NumberFormatException e){
                System.out.println("\nError: El valor introducido no es valido, tiene que ser un numero entero positivo");
                error = true;
            }    
        }while(error == true);
        
        egresoCajasCompra = numCajasCompra * costoCajasCompra; //Se calcula la compra total
        acumuladoEgresoCajasCompra += egresoCajasCompra; //Se agrega al total de compras
        
        String respuesta = ("\nLa compra realizada por " + numCajasCompra + " cajas al costo $" + costoCajasCompra + " es igual a $" + egresoCajasCompra);
        System.out.println(respuesta);       
        return respuesta;
    }
    
    static int numCajasVenta;
    static float costoCajasVenta;
    static float ingresoCajasVenta;
    static int acumuladoNumCajasVenta;
    static float acumuladoIngresoCajasVenta;
    
    public static String ventaCajas (Scanner scanner){
        
        operacion++;//Se agrega al total de las operaciones realizadas        

        do{
            error = false;
            System.out.print("¿Cuantas cajas deseas vender? ");
            String numCajasVentaString = scanner.next();
            
            try{
                numCajasVenta = Integer.parseInt(numCajasVentaString);
                if(numCajasVenta < 0){
                    System.out.println("\nError: Introduce un numero entero positivo\n");
                    error = true;
                }
            } catch (NumberFormatException e){
                System.out.println("\nError: El valor introducido no es valido, tiene que ser un numero entero positivo\n");
                error = true;
            }
        }while(error == true);
        
        acumuladoNumCajasVenta += numCajasVenta; //Se agrega al total de las cajas vendidas
        
        do{        
            error = false;
            System.out.print("¿Cual es el precio de las cajas? " );
            String costoCajasVentaString = scanner.next();
            try{
                costoCajasVenta = Float.parseFloat(costoCajasVentaString);
                if(costoCajasVenta < 0){
                    System.out.println("\nError: Introduce un numero positivo\n");
                    error = true;
                }
            } catch (NumberFormatException e){
                System.out.println("\nError: El valor introducido no es valido, tiene que ser un numero entero positivo\n");
                error = true;
            }    
        }while(error == true);
        
        ingresoCajasVenta = numCajasVenta * costoCajasVenta;//Se calcula la venta total
        acumuladoIngresoCajasVenta += ingresoCajasVenta;//Se agrega al total de ventas
        
        String respuesta = ("\nLa venta realizada por " + numCajasVenta + " cajas al costo $" + costoCajasVenta + " es igual a $" + ingresoCajasVenta);
        System.out.println(respuesta);       
        return respuesta;
    }
    
    static float montoTotal; //La cantidad de dinero que le queda al usuario
    
    public static void mostrarReporte(){

        operacion++;//Se agrega al total de las operaciones realizadas        

        System.out.println("\n**Reporte de compra y venta**");
        System.out.println("Cantidad total de venta: " + acumuladoNumCajasVenta + " caja(s)");
        System.out.println("Cantidad total de compra: " + acumuladoNumCajasCompra + " caja(s)");
        System.out.println("Cantidad total de ingreso: $" + acumuladoIngresoCajasVenta);
        System.out.println("Cantidad total de egreso: $" + acumuladoEgresoCajasCompra);

        montoTotal = acumuladoIngresoCajasVenta - acumuladoEgresoCajasCompra;
        System.out.println("El monto total en caja es de: $" + montoTotal);
    }   
    
    public static void resumenActividad(){
        
        System.out.println("Cantidad total de operaciones realizadas " + operacion);
        System.out.println("Cantidad total de venta: " + acumuladoNumCajasVenta + " caja(s)");
        System.out.println("Cantidad total de compra: " + acumuladoNumCajasCompra + " caja(s)");
        montoTotal = acumuladoIngresoCajasVenta - acumuladoEgresoCajasCompra;
        System.out.println("El monto total en caja es de: $" + montoTotal);        
        System.out.println("Cantidad total de ingreso: $" + acumuladoIngresoCajasVenta);
        System.out.println("Cantidad total de egreso: $" + acumuladoEgresoCajasCompra);
        System.out.print("Saliendo del programa...");
    }
}
