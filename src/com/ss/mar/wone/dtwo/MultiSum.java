package com.ss.mar.wone.dtwo;

import java.util.Scanner;

/**
 * Computes the sum from multiple string inputs
 * @author Mosaab
 */
public class MultiSum {
    public Double runningTotal = 0.0;

    /**
     * Invokes the sum() function from commandline arguments, or asks the user for a running sum input
     * @param args array of strings from cmdline
     */
    public static void main(String[] args) {
        // Initiates a MultiSum object
        MultiSum userSum = new MultiSum();

        // Check for argument input
        if (args.length > 1) { // Summing arguments from cmdline
            for (String num : args) {
                // Add sum to the sum object
                userSum.sum(parseArg(num));
            }

            System.out.println("Total is "+ userSum.runningTotal);
        } else { // Running total mode
            // Initializing a scanner for user input
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter numbers for a running total.");
            System.out.println("To terminate, press enter without entering anything.");

            String input = null;
            // This is a hack-ey way of assigning the variable and accessing it within a conditional
            while (!(input = scan.nextLine()).isEmpty()) {
                // Add sum to the sum object
                userSum.sum(parseArg(input));

                System.out.println("Running total: "+ userSum.runningTotal);
            }
        }
    }

    /**
     * Parses strings containing numbers into double, handling exceptions
     * @param arg string containing a number
     * @return Double type number
     */
    public static Double parseArg(String arg) {
        try {
            // Try parsing
            return Double.parseDouble(arg);
        } catch (NumberFormatException e) {
            // Parsing failed, something must be wrong in the String passed
            System.out.println("Input must be a number.");

            // Return 0 to keep the running sum going
            return (Double) 0.0;
        }
    }

    /**
     * Sums the input with the field from the current object
     * @param num a Double number
     */
    public void sum(Double num) {
        this.runningTotal += num;
    }
}
