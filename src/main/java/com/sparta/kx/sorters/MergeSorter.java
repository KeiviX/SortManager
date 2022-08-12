package com.sparta.kx.sorters;


import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSorter implements Sorter {
    private static final Logger logger = Logger.getLogger("my logger");
    @Override
    public String toString() {
        return "MergeSorter";
    }

    @Override
    public int[] sortArray(int[] arrays) {
        mergeSort(arrays, arrays.length);
        return arrays;
    }

    public static void mergeSort(int[] a, int lengthOfArray) {
        // if n is 1
        if (lengthOfArray < 2) {
            return;
        }

        int midPoint = lengthOfArray / 2;
        int[] l = new int[midPoint];
        int[] r = new int[lengthOfArray - midPoint];
        System.arraycopy(a, 0, l, 0, midPoint);

        if (lengthOfArray - midPoint >= 0)
            System.arraycopy(a, midPoint, r, 0, lengthOfArray - midPoint);
        mergeSort(l, midPoint);
        mergeSort(r, lengthOfArray - midPoint);
        merge(a, l, r, midPoint, lengthOfArray - midPoint);
    }
    public static void merge( int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
            logger.log(Level.INFO, "This iteration of the array is " + Arrays.toString(a));
        }
        while (i < left) {
            a[k++] = l[i++];
            logger.log(Level.INFO, "This iteration of the array is " + Arrays.toString(a));

        }
        while (j < right) {
            a[k++] = r[j++];
            logger.log(Level.INFO, "This iteration of the array is " + Arrays.toString(a));

        }
    }
}