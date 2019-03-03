def solution(s, x):
    temp = list(s)
    answer = 'NONE'
    for i in range(len(temp)-1):
        first = int(s[:i + 1])
        second = int(s[i + 1:])
        result = first + second
        if x == result:
            answer = f'{first}+{second}={result}'
            break
    return answer


def main():
    s, x = input().split();
    print(solution(s, int(x)))


if __name__ == '__main__':
    main()
