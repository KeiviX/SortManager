package com.sparta.kx.start;

import com.sparta.kx.exceptions.SorterLoaderException;
import com.sparta.kx.sorters.*;
import com.sparta.kx.sorters.binaryTree.BinaryTree;
import com.sparta.kx.sorters.binaryTree.BinaryTreeImpl;

public class SortFactory {

    public static Sorter getSorter(int choice) throws SorterLoaderException {
        switch (choice) {
            case 1:
                return new BubbleSorter();
            case 2:
                return new BinarySorter();
            case 3:
                return new MergeSorter();
            case 4:
                return new QuickSorter();
            default:
                throw new SorterLoaderException("Invalid Sorter choice " + choice);
        }
    }
}