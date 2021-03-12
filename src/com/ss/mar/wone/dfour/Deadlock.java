package com.ss.mar.wone.dfour;

import com.ss.mar.wone.dtwo.Circle;

/**
 * Example of how a deadlock might happen
 * @author Mosaab
 */
public class Deadlock {
    /**
     * Start 2 threads that happen to be deadlock threads
     * @param args
     */
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(7);

        System.out.println("Started main Thread...");
        Runnable thread1 = () -> {
            try {
                synchronized (circle1) {
                    Thread.sleep(250);
                    synchronized (circle2) {
                        System.out.println("Thread 1 locked both objects");
                    }
                }
            } catch (InterruptedException e) {
                System.err.println("Error creating thread.");
            }
        };

        Runnable thread2 = () -> {
            try {
                synchronized (circle2) {
                    Thread.sleep(250);
                    synchronized (circle1) {
                        System.out.println("Thread 2 locked both objects");
                    }
                }
            } catch (InterruptedException e) {
                System.err.println("Error creating thread.");
            }
        };

        new Thread(thread1).start();
        new Thread(thread2).start();

        System.out.println("End of main thread.");
    }
}
