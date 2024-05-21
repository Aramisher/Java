package com.mycompany.reto6;

import java.util.Scanner;

public class Reto6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("""
                           **Programa Asistente para Area de Recursos Humanos**
                           
                           A continuación se hará el registro de los empleados 
                           de la empresa y se registrara:
                           - Nombre completo
                           - Horas trabajadas 
                           - Horas extra erabajadas 
                           - Teléfono  
                           - Fecha de nacimiento
                           
                           Al finalizar se creará un reporte con:
                           - Cálculo del total de la nómina de la empresa. 
                           - Cálculo del total a pagar por sueldo normal. 
                           - Cálculo del total a pagar por horas extras. 
                           - Cálculo del total de horas laboradas (Hora trabajo + hora extra) en la empresa.   
                           - Total de personas que tienen horas extras. 
                           - Total de personas que no tienen horas extras. 
                           """);    

        int cantidadEmpleados;
        
        System.out.print("\n¿Cuantos empleados deseas registrar? ");
        cantidadEmpleados = Metodos.solicitarInt();
        
        // Creamos dos arreglos del tamaño de la cantidad de empleados para guardar sus datos
        Empleado[] listaEmpleados = new Empleado[cantidadEmpleados];
        Categoria[] listaCategoria = new Categoria[cantidadEmpleados];
        
        // Atributos del empleado
        String nombre;
        int horasTrabajadas;
        int horasExtraTrabajadas;
        String telefono;
        String nombreCategoria;        
        
        // Totales que se calculan para el reporte final
        double totalSueldo = 0;
        double totalSueldoExtra = 0;
        int totalHoras = 0;
        int totalHorasExtra = 0;
        int empleadosConHorasExtra = 0;
        
        // Un for para repetir el proceso de pedir los datos del estudiante la cantidad de veces que haya elegido el usuario
        for (int i = 0; i < cantidadEmpleados; i++){
            
            System.out.print("\nNombre del empleado " + (i + 1) + ": ");
            nombre = scanner.nextLine();

            System.out.print("Horas trabajadas: ");
            horasTrabajadas = Metodos.solicitarInt();

            System.out.print("Horas extras trabajadas: ");
            horasExtraTrabajadas = Metodos.solicitarInt();
            if(horasExtraTrabajadas > 0){
                empleadosConHorasExtra++; //Si el empleado tiene horas extras hacemos el aumento
            }

            System.out.print("Teléfono: ");
            telefono = scanner.nextLine();

            do{ //Se repite hasta que el usuario introduzca un valor valido
                System.out.print("Categoría (ventas, administrador o gerente): ");
                nombreCategoria = scanner.nextLine().toLowerCase();
                if(!nombreCategoria.equals("ventas") && !nombreCategoria.equals("administrador") && !nombreCategoria.equals("gerente")){
                    System.out.println("\nError: entrada inválida. Por favor teclea uno de los valores validos sin tilde\n");
                }              
            }while(!nombreCategoria.equals("ventas") && !nombreCategoria.equals("administrador") && !nombreCategoria.equals("gerente"));

            // Llamamos al metodo getCategoria para obtener una instancia de categoria
            Categoria categoria = Categoria.getCategoria(nombreCategoria);
            // Agregamos las instancias a los arreglos para usar los datos en el reporte
            listaCategoria[i] = categoria; 
            listaEmpleados[i] = new Empleado(nombre, horasTrabajadas, horasExtraTrabajadas, telefono, categoria);  

            // Se hace el aumento de los totales para el reporte final
            totalHoras += horasTrabajadas;   
            totalHorasExtra += horasExtraTrabajadas;
            totalSueldo += listaEmpleados[i].getSueldo();
            totalSueldoExtra += listaEmpleados[i].getSueldoExtra();
        }
        
        // Reporte
        System.out.println("\n----- Reporte de nómina -----");
        System.out.println("Cantidad de empleados: " + cantidadEmpleados);
        
        // Datos de empleado
        for (int i = 0; i < cantidadEmpleados; i++){
            System.out.println("\nEmpleado " + (i + 1) + ": " + listaEmpleados[i].getNombre());
            System.out.println("Categoria: " + listaCategoria[i].getNombreCategoria());
            System.out.println("Sueldo base: $" + listaCategoria[i].getSueldoBase());
            System.out.println("Horas trabajadas: " + listaEmpleados[i].getHorasTrabajadas());
            System.out.println("Horas extras: " + listaEmpleados[i].getHorasExtraTrabajadas());
            System.out.println("Pago neto $" + listaEmpleados[i].getSueldoNeto());
        }
        
        // Datos totales
        System.out.println("\nPago total horas trabajadas: $" + totalSueldo);
        System.out.println("Pago total horas extra trabajadas: $" + totalSueldoExtra);
        System.out.println("Pago total nómina: $" + (totalSueldo + totalSueldoExtra));
        System.out.println("Total de horas laboradas: " + (totalHoras + totalHorasExtra));
        System.out.println("Total de empleados con horas extras: " + empleadosConHorasExtra);
        System.out.println("Total de empleados sin horas extras: " + (cantidadEmpleados - empleadosConHorasExtra));
        System.out.println("Total de horas extras laboradas: " + totalHorasExtra);
    }
}
