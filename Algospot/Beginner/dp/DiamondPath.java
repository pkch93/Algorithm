package Algospot.beginner;

public class DiamondPath {
	int [][] dp; 
	public int solution(int[][] arr, int n) {
		this.dp = arr;
		for(int i = 1; i < dp.length; i++) {
			if(i < n) {
				for(int j = 0; j < dp[i].length; j++) {
					if(j == 0) dp[i][j] = dp[i][j] + dp[i - 1][j];
					else if(j == dp[i].length - 1) dp[i][j] = dp[i][j] + dp[i - 1][j - 1];
					else {
						dp[i][j] = Math.max(dp[i][j] + dp[i-1][j-1], dp[i][j] + dp[i-1][j]);
					}
				}
			}
			else {
				for(int x = 0; x < dp[i].length; x++) {
					dp[i][x] = Math.max(dp[i][x] + dp[i-1][x+1], dp[i][x] + dp[i-1][x]);
				}
			}
		}
		return dp[dp.length-1][0];
	}
	
	public static void main(String[] args) {
		DiamondPath test = new DiamondPath();
		int n = 5;
		int [][] arr = {
				{6},
				{1,2},
				{6,7,4},
				{9,4,1,7},
				{6,7,5,9,4},
				{4,4,3,2},
				{1,2,3},
				{6,1},
				{7}
		};
		
		int [][] arr2 = {
				{39},
				{43,16},
				{74,94,24},
				{25,76,98,62},
				{79,58,71,67,98},
				{43,55,27,44},
				{10,96,56},
				{73,31},
				{95}
		};
		System.out.println(test.solution(arr, n));
		System.out.println(test.solution(arr2, n));
	}
}
