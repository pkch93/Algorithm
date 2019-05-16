/**
 * programmers level1 콜라츠 추측 Collatz
 * @author pkch93
 */
class Collatz {
    /**
     * 입력된 수가 짝수면 2를 나누고 홀수면 3을 곱하여 1을 더함
     * 이 과정을 반복하여 입력된 수가 1이 될 때까지의 횟수를 구하는 문제
     * @param num : 초기값
     * @return num이 1이 될 때까지의 횟수, 500이라면 -1
     */
    public int solution(long num) {
        int answer = 0;
        while (num != 1 && answer < 500){
            if ((num & 1) == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            answer++;
        }
        return answer == 500 ? -1 : answer;
    }
}