package com.example.satelites.service;

import com.example.satelites.Logic.Message;
import com.example.satelites.Logic.ReadData;
import com.example.satelites.Model.Satellite;
import com.example.satelites.Model.SourceResponse;
import com.example.satelites.Logic.Localization;
import com.example.satelites.Model.Position;
import com.example.satelites.Model.SatellitesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Camila Osorio
 * Clase service de los servicios de localizacion y mensajes
 */
@Service
public class LocalizationService {

    private final Localization localization;
    private final Message message;
    private final ReadData readData;

    @Autowired
    public LocalizationService() {
        localization = new Localization();
        message = new Message();
        readData = new ReadData();
    }

    public Position getLocation(){
        return localization.getLocation();
    }

    public String getMessage(String[]...messages){
        return message.getMessage(messages);
    }

    public SourceResponse getPositionAndMessage(SatellitesRequest satellites){
       return readData.getPositionAndMessage(satellites);
    }

    public void receiveSatellite(Satellite satellite){

    }


}
