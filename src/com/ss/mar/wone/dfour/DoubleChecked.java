package com.ss.mar.wone.dfour;

/**
 * Double Checked Singleton
 * @author Mosaab
 */
public class DoubleChecked {

    // Declare a volatile instance field
    volatile private static DoubleChecked inst = null;

    /**
     * Private constructor to prevent additional init
     */
    private DoubleChecked() {}

    /**
     * Getter function for the Singleton object
     * @return DoubleChecked object instance
     */
    public static DoubleChecked getInst() {
        // First check
        if (inst == null) {
            // Locking
            synchronized (DoubleChecked.class) {
                // Double check
                if (inst == null) {
                    // Init object
                    inst = new DoubleChecked();
                }
            }
        }

        // Finally return instance
        return inst;
    }
}
