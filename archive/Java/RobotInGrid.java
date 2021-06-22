package ctci;

/*Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns. The robot can only move in two directions, right and down, but certain cells are "off limits" such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.*/
import java.util.ArrayList;

class Point{
	int x;
	int y;

	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class RobotInGrid {

	public static boolean isRightSafe(Point now, int [][] grid){
		return now.y + 1 < grid[0].length && grid[now.x][now.y + 1] != 1;
	}

	public static boolean isDownSafe(Point now, int [][] grid){
		return now.x + 1 < grid.length && grid[now.x + 1][now.y] != 1;
	}

	public static boolean findPath(Point src, Point des, int [][] grid, ArrayList <Point> path){

		if(src.x == des.x && src.y == des.y && grid[des.x][des.y] == 0)
			return true;

		if(isRightSafe(src, grid) && findPath(new Point(src.x, src.y + 1), des, grid, path)){
			path.add(new Point(src.x, src.y + 1));
			return true;
		} if(isDownSafe(src, grid) && findPath(new Point(src.x + 1, src.y), des, grid, path)) {
			path.add(new Point(src.x + 1, src.y));
			return true;
		} 	
		return false;
	}

	public static void printPathInGrid(ArrayList <Point> path, int [][] solution){
		for(int i=0; i<path.size(); i++){
			Point p = path.get(i);
			solution[p.x][p.y] = 5;
		}

		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				System.out.print(solution[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		return;
	}

	public static void main(String[] args) {
		int [][] grid = 
		{
			{0, 1, 1, 0, 0, 1, 0},
			{0, 0, 1, 0, 0, 0, 1},
			{1, 0, 1, 0, 0, 0, 1},
			{0, 0, 0, 0, 1, 1, 0},
			{1, 0, 0, 0, 1, 0, 0},
			{1, 0, 0, 0, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0}
		};

		Point src = new Point(0, 0);
		Point des = new Point(6, 6);

		ArrayList <Point> path = new ArrayList <Point> ();
		path.add(src);
		System.out.println(findPath(src, des, grid, path));

		int [][] solution = new int[8][8];
		printPathInGrid(path, solution);
	}	

}