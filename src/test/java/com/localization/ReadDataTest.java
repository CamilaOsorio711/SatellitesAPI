package com.localization;

import com.example.satelites.Logic.ReadData;
import com.example.satelites.Model.Satellite;
import com.example.satelites.Model.SatellitesRequest;
import com.example.satelites.Model.SourceResponse;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.junit.Assert.*;

public class ReadDataTest {

    public static SatellitesRequest request;

    public static ReadData readData= new ReadData();

    @BeforeClass
    public static void init(){
        Satellite sat1 = new Satellite("sat1", 100, new String[]{"este", "mensaje", "es", "de", "prueba"});
        Satellite sat2 = new Satellite("sat2", 200, new String[]{"este", "", "es", "de", "prueba"});
        Satellite sat3 = new Satellite("sat3", 300, new String[]{"este", "mensaje", "", "de", ""});
        request = new SatellitesRequest(new Satellite[]{sat1,sat2,sat3});

    }

    @Test
    public void ReadDataDistances(){

        double[] distances = new double[]{100,200,300};
        readData.readDataSatellites(request);

        assertArrayEquals(distances, readData.getDistances(),0.5);


    }

    @Test
    public void ReadDataMessage(){

        String[][] messages = new String[][]{
                new String[]{"este", "mensaje", "es", "de", "prueba"},
                new String[]{"este", "", "es", "de", "prueba"},
                new String[]{"este", "mensaje", "", "de", ""}
        };
        readData.readDataSatellites(request);

        assertArrayEquals(messages, readData.getMessages());


    }


}
