package programmers.exhaustive_search;

public class Carpet {

    public int [] solution(int brown, int red){
        int [] answer = new int[2];
        int n = brown / 2 + 2; // 가로세로의 총 길이는 brown / 2 + 2
        int length = n - 1, width = n - length; // length: 가로, width: 세로
        while(length >= width){ // 문제 조건에서 가로는 세로보다 크거나 같다고 명시되어있음
            int temp = (length - 2) * (width - 2); // 가로가 큰 상황에서 넓이를 구해 red와 같은지 비교
            if(temp == red) { // 같다면 해당 가로, 세로 길이가 정답
                answer[0] = length;
                answer[1] = width;
                break;
            }
            // 아니라면 가로는 1 빼고 세로는 1 더하면서 다시 logic 수행
            length -= 1;
            width += 1;
        }
        return answer;
    }
}
