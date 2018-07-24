package Programmers.Algorithm;

import java.util.*;

public class PairsRemove {
	
	public int solution(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int l = 0, r = l + 1, n = s.length();
		for(; l < n && r < n;) {
			char cur = s.charAt(r), prev = s.charAt(l);
			if(cur == prev) {
				if(stack.empty()) {
					l = r + 1;
					r = l + 1;
				}
				else {
					l = stack.pop();
					r++;
				}
			}
			else {
				stack.push(l);
				l = r;
				r = l + 1;
			}
		}
		return l >= n && r >= n ? 1 : 0;
	}
	
	public static void main(String[] args) {
		PairsRemove test = new PairsRemove();
		String s = "abcdeedcb";
		System.out.println(test.solution(s));
	}
}
