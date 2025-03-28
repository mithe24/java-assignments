package com.mithe.miniCollections.concrete;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

import com.mithe.miniCollections.abstracts.MAbstractCollection;

public class BinaryTree<E extends Comparable<E>>
    extends MAbstractCollection<E> {

    protected Node root;

    protected class Node {

        protected E data;
        protected Node leftChild = null, rightChild = null, parrent = null;

        protected Node(E data) {
            this.data = data;
        }
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

        super.size++;
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
                super.size--;
                treeRemove(current);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        E key = (E) o;
        Node current = root;
        while (current != null) {
            if (current.leftChild != null && current.leftChild.data.compareTo(key) < 0) {
                current = current.leftChild;
            } else if (current.rightChild != null && current.rightChild.data.compareTo(key) > 0) {
                current = current.rightChild;
            } else {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new InOrderIterator();
    }

    @Override
    public void clear() {
        root = null;
        super.size = 0;
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
        return new PreOrderIterator();
    }

    public Iterator<E> iteratorInOrder() {
        return new InOrderIterator();
    }

    public Iterator<E> iteratorPostOrder() {
        return new PostOrderIterator();
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

    private class InOrderIterator
        implements Iterator<E> {

        Stack<Node> stack = new Stack<>();

        private void pushAllLeft(Node node) {
            while (node != null) {
                stack.push(node.leftChild);
                node = node.leftChild;
            }
        }

        public InOrderIterator() {
            if (root != null) {
                pushAllLeft(root);
            }
        }

        @Override
        public E next() {
            if (hasNext()) {
                throw new NoSuchElementException("No more elements");
            }

            Node node = stack.pop();
            if (node.rightChild != null) {
                stack.push(node.rightChild);
            }
            
            return node.data;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }


    private class PreOrderIterator
        implements Iterator<E> {

        Stack<Node> stack;

        public PreOrderIterator() {
            stack = new Stack<>();
            if (root != null) {
                stack.push(root);
            }
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }

            Node node = stack.pop();
            if (node.rightChild != null) {
                stack.push(node.rightChild);
            } 
            if (node.leftChild != null) {
                stack.push(node.leftChild);
            }

            return node.data;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    private class PostOrderIterator
        implements Iterator<E> {

        Stack<Node> stack;
        Node lastVisited = null;

        public PostOrderIterator() {
            stack = new Stack<>();
            if (root != null) {
                stack.push(root);
            }
        }

        private void pushAllLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
        }

        @Override
        public E next() {
            Node node = stack.peek();
            
            if (node.rightChild != null && node.rightChild != lastVisited) {
                pushAllLeft(node.rightChild);
            } else {
                stack.pop();
                lastVisited = node;
                return node.data;
            }

            return next();
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
