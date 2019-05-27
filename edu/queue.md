# Queue

Queue는 FIFO(First-In-First-Out) 형태의 자료구조

## Queue의 구조 및 기본 연산

`Queue`는 `Stack`과 마찬가지로 삽입과 삭제가 제한적인 자료구조이다.

`Stack`이 후입선출의 FILO(Last-In-First-Out) 형태를 띄었다면 `Queue`는 선입선출의 FIFO(First-In-First-Out) 형태를 띈다.

때문에 `Stack`에서 삭제될 값을 `top`으로 가리킨 것처럼 `Queue`도 삽입과 삭제를 위한 특별한 변수가 있다.

***Queue의 변수***

- front

    `front`는 저장된 원소 중 첫 번째 원소를 가리킨다. 즉, `Queue`에서 삭제될 원소 앞의 index를 말한다.
    
- rear

    `rear`는 저장된 원소 중 마지막 원소를 가리킨다. 즉, `Queue`에서 마지막 원소의 index를 말한다.
    
***Queue의 주요 연산***

1. enQueue(item)

    큐의 뒤쪽(`rear`의 다음)에 원소`item`을 삽입하는 연산
    
    ```python
    def enqueue(item):
       global rear  
       if is_full():
           print('queue is full')
       else:
           rear += 1
           Q[rear] = item 
    ```
    
2. deQueue()

    큐의 앞쪽(`front`)에서 원소를 삭제하고 반환하는 연산
    
    ```python
    def dequeue(item):  
       if is_empty():
           print('queue is empty')
       else:
           front += 1
           return Q[front]
    ```
    
3. isEmpty()

    큐가 공백상태인지 확인하는 연산
    
    ```python
    def is_empty():
       return front == rear
    ```
    
4. isFull()

    큐가 포화상태인지 확인하는 연산
    
    ```python
    def is_full():
       return rear == len(Q)-1 
    ```

## 선형큐와 원형큐

### - 선형큐

선형큐는 1차원 배열을 이용한 큐이다. (큐의 크기 = 배열의 크기)

> 큐의 상태 표현
>
> 초기상태: front = rear = -1
>
> 공백상태: front = rear
>
> 포화상태: rear = n-1

단, 선형큐를 사용하게 되면 `front`값이 늘어나므로 `front` 앞의 queue 공간을 사용할 수 없다. (즉, 메모리 낭비 발생)

이 경우 때문에 원형큐가 나타나게 되었다.

### - 원형큐

선형 배열의 인덱스를 순환하도록 만들어 메모리 낭비를 막아준다.

> 이를 위해 나머지 연산 %을 사용한다.

- front

    공백상태와 포화상태 구분을 위해 front가 있는 자리를 사용하지 않고 항상 빈자리로 둔다.
    
> 삽입 위치 및 삭제 위치
>
> 선형큐: rear += 1 (삽입) / front += 1 (삭제) 
> 
> 선형큐: rear = (rear + 1) mod n (삽입) / front = (front + 1) mod n (삭제) 
