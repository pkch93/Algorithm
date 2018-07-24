package Programmers.Algorithm;

public class ColoringBook {
	int [][] picture;
	boolean [][] isGroup;
	public int makeGroup(int i, int j, int prev) {
		if(picture[i][j] != prev || isGroup[i][j]) return 0;
		isGroup[i][j] = true;
		int count = 1;
		
		if(i+1 < picture.length) count += makeGroup(i+1, j, prev);
		if(i-1 >= 0) count += makeGroup(i-1, j, prev);
		if(j+1 < picture[0].length) count += makeGroup(i, j+1, prev);
		if(j-1 >= 0) count += makeGroup(i, j-1, prev);
		return count;
	}
	
	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		this.picture = picture;
		isGroup = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				int groupNum = picture[i][j];
				int count = 0;
				if(!isGroup[i][j] && groupNum != 0) {
					count = makeGroup(i, j, groupNum);
					numberOfArea++;
				}
				maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count); 
			}
		}
		int [] answer = {numberOfArea, maxSizeOfOneArea};
		return answer;
	}
	
	public static void main(String[] args) {
		ColoringBook test = new ColoringBook();
		int [][] picture = {
				{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
				{0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
				{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},
				{0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
				{0,1,1,1,1,2,1,1,1,1,2,1,1,1,1,0},
				{0,1,1,1,2,1,2,1,1,2,1,2,1,1,1,0},
				{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
				{0,1,3,3,3,1,1,1,1,1,1,3,3,3,1,0},
				{0,1,1,1,1,1,2,1,1,2,1,1,1,1,1,0},
				{0,0,1,1,1,1,1,2,2,1,1,1,1,1,0,0},
				{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},
				{0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
		};
		int m = 13, n = 16;
		int [] answer = test.solution(m, n, picture);
		System.out.println(answer[0] + " " + answer[1]);
	}
}
