package com.lmchoi.ds;
import java.util.Arrays;

public class UnionFind {
    private final int[] unions;
    private final int[] unionSize;

    private static final boolean PRINT_DEBUG = true;

    public UnionFind(final int n) {
        unions = new int[n];
        unionSize = new int[n];
        for (int i = 0; i < n; i++) {
            unions[i] = i;
            unionSize[i] = 1;
        }
    }

    public void merge(final int a, final int b) {
        final int ra = findRoot(a);
        final int rb = findRoot(b);

        if (unionSize[ra] > unionSize[rb]) {
            unions[rb] = ra;
            unionSize[ra] += unionSize[rb];
        } else {
            unions[ra] = rb;
            unionSize[rb] += unionSize[ra];
        }

        if (PRINT_DEBUG) {
            System.out.println(this);
        }
    }

    private int findRoot(final int a) {
        int parent = unions[a];
        return (parent == a) ? a : findRoot(parent);
    }

    public boolean isConnected(final int a, final int b) {
        return findRoot(a) == findRoot(b);
    }

    public int distinct() {
        return (int) Arrays.stream(unions).distinct().count();
    }

    @Override
    public String toString() {
        return "UnionFind{" +
                "unions=" + Arrays.toString(unions) +
                ", unionSize=" + Arrays.toString(unionSize) +
                '}';
    }
}
