/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregunta;

/**
 *
 * @author Cliente
 */
public interface PreguntaEntera {
 

    //Dadas en clase
    public String getPregunta();
    public int getRespuestaCorrecta();
    
    //Creadas
    public String getMensajeRespuestaCorrecta();
    public String getMensajeRespuestaIncorrecta();
    public boolean verificarPregunta(int z);
    public int totalCalificacion(int z);
    public int calificacionRespuesta(boolean z);
    public void contadorPreguntas(boolean z);
    public int respuestaDato(int z);
}
