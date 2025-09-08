설명

N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.

(첫 번째 수는 무조건 출력한다)


입력

첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.


출력

자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.

예시 입력 1                   예시 출력 1

6
7 3 9 5 6 12                 7 9 6 12

import java.util.*;
class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] numebers = new int[n];

        int max = 0;
        int[] answers = new int[n];


        for (int i = 0; i < n; i++) {
            int num = input.nextInt();
            numebers[i] = num;
        }

        answers[0] = numebers[0];
        max = numebers[0];

        for (int i = 1; i < n; i++) {
            if (numebers[i] > max) {
                answers[i] = numebers[i];
                max = numebers[i];
            } else {
                max = numebers[i];
            }
        }

        for (int answer : answers) {
            if (answer != 0) {
                System.out.print(answer + " ");
            }
        }
    }
}

2회차 풀이 

import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        int n = input.nextInt();  //총 몇개의 숫자 받을지
        int[] arr = new int[n+1]; //사용자 숫자 받기

        ArrayList<Integer> answer = new ArrayList<>(); //정답 값 저장

        for (int i = 1; i < n+1; i++) {
            arr[i] = input.nextInt();
        }


        for (int i = n; i >= 1; i--) {
            if (arr[i] > arr[i - 1]) {
                answer.add(arr[i]);
            }
        }

        

        Collections.reverse(answer);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }

    }
}


2회차에서 조금만 더 최적화

import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        int n = input.nextInt();
        int[] arr = new int[n];
        List<Integer> answer = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        answer.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                answer.add(arr[i]);
            }
        }

        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }
}






