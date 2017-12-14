/**
 * The package of different sort algorithms
 *
 * @author luwei
 * @version 1.1
 * @date 2017-10-29
 */

import java.util.*;

public final class Sort {
    /**
     * selection sort algorithm
     *
     * @param a the array to be sorted
     *          array a will be sorted in non-descending order (a[0] <= a[1] <= ... <= a[n-1])
     */
    public static void sort(int[] a) {
//      selectionSort(a);
		bubbleSort(a);
    }

    /**
     * selection sort algorithm
     *
     * @param a the array to be sorted
     *          array a will be sorted in non-descending order (a[0] <= a[1] <= ... <= a[n-1])
     */
    private static void selectionSort(int[] a) {
        int min;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    /**
     * bubble sort algorithm
     *
     * @param a the array to be sorted
     *          array a will be sorted in non-descending order (a[0] <= a[1] <= ... <= a[n-1])
     */
    private static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    /**
     * insert sort algorithm
     *
     * @param a the array to be sorted
     *          array a will be sorted in non-descending order (a[0] <= a[1] <= ... <= a[n-1])
     */
    private static void insertSort(int[] a) {
    }

    private static void swap(int[] list, int k, int i) {
        int temp = list[k];
        list[k] = list[i];
        list[i] = temp;
    }

    public static void main(String[] args) {

        int[] a = {45, 32, 67, 54, 34, 32, 21, 25, 67, 10};

        for (int i = 0; i < 10; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        sort(a);

        for (int i = 0; i < 10; i++)
            System.out.print(a[i] + " ");
    }
}