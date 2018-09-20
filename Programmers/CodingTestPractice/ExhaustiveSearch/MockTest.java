package programmers.exhaustive_search;

import java.util.ArrayList;
import java.util.Arrays;

public class MockTest {

    private static final int[][] point = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    }; // 수포자들 3명의 찍기 패턴을 담은 이차원 배열

    public int check(int [] target, int [] answers){
        int result = 0, j = 0, n = answers.length;
        for(int i = 0; i < n; i++){
            if(j >= target.length) j = 0;
            if(target[j++] == answers[i]) result += 1;
        }
        return result;
    } // 정답이 주어졌을때 수포자들이 맞은 정답을 계산하여 result로 반환

    public int[] solution (int [] answers){
        int [] answer = new int[3]; // 수포자가 3명이므로
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < point.length; i++) answer[i] = check(point[i],answers); // 수포자이 맞은 정답의 수를 계산
        for(int i= 0; i < answer.length; i++){
            int j = 0;
            int temp = answer[i];
            for(; j < answer.length; j++){
                int temp2 = answer[j];
                if(temp < temp2) break;
            }
            if(j == answer.length) arr.add(i+1);
        } // 제일 많이 맞은 사람을 계산하는 logic, ArrayList를 이용하여 정답 배열에 넣고자 했다.
        int[] temp = new int[arr.size()]; // 제일 많이 맞은 사람의 수만큼 arr에 담기므로 arr의 사이즈만큼의 배열을 생성한다.
        return Arrays.stream(temp).map( (o)-> arr.remove(0)).toArray(); // stream API를 이용하여 정답 반환
    }

    public static void main(String[] args) {
        MockTest test = new MockTest();
        int [] answers = {1,3,2,4,2};
        int[] solution = test.solution(answers);
        Arrays.stream(solution).forEach(num -> System.out.println(num));
        // TEST
    }

    /*
        역시 자바에서는 배열을 다루는게 문제 로직을 짜는거 보다 힘든것 같다...
        자바 배열을 다루는 방법과 자바 8의 stream API 사용법에 대해 공부할 필요가 있어보인다.
    */
}
