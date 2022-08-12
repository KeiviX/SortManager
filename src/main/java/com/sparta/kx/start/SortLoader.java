package com.sparta.kx.start;

import com.sparta.kx.display.DisplayManager;
import com.sparta.kx.exceptions.SorterLoaderException;
import com.sparta.kx.sorters.*;
import java.util.Scanner;

public class SortLoader {
    private final static Scanner scanner = new Scanner(System.in);
    public static void start() {
        try {
            DisplayManager.displayChoiceOfSorter();
            int choice = scanner.nextInt();
            Sorter sorter = SortFactory.getSorter(choice);
            System.out.println("Please enter the size of array you want to generate: ");
            int[] arrayToSort = RandomArrayGenerator.createArray(scanner.nextInt());
            DisplayManager.printBeforeSort(sorter, arrayToSort);
            DisplayManager.printResults(sorter, arrayToSort);
        } catch (SorterLoaderException e) {
            System.out.println("That sorter does not exist, please try again.\n");
            start();
        }
    }
}