/**
 * 投资问题
 *
 * @author luwei
 * @version
 */

public final class Investment{

	/**
	* 最大投资收益计算算法
	*
	* @param pNum 项目个数
	* @param mAmount 最大总投资钱数
	* @param vFun 投资效益函数[pNum-1][m]
	* @param earning 项目收益矩阵，最优值为earning[pNum][mAmount]，pNum+1行，mAmount+1列
	* @param t 最佳投资方案追踪矩阵，t[i][j]表示i个项目j元钱情况下，最后一个项目投入钱数，pNum+1行，mAmount+1列
	* @return 最大收益
	*/
	public static int maxEarning(int pNum, int mAmount, int[][] vFun, int[][] earning, int[][] t){

		//最大收益矩阵earnning与追踪矩阵t初始化		
		initial(pNum, mAmount, vFun, earning, t);

		for(int p=1; p<=pNum; p++){//不断尝试扩大项目数量
			
			for(int m=1; m<=mAmount; m++){//不断尝试扩大资金额
				
				earning[p][m] = Integer.MIN_VALUE;
				
				//最后一个项目投资金额尝试不断扩大，寻找最大收益
				for(int moneyForLastProj=0; moneyForLastProj<=m; moneyForLastProj++){
					int thisEarning = earning[p-1][m-moneyForLastProj] + vFun[p-1][moneyForLastProj];

					if(thisEarning > earning[p][m]){
						earning[p][m] = thisEarning;
						t[p][m] = moneyForLastProj;
					}
				}
			}
		}
		return earning[pNum][mAmount];
	}

	public static void traceback(int pNum, int mAmount, int[][] t){

		if(pNum == 0 || mAmount == 0) return;

		traceback(pNum - 1, mAmount - t[pNum][mAmount], t);

		System.out.print("The money for project " + pNum + ": " + t[pNum][mAmount]);
		System.out.println();
	}
	
	/**
	 * 最大收益矩阵earnning与追踪矩阵t赋初值
	 */
	private static void initial(int pNum, int mAmount, int[][] vFun, int[][] earning, int[][] t){

		//第一行赋初值0，表示0个项目情况下投资金额收益
		for(int i=0; i<=mAmount; i++){
			earning[0][i] = 0;
			t[0][i] = 0;
		}
		//第一列赋初值0，表示0资金情况下不同项目收益
		for(int j=0; j<=pNum; j++){
			earning[j][0] = 0;
			t[j][0] = 0;
		}
	}

	public static void main(String[] args){	
		
		int[][] vestFunction = {{0, 11, 12, 13, 14, 15}, 
			                    {0, 0, 5, 10, 15, 20}, 
			                    {0, 2, 10, 30, 32, 40},
			                    {0, 20, 21, 22, 23, 24}};
		
		int projNum = vestFunction.length;
		int moneyAmount =  vestFunction[0].length - 1;//投资函数给出了0元收益
		int[][] earning = new int[projNum+1][moneyAmount+1];
		int[][] trace = new int[projNum+1][moneyAmount+1];

		System.out.println("The vest function: ");
		for(int i=0; i<projNum; i++){
			System.out.print("p" + (i+1) + ": ");
			for(int j=0; j<moneyAmount; j++){
				System.out.print(vestFunction[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();

		int maxEarnings = maxEarning(projNum, moneyAmount, vestFunction, earning, trace);

		System.out.println("The max Earnings: " + maxEarnings);

		traceback(projNum, moneyAmount, trace);
	}
}