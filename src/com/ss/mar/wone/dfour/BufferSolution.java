package com.ss.mar.wone.dfour;

import java.util.ArrayList;

/**
 * Example for Producer-Consumer problem
 * @author Mosaab
 */
public class BufferSolution {
    /**
     * Starts 2 threads as producer and consumer add more than the size of the buffer
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> buffer = new ArrayList<Integer>();

        Thread threadProducer = new Thread(new Producer(buffer, 6), "Producer Thread");
        Thread threadConsumer = new Thread(new Consumer(buffer, 6), "Consumer Thread");

        threadProducer.start();
        threadConsumer.start();
    }
}