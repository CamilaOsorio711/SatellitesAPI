package com.example.satelites.Logic;

import java.util.ArrayList;

/**
 * @author Camila Osorio
 * Clase para encontrar el mensaje.
 * Para esto se asume que la matriz de mensajes es de NxM con M constante.
 * Se asume que el desface es de 1.
 */
public class FindMessage {

    private String[][] messages;
    private String finalMessage = "";
    private ArrayList<String> words;
    private int cont = 0;


    public FindMessage() {
    }

    public FindMessage(String[][] messages) {
        this.messages = messages;
        words = new ArrayList<String>(messages[0].length);
    }

    /**
     * Metodo principal de la clase que realiza el llamado en orden de los otros metodos
     * @return retorna el mensaje
     */
    public String getMessage(){
        readByColumn();
        orderMessage();
        return finalMessage;
    }

    /**
     * Metodo para leer una sola columna de la matriz de mensajes
     */
    private  void readByColumn() {
        for (int i = 0; i < messages[0].length; i++) {
            readColumn(i);
        }
    }

    /**
     * Metodo para leer una sola columna de la matriz de mensajes,
     * dado el index de la columna
     */
    private void readColumn(int col) {
        for (int i = 0; i < messages.length; i++) {
            if(validateInsert(messages[i][col])){
                words.add(messages[i][col]);
                cont++;
            }
        }
    }

    /**
     * Metodo para validar si la palabra ya existe en la posicion anterior o si
     * es la primera palabra a insertar
     * @param word palabra a validar
     */
    public boolean  validateInsert(String word) {
        if(!word.equals("")) {
            if(cont==0) {
                return true;
            }
            else{
                if (!words.get(cont - 1).equals(word)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo para convertir el array de palabras en un solo String
     */
    public void orderMessage(){
        for (int i = 0; i < words.size(); i++) {
            finalMessage += " " + words.get(i);
        }
        finalMessage = finalMessage.trim();

    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public String[][] getMessages() {
        return messages;
    }

    public void setMessages(String[][] messages) {
        this.messages = messages;
    }

    public String getFinalMessage() {
        return finalMessage;
    }

    public void setFinalMessage(String finalMessage) {
        this.finalMessage = finalMessage;
    }
}
