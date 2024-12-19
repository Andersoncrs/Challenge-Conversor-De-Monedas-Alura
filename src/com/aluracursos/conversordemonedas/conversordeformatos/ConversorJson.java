package com.aluracursos.conversordemonedas.conversordeformatos;

import com.aluracursos.conversordemonedas.dtos.ConversionMonedaExchangerate;
import com.aluracursos.conversordemonedas.modelos.ListaMonedasConsultadas;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConversorJson {
    private  String json;
    private ListaMonedasConsultadas listaMonedasConsultadas;

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    public ConversorJson(ListaMonedasConsultadas listaMonedasConsultadas) {
        this.listaMonedasConsultadas = listaMonedasConsultadas;
    }

    public ConversorJson(String json ){
        this.json = json;
    }

    public ConversionMonedaExchangerate convertirAMonedaExchangerate(){
        return gson.fromJson(this.json, ConversionMonedaExchangerate.class);
    }

    public String ConvertirListaDeMonedasAJson(){
        return gson.toJson(this.listaMonedasConsultadas);
    }

}
