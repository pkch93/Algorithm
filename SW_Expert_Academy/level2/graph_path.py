import sys

sys.stdin = open('inputs/graph_path_input.txt')


def solution(adj, s, f):
    visited = [0] * (len(adj)+1)
    stack = [s]
    while stack:
        s = stack[-1]
        if s == f:
            return 1
        visited[s] = 1
        flag = False
        for w in adj[s]:
            if not visited[w]:
                stack.append(w)
                flag = True
                break
        if not flag:
            stack.pop()
    return 0


def main():
    test_cases = int(input())
    for test_case in range(test_cases):
        v, e = map(int, input().split())
        adj = [[] for _ in range(v+1)]
        for i in range(e):
            s, f = map(int, input().split())
            adj[s].append(f)
        s, f = map(int, input().split())
        print(f'#{test_case+1} {solution(adj, s, f)}')


if __name__ == '__main__':
    main()