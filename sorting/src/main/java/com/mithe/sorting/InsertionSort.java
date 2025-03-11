package com.mithe.sorting;

/**
 * The InsertionSort class implements the {@link SortingAlgorithm} interface to provide
 * the insertion sort algorithm. Insertion sort is a simple comparison-based sorting 
 * algorithm that builds the final sorted array one element at a time by repeatedly 
 * inserting the next element into its correct position within the already sorted part 
 * of the array.
 *
 * <p>
 * While insertion sort is relatively efficient for small datasets, its time complexity 
 * is O(n^2) in the worst case, making it less suitable for large datasets. It is, however, 
 * adaptive, meaning it performs well when the input is already partially sorted. Insertion sort 
 * is stable and in-place.
 * </p>
 * 
 * @param T The type of elements in the array to be sorted. The elements must implement 
 *            the {@link Comparable} interface for comparison during sorting.
 */
public class InsertionSort 
    implements SortingAlgorithm {

    /**
     * Sorts an array of Comparable elements using the Insertion Sort algorithm.
     *
     * <p>
     * The algorithm iterates through the array, and for each element, it finds the correct 
     * position in the sorted portion of the array by comparing it with the previous elements. 
     * As it finds the correct position, it shifts the larger elements to the right to make space 
     * for the current element.
     * </p>
     * 
     * @param T The type of the elements in the array, which must implement {@link Comparable}.
     * @param arr The array of Comparable elements to be sorted.
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        int j;
        T key;

        for(int i = 1; i < arr.length; i++) {
            // Gets next element
            key = arr[i];
            j = i;
            
            // Goes down the array until it reaches a weaker element
            while(j > 0 && arr[j-1].compareTo(key) > 0) {
                // Shifting elements
                arr[j] = arr[j-1];
                j--;
            }
            
            // Insert into correct position
            arr[j] = key;
        }
    }
}
