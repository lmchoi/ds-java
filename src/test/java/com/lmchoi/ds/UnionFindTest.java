package com.lmchoi.ds;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UnionFindTest {
    @Test
    public void mergeSingleNodes() {
        int n = 10;
        UnionFind unionFind = new UnionFind(n);
        assertThat(unionFind.distinct(), is(10));

        unionFind.merge(2, 5);

        assertFalse(unionFind.isConnected(0, 2));
        assertTrue(unionFind.isConnected(5, 2));
        assertTrue(unionFind.isConnected(2, 5));

        assertThat(unionFind.distinct(), is(9));

        System.out.println(unionFind);
    }

    @Test
    public void mergeNodeToTree() {
        int n = 10;
        UnionFind unionFind = new UnionFind(n);
        unionFind.merge(2, 5);
        unionFind.merge(2, 9);

        assertTrue(unionFind.isConnected(9, 5));
        assertThat(unionFind.distinct(), is(8));
    }

    @Test
    public void mergeNodeToLeaveNode() {
        int n = 10;
        UnionFind unionFind = new UnionFind(n);
        unionFind.merge(2, 5);
        unionFind.merge(2, 9);
        unionFind.merge(0, 9);

        assertTrue(unionFind.isConnected(0, 2));
        assertTrue(unionFind.isConnected(0, 5));
        assertThat(unionFind.distinct(), is(7));
    }

    @Test
    public void mergeTwoTrees() {
        int n = 10;
        UnionFind unionFind = new UnionFind(n);
        unionFind.merge(0, 1);

        unionFind.merge(8, 9);
        unionFind.merge(8, 7);

        unionFind.merge(8, 0);
        assertTrue(unionFind.isConnected(0, 9));
    }
}
