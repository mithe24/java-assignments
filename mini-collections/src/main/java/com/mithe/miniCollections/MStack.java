package com.mithe.miniCollections;

import com.mithe.miniCollections.interfaces.MList;
import com.mithe.miniCollections.interfaces.MListIterator;

public class MStack<E>
    implements MList<E>{

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    private class Node {
        private E data;
        private Node next;
        private Node previous;

        private Node(E data) {
            this.data = data;
        }
    }

    private class MStackIterator
        implements MListIterator<E> {

        Node currentNode = head;
        int index = 0;
        
        @Override
        public E next() {
            E data = currentNode.data;

            if (hasNext()) {
                currentNode = currentNode.next;
            }

            index++;
            return data;
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public boolean hasNext() {
            return currentNode.next != null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head.previous = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                current.next.previous = current.previous;
                current.previous = current.next;

                size--;
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds of " + index);
        }

        Node current = head;

        if (index < size/2) {
            int i = 0;
            while (i <= index) {
                current = current.next;
                i++;
            }
        } else {
            current = tail;
            int i = size - 1;
            while (i > index) {
                current = current.previous;
                i--;
            }
        }

        return current.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public MListIterator<E> iterator() {
        return new MStackIterator();
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }
}
