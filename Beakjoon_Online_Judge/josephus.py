def solution(n, m):
    answer = []
    k = m
    temp = [i+1 for i in range(n)]
    while len(temp) > 0:
        mod = ((m-1) % n)
        answer.append(temp.pop(mod))
        n -= 1
        m = mod + k
    return answer

def main():
    n, m = [int(i) for i in input().split()]
    print("<", end="")
    print(*solution(n, m), sep=", ", end=">")

if __name__ == "__main__":
    main()
