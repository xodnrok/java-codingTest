설명

현수는 1년 과정의 수업계획을 짜야 합니다.

수업중에는 필수과목이 있습니다. 이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있습니다.

만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은 C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.

여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다.

현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만

C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.

수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.

수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.

필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.


입력

첫 줄에 한 줄에 필수과목의 순서가 주어집니다. 모든 과목은 영문 대문자입니다.

두 번 째 줄부터 현수가 짠 수업설계가 주어집니다.(수업설계의 길이는 30이하이다)


출력

첫 줄에 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력합니다.


예시 입력 1                   예시 출력 1

CBA                          YES
CBDAGE



import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char[] charArray1 = input.next().toCharArray();
        char[] charArray2 = input.next().toCharArray();

        Deque<Character> deque1 = new ArrayDeque<>();
        for (char c : charArray1) {
            deque1.offer(c);
        }

        Deque<Character> deque2 = new ArrayDeque<>();
        for (char c : charArray2) {
            deque2.offer(c);
        }

        while (!deque2.isEmpty()) {
            if (deque1.peek() == deque2.peek()) {
                deque1.poll();
                deque2.poll();
            } else {
                deque2.poll();
            }
        }
        if (deque1.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

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

        String essential = input.next(); //필수 과목 순서 문자 받기
        String request = input.next(); //사용자로 부터 수업설계 받기

        Deque<Character> essentialDeque = new ArrayDeque<>(); //필수 과목 저장 큐
        Deque<Character> deque = new ArrayDeque<>(); //사용자 수업계획 저장 큐

        for (int i = 0; i < essential.length(); i++) {
            essentialDeque.addLast(essential.charAt(i)); //필수 과목 저장큐 값 넣기
        }

        for (int i = 0; i < request.length(); i++) {
            deque.addLast(request.charAt(i)); //사용자 수업설계 저장큐 값 넣기
        }

        while (!deque.isEmpty()) {
            Character c = deque.pollFirst(); //수업계획 값 꺼내기
            if (essentialDeque.contains(c) && essentialDeque.peek() == c) { //필수 과목 순서가 맞으므로 필수과목 제거
                essentialDeque.pollFirst();
            } else if (essentialDeque.contains(c) && essentialDeque.peek() != c) { //필수 과목 순서가 안맞으므로 바로 반복문 종료
                break;
            }
        }

        if (essentialDeque.isEmpty()) { // 필수과목 저장 큐가 비었을경우 제대로 된 수업설계
            System.out.println("YES");
        } else { //필수과목 저장 큐가 안비었으므로 제대로 된 수업설계가 아니다.
            System.out.println("NO");
        }



    }
}


