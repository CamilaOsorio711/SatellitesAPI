package com.example.satelites.Logic;

/**
 * @author Camila Osorio
 * Clase para llamar la clase que tiene la logica de encontrar el mensaje
 */
public class Message {

    public String getMessage(String[]... messages) {

        FindMessage findMessage = new FindMessage(messages);

        String finalMessage = findMessage.getMessage();

        return finalMessage;

    }
}





