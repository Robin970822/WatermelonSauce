public class ShortPath {

    private static final int M = Integer.MAX_VALUE;

    /**
     * @param e    邻接矩阵
     * @param v    源
     * @param dist  最近距离
     * @param preV 前驱顶点
     */
    public static void dijkstra(int[][] e, int v, int[] dist, int preV[]) {
        int vNum = e.length; // 顶点数
        boolean[] s = new boolean[vNum];
        //初始化
        for (int i = 0; i < vNum; i++) {
            dist[i] = e[v][i];
            s[i] = false;
            if (dist[i] == M) preV[i] = -1; //不可达
            else preV[i] = v;
        }

        //顶点v加入集合
        dist[v] = 0;
        s[v] = true;
        for (int i = 0; i < vNum - 1; i++) {
            int temp = M;
            int u = v;
            for (int j = 0; j < vNum; j++) {
                if (!s[i] && dist[j] < temp) {
                    temp = dist[j];
                    u = j;
                }
            }
            s[u] = true;

            //遍历顶点，更新距离
            for (int j = 0; j < vNum; j++) {
                if ((!s[j]) && (e[u][j] < M)) {
                    int newdist = dist[u] + e[u][j];
                    if (newdist < dist[j]) {
                        dist[j] = newdist;
                        preV[j] = u;
                    }
                }
            }
        }
    }
}
