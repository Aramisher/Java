package aramis.metodos;

import java.time.LocalDateTime; // Usada por el metodo fechaHora
import java.time.format.DateTimeFormatter;// Usada por el metodo fechaHora
import java.util.Scanner;
import java.util.Random; //Usada por el metodo generarArregloBidimensional

public class Metodos {

    static Scanner scanner = new Scanner(System.in);

    public static int solicitarInt(){
        while (true) {
            System.out.print("Numero int: ");
            String intValue = scanner.next();
            try {
                return Integer.parseInt(intValue);
            }catch (NumberFormatException e){
                System.out.println("\nError: No has introducido un valor INT\nEjemplo de valores validos: 34, 858, 99999 \n");
                // No es necesario hacer nada aquí, el bucle continuará automáticamente
            }
        }
    }
    
    public static float solicitarFloat(){
        while(true){
            System.out.print("Numero float: ");
            String floatValue = scanner.next();
            try{
                return Float.parseFloat(floatValue);
            }catch(NumberFormatException e){
                System.out.println("Error: No has introducido un valor FLOAT");
            }
        }
    }
    
    public static double solicitarDouble(){
        while(true){
            System.out.print("Numero double: ");
            String doubleValue = scanner.next();
            try{
                return Double.parseDouble(doubleValue);
            }catch(NumberFormatException e){
                System.out.println("Error: No has introducido un valor DOUBLE");
            }
        }
    }
    
    public static char solicitarChar(){
        while(true){
            System.out.print("Valor char:");
            char charValue = scanner.next().charAt(0);
            return charValue;
        }
    }
    
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
    
    // Este metodo nos sirve para imprimir los valores dentro de un array unidimensional INT
    public static void imprimirArray(int array[]){ 
        for(int i = 0; i < array.length; i++){
            System.out.print("Valor " + (i + 1) + ": " + array[i]);   
        }
    }
    
    // Método que cumple con la funcionalidad de mostrar una lista de elementos y luego buscar y mostrar la información correspondiente a un elemento seleccionado por el usuario
    public static void buscarYMostrarInformacion(String elemento[], String detalle[]){            
        boolean encontrado; // Si el usuario introduce un valor que este dentro de elementos la variable cambia a true
        String elementoBuscado; //Variable de entrada usada para buscar su informacion en detalle[] 
            
        do{
            encontrado = false;
            System.out.print("Ingresa el elemento a buscar: ");
            elementoBuscado = scanner.nextLine();
                
            for(int i = 0; i < elemento.length; i++){
                if(elemento[i].equalsIgnoreCase(elementoBuscado)){
                    System.out.println("Detalle: " + detalle[i]);
                    encontrado = true;
                    break;
                }
            }   
            if (!encontrado){
                System.out.println("El elemento " + elementoBuscado + " no existe. Intenta nuevamente. ");
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
            System.out.println((i + 1) + ". " + elemento[i] + " tiene " + longitudElemento + " caracteres, significado tiene " + longitudDetalle + " caracteres");                        
        } 
    }
    
    // Metodo que crea un arreglo bidimensional con dimensiones dadas por el usuario y lo llena en automatico con numeros aleatorios
    public static int[][] generarArregloBidimensionalRandom(int filas, int columnas){
        Random random = new Random();
        int[][] arreglo = new int[filas][columnas];
        for(int i=0;i < filas; i++){
            for(int j=0;j < columnas; j++){
                arreglo[i][j] = random.nextInt();
            }
        }     
        return arreglo;
    }
    
    public static void mostrarArregloBidimensional(int[][] arreglo){
        for(int i=0;i < arreglo.length;i++){
            for(int j=0;j < arreglo[i].length;j++){
                System.out.print(arreglo[i][j] + "  ");
            }
            System.out.println();
        }
    }
    
    public static void contarParesImparesArregloBidimensional(int[][] arreglo){
        int pares;
        int impares;
        System.out.println("-------------------------------------------------");
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
     
    //Metodo para verificar usuario y contraseña
    public static boolean verificarCredenciales(String usuario, String contra){
        String usuarioCorrecto = "pancho";
        String contraCorrecta = "pedro";
        boolean acceso;
        
        if(usuarioCorrecto.equals(usuario) && contraCorrecta.equals(contra)){
            acceso = true;
            System.out.println("\n¡Inicio de sesión exitoso!");
        }else{
            acceso = false;
            System.out.println("\nUsuario o contraseña incorrectos. Intenta de nuevo");
        }   
        return acceso;
    }
    
    
    //Metodo para retornar la fecha y hora actual
    public static String fechaYHora(){
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");    
        
        return ahora.format(formato); 
    }
}
