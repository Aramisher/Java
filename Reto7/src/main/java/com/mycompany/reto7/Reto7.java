package com.mycompany.reto7;

import java.util.ArrayList;

public class Reto7 {
    //Creamos una instancia final de cafetera para poder modificar sus atributos durante el programa
    final private static Cafetera cafetera = new Cafetera();
    
    public static void main(String[] args) {
        
        boolean ejecutar = true;
        while(ejecutar){ //Se ejecutara el programa hasta que el usuario quiera salirse
            System.out.println("""
                               CODIGO ADMIN: 420                               
                                              ***Cafetera*** 
                               Se indicaran la cantidad de vasos deseados,
                               el tamaño del vaso y si lo desea con azucar.

                                                ***Menu***
                               Vaso de café pequeño sin azúcar (120 ml): $10.50 
                               Vaso de café pequeño con azúcar (120 ml): $14.50 
                               Vaso de café mediano con azúcar (220 ml): $24.50 
                               Vaso de café mediano sin azúcar (220 ml): $34.50 
                               Vaso de café grande con azúcar (320 ml): $34.50 
                               Vaso de café grande sin azúcar (320 ml): $39.50 
                               """);
            
            
            // Variables que se usaran dentro del for
            boolean azucar; //Variable que determina si el usuario tendra azucar en su cafe
            String tamaño = " "; //Guardamos el tamaño en String dependiendo del valor de tamañoInt
            int mililitros; //Cantidad de mililitros en el tamaño dependiendo de su vaso
            double pago; // Cantidad de dinero que el usuario introduce
            double precio; // Cuanto cuesta cada cafe
            double aPagar = 0; // Cuanto tiene que pagar el usuario

            //Creamos el ArrayList donde guardaremos todos los pedidos para imprimir el ticket
            ArrayList<TipoCafe> listaCafe = new ArrayList<>(); 

            //El usuario decide cuantas tazas quiere en un solo pedido
            System.out.print("\n¿Cuantas tazas deseas comprar?(0 para salir): ");
            int cantidadTazas = Metodos.solicitarInt();      
            
            //Si introduce 0 es porque se quiere salir del progra,a
            if (cantidadTazas == 0){
                System.out.print("\nSaliendo del programa... ");
                System.exit(0); //Termina la ejecución del programa
            }
            // Si se introduce el codigo del administrador se ejecutara el menu del administrador, al salir regresara al programa
            if (cantidadTazas == 420){
                menuAdmin();
                System.out.print("¿Cuantas tazas deseas comprar? ");
                cantidadTazas = Metodos.solicitarInt();                    
            }

            for(int i = 0; i < cantidadTazas; i++){
                System.out.println("\n\nTaza " + (i+1) + ": ");
                System.out.print("""

                                ***Tamaños***
                                (1) Pequeño
                                (2) Mediano
                                (3) Grande
                                """);

                // Entrada: tamaño
                int tamañoInt;
                do{
                    System.out.print("Tamaño: ");
                    tamañoInt = Metodos.solicitarInt();  //Creamos una variable tamañoInt para pedir los datos y el usuario los pueda poner rapidamente con numeros

                    // Le damos el valor indicado a la variable tamaño
                    switch(tamañoInt){
                        case 1:
                            tamaño = "pequeño";
                            break;
                        case 2:
                            tamaño = "mediano";
                            break;
                        case 3:
                            tamaño = "grande";
                            break;
                        default:
                            System.out.println("Selección no válida. Por favor, elija 1 para pequeño, 2 para mediano, o 3 para grande.");
                            break;
                    }
                }while(tamañoInt != 1 && tamañoInt != 2 && tamañoInt != 3);     



                // Entrada: azucar
                System.out.print("""

                                 ***Azucar***
                                 (0) Sin azucar
                                 (1) Con azucar
                                 """);


                System.out.print("Azucar: ");
                azucar = Metodos.solicitarBoolean();

                precio = Cafetera.obtenerPrecio(tamaño, azucar); //Obtenemos el precio del cafe con las caracteristicas dads por el usuario

                TipoCafe cafe = new TipoCafe(tamaño, azucar, precio); //Creamos el cafe segun su tamaño, contenido de azucar y precio;

                mililitros = cafe.calcularMlAgua();   // Calculamos la cantidad de mililitros de agua para poder servir la cantidad correcta al cafe     
                // Checamos si hay insumos suficientes para servir el cafe
                boolean insumosSuficientes = cafetera.servirCafe(mililitros, azucar);
                if (insumosSuficientes){
                    aPagar += precio; //Guardamos el total que se tiene que pagar  
                    listaCafe.add(cafe);
                }else{
                    System.out.print("\nNo hay suficientes insumos para servir el cafe\n¿Prefieres intentar nuevamente o pagar en caso de que ya hayas pedido otro cafe? \nSalir e ir a caja(0) o intentar nuevamente (1): ");
                    boolean continuar = Metodos.solicitarBoolean();
                    if (continuar){
                        i--; //El for continua desde el mismo punto
                    }else{
                        break; //Salimos del for
                    }
                }
            }

            //Le indicamos al usuario cuanto tendra que pagar
            System.out.printf("\nLa cantidad total a pagar es de: %.2f", aPagar);
            do{ //Haremos el ciclo hasta que el usuario introduzca una cantidad igual o mayor a la cantidad a pagar
            System.out.print("\n¿Cuanto dinero deseas ingresar?: ");
            pago = Metodos.solicitarDouble();
            if (pago <= aPagar){ //Si el pago es menos imprimeremos un mensaje y le preguntaremos nuevamente al usuario
                System.out.println("El pago no es suficiente, intentalo nuevamente");
            }
            }while(pago < aPagar);

            Metodos.sistemaCambio(pago, aPagar); //Le regresamos el cambio al cliente en monedas con el metodo del sistema de cambio

            // Reporte final
            System.out.println("\n***Desglose de compra***");            
            System.out.println("\nImporte total de la venta: " + aPagar); //Imprimimos el total
            System.out.println("Total de tazas : " + cantidadTazas); //Imprimimos la cantidad de tazas que se pidieron
            // Detalle de todas las tazas vendidas
            int i = 1;
            for(TipoCafe cafe: listaCafe){ //for-each para poder imprimir la informacion de cada una de las tazas que pidio el usuario
                System.out.println("\nTaza " + i); 
                System.out.println("Tamaño: " + cafe.getTamaño());
                System.out.print("Azucar: ");
                if(cafe.getAzucar()){ // Si azucar es true imprimimos si para que sea mas legible para el usaurio
                    System.out.println("si");
                }else // Si azucar es false imprimimos que no por al misma razon
                    System.out.println("no");
                System.out.println("Precio: " + cafe.getPrecio());
                i++;
            }
            System.out.print("\n¿Deseas continuar? no(0) si(1): "); //El usuario despues de su pedido decide si quiere seguir y hacer otro pedido
            ejecutar = Metodos.solicitarBoolean();        
        }
        System.out.println("\nSaliendo del programa...");
    }
    
