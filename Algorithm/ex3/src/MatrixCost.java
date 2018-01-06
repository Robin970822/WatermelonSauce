import java.util.*;

public class MatrixCost {

    /**
     * 矩阵大小
     */
    private int size;

    /**
     * 矩阵
     */
    private int[][] Matrix;


    /**
     * 最小耗费矩阵
     */
    private int[][] cost;

    /**
     * 追踪矩阵
     */
    private int[][] backtrack;

    /**
     * 当前最优路径
     */
    private int[] bestPath;

    /**
     * 当前路径
     */
    private int[] currentPath;

    /**
     * 最优路径耗费
     */
    private int bestCost;

    /**
     * 当前路径耗费
     */
    private int currentCost;

    /**
     * 耗费下限
     */
    private int minCost;

    /**
     * 追踪矩阵内容
     */
    private static final int fromUp = 1;
    private static final int fromLeft = -1;
    private static final int isStart = 0;

    /**
     * 最大整型
     */
    private static final int Max = Integer.MAX_VALUE;

    /**
     * 构造函数
     *
     * @param size   矩阵大小
     * @param Matrix 矩阵
     */
    public MatrixCost(int size, int[][] Matrix) {
        this.size = size;
        this.Matrix = Matrix;
        this.cost = new int[size][size];
        this.backtrack = new int[size][size];
        this.bestPath = new int[2 * size - 1];
        this.currentPath = new int[2 * size - 1];

        backtrack[0][0] = isStart;
        bestPath[0] = 0;
        bestPath[2 * size - 2] = size * size - 1;
        currentPath[0] = 0;
        currentPath[2 * size - 2] = size * size - 1;
    }

    /**
     * 分治法求数字和最小路径
     */
    public void dividedCost() {
        bestCost = dividedCost(size - 1, size - 1);
        System.out.println("分治法：\t\t" + bestCost);
        outputPath();
    }

    /**
     * 动态规划求数字和最小路径
     */
    public void dynamicCost() {
        bestCost = dynamicCost(size - 1, size - 1);
        System.out.println("动态规划：\t" + bestCost);
        outputPath();
    }

    /**
     * 贪心法求数字和最小路径近似
     */
    public void greedyCost() {
        bestCost = greedyCost(0, 0);
        System.out.println("贪心法：\t\t" + bestCost);
        outputPath();
        outputBestPath();
    }

    /**
     * 对角线求下界函数
     */
    public void minCost() {
        int cost = minCost(0, 0);
        System.out.println("路径下界：\t" + cost);
    }

    /**
     * 回溯法求数字和最小路径
     */
    public void backtrackCost() {
        /*
        上界贪心，下界对角线最小值和
         */
        bestCost = greedyCost(0, 0);
        minCost = minCost(0, 0);
        if (bestCost > minCost) {
            currentCost = 0;
            bestCost = backtrackCost(0, 0);
        }
        System.out.println("回溯法：\t\t" + bestCost);
        outputBestPath();
    }

    public void branchCost() {
        /*
        上界贪心，下界对角线最小值和
         */
        bestCost = greedyCost(0, 0);
        minCost = minCost(0, 0);
        if (bestCost > minCost) {
            Strategy strategy = branchCost(0,0);
            System.out.println("分支限界：\t" + bestCost);
            outputStrategy(strategy);
        }else {
            System.out.println("分支限界：\t" + bestCost);
            outputBestPath();
        }
    }

