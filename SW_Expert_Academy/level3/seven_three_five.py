
def solution(input_list):
    answer = []
    n = len(input_list)
    for i in range(n):
        i_num = input_list[i]
        for j in range(i + 1, n):
            j_num = input_list[j]
            for k in range(j + 1, n):
                k_num = input_list[k]
                temp = i_num + j_num + k_num
                if answer.count(temp) == 0:
                    answer.append(temp)
    print(answer)
    return sorted(answer, reverse=True)[4]

def main():
    n = int(input())
    for i in range(n):
        input_list = [int(s) for s in input().split()]
        print(f"#{i + 1} {solution(input_list)}")

if __name__ == "__main__":
    main()