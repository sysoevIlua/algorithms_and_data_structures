package org.sysoev.task6_2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopologicalSortingTest {

    @Test
    void topologicalSort() {
        int[][] g = {
                {0, 1, 1},
                {0, 0, 1},
                {0, 0, 0}
        };

        List<Integer> sortedGraph = TopologicalSorting.topologicalSort(g);

        assertTrue(sortedGraph.indexOf(0) < sortedGraph.indexOf(1));
        assertTrue(sortedGraph.indexOf(0) < sortedGraph.indexOf(2));
        assertTrue(sortedGraph.indexOf(1) < sortedGraph.indexOf(2));
    }
}