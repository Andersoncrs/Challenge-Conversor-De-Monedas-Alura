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
        System.out.println("Fecha De Actualizacion de la moneda: " + this.fechaActualizacionMoneda);
        System.out.println("********************************************************************************");
    }
    public void realizarConversionMoneda(double valorMonedaBase){
        this.valorMonedaBase = valorMonedaBase;

        this.valorMonedaObjetivo = this.valorMonedaBase * this.tasaDeCambio;
        mostrarResultadoConversion();
    }

    public void mostrarResultadoConversion(){
        System.out.println("\n********************************************************************************");
        System.out.println("***************************** RESULTADO CONVERSION *****************************");
        System.out.println("********************************************************************************");
        System.out.println("Valor " + this.monedaBase + ": " + this.valorMonedaBase + "$");
        System.out.println("Valor " + this.monedaObjetivo + ": " + this.valorMonedaObjetivo + "$");
        System.out.println("********************************************************************************\n");
    }
}
