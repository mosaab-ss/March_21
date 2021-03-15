package com.ss.mar.wone.dfive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates List streams
 * @author Mosaab
 */
public class ArrayStream {
    /**
     * Passes a list of numbers to be processed by clarifyOddEven
     * @param args
     */
    public static void main(String[] args) {
        ArrayStream arrS = new ArrayStream();

        List<Integer> nums = new ArrayList<>();

        for (int i=0; i < 10; i++) {
            nums.add(i);
        }

        System.out.println(arrS.clarifyOddEven(nums));
    }

    /**
     * Prepends o or e if the number is odd or even respectively
     * @param numbers List of numbers
     * @return comma joined string
     */
    private String clarifyOddEven(List<Integer> numbers) {
        List<String> clarified = numbers.stream().map(n -> {
            if ((n ^ 1) == n + 1) {
                return "e"+n;
            } else {
                return "o"+n;
            }
        }).collect(Collectors.toList());

        return String.join(",", clarified);
    }
}
