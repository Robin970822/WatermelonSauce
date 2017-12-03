/**
 * 背包问题
 *
 * @author luwei
 * @
 */

public final class Knapsack{

	/**
	 * 0-1背包问题最大装载价值计算算法
	 *
	 * @param kc 背包容量
	 * @param w 物品重量数组
	 * @param v 物品价值数组
	 * @param maxValue 求解结果矩阵,maxValue[n][kc]为n种物品背包容量为kc情况下的最大装载价值,矩阵维数为w和kc的维数分别+1
	 */
	public static int maxLoadValue01(int kc, int[] w, int[] v, int[][] maxValue){

		//结果矩阵maxValue初始化		
		int gNum = w.length;
		for(int i=0; i<=gNum; i++)	maxValue[i][0] = 0;//背包容量为0初值
		for(int j=0; j<=kc; j++)	maxValue[0][j] = 0;//物品为0初值

		//递推求解最大价值
		for(int g=1; g<=gNum; g++){
			//背包容量循环变量边界
			int cBound = min(w[g-1], kc+1);

			//容量不够装入第i个物品，第i个物品的重量有可能超过背包容量，要防止数组越界.
			for(int c=1; c<cBound; c++){
				maxValue[g][c] = maxValue[g-1][c];
			}

			for(int c=w[g-1]; c<=kc; c++){
				maxValue[g][c] = max(maxValue[g-1][c], maxValue[g-1][c-w[g-1]]+v[g-1]);
			}
		}
		
		return maxValue[gNum][kc];
	}

	/**
	 * 追踪装载物品
	 *
	 * @param maxValue 求解结果矩阵
	 * @param weights 物品重量数组
	 * @param x 是否装载物品向量
	 */
	public static void traceback01(int[][] maxValue, int[] weights, int[] x){

		int gNum = maxValue.length-1;
		int kc = maxValue[0].length-1;

		for(int i=gNum; i>0; i--){
			if(maxValue[i][kc] == maxValue[i-1][kc]){//不装第i个物品，对应向量x[i-1]
				x[i-1] = 0;
			}
			else{//装入第i个物品
				x[i-1] = 1;
				kc -= weights[i-1];
			}
		}
	}

	/**
	 * 0-N背包问题最大装载价值计算算法
	 *
	 * @param kc 背包容量
	 * @param w 物品重量数组
	 * @param v 物品价值数组
	 * @param maxValue 求解结果矩阵,maxValue[n][kc]为n种物品背包容量为kc情况下的最大装载价值,矩阵维数为w和kc的维数分别+1
	 */
	public static int maxLoadValue0N(int kc, int[] w, int[] v, int[][] maxValue){

		//结果矩阵maxValue初始化		
		int gNum = w.length;
		for(int i=0; i<=gNum; i++)	maxValue[i][0] = 0;//背包容量为0初值
		for(int j=0; j<=kc; j++)	maxValue[0][j] = 0;//物品为0初值

		//递推求解最大价值
		for(int g=1; g<=gNum; g++){
			//背包容量循环变量边界
			int cBound = min(w[g-1], kc+1);

			//容量不够装入第i个物品，第i个物品的重量有可能超过背包容量，要防止数组越界.
			for(int c=1; c<cBound; c++){
				maxValue[g][c] = maxValue[g-1][c];
			}

			for(int c=w[g-1]; c<=kc; c++){
				maxValue[g][c] = max(maxValue[g-1][c], maxValue[g][c-w[g-1]]+v[g-1]);
			}
		}
		return maxValue[gNum][kc];
	}

	/**
	 * the same as traceback01
	 */
	public static void traceback0N(int[][] maxValue, int[] weights, int[] x){

		int gNum = maxValue.length-1;
		int kc = maxValue[0].length-1;

		for(int i=0; i<gNum; i++)	x[i] = 0;

		for(int i=gNum; i>0;){
			if(maxValue[i][kc] == maxValue[i-1][kc]){//不装第i个物品，对应向量x[i-1]
				i--;
			}
			else{//装入第i个物品
				x[i-1]++;
				kc -= weights[i-1];
			}
		}
	}

	private static int max(int a, int b){
		return a > b ? a : b;
	}

	private static int min(int a, int b){
		return a < b ? a : b;
	}


	public static void main(String[] args){	
		
		final int capacity = 10;
		int[] weights = {2, 2, 6, 5, 4};
		int[] values = {6, 3, 5, 4, 6};
		
//		int[] weights = {2, 3, 4, 7};
//		int[] values = {1, 3, 5, 9};

		int[][] maxValue = new int[weights.length+1][capacity+1];

		System.out.println("Knapsack capacity: " + capacity);

		System.out.print("weights: " + weights[0]);
		for(int i=1; i<weights.length; i++)
			System.out.print(", " + weights[i]);
		System.out.println();

		System.out.print("values: " +values[0]);
		for(int i=1; i<values.length; i++)
			System.out.print(", " + values[i]);
		System.out.println();
		
		System.out.println("The max value is under 0-1 constraint: " + maxLoadValue01(capacity, weights, values, maxValue));

		int[] x = new int[weights.length];//物品是否装入向量
		traceback01(maxValue, weights, x);

		System.out.print( "The load plan is under 0-1 constraint: " + x[0]);
		for(int i=1; i<x.length; i++)
			System.out.print( ", " + x[i]);
		System.out.println();
		System.out.println();

		System.out.println("The max value is under 0-N constraint: " + maxLoadValue0N(capacity, weights, values, maxValue));
		traceback0N(maxValue, weights, x);
				System.out.print( "The load plan is under 0-N constraint: " + x[0]);
		for(int i=1; i<x.length; i++)
			System.out.print( ", " + x[i]);
		System.out.println();
	}
}