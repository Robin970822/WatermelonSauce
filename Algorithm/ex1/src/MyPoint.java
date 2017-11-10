public class MyPoint{
	private int x;
	private int y;

	public MyPoint(){x=0;y=0;}

	public MyPoint(int x, int y){this.x = x;this.y = y;}

	public void setX(int x){this.x = x;}

	public void setY(int y){this.y = y;}

	public int getX(){return x;}
	
	public int getY(){return y;}

	public double distance(MyPoint p)	{
		int diffx = p.getX() - this.x;
		int diffy = p.getY() - this.y;
		return Math.sqrt(diffx * diffx + diffy * diffy);
	}
}
