package com.ss.mar.wone.dfour;

import java.util.ArrayList;

/**
 * Consumer thread that attaches to a queue
 * @author Mosaab
 */
public class Consumer implements Runnable {
    private final ArrayList<Integer> QUEUE;
    private final int SIZE;

    /**
     * constructor
     * @param sharedQueue a queue that is shared between producer and consumer
     * @param size the size of the queue buffer
     */
    public Consumer(ArrayList<Integer> sharedQueue, int size) {
        this.QUEUE = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Item consumed: "+ consume());
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.err.println("Thread interrupted");
            }

        }
    }

    /**
     * Consume an item
     * @return an item from the queue
     * @throws InterruptedException if the thread is interrupted
     */
    private int consume() throws InterruptedException {
        while (QUEUE.isEmpty()) {
            synchronized (QUEUE) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting...");
                System.out.println("size: " + QUEUE.size());
                QUEUE.wait();
            }
        }

        synchronized (QUEUE) {
            QUEUE.notifyAll();
            return (Integer) QUEUE.remove(0);
        }
    }
}