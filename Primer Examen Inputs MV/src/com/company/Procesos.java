package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Procesos extends Libro {
    public int Agregar() {
        ArrayList<Libro> listalibros;
        listalibros = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        boolean bandera = true;
        System.out.println("Aplicacion de Biblioteca");
        while (bandera) {
            System.out.println("Elija una opcion\n1.Agregar\n2.Consultar\n3.consultar todos \n4.Prestar un libro\n5.devolver un libro\n6.Ver existencia de libros \n7.Salir");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1: //agregar
                {

                    System.out.println("Ingresa el nombre del libro");
                    String nombre = scanner.next();
                    System.out.println("Ingrese el anio de publicacion");
                    int anio = scanner.nextInt();
                    System.out.println("Ingrese el ISBN");
                    int isbn = scanner.nextInt();
                    System.out.println("Ingrese la cantidad de libros a ingresar");
                    int cant = scanner.nextInt();
                    Libro nuevolibro = new Libro();
                    nuevolibro.setAnio(anio);
                    nuevolibro.setExistencia(cant);
                    nuevolibro.setNombre(nombre);
                    nuevolibro.setIsbn(isbn);
                    listalibros.add(nuevolibro);
                }
                break;
                case 2: //consultar
                {
                    System.out.println("Por que metodo quieres consultar el libro\n1.Nombre\n2.Anio\n3.ISBN");
                    int opcion2 = scanner.nextInt();
                    switch (opcion2) {
                        case 1://nombre
                        {
                            System.out.println("Cual es el nombre del libro");
                            String nombre = scanner.next();
                            for (Libro nuevolibro : listalibros) {
                                if (nombre.toUpperCase().equals((nuevolibro.getNombre().toUpperCase()))) {
                                    System.out.println("El libro consultado es\nNombre:" + nuevolibro.getNombre() + "\nAnio:" + nuevolibro.getAnio() + "\nISNB:" + nuevolibro.getIsbn() + "\nCantidad:" + nuevolibro.getExistencia());
                                } else {
                                    System.out.println("No hay libros con esas caracteristicas");
                                }

                            }
                            break;
                        }
                        case 2://anio
                        {
                            System.out.println("Cual es el anio del libro a consultar");
                            String anio = scanner.next();
                            for (Libro nuevolibro : listalibros) {
                                if (anio.equals((nuevolibro.getNombre()))) {
                                    System.out.println("El libro consultado es\nNombre:" + nuevolibro.getNombre() + "\nAnio:" + nuevolibro.getAnio() + "\nISNB:" + nuevolibro.getIsbn() + "\nCantidad:" + nuevolibro.getExistencia());
                                } else {
                                    System.out.println("No hay libros con esas caracteristicas");
                                }
                            }
                            break;
                        }
                        case 3://ISBM
                        {
                            System.out.println("Cual es el ISBM del libro");
                            String ISBM = scanner.next();
                            for (Libro nuevolibro : listalibros) {
                                if (ISBM.equals((nuevolibro.getNombre()))) {
                                    System.out.println("El libro consultado es\nNombre:" + nuevolibro.getNombre() + "\nAnio:" + nuevolibro.getAnio() + "\nISBN:" + nuevolibro.getIsbn() + "\nCantidad:" + nuevolibro.getExistencia());
                                } else {
                                    System.out.println("No hay libros con esas caracteristicas");
                                }

                            }
                            break;
                        }
                    }
                }
                break;
                case 3: //consultar todos
                {
                    for (Libro nuevolibro : listalibros) {
                        System.out.println("Estos son todos los Libros\nNombre:" + nuevolibro.getNombre() + "\nAnio:" + nuevolibro.getAnio() + "\nISNB:" + nuevolibro.getIsbn() + "\nCantidad:" + nuevolibro.getExistencia());
                    }
                }
                break;
                case 4://prestar un libro
                {
                    System.out.println("Cual es el nombre del libro que deseas alquilar?");
                    String nombre = scanner.next();
                    for (Libro nuevolibro : listalibros) {
                        if (nombre.toUpperCase().equals((nuevolibro.getNombre().toUpperCase()))) {
                            int NV = nuevolibro.getExistencia() - 1;
                            nuevolibro.setExistencia(NV);

                        } else {
                            System.out.println("No hay libros con esas caracteristicas");
                        }

                    }
                }
                break;
                case 5://devolver un libro
                {
                    System.out.println("Cual es el nombre del libro que deseas alquilar?");
                    String nomdev = scanner.next();
                    for (Libro nuevolibro : listalibros) {
                        if (nomdev.toUpperCase().equals((nuevolibro.getNombre().toUpperCase()))) {
                            int NV = nuevolibro.getExistencia() + 1;
                            nuevolibro.setExistencia(NV);
                        } else {
                            System.out.println("No hay libros con esas caracteristicas");
                        }
                    }
                }
                break;
                case 6://Ver existencia de libros
                {
                    System.out.println("Estos son las existencias de libros");
                    for (Libro nuevolibro : listalibros) {
                        System.out.println(nuevolibro.getNombre() + " " + nuevolibro.getExistencia() + "\n");
                    }
                }
                break;
                case 7://salir
                {
                    bandera = false;
                }
                break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        }
        return 5;
    }
}




