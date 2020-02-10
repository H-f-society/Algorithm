/*
* @Author: root
* @Date:   2020-02-10 20:17:35
* @Last Modified by:   root
* @Last Modified time: 2020-02-10 20:22:26
*/
public class DP {
	public static void main(String[] args) {
		System.out.println(getPathSum(3, 7));
	}
	public static int getPathSum(int row, int col) {
		int[][] dp = new int[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(i==0 || j==0) dp[i][j] = 1;
				else dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[row-1][col-1];
	}
}
