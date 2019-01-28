package programmers.mocktest;

public class First {

    public boolean solution(int[] arrA, int[] arrB) {
        int n = arrA.length;
        if (arrB.length != n) return false;
        for (int i = 0; i < n; i++){
            int j;
            for (j = 0; j < n; j++){
                int idx = (i + j) % n;
                if (arrA[j] != arrB[idx]) break;
            }
            if (j == n) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        First test = new First();
        int [] arrA = {2, 2, 2, 2, 2, 2, 2, 1, 2, 2};
        int [] arrB = {2, 2, 2, 2, 2, 1, 2, 2, 2, 2};
        System.out.println(test.solution(arrA,arrB));
    }
}
