
설명

입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.


입력

첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.


출력

남은 문자만 출력한다.


예시 입력 1                         예시 출력 1

(A(BC)D)EF(G(H)(IJ)K)LM(N)          EFLM




인프런 정답 풀이

import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Stream;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str = input.next();

        Deque<Character> deque = new ArrayDeque<>();
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            if (c == ')') {
                while (deque.pop() != '(') ;
            } else {
                deque.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            sb.append(deque.pollLast());
        }
        System.out.println(sb);



    }
}




대큐로 풀이 스택보단 대큐를 쓰는게 더 좋다.

import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Stream;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str = input.next();

        Deque<Character> deque = new ArrayDeque<>();
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            if (c == '(') {
                deque.push(c);
            } else if (Character.isAlphabetic(c)) {
                deque.push(c);
            } else if (c ==')'){
                while (deque.peek() != '(') {
                    deque.pop();
                }
                deque.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            sb.append(deque.pollLast());
        }
        System.out.println(sb);

    }
}


스택으로 풀이

import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Stream;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str = input.next();

        Stack<Character> deque = new Stack<>();
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            if (c == '(') {
                deque.push(c);
            } else if (Character.isAlphabetic(c)) {
                deque.push(c);
            } else if (c ==')'){
                while (deque.peek() != '(') {
                    deque.pop();
                }
                deque.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deque.size(); i++) {
            sb.append(deque.get(i));
        }
        System.out.println(sb);


    }
}


2회차 풀이

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String request = input.next(); //문자 입력받기

        Deque<Character> deque = new ArrayDeque<>(); //스택 생성

        char[] charArray = request.toCharArray();

        for (char c : charArray) {
            if (c == ')') {
                while (deque.peek() != '(') {
                    deque.pop();
                }
                deque.pop();
            } else {
                deque.push(c);
            }
        }

        //해당 기능으로 풀었지만 채점 사이트에서 해당 메서드로 구현시 컴파일 에러 발생
//        Deque<Character> answer = deque.reversed();
//        for (Character c : answer) {
//            System.out.print(c);
//        }

        int size = deque.size();
        for (int i = 0; i < size; i++) {
            System.out.print(deque.pollLast());
        }
    }
}


