
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * programmers level1 문자열 내림차순으로 배치하기 StringDescendSort
 * @author pkch93
 */
class StringDescendSort {
    /**
     * 문자를 큰 것부터 작은 것 순으로 정렬한 문자열을 return 해야한다.
     * 이때, 대문자의 경우 ASCII 코드가 소문자보다 작으므로
     * 오름차순으로 정렬 후 문자열을 거꾸로 반전 시키는 방식으로 풀고자 함
     *
     * @param s : 내림차순 할 문자열
     * @return s 문자열에서 문자를 내림차순 한 새로운 문자열
     */
    public String solution(String s) {
        String reversedStr = Arrays.stream(s.split("")).sorted().collect(Collectors.joining(""));
        return new StringBuilder(reversedStr).reverse().toString();
    }
}