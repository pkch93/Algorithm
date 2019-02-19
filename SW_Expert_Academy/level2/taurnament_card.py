import sys

sys.stdin = open('inputs/taurnament_card_input.txt')

wins = {
    1: 2,
    2: 3,
    3: 1
}


def solution(nums, l, r):
    if r == l:
        return nums[l], l
    mid = (l + r) // 2
    lnum, lidx = solution(nums, l, mid)
    rnum, ridx = solution(nums, mid+1, r)
    if wins[lnum] == rnum:
        return rnum, ridx
    else:
        return lnum, lidx


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        n = int(input())
        nums = [0] + list(map(int, input().split()))
        print(f'#{test_case+1} {solution(nums, 1, n)[1]}')


if __name__ == '__main__':
    main()
