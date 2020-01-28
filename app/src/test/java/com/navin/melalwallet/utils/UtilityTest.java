package com.navin.melalwallet.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilityTest {

    Utility utility = new Utility();

    @Test
    public void getMin() {




        assertEquals(utility.getMin(3,3),3);


    }

    @Test
    public void getZoj() {

        assertTrue(utility.getZoj(2));

    }
}