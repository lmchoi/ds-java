package com.lmchoi.ds;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CountingSort extends SortingAlgo {
    @Override
    public void sort(Comparable[] arr) {
        Map<Comparable, Integer> counter = new TreeMap<>();

        for (Comparable value : arr) {
            Integer count = counter.getOrDefault(value, 0);
            counter.put(value, count + 1);
        }

        int i = 0;
        for (Map.Entry<Comparable, Integer> entry : counter.entrySet()) {
            Comparable value = entry.getKey();
            int count = entry.getValue();

            Arrays.fill(arr, i, i + count, value);

            i += count;
        }
    }
}
