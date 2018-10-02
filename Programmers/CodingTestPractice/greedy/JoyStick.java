package com.Algorithm.programmers.greedy;

// Programmers 코딩테스트 고득점 Kit Greedy 조이스틱
// BOJ 3663번 고득점
public class JoyStick {
    // 알파벳 대문자는 65~90 까지 N(78)이 중간!
    public int solution(String name){
        int answer = 0, n = name.length(),
                leftOrRight = name.length() - 1;
        // n은 name의 길이, leftOrRight는 커서 이동 위치를 구하기 위한 변수
        for(int i = 0; i < n; i++){
            int next = i + 1;
            char target = name.charAt(i);
            if(target <= 'N') answer += target - 'A';
            else answer += 'Z' - target + 1;
            while(next < n && name.charAt(next) == 'A') next++; // 글자가 'A'인 경우 next를 1 증가
            int b = i + n - next + Math.min(i, n - next); // 현 위치에서 좌우 움직이는 수 중 작은 수를 구하는 식
            leftOrRight = Math.min(leftOrRight, b);
            // i는 현재 글자를 바꾸는 단어의 위치, n은 name의 총 길이
            // next는 현재 위치에서 A가 아닌 문자로 얼마나 갈 수 있는지 판단
        }
        answer += leftOrRight;
        return answer;
    }

    public static void main(String[] args) {
        JoyStick test = new JoyStick();
        String name = "JAN";
        System.out.println(test.solution(name));
    }
}
