package com.mithe.sorting;

import java.util.Arrays;

/**
 * The MergeSort class implements the {@link SortingAlgorithm} interface to provide
 * the merge sort algorithm. Merge sort is a divide-and-conquer sorting algorithm 
 * that recursively divides the array into halves, sorts each half, and then merges 
 * the sorted halves back together.
 *
 * <p>
 * Merge sort has a time complexity of O(n log n) in all cases (best, average, and worst),
 * making it much more efficient than algorithms like bubble sort or insertion sort for large datasets. 
 * It is a stable and in-place sorting algorithm.
 * </p>
 * 
 * @param <T> The type of elements in the array to be sorted. The elements must implement 
 *            the {@link Comparable} interface for comparison during sorting.
 */
public class MergeSort
    implements SortingAlgorithm {

    /**
     * Sorts an array of Comparable elements using the Merge Sort algorithm.
     *
     * <p>
     * The algorithm divides the array into two halves, recursively sorts each half, 
     * and then merges the two sorted halves into a single sorted array.
     * </p>
     * 
     * @param arr The array of Comparable elements to be sorted.
     * @param <T> The type of the elements in the array, which must implement {@link Comparable}.
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Recursively divides the array into two halves and sorts each half.
     * 
     * @param arr The array to be sorted.
     * @param l The left index of the current subarray.
     * @param r The right index of the current subarray.
     * @param <T> The type of the elements in the array, which must implement {@link Comparable}.
     */
    private <T extends Comparable<T>> void mergeSort(T[] arr, int l, int r) {
        if (l < r) {

            // Find midle point
            int m = l + (r - l) / 2;

            // Sort each half
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the halfs
            merge(arr, l, m, r);
        }
    }

    /**
     * Merges two sorted subarrays of the array into a single sorted subarray.
     * The subarrays are defined by the indices l, m, and r. 
     * The subarray from index {@code l} to {@code m} is the left subarray, 
     * and the subarray from index {@code m+1} to {@code r} is the right subarray.
     * 
     * @param arr The array containing the subarrays to be merged.
     * @param l The left index of the current subarray.
     * @param m The middle index that divides the subarray into two halves.
     * @param r The right index of the current subarray.
     * @param <T> The type of the elements in the array, which must implement {@link Comparable}.
     */
    private <T extends Comparable<T>> void merge(T[] arr, int l, int m, int r) {

        // Calculating subarray lengths
        int l1 = m - l + 1;
        int l2 = r - m;

        // Creating new temp sub arrays
        T[] L = Arrays.copyOfRange(arr, l, m + 1);
        T[] R = Arrays.copyOfRange(arr, m + 1, r + 1);

        // Merge the two subarrays
        int i = 0, j = 0;
        int k = l;

        while (i < l1 && j < l2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining subarrays into the original array
        while (i < l1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < l2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
