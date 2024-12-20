package com.aluracursos.conversordemonedas.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que maneja la lista de monedas disponibles para realizar conversiones.
 * Esta clase proporciona acceso a las monedas que el sistema puede usar para realizar conversiones entre ellas.
 */
public class ListaMonedasDisponibles {
    private final List<String> listaDeMonedasDisponibles = new ArrayList<>(List.of(
            "COP Peso Colombiano",
            "ARS Peso Argentino",
            "VES Bolivar Venezolano"
    ));

    /**
     * Obtiene la lista de las monedas disponibles para la conversión.
     *
     * @return Lista de cadenas de texto que representan las monedas disponibles.
     */
    public List<String> getListaDeMonedasDisponibles() {
        return listaDeMonedasDisponibles;
    }
}

