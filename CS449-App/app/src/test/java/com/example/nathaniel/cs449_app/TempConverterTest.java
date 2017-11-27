package com.example.nathaniel.cs449_app;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/26/2017.
 */
public class TempConverterTest {
    @Test
    public void fah_To_cel() throws Exception {
        double fah = TempConverter.fah_To_cel(41);
        assertEquals(5, fah);
    }

    @Test
    public void cel_To_fah() throws Exception {

    }

    @Test
    public void round() throws Exception {

    }

}