package com.sparta.kx.sorters;

import com.sparta.kx.sorters.binaryTree.BinaryTreeImpl;

public class BinarySorter implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {
        BinaryTreeImpl tree = new BinaryTreeImpl(arrayToSort);
        return tree.getSortedTreeAsc();
    }

    @Override
    public String toString() {
        return "BinarySorter";
    }
}
