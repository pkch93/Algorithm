import sys

sys.stdin = open('inputs/brace_check_input.txt')


def solution(input_str):
    stack = []
    braces = {
        '(': ')',
        '{': '}'
    }
    for s in input_str:
        if s not in ['(', '{', ')', '}']:
            continue
        if s in braces:
            stack.append(s)
        elif not stack or s != braces[stack.pop()]:
            return 0
    return 0 if stack else 1


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        input_str = input()
        print(f'#{test_case + 1} {solution(input_str)}')


if __name__ == '__main__':
    main()
