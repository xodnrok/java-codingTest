설명

괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.

(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.


입력

첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.


출력

첫 번째 줄에 YES, NO를 출력한다.

    
예시 입력 1                               예시 출력 1

(()(()))(()                               NO


인프런 보고 푼 정답


import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Stream;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str = input.next();

        Deque<Character> deque = new ArrayDeque<>();
        boolean b = true;
        char[] charArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (charArray[i] == '(') {
                deque.push(charArray[i]);
            } else if (charArray[i] == ')') {
                if (deque.isEmpty()) {
                    System.out.println("NO");
                    b = false;
                    break;
                }
                deque.pop();
            }
        }
        if (b) {
            System.out.println("YES");
        }

    }
}






내가 생각한 풀이

import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Stream;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str = input.next();

        Deque<Character> deque = new ArrayDeque<>();

        char[] charArray = str.toCharArray();
        char pop1 = ' ';
        char pop2 = ' ';
        deque.push(charArray[0]);
        for (int i = 1; i < str.length(); i++) {
            deque.push(charArray[i]);
            if (deque.size() != 1) {
                pop1 = deque.pop();
                pop2 = deque.pop();
            }
            if (pop1 == pop2) {
                deque.push(pop2);
                deque.push(pop1);
            } else if (pop1 == '(' && pop2 == ')') {
                deque.push(pop2);
                deque.push(pop1);
            }
        }
        if (deque.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
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

        String request = input.next(); //질문 받기

        Deque<Character> deque = new ArrayDeque<>();

        char[] charArray = request.toCharArray(); //입력받은 문자 배열로 만들기

        boolean b = true;

        for (char c : charArray) {
            if (c == '(') {
                deque.push(c);
            } else {
                if (deque.isEmpty()) {
                    b = false;
                    break;
                }
                if (deque.peek() == '(') {
                    deque.pop();
                }
            }
        }

        if (b && deque.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}


2회차 런타임 에러 발생


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String request = input.next(); //질문 받기

        Deque<Character> deque = new ArrayDeque<>();

        char[] charArray = request.toCharArray(); //입력받은 문자 배열로 만들기


        for (char c : charArray) {
            if (c == ')' && deque.peek() == '(') {
                deque.pop();
            } else {
                deque.push(c);
            }
        }

        if (deque.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}

