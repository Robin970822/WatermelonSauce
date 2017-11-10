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
//		selectionSort(a);
//		bubbleSort(a);
//		intertSort(a);
//        mergeSort(a, 0, a.length - 1);
        quickSort(a, 0, a.length - 1);
    }

    /**
     * selection sort algorithm
     *
     * @param a the array to be sorted
     *          array a will be sorted in non-descending order (a[0] <= a[1] <= ... <= a[n-1])
     */
    private static void selectionSort(int[] a) {
    }

    /**
     * bubble sort algorithm
     *
     * @param a the array to be sorted
     *          array a will be sorted in non-descending order (a[0] <= a[1] <= ... <= a[n-1])
     */
    private static void bubbleSort(int[] a) {
    }

    /**
     * insert sort algorithm
     *
     * @param a the array to be sorted
     *          array a will be sorted in non-descending order (a[0] <= a[1] <= ... <= a[n-1])
     */
    private static void insertSort(int[] a) {
    }

    private static void mergeSort(int[] a, int left, int right) {
        int[] b = new int[a.length];
        mSort(a, b, left, right);
    }

    private static void mSort(int[] a, int[] b, int left, int right) {
        if (left < right) {
            int i = (left + right) / 2;
            mSort(a, b, left, i);
            mSort(a, b, i + 1, right);
            merge(a, b, left, i, right);//合并到数组b
            copy(a, b, left, right);//复制回数组a
        }
    }

    private static void merge(int[] a, int[] b, int l, int m, int r) {//合并a[l:m]和a[m+1:r]到b[l:r]
        int i = l;
        int j = m + 1;
        int k = l;
        while (i <= m && j <= r) {
            if (a[i] < a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        if (i == m + 1) {
            while (j <= r) {
                b[k++] = a[j++];
            }
        } else {
            while (i <= m) {
                b[k++] = a[i++];
            }

        }
    }

    private static void copy(int[] a, int[] b, int left, int right) {//拷贝数组b中元素到数组a
        for (int i = left; i <= right; i++)
            a[i] = b[i];
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int q = partition(a, left, right);
            //int q = randomizedPartition(a, left, right);
            quickSort(a, left, q - 1);
            quickSort(a, q + 1, right);
        }
    }

    public static int kthSelect(int[] a, int left, int right, int k) {
        if (left == right)
            return a[left];
        //int q = Partition(a, left, right);
        //int q = randomizedPartition(a, left, right);
        int q = partition(a, left, right);
        int j = q - left + 1;//q为绝对位置，转化为相对位置

        if (k == j) return a[q];
        if (k < j)
            return kthSelect(a, left, q - 1, k);
        else return kthSelect(a, q + 1, right, k - j);
    }

    public static int kthMaxSelect(int[] a, int left, int right, int k) {
        return kthSelect(a, left, right, a.length - k + 1);
    }


    private static int randomizedPartition(int[] a, int left, int right) {
        Random random = new Random();
        int i = random.nextInt(right - left + 1) + left;
        swap(a, i, left);
        return partition(a, left, right);
    }

    private static int partition(int[] a, int left, int right) {
        int p = a[left];
        int i = left + 1;
        int j = right;

        while (true) {
            while (a[i] < p && i <= right) {
                i++;
            }
            while (a[j] > p && j >= left) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, left, j);
        return j;
    }

    private static void swap(int[] list, int k, int i) {
        int temp = list[k];
        list[k] = list[i];
        list[i] = temp;
    }

    public static void main(String[] args) {

        int[] a = {45, 32, 67, 54, 34, 32, 21, 25, 67, 98};

        for (int i = 0; i < 10; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        sort(a);

        for (int i = 0; i < 10; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        System.out.println(kthSelect(a, 0, 9, 5));
        System.out.println(kthMaxSelect(a, 0, 9, 5));
    }
}