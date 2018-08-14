package com.Algorithm;

import java.util.*;

// 백준 알고리즘 2309번 문제 일곱 난쟁이
public class SevenDwarfs {

    /*
        브루트 포스 문제
        DP, 재귀 등 다양한 방법을 구상해보았으나 딱히 방법이 없어 완전 탐색 방법을 사용
        일곱 난쟁이의 키 합이 100이므로 아홉 난쟁이의 키를 모두 더한 후
        두 난쟁이의 키를 빼서 일곱 난쟁이의 키를 구함
    */

    // ArrayList의 요소들을 모두 print하는 함수
    public static void printArrayList(ArrayList arrList){
        for(int i = 0; i < arrList.size(); i++){
            System.out.println(arrList.get(i));
        }
    }

    // int형 배열의 요소를 모두 더하는 함수
    public static int sumArray(int [] arr){
        int answer = 0;
        for (int i = 0; i < arr.length; i++){
            answer += arr[i];
        }
        return answer;
    }

    public static void solution(int [] arr){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(arr); // 오름차순으로 정렬
        int n = sumArray(arr), except1 = -1, except2 = -1;
        // n은 아홉 난쟁이의 키를 모두 더한 값, except1, except2는 빼야할 난쟁이의 index를 뜻함
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue; // 만약 i와 j가 같다면 다음 loop
                else if (n - arr[i] - arr[j] == 100) {
                    // 다음 조건을 만족하면 빼야할 두 난쟁이를 찾은 것이므로...
                    except1 = i;
                    except2 = j;
                    break;
                }
            }
        }

        for(int k = 0; k < arr.length; k++) {
            if (k == except1 || k == except2) {
                continue;
            }
            answer.add(arr[k]); // 두 난쟁이를 제외한 다른 난쟁이들을 answer에 저장
        }

        printArrayList(answer); // 출력
    }

    public static void main(String[] args) {
        int [] arr = {20, 7, 23, 19, 10, 15, 25, 8, 13};
        solution(arr);
        // 7 8 10 13 19 20 23
    }
}
