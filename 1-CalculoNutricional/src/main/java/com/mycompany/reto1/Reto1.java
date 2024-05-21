package com.mycompany.reto1;

import java.io.*;

public class Reto1 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        System.out.println("""
                           **CLINICA DE NUTRICIÓN**
                           
                           Elige una servicio: 
                           A. Cálculo de masa corporal (índice de masa corporal)
                           B. Cálculo de masa corporal magra
                           C. Cálculo de metabolismo basal (gasto energético basal)""");
        
        char opcion = Metodos.solicitarOpcion(reader); // El usuario escoge y se guarda en opcion
        // En un principio solo se piden peso y estatura porque las 3 opciones necesitan ambos datos
        float peso = Metodos.solicitarPeso(reader); // El usuario introduce su peso
        int estatura = Metodos.solicitarEstatura(reader); // E introduce su estatura 

        //Se declaran las variables de genero y edad para ser usadas por las opciones B y C en caso de ser necesario
        char genero;
        int edad;
        
        switch(opcion){
            case 'A':
                Metodos.indiceMasaCorporal(peso, estatura);
                break;
            case 'B':
                genero = Metodos.solicitarGenero(reader);
                Metodos.masaCorporalMagra(peso, estatura, genero);
                break;     
            case 'C':
                genero = Metodos.solicitarGenero(reader);
                edad = Metodos.solicitarEdad(reader);
                Metodos.metabolismoBasal(peso, estatura, genero, edad);
                break;
        }        
    }
}
    

