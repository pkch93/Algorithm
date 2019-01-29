import sys

sys.stdin = open("inputs/palindrome_input.txt")


def solution(input_list, m):
    n = len(input_list)
    count = n - m + 1
    for i in range(n):
        for c in range(count):
            j = 0
            while j < (m // 2):
                if input_list[i][c+j] != input_list[i][m+c-j-1]:
                    break
                j += 1
            if j == (m // 2):
                return "".join(input_list[i][c:c+m])

    for i in range(n):
        for c in range(count):
            j = 0
            result = []
            while j < (m // 2):
                if input_list[c+j][i] != input_list[m+c-j-1][i]:
                    break
                result.append(input_list[c+j][i])
                j += 1
            if j == m // 2:
                if m % 2:
                    middle = [input_list[c+j][i]]
                    result += middle + result[::-1]
                else:
                    result += result[::-1]
                return "".join(result)

def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        input_list = []
        n, m = map(int, input().split())
        for _ in range(n):
            input_list.append(input())
        print(f"#{test_case + 1} {solution(input_list, m)}")


if __name__ == '__main__':
    main()
