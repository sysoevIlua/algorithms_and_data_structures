package org.sysoev.task6_1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertMatrixToListTest {

    ConvertMatrixToList convertMatrixToList = new ConvertMatrixToList();

    @Test
    void convertMatrixToListTest() {
        int[][] matrix = {
                {0, 5, 0},
                {0, 0, 3},
                {2, 0, 0}
        };

        List<Edge> edges = convertMatrixToList.convertMatrixToList(matrix);
        for(Edge e:edges){
            System.out.println(e.toString());
        }

        assertTrue(edges.contains(new Edge(0, 1, 5)));
        assertTrue(edges.contains(new Edge(1, 2, 3)));
        assertTrue(edges.contains(new Edge(2, 0, 2)));
    }
}