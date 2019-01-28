package programmers.mocktest;

import java.util.Arrays;

public class Second {
    public int solution(int l, int[] v) {
        Arrays.sort(v);
        int d = v[0], n = v.length;
        for (int i = 1; i < v.length; i++){
            int mid = (v[i] + v[i-1]) / 2;
            d = Math.max(Math.max(v[i] - mid, mid - v[i-1]), d);
        }
        if (v[n-1] + d < l) d = l - v[n-1];
        return d;
    }

    public static void main(String[] args) {
        Second test = new Second();
        System.out.println(test.solution(15, new int[]{15, 5, 3, 7, 9, 14, 0}));
        System.out.println(test.solution(5, new int[]{2, 5}));
    }
}
