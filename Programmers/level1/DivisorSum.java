/**
 * programmers level1 약수의 합 DivisorSum
 * @author pkch93
 */
class DivisorSum {

    /**
     * 0부터 3000까지의 자연수 n의 모든 약수의 합을 구하는 문제
     * 0과 1은 각각 약수가 0, 1이므로 해당 값을 return
     * 2 이상의 경우 root n까지 loop를 돌면서 약수의 합을 구함
     * 이때, n / i와 i가 같은 경우는 i의 제곱이 n이 되는 경우이므로
     * i를 한번만 더해줌  
     *
     * @param n
     * @return n의 약수의 합
     */
    public int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int answer = 0;
        for (int i = 1; i*i <= n; i++){
            if (n % i == 0) {
                answer += i;
                if (i != n / i){
                    answer += n / i; 
                }
            }
        }
        return answer;
    }
}