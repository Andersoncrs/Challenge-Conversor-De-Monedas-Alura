package com.aluracursos.conversordemonedas.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa el menú interactivo para el conversor de monedas.
 * Permite al usuario seleccionar opciones, ingresar valores y visualizar los resultados.
 */
public class Menu {

    // Instancia de Scanner para leer la entrada del usuario.
    Scanner scanner = new Scanner(System.in);

    // Instancia de ListaMonedasDisponibles que contiene las monedas disponibles para convertir.
    ListaMonedasDisponibles listaMonedasDisponibles = new ListaMonedasDisponibles();

    /**
     * Muestra un mensaje de bienvenida al usuario.
     */
    public void mostrarBienvenida(){
        System.out.println("""
                
                ********************************************************************************
                ***********    Bienvenido al Conversor de Monedas WorldChangeRate    ***********
                ********************************************************************************
                Aquí podrás hallar la tasa de conversion de multiples monedas a nivel mundial""");
    }

    /**
     * Muestra las opciones del menú en una lista numerada.
     *
     * @param listaMenu Lista de opciones para mostrar en el menú.
     */
    public void mostrarMenu(List<String> listaMenu){
        for (int i = 0; i < listaMenu.size(); i++) {
            System.out.println( i + 1 + " - " + listaMenu.get(i));
        }
    }

    /**
     * Muestra el menú principal para que el usuario seleccione una moneda a convertir.
     * También ofrece opciones para consultar historial, guardar historial o salir.
     *
     * @return La opción seleccionada por el usuario (moneda a convertir, historial, guardar o salir).
     */
    public String mostrarmenuBase() {
        while (true) {
            System.out.println("\n********************************************************************************");
            System.out.println("MENU PRINCIPAL");
            System.out.println("********************************************************************************");
            System.out.println("Ingrese La moneda que desea Convertir: ");

            // Obtiene la lista de monedas disponibles
            List<String> listaDeMonedasDisponibles = listaMonedasDisponibles.getListaDeMonedasDisponibles();
            mostrarMenu(listaDeMonedasDisponibles);

            // Opciones adicionales para historial y guardar
            System.out.println("\n- Para Consultar el Historial, ingrese la palabra \"historial\"");
            System.out.println("- Para Guadar el Historial de Conversiones y salir ingrese \"guardar\"");
            System.out.println("- Para Salir ingrese la palabra \"salir\"");

            // Lee la opción del usuario
            String eleccionUsuario = scanner.nextLine().toLowerCase().trim();

            // Valida la opción ingresada por el usuario
            String resultadoValidacion = validacionIngresoUsuario(eleccionUsuario, listaDeMonedasDisponibles);
            switch (resultadoValidacion) {
                case "salir":
                    return "salir";
                case "historial":
                    return "historial";
                case "guardar":
                    return "guardar";
                case "valido":
                    return listaDeMonedasDisponibles.get(Integer.parseInt(eleccionUsuario) - 1);
                case "invalido":
                    mostrarMensajeValorInvalido();
            }
        }
    }

    /**
     * Muestra el menú para que el usuario seleccione la moneda a la cual desea convertir.
     *
     * @param monedaBase La moneda base seleccionada previamente.
     * @return La moneda objetivo seleccionada por el usuario.
     */
    public String mostrarMenuObjetivo(String monedaBase){
        while(true){
            System.out.println("********************************************************************************");
            System.out.println("Moneda Base ingresada: " + monedaBase );
            System.out.println("********************************************************************************");

            // Crea una lista de monedas sin incluir la moneda base
            List<String> listaMenuObjetivo = new ArrayList<>(listaMonedasDisponibles.getListaDeMonedasDisponibles());
            listaMenuObjetivo.remove(monedaBase);

            System.out.println("ingrese La moneda a la cual desea convertir ");
            mostrarMenu(listaMenuObjetivo);

            // Lee la opción de moneda objetivo del usuario
            String validacionIngresoMenuObjetivo = scanner.nextLine().toLowerCase().trim();

            // Valida la opción ingresada
            String validacion = validacionDigito(validacionIngresoMenuObjetivo, listaMenuObjetivo);
            if(validacion.equals("valido")){
                return listaMenuObjetivo.get(Integer.parseInt(validacionIngresoMenuObjetivo) - 1);
            }
            mostrarMensajeValorInvalido();
        }
    }

