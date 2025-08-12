package com.MiLibreria.Practicas.vistas;

import com.MiLibreria.Practicas.apis.JsonParser;
import com.MiLibreria.Practicas.entidades.Libro;
import com.MiLibreria.Practicas.entidades.RespuestaAPI;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    public void imprimirOpciones(){
        for (int i=0; i<11; i++){
            System.out.println("");
        }
        System.out.println("****************************");
        System.out.println("- SISTEM DE MI LIBRERIA, QUE QUIERES HACER HOY?");
        System.out.println(" 1 - Buscar un libro ");
        System.out.println(" 2 - Buscar un libro ");
        System.out.println(" 3 - Buscar un libro ");
        System.out.println(" 4 - Buscar un libro ");
        System.out.println(" 5 - Buscar un libro ");
        System.out.println(" 6 - Buscar un libro ");
        System.out.println(" 7 - Salir ");
        System.out.print("Elije una opcion (1-7):  ");
    }

    public int capturaEleccion(){
        int eleccion = 0;
        while (true){
            try {
                eleccion = scanner.nextInt();
                if (eleccion > 0 && eleccion < 8){
                    break;
                }
                System.out.println("Se requiere que ingreses un numero del 1 al 7, y no " + eleccion);
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


}

