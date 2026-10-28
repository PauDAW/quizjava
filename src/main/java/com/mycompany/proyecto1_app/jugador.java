package com.mycompany.proyecto1_app;

public class jugador implements Comparable<jugador> {
    private int top;
    private String usuario;
    private int aciertos;
    private int fallos;
    private String nota;

    public jugador(int top, String usuario, int aciertos, int fallos, String nota) {
        this.top = top;
        this.usuario = usuario;
        this.aciertos = aciertos;
        this.fallos = fallos;
        this.nota = nota;
    }

    // Métodos Getters
    public int getTop() { return top; }
    public String getUsuario() { return usuario; }
    public int getAciertos() { return aciertos; }
    public int getFallos() { return fallos; }
    public String getNota() { return nota; }
    
    
    public void setAciertos(int aciertos) { 
    this.aciertos = aciertos; 
    }

    public void setFallos(int fallos) { 
        this.fallos = fallos; 
    }

public void setNota(String nota) { 
    this.nota = nota; 
}

    // Método Setter corregido
    public void setTop(int top) { 
        this.top = top; 
    }

    @Override
    public int compareTo(jugador otro) {

        return Integer.compare(otro.getAciertos(), this.aciertos);
    }
}
