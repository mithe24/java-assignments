package com.mithe.sorting;

/**
 * The HeapSort class implements the {@link SortingAlgorithm} interface to provide
 * the heap sort algorithm. Heap sort is a comparison-based sorting algorithm that 
 * works by organizing the elements of the array into a binary heap data structure,
 * and then sorting them by repeatedly extracting the maximum (or minimum) element 
 * from the heap and rebuilding the heap.
 *
 * <p>
 * The time complexity of heap sort is O(n log n) in the worst case, making it more 
 * efficient than bubble sort and insertion sort. It is an in-place sorting algorithm 
 * but not stable (it does not preserve the relative order of equal elements).
 * </p>
 * 
 * @param <T> The type of elements in the array to be sorted. The elements must implement 
 *            the {@link Comparable} interface for comparison during sorting.
 */
public class HeapSort
    implements SortingAlgorithm {

    /**
     * Sorts an array of Comparable elements using the Heap Sort algorithm.
     *
     * <p>
     * Heap sort first builds a max heap from the input array, which is a binary heap 
     * where each parent node is greater than or equal to its child nodes. Then, the 
     * root element (the maximum element) is swapped with the last element of the array 
     * and the heap size is reduced by one. This process is repeated for the remaining elements 
     * until the entire array is sorted.
     * </p>
     * 
     * @param arr The array of Comparable elements to be sorted.
     * @param T The type of the elements in the array, which must implement {@link Comparable}.
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        T temp;
        int n = arr.length;

        // Building heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extracting each element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            temp = arr[0]; 
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * Maintains the max-heap property by ensuring that the subtree rooted at index {@code i}
     * is a valid heap. If the subtree is not a valid max-heap, this method will swap elements
     * and recursively heapify the affected subtree.
     * 
     * @param arr The array representing the heap.
     * @param n The size of the heap (i.e., the number of elements to consider).
     * @param i The index of the root element of the subtree to heapify.
     * @param T The type of the elements in the array, which must implement {@link Comparable}.
     */
    private <T extends Comparable<T>> void heapify(T[] arr, int n, int i) {
        T temp;
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If the left child exists and is greater than the root
        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }

        // If the right child exists and is greater than the current largest
        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }

        // If the largest is not the root, swap and recursively heapify the affected subtree
        if (largest != i) {
            // Swap
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }
}
