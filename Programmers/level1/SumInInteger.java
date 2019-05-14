/**
 * programmers level1 두 정수 사이의 합 SumInInteger
 * @author pkch93
 */
class Solution{
    /**
     * 정수 a, b를 포함하여 a, b 사이의 합을 구해서 return 하는 메서드
     * 단, a와 b의 대소관계가 정해지지 않았기 때문에 a, b의 대소관계를 알아낸 후 계산
     * 
     * @param a : 정수
     * @param b : 정수
     * @return a와 b사이의 모든 합
     */
    public long solution(int a, int b) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        long answer = 0;
        for(int i = a; i <= b; i++)
            answer += i;
        return answer;
    }
}