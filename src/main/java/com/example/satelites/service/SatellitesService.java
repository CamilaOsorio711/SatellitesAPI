package com.example.satelites.service;


import com.example.satelites.Model.Satellite;
import com.example.satelites.Model.SatellitesRequest;
import org.springframework.stereotype.Service;

/**
 * @author Camila Osorio
 * Clase service de los servicios de satelites
 */
@Service
public class SatellitesService {

    SatellitesRequest satellitesRequest;
    Satellite[] satellites = new Satellite[3] ;

    int cant = 0;

    public SatellitesService() {
        satellitesRequest = new SatellitesRequest();
    }

    public Satellite[] getSatellites() {
        return satellites;
    }

    public void setSatellites(Satellite[] satellites) {
        this.satellites = satellites;
    }

    public SatellitesRequest getSatellitesRequest() {
        return satellitesRequest;
    }

    public void setSatellitesRequest(SatellitesRequest satellitesRequest) {
        this.satellitesRequest = satellitesRequest;
    }

    public boolean receiveSatellite(Satellite satellite, String nameSatellite){

        if(!validateSize()){
            satellite.setName(nameSatellite);
            satellites[cant] = satellite;
            cant++;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean validateSize(){

        for (int i = 0; i < satellites.length; i++) {
            if(satellites[i] == null){
                return false;
            }
        }
        return true;
    }

    public boolean validateSatellites(){
        if(validateSize()){
            fillRequest();
            return true;
        }
        else{
            return false;
        }
    }

    public void fillRequest(){
        satellitesRequest.setSatellites(satellites);
        satellites = new Satellite[3];
    }
}
