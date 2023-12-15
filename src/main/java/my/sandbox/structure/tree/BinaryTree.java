package my.sandbox.structure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO: Add delete
// TODO: Optimize `add` function

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public void add(final T value) {
        root = recursiveAdd(root, value);
    }

    public boolean contains(final T value) {
        return recursiveFind(root, value).isPresent();
    }

    private Optional<Node<T>> recursiveFind(final Node<T> currentNode, final T value) {
        if (currentNode == null) {
            return Optional.empty();
        }

        int comparison = value.compareTo(currentNode.value);

        if (comparison == 0) {
            return Optional.of(currentNode);
        }

        if (comparison > 0) {
            return recursiveFind(currentNode.right, value);
        } else {
            return recursiveFind(currentNode.left, value);
        }
    }

    private Node<T> recursiveAdd(final Node<T> currentNode, final T value) {
        if (currentNode == null) {
            return new Node<>(value);
        }

        int comparison = value.compareTo(currentNode.value);
        if (comparison < 0) {
            currentNode.left = recursiveAdd(currentNode.left, value);
        } else if (comparison > 0) {
            currentNode.right = recursiveAdd(currentNode.right, value);
        }
        return currentNode;
    }

    public List<T> traverse(TraversalOrder order) {
        List<T> traverse = new ArrayList<>();
        switch (order) {
            case PRE_ORDER -> traversePreOrder(root, traverse);
            case POST_ORDER -> traversePostOrder(root, traverse);
            case IN_ORDER -> traverseInOrder(root, traverse);
        }
        return traverse;
    }

    private void traverseInOrder(final Node<T> node, List<T> traversal) {
        if (node != null) {
            traverseInOrder(node.left, traversal);
            traversal.add(node.value);
            traverseInOrder(node.right, traversal);
        }
    }

    private void traversePreOrder(final Node<T> node, List<T> traversal) {
        if (node != null) {
            traversal.add(node.value);
            traversePreOrder(node.left, traversal);
            traversePreOrder(node.right, traversal);
        }
    }

    private void traversePostOrder(final Node<T> node, List<T> traversal) {
        if (node != null) {
            traversePostOrder(node.left, traversal);
            traversePostOrder(node.right, traversal);
            traversal.add(node.value);
        }
    }

    private static class Node<T> {

        private final T value;
        private Node<T> right;
        private Node<T> left;

        Node(final T value) {
            this.value = value;
        }
    }
}



