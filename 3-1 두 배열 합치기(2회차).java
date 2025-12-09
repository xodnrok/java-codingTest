설명

오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.


입력

첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.

두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.

세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.

네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.

각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.


출력

오름차순으로 정렬된 배열을 출력합니다.

예시 입력 1                   예시 출력 1

3                            1 2 3 3 5 6 7 9
1 3 5
5
2 3 6 7 9


import java.util.*;
import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = input.nextInt();
        }

        int n2 = input.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = input.nextInt();
        }
        
        int p1 = 0;
        int p2 = 0;
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n1 + n2; i++) {
            if (p1 == arr1.length) {
                answer.add(arr2[p2]);
                p2++;
            } else if (p2 == arr2.length) {
                answer.add(arr1[p1]);
                p1++;
            } else if (arr1[p1] < arr2[p2]) {
                answer.add(arr1[p1]);
                p1++;
            } else if (arr2[p2] < arr1[p1]) {
                answer.add(arr2[p2]);
                p2++;
            } else {
                answer.add(arr1[p1]);
                p1++;
            }
        }

        for (Integer i : answer) {
            System.out.printf(i + " ");
        }
    }
}


다른 풀이 방법 while 문

import java.util.*;
import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = input.nextInt();
        }

        int n2 = input.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = input.nextInt();
        }
        
        int p1 = 0;
        int p2 = 0;
        List<Integer> answer = new ArrayList<>();

        while (p1 < n1 && p2 < n2) {
            if (arr1[p1] < arr2[p2]) {
                answer.add(arr1[p1++]);
            } else {
                answer.add(arr2[p2++]);
            }
        }
        while (p1 < n1) {
            answer.add(arr1[p1++]);
        }
        while (p2 < n2) {
            answer.add(arr2[p2++]);
        }

        for (Integer i : answer) {
            System.out.printf(i + " ");
        }
    }
}


2회차 풀이(투포인터 알고리즘 생각안하고 그냥 풀음)

import java.util.*;
import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); //첫 번째 배열 크기
        int[] arr1 = new int[n]; //첫번째 배열

        for (int i = 0; i < n; i++) {
            arr1[i] = input.nextInt();
        }

        int m = input.nextInt();//두 번째 배열 크기
        int[] arr2 = new int[m];//두번째 배열

        for (int i = 0; i < m; i++) {
            arr2[i] = input.nextInt();
        }

        int[] answer = new int[n + m];

        for (int i = 0; i < n; i++) {
            answer[i] = arr1[i];
        }

        for (int i = 0; i < m; i++) {
            answer[n+i] = arr2[i];
        }

        int[] array = Arrays.stream(answer).sorted().toArray();

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}


2회차 풀이 투포인터 알고리즘 적용

import java.util.*;
import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); //첫 번째 배열 크기
        int[] arr1 = new int[n]; //첫번째 배열

        for (int i = 0; i < n; i++) {
            arr1[i] = input.nextInt();
        }

        int m = input.nextInt();//두 번째 배열 크기
        int[] arr2 = new int[m];//두번째 배열

        for (int i = 0; i < m; i++) {
            arr2[i] = input.nextInt();
        }

        int[] answer = new int[n + m];

        int i = 0; //arr1 의 인덱스
        int j = 0; //arr2 의 인덱스
        int k = 0; //answer 의 인덱스

        while (i < n && j < m) {

            if (arr1[i] < arr2[j]) {
                answer[k] = arr1[i];
                i++;
                k++;
            } else if (arr1[i] > arr2[j]) {
                answer[k] = arr2[j];
                j++;
                k++;
            } else {
                answer[k] = arr1[i];
                i++;
                k++;
            }
        }

        while (j < m) {
            answer[k] = arr2[j];
            k++;
            j++;
        }

        while (i < n) {
            answer[k] = arr1[i];
            k++;
            i++;
        }

        for (int i1 : answer) {
            System.out.print(i1 + " ");
        }
    }
}


