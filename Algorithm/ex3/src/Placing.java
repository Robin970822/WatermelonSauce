final class Placing {
    /**
     * 皇后数量
     */
    private int n;

    /**
     * 当前可行解
     */
    private int[] x;

    /**
     * 可行解数量
     */
    private int sum;

    public Placing(int n) {
        this.n = n;
        this.sum = 0;
        this.x = new int[n];
    }

    /**
     * 对外接口
     */
    public void doPlace(){
        backtrack(0);
        System.out.println(sum);
    }


    private void backtrack(int d) {
        if (d == n) {
            sum++;
            outputX();
        } else {
            for (int i = 0; i < n; i++) {
                x[d] = i;
                if (isPlace(d)) {
                    backtrack(d + 1);
                }
            }
        }
    }

    private boolean isPlace(int row) {
        for (int j = 0; j < row; j++) {
            if (x[row] == x[j] || Math.abs(row - j) == Math.abs(x[row] - x[j])) {
                return false;
            }
        }
        return true;
    }

    private void outputX() {
        for (int temp : x) {
            System.out.print(temp);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Placing placing = new Placing(8);
        placing.doPlace();
    }

}
