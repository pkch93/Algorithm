import java.util.*;

/**
 * programmers level1 같은 숫자는 싫어 HateSameNum
 * @author pkch93
 */
public class HateSameNum {
    /**
     * 연속된 숫자 중 중복이 있는 경우 하나만 남기고 전부 제거하여야함
     * 이를 위해 prev 변수를 두어 이전에 어떤 값이 있었는지 확인
     * prev 변수의 값과 현재 loop를 돌고 있는 값을 비교하여 다르다면
     * 동적배열 list에 저장
     * 결과값은 list의 stream을 이용하여 Stream<Integer>를 mapToInt를 통해
     * IntStream으로 변환한 후 int[]로 return
     * 
     * @param arr 연속된 중복이 있는 int 배열
     * @return 연속된 중복이 제거된 int 배열
     */
	public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int prev = arr[0];
        list.add(prev);
        for (int i = 1; i < arr.length; i++){
            if (prev != arr[i]){
                prev = arr[i];
                list.add(prev);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
	}
}