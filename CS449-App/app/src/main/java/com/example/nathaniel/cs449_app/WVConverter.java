package com.example.nathaniel.cs449_app;

/**
 * Created by Nathaniel on 10/21/2017.
 */

class VConverter {

    //tsp conversions
    public static double tsp_To_tsp(double tsp) {
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
        return (tsp_To_quart(tsp) / 4);
    }

    //tbsp conversions
    public static double tbsp_To_tsp(double tbsp){
        return tbsp * 3;
    }
    public static double tbsp_To_tbsp(double tbsp) {
        return tbsp;
    }
    public static double tbsp_To_oz(double tbsp){
        return tbsp / 2;
    }
    public static double tbsp_To_lbs(double tbsp){
        return tbsp_To_oz(tbsp) / 16;
    }
    public static double tbsp_To_cup(double tbsp){
        return tbsp / 16;
    }
    public static double tbsp_To_pint(double tbsp){
        return tbsp_To_cup(tbsp) / 2;
    }
    public static double tbsp_To_quart(double tbsp){
        return tbsp_To_pint(tbsp) / 2;
    }
    public static double tbsp_To_gallon(double tbsp){
        return tbsp_To_quart(tbsp) / 4;
    }

    //fluid oz. conversions
    public static double oz_To_tsp(double oz){
        return oz * 6;
    }
    public static double oz_To_tbsp(double oz){
        return oz * 2;
    }
    public static double oz_To_oz(double oz){
        return oz;
    }
    public static double oz_To_lbs(double oz){
        return oz / 16;
    }
    public static double oz_To_cup(double oz){
        return oz / 8;
    }
    public static double oz_To_pint(double oz){
        return oz_To_cup(oz) / 2;
    }
    public static double oz_To_quart(double oz){
        return oz_To_pint(oz) / 2;
    }
    public static double oz_To_gallon(double oz){
        return oz_To_quart(oz) / 4;
    }

    //fluid lbs. conversions
    public static double lbs_To_tsp(double lbs){
        return (2 * (lbs * 16)) * 3;
    }
    public static double lbs_To_tbsp(double lbs){
        return 2 * (lbs * 16);
    }
    public static double lbs_To_oz(double lbs){
        return lbs * 16;
    }
    public static double lbs_To_lbs(double lbs){
        return lbs;
    }
    public static double lbs_To_cup(double lbs){
        return lbs * 2;
    }
    public static double lbs_To_pint(double lbs){
        return lbs; // 16 fluid oz. == pint
    }
    public static double lbs_To_quart(double lbs){
        return lbs / 2;
    }
    public static double lbs_To_gallon(double lbs){
        return lbs / 8;
    }

    // cup conversions
    public static double cup_To_tsp(double cup){
        return 48 * cup;
    }
    public static double cup_To_tbsp(double cup){
        return cup * 16;
    }
    public static double cup_To_oz(double cup){
        return cup * 8;
    }
    public static double cup_To_lbs(double cup){
        return cup / 2;
    }
    public static double cup_To_cup(double cup){
        return cup;
    }
    public static double cup_To_pint(double cup){
        return cup / 2;
    }
    public static double cup_To_quart(double cup){
        return cup / 4;
    }
    public static double cup_To_gallon(double cup){
        return cup / 8;
    }

    // pint conversions;
    public static double pint_To_tsp(double pint){
        return ((pint * 2) * 16) * 3;
    }
    public static double pint_To_tbsp(double pint){
        return (pint * 2) * 16;
    }
    public static double pint_To_oz(double pint){
        return (pint * 2) * 8;
    }
    public static double pint_To_lbs(double pint){
        return pint; // 16 fluid oz. == pint
    }
    public static double pint_To_cup(double pint){
        return pint * 2;
    }
    public static double pint_To_pint(double pint){
        return pint;
    }
    public static double pint_To_quart(double pint){
        return pint / 2;
    }
    public static double pint_To_gallon(double pint){
        return pint / 8;
    }

    // quart conversions
    public static double quart_To_tsp(double quart){
        return ((quart * 4) * 16) * 3;
    }
    public static double quart_To_tbsp(double quart){
        return (quart * 4) * 16;
    }
    public static double quart_To_oz(double quart){
        return (quart * 4) * 8;
    }
    public static double quart_To_lbs(double quart){
        return quart * 2;
    }
    public static double quart_To_cup(double quart){
        return quart * 4;
    }
    public static double quart_To_pint(double quart){
        return quart * 2;
    }
    public static double quart_To_quart(double quart){
        return quart;
    }
    public static double quart_To_gallon(double quart){
        return quart / 4;
    }

    // gallon conversions
    public static double gallon_To_tsp(double gallon){
        return ((((gallon * 4) * 2) * 2) * 16) * 3;
    }
    public static double gallon_To_tbsp(double gallon){
        return (((gallon * 4) * 2) * 2) * 16;
    }
    public static double gallon_To_oz(double gallon){
        return (((gallon * 4) * 2) * 2) * 8;
    }
    public static double gallon_To_lbs(double gallon){
        return (gallon * 4) * 2;
    }
    public static double gallon_To_cup(double gallon){
        return ((gallon * 4) * 2) * 2;
    }
    public static double gallon_To_pint(double gallon){
        return (gallon * 4) * 2;
    }
    public static double gallon_To_quart(double gallon){
        return gallon * 4;
    }
    public static double gallon_To_gallon(double gallon){
        return gallon;
    }
}


