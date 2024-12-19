package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.apis.ApiExchangerate;
import com.aluracursos.conversordemonedas.conversordeformatos.ConversorJson;
import com.aluracursos.conversordemonedas.dtos.ConversionMonedaExchangerate;
import com.aluracursos.conversordemonedas.modelos.ConversorMoneda;
import com.aluracursos.conversordemonedas.modelos.ListaMonedasConsultadas;
import com.aluracursos.conversordemonedas.modelos.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.mostrarBienvenida();
        ListaMonedasConsultadas listaMonedasConsultadas = new ListaMonedasConsultadas();

        loopPrincipal:
        while(true){
            String eleccionResultadoMonedaBase = menu.mostrarmenuBase();

            switch (eleccionResultadoMonedaBase) {
                case "salir":
                    break loopPrincipal;
                case "historial":
                    listaMonedasConsultadas.mostrarMonedasConvertidas();
                    continue;
                case "guardar":
                    if (listaMonedasConsultadas.validarElementosLista()) {
                        continue;
                    }
                    String jsonConversionesRealizadas = new ConversorJson(listaMonedasConsultadas).
                            ConvertirListaDeMonedasAJson();
                    System.out.println(jsonConversionesRealizadas);
                    continue;
            }
            String eleccionResultadoMonedaObjetivo = menu.mostrarMenuObjetivo(eleccionResultadoMonedaBase);

            String acronimoMonedaBase = menu.ObtenerAcronimo(eleccionResultadoMonedaBase);
            String acronimoMonedaObjetivo = menu.ObtenerAcronimo(eleccionResultadoMonedaObjetivo);

            try{
                String resultadoApi = new ApiExchangerate(acronimoMonedaBase, acronimoMonedaObjetivo).obtenerDatosApi();
                ConversionMonedaExchangerate monedaExchangerate =
                        new ConversorJson(resultadoApi).convertirAMonedaExchangerate();
                ConversorMoneda conversorMoneda = new ConversorMoneda(monedaExchangerate,
                        eleccionResultadoMonedaBase,
                        eleccionResultadoMonedaObjetivo);
                conversorMoneda.mostrarTasaDeCambio(acronimoMonedaBase, acronimoMonedaObjetivo);
                double valorMonedaBase =  menu.ingresoValorMonedaBase(eleccionResultadoMonedaBase);
                conversorMoneda.realizarConversionMoneda(valorMonedaBase);
                listaMonedasConsultadas.agregarConversionMoneda(conversorMoneda);

            } catch (IOException | InterruptedException e) {
                System.out.println("Hubo un problema en la comunicación con el servidor" +
                        "Intentelo Mas Tarde.");
            }
        }

    }
}
