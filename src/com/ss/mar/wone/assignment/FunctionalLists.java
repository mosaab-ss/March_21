package com.ss.mar.wone.assignment;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Methods to work with Lists
 * @author Mosaab
 */
public class FunctionalLists {
    /**
     * Get the right most digit
     * @param numbers list of integers
     * @return list of integers
     */
    public List<Integer> rightDigit(List<Integer> numbers) {
        return numbers.stream().map(p -> p % 10).collect(Collectors.toList());
    }

    /**
     * Double the integers
     * @param numbers list of integers
     * @return list of integers
     */
    public List<Integer> doubling(List<Integer> numbers) {
        return numbers.stream().map(p -> p * 2).collect(Collectors.toList());
    }

    /**
     * Remove any occurrence of x
     * @param numbers list of strings
     * @return list of strings
     */
    public List<String> noX(List<String> numbers) {
        return numbers.stream().map(p -> p.replaceAll("x", "")).collect(Collectors.toList());
    }
}
