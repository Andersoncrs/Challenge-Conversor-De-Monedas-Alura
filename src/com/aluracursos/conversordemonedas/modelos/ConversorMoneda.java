package com.aluracursos.conversordemonedas.modelos;

import com.aluracursos.conversordemonedas.dtos.ConversionMonedaExchangerate;

public class ConversorMoneda {
    private String monedaBase;
    private String monedaObjetivo;
    private String fechaActualizacionMoneda;
    private String fechaConversion;
    private double tasaDeCambio;
    private double valorMonedaBase;
    private double valorMonedaObjetivo;

    public ConversorMoneda(ConversionMonedaExchangerate monedaExchangerate,String monedaBase, String monedaObjetivo){
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
        this.fechaActualizacionMoneda = monedaExchangerate.time_last_update_utc();
        this.tasaDeCambio = monedaExchangerate.conversion_rate();
    }

    public void mostrarTasaDeCambio(String acronimoMonedaBase, String acronimoMonedaObjetivo){
        System.out.println("\n********************************************************************************");
        System.out.println("Moneda Base ingresada: " + this.monedaBase );
        System.out.println("Moneda Objetivo: " + this.monedaObjetivo);
        System.out.println("La tasa de cambio de " +
                acronimoMonedaBase +
                " a " +
                acronimoMonedaObjetivo +
                " es de: " +
                this.tasaDeCambio + " $");
        System.out.println("********************************************************************************");
    }
}
