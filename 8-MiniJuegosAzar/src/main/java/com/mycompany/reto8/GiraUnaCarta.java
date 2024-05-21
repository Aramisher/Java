package com.mycompany.reto8;

public class GiraUnaCarta extends Partida{
    
    public GiraUnaCarta(Cliente cliente){
        super(cliente, "Gira una carta diamante", false);
    }
    
    public boolean iniciarJuego(){
        System.out.println("Hola! " + super.cliente.getNombre() + " estas listo para jugar? :D");
        System.out.println("""
                           
                           *** Adivina donde esta el diamante!!
                           Se te mostraran 5 cartas y tienes que 
                           adivinar donde esta la carta diamante!
                           
                           """);
        
        char[] cartas = {'x', 'x', 'x', 'x', 'x'};
        int respuesta = 0;
        int diamante = 1;
        
        while(oportunidad > 0 && respuesta != diamante){
            diamante = random.nextInt(5)+ 1;        
            System.out.println("Barajando las cartas... \n");
            for(int i = 0; i < cartas.length; i++){
                System.out.print(cartas[i] + " ");
            }
            System.out.println(" ");
            do{
                System.out.print("\nDonde esta la carta de diamante? ");
                respuesta = Metodos.solicitarInt();
                if(respuesta > cartas.length || respuesta <= 0){
                    System.out.println("Solo hay " + cartas.length + " cartas, elige una dentro del rango.");
                }
            }while(respuesta > cartas.length || respuesta <= 0);
                    
            if(respuesta == diamante){
                super.victoria = true;
                cartas[diamante - 1] = '\u2666';
                for(int i = 0; i < cartas.length; i++){
                    System.out.print(cartas[i] + " ");  
                }    
                System.out.println("\nFelicidades " + super.cliente.getNombre() +"!! has encontrado la carta de diamante!");
            }else{
                oportunidad--;
                System.out.println("\nLo siento, ahi no esta la carta de diamante, te queda(n):" + oportunidad + " oportunidad(es).\n");    
            } 
        }
        
        if(respuesta != diamante){
            System.out.println("Se te acabaron las oportunidades! Has perdido.");
        }
        return victoria;
    }
}
