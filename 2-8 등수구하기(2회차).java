설명

N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.

같은 점수가 입력될 경우 높은 등수로 동일 처리한다.

즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.


입력

첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.


출력

입력된 순서대로 등수를 출력한다.

예시 입력 1                         예시 출력 1

5                    
87 89 92 100 76                    4 3 2 1 5


import java.util.*;
class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            number.add(input.nextInt());
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (number.get(i) < number.get(j)) {
                    count++;
                }
            }
            answer.add(count + 1);
            count = 0;
        }

        for (Integer i : answer) {
            System.out.printf(i + " ");
        }
    }
}

2회차 문제풀이

import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] arr = new int[n];//사용자 점수 저장 배열
        int count = 0; // 등수 카운터

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int[] answer = new int[n];//정답값 저장 배열

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    count++;
                }
            }
            answer[i] = count + 1;
            count = 0;
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}



