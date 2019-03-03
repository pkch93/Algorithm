def solution(overtime_list):
    overtime_sum = 0
    for overtime in overtime_list:
        worktime = overtime[1] - overtime[0]
        if worktime > 1.0:
            if worktime - 1 > 4:
                overtime_sum += 4
            else:
                overtime_sum += worktime - 1

    answer = overtime_sum * 10000
    if overtime_sum <= 5.0:
        answer += answer * 0.05
    elif overtime_sum >= 15.0:
        answer -= answer * 0.05
    return int(answer)


def main():
    overtime_list = []
    for _ in range(5):
        overtime_list.append(list(map(float, input().split())))
    print(solution(overtime_list))


if __name__ == '__main__':
    main()
