package com.ss.mar.wone.done;

/**
 * Create different star patterns and print to stdout
 * @author Mosaab
 */
public class StarPattern {
    /**
     * Executes the different pattern generating methods
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Downward pattern:");
        downPattern(6);

        System.out.println("Upward pattern:");
        upPattern(7);

        System.out.println("Pyramid pattern:");
        upPyramid(5);

        System.out.println("Inverse pyramid pattern:");
        downPyramid(7);
    }

    /**
     * Generate a downward expanding star pattern
     * @param lines positive integer of lines to generate a pattern up to
     */
    public static void downPattern(Integer lines) {
        for (int i = 1; i <= lines; i++) {
            // Using String::repeat() to build the string
            System.out.println("*".repeat(i));
        }
    }

    /**
     * Generate an upward expanding star pattern
     * @param lines positive integer of lines to generate a pattern up to
     */
    public static void upPattern(Integer lines) {
        // demonstrating how to implement a reverse loop by only manipulating the logic
        for (int i = 0; i < lines; i++) {
            System.out.println("*".repeat(lines - i));
        }
    }

    /**
     * Generate a pyramid type star pattern
     * @param lines positive integer of lines to generate a pattern up to
     */
    public static void upPyramid(Integer lines) {
        for (int i = 1; i <= lines; i++) {
            // "caching" the spaces in case we need to use again
            String spaces = " ".repeat(lines - i);
            // using 2n-1 sequence to produce the pattern: 1,3,5...
            System.out.println(spaces + "*".repeat(i*2 - 1)); // Can add + spaces at the end of the concat
        }
    }

    /**
     * Generate an inverse pyramid type star pattern
     * @param lines positive integer of lines to generate a pattern up to
     */
    public static void downPyramid(Integer lines) {
        for (int i = lines; i > 0; i--) {
            String spaces = " ".repeat(lines - i);
            System.out.println(spaces + "*".repeat(i*2 - 1)); // Can add + spaces at the end of the concat
        }
    }
}
