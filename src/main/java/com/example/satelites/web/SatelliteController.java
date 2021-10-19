package com.example.satelites.web;

import com.example.satelites.Model.Satellite;
import com.example.satelites.Model.SatellitesRequest;
import com.example.satelites.Model.SourceResponse;
import com.example.satelites.service.LocalizationService;
import com.example.satelites.service.SatellitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Camila Osorio
 * Clase para exponer los servicios
 */
@RestController
@RequestMapping("/")
public class SatelliteController {

    @Autowired
    private final LocalizationService localizationService;

    @Autowired
    private final SatellitesService satellitesService;


    private final SourceResponse sourceResponse = new SourceResponse();

    public SatelliteController(LocalizationService localizationService,SatellitesService satellitesService) {
        this.localizationService = localizationService;
        this.satellitesService = satellitesService;
    }

    @PostMapping("/topsecret")
    public ResponseEntity<SourceResponse> getData(@RequestBody SatellitesRequest satellites){
        try{
            SourceResponse source= localizationService.getPositionAndMessage(satellites);

            if((source.getPosition()==null) || source.getMessage().trim().equals("")){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                return new ResponseEntity<>(source, HttpStatus.OK);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/topsecret_split/{satellite_name}")
    public ResponseEntity<?> saveSatellite(@PathVariable("satellite_name") String name, @RequestBody Satellite satellite){
        if(satellitesService.receiveSatellite(satellite, name)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("Ya hay 3 satelites almacenados.", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/topsecret_split/{satellite_name}")
    public ResponseEntity getData(@PathVariable("satellite_name") String name, @RequestBody Satellite satellite){
        SourceResponse source = new SourceResponse();
        satellitesService.receiveSatellite(satellite, name);

        boolean callLocalization = satellitesService.validateSatellites();

        if (callLocalization){
            source= localizationService.getPositionAndMessage(satellitesService.getSatellitesRequest());
        }
        else{

            return new ResponseEntity<>("No hay informacion suficiente", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(source, HttpStatus.OK);
    }



}
