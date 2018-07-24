package Algospot.beginner;

public class CoinChange {
	
	public int solution(int n, int [] money) {
		int [] dp = new int[n+1];
		for(int a = 0; a <= n; a++) {
			if(a % money[0] == 0) dp[a] = 1;
		}
		// 초기작업, 맨 첫 번째 화폐 단위로 해당 액수를 만들 수 있는지 없는지 표시하기 위해 1을 저장
		for(int i = 1; i < money.length; i++) {
			for(int j = money[i]; j <= n; j++) {
				dp[j] = (dp[j] + dp[j - money[i]]) % 1000000007;
				// dp[j]는 이전의 화폐단위로 j를 만들 수 있는 경우의 수
				// dp[j - money[i]]는 해당 금액에 money[i]만큼의 액수를 뺀 dp의 경우의 수
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		CoinChange test = new CoinChange();
		int m = 1278;
		int [] coins = {1,2,4,8,16,32,64,128};
		System.out.println(test.solution(m, coins));
	}
}
