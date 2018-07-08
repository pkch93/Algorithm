package Programmers.Algorithm;

import java.util.LinkedList;

public class LineRule {
	
	public int factorial(int n) {
		int answer = 1;
		for(int i = 1; i <= n; i++) answer *= i;
		return answer;
	}
	
	public int[] solution(int n, long k) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) list.add(i);
		int [] answer = new int[n];
		long p = k - 1;
		for(int i = 0; i < n; i++) {
			if(p == 0) {
				answer[i] = list.remove(0);
				continue;
			}
			int temp = factorial(n - 1 - i);
			int index = (int) (p / temp);
			answer[i] = list.remove(index);
			p %= temp;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		LineRule test = new LineRule();
		int [] answer = test.solution(20, 2123123412);
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}
