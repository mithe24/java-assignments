package com.mithe.sorting;

import java.util.stream.Stream;

/**
 * The {@code Sortings} class provides a collection of different sorting algorithms.
 * It follows the Singleton design pattern to ensure that only one instance of the class
 * is created during the application's lifecycle.
 * 
 * This class contains various sorting algorithms that can be accessed as constants, such as
 * BubbleSort, HeapSort, InsertionSort, MergeSort, QuickSort, and SelectionSort.
 */
public class Sortings {

    /**
     * The singleton instance of the {@code Sortings} class.
     */
    private static Sortings sortings_instance = null;

    /**
     * An instance of the {@link SortingAlgorithm} for BubbleSort.
     */
    public final SortingAlgorithm BUBBLESORT = new BubbleSort();

    /**
     * An instance of the {@link SortingAlgorithm} for HeapSort.
     */
    public final SortingAlgorithm HEAPSORT = new HeapSort();
    
    /**
     * An instance of the {@link SortingAlgorithm} for InsertionSort.
     */
    public final SortingAlgorithm INSERTIONSORT = new InsertionSort();

    /**
     * An instance of the {@link SortingAlgorithm} for MergeSort.
     */
    public final SortingAlgorithm MERGESORT = new MergeSort();

    /**
     * An instance of the {@link SortingAlgorithm} for QuickSort.
     */
    public final SortingAlgorithm QUICKSORT = new QuickSort();

    /**
     * An instance of the {@link SortingAlgorithm} for SelectionSort.
     */
    public final SortingAlgorithm SELECTIONSORT = new SelectionSort();

    /*
     * Methods
     */

    /**
     * Private constructor to prevent instantiation from outside the class. 
     * This ensures that only one instance of {@code Sortings} is created.
     */
    private Sortings() {
        // Private constructor to prevent external instantiation
    }

    /**
     * Returns the singleton instance of the {@code Sortings} class.
     * If the instance is not yet created, it creates and returns a new one.
     * This method is synchronized to make it thread-safe, ensuring that
     * only one instance is created even in multi-threaded environments.
     *
     * @return The singleton instance of the {@code Sortings} class.
     */
    public static synchronized Sortings getInstance() {
        if (sortings_instance == null) {
            sortings_instance = new Sortings();
        }

        return sortings_instance;
    }

    /**
     * Returns a {@link Stream} of all available sorting algorithms.
     * This allows for easy iteration or processing of the algorithms in a stream-based way.
     *
     * @return A stream of {@link SortingAlgorithm} instances representing all available sorting algorithms.
     */
    public Stream<SortingAlgorithm> getStream() {
        return Stream.of(
            BUBBLESORT,
            HEAPSORT,
            INSERTIONSORT,
            MERGESORT,
            QUICKSORT,
            SELECTIONSORT
        );
    }
}
