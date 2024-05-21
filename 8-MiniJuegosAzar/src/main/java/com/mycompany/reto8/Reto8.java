package com.mycompany.reto8;

import java.util.Scanner;
import java.util.ArrayList;

public class Reto8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Partida> listaPartidas = new ArrayList<>();
        
        boolean continuar = true;
        while(continuar == true){
            System.out.println("""
                               
                               *** Elige un juego!! ***
                               1) Adivina el numero
                               2) Encuentra la carita
                               3) Gira una carta diamante
                               """);
            int opcion = 0;
            while(opcion > 3 || opcion <= 0){
                System.out.print("Juego: ");
                opcion = Metodos.solicitarInt();
                if(opcion > 3 || opcion <= 0){
                    System.out.println("\nElige una opcion valida, solo se admiten numeros del 1 al 3\n");
                }
            }
            String tipoJuego = " ";
            switch(opcion){
                case 1:
                    tipoJuego = "Adivina el numero";
                    break;
                case 2:
                    tipoJuego = "Encuentra la carita";
                    break;
                case 3:
                    tipoJuego = "Gira una carta diamante";
                    break;
            }

            String nombre;
            String correo;
            String telefono;
            String fechaNacimiento;

            System.out.print("Nombre: ");
            nombre = scanner.nextLine();
            System.out.print("Correo: ");
            correo = scanner.nextLine();
            System.out.print("Telefono: ");
            telefono = scanner.nextLine();
            System.out.print("Fecha de nacimiento: ");
            fechaNacimiento = scanner.nextLine(); 

            Cliente cliente = new Cliente(nombre, correo, telefono, fechaNacimiento);

            boolean victoria = false;
            switch(tipoJuego){
                case "Adivina el numero":
                    AdivinaElNumero juego1 = new AdivinaElNumero(cliente);
                    victoria = juego1.iniciarJuego();
                    break;
                case "Encuentra la carita":
                    EncuentraLaCarita juego2 = new EncuentraLaCarita(cliente);
                    victoria = juego2.iniciarJuego();
                    break;
                case "Gira una carta diamante":
                    GiraUnaCarta juego3 = new GiraUnaCarta(cliente);
                    victoria = juego3.iniciarJuego();                
                    break;
            }

            Partida partida = new Partida(cliente, tipoJuego, victoria);

            listaPartidas.add(partida);
            
            System.out.print("\n¿Quieres jugar otro juego? ");
            continuar = Metodos.solicitarBoolean();
        }
        int i = 1;
        for(Partida infoPartida: listaPartidas){
            System.out.println("\nJuego " + i + ": " + infoPartida.getTipoJuego());
            System.out.println("Informacion del jugador " + i);
            System.out.println("Nombre: " + infoPartida.getCliente().getNombre());
            System.out.println("Correo: " + infoPartida.getCliente().getCorreo());
            System.out.println("Telefono: " + infoPartida.getCliente().getTelefono());
            System.out.println("Fecha de Nacimiento: " + infoPartida.getCliente().getFechaNacimiento());
            System.out.print("Gano? ");
            if(infoPartida.getVictoria()){
                System.out.print("Si!!! :D");
            }else{
                System.out.print("No... :(");                
            }
            i++;
        }                
    }
}
