def solution(r):
    answer = 0
    for i in range(1, r):
        for j in range(1, r):
            if i ** 2 + j ** 2 <= r ** 2:
                answer += 1
    return answer * 4

def main():
    r = int(input())
    print(solution(r))


if __name__ == '__main__':
    main()
