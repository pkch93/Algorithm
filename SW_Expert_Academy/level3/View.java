package swexport.d3;

import java.util.Scanner;

// SW Expert Academy 1206번 View 문제
public class View {

    public static int solution(int [] arr){
        int n = arr.length, answer = 0;
        for (int i = 2; i < n - 2; i++){
            int temp = arr[i];
            int min = Math.min(Math.min(Math.min(temp - arr[i - 1], temp - arr[i - 2]), temp - arr[i + 1]), temp - arr[i + 2]);
            min = min < 0 ? 0 : min;
            answer += min;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int n = sc.nextInt();
            int [] arr = new int[n];
            for (int j = 0; j < n; j++) arr[j] = sc.nextInt();
            System.out.printf("%s %d\n","#"+ (i+1) ,solution(arr));
        }
        sc.close();
    }
}
