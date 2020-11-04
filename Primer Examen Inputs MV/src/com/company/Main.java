package com.company;

import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public Scanner scanner = new Scanner(System.in);


    public static void main(String[] args)
    {
        //trabajo con el proceso principal en main y metodos en la clase Libro
        Scanner scanner = new Scanner(System.in);
        ArrayList<Libro>listalibros;
        listalibros = new ArrayList();
        Libro relacion = new Libro();//creamos la instancia con la clase
        boolean bandera = true;
        System.out.println("Aplicacion de Biblioteca");
        do {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("\n" + "Elija una opcion\n1.Agregar\n2.Consultar\n3.consultar todos \n4.Prestar un libro\n5.devolver un libro\n6.Ver existencia de libros \n7.Salir\n8.Modificar datos de Libro"));
                    switch (opcion) {
                    case 1: //agregar
                    {
                        listalibros.add(relacion.agregar());
                    }
                    break;
                    case 2: //consultar
                    {
                        relacion.consultarportipo(listalibros);
                    }
                    break;
                    case 3: //consultar todos
                    {
                        relacion.consultartodos(listalibros);
                    }
                    break;
                    case 4://prestar un libro
                    {
                        relacion.prestaralv(listalibros);
                    }
                    break;
                    case 5://devolver un libro
                    {
                        relacion.regresar(listalibros);
                    }
                    break;
                    case 6://Ver existencia de libros
                    {
                        relacion.verexistencia(listalibros);
                    }
                    break;
                    case 7://salir
                    {
                        bandera = false;
                    }
                    break;
                    case 8://modificar datos de libros; Este metodo esta chidi
                    {
                        relacion.modificardatos(listalibros);
                    }
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                        break;
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Caracter invalido");
                break;
            }
        } while (bandera) ;
        System.exit(0);
        }
    }

