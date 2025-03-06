package com.mithe.sorting;

/**
 * The BubbleSort class implements the {@link SortingAlgorithm} interface to provide
 * the bubble sort algorithm. Bubble sort is a simple sorting algorithm that repeatedly 
 * steps through the list, compares adjacent elements, and swaps them if they are in 
 * the wrong order. The process is repeated until the list is sorted.
 *
 * <p>
 * Bubble sort is not the most efficient algorithm for large datasets, but it is simple
 * to understand and implement. Its time complexity is O(n^2) in the worst case, making it 
 * less efficient than algorithms like MergeSort or QuickSort for larger arrays.
 * </p>
 * 
 * @param <T> The type of elements in the array to be sorted. The elements must implement 
 *            the {@link Comparable} interface for comparison during sorting.
 */
public class BubbleSort
    implements SortingAlgorithm {

    /**
     * Sorts an array of Comparable elements using the Bubble Sort algorithm.
     *
     * <p>
     * The algorithm compares each pair of adjacent elements in the array. If the elements
     * are in the wrong order (i.e., the first is greater than the second), it swaps them.
     * This process continues iteratively, each time reducing the number of elements to check,
     * as the largest unsorted element "bubbles" to its correct position.
     * </p>
     * 
     * @param <T> The type of the elements in the array, which must implement {@link Comparable}.
     * @param arr The array of Comparable elements to be sorted.
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        T temp;
        int newn;
        int n  = arr.length;

        // Iterate over array 
        while (n > 1) {
            newn = 0;
            for (int i = 0; i < n - 1; i++) {
                // If the two adjacent elements are out of order
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    newn = i + 1;
                }
            }
            n = newn;
        }
    }
}