    /**
     * 分治法求(0,0)到(i,j)的数字和最小路径
     *
     * @param i 目标点行数 0<=i<=size-1
     * @param j 目标点列数 0<=j<=size-1
     * @return 最小路径
     */
    private int dividedCost(int i, int j) {
        if (i == 0 && j == 0) {//初始点
            backtrack[i][j] = isStart;
            return Matrix[i][j];
        } else if (i == 0) {//行为零，从左方到达该点
            backtrack[i][j] = fromLeft;
            return dividedCost(i, j - 1) + Matrix[i][j];
        } else if (j == 0) {//列为零，上方到达该点
            backtrack[i][j] = fromUp;
            return dividedCost(i - 1, j) + Matrix[i][j];
        } else {
            int left = dividedCost(i, j - 1);
            int up = dividedCost(i - 1, j);
            if (left < up) {//从左方到达该点
                backtrack[i][j] = fromLeft;
                return dividedCost(i, j - 1) + Matrix[i][j];
            } else {//从上方到达该点
                backtrack[i][j] = fromUp;
                return dividedCost(i - 1, j) + Matrix[i][j];
            }
        }
    }

    /**
     * 动态规划求(0,0)到(i,j)的数字和最小路径
     *
     * @param i 目标点行数 0<=i<=size-1
     * @param j 目标点列数 0<=j<=size-1
     * @return 最小路径
     */
    private int dynamicCost(int i, int j) {
        for (int row = 0; row <= i; row++) {
            for (int col = 0; col <= j; col++) {
                if (row == 0 && col == 0) {//初始点
                    cost[row][col] = Matrix[row][col];
                    backtrack[row][col] = isStart;
                } else if (row == 0) {//行为零，从左方到达该点
                    cost[row][col] = cost[row][col - 1] + Matrix[row][col];
                    backtrack[row][col] = fromLeft;
                } else if (col == 0) {//列为零，上方到达该点
                    cost[row][col] = cost[row - 1][col] + Matrix[row][col];
                    backtrack[row][col] = fromUp;
                } else if (cost[row - 1][col] < cost[row][col - 1]) {//从上方到达该点
                    cost[row][col] = cost[row - 1][col] + Matrix[row][col];
                    backtrack[row][col] = fromUp;
                } else {//从左方到达该点
                    cost[row][col] = cost[row][col - 1] + Matrix[row][col];
                    backtrack[row][col] = fromLeft;
                }
            }
        }
        return cost[i][j];
    }

    /**
     * 贪心法求(i,j)到(size-1,size-1)的数字和最小路径
     *
     * @param i 初始点行数 0<=i<=size-1
     * @param j 初始点列数 0<=j<=size-1
     * @return 最小路径
     */
    private int greedyCost(int i, int j) {
        int cost = Matrix[i][j];
        int row = i;
        int col = j;
        bestPath[row + col] = row * size + col;
        while (true) {
            if (row >= size - 1 && col >= size - 1) {
                break;
            } else if (row >= size - 1) {//行到底，向右走
                cost += Matrix[row][col + 1];
                bestPath[row + col] = row * size + col;
                col++;
                backtrack[row][col] = fromLeft;
            } else if (col >= size - 1) {//列到底，向下走
                cost += Matrix[row + 1][col];
                bestPath[row + col] = row * size + col;
                row++;
                backtrack[row][col] = fromUp;
            } else if (Matrix[row + 1][col] < Matrix[row][col + 1]) {//向下走
                cost += Matrix[row + 1][col];
                bestPath[row + col] = row * size + col;
                row++;
                backtrack[row][col] = fromUp;
            } else {//向右走
                cost += Matrix[row][col + 1];
                bestPath[row + col] = row * size + col;
                col++;
                backtrack[row][col] = fromLeft;
            }
        }
        return cost;
    }

    /**
     * 下界函数求(i,j)到(size-1,size-1)的数字和下界路径
     *
     * @param i 初始点行数 0<=i<=size-1
     * @param j 初始点列数 0<=j<=size-1
     * @return 下界
     */
    private int minCost(int i, int j) {
        int cost = 0;
        for (int p = i + j; p < 2 * size - 1; p++) {
            int temp = Max;
            for (int q = i; q <= p; q++) {
                if (q < size && p - q < size && p - q >= j) {
                    if (Matrix[q][p - q] < temp) {
                        temp = Matrix[q][p - q];
                    }
                }
            }
            cost += temp;
        }
        return cost;
    }

