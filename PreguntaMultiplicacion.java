/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregunta;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cliente
 */
public class PreguntaMultiplicacion implements PreguntaEntera {

    private int multiplicando, multiplicador;
    PreguntaMultiplicacion preguntaMultiplicacion;
    
    int valorNota = 0;
    int cont = 0;
    
   
    
    public PreguntaMultiplicacion() {
        multiplicando = (int) (Math.random() * 50 + 1);
        multiplicador = (int) (Math.random() * 50);
    }

    
    
    @Override
    public String getPregunta() {
        multiplicando = (int) (Math.random() * 50 + 1);
        multiplicador = (int) (Math.random() * 50);
        return "Cuanto es " + multiplicando + " * " + multiplicador + "?";
    }

    
    @Override
    public int getRespuestaCorrecta() {
        return multiplicando * multiplicador;
    }
    
    @Override
    public String getMensajeRespuestaCorrecta() {
        return "Respuesta correcta\n";
    }

    @Override
    public String getMensajeRespuestaIncorrecta() {
        return "Respuesta incorrecta\nLa respuesta correcta es: " + getRespuestaCorrecta();
    }

    @Override
    public boolean verificarPregunta(int z) {
        if (z == getRespuestaCorrecta()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int totalCalificacion(int z) {
        if (z == 10) {
            valorNota = valorNota + z;
        }

        return valorNota;
    }

    @Override
    public int calificacionRespuesta(boolean z) {
        if (z == true) {
            return 10;
        } else {
            return 0;
        }

    }

    @Override
    public void contadorPreguntas(boolean z) {
        if (z == true) {
            cont++;
        }
        JOptionPane.showMessageDialog(null, "Pregunta acertadas");
    }

    @Override
    public int respuestaDato(int z) {
        return z;
    }
}
