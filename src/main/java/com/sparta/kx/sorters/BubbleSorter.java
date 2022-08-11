package com.sparta.kx.sorters;

public class BubbleSorter implements Sorter{

    //static int[] getRandomArray(int requiredLength) {
    public int[] sortArray(int[] arrayToSearch) {
        bubbleSortAlg(arrayToSearch);
        return arrayToSearch;
    }

    private static void bubbleSortAlg(int[] arrayToSearch) {
        int count = arrayToSearch.length;
        for(int i = 0; i < count -1; i++) {
            for (int j = 0; j < count - 1; j ++) {
                if (arrayToSearch[j] > arrayToSearch[j+1]) {
                    swapTriangle(arrayToSearch, j);
                }
            }
        }
    }

    public static void swapTriangle(int[] arrayToSearch, int j) {
        int temp;
        temp = arrayToSearch[j];
        arrayToSearch[j] = arrayToSearch[j+1];
        arrayToSearch[j+1] = temp;
    }
}
