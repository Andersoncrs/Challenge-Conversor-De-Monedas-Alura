package com.aluracursos.conversordemonedas.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    ListaMonedasDisponibles listaMonedasDisponibles = new ListaMonedasDisponibles();

    public void mostrarBienvenida(){
        System.out.println("""
                ********************************************************************************
                ***********    Bienvenido al Conversor de Monedas WorldChangeRate    ***********
                ********************************************************************************
                Aquí podrás hallar la tasa de conversion de multiples monedas a nivel mundial""");
    }
    public void mostrarMenu(List<String> listaMenu){
        for (int i = 0; i < listaMenu.size(); i++) {
            System.out.println( i + 1 + " - " + listaMenu.get(i));
        }
    }

    public String mostrarmenuBase() {
        while (true) {
            System.out.println("Ingrese La moneda que desea Convertir: ");
            List<String> listaDeMonedasDisponibles = listaMonedasDisponibles.getListaDeMonedasDisponibles();
            mostrarMenu(listaDeMonedasDisponibles);
            System.out.println("- Para consultar el Historial, ingrese la palabra \"historial\"");
            System.out.println("- Para Salir ingrese la palabra \"salir\"");
            String eleccionUsuario = scanner.nextLine().toLowerCase().trim();

            String resultadoValidacion = validacionIngresoUsuario(eleccionUsuario, listaDeMonedasDisponibles);
            switch (resultadoValidacion) {
                case "salir":
                    return "salir";
                case "historial":
                    return "historial";
                case "valido":
                    return listaDeMonedasDisponibles.get(Integer.parseInt(eleccionUsuario) - 1);
                case "invalido":
                    System.out.println("Ha ingresado un valor invalido. Intentelo de nuevo\n");
            }
        }
    }

    public String mostrarMenuObjetivo(String monedaBase){
        while(true){
            System.out.println("********************************************************************************");
            System.out.println("Moneda Base ingresada: " + monedaBase );
            System.out.println("********************************************************************************");
            List<String> listaMenuObjetivo = new ArrayList<>(listaMonedasDisponibles.getListaDeMonedasDisponibles());
            listaMenuObjetivo.remove(monedaBase);
            System.out.println("ingrese La moneda a la cual desea convertir ");
            mostrarMenu(listaMenuObjetivo);
            String validacionIngresoMenuObjetivo = scanner.nextLine().toLowerCase().trim();

            String validacion = validacionDigito(validacionIngresoMenuObjetivo, listaMenuObjetivo);
            if(validacion.equals("valido")){
                return listaMenuObjetivo.get(Integer.parseInt(validacionIngresoMenuObjetivo) - 1);
            }
            System.out.println("Ha ingresado un valor invalido. Intentelo de nuevo ");
        }
    }

    public String validacionIngresoUsuario(String eleccionUsuario, List<String> listaMenu){
        if (eleccionUsuario.contains("salir")){
            return "salir";
        } else if(eleccionUsuario.contains("historial")){
            return "historial";
        }
        return validacionDigito(eleccionUsuario, listaMenu);
    }

    public String validacionDigito(String eleccionUsuario, List<String> listaMenu){
        if(eleccionUsuario.matches("\\d+")){
            int numero = Integer.parseInt(eleccionUsuario);
            if( numero <= listaMenu.size() && numero > 0){
                return "valido";
            }
        }
        return "invalido";
    }

    public String ObtenerAcronimo(String moneda){
        return moneda.trim().substring(0, 3).toUpperCase();
    }

    public double ingresoValorMonedaBase(String monedaBase){
        while(true){
            System.out.println("\nPor favor ingrese el valor en " + monedaBase);
            String ingresoValorUsuario = scanner.nextLine().trim();
            if(!validacionNumeroPositivo(ingresoValorUsuario)){
                System.out.println("Ha ingresado un numero no valido. " +
                        "Por favor ingrese numero mayores positivos");
                continue;
            }
            return Double.parseDouble(ingresoValorUsuario);
        }
    }

    public boolean validacionNumeroPositivo(String numero){
        if (numero.matches("^\\d+(\\.\\d+)?$")) {
            return Double.parseDouble(numero) > 0;
        }
        return false;
    }
}

