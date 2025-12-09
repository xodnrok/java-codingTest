설명

앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.

문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.

단 회문을 검사할 때 대소문자를 구분하지 않습니다.


입력

첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.


출력

예시 입력 1                                예시 출력 1

gooG                                      YES  


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str = input.next();

        String lowerCase = str.toLowerCase();
        char[] charArray = lowerCase.toCharArray();
        Boolean b = false;

        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - i - 1]) {
                System.out.println("NO");
                b = false;
                break;
            } else {
                b = true;
            }
        }
        if (b) {
            System.out.println("YES");
        }
    }
}


2회차 문제 풀이

import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String request = input.next();
        String s = request.toUpperCase();
        char[] array = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        boolean b = false;

        while (left < right) {
            if (array[left] == array[right]) {
                left++;
                right--;
            } else {
                b = true;
                break;
            }
        }

        if (b) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}


