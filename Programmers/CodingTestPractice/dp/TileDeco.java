package programmers.dinamic_programming;

// Programmers 코딩테스트 고득점 Kit 동적계획법 타일 장식물 문제
public class TileDeco {
    // 문제에 주어진 타일의 패턴이 fibonacci의 형태를 띄는 것이 포인트!
    public long solution(int n){
        long answer;
        long [] cache = new long[80]; // 문제의 길이가 80이므로 최대 80개까지 저장
        cache[0] = cache[1] = 1; // 초기 상태로 0, 1번째 cache에는 1의 값을 저장
        for(int i = 2; i < n; i++){
            cache[i] = cache[i-1] + cache[i-2]; // fibonacci 계산
        }
        answer = ((cache[n-1]*2) + cache[n-2] ) * 2;
        // 둘레의 합은 ( 가장 큰 사각형의 한변 길이 ) * 4 + ( 2번째로 큰 사각형의 한변 길이 ) * 2
        return answer;
    }

    public static void main(String[] args) {
        TileDeco test = new TileDeco();
        System.out.println(test.solution(80));
    }
}
