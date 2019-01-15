import sys
sys.stdin = open("inputs/intervalsum_input.txt")

def solution(m, nums):
    """
    :param m: 구간합을 구할 구간
    :param nums: 정수 배열
    :return: 구간합의 최대값과 최소값의 차

    SW Expert Academy 4835. 구간합 문제(d2) / 시간복잡도 : O(n) 예상
    """
    n = len(nums) # 받은 숫자의 길이
    max_sum = -sys.maxsize # 최대값 초기화
    min_sum = sys.maxsize # 최소값 초기화
    for i in range(n - m + 1):
        """
        핵심로직!
        O(n)으로 풀기 위해 for문 한번으로 최대 최소 구간합 구할 방법을 생각해봄
        for문의 range가 nums의 길이 - 합 구할 구간 갯수 + 1인 이유는
        맨 앞에서부터 m개씩 더해주기 위해서
        이렇게 for문을 순회하면서 현재 index부터 m번 떨어진 index의 값을 더해서 구간합을 구한다.
        그후 앞서 정의한 max_sum과 min_sum과 비교하여 최대/최소 구간합을 도출
        """
        i_sum = sum(nums[i:i+m])
        if i_sum > max_sum:
            max_sum = i_sum
        if i_sum < min_sum:
            min_sum = i_sum
    return max_sum - min_sum # 최대 구간합 - 최소 구간합

def main():
    T = int(input())
    for test_case in range(T):
        n, m = map(int, input().split())
        nums = list(map(int, input().split()))
        print(f"#{test_case + 1} {solution(m, nums)}")

if __name__ == '__main__':
    main()