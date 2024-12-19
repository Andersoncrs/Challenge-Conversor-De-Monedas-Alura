package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.modelos.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.mostrarBienvenida();

        while(true){
            String eleccionResultadoMenuBase = menu.mostrarmenuBase();

            if(eleccionResultadoMenuBase.equals("salir")){
                break;
            }
            String eleccionResultadoMenuObjetivo = menu.mostrarMenuObjetivo(eleccionResultadoMenuBase);
            System.out.println("Eleccion Moneda Objetivo: " + eleccionResultadoMenuObjetivo);

        }

    }
}
