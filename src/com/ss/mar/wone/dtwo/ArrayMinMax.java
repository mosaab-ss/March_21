package com.ss.mar.wone.dtwo;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Constructs a 2D array and returns the index of the max value
 * @author Mosaab
 */
public class ArrayMinMax {
    /**
     * Generates a 2D array and invokes FindMax() function to return the index
     * @param args
     */
    public static void main(String[] args) {
        int[][] exampleArray = generateRandomArray(7, 0, 100);

        // Printing the generated 2D array
        System.out.println(Arrays.deepToString(exampleArray));

        int[] indexOfMax = maxTwoDArray(exampleArray);

        System.out.println("The max value occurs at {"+ indexOfMax[0] +", "+ indexOfMax[1] +"}");
    }

    /**
     * Generates a 2D int array with random values within the parameters
     * @param rows number of rows in the array
     * @param min minimum number for RNG
     * @param max maximum number for RNG
     * @return int[][] 2D array initialized with RNG
     */
    public static int[][] generateRandomArray(int rows, int min, int max) {
        int[][] generatedArray = new int[rows][2];

        // Loop over array and assign a RNG from [min-max] into each cell
        for (int i=0; i < generatedArray.length; i++) {
            generatedArray[i][0] = ThreadLocalRandom.current().nextInt(min, max+1);
            generatedArray[i][1] = ThreadLocalRandom.current().nextInt(min, max+1);
        }

        return generatedArray;
    }

    /**
     * Loops through a 2D array and returns the index of the max value
     * @param twoDArray 2D array of int
     * @return index of the max value
     */
    public static int[] maxTwoDArray(int[][] twoDArray) {
        // Initializing max index to the first element
        int[] maxIndex = {0, 0};

        // Looping through 2D array
        for (int i=0; i < twoDArray.length; i++) {
            for (int j=0; j < twoDArray[i].length; j++) {
                // if current > prev
                if (twoDArray[i][j] > twoDArray[maxIndex[0]][maxIndex[1]]) {
                    maxIndex[0] = i;
                    maxIndex[1] = j;
                }
            }
        }

        return maxIndex;
    }
}
