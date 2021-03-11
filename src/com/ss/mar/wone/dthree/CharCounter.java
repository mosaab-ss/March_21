package com.ss.mar.wone.dthree;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Counts the occurrence of a specific character in a file
 * @author Mosaab
 */
public class CharCounter {
    /**
     * Takes path input from cmdline and asks user to provide the character
     * @param args path to file
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You must specify a target file.");
            return;
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the character to count occurrences of:");
        char character = scan.next().charAt(0);

        System.out.println("Counting occurrences of "+ character +"...");

        try {
            System.out.println("The number of occurrences: " + occurrencesOfCharacter(args[0], character));
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    /**
     * Reads the file from the provided path and counts the number of times the character appears in the text
     * @param path path to file
     * @param character character to count for
     * @return number of occurrences of the character in the given file
     */
    public static int occurrencesOfCharacter(String path, char character) throws IOException {
        int occurrences = 0;

        try(FileReader in = new FileReader(path)) {
            int c;
            while((c = in.read()) != -1){
                if (c == character)
                    occurrences++;
            }
        } catch (Exception e) {
            System.err.println("Error reading file.");
        }

        return occurrences;
    }
}
