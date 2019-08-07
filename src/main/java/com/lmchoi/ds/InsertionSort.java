package com.lmchoi.ds;

public class InsertionSort extends SortingAlgo {
    @Override
    public void sort(Comparable[] arr) {
        if (arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                Comparable previous = arr[j - 1];
                Comparable current = arr[j];
                if (previous.compareTo(current) > 0) {
                    arr[j - 1] = current;
                    arr[j] = previous;
                }
            }
        }
    }
}
