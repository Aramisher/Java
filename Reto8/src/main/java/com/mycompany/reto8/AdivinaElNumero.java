package com.mycompany.reto8;

public class AdivinaElNumero extends Partida
{
    public AdivinaElNumero(Cliente cliente) {
        super(cliente, "Adivina el Numero", false); // 'false' inicializa 'victoria' indicando que el jugador aún no ha ganado
    }
    
    public boolean iniciarJuego(){

        System.out.println("\nHola! " + super.cliente.getNombre() + " estas listo para jugar? :D");
        System.out.println("""
                           
                                *** Adivina el numero!! ***
                           Se generara un numero del 1 al 10 y
                           tienes que adivinarlo, solo tienes 3
                           oportunidades
                           """);
    
        int respuesta = random.nextInt(10)+ 1;

        int num = 0;   
        
        while(oportunidad > 0 && num != respuesta){
            num = 0;
            while(num > 10 || num <= 0){
                System.out.print("\nElige un numero: ");
                num = Metodos.solicitarInt();
                if(num > 10 || num <= 0){
                    System.out.println("\nSolo puedes elegir un numero del 1 al 10, intentalo de nuevo");
                }
            }    
            if(num != respuesta){
                oportunidad--;
                System.out.println("\nIncorrecto!!\nTe queda(n) " + oportunidad + " oportunidad(es)");
            }
        }    
        
        if(num == respuesta){
            victoria = true;
            System.out.print("\nHas GANADO!! Felicidades " + super.cliente);
        }else{
            System.out.println("Se te acabaron las oportunidades! Has perdido\n");
        }
        return victoria;
    }      
}
