import java.util.Arrays;

/**
 * programmers level1 나누어 떨어지는 숫자 배열 DivisibleNumArr
 * @author pkch93
 */
class DivisibleNumArr {
  
    /**
     * arr의 값 중 divisor로 딱 나누어 떨어지는 값을 추려 배열로 return 메서드
     * 이를 위해 stream을 활용하여 구현
     * filter는 arr의 각 원소가 람다의 조건식에 부합한다면 원소로 담는 메서드
     * sorted는 filter로 걸러진 원소들을 정렬 (기본적으로 오름차순)
     * IntStream이므로 toArray()로 int 배열로 가져옴
     * 이때, answer의 길이가 0이라면 부합하는 element가 없으므로 -1을 담은 배열을 return
     *
     * @param arr : 나누어 떨어지는지 검사할 대상 int 배열
     * @param divisor : 배열의 element가 나누어 떨어지는지 판단의 기준이 되는 int 값
     * @return divisor로 나누어 떨어지는 값을 담은 오름차순으로 정렬된 int 배열
     */
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
                        .filter(num -> num % divisor == 0)
                        .sorted()
                        .toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
  }
}