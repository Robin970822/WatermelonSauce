/**
 * This class use for common computing
 *
 * @author Hanxy
 */

public final class MyComputer {

    /**
     * 阶乘计算递归实现
     *
     * @param n>=0
     * @return n!
     */
    public static long factorialRec(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorialRec(n - 1);
        }
    }

    /**
     * 阶乘计算迭代实现
     *
     * @param n>=0
     * @return n!
     */
    public static long factorialNRec(int n) {

        long val = 1;

        for (int i = 1; i < n + 1; i++) {
            val *= i;
        }
        return val;
    }

    /**
     * Fibonacci数列计算递归实现
     *
     * @param n>=0
     * @return fibonacci value of n
     */
    public static int fibonacciRec(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacciRec(n - 1) + fibonacciRec(n - 2);
        }

    }

    /**
     * Fibonacci数列计算迭代实现
     *
     * @param n>=0
     * @return fibonacci value of n
     */
    public static int fibonacciIter(int n) {
        int val = 1;
        int fval = 1;
        int temp = 1;

        if (n==1 || n==2){

        }else {
            for (int i = 3; i < n+1 ; i++){
                temp = val;
                val += fval;
                fval = temp;
            }
        }
        return val;
    }
    public static void main(String[] args) {

        long begin1 = System.currentTimeMillis();
        System.out.println(factorialRec(15));
        long end1 = System.currentTimeMillis();
        System.out.println("Recursive computing time: " + (end1 - begin1) + "毫秒");

        long begin2 = System.currentTimeMillis();
        System.out.println(factorialNRec(15));
        long end2 = System.currentTimeMillis();
        System.out.println("Iterative computing time: " + (end2 - begin2) + "毫秒");

        long begin3 = System.currentTimeMillis();
        System.out.println(fibonacciRec(45));
        long end3 = System.currentTimeMillis();
        System.out.println("Recursive computing time: " + (end3 - begin3) + "毫秒");

        long begin4 = System.currentTimeMillis();
        System.out.println(fibonacciIter(45));
        long end4 = System.currentTimeMillis();
        System.out.println("Iterative computing time: " + (end4 - begin4) + "毫秒");
    }
}