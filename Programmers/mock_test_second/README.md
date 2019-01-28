# 프로그래머스 제 2회 코딩테스트 실전 모의고사

> 문제는 모의고사가 끝나서 열람할 수 없습니다 ㅠㅠ
>
> 아래는 제가 문제를 풀때 생각한 방식과 코드를 첨부하여 간략하게 저만의 해설을 해보았습니다. 
>
> 프로그래머스의 공식해설도 볼 수 있습니다. :) [공식 해설 보기](https://programmers.co.kr/competitions/92/%EA%B3%B5%EC%B1%84-%EB%8C%80%EB%B9%84-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%8B%A4%EC%A0%84-%EB%AA%A8%EC%9D%98%EA%B3%A0%EC%82%AC-2%ED%9A%8C)
>
> 코딩테스트에는 주로 Java를 사용하므로 이번 모의고사에도 Java를 사용하였습니다.

## 1. 배열회전

`배열 2개`를 입력받아 `첫 번째 배열의 원소들을 하나씩 오른쪽으로 옮기면 두 번째 배열처럼 만들 수 있는지` 묻는 문제였습니다.

> 배열의 길이는 0 ~ 1500 인 것으로 기억합니다

처음에 배열의 `원소에는 중복이 없고` 두 배열의 `길이가 같다고` 이해했었습니다. 때문에 처음 생각한 로직은 첫 번째 배열의 첫 번째 원소를 두 번째 배열에서 찾아 `벌어지는 간격`을 구하고 그 간격을 바탕으로 배열을 `for문으로 순회`하면 정답이 될 것으로 기대했습니다.

하지만 위와 같이 코드를 짰을 때 `런타임에러`와 함께 실패하는 테스트코드가 있음을 알 수 있었습니다.

`런타임에러`는 주어진 조건에 두 배열의 길이가 같다는 조건이 없었으므로 두 배열의 길이를 검사하여 다르면 false를 리턴하도록 하여 해결했습니다.

`실패하는 테스트코드`의 경우는 중복된 원소가 있을 때 위 로직으로는 알아볼 수 없으므로 결국 for문을 두 번 돌아 모든 경우의 수를 알아보는 방식으로 바꿨습니다. 배열의 길이가 최대 1500이었기 때문에 충분히 가능하다고 생각했고 모든 테스트케이스를 통과할 수 있었습니다.

```java
public boolean solution(int[] arrA, int[] arrB) {
    int n = arrA.length;
    if (arrB.length != n) return false;
    for (int i = 0; i < n; i++){
        int j;
        for (j = 0; j < n; j++){
            int idx = (i + j) % n;
            if (arrA[j] != arrB[idx]) break;
        }
        if (j == n) return true;
    }
    return false;
}
```

[첫 번째 문제 배열회전 코드 보기](First.java)

## 2. 가로등

`도로의 길이`와 `가로등의 위치`가 입력값으로 주어졌을때 모든 도로를 비추는 `d의 크기 중 최소값`을 구하는 문제였습니다. 가로등은 좌/우 둘 다 비출 수 있다는 것이 특징입니다.

저는 이 문제가 걸음마 문제 형식과 비슷하다고 생각했습니다.

모든 가로등의 위치에서 도로를 비추는 최대값을 d로 가져와 비교하는 방식으로 이번 문제를 풀었습니다. 다만, 가로등의 위치가 정렬되어 있지 않았기 때문에 먼저 정렬을 해준 후 위 로직을 수행했습니다.

```java
public int solution(int l, int[] v) {
    Arrays.sort(v);
    int d = v[0], n = v.length;
    for (int i = 1; i < v.length; i++){
        int mid = (v[i] + v[i-1]) / 2;
        d = Math.max(Math.max(v[i] - mid, mid - v[i-1]), d);
    }
    if (v[n-1] + d < l) d = l - v[n-1];
    return d;
}
```

`Arrays.sort(v)`로 입력받은 가로등의 위치인 v를 먼저 정렬했습니다. 그 후 처음 d는 첫 번째 가로등이 비춰줘야하기 때문에 첫 번째 있는 가로등의 위치만큼 준 후 비교를 시작 했습니다. `mid`로 v[i]과 v[i-1]을 2로 나눠준 이유는 가로등이 좌/우로 비출 수 있기 때문입니다.

위 for문이 끝나면 `마지막 가로등까지의 거리를 비추는 최소 d`를 구할 수 있습니다. 하지만 위 문제에서는 `거리를 모두 비추는 것`입니다. 따라서 마지막 if를 통해 `마지막 가로등에서 거리의 끝까지 빛을 비출 수 있는지` 판단하여 d값을 할당했습니다.

## 3. 빙고

`빙고판을 이루는 이차원 배열`과 `빙고를 맞추는 nums 일차원 배열`이 입력값으로 들어와 `모두 몇 개의 빙고가 맞춰지는지` 알아보는 문제입니다.

> 이차원 배열의 최대 크기는 500 X 500, nums도 그에 맞춰 최대 크기는 500 X 500 입니다.

일단 nums의 원소 하나를 탐색할 때마다 빙고판에 존재하는지 유무를 판단해야하기 때문에 빙고판을 모두 탐색해야합니다. (`빙고판 탐색에 O(n^2)`)

이 경우 nums가 `n^2`이고 빙고판이 `n^2`이므로 최악의 경우에는 500^4인 6,250,000,000번 탐색해야함을 알 수 있었고 위 로직으로는 시간초과가 날 수 밖에 없습니다.

이를 해결하기 위해 복잡도를 줄이는 방법을 생각해보았습니다. 일단 빙고판은 모두 돌아야합니다. 그렇다면 일차원 배열인 `nums`에서 복잡도를 줄일 방법을 생각해야했습니다.

`nums`를 정렬한 후 이분 탐색을 한다면 `n^4`을 `n^2 * logn^2`의 복잡도로 줄일 수 있을 거라 확신했습니다. 그러면 약 `25000 * 14.xx`번 탐색하면 되므로 복잡도가 많이 줄어드는 것을 알 수 있습니다.

따라서 이분 탐색을 위한 `binarySearch` 메서드를 만들고 빙고판을 모두 탐색하면서 해당 행과 열, 대각선이 빙고가 되는지 판단하였습니다.

```java
private boolean binarySearch(int [] nums, int idx){
    int start = 0, end = nums.length - 1;
    while (start <= end) {
        int mid = (start + end) / 2;
        if (nums[mid] > idx) end = mid - 1;
        else if (nums[mid] < idx) start = mid + 1;
        else return true;
    }
    return false;
}

public int solution(int[][] board, int[] nums) {
    Arrays.sort(nums);
    int n = board.length, answer = 0;
    boolean diag, rdiag;
    diag = rdiag = true;
    for (int i = 0; i < n; i++){
        boolean r, c; // r : row, c : column
        r = c = true;
        if (!binarySearch(nums, board[i][i])) diag = false;
        if (!binarySearch(nums, board[i][n-i-1])) rdiag = false;
        for (int j = 0; j < n; j++){
            if (!binarySearch(nums, board[i][j])) r = false;
            if (!binarySearch(nums, board[j][i])) c = false;
        }
        if (r) answer += 1;
        if (c) answer += 1;
    }
    if (diag) answer += 1;
    if (rdiag) answer += 1;
    return answer;
}
```

## 총평

저번 1회 모의고사도 봤었습니다. 그 때는 마지막 문제를 풀지 못했던 것으로 기억하는데 이번 모의고사는 그 때보다는 쉽게 나왔다고 생각합니다.

제가 코딩테스트를 보면서 문제를 다 풀어본 적은 이번이 처음입니다. 알고리즘을 공부하면서 복잡도를 생각하는 방법, 어떻해야 좀 더 효율적인 코드를 작성하는지를 고민하니 어느정도 실력이 향상되는 것 같습니다.

이제 약점 중 하나인 BFS / DFS / Tree 순회를 좀 더 공부하면서 다가올 코딩테스트를 준비해야겠습니다.

2019년도 화이팅!
