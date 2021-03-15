package com.ss.mar.wone.dfive;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Basic lambda operations for sorting
 * @author Mosaab
 */
public class BasicLambda {
    /**
     * Creates a string array and applies different sort operations then prints the array each time
     * @param args cmdline args
     */
    public static void main(String[] args) {
        BasicLambda bl = new BasicLambda();
        String[] cities = {"Baton Rouge", "Indianapolis", "Columbus", "Montgomery", "Helena", "Denver", "Boise", "Austin", "Everett", "Evansville", "Eugene", "Escondido"};

        // Sort by length
        Arrays.sort(cities, Comparator.comparingInt(String::length));
        // Not lambda, but works the same as:
        //Arrays.sort(cities, (s1, s2) -> s1.length() - s2.length());
        bl.printArray(cities);

        // Sort by reverse length
        Arrays.sort(cities, (s1, s2) -> s2.length() - s1.length());
        bl.printArray(cities);

        // Sort alphabetically (first letter)
        Arrays.sort(cities, Comparator.comparingInt(s -> s.charAt(0)));
        // Same as:
        //Arrays.sort(cities, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
        bl.printArray(cities);

        // Sort first if contains e
        Arrays.sort(cities, (s1, s2) -> {
            if ('e' == s1.toLowerCase().charAt(0)) return -1;
            else if ('e' == s2.toLowerCase().charAt(0)) return 1;
            else return 0;
        });
        bl.printArray(cities);

        // Sort first if contains e (improved)
        Arrays.sort(cities, (s1, s2) -> sortByCharInsensitive(s1, s2, 'e'));
        bl.printArray(cities);
    }

    /**
     * Sort helper based on character (case insensitive)
     * @param e1 first element
     * @param e2 second element
     * @param character character to sort by
     * @return integer used by the sort algorithm
     */
    private static int sortByCharInsensitive(String e1, String e2, char character) {
        if (character == e1.toLowerCase().charAt(0)) return -1;
        else if (character == e2.toLowerCase().charAt(0)) return 1;
        else return 0;
    }

    /**
     * Prints a given String array
     * @param array string array
     */
    private void printArray(String[] array) {
        for (String element : array) {
            System.out.println(element);
        }

        System.out.println();
    }

}
