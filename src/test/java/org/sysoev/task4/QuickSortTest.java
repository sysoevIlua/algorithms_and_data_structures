package org.sysoev.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    @DisplayName("Сортировка с пустым массивом")
    void quickSortWithoutNumbers() {
        int[] a = {};
        QuickSort.quickSort(a);
        assertArrayEquals(new int []{}, a);
    }

    @Test
    @DisplayName("Сортировка с одним элементом")
    void quickSortWithOneNumbers() {
        int[] a = {2};
        QuickSort.quickSort(a);
        assertArrayEquals(new int []{2}, a);
    }

    @Test
    @DisplayName("Сортировка с обратным порядком")
    void quickSortWithReverse() {
        int[] a = {76, 65, 45, 31, 28, 16, 11, 7};
        QuickSort.quickSort(a);
        assertArrayEquals(new int []{7, 11, 16, 28, 31, 45, 65, 76}, a);
    }

    @Test
    @DisplayName("Сортировка с рандомным порядком")
    void quickSortWithRandom() {
        int[] a = {28, 65, 11, 7, 76, 16, 45, 31};
        QuickSort.quickSort(a);
        assertArrayEquals(new int []{7, 11, 16, 28, 31, 45, 65, 76}, a);
    }
}