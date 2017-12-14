final class Traveling {

    //相对大的值
    private int noEdge;

    //图的邻接矩阵
    private int[][] graph;

    //图中节点数量
    private int nodeNum;

    //出发节点
    private int start;

    //当前解
    private int[] currentpath;

    //当前最优解
    private int[] bestPath;

    //当前代价
    private int currentCost;

    //当前最小代价
    private int bestCost;

    /**
     * 构造函数
     *
     * @param initialG     初始连接矩阵
     * @param sourceVertex 初始节点
     * @param noEdge       相对大的值
     */
    public Traveling(int[][] initialG, int sourceVertex, int noEdge) {
        this.noEdge = noEdge;
        this.start = sourceVertex;
        this.graph = initialG;
        this.nodeNum = graph.length;
        this.currentCost = 0;
        this.bestCost = noEdge;
        this.start = sourceVertex;

        this.currentpath = new int[nodeNum];
        this.bestPath = new int[nodeNum];

        for (int i = 0; i < nodeNum; i++) {
            bestPath[i] = i;
            currentpath[i] = i;
        }

        swap(currentpath, 0, sourceVertex);
        swap(bestPath, 0, sourceVertex);

    }


    /**
     * @return 无边的权值
     */
    public int getNoEdge() {
        return noEdge;
    }

    /**
     * @param noEdge 无边的权值
     */
    public void setNoEdge(int noEdge) {
        this.noEdge = noEdge;
    }

    public void backtrack(int i) {
        if (i == nodeNum) {
            if (currentCost + graph[currentpath[nodeNum - 1]][currentpath[0]] < bestCost) {
                bestCost = currentCost + graph[currentpath[nodeNum - 1]][currentpath[0]];//更新最优解
                for (int j = 0; j < nodeNum; j++) {
                    bestPath[j] = currentpath[j];//更新最优解向量
                }
            }
        } else {
            for (int j = i; j < nodeNum; j++) {
                //子数准入判断
                if (currentCost + graph[currentpath[i - 1]][currentpath[j]] < bestCost) {
                    swap(currentpath, i, j);
                    currentCost += graph[currentpath[i - 1]][currentpath[i]];
                    backtrack(i+1);
                    currentCost -= graph[currentpath[i - 1]][currentpath[i]];
                    swap(currentpath, i, j);
                }
            }
        }
    }

    /**
     * 数组元素交换
     *
     * @param list
     * @param k
     * @param i
     */
    private static void swap(int[] list, int k, int i) {
        int temp = list[k];
        list[k] = list[i];
        list[i] = temp;
    }
}

public class Travel {
}