    /**
     * Valida la opción ingresada por el usuario en el menú base.
     *
     * @param eleccionUsuario La opción seleccionada por el usuario.
     * @param listaMenu La lista de opciones válidas en el menú.
     * @return El resultado de la validación (salir, historial, guardar, válido o inválido).
     */
    public String validacionIngresoUsuario(String eleccionUsuario, List<String> listaMenu){
        if (eleccionUsuario.contains("salir")){
            return "salir";
        } else if(eleccionUsuario.contains("historial")){
            return "historial";
        } else if (eleccionUsuario.contains("guardar")) {
            return "guardar";
        }
        return validacionDigito(eleccionUsuario, listaMenu);
    }

    /**
     * Valida si la entrada del usuario es un número válido dentro de los índices del menú.
     *
     * @param eleccionUsuario La entrada del usuario.
     * @param listaMenu La lista de opciones del menú.
     * @return "valido" si la entrada es válida, "invalido" si no lo es.
     */
    public String validacionDigito(String eleccionUsuario, List<String> listaMenu){
        if(eleccionUsuario.matches("\\d+")){
            int numero = Integer.parseInt(eleccionUsuario);
            if( numero <= listaMenu.size() && numero > 0){
                return "valido";
            }
        }
        return "invalido";
    }

    /**
     * Obtiene el acrónimo de una moneda (los primeros 3 caracteres en mayúsculas).
     *
     * @param moneda El nombre de la moneda.
     * @return El acrónimo de la moneda.
     */
    public String ObtenerAcronimo(String moneda){
        return moneda.trim().substring(0, 3).toUpperCase();
    }

    /**
     * Solicita al usuario ingresar un valor para la moneda base.
     *
     * @param monedaBase La moneda base seleccionada.
     * @return El valor ingresado por el usuario como un número decimal.
     */
    public double ingresoValorMonedaBase(String monedaBase){
        while(true){
            System.out.println("\nPor favor ingrese el valor en " + monedaBase);
            String ingresoValorUsuario = scanner.nextLine().trim();

            // Valida que el valor ingresado sea positivo
            if(!validacionNumeroPositivo(ingresoValorUsuario)){
                System.out.println("\n********************************************************************************");
                System.out.println("Ha ingresado un numero no valido. " +
                        "Por favor ingrese numero mayores positivos");
                System.out.println("********************************************************************************");
                continue;
            }
            return Double.parseDouble(ingresoValorUsuario);
        }
    }

    /**
     * Valida que el número ingresado por el usuario sea un número positivo.
     *
     * @param numero El número ingresado por el usuario.
     * @return `true` si el número es positivo, `false` si no lo es.
     */
    public boolean validacionNumeroPositivo(String numero){
        if (numero.matches("^\\d+(\\.\\d+)?$")) {
            return Double.parseDouble(numero) > 0;
        }
        return false;
    }

    /**
     * Muestra un mensaje indicando que el valor ingresado es inválido y solicita al usuario intentarlo nuevamente.
     */
    public void mostrarMensajeValorInvalido(){
        System.out.println("\n********************************************************************************");
        System.out.println("Ha ingresado un valor invalido. Intentelo de nuevo ");
        System.out.println("********************************************************************************");
    }

    /**
     * Muestra un mensaje de despedida cuando el usuario decide salir del programa.
     */
    public void mostrarDespedida(){
        System.out.println("\n********************************************************************************");
        System.out.println("******************** GRACIAS POR UTILIZAR NUESTROS SERVICIOS ******************* ");
        System.out.println("********************************************************************************");
        System.out.println("********************** REALIZADO POR ANDERSON RODRIGUEZ.S ********************** ");
        System.out.println("********************************************************************************");
    }
}