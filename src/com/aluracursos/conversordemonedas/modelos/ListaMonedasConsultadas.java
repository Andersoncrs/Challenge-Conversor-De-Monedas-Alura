package com.aluracursos.conversordemonedas.modelos;

import java.util.ArrayList;
import java.util.List;

public class ListaMonedasConsultadas {
    private List<ConversorMoneda> listaConversionMonedas = new ArrayList<>();

    public void agregarConversionMoneda(ConversorMoneda conversorMoneda){
        listaConversionMonedas.add(conversorMoneda);
    }

    public void mostrarMonedasConvertidas(){
        if(this.listaConversionMonedas.isEmpty()){
            System.out.println("\n********************************************************************************");
            System.out.println("El historial esta vacio. No ha realizado ninguna conversion en esta sesion");
            System.out.println("********************************************************************************\n");
            return;
        }
        System.out.println("\n********************************************************************************");
        System.out.println("********************* HISTORIAL DE CONVERSIONES REALIZADAS *********************");
        System.out.println("********************************************************************************");
        for (ConversorMoneda moneda : listaConversionMonedas) {
            moneda.mostrarDetallesMoneda();
            System.out.println("********************************************************************************");
        }
        System.out.println("************************** FIN HISTORIAL CONVERSIONES **************************");
        System.out.println("********************************************************************************\n");
    }
}

