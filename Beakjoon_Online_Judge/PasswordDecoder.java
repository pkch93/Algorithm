package boj.third;

import java.util.Scanner;

public class PasswordDecoder {
    public static String solution(int n, int[] code, String str){
        int [] cnt = new int[53];
        for (int i = 0; i < n; i++){
            char word= str.charAt(i);
            int wordCode;
            if (word == ' '){
                wordCode = 0;
            } else if (word <= 90){
                wordCode = word - 64;
            } else {
                wordCode = word - 70;
            }
            cnt[wordCode] += 1;
        }
        for (int i = 0; i < n; i++){
            int wordCode = code[i];
            if (cnt[wordCode] == 0) {
                return "n";
            }
            cnt[wordCode] -= 1;
        }
        return "y";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] code = new int[n];
        for (int i = 0; i < n; i++){
            code[i] = sc.nextInt();
        }
        sc.nextLine();
        String str = sc.nextLine();
        System.out.println(solution(n, code, str));
    }
}
