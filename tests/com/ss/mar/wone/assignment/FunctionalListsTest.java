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
        List<Integer> firstCured = fl.performInt(Arrays.asList(1, 22, 93), fl.rightDigit());
        List<Integer> secondCured = fl.performInt(Arrays.asList(16, 8, 886, 8, 1), fl.rightDigit());
        List<Integer> thirdCured = fl.performInt(Arrays.asList(10, 0), fl.rightDigit());


        List<Integer> firstExpect = Arrays.asList(1, 2, 3);
        List<Integer> secondExpect = Arrays.asList(6, 8, 6, 8, 1);
        List<Integer> thirdExpect = Arrays.asList(0, 0);

        assertTrue(assertIntegerList(firstExpect, firstCured));
        assertTrue(assertIntegerList(secondExpect, secondCured));
        assertTrue(assertIntegerList(thirdExpect, thirdCured));
    }

    @Test
    public void doubling() {
        List<Integer> firstCured = fl.performInt(Arrays.asList(1, 2, 3), fl.doubling());
        List<Integer> secondCured = fl.performInt(Arrays.asList(6, 8, 6, 8, -1), fl.doubling());
        List<Integer> thirdCured = fl.performInt(Arrays.asList(), fl.doubling());


        List<Integer> firstExpect = Arrays.asList(2, 4, 6);
        List<Integer> secondExpect = Arrays.asList(12, 16, 12, 16, -2);
        List<Integer> thirdExpect = Arrays.asList();

        assertTrue(assertIntegerList(firstExpect, firstCured));
        assertTrue(assertIntegerList(secondExpect, secondCured));
        assertTrue(assertIntegerList(thirdExpect, thirdCured));
    }

    @Test
    public void noX() {
        List<String> firstCured = fl.performStr(Arrays.asList("ax", "bb", "cx"), fl.noX());
        List<String> secondCured = fl.performStr(Arrays.asList("xxax", "xbxbx", "xxcx"), fl.noX());
        List<String> thirdCured = fl.performStr(Arrays.asList("x"), fl.noX());


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