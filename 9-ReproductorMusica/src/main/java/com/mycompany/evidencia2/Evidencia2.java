package com.mycompany.evidencia2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Evidencia2 {
    
    static ArrayList<Playlist> playlists = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
     
    public static void main(String[] args) {
        inicializarPlaylists();

        
        boolean continuar = true;
        while(continuar){
            System.out.println("""
              1. Agregar playlist
              2. Reproducir musica
              3. Terminar aplicacion
              """);
            int opcion = 0;
            while(opcion > 3 || opcion <= 0){
                System.out.print("Opcion: ");
                opcion = Metodos.solicitarInt();
                if(opcion > 3 || opcion <= 0){
                    System.out.println("\nElige una opcion valida, solo se admiten numeros del 1 al 3\n");
                }
            }
            switch (opcion) {
                case 1:
                    agregarPlaylist();
                    break;
                case 2:
                    reproducirMusica();
                    break;
                case 3:
                    System.out.println("Saliendo del programa....");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            } 
        }
    }
    
    private static void inicializarPlaylists() {
        GeneroMusical pop = new GeneroMusical("Pop");
        GeneroMusical rock = new GeneroMusical("Rock");

        Cancion cancion1 = new Cancion("Love me", 210, pop, "Kat", new String[]{"Keys", "Jon"});
        Cancion cancion2 = new Cancion("On Level22", 250, rock, "Ark", new String[]{"Skill", "Lonon"});

        Cancion[] cancionesIniciales = {cancion1, cancion2}; // o más, según el requisito

        Playlist playlistPopRock = new Playlist("Pop y Rock Mix", LocalDateTime.now(), cancionesIniciales);

        playlists.add(playlistPopRock);
    }

    private static void agregarPlaylist() {
        System.out.println("Nombre de la nueva playlist:");
        String nombre = scanner.nextLine();

        System.out.println("Vamos a agregar la primera canción a tu nueva playlist.");
        System.out.println("Nombre de la canción:");
        String nombreCancion = scanner.nextLine();
        System.out.println("Interprete:");
        String interprete = scanner.nextLine();
        System.out.println("Duración (MM:SS):");
        String duracion = scanner.nextLine();
        int minutos = Integer.parseInt(duracion.split(":")[0]);
        int segundos = Integer.parseInt(duracion.split(":")[1]);
        int duracionSegundos = minutos * 60 + segundos;
        System.out.println("Introduce el género musical:");
        String nombreGenero = scanner.nextLine();
    
        GeneroMusical genero = new GeneroMusical(nombreGenero);

        System.out.println("¿Cuántos autores tiene la canción?");
        int cantidadAutores = scanner.nextInt();
        scanner.nextLine(); // Consumir línea nueva restante
        String[] autores = new String[cantidadAutores];
        for (int i = 0; i < cantidadAutores; i++) {
            System.out.println("Nombre del autor " + (i + 1) + ":");
            autores[i] = scanner.nextLine();
        }

        Cancion primeraCancion = new Cancion(nombreCancion, duracionSegundos, genero, interprete, autores);

        Playlist nuevaPlaylist = new Playlist(nombre, LocalDateTime.now(), new Cancion[]{primeraCancion});

        playlists.add(nuevaPlaylist);

        System.out.println("Playlist '" + nombre + "' agregada correctamente con 1 canción inicial.");
    }

    private static void reproducirMusica() {
        if (playlists.isEmpty()) {
            System.out.println("No hay playlists disponibles.");
            return;
        }
        System.out.println("Lista de playlist disponibles:");
        for (Playlist playlist : playlists) {
            System.out.println(playlist.getClave() + ": " + playlist.getNombre());
        }
        System.out.println("Elige una playlist (clave): ");
        String clave = scanner.nextLine().toUpperCase();

        for (Playlist playlist : playlists) {
            if (playlist.getClave().equals(clave)) {
                System.out.println("Reproduciendo playlist: " + playlist.getNombre());
                ArrayList<Cancion> canciones = playlist.getCanciones();
                if (canciones.isEmpty()) {
                    System.out.println("Esta playlist no tiene canciones.");
                } else {
                    for (Cancion cancion : canciones) {
                        System.out.println("Nombre de la canción: " + cancion.getNombre());
                        System.out.println("Duración: " + cancion.getDuracionFormateada());
                        System.out.println("Género: " + cancion.getGenero().getNombre());
                        System.out.println("Cantante: " + cancion.getCantante());
                        System.out.print("Autores: ");
                        String[] autores = cancion.getAutor();
                        for (int i = 0; i < autores.length; i++) {
                            System.out.print(autores[i]);
                            if (i < autores.length - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println("\n");
                    }
                }
                break;
            }
        }
    }

}
