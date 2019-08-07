package com.lmchoi.ds;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SortingAlgosTest {

    @Parameterized.Parameters
    public static Object[] data() {
        return new SortingAlgo[] {
                new InsertionSort(),
                new CountingSort()
        };
    }

    private final SortingAlgo algo;

    public SortingAlgosTest(SortingAlgo algo) {
        this.algo = algo;
    }

    @Test
    public void testSortReversed() {
        Comparable[] arr = new Integer[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10 - i - 1;
        }

        algo.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            assertThat(arr[i], is(i));
        }
    }

    @Test
    public void testSortShuffled() {
        Comparable[] arr = {10, 6, 7, 9};
        Comparable[] expected = {6, 7, 9, 10};

        algo.sort(arr);

        assertThat(arr, is(expected));
    }
}
