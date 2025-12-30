10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단 재귀함수를 이용해서 출력해야 합니다.

입력설명
첫 번째 줄에 10진수 N(1<=N<=1000)이 주어집니다.

출력설명
첫 번째 줄에 이진수를 출력하세요.

입력예제 1          출력예제1
11                  1011

import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        DFS(n);
    }

    private static void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n / 2);
            System.out.print(n % 2);
        }
    }
}

2회차 풀이

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();


        DFS(n);

    }

    private static void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            int num2 = n / 2;
            DFS(num2);

            int num1 = n % 2;
            System.out.print(num1);

        }
    }


}
//11 를 2로 나누면
//몫은 5 나머지 1

//5 를 2로 나누면
//몫은 2 나머지는 1

//2를 2로 나누면
//몫은 1 나머지는 0

//1을 2로 나누면
//몫은 0 나머지는 1