    /**
     * 回溯法求(i,j)到(size-1,size-1)的数字和最小路径
     *
     * @param i 初始点行数 0<=i<=size-1
     * @param j 初始点列数 0<=j<=size-1
     * @return 最小路径
     */
    private int backtrackCost(int i, int j) {
        /*
        加入路径
         */
        currentCost += Matrix[i][j];
        currentPath[i + j] = i * size + j;

        if (i >= size - 1 && j >= size - 1) {
            if (currentCost < bestCost) {
                bestCost = currentCost;
                for (int k = 0; k < bestPath.length; k++) {
                    bestPath[k] = currentPath[k];
                }
            }
        } else {
            if (currentCost < bestCost) {//如果当前耗费未超过上界
                if (i >= size - 1) {//向下触底
                    backtrackCost(i, j + 1);//向右
                } else if (j >= size - 1) {//向右触底
                    backtrackCost(i + 1, j);//向下
                } else {
                    backtrackCost(i, j + 1);//向右
                    backtrackCost(i + 1, j);//向下
                }
            }
        }
        /*
        回溯返回
         */
        currentCost -= Matrix[i][j];
        currentPath[i + j] = -1;
        return bestCost;
    }

    /**
     * 分支限界求(i,j)到(size-1,size-1)的数字和最小路径
     *
     * @param i 初始点行数 0<=i<=size-1
     * @param j 初始点列数 0<=j<=size-1
     * @return 最小路径
     */
    private Strategy branchCost(int i, int j) {
        Strategy bestStrategy = new Strategy();
        Queue<Strategy> strategyQueue = new PriorityQueue<>(size * size, Comparator);
        strategyQueue.add(new Strategy(i, j, Matrix[i][j]));

        while (!strategyQueue.isEmpty()) {
            Strategy strategy = strategyQueue.poll();

            int row = strategy.getX();
            int col = strategy.getY();
            int cost = strategy.getCost();

            if (row >= size - 1 && col >= size - 1) {
                if (cost < bestCost) {//达到最优解
                    bestCost = cost;
                    bestStrategy = strategy;
                }
            } else if (row >= size - 1) {//向下触底
//                Strategy temp = new Strategy(row,col + 1, cost + Matrix[row][col + 1],
//                        cost + minCost(row, col + 1));
                Strategy temp = new Strategy(row,col + 1, cost + Matrix[row][col + 1]);
                temp.setPrevious(strategy);
                strategyQueue.add(temp);
            } else if (col >= size - 1) {//向右触底
//                Strategy temp = new Strategy(row + 1,col, cost + Matrix[row + 1][col],
//                        cost + minCost(row + 1, col));
                Strategy temp = new Strategy(row + 1,col, cost + Matrix[row + 1][col]);
                temp.setPrevious(strategy);
                strategyQueue.add(temp);
            } else {
            /*
            向右的耗费以及下界耗费
             */
                int rightCost = cost + Matrix[row][col + 1];
//                int minRightCost = cost + minCost(row, col + 1);

            /*
            向下的耗费以及下界耗费
             */
                int downCost = cost + Matrix[row + 1][col];
//                int minDownCost = cost + minCost(row + 1, col);
                if (rightCost < bestCost){//向右的消耗小于当前最优耗费
                    Strategy temp = new Strategy(row, col + 1, rightCost);
                    temp.setPrevious(strategy);
                    strategyQueue.add(temp);
                }
                if (downCost < bestCost) {//向下的耗费小于当前最优耗费
                    Strategy temp = new Strategy(row + 1, col, downCost);
                    temp.setPrevious(strategy);
                    strategyQueue.add(temp);
                }

//                if (minDownCost <= minRightCost){//向下的下界耗费小于向右的下界耗费
//                    if (minDownCost < bestCost) {//向下的下界耗费小于当前最优耗费
//                        Strategy temp = new Strategy(row + 1, col, downCost, minDownCost);
//                        temp.setPrevious(strategy);
//                        strategyQueue.add(temp);
//                    }
//                    if (minRightCost < bestCost) {//向右的下界耗费小于当前最优耗费
//                        Strategy temp = new Strategy(row, col + 1, rightCost, minRightCost);
//                        temp.setPrevious(strategy);
//                        strategyQueue.add(temp);
//                    }
//                }else {
//                    if (minRightCost < bestCost) {//向右的下界耗费小于当前最优耗费
//                        Strategy temp = new Strategy(row, col + 1, rightCost, minRightCost);
//                        temp.setPrevious(strategy);
//                        strategyQueue.add(temp);
//                    }
//                    if (minDownCost < bestCost) {//向下的下界耗费小于当前最优耗费
//                        Strategy temp = new Strategy(row + 1, col, downCost, minDownCost);
//                        temp.setPrevious(strategy);
//                        strategyQueue.add(temp);
//                    }
//                }
            }
        }

        return bestStrategy;
    }

