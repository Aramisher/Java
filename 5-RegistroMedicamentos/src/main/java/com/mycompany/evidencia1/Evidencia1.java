package com.mycompany.evidencia1;

import java.util.Scanner;
import java.util.ArrayList;

public class Evidencia1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Variables que se usaran para que el usuario pueda iniciar sesion
        String usuario;
        String contra;
        boolean sesionIniciada;    
        // Inicio de sesion
        do{
            System.out.print("Introduce tu nombre de usuario: ");
            usuario = scanner.next().toLowerCase();
            System.out.print("Introduce tu contraseña: ");
            contra = scanner.next(); 
            sesionIniciada = Metodos.validarCredenciales(usuario, contra);
        }while(!sesionIniciada); //Se repite hasta que se introduzcan los valores correctos
              
        


        // ArrayList donde guardaremos todos los medicamentos y sus atributos
        ArrayList<Medicamento> catalogoMedicamentos = new ArrayList<>();
        // Declaramos todas las variables que usaremos para guardar los registros de medicamentos
        char continuar;
        String nombreQuimico;
        String nombreGenerico;
        String nombreRegistrado;
        double precioPublico;
        String tipoPresentacion;

            System.out.println("""
                                  
                                   **Programa Registrador de medicamentos**
                               A continuación se le pedira que ingrese los datos de
                               los medicamentos que desea registrar, los datos que se
                               ingresaran seran nombre químico, nombre genérico y 
                               nombre registrado, precio al público, precio de venta 
                               y tipo de presentación o forma farmacéutica. 
                               """);
        
        
        //Se registraran medicamentos hasta que el usuario decida salirse
        do{ 
            
            //Pedimos todos los datos del medicamento
            System.out.println("\nIntroduce los detalles del medicamento");
            
            System.out.print("Nombre químico: ");
            nombreQuimico = scanner.next(); 
            
            System.out.print("Nombre generico: ");
            nombreGenerico = scanner.next();
            
            System.out.print("Nombre registrado: ");
            nombreRegistrado = scanner.next();
            
            System.out.print("Precio publico: ");
            precioPublico = Metodos.solicitarDouble();
            
            do{ //Se repite hasta que el usuario introduzca un valor valido
                System.out.print("Tipo de presentación (solido, semisolido, liquido): ");                  
                tipoPresentacion = scanner.next().toLowerCase();
                if (!tipoPresentacion.equals("solido") && !tipoPresentacion.equals("semisolido") && !tipoPresentacion.equals("liquido")){
                    System.out.println("\nError: entrada inválida. Por favor teclea uno de los valores validos sin tilde\n");
                }           
            }while(!tipoPresentacion.equals("solido") && !tipoPresentacion.equals("semisolido") && !tipoPresentacion.equals("liquido"));
            
            // Declaramos un objeto donde guardaremos todas los detalles del medicamento
            Medicamento medicamento = new Medicamento(nombreQuimico, nombreGenerico, nombreRegistrado, precioPublico, tipoPresentacion);
            
            // Agregamos el medicamento con toda su informacion al ArrayList
            catalogoMedicamentos.add(medicamento);
            
            // Le preguntamos al usuario si desea continuar
            do{
            System.out.print("Deseas continuar? (s/n): ");
            continuar = scanner.next().toLowerCase().charAt(0);           
                if (continuar != 's' && continuar != 'n') {
                    System.out.println("\nError: entrada inválida. Por favor teclea 's' para sí o 'n' para no.");
                }
            }while(continuar != 's' && continuar != 'n');
            
        }while(continuar == 's'); 
               
        
        //Registro Final
        //Llamamos a este metodo para obtener la fecha y hora exacta
        String fechaHora = Metodos.fechaYHora();
        System.out.println("\n--------------------------------------");
        System.out.println(fechaHora);
        System.out.println("Responsable del registro: " + usuario);      
        System.out.println("Cantidad de medicamentos registrados: " + catalogoMedicamentos.size());

        // Mostramos un lista de todos los medicamentos registrados y sus atributos
        for (Medicamento medicamento : catalogoMedicamentos) {
            
            System.out.println("--------------------------------------");
            System.out.println("Nombre Químico: " + medicamento.getNombreQuimico());
            System.out.println("Nombre Genérico: " + medicamento.getNombreGenerico());
            System.out.println("Nombre Registrado: " + medicamento.getNombreRegistrado());
            System.out.println("Precio Público: " + medicamento.getPrecioPublico());
            System.out.println("Tipo de Presentación: " + medicamento.getTipoPresentacion());
            System.out.println("Precio de Venta: " + medicamento.getPrecioVenta());
        }
        
        System.out.println("--------------------------------------");                     
        System.out.print("\nSaliendo del programa...");

    }
}
