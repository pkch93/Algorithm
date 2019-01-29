import sys

sys.stdin = open("inputs/countstr_input.txt")


def solution(pettern, string):
    answer = 0
    for p in pettern:
        temp = 0
        for s in string:
            if p == s:
                temp += 1
        answer = max(answer, temp)
    return answer


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        pettern, string = input(), input()
        print(f"#{test_case + 1} {solution(pettern, string)}")


if __name__ == '__main__':
    main()
