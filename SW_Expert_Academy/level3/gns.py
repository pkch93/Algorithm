import sys

sys.stdin = open("inputs/GNS_test_input.txt")


def solution(data):
    """
    SW Expert Academy 1221번 GNS - D3

    어짜피 0 ~ 9까지의 숫자로 이뤄져있으므로 이 숫자들을 하나의 dict로 모은 다음 얼마나 존재하는지 counting함

    :param data: 정렬되지 않은 어느 행성의 숫자들
    :return: 어느 행성의 숫자로 정렬된 list
    """
    gns = {"ZRO": 0, "ONE": 1, "TWO": 2, "THR": 3, "FOR": 4, "FIV": 5, "SIX": 6, "SVN": 7, "EGT": 8, "NIN": 9}
    # dictionary로 어느 행성의 숫자를 정의
    gns_keys = list(gns.keys())
    count = [0 for _ in range(10)]  # counting을 위한 배열 초기화
    answer = []
    for s in data:
        if s in gns:
            count[gns[s]] += 1  # counting
    for i in range(len(count)):
        answer += [gns_keys[i]] * (count[i])
        # counting된 값이 결국엔 해당 값이 있어야할 갯수이므로 count 배열을 돌면서 answer 배열에 추가
    return answer


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        temp = input()
        data = input().split()
        answer = solution(data)
        print(f"#{test_case + 1}", *answer)


if __name__ == '__main__':
    main()
