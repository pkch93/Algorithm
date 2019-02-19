import sys

sys.stdin = open('inputs/maze_input.txt')

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def __dfs(adj, x, y):
    global flag
    n = len(adj)
    if adj[y][x] == 3:
        flag = 1
        return
    adj[y][x] = 9
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and \
                (adj[ny][nx] == 0 or adj[ny][nx] == 3):
            __dfs(adj, nx, ny)


def solution(adj):
    nrange = range(len(adj))
    for i in nrange:
        for j in nrange:
            if adj[i][j] == 2:
                y, x = i, j
                break
    __dfs(adj, x, y)


def main():
    global flag, cnt
    test_cases = int(input())
    for test_case in range(test_cases):
        adj = []
        n = int(input())
        for _ in range(n):
            adj.append(list(map(int, input())))
        flag = 0
        solution(adj)
        print(f'#{test_case + 1} {flag}')

if __name__ == '__main__':
    main()
