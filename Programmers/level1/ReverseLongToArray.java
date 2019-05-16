import java.util.Arrays;

/**
 * programmers level1 자연수 뒤집어 배열로 만들기 ReverseLongToArray
 * @author pkch93
 */
class ReverseLongToArray {
  /**
   * 자연수 더하기와 비슷하게 쉽게 수를 조작하기 위해 n을
   * split과 Integer.parseInt를 사용함
   * 단, 이 문제에서는 문자열을 뒤집는 로직이 필요.
   * 이를 위해 StringBuilder 객체의 메서드 reverse()를 사용
   *
   * @param n : 뒤집어 배열로 만들 자연수
   * @return n을 뒤집은 뒤 각 자리수를 담은 int 배열
   */
  public int[] solution(long n) {
      String s = Long.toString(n);
      StringBuilder sb = new StringBuilder(s);
      return Arrays.stream(sb.reverse().toString().split(""))
        .mapToInt(Integer::parseInt).toArray();
  }
}