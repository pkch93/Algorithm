def solution(s, quiz_list):
    time_cnt = 0
    s = s-1
    for t, z in quiz_list:
        time_cnt += t
        if time_cnt > 210:
            break
        if z == 'T':
            s = (s + 1) % 8
    return s+1


def main():
    s = int(input())
    n = int(input())
    quiz_list = []
    for _ in range(n):
        t, z = input().split()
        quiz_list.append((int(t), z))
    print(solution(s, quiz_list))


if __name__ == '__main__':
    main()
