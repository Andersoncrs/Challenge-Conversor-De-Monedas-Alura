package com.aluracursos.conversordemonedas.modelos;

import com.aluracursos.conversordemonedas.dtos.ConversionMonedaExchangerate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase encargada de realizar la conversión entre dos monedas utilizando una tasa de cambio proporcionada.
 * Además, gestiona la visualización de los resultados de la conversión y detalles relacionados con la operación.
 */
public class ConversorMoneda {
    private final String monedaBase;
    private final String monedaObjetivo;
    private final String fechaActualizacionMoneda;
    private final String marcaDeTiempoConsulta;
    private final double tasaDeCambio;
    private double valorMonedaBase;
    private double valorMonedaObjetivo;

    /**
     * Constructor de la clase ConversorMoneda.
     *
     * @param monedaExchangerate Objeto DTO que contiene la tasa de cambio y la fecha de actualización de la moneda.
     * @param monedaBase El acrónimo de la moneda base.
     * @param monedaObjetivo El acrónimo de la moneda objetivo.
     */
    public ConversorMoneda(ConversionMonedaExchangerate monedaExchangerate, String monedaBase, String monedaObjetivo) {
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
        this.fechaActualizacionMoneda = monedaExchangerate.time_last_update_utc();
        this.tasaDeCambio = monedaExchangerate.conversion_rate();
        this.marcaDeTiempoConsulta = capturarFechaConsultaUTC();
    }

    /**
     * Muestra la tasa de cambio entre la moneda base y la moneda objetivo.
     *
     * @param acronimoMonedaBase El acrónimo de la moneda base.
     * @param acronimoMonedaObjetivo El acrónimo de la moneda objetivo.
     */
    public void mostrarTasaDeCambio(String acronimoMonedaBase, String acronimoMonedaObjetivo) {
        System.out.println("\n********************************************************************************");
        System.out.println("Moneda Base ingresada: " + this.monedaBase);
        System.out.println("Moneda Objetivo: " + this.monedaObjetivo);
        System.out.println("La tasa de cambio de " +
                acronimoMonedaBase +
                " a " +
                acronimoMonedaObjetivo +
                " es de: " +
                this.tasaDeCambio + " $");
        System.out.println("Fecha De Actualización de la moneda: " + this.fechaActualizacionMoneda);
        System.out.println("********************************************************************************");
    }

    /**
     * Realiza la conversión del valor de la moneda base a la moneda objetivo.
     *
     * @param valorMonedaBase El valor de la moneda base a convertir.
     */
    public void realizarConversionMoneda(double valorMonedaBase) {
        this.valorMonedaBase = valorMonedaBase;
        this.valorMonedaObjetivo = this.valorMonedaBase * this.tasaDeCambio;
        mostrarResultadoConversion();
    }

    /**
     * Captura la fecha y hora actual en formato UTC.
     *
     * @return La fecha y hora actual en formato UTC como una cadena de texto.
     */
    public String capturarFechaConsultaUTC() {
        Instant ahora = Instant.now();
        ZonedDateTime zdt = ahora.atZone(ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
        return zdt.format(formatter);
    }

    /**
     * Muestra el resultado de la conversión, incluyendo el valor de la moneda base, la moneda objetivo
     * y la marca de tiempo de la consulta.
     */
    public void mostrarResultadoConversion() {
        System.out.println("\n********************************************************************************");
        System.out.println("***************************** RESULTADO CONVERSION *****************************");
        System.out.println("********************************************************************************");
        System.out.println("Valor " + this.monedaBase + ": " + this.valorMonedaBase + " $");
        System.out.printf("Valor  %s: %.2f $ \n", this.monedaObjetivo, this.valorMonedaObjetivo);
        System.out.println("********************************************************************************");
        System.out.println("Marca de Tiempo de la Consulta: " + this.marcaDeTiempoConsulta);
        System.out.println("********************************************************************************\n");
    }

    /**
     * Muestra los detalles completos de la conversión de moneda, incluyendo la moneda base, la moneda objetivo,
     * la tasa de cambio, el valor de la moneda base y el valor convertido.
     */
    public void mostrarDetallesMoneda() {
        System.out.println("Moneda Base: " + this.monedaBase);
        System.out.println("Moneda Objetivo: " + this.monedaObjetivo);
        System.out.println("Tasa de Cambio: " + this.tasaDeCambio);
        System.out.println("Valor Moneda Base: " + this.valorMonedaBase);
        System.out.printf("Valor Moneda Objetivo: " + this.valorMonedaObjetivo);
        System.out.println("Fecha de Actualización Moneda: " + this.fechaActualizacionMoneda);
        System.out.println("Marca de Tiempo de la Consulta: " + this.marcaDeTiempoConsulta);
    }
}
