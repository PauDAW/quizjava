package com.mycompany.proyecto1_app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;

public class GestorArchivos {

    public ArrayList<Pregunta> cargarPreguntas(String ruta) {
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        try {
            InputStream stream = getClass().getResourceAsStream("/com/mycompany/proyecto1_app/preguntas.txt");
            if (stream == null) {
                System.out.println("Error crítico: No se encontró 'preguntas.txt'.");
                return preguntas;
            }
            BufferedReader lee = new BufferedReader(new InputStreamReader(stream));
            String linea;
            while((linea = lee.readLine()) != null) {
                String enunciado = linea;
                String op1 = lee.readLine();
                String op2 = lee.readLine();
                String op3 = lee.readLine();
                String op4 = lee.readLine();
                String correcta = lee.readLine();
                preguntas.add(new Pregunta(enunciado, op1, op2, op3, op4, correcta));
            }
            lee.close();
        } catch(Exception e) {
            System.out.println("Error al leer el archivo de preguntas: " + e.getMessage());
        }
        return preguntas;
    }

    public void guardarPuntuacion(String usuario, int aciertos, int fallos, String nota) {
        try {
            FileWriter result = new FileWriter("ranking.txt", true);
            result.write(usuario + "," + aciertos + "," + fallos + "," + nota + "\n");
            result.close();
        } catch(Exception e) {
            System.out.println("Error al guardar en el ranking: " + e.getMessage());
        }
    }

    public List<jugador> cargarRanking() {
        List<jugador> lista = new ArrayList<>();
        File archivo = new File(System.getProperty("user.dir") + File.separator + "ranking.txt");

        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    lista.add(new jugador(0, partes[0], Integer.parseInt(partes[1]), Integer.parseInt(partes[2]), partes[3]));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar la lista: " + e.getMessage());
        }
        Collections.sort(lista);
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).setTop(i + 1);
        }
        return lista;
    }

    public void borrarRanking() {
        try {
            File archivo = new File(System.getProperty("user.dir") + File.separator + "ranking.txt");
            FileWriter writer = new FileWriter(archivo, false);
            writer.write("");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error al borrar el ranking: " + e.getMessage());
        }
    }
    
    public void guardarPuntuacionSinRepetir(String nombre, int aciertos, int fallos, String nota) {
    
    List<jugador> lista = cargarRanking();
    
    
    boolean encontrado = false;
    for (jugador j : lista) {
        if (j.getUsuario().equalsIgnoreCase(nombre)) {
            
            if (aciertos > j.getAciertos()) {
                j.setAciertos(aciertos);
                j.setFallos(fallos);
                j.setNota(nota);
            }
            encontrado = true;
            break;
        }
    }
    
    
    if (!encontrado) {
        lista.add(new jugador(lista.size() + 1, nombre, aciertos, fallos, nota));
    }
    
    
    reescribirRanking(lista);
}
    
    private void reescribirRanking(List<jugador> lista) {
    try {
        FileWriter fw = new FileWriter("ranking.txt", false);
        for (jugador j : lista) {
            fw.write(j.getUsuario() + "," + j.getAciertos() + "," + j.getFallos() + "," + j.getNota() + "\n");
        }
        fw.close();
    } catch (Exception e) {
        System.out.println("Error al reescribir ranking: " + e.getMessage());
    }
}
}