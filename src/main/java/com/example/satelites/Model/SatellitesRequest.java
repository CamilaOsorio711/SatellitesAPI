package com.example.satelites.Model;

/**
 * @author Camila Osorio
 * Clase que representa el request de la peticion del servicio topsecret
 */
public class SatellitesRequest {

    private Satellite[] satellites;

    public Satellite[] getSatellites() {
        return satellites;
    }

    public void setSatellites(Satellite[] satellites) {
        this.satellites = satellites;
    }

    public SatellitesRequest(Satellite[] satellites) {
        this.satellites = satellites;
    }

    public SatellitesRequest(){

    }


}
