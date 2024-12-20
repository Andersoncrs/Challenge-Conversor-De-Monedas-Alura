package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.Excepciones.ArchivoNoGuardadoException;
import com.aluracursos.conversordemonedas.apis.ApiExchangerate;
import com.aluracursos.conversordemonedas.conversordeformatos.ConversorJson;
import com.aluracursos.conversordemonedas.dtos.ConversionMonedaExchangerate;
import com.aluracursos.conversordemonedas.manejoarchivos.ArchivoJson;
import com.aluracursos.conversordemonedas.modelos.ConversorMoneda;
import com.aluracursos.conversordemonedas.modelos.ListaMonedasConsultadas;
import com.aluracursos.conversordemonedas.modelos.Menu;

import java.io.IOException;

/**
 * Clase principal que ejecuta el conversor de monedas.
 * Esta clase se encarga de mostrar el menú, realizar las conversiones de monedas, y guardar el historial.
 */
public class Main {

    /**
     * Metodo principal que inicia el programa de conversión de monedas.
     * Muestra el menú, permite elegir la moneda base y la moneda objetivo, realiza la conversión y guarda el historial si se elige.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Inicializa el menú y muestra la bienvenida
        Menu menu = new Menu();
        menu.mostrarBienvenida();

        // Lista que almacena las monedas consultadas
        ListaMonedasConsultadas listaMonedasConsultadas = new ListaMonedasConsultadas();

        // Bucle principal del programa
        loopPrincipal:
        while(true){
            // Muestra el menú para seleccionar la moneda base
            String eleccionResultadoMonedaBase = menu.mostrarmenuBase();

            // Maneja la elección del usuario
            switch (eleccionResultadoMonedaBase) {
                case "salir":
                    // Sale del bucle si el usuario elige "salir"
                    break loopPrincipal;
                case "historial":
                    // Muestra el historial de monedas convertidas si el usuario elige "historial"
                    listaMonedasConsultadas.mostrarMonedasConvertidas();
                    continue;
                case "guardar":
                    // Valida si la lista está vacía antes de guardar el historial
                    if (listaMonedasConsultadas.validarElementosLista()) {
                        continue;
                    }
                    // Convierte la lista de monedas a formato JSON
                    String jsonConversionesRealizadas = new ConversorJson(listaMonedasConsultadas).
                            ConvertirListaDeMonedasAJson();
                    try {
                        // Intenta guardar el archivo JSON con el historial de conversiones
                        new ArchivoJson(jsonConversionesRealizadas).GuardarArchivo();
                    } catch (ArchivoNoGuardadoException e) {
                        // Maneja la excepción si no se puede guardar el archivo
                        System.out.println(e.getMessage());
                    }
                    break loopPrincipal;
            }

            // Muestra el menú para seleccionar la moneda objetivo
            String eleccionResultadoMonedaObjetivo = menu.mostrarMenuObjetivo(eleccionResultadoMonedaBase);

            // Obtiene los acrónimos de las monedas base y objetivo seleccionadas
            String acronimoMonedaBase = menu.ObtenerAcronimo(eleccionResultadoMonedaBase);
            String acronimoMonedaObjetivo = menu.ObtenerAcronimo(eleccionResultadoMonedaObjetivo);

            try{
                // Obtiene los datos de la API para la tasa de cambio entre las dos monedas
                String resultadoApi = new ApiExchangerate(acronimoMonedaBase, acronimoMonedaObjetivo).obtenerDatosApi();
                // Convierte los datos obtenidos a un objeto de tipo ConversionMonedaExchangerate
                ConversionMonedaExchangerate monedaExchangerate =
                        new ConversorJson(resultadoApi).convertirAMonedaExchangerate();
                // Crea un objeto conversor con la tasa de cambio y las monedas seleccionadas
                ConversorMoneda conversorMoneda = new ConversorMoneda(monedaExchangerate,
                        eleccionResultadoMonedaBase,
                        eleccionResultadoMonedaObjetivo);
                // Muestra la tasa de cambio de las monedas seleccionadas
                conversorMoneda.mostrarTasaDeCambio(acronimoMonedaBase, acronimoMonedaObjetivo);

                // Solicita al usuario que ingrese un valor en la moneda base
                double valorMonedaBase =  menu.ingresoValorMonedaBase(eleccionResultadoMonedaBase);
                // Realiza la conversión de la moneda base al valor ingresado
                conversorMoneda.realizarConversionMoneda(valorMonedaBase);

                // Agrega la conversión realizada a la lista de monedas consultadas
                listaMonedasConsultadas.agregarConversionMoneda(conversorMoneda);

            } catch (IOException | InterruptedException e) {
                // Maneja excepciones en caso de problemas con la API
                System.out.println("Hubo un problema en la comunicación con el servidor" +
                        "Intentelo Mas Tarde.");
            }
        }
        // Muestra un mensaje de despedida al finalizar el programa
        menu.mostrarDespedida();
    }
}
