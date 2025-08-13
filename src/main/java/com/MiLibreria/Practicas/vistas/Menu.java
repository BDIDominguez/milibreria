package com.MiLibreria.Practicas.vistas;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.InputMismatchException;

import java.util.Scanner;

@Component
public class Menu {

    private Scanner scanner = new Scanner(System.in);

    public void imprimirOpciones(){
        for (int i=0; i<11; i++){
            System.out.println("");
        }
        System.out.println("****************************");
        System.out.println("- SISTEM DE MI LIBRERIA, QUE QUIERES HACER HOY?");
        System.out.println(" 1 - Buscar un libro ");
        System.out.println(" 2 - Listar todos los Libros en la Base de Datos ");
        System.out.println(" 3 - Lista Libros segun un idioma seleccionado ");
        System.out.println(" 4 - Lista de Autores ");
        System.out.println(" 5 - Lista de Autores vivos hasta ");
        System.out.println(" 6 - Libros por idioma ");
        System.out.println(" 7 - Salir ");
        System.out.print("Elije una opcion (1-7):  ");
    }

    public int capturaEleccion(int minimo, int maximo){
        int eleccion = 0;
        while (true){
            try {
                eleccion = scanner.nextInt();
                if (eleccion >= minimo && eleccion <= maximo){
                    break;
                }
                System.out.println("Se requiere que ingreses un numero del " + minimo + " al " + maximo + " y no " + eleccion);
            } catch (InputMismatchException e){
                System.out.println("Error: debe ingresar un número entero válido.");
                scanner.next();
            }
        }
        return eleccion;
    }

    public String capturaTexto(){
        String texto = "";
        while (true){
            texto = scanner.nextLine();
            if (!texto.isBlank() && !texto.equals("")){
                break;
            }
            System.out.println("Debes ingresar algun texto por favor:");
        }
        return texto;
    }

    public void presioneParaContinual(){
        System.out.println("\n Presione Enter para continuar....");
        try {
            System.in.read(); // espera a que se presione la tecla Enter.
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void imprimirIdiomas(){
        System.out.println("*********** IDIOMAS DISPONIBLES **************** ");
        System.out.println(" 1 - Español");
        System.out.println(" 2 - Ingles");
        System.out.print(" Cual es tu eleccion: ");
    }


}

