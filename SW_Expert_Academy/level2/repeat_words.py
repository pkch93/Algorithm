import sys

sys.stdin = open('inputs/repeat_words_input.txt')


def solution(input_str):
    stack = []
    for s in input_str:
        if stack and stack[-1] == s:
            stack.pop()
        else:
            stack.append(s)
    return len(stack)


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        input_str = input()
        print(f'#{test_case + 1} {solution(input_str)}')


if __name__ == '__main__':
    main()
