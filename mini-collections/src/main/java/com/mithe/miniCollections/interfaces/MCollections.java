package com.mithe.miniCollections.interfaces;

public interface MCollections<E> 
    extends Iterable<E> {

    /**
     * Makes sure that this collection contains the given {@code element}, and
     * returns {@code true} if collection changed due to the {@code next()} call.
     *
     * @param e the {@code element} to be added to the collection.
     * @return If the collection was changed.
     */
    boolean add(E e);

    /**
     * Removes all elements from the collection.
     */
    void clear();

    /**
     * Checks whether this collection contains a given {@code object}.
     * 
     * @param o the {@code object} to check whether is in this collection.
     * @return whether the {@code object} is in this collection.
     */
    boolean contains(Object o);

    /**
     * Removes a single instance of the given object in this collection, and
     * returns {@code true} if the collection contained the {@code object}.
     *
     * @param o the {@code object} to remove from the collection.
     * @return whether the collection contaied the {@code object}.
     */
    boolean remove(Object o);

    /**
     * Returns number of {@code element} in this collection.
     *
     * @return number of {@code element}.
     */
    int size();

    /**
     * Checks whether this collection contains any {@code elements}.
     *
     * @return whether the collection is empty.
     */
    boolean isEmpty();
}
