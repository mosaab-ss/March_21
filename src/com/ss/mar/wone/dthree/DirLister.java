package com.ss.mar.wone.dthree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Lists all files and folders recursively under a path
 * @author Mosaab
 */
public class DirLister {
    /**
     * Takes input from cmdline args and invokes the path printer function
     * @param args first argument must be a path to list, use "" when necessary
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You must input a directory path.");
            return;
        }

        try {
            printDir(Paths.get(args[0]));
        } catch (IOException | SecurityException | IllegalArgumentException e) {
            System.out.println("Path is not valid.");
        }
    }

    /**
     * Walks through the given path and prints every file and directory recursively
     * @param path the path of the directory to navigate
     * @throws IOException file IO
     * @throws SecurityException file permission
     * @throws IllegalArgumentException from relativize, if other isn't a path
     */
    public static void printDir(Path path) throws IOException, SecurityException, IllegalArgumentException  {
        try (Stream<Path> paths = Files.walk(path)) {
            System.out.println("Listing "+ path.getFileName() +":");

            // Lambda foreach function to loop over each path
            paths.forEach(file -> {
                if (Files.isDirectory(file)) {
                    System.out.println(path.relativize(file));
                } else if (Files.isRegularFile(file)) {
                    System.out.println("| "+ file.getFileName());
                }
            });
        }
    }
}
