package Programmers.Algorithm;

import java.util.HashSet;

public class EndtoEnd {
	
	public int [] solution(int n, String [] words) {
		int [] answer = {0, 0};
		HashSet<String> set = new HashSet<String>();
		char previous = words[0].charAt(words[0].length() - 1);
		set.add(words[0]);
		for(int i=1; i < words.length; i++) {
			char current = words[i].charAt(0);
			if(previous != current || set.contains(words[i])) {
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				break;
			}
			set.add(words[i]);
			previous = words[i].charAt(words[i].length() - 1);
		}
		return answer;
	}
}
