설명
 
N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.

정렬하는 방법은 선택정렬입니다.


입력

첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.

두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.


출력

오름차순으로 정렬된 수열을 출력합니다.


예시 입력 1                                   예시 출력 1

6                                            5 7 11 13 15 23
13 5 11 7 23 15


선택정렬 정답

import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }


    }
}


내가 어레이유틸스에서 sort를 써서 푼 정답


import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);
        for (int i : arr) {
            System.out.printf(i + " ");
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
        int n = input.nextInt(); //자연수 몇 개를 받을지
        int[] arr = new int[n]; //자연수 저장할 배열 생성

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt(); //자연수 받아서 배열에 저장
        }

        for (int i = 0; i < n - 1; i++) {

            int min = arr[i]; // 최솟값 저장 변수
            int idx = i; //최솟값을 가지는 인덱스

            for (int j = i; j < n; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    idx = j; //최솟값을 가지는 인덱스 번호
                }
            }
            arr[idx] = arr[i]; //값 바꾸기
            arr[i] = min; //값 바꾸기
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }


        


    }

}



