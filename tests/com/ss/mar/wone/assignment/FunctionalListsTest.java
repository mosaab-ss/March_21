package com.ss.mar.wone.assignment;

import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FunctionalListsTest {

    FunctionalLists fl = new FunctionalLists();

    @Test
    public void rightDigit() {
        List<Integer> firstCured = fl.rightDigit(Arrays.asList(1, 22, 93));
        List<Integer> secondCured = fl.rightDigit(Arrays.asList(16, 8, 886, 8, 1));
        List<Integer> thirdCured = fl.rightDigit(Arrays.asList(10, 0));


        List<Integer> firstExpect = Arrays.asList(1, 2, 3);
        List<Integer> secondExpect = Arrays.asList(6, 8, 6, 8, 1);
        List<Integer> thirdExpect = Arrays.asList(0, 0);

        assertTrue(assertIntegerList(firstExpect, firstCured));
        assertTrue(assertIntegerList(secondExpect, secondCured));
        assertTrue(assertIntegerList(thirdExpect, thirdCured));
    }

    @Test
    public void doubling() {
        List<Integer> firstCured = fl.doubling(Arrays.asList(1, 2, 3));
        List<Integer> secondCured = fl.doubling(Arrays.asList(6, 8, 6, 8, -1));
        List<Integer> thirdCured = fl.doubling(Arrays.asList());


        List<Integer> firstExpect = Arrays.asList(2, 4, 6);
        List<Integer> secondExpect = Arrays.asList(12, 16, 12, 16, -2);
        List<Integer> thirdExpect = Arrays.asList();

        assertTrue(assertIntegerList(firstExpect, firstCured));
        assertTrue(assertIntegerList(secondExpect, secondCured));
        assertTrue(assertIntegerList(thirdExpect, thirdCured));
    }

    @Test
    public void noX() {
        List<String> firstCured = fl.noX(Arrays.asList("ax", "bb", "cx"));
        List<String> secondCured = fl.noX(Arrays.asList("xxax", "xbxbx", "xxcx"));
        List<String> thirdCured = fl.noX(Arrays.asList("x"));


        List<String> firstExpect = Arrays.asList("a", "bb", "c");
        List<String> secondExpect = Arrays.asList("a", "bb", "c");
        List<String> thirdExpect = Arrays.asList("");

        assertTrue(assertStringList(firstExpect, firstCured));
        assertTrue(assertStringList(secondExpect, secondCured));
        assertTrue(assertStringList(thirdExpect, thirdCured));
    }

    private boolean assertIntegerList(List<Integer> l1, List<Integer> l2) {
        return(l1.size() == l2.size() && l1.containsAll(l2) && l2.containsAll(l1));
    }

    private boolean assertStringList(List<String> l1, List<String> l2) {
        return(l1.size() == l2.size() && l1.containsAll(l2) && l2.containsAll(l1));
    }
}