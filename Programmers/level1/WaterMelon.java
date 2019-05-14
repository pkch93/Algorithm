import java.util.stream.IntStream;

/**
 * programmers level1 수박수박수박수박수박수? WaterMelon
 * @author pkch93
 */
class WaterMelon {
    /**
     * 홀수번째에서는 수, 짝수번째에서는 박이 담긴 길이 n 문자열을 return하는 문제
     * 간단히 StringBuilder와 IntStream을 사용하여 문제를 해결하였음
     * 
     * @param n : return할 문자열의 길이
     * @return 홀수번째는 수, 짝수번째는 박이 담긴 길이 n 문자열
     */
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, n).forEach(i -> {
            if ((i & 1) == 0) {
                sb.append("수");
            } else {
                sb.append("박");
            }
        });
        return sb.toString();
    }
}