package com.mithe.miniCollections;

import java.util.NoSuchElementException;

import com.mithe.miniCollections.interfaces.MListIterator;
import com.mithe.miniCollections.interfaces.MQueue;

public class MLinkedList<E> 
    extends MAbstractList<E> implements MQueue<E> {
    
    private int size;
    private Node head;
    private Node tail;

    private class Node {

        private E data;
        private Node next = null;
        private Node previous = null;

        private Node(E data) {
            this.data = data;
        }
    }

    private class MLinkedListIterator
        implements MListIterator<E> {

        private Node currentNode = head;
        private int index = 0;

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }

            E data = currentNode.data;
            currentNode = currentNode.next;
            index++;

            return data;
        }

        public E previous() {
            if (index == 0) {
                throw new NoSuchElementException("No more previous elements");
            }

            E data = currentNode.data;
            currentNode = currentNode.previous;
            index --;

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

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        size++;
        return true;
    }

    @Override
    public E remove() {
        if (head == null) {
            throw new NoSuchElementException("Linked list is empty");
        }

        E data = head.data;
        if (size() >= 2) {
            head = head.next;
        } else  {
            head = null;
            tail = null;
        }

        size--;
        return data;
    }

    @Override
    public boolean remove(Object o) {
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

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public MListIterator<E> iterator() {
        return new MLinkedListIterator();
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public E element() {
        return head.data;
    }
}
