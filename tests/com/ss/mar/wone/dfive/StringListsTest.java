package com.ss.mar.wone.dfive;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StringListsTest {

    @Test
    public void specificCondition() {
        StringLists sl = new StringLists();


        String[] testStrings = {"Test", "abc", "Arrays", "art", "Ant"};
        List<String> strList = Arrays.asList(testStrings);

        List<String> results = sl.specificCondition(strList);

        System.out.println(results.get(0));
        assertEquals("abc", results.get(0));
        System.out.println(results.get(1));
        assertEquals("art", results.get(1));
    }
}