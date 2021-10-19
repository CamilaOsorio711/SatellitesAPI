package com.example.satelites.Logic;

import com.example.satelites.Model.SourceResponse;
import com.example.satelites.Model.Position;
import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;

import com.lemmingapex.trilateration.TrilaterationFunction;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer.Optimum;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;

/**
 * @author Camila Osorio
 * Clase para encontrar la posicion x y de la fuente del mensaje
 * Se utiliza la libreria de maven lemmingapex.trilateration que dado una posiciones y distancias
 * calcula la posicion x y.
 */

public class Localization {

    Position position = new Position();

    /**
     * Metodo encargado de realizar la trilateracion dado la posicion inicial de los satelites y las distancias
     * @param distances distancias de cada satelite a la fuente
     * @return Objeto Position que contiene las coordenadas x y
     */
    public Position getLocation(double... distances){

        double[][] positions = new double[][] { { -500, -200 }, { 100, -100 }, { 500,100 }};

        NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(new TrilaterationFunction(positions, distances), new LevenbergMarquardtOptimizer());
        Optimum optimum = solver.solve();

        double[] centroid = optimum.getPoint().toArray();

        position.setX(centroid[0]);
        position.setY(centroid[1]);

        return position;

    }
}
