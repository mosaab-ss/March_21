package com.ss.mar.wone.dfour;

import java.util.ArrayList;

/**
 * Producer thread that attaches to a queue
 * @author Mosaab
 */
public class Producer implements Runnable {
    private final ArrayList<Integer> QUEUE;
    private final int SIZE;

    /**
     * constructor
     * @param sharedQueue a queue that is shared between producer and consumer
     * @param size the size of the queue buffer
     */
    public Producer(ArrayList<Integer> sharedQueue, int size) {
        this.QUEUE = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Item produced");
            try {
                produce(i);
            } catch (InterruptedException ex) {
                System.err.println("Thread interrupted");
            }

        }
    }

    /**
     * Produce an item
     * @param i the item to produce into the queue
     * @throws InterruptedException if the thread is interrupted
     */
    private void produce(int i) throws InterruptedException {
        while (QUEUE.size() == SIZE) {
            synchronized (QUEUE) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting...");
                System.out.println("Size: " + QUEUE.size());
                QUEUE.wait();
            }
        }

        synchronized (QUEUE) {
            QUEUE.add(i);
            QUEUE.notifyAll();
        }
    }
}