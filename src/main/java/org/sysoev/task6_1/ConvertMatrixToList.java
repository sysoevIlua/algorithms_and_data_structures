package org.sysoev.task6_1;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrixToList {
    public List<Edge> convertMatrixToList(int[][] matrix)
    {
        List<Edge> edgeList = new ArrayList<>();
        for (int from = 0; from < matrix.length; from++) {
            for (int to = 0; to < matrix.length; to++) {
                int weight = matrix[from][to];
                if (weight != 0) {
                    edgeList.add(new Edge(from, to, weight));
                }
            }
        }
        return edgeList;
    }
}

