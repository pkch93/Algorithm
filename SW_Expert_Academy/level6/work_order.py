import sys

sys.stdin = open('inputs/work_order_input.txt')


def __dfs(adj, preq, s):
    result = []
    stack = [s]
    visited = [0] * (len(adj)+1)
    while stack:
        order = stack[-1]
        if not visited[order]:
            result.append(order)
        visited[order] = 1
        flag = False
        for i in adj[order]:
            if order in preq[i]:
                preq[i].remove(order)
            if not visited[i] and not preq[i]:
                stack.append(i)
                flag = True
                break
        if not flag:
            stack.pop()
    return result


def solution(adj, preq, start_point):
    n = len(adj) - 1
    result = []
    for i in start_point:
        result += __dfs(adj, preq, i)
        if len(result) == n:
            return result
    return result


def main():
    for test_case in range(10):
        v, e = map(int, input().split())
        adj = [[] for _ in range(v+1)]
        preq = [[] for _ in range(v+1)]
        orders = input().split()
        for i in range(0, e*2, 2):
            adj[int(orders[i])].append(int(orders[i+1]))
            preq[int(orders[i+1])].append(int(orders[i]))
        start_point = []
        for i in range(1, v+1):
            if not preq[i]:
                start_point.append(i)
        print(f'#{test_case+1}', *solution(adj, preq, start_point))


if __name__ == '__main__':
    main()