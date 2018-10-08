package programmers.stackqueue;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

// Programmers 코딩테스트 고득점 Kit 스택/큐 프린터
public class Printer {
    public int solution(int[] priorities, int location){
        int index = location, count = 0; // index는 현재 target의 위치, count는 빠져나간 값들의 수
        List<Integer> queue = Arrays.stream(priorities).boxed().collect(Collectors.toList());
        while(true){
            Integer remove = queue.remove(0);
            Integer max = queue.stream().reduce(0, BinaryOperator.maxBy(Integer::compareTo));
            if(index == 0){ // target이 빠져나갈 차례
                if(max > remove){
                    index = queue.size();
                    queue.add(remove);
                }
                else {
                    return count + 1;
                }
            }
            else { // target이 빠져나가지 않음
                index--;
                if(max > remove){
                    queue.add(remove);
                }
                else{
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Printer test = new Printer();
        int [] priorities = {1,1,9,1,1,1};
        int location = 0;
        System.out.println(test.solution(priorities, location));
    }
}
