package com.sparta.kx.sorters;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickSorter implements Sorter{
    private static final Logger logger = Logger.getLogger("my logger");
    @Override
    public int[] sortArray(int[] arrays) {
        return quickSort(arrays, 0, arrays.length -1);
    }

    public int[] quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
            logger.log(Level.INFO, "This iteration of the array is " + Arrays.toString(arr));
        }
        return arr;
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
            logger.log(Level.INFO, "This iteration of the array is " + Arrays.toString(arr));
        }
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
        return i+1;
    }

    @Override
    public String toString() {
        return "QuickSorter";
    }
}