package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.modelos.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.mostrarBienvenida();

        while(true){
            String eleccionResultadoMonedaBase = menu.mostrarmenuBase();

            if(eleccionResultadoMonedaBase.equals("salir")){
                break;
            }
            String eleccionResultadoMonedaObjetivo = menu.mostrarMenuObjetivo(eleccionResultadoMonedaBase);

            String acronimoMonedaBase = menu.ObtenerAcronimo(eleccionResultadoMonedaBase);
            String acronimoMonedaObjetivo = menu.ObtenerAcronimo(eleccionResultadoMonedaObjetivo);


        }

    }
}
