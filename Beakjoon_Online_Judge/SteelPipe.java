package com.Algorithm;

import java.util.Stack;

// 백준알고리즘 10799번 문제 쇠막대기
public class SteelPipe {
/*
  막대기와 레이저를 모두 "(" ")"로 표현하였다.
  이 부분을 구별하기 위해 Stack 자료구조가 합당하다 판단하여
  Stack을 사용하였다.
*/
    public static int solution(String str){
        int answer = 0; // 정답
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < str.length(); i++){
            String target = "" + str.charAt(i);
            // 현재 보고있는 문자열의 index
            if(target.equals("(")) {
              /*
               만약 "("인 경우는 2가지가 있을 수 있다.
               1. 막대기의 시작지점
               2. 레이저
              */
                if (str.charAt(i+1) == ')') {
                    // 위는 "(" 다음이 ")"라면 레이저라는 뜻이므로
                    answer += stack.size();
                    // 막대기를 자른다. 이 때 막대기가 레이저에 잘려지면
                    // 하나의 막대기가 더 생기므로 stack의 size만큼 더 해준다.
                    i++;
                } else {
                    answer++; // 만약 레이저가 아니라면 막대기이므로 answer++
                    stack.push(target); // 그리고 stack에 "("를 push
                }
            }
            else {
                stack.pop(); // 그 외 경우 ")"는 막대기의 마지막 부분을 의미하므로 pop()
            }
        }
        return answer; // 이렇게 생긴 총 막대기의 수 return
    }

    public static void main(String[] args) {
        String str = "(((()(()()))(())()))(()())";
        System.out.println(solution(str)); // 24
    }

    // 따라서 O(n)의 복잡도가 들 것으로 예상
}
