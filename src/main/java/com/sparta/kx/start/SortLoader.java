package com.sparta.kx.start;

import com.sparta.kx.display.DisplayManager;
import com.sparta.kx.exceptions.SorterLoaderException;
import com.sparta.kx.sorters.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortLoader {
    private final static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger("my logger");
    public static void start() {
        try {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO);
            logger.setUseParentHandlers(true);
            DisplayManager.displayChoiceOfSorter();
            int choice = scanner.nextInt();
            logger.log(Level.INFO, "The users choice is " + choice);

            Sorter sorter = SortFactory.getSorter(choice);
            System.out.println("Please enter the size of array you want to generate: ");
            int[] arrayToSort = RandomArrayGenerator.createArray(scanner.nextInt());
            logger.log(Level.INFO, "Unsorted array: " + Arrays.toString(arrayToSort));
            DisplayManager.preSort(sorter, arrayToSort);
            DisplayManager.postSort(sorter, arrayToSort);

            logger.log(Level.INFO, "Sorted array: " + Arrays.toString(arrayToSort));
        } catch (SorterLoaderException e) {
            System.out.println("That sorter does not exist, please try again.\n");
            start();
        }
    }
}