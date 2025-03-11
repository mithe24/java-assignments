package com.mithe.sorting;

/**
 * The SortingAlgorithm interface represents a common contract for all sorting algorithms.
 * Any sorting algorithm that implements this interface must provide an implementation for the
 * {@link #sort} method, which sorts an array of Comparable elements.
 *
 * <p>
 * This interface is designed to allow polymorphic usage of various sorting algorithms, enabling
 * flexible and interchangeable sorting strategies.
 * </p>
 * 
 * @param T The type of elements to be sorted, which must implement the Comparable interface.
 */
public interface SortingAlgorithm {

    /**
     * Sorts an array of Comparable elements.
     * The algorithm should arrange the elements in ascending order.
     * 
     * @param a The array to be sorted.
     * @param T The type of elements in the array, which must implement the Comparable interface.
     */
    public <T extends Comparable<T>> void sort(T[] a);
}
