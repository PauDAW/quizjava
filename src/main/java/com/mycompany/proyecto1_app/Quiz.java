package com.mycompany.proyecto1_app;

import java.util.ArrayList;

public class Quiz {
    
private int puntuacion;
private int indice;
private ArrayList<Pregunta> listaPregunta;
private int aciertos=0;
private int errores=0;

public int getpuntuacion() 
{
    return puntuacion;
}
public void setpuntuacion(int puntuacion) 
{
    this.puntuacion = puntuacion;
}

public int getindice() 
{
    return indice;
}
public void setindice(int indice) 
{
    this.indice = indice;
}

public ArrayList<Pregunta> getlistaPreguntas() 
{
    return listaPregunta;
}
public void setlistaPreguntas(ArrayList<Pregunta> listaPreguntas) 
{
    this.listaPregunta = listaPreguntas;
}

public int getaciertos() 
{
    return aciertos;
}
public void setaciertos(int aciertos) 
{
    this.aciertos = aciertos;
}

public int geterrores() 
{
    return errores;
}
public void seterrores(int errores) 
{
    this.errores = errores;
}

public Quiz() 
{
    this.listaPregunta = new ArrayList<>();
    this.indice = 0;
    this.puntuacion = 0;
}

public Pregunta getPreguntaActual()
{
    return this.listaPregunta.get(this.indice);
}

public void siguientePregunta()
{
    this.indice++;
}

public boolean mas()
{
    return this.indice<this.listaPregunta.size();
}

public void correcto()
{
    this.aciertos=aciertos+1;
}

public void fallos()
{
    this.errores=errores+1;
}

}
