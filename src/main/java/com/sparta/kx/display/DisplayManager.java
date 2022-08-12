package com.sparta.kx.display;

import com.sparta.kx.sorters.Sorter;
import java.util.Arrays;

public class DisplayManager {

    public static void displayChoiceOfSorter() {
        System.out.println("""
Enter the number of the sorter you wish to use
1. BubbleSorter
2. BinarySorter
3. MergeSorter
4. QuickSorter""" );
    }

    public static void printBeforeSort(Sorter sorter, int[] arrayToSort) {
        System.out.println("Sorted using the " + sorter.toString());
        System.out.println("Before sorting:\n" + Arrays.toString(arrayToSort));
    }

    public static void printResults(Sorter sorter, int[] arrayToSort) {
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(arrayToSort);
        System.out.println("After sorting:\n" + Arrays.toString(sortedArray));
        long end = System.nanoTime();
        System.out.println("Time taken: " + (end-start) + "nanoseconds");
    }
}