package com.aluracursos.conversordemonedas.Excepciones;

/**
 * Excepción personalizada que se lanza cuando ocurre un error al intentar guardar un archivo.
 * Esta clase extiende la clase `Exception` para proporcionar un mensaje de error específico.
 */
public class ArchivoNoGuardadoException extends Exception {

    /**
     * Constructor de la excepción `ArchivoNoGuardadoException`.
     *
     * @param message El mensaje de error que describe el problema que ocurrió al intentar guardar el archivo.
     */
    public ArchivoNoGuardadoException(String message) {
        // Llama al constructor de la clase base `Exception` para pasar el mensaje de error.
        super(message);
    }
}
