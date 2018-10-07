package programmers.sorting;

import static java.util.Arrays.*;

// Programmers 코딩테스트 고득점 Kit 정렬 K번째 수 문제
// 단순히 array에서 i,j 까지의 범위의 배열로 만들고 k번째 수를 뽑는 방법을 썼다.
public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        for (int a = 0; a < n; a++) {
            int i = commands[a][0] - 1;
            int j = commands[a][1];
            int k = commands[a][2] - 1;
            int[] temp = copyOfRange(array, i, j);
            sort(temp);
            answer[a] = temp[k];
        }
        return answer;
    }
}
