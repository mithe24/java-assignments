package com.mithe.miniCollections;

import java.util.NoSuchElementException;

import com.mithe.miniCollections.interfaces.MList;
import com.mithe.miniCollections.interfaces.MListIterator;

public class SinglyLinkedList<E>
    implements MList<E> {
    
    private int size = 0;
    private Node head = null;;

    private class Node {

        private E data;
        private Node next;

        private Node(E data) {
            this.data = data;
        }
    }

    private class SinglyLinkedListIterator
        implements MListIterator<E> {

        int index = 0;
        Node current = head;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            if (current.next == null) {
                throw new NoSuchElementException("No more elements");
            }
            E data = current.data;

            if (current.next != null) {
                current = current.next; 
            }
            
            index++;
            return data;
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        Node newNode = new Node(e);
        Node current = head;

        if (head == null) {
            head = newNode;
        } else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) { return false; }
        
        Node current = head, prev = null;
        while (current != null) {
            if (current.data.equals(o)) {
                if (prev == null) {
                    head = null;
                } else {
                    prev.next = current.next;
                }

                size--;
                return true;
            } else {
                prev = current;
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

        int i = 0;
        Node current = head;
        while (i != index) {
            current = current.next;
            i++;
        }

        return current.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public MListIterator<E> iterator() {
        return new SinglyLinkedListIterator();
    }

    @Override
    public void clear() {
        head = null;
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
