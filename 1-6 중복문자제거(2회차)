설명

소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.

중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.


입력

첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.


출력

예시 입력 1               예시 출력 1

ksekkset                 kset


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str = input.next();

        String answer = "";
        answer += str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (answer.indexOf(str.charAt(i)) == -1) {
                answer += str.charAt(i);
            }
        }
        System.out.println(answer);
    }


}

2회차 코드

import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String request = input.next();

        char[] charArray = request.toCharArray();
        List<String> ch = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (char c : charArray) {
            if (!ch.contains(String.valueOf(c))) {
                sb.append(c);
                ch.add(String.valueOf(c));
            }
        }
        System.out.println(sb);

    }
}


2회차 조금더 최적화 

import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String request = input.next();

        char[] charArray = request.toCharArray();

        Set<Character> ch = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : charArray) {
            if (ch.add(c)) {
                sb.append(c);
            }
        }
        System.out.println(sb);

    }
}




