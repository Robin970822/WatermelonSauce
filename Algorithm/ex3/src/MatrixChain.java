public class MatrixChain {


    /**
     * 求解矩阵最小乘次
     *
     * @param p n个矩阵组成的矩阵链的n+1个行列值，p[0...n]
     * @param t 追踪矩阵，矩阵链得到最小乘次的分裂点，n+1阶
     * @return 矩阵链的最小乘次
     */
    public static int minMultiNum(int[] p, int[][] t) {
       int min1 = recurMinMultiNum(p, t, 1, p.length - 1);
       int min2 = iteraMinMultiNum(p, t);

       return min1 == min2 ? min1 : -1;
    }

    /**
     * 迭代方法求矩阵最小乘次
     *
     * @param p n个矩阵组成的矩阵链的n+1个行列值，p[0...n]
     * @param t 追踪矩阵，矩阵链得到最小乘次的分裂点，n+1阶
     * @return 矩阵链的最小乘次
     */
    private static int iteraMinMultiNum(int[] p, int[][] t) {

        int[][] m = new int[p.length][p.length];

        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                m[i][j] = -1;
                t[i][j] = -1;
            }
            m[i][i] = 0;
        }

        for (int r = 2; r < p.length; r++) {
            for (int i = 1; i < p.length - r; i++) {
                int j = i + r - 1;
                m[i][j] = m[i][i] + m[i + 1][j] + p[i - 1] * p[i] * p[j];
                for (int k = i + 1; k < j; k++) {
                    int temp = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (temp < m[i][j]) {
                        m[i][j] = temp;
                        t[i][j] = k;
                    }
                }
            }
        }

        return m[1][p.length - 1];
    }

    /**
     * 递归方法求矩阵最小乘次
     *
     * @param p n个矩阵组成的矩阵链的n+1个行列值，p[0...n]
     * @param t 追踪矩阵，矩阵链得到最小乘次的分裂点，n+1阶
     * @param i 矩阵链的起始位置,i>0,i<j
     * @param j 矩阵链的结束位置,j<n
     * @return 矩阵链的最小乘次
     */
    private static int recurMinMultiNum(int[] p, int[][] t, int i, int j) {

        if (i == j) return 0;

        int minVal = recurMinMultiNum(p, t, i, i) + recurMinMultiNum(p, t, i + 1, j) + p[i - 1] * p[i] * p[j];

        t[i][j] = i;
        for (int k = i + 1; k < j; k++) {
            int temp = recurMinMultiNum(p, t, i, k) + recurMinMultiNum(p, t, k + 1, j) + p[i - 1] * p[k] * p[j];
            if (temp < minVal) {
                minVal = temp;
                t[i][j] = k;
            }
        }
        return minVal;
    }

    /**
     * @param t
     * @param i
     * @param j
     */
    public static void traceback(int[][]t, int i, int j){
        if (i == j) return;
        traceback(t, i, t[i][j]);
        traceback(t, t[i][j] +1 ,j);
        String tracebackinfo = "";
        tracebackinfo += i + "\t" + t[i][j] + "\t";
        tracebackinfo += (t[i][j] + 1) + "\t" + j + "\n";

        System.out.println(tracebackinfo);
    }

    public static void main(String[] args) {
    }
}
