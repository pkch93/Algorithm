import java.util.Arrays;

/**
 * programmers level1 하샤드 수 Harsard
 * @author pkch93
 */
class Solution {
    /**
     * x가 x의 각 자리수의 합으로 나누어 떨어지면 이를 하샤드 수라고 한다.
     * 정수 x가 하샤드 수인지 판단하는 문제.
     * 각 자리수를 제어를 쉽게하기 위해 x를 String으로 바꿈
     * 그 후 split과 stream, Integer.parseInt로 각 자리의 합을 구함
     *
     * @param x : 하샤드 수인지 여부를 알아볼 정수
     * @return 하샤드 수 여부 (true / false)
     */
    public boolean solution(int x) {
        int sumDisit = Arrays.stream(Integer.toString(x).split(""))
            .mapToInt(Integer::parseInt).sum();
        return (x % sumDisit) == 0;
    }
}