package programmers.dinamic_programming;

import java.util.Arrays;

/*
    프로그래머스 코딩테스트 고득점 Kit 동적계획법 (Dynamic Programming) 등굣길 문제
    등교하는 최단 경로의 갯수는 무수히 많이 나타나므로 dp를 이용함
    default값을 -1로 지정한 이유는 puddle에 해당하는 공간 값을 0으로 해야 최단 경로 계산시 편리하기 때문에
    그리고 위에서 아래, 왼쪽에서 오른쪽으로 가는 방향만 계산함
    이유는 왼쪽으로 가는 경우 및 위로가는 경우는 왔던 방향을 다시 돌아가므로 최단경로에 맞지 않게 됨
    마지막으로 각 공간의 최단경로 갯수를 구하면서 % 1000000007를 해주는 이유는
    중간중간에 계산하면서 int 범위를 넘어갈 수 있어 원치 않은 값이 나올 수 있다.
    계산마다 나머지처리를 해주어 int 범위가 넘어가는 문제를 방지함
*/
public class GoToSchool {
    public int solution(int m, int n, int[][] puddles){
        int [][] dp = new int[n][m]; // 경로의 크기에 맞게 dp 공간 마련
        for(int i = 0; i < n; i++)Arrays.fill(dp[i], -1); // default값을 -1로 지정
        for(int i = 0; i < puddles.length; i++){
            int x = puddles[i][0] - 1;
            int y = puddles[i][1] - 1;
            dp[y][x] = 0; // 물웅덩이 공간을 0으로 지정
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dp[i][j] == 0) continue; // 물웅덩이 부분은 이미 계산했으므로 continue
                if( i == 0 && j == 0 ) dp[i][j] = 1; // 집을 1로 두어 맨 위, 맨 왼쪽 공간을 계산하기 편하도록 만듦
                else {
                    if(i == 0) dp[i][j] = dp[0][j-1] % 1000000007; // 만약 이전에 물웅덩이가 있었다면 그 이후 공간은 0으로 처리
                    else if(j == 0)  dp[i][j] = dp[i-1][0] % 1000000007; // 만약 이전에 물웅덩이가 있었다면 그 이후 공간은 0으로 처리
                    else dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007; // 위로 오는 경우의 최단경로 갯수와 왼쪽으로 오는 최단 경로 갯수를 더함
                }
            }
        }
        int answer = dp[n - 1][m - 1];
        return answer;
    }

    public static void main(String[] args) {
        GoToSchool test = new GoToSchool();
        int m = 4, n = 3;
        int [][] puddles = {{1,3}, {2,2}, {3,1}};
        System.out.println(test.solution(m,n,puddles));
    }
}
