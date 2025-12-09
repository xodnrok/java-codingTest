설명

현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.

현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.

기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.

만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.


입력

첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.


출력

첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.


예시 입력 1                                               예시 출력 1

10 3                                                      143
13 15 34 23 45 65 33 11 26 42  




import java.util.*;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        Set<Integer> Tset = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        boolean b = true;

        int count = 0;
        for (Integer i : Tset) {
            count++;
            if (count == k) {
                System.out.println(i);
                b = false;
                break;
            }
        }

        if (b) {
            System.out.println(-1);
        }


    }
}


2회차 풀이

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); //카드 의 총 갯수
        int k = input.nextInt(); //k번째 큰값

        int[] arr = new int[n]; //카드를 저장할 배열 생성
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());//카드합 저장 리스트
        int sum = 0; // 카드 k개 저장 합
        int count = 1; //set 원하는 k번째를 찾기위해
        boolean b = true;

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int l = j + 1; l < n; l++) {
                    sum = arr[i] + arr[j] + arr[l];
                    set.add(sum);
                    sum = 0;
                }
            }
        }

        for (Integer i : set) {
            if (count == k) {
                b = false;
                System.out.println(i);
                break;
            }
            count++;
        }

        if (b) {
            System.out.println(-1);
        }


    }
}


