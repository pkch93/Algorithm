def find_bingo(bingo_board):
    bingo_num = 0
    diag = rdiag = 0
    for i in range(5):
        row = col = 0
        if bingo_board[i][i]:
            diag += 1
        if bingo_board[4-i][i]:
            rdiag += 1
        for j in range(5):
            if bingo_board[i][j]:
                col += 1
            if bingo_board[j][i]:
                row += 1
        if row == 5:
            bingo_num += 1
        if col == 5:
            bingo_num += 1
    if diag == 5:
        bingo_num += 1
    if rdiag == 5:
        bingo_num += 1
    return bingo_num


def solution(user, npc):
    bingo_board = [[False for _ in range(5)]for _ in range(5)]
    for i in range(25):
        ny = i // 5
        nx = i % 5
        n_num = npc[ny][nx]
        for j in range(5):
            for k in range(5):
                if user[j][k] == n_num:
                    bingo_board[j][k] = True
        if find_bingo(bingo_board) >= 3:
            return i + 1


def main():
    user = []
    npc = []
    for i in range(2):
        for _ in range(5):
            if i == 0:
                user.append(list(map(int, input().split())))
            else:
                npc.append(list(map(int, input().split())))
    print(solution(user, npc))


if __name__ == '__main__':
    main()
