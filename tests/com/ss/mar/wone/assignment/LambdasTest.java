package com.ss.mar.wone.assignment;

import org.junit.Test;

import static org.junit.Assert.*;

public class LambdasTest {
    private Lambdas ao = new Lambdas();

    @Test
    public void isOdd() {
        assertTrue(ao.performCheck(ao.isOdd(), 19));

        assertFalse(ao.performCheck(ao.isOdd(), 18));
    }

    @Test
    public void isPrime() {
        assertTrue(ao.performCheck(ao.isPrime(), 19));
        assertTrue(ao.performCheck(ao.isPrime(), 1368677987));

        assertFalse(ao.performCheck(ao.isPrime(), 18));
    }

    @Test
    public void isPalindrome() {
        assertTrue(ao.performCheck(ao.isPalindrome(), 12321));
        assertTrue(ao.performCheck(ao.isPalindrome(), 123321));

        assertFalse(ao.performCheck(ao.isPalindrome(), 12345));
    }
}