package SW_Expert_Academy.level5;

import java.util.Arrays;

public class JumpEquipment {
	
	public int solution(int [] height) {
		int answer = 0, n = height.length - 1;
		int [] temp = height;
		Arrays.sort(temp); // sorting
		answer = temp[n] - temp[n-1] > temp[n] - temp[n-2]
				? temp[n] - temp[n-1] : temp[n] - temp[n-2];   
		for(int i = n - 1; i >= 2; i-=2) {
			answer = Math.max(temp[i] - temp[i - 2], answer);
		}
		for(int j = n - 2; j >= 2; j-=2) {
			answer = Math.max(temp[j] - temp[j - 2], answer);
		}
		
		answer = Math.max(answer, temp[1] - temp[0]);
		return answer;
	}
	
	public static void main(String[] args) {
		JumpEquipment test = new JumpEquipment();
		int [] height = {4,7,5,3,2,4,8,7};
		System.out.println(test.solution(height));
	}
}