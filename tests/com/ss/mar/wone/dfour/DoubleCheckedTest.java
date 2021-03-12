package com.ss.mar.wone.dfour;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleCheckedTest {

    @Test
    public void getInstWithoutDelay() {
        DoubleChecked inst1 = DoubleChecked.getInst();
        DoubleChecked inst2 = DoubleChecked.getInst();

        assertEquals(inst1, inst2);
    }

    @Test
    public void getInstWithDelay() {
        try {
            DoubleChecked inst1 = DoubleChecked.getInst();
            Thread.sleep(100);

            DoubleChecked inst2 = DoubleChecked.getInst();

            assertEquals(inst1, inst2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}