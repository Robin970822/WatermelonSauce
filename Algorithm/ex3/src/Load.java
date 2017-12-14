/**
 * @author Robin Hanxy
 * @version 1.0.0
 */
final class Loading {
    //集装箱数量
    private int gNum;
    //集装箱重量数组
    private int[] weights;
    //容量
    private int capacity;
    //当前的解向量
    private int[] x;
    //当前最优解向量
    private int[] bestX;
    //当前载重
    private int cw;
    //当前最优载重
    private int bestW;
    //当前剩余集装箱重量
    private int rw;


    public Loading(int[] w, int c) {
        this.gNum = w.length;
        this.weights = w;
        this.capacity = c;
        this.cw = 0;
        this.bestW = 0;
        this.x = new int[gNum];
        this.bestX = new int[gNum];
        this.rw = 0;
        for (int i = 0; i < gNum; i++) {
            rw += w[i];
        }
    }

    /**
     * 回溯递归函数
     *
     * @param i 子集树的深度
     */
    public void backtrack(int i) {
        if (i == gNum) {//到达叶节点
            if (cw > bestW) {//得到一个更优值
                bestW = cw;
                bestX = x.clone();
            }
            return;
        }

        rw -= weights[i];

        if (cw + weights[i] <= capacity){
            x[i] = 1;
            cw += weights[i];
            backtrack(i+1);
            x[i] = 0;
            cw -= weights[i];
        }

        if (cw + weights[i] > bestW ){
            x[i] = 0;
            backtrack(i+1);
        }
        rw += weights[i];
    }

    /**
     * @return 返回当前最优解
     */
    public int[] getBestX(){
        return this.bestX;
    }

    /**
     * @return 返回当前最优载重量
     */
    public int getBestW(){
        return this.bestW;
    }

}


/**
 *
 */
public final class Load {


    public static int maxloading(int[] w, int c, int[] loading) {
        Loading ld = new Loading(w, c);
        ld.backtrack(0);

        for (int i = 0; i < loading.length; i++) {
            loading[i] = ld.getBestX()[i];
        }
        return ld.getBestW();
    }

    public static void output(int[] loading) {
        for (int i = 0; i < loading.length; i++){
            System.out.print(loading[i]);
        }
    }


    public static void main(String[] args) {
        int[] w = {90, 80, 40, 30, 20, 12, 10};
        int sumW = 0;
        for (int temp: w){
            sumW += temp;
        }

        int c1 = 120;
        int c2 = 200;
        int[] loading1 = new int[w.length];

        int w1 = maxloading(w, c1, loading1);
        int restW = sumW - w1;

        if (restW <= c2){
            System.out.println("一个可行解如下");
            System.out.println("在c1中装载重量为：" + w1);
            System.out.println("在c2中装载重量为：" + restW);
            output(loading1);
        }else {
            System.out.println("无法找到可行解");
        }
    }
}
