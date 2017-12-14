/**
 *Picture compress problem
 *
 * @author luwei
 * 2017-11-12
 */

public final class PicCompress{
	
	public static final int SEGLENMAX = 256;//每段中最大像素个数

	public static final int SEGHEAD = 11;////表示每段段头信息，其中，8位为段中像素个数，3位为段中每个像素需要的存储位数(最多需要8位)。

	private static int segNum = 0;

	/**
	* 求解最小存储空间方法
	* 
	* @param p 各个像素点的灰度值
	* @param minBits minBits[i]表示像素段p[1]-p[i]所需的最少存储位数,minBits长度为像素个数+1
	* @param lastSegPixNum  lastSegPexNum[i]表示对于p[1]-p[i]之间的像素，得到最优划分的最后一个像素段中像素个数， lastSegPexNum长度为像素个数+1
	* @param b b[i]表示对于p[1]-p[i]之间的像素，最后一个分段中每个像素所需存储位数(该段中最大像素位数)，b长度为像素个数+1
	*/
	public static void segPartition(int[] p, int[] minBits, int[] lastSegPixNum, int[] b){

		int pixNum = p.length;
		minBits[0] = 0;
		lastSegPixNum[0] = 0;
		b[0] = 0;
		int[] pixBit = new int[pixNum+1];//临时变量，存储每个像素点需要的位数
		pixBit[0] = 0;

		for(int i=1; i<pixNum+1; i++){//像素个数从1到p.length,求解最优分段
			
			pixBit[i] = length(p[i-1]);//最后一个分段只有1个像素
			int bmax = pixBit[i];
			b[i] = bmax;
			minBits[i] = minBits[i-1] + bmax;
			lastSegPixNum[i] = 1;

			for(int j=2; j<=i && j<=SEGLENMAX; j++){//最后一段像素个数从2开始不断扩大尝试
				if(bmax < pixBit[i-j+1]) bmax = pixBit[i-j+1];

				if(minBits[i] > minBits[i-j]+j*bmax){
					minBits[i] = minBits[i-j] + j*bmax;
					lastSegPixNum[i] = j;
					b[i] = bmax;
				}
			}
			minBits[i] += SEGHEAD;
		}
	}

	/**
	 * 追踪分段信息和各段所需存储位数
	 * @param pixelNum 输入参数，像素数
	 * @param lastSegPixNum 输入参数，最后一个分段像素个数
	 * @param bitNumForLastSeg 输入参数，最后一个分段所需存储位数
	 * @param seg 输出参数，各分段中的像素数量
	 * @param bitsForEachSeg 输出参数，各分段中的每个像素所需存储位数
	 */
	public static void traceback(int pixelNum, int[] lastSegPixNum, int[] bitNumForLastSeg, int[] seg, int[] bitsForEachSeg){
		if(pixelNum == 0) return;

		traceback(pixelNum-lastSegPixNum[pixelNum], lastSegPixNum, bitNumForLastSeg, seg, bitsForEachSeg);

		seg[segNum] = lastSegPixNum[pixelNum];
		bitsForEachSeg[segNum] = bitNumForLastSeg[pixelNum];
		segNum++;
	}

	public static void output(){
	}

	/**
	 * 计算像素p需要的二进制存储位数
	 * @param p 像素值，p>=0
	 * @return 所需二进制存储位数
	 */
	private static int length(int p){
		int b = 1;

		int v = p/2;
		while(v > 0){
			b++;
			v = v/2;
		}
		return b;
	}

	public static void main(String[] args){

//		int[] pixel = {0, 2, 168, 138};
		int[] pixel = {10, 12, 15, 255, 1, 2};
//		int[] pixel = {6, 5, 3, 168, 68, 255};
		int pLength = pixel.length;

		int[] minBitNum = new int[pLength+1];
		int[] lastSegPixNum = new int[pLength+1];
		int[] bitNumForLastSeg = new int[pLength+1];

		System.out.println("The pixel value are: ");
		System.out.print(pixel[0]);
		for(int i=1; i<pLength; i++){
			System.out.print(", " + pixel[i]);
		}
		System.out.println();
		segPartition(pixel, minBitNum, lastSegPixNum, bitNumForLastSeg);
		System.out.println("The optimal value is: " + minBitNum[pLength]);

		int[] segment = new int[pLength+1];
		int[] bitsForEachSeg = new int[pLength+1];

		traceback(pLength, lastSegPixNum, bitNumForLastSeg, segment, bitsForEachSeg);

		System.out.print("Decompose into " + segNum + " segments: " + segment[0]);		
		for(int i=1; i<segNum; i++){
			System.out.print(", " + segment[i]);
		}
		System.out.println();

		System.out.print("Bits for each pixel in segments: " + bitsForEachSeg[0]);
		for(int i=1; i<segNum; i++){
			System.out.print(", " + bitsForEachSeg[i]);
		}
		System.out.println();
/*
		System.out.print("Bits for last segment: ");
		for(int i=0; i<=pLength; i++)
			System.out.print(bitNumForLastSeg[i]);
		System.out.println();
		System.out.print("Last segment pixel Number: ");
		for(int i=0; i<=pLength; i++)
			System.out.print(lastSegPixNum[i]);
		System.out.println();
*/
	}
}