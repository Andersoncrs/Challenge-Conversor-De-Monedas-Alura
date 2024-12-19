package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.apis.ApiExchangerate;
import com.aluracursos.conversordemonedas.modelos.Menu;

import java.io.IOException;

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

            try{
                String resultadoApi = new ApiExchangerate(acronimoMonedaBase, acronimoMonedaObjetivo).obtenerDatosApi();
                System.out.println(resultadoApi);

            } catch (IOException | InterruptedException e) {
                System.out.println("Hubo un problema en la comunicación con el servidor" +
                        "Intentelo Mas Tarde.");
            }

        }

    }
}
