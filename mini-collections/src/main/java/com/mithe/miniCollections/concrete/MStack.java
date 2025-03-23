package com.mithe.miniCollections.concrete;

import java.util.NoSuchElementException;

public class MStack<E>
    extends SinglyLinkedList<E> {

    public void push(E e) {
        super.add(e);
    }

    public E peek() {
        if (super.size() == 0) {
            throw new NoSuchElementException("Stack is empty");
        }

        return super.get(0);
    }

    public E pop() {
        if (super.size() == 0) {
            throw new NoSuchElementException("Stack is empty");
        }

        E data = super.get(0);
        super.remove(data);
    
        return data;
    }
}
