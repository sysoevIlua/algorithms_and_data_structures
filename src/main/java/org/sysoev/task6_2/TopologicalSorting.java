package org.sysoev.task6_2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TopologicalSorting {
    public static List<Integer> topologicalSort(int[][] matrix) {

        int[] edges = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    edges[j]++;
                }
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < matrix.length; i++) {
            if (edges[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>(matrix.length);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            result.add(v);

            for (int j = 0; j < matrix.length; j++) {
                if (matrix[v][j] != 0 && --edges[j] == 0) {
                    queue.add(j);
                }
            }
        }

        if (result.size() != matrix.length) {
            throw new IllegalStateException("Graph has a cycle");
        }

        return result;
    }
}
