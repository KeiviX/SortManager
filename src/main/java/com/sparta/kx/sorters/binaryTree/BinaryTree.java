package com.sparta.kx.sorters.binaryTree;

import com.sparta.kx.exceptions.ChildNotFoundException;

public interface BinaryTree {
    int getRootElement();


    int getNumberOfElements();

    void addElementToTree(int element);

    void addElements(final int[] elements);

    boolean findElement(int element);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}