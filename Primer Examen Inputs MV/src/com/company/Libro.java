package com.company;

//import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;


public class Libro {
    private String nombre;
    private  int anio;
    private int isbn;
    private  int existencia;
    public Scanner scanner = new Scanner(System.in);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    public Libro agregar()//Creamos del tipo de la clase para enviar sin errores a la instancia
    {

        String nombre= JOptionPane.showInputDialog("Cual es el nombre del libro");
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Dame el anio de publicacion del libro"));
        int isbn = Integer.parseInt(JOptionPane.showInputDialog("Dame el isbn del libro"));
        int cant = Integer.parseInt(JOptionPane.showInputDialog("Dame la cantidad de libros a ingresar"));
        JOptionPane.showMessageDialog(null,"Libro aniadido con exito");

        Libro nuevolibro = new Libro();
        nuevolibro.setAnio(anio);
        nuevolibro.setExistencia(cant);
        nuevolibro.setNombre(nombre);
        nuevolibro.setIsbn(isbn);
        return nuevolibro;//enviamos el objeto con sus atributos para solo agregarlo en el main
    }
    public  void  consultarportipo(ArrayList<Libro> libros)
    {
        Object[] opciones = {"Nombre", "ISBN", "Anio"};
        Object opcion = JOptionPane.showInputDialog(null, "Elige por que metodo buscaras el libro","Buscar por...", JOptionPane.ERROR_MESSAGE, null,  opciones,"Nombre");
if(opcion=="Nombre")
{
    String nombre = JOptionPane.showInputDialog("Cual es el nombre del libro");
    int i=0;
    for (Libro nuevolibro : libros)
    {
        if (nombre.toUpperCase().equals((nuevolibro.getNombre().toUpperCase())))
        {
           JOptionPane.showMessageDialog(null,"El libro consultado es\nNombre:" + nuevolibro.getNombre() + "\nAnio:" + nuevolibro.getAnio() + "\nISNB:" + nuevolibro.getIsbn() + "\nCantidad:" + nuevolibro.getExistencia()+"\n");
        }
        else {//si no hay coicidencias mandar solo un mensaje de error
            if(i==0){
                JOptionPane.showMessageDialog(null,"No hubo ninguno concidencia");
            }
        }
        i++;
    }
}
if (opcion=="Anio")
{
    int anio = Integer.parseInt(JOptionPane.showInputDialog("Cual es el anio del libro a consultar"));
    int i=0;
    for (Libro nuevolibro : libros)
    {
        if (anio==(nuevolibro.getAnio()))
        {
            JOptionPane.showMessageDialog(null, " El libro consultado es\nNombre:" + nuevolibro.getNombre() + "\nAnio:" + nuevolibro.getAnio() + "\nISNB:" + nuevolibro.getIsbn() + "\nCantidad:" + nuevolibro.getExistencia()+"\n");
        }
        else {
            if(i==0){
                JOptionPane.showMessageDialog(null, "No hubo ninguno concidencia");
            }
        }
        i++;
    }
}
if(opcion=="ISBM")
{
    int ISBM = Integer.parseInt(JOptionPane.showInputDialog("Cual es el ISBM del libro"));
    int i=0;
    for (Libro nuevolibro : libros) {
        if (ISBM==(nuevolibro.getIsbn()))
        {
            JOptionPane.showMessageDialog(null, "El libro consultado es\nNombre:" + nuevolibro.getNombre() + "\nAnio:" + nuevolibro.getAnio() + "\nISBN:" + nuevolibro.getIsbn() + "\nCantidad:" + nuevolibro.getExistencia()+"\n");
        }
        else {
            if(i==0){
                JOptionPane.showMessageDialog(null, "No hubo ninguno concidencia");
            }
        }
        i++;
    }
}
    }
    public  void  consultartodos(ArrayList<Libro>libros)
    {
        for(Libro nuevolibro :libros)
        {
            JOptionPane.showMessageDialog(null, "Nombre: "+nuevolibro.getNombre()+"\nAnio:"+nuevolibro.getAnio()+"\nISNB:"+nuevolibro.getIsbn()+"\nCantidad:"+nuevolibro.getExistencia()+"\n","Estos son todos tus libros",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void prestaralv(ArrayList<Libro> libros) {
        String num = JOptionPane.showInputDialog("Ingresa el nombre del libro que deseas alquilar?");
            int i = 0;
        for (Libro nuevolibro : libros)
        {
            int comprobar = nuevolibro.getExistencia();
            if (comprobar > 1)//Comprobar si hay existencias del libro que se quiere
            {
                if (num.toUpperCase().equals((nuevolibro.getNombre().toUpperCase())))//Si el nombre coincide
                {
                    int NV = nuevolibro.getExistencia() - 1;
                    nuevolibro.setExistencia(NV);
                    if (i == 0)
                    {
                        JOptionPane.showMessageDialog(null, "Muy bien el libro " + num + " se ha prestado");}
                }
                else {//Si el nombre no es correcto
                    if (i==0)
                    {
                        JOptionPane.showMessageDialog(null, "El libro que estas buscando no existe en nuestro catalogo","Ha habido un error",JOptionPane.INFORMATION_MESSAGE);}
                }
            }//No hay coincidencias con el nombre
            else {//Si la existencia es menor a 1
                if(i==0) {
                    JOptionPane.showMessageDialog(null, "No hay existencias del libro que estas buscando");}
            }
            i++;//Que no se repita
        }
    }


    public void  regresar(ArrayList<Libro>libros)
    {
        String nomdev = JOptionPane.showInputDialog("Cual es el nombre del libro que deseas regresar?");

        for (Libro nuevolibro : libros)
        {
            if (nomdev.toUpperCase().equals((nuevolibro.getNombre().toUpperCase())))
            {
                int NV = nuevolibro.getExistencia() + 1;
                nuevolibro.setExistencia(NV);
            }
        }
        JOptionPane.showMessageDialog(null, "Muy bien el libro "+nomdev+" se ha devuelto");
    }
    public void  verexistencia(ArrayList<Libro>libros)
    {
        for(Libro nuevolibro :libros)
        {
            JOptionPane.showMessageDialog(null, nuevolibro.getNombre()+" "+nuevolibro.getExistencia()+"\n","Estas son las existencias de libros",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void modificardatos(ArrayList<Libro>libros)//Este metodo hace tod lo de las anteriores pero mas chidi
    {
        String nombre = JOptionPane.showInputDialog("Cual es el nombre del libro?");
        int i=0;
        for (Libro nuevolibro : libros)
        {
            if (nombre.toUpperCase().equals((nuevolibro.getNombre().toUpperCase())))
            {
                if(i==0) {

                    JOptionPane.showMessageDialog(null, "El libro consultado es\nNombre:" + nuevolibro.getNombre() + "\nAnio:" + nuevolibro.getAnio() + "\nISNB:" + nuevolibro.getIsbn() + "\nCantidad:" + nuevolibro.getExistencia() + "\n");

                    Object[] opciones = {"Nombre", "ISBN", "Anio","Existencias"};
                    Object opcion = JOptionPane.showInputDialog(null, "Elige que atributo deseas editar del libro","Modificar datos de libro", JOptionPane.ERROR_MESSAGE, null,  opciones,"Nombre");
                    if(opcion=="Nombre")
                    {
                        String NN = JOptionPane.showInputDialog("Ingresa el nuevo nombre que tendra el libro");
                        nuevolibro.setNombre(NN);
                        JOptionPane.showMessageDialog(null, "El nombre ha sido actualizado con exito\n");
                    }
                    if(opcion=="Anio")
                    {
                        int NA = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el nuevo anio que tendra el libro"));
                        nuevolibro.setAnio(NA);
                        JOptionPane.showMessageDialog(null, "El Anio ha sido actualizado con exito\n");
                    }
                    if(opcion=="ISBN")
                    {
                        int NI = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el nuevo ISBN que tendra el libro"));
                        nuevolibro.setIsbn(NI);
                        JOptionPane.showMessageDialog(null, "El ISBN ha sido actualizado con exito\n");
                    }
                    if(opcion=="Existencias")
                    {
                        int NE = Integer.parseInt(JOptionPane.showInputDialog("Ingresa las existencias que tendra el libro"));
                        nuevolibro.setExistencia(NE);
                        JOptionPane.showMessageDialog(null, "Las existencias han sido actualizadas con exito\n");
                    }
                }
                i++;
            }
            else {//si no hay coicidencias mandar solo un mensaje de error
                if(i==0){
                    JOptionPane.showMessageDialog(null, "No hubo ninguna concidencia\n");
                }
            }
        }
    }
}
