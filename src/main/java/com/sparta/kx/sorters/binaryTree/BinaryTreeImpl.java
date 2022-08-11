package com.sparta.kx.sorters.binaryTree;

//public - methods you can access
//private - implementation
//abstract Nodes - values


import com.sparta.kx.exceptions.ChildNotFoundException;

public class BinaryTreeImpl implements BinaryTree{
    private final Node rootNode;
    private int[] arrayToSort;
    private int index;

    public BinaryTreeImpl(int elements) {
        rootNode = new Node(elements);
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

    }

    @Override
    public boolean findElement(int element) {
        Node node = findNode(element);
        return node != null;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node leftNode = findNode(element).getLeftChild();
        return leftNode.getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node rightNode = findNode(element);
        return rightNode.getRightChild().getValue();
    }


    /*
    @Override
    public int[] getSortedTreeAsc(int size) {
        int[] sortedArrayInAsc = new int[size];
            return returnAscendingTree(sortedArrayInAsc, rootNode);
        }

    private int[] returnAscendingTree(int[] tempArray, Node rootNode) {
        if (!rootNode.isLeftChildEmpty()) {
            returnAscendingTree(tempArray, rootNode);
        } else {
            tempArray[index] =rootNode.getValue();
            index++;
            if (!rootNode.isRightChildEmpty()) {
                returnAscendingTree(tempArray, rootNode.getRightChild());
            }
        }
        return tempArray;
    }

     */
    @Override
    public int[] getSortedTreeAsc() {
        sortedTree = new int[numOfNodes()]
    }

    @Override
    public int[] getSortedTreeDesc() {
        return new int[0];
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