package programmers.stackqueue;

import java.util.Arrays;

public class Tower {

    public int [] solution(int [] heights){
        int n = heights.length;
        int [] answer = new int[n];
        for(int i = 1; i < n; i++){
            int give = heights[i];
            for(int j = i - 1; j >= 0; j--){
                int take = heights[j];
                if(take > give) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] heights = {1,5,3,6,7,6,5};
        Tower test = new Tower();
        int [] answer = test.solution(heights);
        Arrays.stream(answer).forEach(i -> System.out.print(i + " "));
    }
}
