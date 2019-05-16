import java.util.*;

/**
 * programmers level1 자리수 더하기 SumDisit
 * @author pkch93
 */
public class Solution {
    /**
     * 각 자리수를 쉽게 다루기 위해 String으로 변환 후
     * split()과 Integer.parseInt() 메서드로 각 자리수를 더함
     * 
     * @param n : 각 자리수를 더할 정수 n
     * @return 정수 n의 각 자리수를 더한 값
     */
    public int solution(int n) {
        String s = Integer.toString(n);
        return Arrays.stream(s.split("")).mapToInt(Integer::parseInt).sum();
    }
}