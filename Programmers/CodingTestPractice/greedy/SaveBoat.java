package programmers.greedy;

import java.util.Arrays;

/*
Programmers 코딩테스트 고득점 Kit 탐욕법 ( Greedy ) 구명보트
한 구명보트는 2명 탈 수 있다는 점, 제한된 무게(40~240)를 넘으면 안된다는 점을 착안
people 배열에서 최소값을 구한 후 limit과 뺀 값이 작거나 같은 값만 있는 배열을 만든다.
-> limit - min 보다 무게가 큰 사람은 혼자 타야하기 때문
이후 맨 앞에 몸무게가 작은 사람과 뒤에 2명 이상 탈 수 있는 사람 중 몸무게가 무거운 사람과
무게를 비교하여 답을 구한다.
만약 앞쪽 사람과 뒤쪽 사람의 무게가 limit보다 크다면 뒤쪽사람 혼자 타야하므로 answer에 1 더해주고
덜 무게가 나가는 사람과 비교한다.
*/
public class SaveBoat {
    public int solution(int [] people, int limit) {
        int min = Arrays.stream(people).min().getAsInt(), k = limit - min;
        int [] targets = Arrays.stream(people).filter(i -> i <= k).sorted().toArray();
        // 2명이상 탈 수 있는 사람들 표본
        int n = people.length;
        int m = targets.length;
        int answer = n - m; // 1명만 타는사람들 answer에 넣기
        int i = 0, j = m - 1;
        while(i <= j){
            int forward = targets[i];
            int backward = targets[j];
            if(forward + backward <= limit) i++;
            j--;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        SaveBoat test = new SaveBoat();
        // int [] people = {40,41,59,50,52,59,90,89,55,67};
        // int [] people = {70,50,80,50};
        int [] people = {70,50,80};
        int limit = 100;
        System.out.println(test.solution(people, limit));
    }
}
