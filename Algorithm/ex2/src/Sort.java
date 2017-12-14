/**
 * The package of different sort algorithms
 *
 * @author luwei
 * @version 1.1
 * @date 2017-10-29
 */

import java.util.Random;


public final class Sort {


    /**
     * sort algorithm
     *
     * @param a the array to be sorted
     *          array a will be sorted in non-descending order (a[0] <= a[1] <= ... <= a[n-1])
     */
    public static void sort(int[] a) {
        long startTime = 0;
        long endTime = 0;

//        selectionSort(a);
        startTime = System.nanoTime();
        bubbleSort(a);
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) + "ns");
        System.out.println(a.length);
//        insertSort(a);
//        mergeSort(a);
//        quickSort(a);
//        int kth = kthMaxSelect(a, 0, a.length - 1, a.length / 2);
//        System.out.println("The " + a.length / 2 + "th largest is: " + kth);
    }

    /**
     * selection sort algorithm
     *
     * @param a the array to be sorted
     *          array a will be sorted in non-descending order (a[0] <= a[1] <= ... <= a[n-1])
     */
    public static void selectionSort(int[] a) {
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
    public static void bubbleSort(int[] a) {
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
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int temp = a[i];
            while (j >= 0 && a[j] > temp) {//从后向前查找小于a[i]的元素
                a[j + 1] = a[j];
                j--;
            }
            if (j != i - 1) {
                a[j + 1] = temp;
            }
        }
    }


    /**
     * merge sort algorithm
     *
     * @param a the array to be sorted
     *          array a will be sorted in non-descending order (a[0] <= a[1] <= ... <= a[n-1])
     */
    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    /**
     * quick sort algorithm
     *
     * @param a the array to be sorted
     *          array a will be sorted in non-descending order (a[0] <= a[1] <= ... <= a[n-1])
     */
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /**
     * merge sort algorithm
     *
     * @param a     the array to be sorted
     *              array a will be sorted in non-descending order (a[0] <= a[1] <= ... <= a[n-1])
     * @param left  the left limit of the array
     * @param right the right limit of the array
     */
    private static void mergeSort(int[] a, int left, int right) {
        int[] b = new int[a.length];
        mSort(a, b, left, right);
    }

    /**
     * recursive merge sort
     *
     * @param a     the array to be sorted
     * @param b     the array to store the sorted array
     * @param left  the left limit of the array
     * @param right the right limit of the array
     */
    private static void mSort(int[] a, int[] b, int left, int right) {
        if (left < right) {
            int i = (left + right) / 2;
            mSort(a, b, left, i);
            mSort(a, b, i + 1, right);
            merge(a, b, left, i, right);//合并到数组b
            copy(a, b, left, right);//复制回数组a
        }
    }

    /**
     * merge a[l:m] and a[m+1,r] into b[l:r]
     *
     * @param a the array to be sorted
     * @param b the array to store the sorted array
     * @param l the light limit of the array
     * @param m the division point of the array
     * @param r the right limit of the array
     */
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

    /**
     * copy array b to array a
     *
     * @param a     the array to be copied into
     * @param b     the array to be copied
     * @param left  the left limit of the array
     * @param right the right limit of the array
     */
    private static void copy(int[] a, int[] b, int left, int right) {//拷贝数组b中元素到数组a
        for (int i = left; i <= right; i++)
            a[i] = b[i];
    }

    /**
     * quick sort algorithm
     *
     * @param a     the array to be sorted
     * @param left  the left limit of the array
     * @param right the right limit of the array
     */
    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            //int q = partition(a, left, right);
            int q = randomizedPartition(a, left, right);
            quickSort(a, left, q - 1);
            quickSort(a, q + 1, right);
        }
    }

    /**
     * select the kth largest element in array a
     *
     * @param a     array to be selected in
     * @param left  the left limit of the array
     * @param right the right limit of the array
     * @param k     the kth
     * @return the value of the kth largest element
     */
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

    /**
     * select the kth largest element in array a
     *
     * @param a     array to be selected in
     * @param left  the left limit of the array
     * @param right the right limit of the array
     * @param k     the kth
     * @return the value of the kth largest element
     */
    public static int kthMaxSelect(int[] a, int left, int right, int k) {
        return kthSelect(a, left, right, a.length - k + 1);
    }


    /**
     * random part a array into a[left:j] and a[j:right] where a[left:j] <= a[j] and a[j] <= a[j:right]
     *
     * @param a     the array to be parted
     * @param left  the left limit of the array
     * @param right the right limit of the array
     * @return the partition index j
     */
    private static int randomizedPartition(int[] a, int left, int right) {
        Random random = new Random();
        int i = random.nextInt(right - left + 1) + left;
        swap(a, i, left);
        return partition(a, left, right);
    }

    /**
     * part a array into a[left:j] and a[j:right] where a[left:j] <= a[j] and a[j] <= a[j:right]
     *
     * @param a     the array to be parted
     * @param left  the left limit of the array
     * @param right the right limit of the array
     * @return the partition index j
     */
    private static int partition(int[] a, int left, int right) {
        int p = a[left];
        int i = left + 1;
        int j = right;

        while (true) {
            while (a[i] < p && i < right) {
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

    /**
     * swap the list[k] and list[i] in the array list
     *
     * @param list the array whose elements will be swapped
     * @param k    the index of the element to be swapped
     * @param i    the index of the element to be swapped
     */
    private static void swap(int[] list, int k, int i) {
        int temp = list[k];
        list[k] = list[i];
        list[i] = temp;
    }

    /**
     * randomly generate array between -maxData and maxData
     *
     * @param length  the length of the array
     * @param maxData the max value of the array
     * @return the random array
     */
    private static int[] generateArray(int length, int maxData) {
        int a[] = new int[length];

        for (int i = 0; i < length; i++) {
            a[i] = new Random().nextInt(2 * maxData) - maxData;
        }

        return a;
    }

    public static void main(String[] args) {

        int a[] = generateArray(10000, 100000);

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        sort(a);

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}