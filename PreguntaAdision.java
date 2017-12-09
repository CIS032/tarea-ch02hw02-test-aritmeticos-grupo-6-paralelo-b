package pregunta;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author Cliente
 */
public class PreguntaAdision implements PreguntaEntera {

    private int a, b;
    PreguntaAdision preguntaAdicion;
    int valorNota = 0;
    int cont = 0;

    public PreguntaAdision() {   //Constructor
        a = (int) (Math.random() * 50 + 1);
        b = (int) (Math.random() * 50);
    }

    

    @Override
    public String getPregunta() {
        a = (int) (Math.random() * 50 + 1);
        b = (int) (Math.random() * 50);
        return "Cuanto es " + a + " + " + b + " ?";
    }


    @Override
    public int getRespuestaCorrecta() {
        return a + b;
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

    //preguntas acertadas
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
