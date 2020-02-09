/*
* @Author: root
* @Date:   2020-02-09 21:42:39
* @Last Modified by:   root
* @Last Modified time: 2020-02-10 03:37:38
*/

import java.util.*;

public class AStar {
	public static int[] startPoint = {1, 0};
	public static int[] endPoint   = {7, 19};
	public static int[][] map = {
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		{0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
		{1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
		{1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
		{1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1},
		{1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
		{1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1},
		{1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
		{1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
	};
	public static int[][] dires = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int STRAIGHT_COST = 10;
    private static final int OBLIQUE_COST = 14;

	class Pos {
		int[] ps;
		int f, g, h;
		Pos parent;
		public Pos(int[] ps) {
			this.ps = ps;
		}
	}
	public List<Pos> searchPath(int[] start, int[] end) {
		int[][] flag = new int[map.length][map[0].length];
		List<Pos> result    = new ArrayList<>();
		LinkedList<Pos> openList  = new LinkedList<>();
		LinkedList<Pos> closeList = new LinkedList<>();
		openList.offer(new Pos(start));
		closeList.offer(openList.peek());
		while(!openList.isEmpty()) {
			Pos nowPoint = openList.poll();
			if(nowPoint.ps[0]==end[0] && nowPoint.ps[1]==end[1]) {
				do {
					result.add(nowPoint);
					nowPoint = nowPoint.parent;
				}while(nowPoint.ps[0]!=start[0] || nowPoint.ps[1]!=start[1]);
				result.add(nowPoint);
			}
			for(int i=0; i<dires.length; i++) {
				int x = nowPoint.ps[0] + dires[i][0];
				int y = nowPoint.ps[1] + dires[i][1];
				Pos pos = new Pos(new int[]{x, y});
				int g = nowPoint.g + OBLIQUE_COST;
				if(Transboundary(map, x, y) && map[x][y]==0 && flag[x][y]==0) {
					pos.h = Math.abs(pos.ps[0]-end[0]) * Math.abs(pos.ps[0]-end[0]);
					pos.g = g;
					pos.f = pos.g + pos.h;
					pos.parent = nowPoint;
					if(!openList.isEmpty() && pos.f < openList.peek().f)
						openList.add(0, pos);
					else openList.offer(pos);
					closeList.offer(pos);
					flag[x][y] = 1;
				}
			}
		}
		return result;
	}
	public static boolean Transboundary(int[][] nums, int x, int y) {
        if(x>=0 && x<nums.length && y>=0 && y<nums[0].length)
            return true;
        return false;
    }
    public static void printMap() {
    	System.out.println();
    	for(int i=0; i<map.length; i++) {
    		for(int j=0; j<map[0].length; j++) {
    			System.out.print(map[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
 	public static void main(String[] args) {
 		AStar astar = new AStar();
 		List<Pos> result = astar.searchPath(startPoint, endPoint);
		for(int i=result.size()-1; i>=0; i--) {
			System.out.print("["+result.get(i).ps[0] + ", " + result.get(i).ps[1] + "]-->");
			map[result.get(i).ps[0]][result.get(i).ps[1]] = 5;
		}
		printMap();

	}
}