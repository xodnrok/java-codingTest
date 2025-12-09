설명

정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.

정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다.

정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.

왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다.

그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다.

그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다.

한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다.

그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.

이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다.

Image1.jpg

예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자. 처음에는 3번 왕자가 3을 외쳐 제외된다.

이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7번 왕자에게 공주를 구하러갑니다.

N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.


입력

첫 줄에 자연수 N(5<=N<=1,000)과 K(2<=K<=9)가 주어진다.


출력

첫 줄에 마지막 남은 왕자의 번호를 출력합니다.


예시 입력 1                 예시 출력 1

8 3                        7


//인프런 최적화 풀이

import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Stream;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }
        while (!deque.isEmpty()) {
            for (int i = 1; i < k; i++) {
                deque.offer(deque.poll());
            }
            deque.poll();
            if (deque.size() == 1) {
                answer = deque.poll();
            }
        }
        System.out.println(answer);
    }
}







//내가 한 풀이
import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Stream;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i : arr) {
            deque.offer(i);
        }
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < k - 1; j++) {
                Integer poll = deque.poll();
                deque.offer(poll);
            }
            deque.poll();

        }
        System.out.println(deque.getFirst());

    }
}


2회차 풀이

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); //왕자의 총 인원
        int k = input.nextInt(); //제외되는 특정 번호

        Deque<Integer> deque = new ArrayDeque<>(); // 큐 생성
        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            deque.addLast(i); //큐에 값 넣기
        }

        while (!deque.isEmpty()) {

            for (int i = 1; i < k; i++) { //특정 숫자를 외치는 왕자를 찾기
                deque.addLast(deque.poll());
            }
            deque.poll(); //특정 숫자를 외친 왕자를 큐에서 제거

            if (deque.size() == 1) {
                answer = deque.poll(); //마지막 남은 왕자를 꺼내서 정답에 저장
            }
        }
        System.out.println(answer);

    }
}


