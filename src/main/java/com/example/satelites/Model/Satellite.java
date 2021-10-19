package com.example.satelites.Model;

/**
 * @author Camila Osorio
 * Clase que representa un satelite
 */
public class Satellite {

    private String name;

    private double distance;

    private String[] message;

    public Satellite(String name, double distance, String[] message) {
        this.name = name;
        this.distance = distance;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
