package boj.third;

import java.util.Scanner;

public class TotalCalculate {

    public static int solution(int n, int m){
        int dummy = n / m;
        int answer = n + dummy;
        while (m <= dummy){
            dummy /= m;
            answer += dummy;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solution(n, m));
    }
}
