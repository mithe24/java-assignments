package com.mithe.miniCollections.interfaces;

public interface MQueue<E>
    extends MCollections<E> {

    /**
     * Adds a given element to this queue.
     */
    boolean add(E e);

    /**
     * Gets but doesn't remove the head of the queue.
     */
    E element();

    /**
     * gets and remove the head of the queue.
     */
    E remove();
}
