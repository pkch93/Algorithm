def solution(exp_data):
    answer = 0
    for i in range(3, len(exp_data)):
        if not answer and exp_data[i] == 1:
            answer = i
        elif answer and exp_data[i] == -1:
            return 'F'
    return 'F' if not answer else answer


def main():
    n = int(input())
    exp_data = [0]*10
    for _ in range(n):
        cnt, like = input().split()
        i = int(cnt)
        if like == 'N':
            exp_data[i] = -1
        else:
            exp_data[i] = 1
    print(solution(exp_data))


if __name__ == '__main__':
    main()
