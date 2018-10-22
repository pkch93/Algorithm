package programmers.stackqueue;

import java.util.ArrayList;

/*
 프로그래머스 코딩테스트 고득점 Kit 스택/큐 주식가격 문제
 일단 단순하게 생각하여 for문 2개로 문제를 풀었다.
 prices의 길이가 100,000 이하라 안 될줄 알았는데 통과...
 stack을 이용하여 O(n)으로 푸는 방법을 생각해 봐야할 듯하다.
*/
public class StockPrice {

    public int [] solution(int[] prices){
        int n = prices.length, count;
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int target = prices[i];
            count = 0;
            for(int j = i + 1; j < n; j++){
                count++;
                int temp = prices[j];
                if(target > temp) break;
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
