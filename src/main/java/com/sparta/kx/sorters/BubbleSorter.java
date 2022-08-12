package com.sparta.kx.sorters;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSorter implements Sorter{
    private static final Logger logger = Logger.getLogger("my logger");

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
                    logger.log(Level.INFO, "The algorithm at this time is " + Arrays.toString(arrayToSearch));
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

    @Override
    public String toString() {
        return "BubbleSorter";
    }
}