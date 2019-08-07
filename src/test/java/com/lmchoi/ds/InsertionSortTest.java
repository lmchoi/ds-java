package com.lmchoi.ds;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InsertionSortTest {
    @Test
    public void testSortReversed() {
        InsertionSort insertionSort = new InsertionSort();
        Comparable[] arr = new Integer[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10 - i - 1;
        }

        insertionSort.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            assertThat(arr[i], is(i));
        }
    }

    @Test
    public void testSortShuffled() {
        InsertionSort insertionSort = new InsertionSort();
        Comparable[] arr = {10, 6, 7, 9};
        Comparable[] expected = {6, 7, 9, 10};

        insertionSort.sort(arr);

        assertThat(arr, is(expected));
    }
}
