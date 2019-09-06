package com.ania.training;

import org.junit.Test;

import static org.junit.Assert.*;

public class BicycleTest {

    @Test
    public void getWheels() {
        //aktorzy
        Bicycle bicycle = new Bicycle();

        //aktorzy graja
        int result = bicycle.getWheels();

        //prownanie spodziewanego wyniku z otrzymanym
        assertEquals(2, result);

    }
}