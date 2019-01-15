import sys
sys.stdin = open("inputs/minmax_input.txt")

def solution(nums):
    """
    :param nums: 최대 최소값을 구할 input값 
    :return: nums에서 최대값과 최소값의 차

    SW Expert Academy 4828. min max (d2) / 시간복잡도 : O(n) 예상
    """
    max_num = -sys.maxsize # 최대값 초기화
    min_num = sys.maxsize # 최소값 초기화
    """
    핵심로직!
    nums 리스트를 순회하면서 각각의 값과
    max_num / min_num과 비교하면서 최대 / 최소값을 구함
    """
    for num in nums:
        if max_num < num:
            max_num = num
        if min_num > num:
            min_num = num
    return max_num - min_num # 최대값과 최소값의 차를 반환

def main():
    T = int(input())
    for test_case in range(T):
        n = int(input())
        nums = list(map(int, input().split(" ")))
        print(f"#{test_case + 1} {solution(nums)}")

if __name__ == '__main__':
    main()