package com.example.satelites.Model;

/**
 * @author Camila Osorio
 * Clase que representa el request de la peticion del servicio topsecret y topsecret_split
 */
public class SatellitesRequestSplit {

    private Satellite[] satellites;

    public Satellite[] getSatellites() {
        return satellites;
    }

    public void setSatellites(Satellite[] satellites) {
        this.satellites = satellites;
    }

    public SatellitesRequestSplit(Satellite[] satellites) {
        this.satellites = satellites;
    }

    public SatellitesRequestSplit(){

    }


}
