package com.mycompany.reto8;

import java.util.Random;

public class Partida {
    
    protected boolean victoria;
    protected int oportunidad = 3;
    static protected Random random = new Random();   
    
    Cliente cliente; // Referencia al cliente de la partida
    String tipoJuego; // Tipo de juego

    public Partida(Cliente cliente, String tipoJuego, boolean victoria) {
        this.cliente = cliente;
        this.tipoJuego = tipoJuego;
        this.victoria = victoria;
    }
    
    public boolean getVictoria(){
        return victoria;
    }

    public String getTipoJuego() {
        return tipoJuego;
    }

    public Cliente getCliente() {
        return cliente;
    }    
}
