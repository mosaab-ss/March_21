package com.ss.mar.wone.dfour;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {

    @Test
    public void getSlope() {
        Line l1 = new Line(0, 0, 1,1);
        Line l2 = new Line(0,0, 1, 0);
        Line l3 = new Line(0,0, 2, 1);

        assertEquals(1, l1.getSlope(), 0.0001);
        assertEquals(0, l2.getSlope(), 0.0001);
        assertEquals(0.5, l3.getSlope(), 0.0001);
    }

    @Test
    public void getDistance() {
        Line l1 = new Line(0, 0, 3,4);
        Line l2 = new Line(0,0, 1, 0);
        Line l3 = new Line(0,0, 2, 1);

        assertEquals(5, l1.getDistance(), 0.0001);
        assertEquals(1, l2.getDistance(), 0.0001);
        assertEquals(Math.sqrt(5), l3.getDistance(), 0.0001);
    }

    @Test
    public void parallelTo() {
        Line l1 = new Line(0, 0, 3,4);
        Line l2 = new Line(1,0, 4, 4);
        Line l3 = new Line(1,0, 4, 5);

        assertTrue(l1.parallelTo(l2));
        assertFalse(l1.parallelTo(l3));
    }
}