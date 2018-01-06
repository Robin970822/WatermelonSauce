public class Strategy {

    /**
     * 消耗
     */
    private int cost;
//    /**
//     * 下界消耗
//     */
//    private int minCost;
    /**
     * 前一个节点
     */
    private Strategy previous;
    /**
     * 坐标x
     */
    private int x;
    /**
     * 坐标y
     */
    private int y;

//    public Strategy(int x, int y, int cost, int minCost){
//        this.x = x;
//        this.y = y;
//        this.cost = cost;
//        this.minCost = minCost;
//        previous = null;
//    }

    public Strategy(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
        previous = null;
    }

    public Strategy(){
        this.x = -1;
        this.y = -1;
        cost = Integer.MAX_VALUE;
        previous = null;
    }

    public int getCost() {
        return cost;
    }

    public Strategy getPrevious() {
        return previous;
    }

    public void setPrevious(Strategy previous) {
        this.previous = previous;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

//    public int getMinCost() {
//        return minCost;
//    }
}
