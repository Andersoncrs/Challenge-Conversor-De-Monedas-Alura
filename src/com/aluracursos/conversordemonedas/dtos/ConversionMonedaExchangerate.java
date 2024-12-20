package com.aluracursos.conversordemonedas.dtos;

/**
 * Registro que representa la información de la conversión de una moneda.
 * Contiene la tasa de conversión y la fecha de la última actualización de la tasa de cambio en formato UTC.
 */
public record ConversionMonedaExchangerate(
        /* La tasa de conversión entre dos monedas. */
        double conversion_rate,

        /* La fecha de la última actualización de la tasa de cambio en formato UTC. */
        String time_last_update_utc) {
}
