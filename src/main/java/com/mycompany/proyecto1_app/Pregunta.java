package com.mycompany.proyecto1_app;

public class Pregunta {
    
private String enunciado; 
private String opcion1;
private String opcion2;
private String opcion3;
private String opcion4;
private String respuestaCorrecta;

public String getenunciado() 
{
    return enunciado;
}
public void setenunciado(String enunciado) 
{
    this.enunciado = enunciado;
}

public String getopcion1() 
{
    return opcion1;
}
public void setopcion1(String opcion1) 
{
    this.opcion1 = opcion1;
}

public String getopcion2() 
{
    return opcion2;
}
public void setopcion2(String opcion2) 
{
    this.opcion2 = opcion2;
}

public String getopcion3() 
{
    return opcion3;
}
public void setopcion3(String opcion3) 
{
    this.opcion3 = opcion3;
}

public String getopcion4() 
{
    return opcion4;
}
public void setopcion4(String opcion4) 
{
    this.opcion4 = opcion4;
}

public String getrespuestaCorrecta() 
{
    return respuestaCorrecta;
}
public void setrespuestaCorrecta(String respuestaCorrecta) 
{
    this.respuestaCorrecta = respuestaCorrecta;
}

public Pregunta(String enunciado, String opcion1, String opcion2, String opcion3, String opcion4, String respuestaCorrecta) {
    this.enunciado = enunciado;
    this.opcion1 = opcion1;
    this.opcion2 = opcion2;
    this.opcion3 = opcion3;
    this.opcion4 = opcion4;
    this.respuestaCorrecta = respuestaCorrecta;
}
    
public boolean esCorrecta(String respuestaUsuario)
{
   return this.respuestaCorrecta.equals(respuestaUsuario); 
}


}
