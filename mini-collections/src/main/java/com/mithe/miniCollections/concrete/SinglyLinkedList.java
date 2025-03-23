package com.mithe.miniCollections.concrete;

import java.util.NoSuchElementException;

import com.mithe.miniCollections.abstracts.MAbstractList;
import com.mithe.miniCollections.interfaces.MListIterator;

public class SinglyLinkedList<E>
    extends MAbstractList<E> {
    
    private Node head = null;

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

        super.size++;
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

                super.size--;
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
        if (index >= super.size) { 
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
    public MListIterator<E> iterator() {
        return new SinglyLinkedListIterator();
    }

    @Override
    public void clear() {
        head = null;
        super.size = 0;
    }
}
