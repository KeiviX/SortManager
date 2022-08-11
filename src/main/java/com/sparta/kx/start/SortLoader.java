package com.sparta.kx.start;

import com.sparta.kx.display.DisplayManager;
import com.sparta.kx.exceptions.SorterLoaderException;
import com.sparta.kx.sorters.*;
import com.sparta.kx.sorters.binaryTree.BinaryTreeImpl;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortLoader {
    private final static Scanner scanner = new Scanner(System.in);
    public static void start() {
        try {
            DisplayManager.displaySortChoice();
            int choice = scanner.nextInt();
            Sorter sorter = SortFactory.getSorter(choice);
            System.out.println("Please enter the size of array you want to generate: ");
            int[] arrayToSort = createArray(scanner.nextInt());
            DisplayManager.printBeforeSort(sorter, arrayToSort);
            DisplayManager.printResults(sorter, arrayToSort);
        } catch (SorterLoaderException e) {
            start();
        }
    }

    public static int[] createArray(int requiredLength) {
        Random rand = new Random();
        int[] randomArray = new int[requiredLength];
        for (int i = 0; i < requiredLength; i++) {
            randomArray[i] = rand.nextInt(100);
        }
        return randomArray;
    }
}