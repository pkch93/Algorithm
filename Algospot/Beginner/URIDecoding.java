package Algospot.beginner;

import java.util.Scanner;

public class URIDecoding {
	
	public String solution(String str) {
		String result = "";
		for(int i = 0; i < str.length(); i++){
			char target = str.charAt(i);
			if(target == '%') {
				char k = str.charAt(i+2);
				switch(k) {
					case '0' :
						result += " ";
						break;
					case '1' :
						result += "!";
						break;
					case '4' :
						result += "$";
						break;
					case '5' :
						result += "%";
						break;
					case '8' :
						result += "(";
						break;
					case '9' :
						result += ")";
						break;
					case 'a' :
						result += "*";
						break;
					default :
						break;
				}
			i += 2;
			}
			else {
				result += target; 
			}
		}
		return result;
	}
	public static void main(String[] args) {
		URIDecoding test = new URIDecoding();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test_case = 1; test_case <= t; test_case++) {
			String str = sc.next();
			System.out.println(test.solution(str));
		}
		sc.close();
	}
}
