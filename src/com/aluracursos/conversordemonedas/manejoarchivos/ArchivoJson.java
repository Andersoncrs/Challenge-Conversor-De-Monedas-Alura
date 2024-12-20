package com.aluracursos.conversordemonedas.manejoarchivos;

import com.aluracursos.conversordemonedas.Excepciones.ArchivoNoGuardadoException;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase encargada de manejar la creación y almacenamiento de archivos JSON.
 * Esta clase permite guardar un archivo con los datos de las conversiones realizadas.
 */
public class ArchivoJson {

    // El contenido JSON que se va a guardar en el archivo.
    private final String json;

    /**
     * Constructor de la clase ArchivoJson.
     *
     * @param json El contenido en formato JSON que se va a guardar en el archivo.
     */
    public ArchivoJson(String json) {
        this.json = json;
    }

    /**
     * Metodo que guarda el contenido JSON en un archivo llamado "ListaConversionMonedas.json".
     * Si ocurre un error durante el proceso de guardado, se lanza una excepción personalizada.
     *
     * @throws ArchivoNoGuardadoException Si ocurre un error al intentar guardar el archivo.
     */
    public void GuardarArchivo() throws ArchivoNoGuardadoException {
        try (FileWriter fileWriter = new FileWriter("ListaConversionMonedas.json")) {
            // Escribe el contenido JSON en el archivo
            fileWriter.write(this.json);

            // Muestra un mensaje indicando que el archivo se guardó con éxito
            System.out.println("\n********************************************************************************");
            System.out.println("¡El Archivo a sido Guardado Con Exito!");
            System.out.println("********************************************************************************");

        } catch (IOException e) {
            // Lanza una excepción personalizada si ocurre un error al guardar el archivo
            throw new ArchivoNoGuardadoException("\nHubo un Error al Intentar guardar el Archivo." +
                    "Intentelo de nuevo mas tarde");
        }
    }
}
