import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * MatrixCost Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十二月 29, 2017</pre>
 */
public class MatrixCostTest {

    private ArrayList<MatrixCost> matrixCostArrayList;

    private static final int DIVIDED_FLAG = 0;
    private static final int DYNAMIC_FLAG = 1;
    private static final int BACKTRACK_FLAG = 2;
    private static final int BRANCH_FLAG = 3;

    @Before
    public void before() throws Exception {
        matrixCostArrayList = new ArrayList<>();

        FileReader fileReader = new FileReader("F:\\作业\\算法\\算法实验三\\input.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String line = "";
        List<String> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            lines.add(line);
            //输出读取的文件
//            System.out.println(line);
        }

        br.close();
        fileReader.close();

        //取得第一行的行列数
        int size = Integer.parseInt(lines.get(0));
        int[][] Matrix = new int[size][size];

        for (int i = 1; i < lines.size(); i++) {
            int row = i % (size + 1) - 1;
            if (row == -1) {
                MatrixCost matrixCost = new MatrixCost(size, Matrix);
                matrixCostArrayList.add(matrixCost);
                Matrix = new int[size][size];
            } else {
                String[] nums = lines.get(i).split(" ");
                for (int col = 0; col < size; col++) {
                    Matrix[row][col] = Integer.parseInt(nums[col]);
                }
            }
        }

        matrixCostArrayList.add(new MatrixCost(size, Matrix));
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: dynamicCost(int i, int j)
     */
    @Test
    public void testDynamicCost() throws Exception {
//TODO: Test goes here...
        testMatrixCost(DYNAMIC_FLAG);
    }

    /**
     * Method: backtrackCost(int i, int j)
     */
    @Test
    public void testBacktrackCost() throws Exception {
//TODO: Test goes here...
        testMatrixCost(BACKTRACK_FLAG);
    }

    /**
     * Method: branchCost(int i, int j)
     */
    @Test
    public void testBranchCost() throws Exception {
//TODO: Test goes here...
        testMatrixCost(BRANCH_FLAG);
    }

    /**
     * Method: dividedCost(int i, int j)
     */
    @Test
    public void testDividedCost() throws Exception {
//TODO: Test goes here...
        testMatrixCost(DIVIDED_FLAG);
    }

    private void testMatrixCost(int flag) throws Exception {
        long startTime;
        long endTime;

        for (MatrixCost matrixCost : matrixCostArrayList){
            startTime = System.nanoTime();
            switch (flag){
                case DIVIDED_FLAG:
                    matrixCost.dividedCost();
                    break;
                case DYNAMIC_FLAG:
                    matrixCost.dynamicCost();
                    break;
                case BACKTRACK_FLAG:
                    matrixCost.backtrackCost();
                    break;
                case BRANCH_FLAG:
                    matrixCost.branchCost();
                    break;
                default:
                    System.err.println("Unknown Method!");
            }
            endTime = System.nanoTime();
            System.out.println(endTime - startTime);
        }
    }

} 
