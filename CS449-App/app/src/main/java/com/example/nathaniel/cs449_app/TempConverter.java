package com.example.nathaniel.cs449_app;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Nathaniel on 10/22/2017.
 */

class TempConverter {
    public static double fah_To_cel(double fah) {
        return ((fah - 32.0) * (5.0/9.0));
    }

    public static double cel_To_fah(double cel) {
        return (cel * (9.0/5.0)) + 32.0;
    }


    // Rounding function from Forum on StackOverflow @
    // https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places

    public static double Round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
