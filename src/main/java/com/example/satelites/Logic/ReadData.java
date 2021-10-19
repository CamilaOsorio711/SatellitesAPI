package com.example.satelites.Logic;

import com.example.satelites.Model.Satellite;
import com.example.satelites.Model.SourceResponse;
import com.example.satelites.Model.SatellitesRequest;


/**
 * @author Camila Osorio
 * Clase encarga de leer la informacion de la peticion del servicios,
 * crea un arreglo de mensajes y otro de posiciones.
 */
public class ReadData {

    private SourceResponse response = new SourceResponse();
    private Satellite[] satellites;
    private String[][] messages;
    private double[] distances;

    /**
     * Metodo encargado de leer el JSON del servicio y crear array de mensajes y distancias
     * @param satellitesRequest
     */
    public void readDataSatellites(SatellitesRequest satellitesRequest) {

        satellites = satellitesRequest.getSatellites();
        messages = new String[satellites.length][];
        distances = new double[satellites.length];

        for (int i = 0; i < satellites.length; i++) {
            messages[i] = satellites[i].getMessage();
            distances[i] = satellites[i].getDistance();
        }
    }

    /**
     * Metodo que llama a readData y llama a la clase del mensaje y
     * y a la localizacion.
     * @param satellitesRequest
     */
    public SourceResponse getPositionAndMessage(SatellitesRequest satellitesRequest){

        readDataSatellites(satellitesRequest);

        Message message = new Message();
        Localization localization = new Localization();

        response.setMessage(message.getMessage(messages));
        response.setPosition(localization.getLocation(distances));

        return response;

    }

    public SourceResponse getResponse() {
        return response;
    }

    public void setResponse(SourceResponse response) {
        this.response = response;
    }

    public Satellite[] getSatellites() {
        return satellites;
    }

    public void setSatellites(Satellite[] satellites) {
        this.satellites = satellites;
    }

    public String[][] getMessages() {
        return messages;
    }

    public void setMessages(String[][] messages) {
        this.messages = messages;
    }

    public double[] getDistances() {
        return distances;
    }

    public void setDistances(double[] distances) {
        this.distances = distances;
    }
}
