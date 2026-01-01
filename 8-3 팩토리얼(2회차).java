자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
예를 들어 5! = 5*4*3*2*1=120입니다.

입력설명
첫 번째 줄에 자연수N(1<=N<=100) 이 주어집니다.

출력설명
첫 번째 줄에 N팩토리얼 값을 출력합니다

입력예제1                출력예제 1 
5                       120



import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("DFS(n) = " + DFS(n));

    }

    private static int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * DFS(n - 1);
        }
    }
    // 돌아가는 로직 
    //5 * DFS(4)
    //     4 * DFS(3)
    //           3 * DFS(2)
    //                 2 * DFS(1)
    //                        1
}


2회차 틀린 풀이

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        DFS(n,1);
    }

    private static void DFS(int n, int sum) {

        if (n == 0) {
            System.out.println(sum);
            return;
        } else {
            sum *= n;
            DFS(n - 1, sum);
        }
    }

}

