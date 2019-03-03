def solution(games):
    n = len(games)
    answer = [0]*n
    for i in range(3):
        for j in range(n):
            if not games[j][i]:
                continue
            temp = games[j][i]
            flag = False
            for k in range(j+1, n):
                if temp == games[k][i]:
                    games[k][i] = 0
                    flag = True
            if flag:
                games[j][i] = 0
        for j in range(n):
            if games[j][i]:
                answer[j] += games[j][i]
    return answer


def main():
    n = int(input())
    games = []
    for _ in range(n):
        games.append(list(map(int, input().split())))
    print(*solution(games))


if __name__ == '__main__':
    main()
