package com.example.ejemploahorcado.domain;

import common.CategoriaException;

import java.util.Scanner;

public class Juego {
    //pensar en los atributos que definen el estado del juego en ese instante para que que si lo paran se pueda recuperar
    private Palabra aAdivinar; //o el String directamente
    private Jugador jugador;
    private int intentos;
    private int dificultad; //opcional, aquí o por elemento.

    private char[] palabra;

    public Juego() {
        try {
            this.aAdivinar = new Palabra(1,"Pikachu", "Pokemon");
        } catch (CategoriaException e) {
            System.out.println(e.getMessage());;
        }
        palabra = aAdivinar.getIncognita().toCharArray();
        for (int i = 0; i < palabra.length; i++) {
            palabra[i]=('_');
        }

    }
    public void bucleJuego(){
        boolean salir=false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Dime un letra o Juegatela");
            String userStr = sc.nextLine();
            if(userStr.length()==1){
                char letra = userStr.charAt(0);
                comprobarPalabra(letra);
                munyeco();
            }else if (userStr.length()>1){

            }
        }while(!salir);
    }

    public Juego(Palabra aAdivinar, Jugador jugador, int dificultad) {
        this.aAdivinar = aAdivinar;
        this.jugador = jugador;
        intentos = 4;
        this.dificultad = dificultad;
    }
    public void comprobarPalabra( char letra){

            if(aAdivinar.getIncognita().contains(String.valueOf(letra))){
                actualizarPaPalabraCon(letra);
                pintarPalabraCon(letra);
            }else{
                intentos--;
            }


    }

    private void actualizarPaPalabraCon(char letra) {
        //hacerlo RAM sustituir el _ por la letra
       char [] incognitachar = aAdivinar.getIncognita().toCharArray();
        for (int i = 0; i < palabra.length; i++) {

            if (letra == incognitachar[i]) {
                palabra[i] = letra;}
        }
    }

    public void pintarPalabraCon(char letra) {

        for (int i = 0; i < palabra.length; i++) {
            System.out.print(palabra[i]);
        }

    }
    public void pintarPalabraSin(String palabra){
        char charpalabra [] = palabra.toCharArray();
        for (int i = 0; i < charpalabra.length; i++) {
            System.out.print("_");
        }
    }

    public void munyeco(){
        if (intentos == 0 ){
            System.out.println("________");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|__");
        }else if(intentos == 1 ){
            System.out.println("________");
            System.out.println("|      O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|__");
        }else if(intentos == 2 ){
            System.out.println("________");
            System.out.println("|      O");
            System.out.println("|     /|}");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|__");
        }
        else if(intentos == 3 ){
            System.out.println("________");
            System.out.println("|      O");
            System.out.println("|     /|}");
            System.out.println("|      |");
            System.out.println("|");
            System.out.println("|__");
        }else if(intentos == 4 ){
            System.out.println("________");
            System.out.println("|      O");
            System.out.println("|     /|}");
            System.out.println("|      |");
            System.out.println("|     _|_");
            System.out.println("|__");
        }
    }
}
