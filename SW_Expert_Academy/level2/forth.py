import sys

sys.stdin = open('inputs/forth_input.txt')

operators = {
    '+': lambda x, y: x + y,
    '-': lambda x, y: x - y,
    '*': lambda x, y: x * y,
    '/': lambda x, y: x // y,
}


def solution(oper_code):
    stack = []
    opers = operators.keys()
    for c in oper_code:
        if c == '.':
            if len(stack) > 1:
                return 'error'
            return stack.pop()
        if c in opers:
            if len(stack) < 2:
                return 'error'
            else:
                s_num = stack.pop()
                f_num = stack.pop()
                stack.append(operators[c](f_num, s_num))
        else:
            stack.append(int(c))


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        oper_code = input().split()
        print(f'#{test_case + 1} {solution(oper_code)}')


if __name__ == '__main__':
    main()
