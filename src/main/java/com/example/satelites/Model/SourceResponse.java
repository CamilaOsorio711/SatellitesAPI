package com.example.satelites.Model;

/**
 * @author Camila Osorio
 * Clase que representa el response del servicio topsecret
 */
public class SourceResponse {

    private Position position;

    private String message;

    public SourceResponse(){
        position = new Position();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
