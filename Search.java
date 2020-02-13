/*
* @Author: root
* @Date:   2020-01-04 23:33:53
* @Last Modified by:   H-f-society
* @Last Modified time: 2020-02-13 21:09:50
*/
import java.util.*;
import java.util.Queue;

public class Search {
	public static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        int[][] nums = {
            { 1,  2,  3,  4,  5,  6},
            { 7,  8,  9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18},
            {19, 20, 21, 22, 23, 24},
            {25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36}
        };
        BFS(nums, 0, 0, 35);
    }
    public static void DFS(int[][] nums, int x, int  y, int target) {
    	
    }
    public static void BFS(int[][] nums, int x, int y, int target) {
        int[][] flag = new int[nums.length][nums[0].length];
        Queue<Integer> queX = new LinkedList<>();
        Queue<Integer> queY = new LinkedList<>();
        queX.offer(x);
        queY.offer(y);
        int count = 0;
        while(!queX.isEmpty() && !queY.isEmpty()) {
            int i = queX.poll();
            int j = queY.poll();
            System.out.println(++count + ", [" + i + ", " + j + "]" + "==" + nums[i][j]);
            if(nums[i][j] == target) {
				System.out.println(i + ", " +j);
					break;
            }
            flag[i][j] = 1;
            for(int k=0; k<direction.length; k++) {
            	if(Transboundary(nums, i+direction[k][0], j+direction[k][1]) && flag[i+direction[k][0]][j+direction[k][1]] != 1) {
            		queX.offer(i+direction[k][0]);
            		queY.offer(j+direction[k][1]);
            		flag[i+direction[k][0]][j+direction[k][1]] = 1;
            	}
            }
        }
    }
    public static boolean Transboundary(int[][] nums, int x, int y) {
        if(x>=0 && x<nums.length && y>=0 && y<nums[0].length)
            return true;
        return false;
    }
}
=======
/*
* @Author: root
* @Date:   2020-01-04 23:33:53
* @Last Modified by:   root
* @Last Modified time: 2020-01-08 01:09:23
*/
import java.util.*;
import java.util.Queue;

public class Search {
	public static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        int[][] nums = {
            { 1,  2,  3,  4,  5,  6},
            { 7,  8,  9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18},
            {19, 20, 21, 22, 23, 24},
            {25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36}
        };
        BFS(nums, 0, 0, 35);
    }
    public static void DFS(int[][] nums, int x, int  y, int target) {
    	
    }
    public static void BFS(int[][] nums, int x, int y, int target) {
        int[][] flag = new int[nums.length][nums[0].length];
        Queue<Integer> queX = new LinkedList<>();
        Queue<Integer> queY = new LinkedList<>();
        queX.offer(x);
        queY.offer(y);
        int count = 0;
        while(!queX.isEmpty() && !queY.isEmpty()) {
            int i = queX.poll();
            int j = queY.poll();
            System.out.println(++count + ", [" + i + ", " + j + "]" + "==" + nums[i][j]);
            if(nums[i][j] == target) {
				System.out.println(i + ", " +j);
					break;
            }
            flag[i][j] = 1;
            for(int k=0; k<direction.length; k++) {
            	if(Transboundary(nums, i+direction[k][0], j+direction[k][1]) && flag[i+direction[k][0]][j+direction[k][1]] != 1) {
            		queX.offer(i+direction[k][0]);
            		queY.offer(j+direction[k][1]);
            		flag[i+direction[k][0]][j+direction[k][1]] = 1;
            	}
            }
        }
    }
    public static boolean Transboundary(int[][] nums, int x, int y) {
        if(x>=0 && x<nums.length && y>=0 && y<nums[0].length)
            return true;
        return false;
    }
}
>>>>>>> 7e639d274c1ed6a823796ee263f3ef3984b156cf
