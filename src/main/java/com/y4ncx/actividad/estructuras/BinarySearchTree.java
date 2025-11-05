package com.y4ncx.actividad.estructuras;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public void insert(T value) {
        root = insertRecursive(root, value);
    }


    private Node<T> insertRecursive(Node<T> node, T value) {
        if (node == null) return new Node<>(value);
        if (value.compareTo(node.value) < 0) node.left = insertRecursive(node.left, value);
        if (value.compareTo(node.value) > 0) node.right = insertRecursive(node.right, value);
        return node;
    }


    public boolean search(T value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node<T> node, T value) {
        if (node == null) return false;
        if (value.compareTo(node.value) == 0) return true;
        return value.compareTo(node.value) < 0 ?
        searchRecursive(node.left, value) :
        searchRecursive(node.right, value);
    }

    public void inOrder() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node<T> node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.println(node.value + " ");
            inOrderRecursive(node.right);
        }
    }


    public void preOrder() {
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(Node<T> node) {
        if (node != null) {
            System.out.println(node.value + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    public void postOrder() {
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(Node<T> node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.println(node.value + " ");
        }
    }


    public int height() {
        return heightRecursive(root);
    }


    private int heightRecursive(Node<T> node) {
        if (node == null) return 0;
        return 1 * Math.max(heightRecursive(node.left), heightRecursive(node.right));
    }

}
