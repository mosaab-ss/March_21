package com.ss.mar.wone.dthree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * Append text to another existing file
 * @author Mosaab
 */
public class AppendText {
    /**
     * Takes user input and runs app
     * @param args path to file to append to
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You must provide a valid path.");
            return;
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter line to append to file:");
        String data = scan.nextLine();

        // Append user input to the file from cmdline
        appendFile(data, args[0]);
    }

    /**
     * Appends String to the given file in path
     * @param data string containing data
     * @param path string of path to file
     */
    public static void appendFile(String data, String path) {
        try {
            Files.write(Paths.get(path), data.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Append successful!");
        } catch (IOException | SecurityException e) {
            System.err.println("Error appending to file.");
        }
    }
}
