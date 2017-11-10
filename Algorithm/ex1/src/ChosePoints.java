/**
 * This class use for finding closes points
 *
 * @author luwei
 * @version 1.0
 * @date 2017-10-29
 */

public final class ChosePoints {

    /**
     * 蛮力法求解平面最近点对
     *
     * @param p                 平面点集合
     * @param closesPointsIndex 最近点对索引
     */
    public static void bruteForceClosesPoints(MyPoint[] p, int[] closesPointsIndex) {
        double dmin = 100000;
        int index0 = -1 ;
        int index1 = -1 ;

        for (int i = 0; i < p.length - 1; i++) {
            for (int j = i + 1; j < p.length; j++) {
                double d = (p[i].getX() - p[j].getX()) * (p[i].getX() - p[j].getX())
                        + (p[i].getY() - p[j].getY()) * (p[i].getY() - p[j].getY());
                if (d < dmin) {
                    dmin = d;
                    index0 = i;
                    index1 = j;
                }
            }
        }

        closesPointsIndex[0] = index0;
        closesPointsIndex[1] = index1;
    }

    public static void main(String[] args) {

        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(1, 1);
        MyPoint p3 = new MyPoint(1, 2);
        MyPoint p4 = new MyPoint(3, 1);

        MyPoint[] p = {p1, p2, p3, p4};
        int[] closesPointsIndex = {-1, -1};

        bruteForceClosesPoints(p, closesPointsIndex);

        System.out.println(closesPointsIndex[0]);
        System.out.println(closesPointsIndex[1]);
    }
}