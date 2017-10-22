package com.example.nathaniel.cs449_app;

/**
 * Created by Nathaniel on 10/21/2017.
 */

public class VConverter {

    //tsp conversions
    public static double tsp_to_tsp(double tsp) {
        return tsp;
    }
    public static double tsp_To_tbsp(double tsp) {
        return tsp / 3;
    }
    public static double tsp_To_oz(double tsp) {
        return tsp / 6;
    }
    public static double tsp_To_lbs(double tsp) {
        return (tsp_To_oz(tsp)) / 16;
    }
    public static double tsp_To_cup(double tsp) {
        return (tsp_To_tbsp(tsp)) / 16;
    }
    public static double tsp_To_pint(double tsp) {
        return (tsp_To_cup(tsp) / 2);
    }
    public static double tsp_To_quart(double tsp) {
        return (tsp_To_cup(tsp) / 4);
    }
    public static double tsp_To_gallon(double tsp) {
        return (tsp_To_quart() / 4);
    }

    //tbsp conversions
    public static double tbsp_To_tsp(double tbsp){
        return tbsp * 3;
    }
    public static double tbsp_To_tbsp(double tbsp) {
        return tbsp;
    }
}
