package com.aluracursos.conversordemonedas.modelos;

import java.util.ArrayList;
import java.util.List;

public class ListaMonedas {
    private final List<String>  listaDeMonedasDisponibles = new ArrayList<>(List.of(
            "COP Peso Colombiano",
            "ARS Peso Argentino",
            "VES Bolivar Venezolano"
    ));

    public List<String> getListaDeMonedasDisponibles() {
        return listaDeMonedasDisponibles;
    }
}
