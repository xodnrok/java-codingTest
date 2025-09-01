설명

영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,

특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.


입력

첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.


출력

첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.

예시 입력 1                     예시 출력 1

a#b!GE*T@S                     S#T!EG*b@a


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String str = input.next();

        char[] charArray = str.toCharArray();

        int lt = 0;
        int rt = str.length() - 1;

        while (rt > lt) {

            if (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(charArray[rt])) {
                rt--;
            } else {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }
        }
        System.out.println(charArray);
    }
}

2회차 풀이 코드

import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String request = input.next();

        String[] arr = request.split("");

        int left = 0;
        int right = request.length() - 1;

        while (left < right) {
            if (Character.isAlphabetic(request.charAt(left)) && Character.isAlphabetic(request.charAt(right))) {
                arr[left] = String.valueOf(request.charAt(right));
                arr[right] = String.valueOf(request.charAt(left));
                left++;
                right--;
            } else if (!Character.isAlphabetic(request.charAt(left))) {
                left++;
            } else {
                right--;
            }
        }

        for (String s : arr) {
            System.out.print(s);
        }


    }
}


조금더 최적화 코드 charArrary

import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String request = input.next();

        char[] arr = request.toCharArray();

        int left = 0;
        int right = request.length() - 1;


        while (left < right) {
            if (Character.isAlphabetic(request.charAt(left)) && Character.isAlphabetic(request.charAt(right))) {
                arr[left] = request.charAt(right);
                arr[right] = request.charAt(left);
                left++;
                right--;
            } else if (!Character.isAlphabetic(request.charAt(left))) {
                left++;
            } else {
                right--;
            }
        }

        for (char s : arr) {
            System.out.print(s);
        }


    }
}



