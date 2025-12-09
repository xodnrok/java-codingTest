설명

N개의 수로 이루어진 수열이 주어집니다.

이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.

만약 N=8, M=6이고 수열이 다음과 같다면

1 2 1 3 1 1 1 2

합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.


입력

첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.

수열의 원소값은 1,000을 넘지 않는 자연수이다.


출력

첫째 줄에 경우의 수를 출력한다.

예시 입력 1                   예시 출력 1

8 6                          3
1 2 1 3 1 1 1 2


import java.util.*;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int hab = input.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int count = 0;
        int sum = 0;
        int pStart = 0;


        for (int pEnd = 0; pEnd < n; pEnd++) {
            sum += arr[pEnd];
            if (sum == hab) {
                count++;
            }
            while (sum >= hab) {
                sum -= arr[pStart++];
                if (sum == hab) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}

2회차 정답

import java.util.*;
import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //배열 크기
        int m = input.nextInt(); //부분 합

        int answer = 0; //정답 카운트
        int sum = 0; //연속 합 저장

        int[] arr = new int[n]; //배열 저장

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int leftIdx = 0;

        for (int rightIdx = 0; rightIdx < n; rightIdx++) {
            sum += arr[rightIdx];
            if (sum == m) {
                answer++;
            }
            while (sum > m) {
                sum -= arr[leftIdx++];
                if (sum == m) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}



2회차 틀린 답

import java.util.*;
import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //배열 크기
        int m = input.nextInt(); //부분 합

        int answer = 0; //정답 카운트
        int sum = 0; //연속 합 저장

        int[] arr = new int[n]; //배열 저장

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int rightIdx = 1;//오른쪽 포인터 값(점점 증가함)
        int leftIdx = 0; //왼쪽 포인터 값

        while (leftIdx < n) {

            sum += arr[rightIdx];

            if (sum == m) {
                answer++;
                leftIdx++;
                if (leftIdx + 1 < n) {
                    sum = arr[leftIdx];
                }
                if (leftIdx + 1 < n) {
                    rightIdx = leftIdx + 1;
                }
            } else if (sum < m) {
                if (rightIdx + 1 < n) {
                    rightIdx++;
                }
            } else {
                leftIdx++;
                if (leftIdx + 1 < n) {
                    sum = arr[leftIdx];
                }
                if (leftIdx + 1 < n) {
                    rightIdx = leftIdx + 1;
                }
            }


        }

        System.out.println(answer);

    }
}




