package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class LectorCSV {

    private final String SEPARATOR = ",";          //Es la declaración de una variable
    private ArrayList<String[]> datos;          //Se crea un arreglo

    public void extraerDatos(String url) {

        datos = new ArrayList<>();          //Se crea un nuevo arreglo
        BufferedReader br = null;          //Se lee un archivo csv

        try {

            br = new BufferedReader(new FileReader(url));          //Aca creamos una clase para lectura de un archivo
            String line = br.readLine();                  //Se declara variables tipo texto
            while (null != line) {                 //Es un ciclo repetitivo hasta que acabe la operacion
                String[] fields = line.split(SEPARATOR);
                datos.add(fields);
                line = br.readLine();
            }

        } catch (Exception e) {                //Contiene sentencias 
            System.out.println(e);                //Es el metodo para imprimir
        } finally {
            if (null != br) {                //Es el metodo que proporciona instrucciones al programa
                try {    //Aca se utiliza para tener escepciones en el programa
                    br.close();      //Aqui es el cierre de operacion
                } catch (IOException ex) {              //Contiene sentencias 
                    Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void calcularPromedio(JTextArea txa) {                //Metodo principal del programa 
        for (String[] x : datos) {     //Ciclo repetitivo que recorre el programa hasta acabar todas las sentencias
            txa.append("Cod. Estudiante: " + x[0]);                //El txa.append recolecta la info que se especifica, en este caso es el codigo del estudiante
            txa.append("\nNombre: "+x[1]);                    //El txa.append recolecta la info que se especifica, en este caso es el nombre
            int promedio = (Integer.parseInt(x[2])+Integer.parseInt(x[3])+Integer.parseInt(x[4])+Integer.parseInt(x[5]))/4;        //Se declara una variable tipo entera
            txa.append("\nPromedio de notas: "+promedio+"\n\n");     //El txa.append recolecta la info que se especifica, en este caso es el resultado de promedio
        }
    }
}
