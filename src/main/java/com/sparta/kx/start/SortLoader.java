package com.sparta.kx.start;

import com.sparta.kx.sorters.BubbleSorter;
import com.sparta.kx.sorters.MergeSorter;
import com.sparta.kx.sorters.QuickSorter;
import com.sparta.kx.sorters.RandomArrayGenerator;
import com.sparta.kx.sorters.binaryTree.BinaryTreeImpl;

import java.util.Arrays;

public class SortLoader {
    public static void getArrays() {
        MergeSorter mergeSorter = new MergeSorter();
        QuickSorter quickSorter = new QuickSorter();


        int[] arr1 = {4, 67, 2, 76, 1};
        int[] arr2 = {64, 223, 123, 54, 43, 7};

        //QuickSort
        //System.out.println(Arrays.toString(quickSorter.sortArray(arr1)));

        //MergeSort
        //System.out.println(Arrays.toString(mergeSorter.sortArray(arr2)));


        BubbleSorter bubbleSorter = new BubbleSorter();
        BinaryTreeImpl binaryTree = new BinaryTreeImpl(6);
        binaryTree.addElementToTree(3);
        binaryTree.addElementToTree(8);
        binaryTree.addElementToTree(4);
        binaryTree.addElementToTree(1);
        binaryTree.addElementToTree(16);

        int[] arrayToAdd = {34, 21, 23, 6, 43, 12, 9};
        binaryTree.addElements(arrayToAdd);

        System.out.println();
        System.out.println("Binary tree sort ascending: " + Arrays.toString(binaryTree.getSortedTreeAsc()));
        System.out.println("Binary tree sort descending: " + Arrays.toString(binaryTree.getSortedTreeDesc()));

        //System.out.println(binaryTree.getNumberOfElements());

        //System.out.println(Arrays.toString(binaryTree.getSortedTreeAsc()));


        int requiredLength = 20;
        int[] numbers = RandomArrayGenerator.getRandomArray(requiredLength);
        //System.out.println("Before sort:" + Arrays.toString(numbers));
        //System.out.println("After sort:" +Arrays.toString(bubbleSorter.sortArray()));
    }
}
