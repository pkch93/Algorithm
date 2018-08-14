package com.Algorithm;

import java.util.Scanner;

// 백준 알고리즘 11052번 문제 붕어빵 판매하기
public class SellingBongappang {
    /*
        구현 방법
        : 기존에 배운 rod cutting에서 착안
        먼저, n + 1의 길이를 갖는 배열을 생성,
        여기에 각 붕어빵의 갯수마다 가지는 최대 수익을 저장
        그리고 이전에 계산한 붕어빵 갯수의 최대 수익을 이용해 정답을 구한다.
    */
    public static int solution(int n, int [] price){
        int [] arr = new int[n+1]; // ※ arr[0] = 0
        for(int i = 1; i <= n; i++){
            int temp = price[i]; // 각 붕어빵 최대 갯수의 가격을 저장
            for(int j = 1; j <= i / 2; j++) {
                // i / 2 만큼 loop를 도는 이유는 (2개 - 3개)와 (3개 - 2개)는 같기 때문
                // 즉, 중복을 제거하기 위함
                temp = Math.max(temp, arr[i - j] + arr[j]); // 최대수익 temp에 저장
            }
            arr[i] = temp; // 이렇게 구해진 최대 수익을 arr 배열에 저장
        }
        return arr[n]; // 우리가 구하고자 하는 것은 n개 붕어빵의 최대수익이므로 arr[n] 리턴
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int [] arr = {0, 10, 9, 8, 7, 6};
        System.out.println(solution(n, arr)); // 10
        sc.close();
    }

    /*
       따라서 이번 문제는 1 ~ n 까지의 loop와 그 안에서 n / 2만큼의 loop를 돌기 때문에
       n * (n / 2) => n² / 2 이므로 결국 O(n²)의 복잡도를 가진다.
    */
}
