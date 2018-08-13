package com.Algorithm;

// 백준알고리즘 1463번 1로 만들기
public class MakeNumberOne {

    private static int [] arr = new int[1000001];
    // DP로 풀기 위한 메모리 선언
    private static int solution(int n){
        for (int i = 2; i <= n; i++){
            makeOne(i);
            // 어떤 숫자 i의 1로 만드는 최소 횟수를 구해 메모리에 저장
        }
        return arr[n];
        // 구하고자 하는 숫자의 최소 횟수 return
    }

    private static void makeOne(int n) {
        int answer = Integer.MAX_VALUE;
        if(n % 3 == 0){
            answer = Math.min(answer, arr[n / 3] + 1);
        }
        if(n % 2 == 0) {
            answer = Math.min(answer, arr[n / 2] + 1);
        }
        /*
        이미 1부터 구하고자 하는 숫자의 최소횟수를 구하고 있다.
        이미 구해진 각 숫자들의 최소 횟수는 그 숫자에서 최소 횟수임을 보장한다.
        따라서 만약 어떤 숫자가 3이나 2로 나누어지는 경우와 1을 뺀 경우 나오는 값은
        항상 메모리에 저장되어있다.
        그 경우 그 메모리에 저장된 값과 1을 더하면 해당 숫자의 최소 횟수가 된다.
        */
        arr[n] = Math.min(answer, arr[n - 1] + 1);
        // 어떤 숫자에 1을 빼서 최소횟수를 구하는 경우
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++) System.out.println(solution(i));
        // TEST
    }

    // 따라서 O(n)의 복잡도가 해당 알고리즘에서 든다.
}
