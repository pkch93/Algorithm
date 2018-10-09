package programmers.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;

/*
Programmers 코딩테스트 고득점 Kit 스택/큐 기능개발
스택 & 큐 문제인데 스택이나 큐 쓰는 것보다 boolean 배열을 이용하는 것이
더 나아보였기 때문에 boolean 배열을 썼다. (다만, 뭔가 코드가 복잡해진 것 같음)
answer라는 List 컬렉션으로 값을 받아 최종 결과를 stream을 이용해 int 배열로 리턴했다.
*/
public class FunctionDev {
    public int[] solution(int [] progresses, int [] speeds){
        int n = progresses.length, days = 0, i, j;
        boolean [] check = new boolean[n];
        ArrayList<Integer> answer = new ArrayList<>();
        for(i = 0; i < n; i++){
           if(check[i]) continue;
           days += ((100 - progresses[i]) / speeds[i]) + 1;
           for(j = i; j < n; j++){
               progresses[j] += days * speeds[j];
               if(progresses[j] >= 100) check[j] = true;
               else break;
           }
           check[i] = true;
           answer.add(j-i);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        FunctionDev test = new FunctionDev();
        int [] progresses = {93, 30, 55};
        int [] speeds = {1, 30, 5};
        int[] solution = test.solution(progresses, speeds);
        Arrays.stream(solution).forEach(System.out::println);
    }
}
