package boj.third;

import java.util.Scanner;

public class SpaceProbe {

    private static int answer;

    static {
        answer = Integer.MAX_VALUE;
    }

    public static void solution(int n, int m, int [][] adj){
        floydWashall(n, adj);
        boolean [] chk = new boolean[n];

        perm(chk, adj, n, 0, m, 0);
    }

    private static void floydWashall(int n, int[][] adj) {
        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                if (i == k) continue;
                for (int j = 0; j < n; j++){
                    if (i == j || k == j) continue;
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
    }

    private static void perm(boolean [] chk, int [][] adj,
                             int n, int r, int k, int sum){
        if (sum > answer) {
            return;
        }
        if (r == n - 1){
            if (answer > sum){
                answer = sum;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (i != k && !chk[i]) {
                    chk[i] = true;
                    perm(chk, adj, n, r+1, i, sum + adj[k][i]);
                    chk[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [][] adj = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                adj[i][j] = scanner.nextInt();
            }
        }
        solution(n, m, adj);
        System.out.println(answer);
    }
}
