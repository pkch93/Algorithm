package programmers.mocktest;

import java.util.Arrays;

public class Third {

    private boolean binarySearch(int [] nums, int idx){
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > idx) end = mid - 1;
            else if (nums[mid] < idx) start = mid + 1;
            else return true;
        }
        return false;
    }

    public int solution(int[][] board, int[] nums) {
        Arrays.sort(nums);
        int n = board.length, answer = 0;
        boolean diag, rdiag;
        diag = rdiag = true;
        for (int i = 0; i < n; i++){
            boolean r, c; // r : row, c : column
            r = c = true;
            if (!binarySearch(nums, board[i][i])) diag = false;
            if (!binarySearch(nums, board[i][n-i-1])) rdiag = false;
            for (int j = 0; j < n; j++){
                if (!binarySearch(nums, board[i][j])) r = false;
                if (!binarySearch(nums, board[j][i])) c = false;
            }
            if (r) answer += 1;
            if (c) answer += 1;
        }
        if (diag) answer += 1;
        if (rdiag) answer += 1;
        return answer;
    }

    public static void main(String[] args) {

    }
}
