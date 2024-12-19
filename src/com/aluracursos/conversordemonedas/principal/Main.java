package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.apis.ApiExchangerate;
import com.aluracursos.conversordemonedas.modelos.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
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

            System.out.println(new ApiExchangerate(acronimoMonedaBase, acronimoMonedaObjetivo).obtenerDatosApi());

        }

    }
}
