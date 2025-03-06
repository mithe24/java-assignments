package com.mithe.sorting;

/**
 * The QuickSort class implements the {@link SortingAlgorithm} interface to provide
 * the quick sort algorithm. Quick sort is a divide-and-conquer sorting algorithm 
 * that works by selecting a "pivot" element from the array and partitioning the other
 * elements into two subarrays according to whether they are less than or greater than the pivot.
 * The subarrays are then recursively sorted.
 *
 * <p>
 * Quick sort is efficient, with an average time complexity of O(n log n), but it has a 
 * worst-case time complexity of O(n^2) when the pivot elements are poorly chosen (e.g., always 
 * choosing the first or last element as the pivot). However, with proper pivot selection strategies, 
 * quick sort is one of the fastest sorting algorithms for large datasets. It is an in-place sorting algorithm 
 * and is not stable.
 * </p>
 * 
 * @param <T> The type of elements in the array to be sorted. The elements must implement 
 *            the {@link Comparable} interface for comparison during sorting.
 */
public class QuickSort 
    implements SortingAlgorithm {

    /**
     * Sorts an array of Comparable elements using the Quick Sort algorithm.
     *
     * <p>
     * The algorithm selects a pivot element and partitions the array into two parts: 
     * elements less than or equal to the pivot, and elements greater than the pivot. 
     * These subarrays are then recursively sorted.
     * </p>
     * 
     * @param arr The array of Comparable elements to be sorted.
     * @param <T> The type of the elements in the array, which must implement {@link Comparable}.
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Recursively sorts a subarray of the array using the Quick Sort algorithm.
     *
     * <p>
     * This method partitions the subarray around a pivot element and then recursively 
     * sorts the left and right partitions.
     * </p>
     * 
     * @param arr The array to be sorted.
     * @param lo The lower index of the subarray to be sorted.
     * @param hi The higher index of the subarray to be sorted.
     * @param <T> The type of the elements in the array, which must implement {@link Comparable}.
     */
    private <T extends Comparable<T>> void quickSort(T[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p - 1);
            quickSort(arr, p + 1, hi);
        }
    }

    /**
     * Partitions the array around a pivot element.
     * Elements less than or equal to the pivot are moved to the left of the pivot, 
     * and elements greater than the pivot are moved to the right.
     * The pivot element is placed in its correct sorted position.
     * 
     * @param arr The array to be partitioned.
     * @param lo The lower index of the subarray to be partitioned.
     * @param hi The higher index of the subarray to be partitioned.
     * @param <T> The type of the elements in the array, which must implement {@link Comparable}.
     * @return The index of the pivot element after partitioning.
     */
    private <T extends Comparable<T>> int partition(T[] arr, int lo, int hi) {
        T pivot = arr[hi];
        T temp;
        int i = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[hi];
        arr[hi] = temp;

        return i + 1;
    }
}
