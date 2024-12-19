package com.aluracursos.conversordemonedas.manejoarchivos;

import com.aluracursos.conversordemonedas.Excepciones.ArchivoNoGuardadoException;

import java.io.FileWriter;
import java.io.IOException;

public class ArchivoJson {
    private final String json;

    public ArchivoJson(String json) {
        this.json = json;
    }

    public void GuardarArchivo() throws ArchivoNoGuardadoException {
        try(FileWriter fileWriter = new FileWriter("ListaConversionMonedas.json")){
            fileWriter.write(this.json);
            System.out.println("\n********************************************************************************");
            System.out.println("¡El Archivo a sido Guardado Con Exito!");
            System.out.println("********************************************************************************");

        }catch (IOException e){
            throw new ArchivoNoGuardadoException("\nHubo un Error al Intentar guardar el Archivo." +
                    "Intentelo de nuevo mas tarde");
        }
    }
}
