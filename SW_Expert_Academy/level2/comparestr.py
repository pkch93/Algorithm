import sys

sys.stdin = open("inputs/comparestr_input.txt")


def solution(pettern, string):
    n, m = len(string), len(pettern)
    for i in range(n - m + 1):
        if pettern == string[i:i+m]:
            return 1
    return 0


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        pettern, string = input(), input()
        print(f"#{test_case + 1} {solution(pettern, string)}")


if __name__ == '__main__':
    main()