    private static Comparator<Strategy> Comparator = new Comparator<Strategy>() {
        @Override
        public int compare(Strategy o1, Strategy o2) {
//            if(o2.getMinCost() - o1.getMinCost() == 0) {
//                return o2.getCost() - o1.getCost();
//            }else return o2.getMinCost() - o1.getMinCost();
            return o2.getCost() - o1.getCost();
        }
    };

    /**
     * 使用栈输出路径
     */
    private void outputPath() {

        int row = size - 1;
        int col = size - 1;
        /*
        入栈
         */
        Stack<String> pathString = new Stack<>();
        while (true) {
            if (backtrack[row][col] == isStart) {
                pathString.push(pointString(row, col));
                break;
            } else if (backtrack[row][col] == fromUp) {
                pathString.push(pointString(row, col));
                row--;
            } else if (backtrack[row][col] == fromLeft) {
                pathString.push(pointString(row, col));
                col--;
            }
        }
        /*
        出栈
         */
        String point = pathString.pop();
        System.out.print(point);
        while (!pathString.isEmpty()) {
            System.out.print(",");
            point = pathString.pop();
            System.out.print(point);
        }
        System.out.println();
    }

    /**
     * 使用队列输出路径
     */
    private void outputBestPath() {
        for (int temp : bestPath) {
            int row = temp / size;
            int col = temp % size;
            System.out.print(pointString(row, col));
            if (temp != size * size - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    private void outputStrategy(Strategy strategy) {

        Stack<String> stringStack = new Stack<>();
        /*
        入栈
         */
        stringStack.push(pointString(strategy.getX(),strategy.getY()));
        Strategy temp = strategy.getPrevious();
        while (temp != null) {
            stringStack.push(pointString(temp.getX(), temp.getY()));
            temp = temp.getPrevious();
        }
        /*
        出栈
         */
        String point = stringStack.pop();
        System.out.print(point);
        while (!stringStack.isEmpty()) {
            System.out.print(",");
            point = stringStack.pop();
            System.out.print(point);
        }
        System.out.println();

    }

    /**
     * 根据矩阵坐标输出坐标字符串
     *
     * @param row 行坐标
     * @param col 列坐标
     * @return 坐标字符串
     */
    private String pointString(int row, int col) {
        return "(" + (row + 1) + "," + (col + 1) + ")";
    }

    public static void main(String[] args) {
//        int size = 5;
//        int[][] Matrix = {{6, 3, 7, 1, 5}, {4, 3, 6, 3, 9}, {9, 6, 3, 3, 5},
//                {1, 3, 0, 0, 6}, {7, 7, 0, 2, 4}};
        int size = 3;
        int[][] Matrix = {{2, 8, 1}, {2, 8, 2}, {4, 8, 5}};
        MatrixCost matrixCost = new MatrixCost(size, Matrix);
        matrixCost.minCost();
//        matrixCost.dividedCost();
//        matrixCost.dynamicCost();
        matrixCost.greedyCost();
//        matrixCost.backtrackCost();
        matrixCost.branchCost();
    }
}
