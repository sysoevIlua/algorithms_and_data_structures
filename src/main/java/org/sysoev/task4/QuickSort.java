package org.sysoev.task4;

public class QuickSort {

    public static void quickSort(int[] array) {

        // если нечего сортировать, то возвращаем массив
        if (array == null || array.length < 2) {
            return;
        }

        // создаем массив, где будем хранить актуальные левые и правые границы для каждой последующей итерации
        int[] borders = new int[array.length*2];
        // top - указатель на текущие границы
        int top = 0;

        // на момент инициализации - левая и правая границы - границы массива
        borders[top++] = 0;
        borders[top++] = array.length - 1;

        // пока есть что сортировать, выполняем цикл
        while (top > 0) {
            // достаем левую и правую границу, сдвигая top
            int right = borders[--top];
            int left = borders[--top];

            int i = left;
            int j = right;
            // опорный элемент - просто середина подмассива
            int pivot = array[(left + right) / 2];

            // сама сортировка
            while (i < j) {
                while (array[i] < pivot) {
                    i++;
                }
                while (array[j] > pivot) {
                    j--;
                }
                // если слева нашли элемент больше pivot и справа меньше pivot, то перекидываем их
                if (i <= j) {
                    int tmp = array[i];
                    array[i++] = array[j];
                    array[j--] = tmp;
                }
            }
            // после сортировки от left до j все элементы меньше pivot
            // от i до right больше pivot

            // новые границы для левого подмассива
            if (left < j) {
                borders[top++] = left;
                borders[top++] = j;
            }
            // новые границы для правого подмассива
            if (i < right) {
                borders[top++] = i;
                borders[top++] = right;
            }
        }
    }
}
