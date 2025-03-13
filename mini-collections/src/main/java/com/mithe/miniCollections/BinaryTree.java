package com.mithe.miniCollections;

// Java Util
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

// My interfaces
import com.mithe.miniCollections.interfaces.MCollections;

public class BinaryTree<E extends Comparable<E>>
    implements MCollections<E> {

    private int size = 0;
    private Node root;

    private class Node {

        private E data;
        private Node leftChild = null, rightChild = null, parrent = null;

        private Node(E data) {
            this.data = data;
        }
    }

    private class BinaryTreeIterator {

        private Node current = root;

        private E nextLeft() {
            if (current.leftChild == null) {
                throw new NoSuchElementException("No more elements");
            } else {
                E data = current.data;
                current = current.leftChild;
                return data;
            }
        }

        private E nextRight() {
            if (current.rightChild == null) {
                throw new NoSuchElementException("No more elements");
            } else {
                E data = current.data;
                current = current.rightChild;
                return data;
            }
        }

        private E nextParrent() {
            if (current.parrent == null) {
                throw new NoSuchElementException("No more elements");
            } else {
                E data = current.data;
                current = current.parrent;
                return data;
            }
        }

        private boolean isLeaf() {
            return current.leftChild == null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        Node newNode = new Node(e);
        Node parrent = null, current = root;

        while (current != null) {
            parrent = current;

            if (e.compareTo(current.data) < 0) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        newNode.parrent = parrent;

        if (parrent == null) {
            root = newNode;
        } else if (e.compareTo(parrent.data) < 0) {
            parrent.leftChild = newNode;
        } else {
            parrent.rightChild = newNode;
        }

        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node current = root;
        E e = (E) o;
        
        while (current != null) {
            int comparison = e.compareTo(current.data);
            if (comparison < 0) {
                current = current.leftChild;
            } else if (comparison > 0) {
                current = current.rightChild;
            } else {
                size--;
                treeRemove(current);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new BinaryTreeIterator();
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        return containsIteratively((E) o);
    }

    public int height() {
        int height = 0;

        if (root == null) {
            return 0;
        } else {
            Queue<Node> q = new LinkedList<>();

            q.add(root);
            q.add(null); // null marker for end of level

            Node current = q.poll();
            while(!q.isEmpty()) {
                if (current == null) {
                    height++;

                    if(!q.isEmpty()) {
                        q.add(null); // add null marker for next level
                    }

                } else {
                    if (current.leftChild != null) { q.add(current.leftChild); }
                    if (current.rightChild != null) { q.add(current.rightChild); }
                }
                current = q.poll(); // next node in queue
            }
        }

        return height;
    }

    public Iterator<E> iteratorPreOrder() {
    }

    public Iterator<E> iteratorInOrder() {
    }

    public Iterator<E> iteratorPostOrder() {
    }

    private boolean containsRecursively(Node node, E e) {
        if (node == null) {
            return false;
        }

        int comparison = e.compareTo(node.data);
        if (comparison < 0) {
            return containsRecursively(node.leftChild, e);
        } else if (comparison > 0) {
            return containsRecursively(node.rightChild, e);
        } else {
            return true;
        }

    }

    private boolean containsIteratively(E e) {
        Node current = root;
        
        while (current != null) {
            int comparison = e.compareTo(current.data);
            if (comparison < 0) {
                current = current.leftChild;
            } else if (comparison > 0) {
                current = current.rightChild;
            } else {
                return true;
            }
        }

        return false;
    }

    private void transplant(Node u, Node v) {
        if (u.parrent == null) {
            root = v;
        } else if (u == u.parrent.leftChild) {
            u.parrent.leftChild = v;
        } else {
            u.parrent.rightChild = v;
        }
    }

    private void treeRemove(Node node) {
        if (node.leftChild == null) {
            transplant(node, node.rightChild);
        } else if (node.rightChild == null) {
            transplant(node, node.leftChild);
        } else {
            node.parrent = treeMinimum(node.rightChild);

            if (node.parrent != node.rightChild) {
                transplant(node.parrent, node.parrent.rightChild);
                node.parrent.rightChild = node.rightChild;
                node.parrent.rightChild.parrent = node.parrent;
            }

            transplant(node, node.parrent);
            node.parrent = node.leftChild;
            node.parrent.leftChild.parrent = node.parrent;
        }
    }

    private Node treeMinimum(Node node) {
        Node current = node;
        while (current.leftChild != null) {
            current = current.leftChild;
        }

        return current;
    }
}
