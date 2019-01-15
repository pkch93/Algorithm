def solution(n):
    answer = 99
    if n < 100:
        return n
    for i in range(111, n + 1):
        temp = [int(s) for s in str(i)]
        interval = temp[0] - temp[1]
        j = 1
        while j < (len(temp) - 1):
            temp2 = temp[j] - temp[j + 1]
            if interval != temp2:
                break
            j += 1
        if j == len(temp) - 1:
            answer += 1
    return answer

def main():
    n = int(input())
    print(solution(n))

if __name__ == '__main__':
    main()