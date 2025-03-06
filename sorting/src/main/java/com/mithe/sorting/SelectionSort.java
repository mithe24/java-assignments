package com.mithe.sorting;

/**
 * The SelectionSort class implements the {@link SortingAlgorithm} interface to provide
 * the selection sort algorithm. Selection sort is a comparison-based sorting algorithm 
 * that repeatedly selects the smallest (or largest) element from the unsorted portion of 
 * the array and swaps it with the first unsorted element.
 *
 * <p>
 * Selection sort has a time complexity of O(n^2) in all cases (best, average, and worst), 
 * making it inefficient for large datasets. Despite its simplicity, it is not a stable 
 * sorting algorithm and is less efficient than algorithms like merge sort or quick sort for 
 * large arrays.
 * </p>
 * 
 * @param <T> The type of elements in the array to be sorted. The elements must implement 
 *            the {@link Comparable} interface for comparison during sorting.
 */
public class SelectionSort 
    implements SortingAlgorithm{

    /**
     * Sorts an array of Comparable elements using the Selection Sort algorithm.
     *
     * <p>
     * The algorithm works by iterating through the array, selecting the smallest element 
     * in the unsorted portion of the array, and swapping it with the first unsorted element.
     * This process is repeated for all elements in the array until the entire array is sorted.
     * </p>
     * 
     * @param arr The array of Comparable elements to be sorted.
     * @param <T> The type of the elements in the array, which must implement {@link Comparable}.
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        T temp;
        int min;
        
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;

            // Find weakest element
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) { min = j; }
            }

            // Swap
            if (min != i) {
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
