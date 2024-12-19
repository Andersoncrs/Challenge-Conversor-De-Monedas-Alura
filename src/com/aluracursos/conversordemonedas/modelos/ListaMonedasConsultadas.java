package com.aluracursos.conversordemonedas.modelos;

import java.util.ArrayList;
import java.util.List;

public class ListaMonedasConsultadas {
    private List<ConversorMoneda> listaConverionMonedas = new ArrayList<>();

    public void agregarConversionMoneda(ConversorMoneda conversorMoneda){
        listaConverionMonedas.add(conversorMoneda);
    }
}

