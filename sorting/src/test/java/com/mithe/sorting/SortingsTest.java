package com.mithe.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.stream.Stream;

public class SortingsTest {

    public static Stream<SortingAlgorithm> algorithms() {
        return Sortings.getInstance().getStream();
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void testEmptyArr(SortingAlgorithm sortingAlgorithm) {
        Integer[] arr = {};

        sortingAlgorithm.sort(arr);
        assertArrayEquals(new Integer[]{}, arr);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void testOneElementArr(SortingAlgorithm sortingAlgorithm) {
        Integer[] arr = {1};
        Integer[] expected = {1};

        sortingAlgorithm.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void testSortedArr(SortingAlgorithm sortingAlgorithm) {
        Integer[] arr = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        sortingAlgorithm.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void testReverseSortedArr(SortingAlgorithm sortingAlgorithm) {
        Integer[] arr = {5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5};

        sortingAlgorithm.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void testArrWithDuplicates(SortingAlgorithm sortingAlgorithm) {
        Integer[] arr = {3, 1, 2, 1, 3, 2};
        Integer[] expected = {1, 1, 2, 2, 3, 3};

        sortingAlgorithm.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void testRandomOrderArr(SortingAlgorithm sortingAlgorithm) {
        Integer[] arr = {10, 7, 9, 2, 1, 5, 3, 8, 4, 6};
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        sortingAlgorithm.sort(arr);
        assertArrayEquals(expected, arr);
    }


    @ParameterizedTest
    @MethodSource("algorithms")
    void testIntegerArr(SortingAlgorithm sortingAlgorithm) {
        Integer[] arr = {5,4,3,2,1};
        Integer[] expected = {1,2,3,4,5};

        sortingAlgorithm.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void testCharacterArr(SortingAlgorithm sortingAlgorithm) {
        Character[] arr = {'D','C','B','A'};
        Character[] expected = {'A','B','C','D'};

        sortingAlgorithm.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void testFloatArr(SortingAlgorithm sortingAlgorithm) {
        Float[] arr = {5.5f, 2.3f, 9.8f, 1.2f};
        Float[] expected = {1.2f, 2.3f, 5.5f, 9.8f};

        sortingAlgorithm.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void testStringArr(SortingAlgorithm sortingAlgorithm) {
        String[] arr = {"banana", "apple", "kiwi", "cherry", "date"};
        String[] expected = {"apple", "banana", "cherry", "date", "kiwi"};

        sortingAlgorithm.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void testDoubleArr(SortingAlgorithm sortingAlgorithm) {
        Double[] arr = {5.5, 2.3, 9.8, 1.2};
        Double[] expected = {1.2, 2.3, 5.5, 9.8};

        sortingAlgorithm.sort(arr);
        assertArrayEquals(expected, arr);
    }
}
