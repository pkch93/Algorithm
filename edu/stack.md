# Stack

> Algorithm 기본 파트 4. 스택 (Stack)

## 스택

> 물건을 쌓아 올리듯 자료를 쌓아 올린 형태의 자료구조

스택은 선형구조를 갖는 자료구조로 후입선출(`LIFO: Last-In-First-Out`)의 특성을 가진다.

즉, 마지막에 삽입(`push`)한 데이터를 가장 먼저 꺼내는 자료구조를 `스택`이라고 한다.

주로 웹사이트의 `즐겨찾기 기능`, `콜 스택` 등을 구현 시 사용된다. 

> 선형구조? 비선형구조?
>
> 선형구조는 자료 간의 관계가 1:1 관계를 가질때를 말한다.
>
> 비선형구조는 자료 간의 관계가 1:N 관계를 가질때를 말한다.

스택을 구현할 때 보통 배열(`array`, `list`)을 사용하여 구현한다. 그리고 이 저장소 자체를 스택이라 부르기도 한다.

### 스택의 연산

> 스택을 다루는 메서드들

1. 삽입(`push`): 저장소에 데이터를 저장
2. 삭제(`pop`): 저장소에서 데이터를 꺼낸다. 이때 꺼낼 데이터는 맨 마지막에 삽입된 데이터를 꺼낸다.
3. 공백확인(`isEmpty`): 스택에 데이터가 있는지 없는지 확인
4. 스택의 맨 위 데이터 확인(`peek`): 스택의 `top`에 있는 데이터를 반환

> top은 스택에서 마지막 삽입된 원소의 위치이다.
