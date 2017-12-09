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
public class Pregunta {

    String pregunta;
    String respuesta;
    String mensaje;
    int ntF = 0;

    ArrayList<Pregunta> lista = new ArrayList<>();

    public Pregunta() {
    }

    public Pregunta(String pregunta, String respuesta, String mensaje) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Lista de Preguntas\n" + pregunta + "\n" + respuesta + "\n" + mensaje + "\n\n" + lista;
    }

    public static void main(String[] args) {
        Pregunta preg = new Pregunta();
        PreguntaAdision p = new PreguntaAdision();
        PreguntaResta pr = new PreguntaResta();

//        p.leerPregunta();
//        p.leerPregunta();
        PreguntaMultiplicacion pm = new PreguntaMultiplicacion();

        preg.calificacionRespuestas(p, pr, pm);
        System.out.println(preg.toString());

    }

    

    public void calificacionRespuestas(PreguntaAdision p, PreguntaResta pr, PreguntaMultiplicacion pm) {
        int cont = 0;
        int z = 0;

        do {
            int i = (int) (Math.random() * 3) + 1;

            switch (i) {
                case 1:
                    this.pregunta = p.getPregunta();
                    JOptionPane.showMessageDialog(null, this.pregunta);   //Presenta la operacion
                
                    z = Integer.parseInt(JOptionPane.showInputDialog("Ingrese respuesta")); //Solicita la respuesta
                    p.respuestaDato(z); //Guarda la respuesta
                    this.respuesta = "Tu respuesta fue: " + p.respuestaDato(z);
                    
                    //p.verificarPregunta(z); //VErifica si es verdadero
                    if (p.verificarPregunta(z) == true) {
                        this.mensaje = "Respuesta correcta";
                    } else {
                        this.mensaje = "Respuesta incorrecta:\nLa respuesta correcta es: " + p.getRespuestaCorrecta();
                    }

                    //verifica si es verdadero devuelve la nota de 10 sino retorna 0
                    if (p.calificacionRespuesta(p.verificarPregunta(z)) == 10) {
                        ntF = ntF + p.calificacionRespuesta(p.verificarPregunta(z));  //Guarda la nota en el contado de todas las notas
                        JOptionPane.showMessageDialog(null, p.getMensajeRespuestaCorrecta());   //Mensaje de respuesta correcta
                    } else {
                        JOptionPane.showMessageDialog(null, p.getMensajeRespuestaIncorrecta());//Mensaje de respuesta incorrecta
                    }
                    cont++;
                    lista.add(new Pregunta(pregunta, respuesta, mensaje));
                    break;
                case 2:
                    this.pregunta = pr.getPregunta();
                    JOptionPane.showMessageDialog(null, this.pregunta);   //Presenta la operacion

                    z = Integer.parseInt(JOptionPane.showInputDialog("Ingrese respuesta")); //Solicita la respuesta
                    pr.respuestaDato(z); //Guarda la respuesta
                    this.respuesta = "Tu respuesta fue: " + pr.respuestaDato(z);

                    //p.verificarPregunta(z); //VErifica si es verdadero
                    if (pr.verificarPregunta(z) == true) {
                        this.mensaje = "Respuesta correcta";
                    } else {
                        this.mensaje = "Respuesta incorrecta:\nLa respuesta correcta es: " + pr.getRespuestaCorrecta();
                    }

//                    pr.calificacionRespuesta( pr.verificarPregunta(z));   //verifica si es verdadero devuelve la nota de 10 sino retorna 0
                    if (pr.calificacionRespuesta(pr.verificarPregunta(z)) == 10) {
                        ntF = ntF + pr.calificacionRespuesta(pr.verificarPregunta(z));  //Guarda la nota en el contado de todas las notas
                        JOptionPane.showMessageDialog(null, pr.getMensajeRespuestaCorrecta());   //Mensaje de respuesta correcta
                    } else {
                        JOptionPane.showMessageDialog(null, pr.getMensajeRespuestaIncorrecta());//Mensaje de respuesta incorrecta

                    }
                    cont++;
                    lista.add(new Pregunta(pregunta, respuesta, mensaje));
                    break;
                case 3:
                    this.pregunta = pm.getPregunta();
                    JOptionPane.showMessageDialog(null, this.pregunta);   //Presenta la operacion

                    z = Integer.parseInt(JOptionPane.showInputDialog("Ingrese respuesta")); //Solicita la respuesta
                    pm.respuestaDato(z); //Guarda la respuesta
                    this.respuesta = "Tu respuesta fue: " + pm.respuestaDato(z);

                    //Verifica si es verdadero
                    if (pm.verificarPregunta(z) == true) {
                        this.mensaje = "Respuesta correcta";
                    } else {
                        this.mensaje = "Respuesta incorrecta:\nLa respuesta correcta es: " + pm.getRespuestaCorrecta();
                    }
                    
//                  //verifica si es verdadero devuelve la nota de 10 sino retorna 0
                    if (pm.calificacionRespuesta(pm.verificarPregunta(z)) == 10) {
                        ntF = ntF + pm.calificacionRespuesta(pm.verificarPregunta(z));
                        JOptionPane.showMessageDialog(null, pm.getMensajeRespuestaCorrecta());   //Mensaje de respuesta correcta
                    } else {
                        JOptionPane.showMessageDialog(null, pm.getMensajeRespuestaIncorrecta());//Mensaje de respuesta incorrecta

                    }
                    cont++;
                    lista.add(new Pregunta(pregunta, respuesta, mensaje));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Número equivocado");   //Por estética
            }
            //System.out.println("cont " + cont); para verificar si se ejecutaron las 10 preguntas una por una
            //System.out.println("nF " + ntF); para verificar la sumatoria de las notas
            
        } while (cont < 10);
        
        JOptionPane.showMessageDialog(null, "Su nota fina es: " + ntF);

    }
}