    /*Metodo donde tendremos el menu del administrador que nos permitira añadir ingredientes y ver 
    informacion importante como cuanto queda de cada ingrediente y su capacidad maxima*/
    public static void menuAdmin(){  
        boolean continuar = true;
        while(continuar){ //Hacemos el ciclo hasta que el admin se quiera salir y regresemos al programa
            System.out.print("""
                             
                             ***Menu Administrador***

                             (1) Agregar cafe 
                             (2) Agregar agua
                             (3) Agregar azucar
                             (4) Mostrar inventario y capacidad maxima
                             """);
            int opcion;
            do{ //Pedimos una opcion hasta que nos de una valida
                System.out.print("Opción: ");
                opcion = Metodos.solicitarInt();
            }while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4);

            switch(opcion){ 
                case 1://Agregamos cafe
                    System.out.println("**Agregar cafe**");
                    System.out.print("Gramos: ");
                    double cantidadCafe = Metodos.solicitarInt();
                    cafetera.añadirCafe(cantidadCafe); //Añadimos la cantidad deseada a la instancia cafetera
                    break;
                case 2:
                    System.out.println("**Agregar agua**");                    
                    System.out.print("Ml de agua: ");
                    double cantidadAgua = Metodos.solicitarInt();
                    cafetera.añadirAgua(cantidadAgua); //Añadimos la cantidad deseada a la instancia cafetera
                    break;
                case 3:
                    System.out.println("**Agregar agua**");                    
                    System.out.print("Gramos de cafe: ");
                    double cantidadAzucar = Metodos.solicitarInt();
                    cafetera.añadirAzucar(cantidadAzucar); //Añadimos la cantidad deseada a la instancia cafetera
                    break;
                case 4: //Imprimimos cuanto queda y cual es la capacidad maxima de cada uno de los ingredientes
                    System.out.println("\n         ***Inventario*** ");
                    System.out.println("      Cafe: " + cafetera.getActualCafe() + " gramos");
                    System.out.println("   Capacidad maxima: " + cafetera.getCapacidadMaxCafe() + " gramos");
                    System.out.println("      Agua: " + cafetera.getActualAgua() + " mililitros");
                    System.out.println("   Capacidad maxima: " + cafetera.getCapacidadMaxAgua() + " mililitros");
                    System.out.println("      Azucar: " + cafetera.getActualAzucar() + " gramos");                    
                    System.out.println("   Capacidad maxima: " + cafetera.getCapacidadMaxAzucar() + " gramos");
                    break;
            }
            System.out.print("\nDeseas continuar con las acciones de administrador? si(1) no(0): "); // El admin decide si quiere realizar otra accion o regresa al menu de usuario
            continuar = Metodos.solicitarBoolean();
        }
        System.out.println("\nSaliendo del modo administrador...");
        System.out.println("Entrando a modo usuario...\n");
    }
}