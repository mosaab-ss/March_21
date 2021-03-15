package com.ss.mar.wone.assignment;

import java.io.*;

/**
 * Lambda expressions performing the specified methods
 * @author Mosaab
 */
public class Lambdas {
    /**
     * "Stub code" handler
     * @param args
     */
    public static void main(String[] args) {
        Lambdas ao = new Lambdas();

        // Try-with-resource to read file
        try (BufferedReader stub = new BufferedReader(
                        new InputStreamReader(new FileInputStream(
                                "resources/stubcode/assignmentOne.txt"
                        ))
        )) {
            // Initialize str to parse lines
            String str;
            // Initialize tests as a counter
            int tests = 0;

            // Read first line
            if ((str=stub.readLine()) != null && str.length() != 0) {
                tests = Integer.parseInt(str);
            }

            // Loop over the tests/each line
            while(tests > 0 && (str=stub.readLine()) != null && str.length() != 0) {
                // Split at space
                String[] testCase = str.split(" ");

                // Found no space
                if (testCase.length < 2) {
                    System.err.println("Ignored test case, formatting error");
                }

                // Handle each check
                switch (Integer.parseInt(testCase[0])) {
                    case 1:
                        System.out.println(ao.performCheck(ao.isOdd(), Integer.parseInt(testCase[1])) ? "ODD" : "EVEN");
                        break;
                    case 2:
                        System.out.println(ao.performCheck(ao.isPrime(), Integer.parseInt(testCase[1])) ? "PRIME" : "COMPOSITE");
                        break;
                    case 3:
                        System.out.println(ao.performCheck(ao.isPalindrome(), Integer.parseInt(testCase[1])) ? "PALINDROME" : "NON-PALINDROME");
                        break;
                }

                tests--;
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        } catch (IOException e) {
            System.err.println("Couldn't read from file.");
        } catch (NumberFormatException e) {
            System.err.println("Input is incorrect");
        }
    }

    /**
     * Lambda execute
     * @param op PerformOperation method
     * @param number integer
     * @return boolean
     */
    public boolean performCheck(PerformOperation op, int number) {
        return op.operation(number);
    }

    /**
     * Checks whether a number is an even or odd number
     * @return boolean
     */
    public PerformOperation isOdd() {
        // XOR bitwise operator, first bit is always 1 if odd
        // Faster than modulus (unless compiler changes code)
        return n -> ((n ^ 1) != n+1);
    }

    /**
     * Checks whether a number is a prime or not
     * NOTE: primes are defined as positive integers
     * @return boolean
     */
    public PerformOperation isPrime() {
        return p -> {
            // Taking the absolute value of p
            int n = Math.abs(p);
            // Zero is not a prime
            if (n == 0) return false;
            // 1 and 2 are prime
            if(n < 3) return true;
            // Pre-check if even, can use isOdd too
            if((n % 2)==0) return false;
            // We check from n>2 up to sqrt(n), because [sqrt(n),n] would be a divisor if [n,sqrt(n)] is
            for (int i=3; i < Math.sqrt(n); i += 2) {
                // Check whether n is divisible by i
                if ((n % i) == 0) return false;
            }
            // Then it's prime
            return true;
        };
    }

    /**
     * Check whether a number is a palindrome or not
     * @return boolean
     */
    public PerformOperation isPalindrome() {
        return n -> {
            // Convert n to string
            StringBuilder nString = new StringBuilder().append(n);
            // check if the reverse is equal
            return nString.toString().equals(nString.reverse().toString());
        };
    }
}