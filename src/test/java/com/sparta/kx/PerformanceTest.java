package com.sparta.kx;

import com.sparta.kx.sorters.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static com.sparta.kx.display.DisplayManager.printResults;

public class PerformanceTest {

    private int[] unsortedArray;
    private static int[] arrayToSort;
    @BeforeAll
    public static void classSetup() {
        Random random = new Random();
        arrayToSort = new int[20];
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = random.nextInt(100);
        }
    }

    @BeforeEach
    public void setup() {
        unsortedArray = arrayToSort.clone();
    }

    @Test
    public void testBinarySorter() {
        Sorter sorter = new BinarySorter();
        System.out.println(sorter.toString() + " sort before\n" + Arrays.toString(unsortedArray));
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter, sortedArray);
    }

    @Test
    public void testBubbleSorter() {
        Sorter sorter = new BubbleSorter();
        System.out.println("Before the " + sorter.toString() + " sort" + Arrays.toString(unsortedArray));
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter, sortedArray);
    }

    @Test
    public void testMergeSorter() {
        Sorter sorter = new MergeSorter();
        System.out.println("Before the " + sorter.toString() + " sort" + Arrays.toString(unsortedArray));
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter, sortedArray);
    }

    @Test
    public void testQuickSorter() {
        Sorter sorter = new QuickSorter();
        System.out.println("Before the " + sorter.toString() + " sort" + Arrays.toString(unsortedArray));
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter, sortedArray);
    }

}
