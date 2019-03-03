def solution(bawls):
    answer = 10
    for i in range(1, len(bawls)):
        if bawls[i-1] == bawls[i]:
            answer += 5
        else:
            answer += 10
    return answer


def main():
    bawls = input()
    print(solution(bawls))


if __name__ == '__main__':
    main()
