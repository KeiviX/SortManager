package com.sparta.kx.sorters.binaryTree;

//public - methods you can access
//private - implementation
//abstract Nodes - values


import com.sparta.kx.exceptions.ChildNotFoundException;

public class BinaryTreeImpl implements BinaryTree{
    private final Node rootNode;
    private int index;

    private class Node {

        private final int value;
        private Node leftChild;
        private Node rightChild;

        private Node(int value) {
            this.value = value;
        }

        private void createLeftNode(int value) {
            leftChild = new Node(value);
        }

        private void createRightNode(int value) {
            rightChild = new Node(value);
        }

        private int getValue() {
            return value;
        }

        private Node getLeftChild() {
            return leftChild;
        }

        private void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        private Node getRightChild() {
            return rightChild;
        }

        private void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        private boolean isLeftChildEmpty() {
            return leftChild == null;
        }

        private boolean isRightChildEmpty() {
            return rightChild == null;
        }
    }

    public BinaryTreeImpl(int elements) {
        rootNode = new Node(elements);
    }
    public BinaryTreeImpl(final int[] array) {
        rootNode = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            addElementToTree(array[i]);
        }
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return numOfNodes(rootNode);
    }

    private int numOfNodes(Node rootNode) {
        if (rootNode == null) {
            return 0;
        } else {//return root + left side + right side, recursively
            return 1 + numOfNodes(rootNode.getLeftChild()) + numOfNodes(rootNode.getRightChild());
        }
    }

    public void addElementToTree(int element) {
        addNodeToTree(rootNode, element);
    }

    @Override
    public void addElements(int[] elements) {
        for (int i : elements) {
            addElementToTree(i);
        }
    }

    @Override
    public boolean findElement(int element) {
        Node node = findNode(element);
        return node != null;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node leftNode = findNode(element);
        assert leftNode != null;
        return leftNode.getLeftChild().getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node rightNode = findNode(element);
        assert rightNode != null;
        return rightNode.getRightChild().getValue();
    }

    @Override
    public int[] getSortedTreeAsc() {
        index = 0;
        int[] sortedArray = new int[getNumberOfElements()];
        return returnAscendingTree(sortedArray, rootNode);
    }

    private int[] returnAscendingTree(int[] sortedArray, Node node) {
        if (!node.isLeftChildEmpty()) {
            returnAscendingTree(sortedArray, node.getLeftChild());
        }
        sortedArray[index++] = node.getValue();
        if (!node.isRightChildEmpty()) {
            returnAscendingTree(sortedArray, node.getRightChild());
        }
        return sortedArray;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedArray = new int[getNumberOfElements()];
        index = 0;
        return returnDescendingTree(sortedArray, rootNode);
    }

    private int[] returnDescendingTree(int[] sortedArray, Node node) {
        if (!node.isRightChildEmpty()) {
            returnDescendingTree(sortedArray, node.getRightChild());
        }
        sortedArray[index ++] = node.getValue();
        if (!node.isLeftChildEmpty()) {
            returnDescendingTree(sortedArray, node.getLeftChild());
        }
        return sortedArray;
    }


    private void addNodeToTree(Node node, int element) {
        if (element <= node.getValue()) {
            findLeftNode(node, element);
        } else if (element > node.getValue()){
            findRightNode(node, element);
        }
    }

    private void findRightNode(Node node, int element) {
        if (node.isRightChildEmpty()) {
            node.setRightChild(new Node(element));
        } else {
            addNodeToTree(node.getRightChild(), element);
        }
    }

    private void findLeftNode(Node node, int element) {
        if (node.isLeftChildEmpty()) {
            node.setLeftChild(new Node(element));
        } else {
            addNodeToTree(node.getLeftChild(), element);
        }
    }

    private Node findNode(int element) {
        Node node = rootNode;
        while (node != null) {
            if (element == node.getValue()) {
                return node;
            }
            if (element < node.getValue()) {
                node = node.getLeftChild();
            } else if (element > node.getValue()) {
                node = node.getRightChild();
            }
        }
        return null;
    }
}