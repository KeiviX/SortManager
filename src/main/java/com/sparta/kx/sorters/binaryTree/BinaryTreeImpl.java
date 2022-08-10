package com.sparta.kx.sorters.binaryTree;

//public - methods you can access
//private - implementation
//abstract Nodes - values


import com.sparta.kx.exceptions.ChildNotFoundException;

public class BinaryTreeImpl implements BinaryTree{
    private final Node rootNode;

    public BinaryTreeImpl(int elements) {
        rootNode = new Node(elements);
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements(Node rootNode) {
        if (rootNode == null) {
            return 0;
        } else {//return root + left side + right side, recursively
            return 1 + getNumberOfElements(rootNode.getLeftChild()) + getNumberOfElements(rootNode.getRightChild());
        }
    }

    public void addElementToTree(int element) {
        addNodeToTree(rootNode, element);
    }

    @Override
    public void addElements(int[] elements) {

    }

    public boolean findElement(int element) {
        Node node = findNode(element);
        return node != null;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int[] getSortedTreeAsc() {
        return new int[0];
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