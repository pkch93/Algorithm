package boj.third;

import java.util.HashSet;
import java.util.Scanner;

public class SumMultiple {
    public static int solution(int n, int[] k) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < k.length; i++) {
            int j = 1;
            int target = k[i];
            while (target * j <= n) {
                int temp = j * target;
                if (!set.contains(temp)) {
                    answer += temp;
                    set.add(temp);
                }
                j++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] k = new int[m];
        for (int i = 0; i < m; i++) {
            k[i] = sc.nextInt();
        }
        System.out.println(solution(n, k));
    }
}
