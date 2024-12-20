package com.aluracursos.conversordemonedas.conversordeformatos;

import com.aluracursos.conversordemonedas.dtos.ConversionMonedaExchangerate;
import com.aluracursos.conversordemonedas.modelos.ListaMonedasConsultadas;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Clase encargada de la conversión entre objetos y su representación en formato JSON.
 * Utiliza la biblioteca Gson para realizar la serialización y deserialización de objetos.
 */
public class ConversorJson {

    /** La cadena JSON a convertir en un objeto. */
    private String json;

    /** La lista de monedas consultadas a convertir a formato JSON. */
    private ListaMonedasConsultadas listaMonedasConsultadas;

    /** Instancia de Gson para convertir entre objetos y JSON. */
    Gson gson = new GsonBuilder()
            .setPrettyPrinting() // Para una salida legible
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) // Convierte los nombres de los campos a minúsculas y usa guiones bajos
            .create();

    /**
     * Constructor que recibe una lista de monedas consultadas para convertirla a JSON.
     *
     * @param listaMonedasConsultadas La lista de monedas consultadas que será convertida.
     */
    public ConversorJson(ListaMonedasConsultadas listaMonedasConsultadas) {
        this.listaMonedasConsultadas = listaMonedasConsultadas;
    }

    /**
     * Constructor que recibe una cadena JSON para convertirla en un objeto.
     *
     * @param json La cadena JSON que se convertirá en un objeto.
     */
    public ConversorJson(String json) {
        this.json = json;
    }

    /**
     * Convierte la cadena JSON a un objeto de tipo {@link ConversionMonedaExchangerate}.
     *
     * @return El objeto {@link ConversionMonedaExchangerate} resultante de la conversión.
     */
    public ConversionMonedaExchangerate convertirAMonedaExchangerate() {
        return gson.fromJson(this.json, ConversionMonedaExchangerate.class);
    }

    /**
     * Convierte la lista de monedas consultadas a una cadena JSON.
     *
     * @return La cadena JSON que representa la lista de monedas consultadas.
     */
    public String ConvertirListaDeMonedasAJson() {
        return gson.toJson(this.listaMonedasConsultadas);
    }
}
