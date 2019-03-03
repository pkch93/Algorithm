
def solution(hill):
    n = len(hill)
    for h in range(n):
        flag = 0
        for i in range(1, n - 1):
            for j in range(1, n - 1):
                if hill[i][j] > h:
                    flag = 1
                    if hill[i - 1][j] > h and hill[i + 1][j] > h and hill[i][j - 1] > h and hill[i][j + 1] > h:
                        hill[i][j] += 1
        if flag == 0:
            break
    return h


def main():
    n = int(input())
    hill = []
    for _ in range(n):
        hill.append(list(map(int, input())))
    print(solution(hill))


if __name__ == '__main__':
    main()
