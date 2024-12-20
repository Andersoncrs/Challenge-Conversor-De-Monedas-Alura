package com.aluracursos.conversordemonedas.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una lista de conversiones de monedas realizadas.
 * Esta clase permite agregar nuevas conversiones, mostrar el historial de conversiones
 * y verificar si la lista está vacía.
 */
public class ListaMonedasConsultadas {

    // Lista que almacena objetos de tipo `ConversorMoneda`, cada uno representando una conversión realizada.
    private final List<ConversorMoneda> listaConversionMonedas = new ArrayList<>();

    /**
     * Agrega una nueva conversión de moneda a la lista de conversiones realizadas.
     *
     * @param conversorMoneda El objeto `ConversorMoneda` que contiene los detalles de la conversión.
     */
    public void agregarConversionMoneda(ConversorMoneda conversorMoneda) {
        // Añade la conversión a la lista
        listaConversionMonedas.add(conversorMoneda);
    }

    /**
     * Muestra el historial de todas las conversiones de monedas realizadas.
     * Si la lista está vacía, muestra un mensaje indicándolo.
     */
    public void mostrarMonedasConvertidas() {
        // Si la lista está vacía, no muestra el historial
        if (validarElementosLista()) {
            return;
        }

        // Muestra el encabezado del historial de conversiones
        System.out.println("\n********************************************************************************");
        System.out.println("********************* HISTORIAL DE CONVERSIONES REALIZADAS *********************");
        System.out.println("********************************************************************************");

        // Muestra los detalles de cada conversión de moneda
        for (ConversorMoneda moneda : listaConversionMonedas) {
            moneda.mostrarDetallesMoneda();
            System.out.println("********************************************************************************");
        }

        // Muestra el pie de página del historial
        System.out.println("************************** FIN HISTORIAL CONVERSIONES **************************");
        System.out.println("********************************************************************************\n");
    }

    /**
     * Valida si la lista de conversiones está vacía.
     *
     * @return `true` si la lista está vacía, `false` si contiene elementos.
     */
    public boolean validarElementosLista() {
        // Si la lista está vacía, muestra el mensaje correspondiente
        if (this.listaConversionMonedas.isEmpty()) {
            mostrarMensjeListaVacia();
            return true;
        }
        return false;
    }

    /**
     * Muestra un mensaje indicando que el historial de conversiones está vacío.
     */
    public void mostrarMensjeListaVacia() {
        System.out.println("\n********************************************************************************");
        System.out.println("El historial esta vacio. No ha realizado ninguna conversion en esta sesion");
        System.out.println("********************************************************************************\n");
    }
}
