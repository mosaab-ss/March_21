package com.ss.mar.wone.assignment;

/**
 * Solves the following question using recursion
 * Given an array of ints, is it possible to choose a group of some of the ints,
 * such that the group sums to the given target, with this additional constraint:
 * if there are numbers in the array that are adjacent and the identical value,
 * they must either all be chosen, or none of them chosen. For example,
 * with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not,
 * all as a group. (one loop can be used to find the extent of the identical values).
 * @author Mosaab
 */
public class Recursion {
    /**
     * Test if it is possible to choose a group of elements that sum to target
     * @param start start index
     * @param numbers array of numbers
     * @param target target sum
     * @return boolean
     */
    public boolean groupSumClump(int start, int[] numbers, int target) {
        // Return out of the recursion
        if (start >= numbers.length) {
            // test whether we reached the end of a consecutive clump
            return target == 0;
        }

        int i = start;
        // prepare for clump
        int result = 0;
        while (i < numbers.length && numbers[start] == numbers[i]) {
            result += numbers[i];
            i++;
        }

        // Return from clump sum or regular sum
        return groupSumClump(i, numbers, target - result) || groupSumClump(i, numbers, target);
    }
}
