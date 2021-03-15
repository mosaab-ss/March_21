package com.ss.mar.wone.assignment;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecursionTest {

    @Test
    public void groupSumClump() {
        Recursion rec = new Recursion();

        int[] nums1 = {2, 4, 8};
        int[] nums2 = {1, 2, 4, 8, 1};
        int[] nums3 = {2, 4, 4, 8};

        assertTrue(rec.groupSumClump(0, nums1, 10));
        assertTrue(rec.groupSumClump(0, nums2, 14));
        assertFalse(rec.groupSumClump(0, nums3, 14));
    }
}