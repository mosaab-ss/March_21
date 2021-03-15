package com.ss.mar.wone.assignment;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Methods to work with Lists
 * @author Mosaab
 */
public class FunctionalLists {
    /**
     *
     * @param input List of Integers
     * @param op IntegerOperations lambda method
     * @return Modified Integer List
     */
    public List<Integer> performInt(List<Integer> input, IntegerOperations op) {
        return input.stream().map(op::operate).collect(Collectors.toList());
    }

    /**
     * Perform a string lambda operation on a list
     * @param input List of strings
     * @param op StringOperations lambda method
     * @return Modified String List
     */
    public List<String> performStr(List<String> input, StringOperations op) {
        return input.stream().map(op::operate).collect(Collectors.toList());
    }

    /**
     * Get the right most digit
     * @return IntegerOperations lambda
     */
    public IntegerOperations rightDigit() {
        return p -> p % 10;
    }

    /**
     * Double the integers
     * @return IntegerOperations lambda
     */
    public IntegerOperations doubling() {
        return p -> p * 2;
    }

    /**
     * Remove any occurrence of x
     * @return StringOperations lambda
     */
    public StringOperations noX() {
        return p -> p.replaceAll("x", "");
    }
}