def solution(time):
    times = (300, 60, 10)
    answer = [0, 0, 0]
    i = 0
    while time > 0 and i < 3:
        temp = time // times[i]
        if temp > 0:
            time -= temp * times[i]
            answer[i] += temp
        i += 1
    if not time:
        print(*answer)
    else:
        print(-1)


def main():
    time = int(input())
    solution(time)


if __name__ == '__main__':
    main()
