package programmers.sorting;

import java.util.Comparator;
import java.util.stream.IntStream;

// Programmers 코딩테스트 고득점 Kit 정렬 H-Index
// 문제에서 주어진 대로 citations를 내림차순 정렬 후 answer과의 비교로 풀었음
public class HIndex {
    public int solution(int [] citations){
        int answer = 0;
        int [] sorted = IntStream.of(citations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();
        for(int i = 0; i < sorted.length; i++){
            if(sorted[i] > answer) answer++;
            else break;
        }
        return answer;
    }
}
