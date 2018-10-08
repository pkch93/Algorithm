package programmers.dinamic_programming;

// 프로그래머스 코딩테스트 고득점 Kit DP 정수 삼각형 (level 3)
public class IntegerTriangle {
    private static int [][] dp = new int[500][500];
    public int solution(int [][] triangle){
        int n = triangle.length;
        dp[n-1] = triangle[n-1];
        for(int i = n - 2; i > 0; i--){
            for(int j = 0; j < triangle[i].length; j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
            }
        }
        return Math.max(dp[1][0], dp[1][1]) + triangle[0][0];
    }

    public static void main(String[] args) {
        IntegerTriangle test = new IntegerTriangle();
        int [][] triangle = {
                {7},
                {3,8},
                {8,1,0},
                {2,7,4,4},
                {4,5,2,6,5}
        };
        System.out.println(test.solution(triangle)); // 30 test
    }
}
