package boj.third;

import java.util.Scanner;

public class AnotherFibo {

    public static int solution(int n){
        int [] dp = new int[51];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2] + 1) % 1_000_000_007;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
