package com.mithe.miniCollections.interfaces;

public interface MList<E>
    extends MCollections<E> {

    /**
     * Adds a {@code element} at the end of list.
     *
     * @param e the element to be added.
     * @return {@code true}.
     */
    boolean add(E e);

    /**
     * Gets element at a given index, index < size.
     *
     * @throws IndexOutOfBoundException if index >= size.
     * @param index.
     * @return the element at index.
     */
    E get(int index);

    /**
     * Returns a iterator for this list.
     * @return iterator
     */
    MListIterator<E> iterator();
}
