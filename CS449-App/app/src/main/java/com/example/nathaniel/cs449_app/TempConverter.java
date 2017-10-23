package com.example.nathaniel.cs449_app;

/**
 * Created by Nathaniel on 10/22/2017.
 */

public class TempConverter {
    public static double fah_To_cel(double fah) {
        return ((fah - 32) * (5/9));
    }

    public static double cel_To_fah(double cel) {
        return (cel * (9/5)) + 32;
    }
}
