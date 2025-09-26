설명

현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.

만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면

12 1511 20 2510 20 19 13 15

연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.

여러분이 현수를 도와주세요.


입력

첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.

두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.


출력

첫 줄에 최대 매출액을 출력합니다.


예시 입력 1                                   예시 출력 1

10 3                                         56
12 15 11 20 25 10 20 19 13 15


import java.util.*;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int day = input.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int sum = 0;
        int max = 0;


        for (int i = 0; i < day; i++) {
            sum += arr[i];
            max += arr[i];
        }
        for (int i = day; i < n; i++) {
            sum -= arr[i - day];
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);


    }
}


2회차 풀이

import java.util.*;
import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); //총 매출 갯수
        int k = input.nextInt(); //몇 일을 기준으로 할지

        int[] arr = new int[n]; //매출 저장 배열

        int answer = 0; //정답 값 저장
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int lInx = 0; //왼쪽 포인터
        int rInx = k; //오른쪽 포인터

        for (int i = lInx; i < rInx; i++) { //처음 동작만 직접 계산해서 넣는다.
            answer += arr[i];
            sum += arr[i];
        }

        for (int i = rInx; i < n; i++) {
            sum -= arr[lInx];
            sum += arr[i];
            answer = Math.max(answer, sum);
            lInx++;
        }

        System.out.println(answer);






//        while (rInx <= n) { 해당 방법으로 풀 시 타임에러
//
//            for (int i = lInx; i < rInx; i++) {
//                sum += arr[i];
//            }
//            answer = Math.max(sum, answer);
//            sum = 0;
//            lInx++;
//            rInx++;
//
//
//        }


//        System.out.println(answer);


    }
}
