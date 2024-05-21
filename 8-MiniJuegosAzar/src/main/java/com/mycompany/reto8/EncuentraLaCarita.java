package com.mycompany.reto8;

public class EncuentraLaCarita extends Partida {
    
    public EncuentraLaCarita(Cliente cliente){
        super(cliente, "Encuentra la carita", false);
    }
    
    public boolean iniciarJuego(){
        System.out.println("Hola! " + super.cliente.getNombre() + " estas listo para jugar? :D");

        System.out.println("""
                           
                           *** Encuentra la carita!! ***
                           Se te mostrara una tabla con 9 
                           espacios, en uno de esos esta la 
                           carita tienes que decir en que 
                           fila y renglon esta.          
                           """);
         
        String[][] tablero = {
            {"x", "x", "x"},
            {"x", "x", "x"},
            {"x", "x", "x"}
        };


        int fila_carita = random.nextInt(3);
        int renglon_carita = random.nextInt(3);
        int fila_respuesta;
        int renglon_respuesta;
        
        while(oportunidad > 0 && !victoria){
            for(int i = 0; i < tablero.length; i++) {
                for(int j = 0; j < tablero[i].length; j++) {
                    System.out.print(tablero[i][j] + "  ");
                }
                System.out.println();
            }    

            System.out.println("\nEn donde esta la carita?");

            do{
                System.out.print("Fila: ");
                fila_respuesta = Metodos.solicitarInt() - 1;
                System.out.print("Renglon: ");
                renglon_respuesta = Metodos.solicitarInt() - 1;
                if ((fila_respuesta >= 3 && fila_respuesta <= 0)||(renglon_respuesta >= 3 && renglon_respuesta <= 0)){
                    System.out.println("El numero de filas de renglones es de 3, introduce numeros entre 1 y 3\n");
                }
            }while((fila_respuesta >= 3 && fila_respuesta <= 0)||(renglon_respuesta >= 3 && renglon_respuesta <= 0));

            if(fila_carita == fila_respuesta && renglon_carita == renglon_respuesta){
                victoria = true;
                tablero[fila_carita][renglon_carita] = ":)";
                for(int i = 0; i < tablero.length; i++) {
                    for(int j = 0; j < tablero[i].length; j++){
                        System.out.print(tablero[i][j] + "  ");
                    }
                    System.out.println();
                }    
                System.out.println("\nFelicidades! " + super.cliente.getNombre() + "Has encontrado la carita");
            }else{
                oportunidad--;
                System.out.println("\nIncorrecto!! Te queda(n) " + oportunidad + " oportunidad(es)\n");   
            }                    
        }
        return victoria;
    }
}

