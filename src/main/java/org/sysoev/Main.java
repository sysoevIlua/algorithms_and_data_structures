package org.sysoev;

import org.sysoev.task2.BinarySearchService;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13};
        int[] badArray = {2, 4, 1, 3};

        var resultTest1 = BinarySearchService.binarySearch(array, 1);
        System.out.println("Тест 1 - должен вернуть 0, фактически - " + resultTest1);
        var resultTest2 = BinarySearchService.binarySearch(array, 13);
        System.out.println("Тест 2 - должен вернуть 6, фактически - " + resultTest2);
        var resultTest3 = BinarySearchService.binarySearch(array, 4);
        System.out.println("Тест 3 - должен вернуть -1, фактически - " + resultTest3);

        var resultTest4 = BinarySearchService.binarySearch(badArray, 3);
        System.out.println("Тест 4 - наверно должен вернуть -1, фактически - " + resultTest4);

    }
}