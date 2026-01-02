1) 파보나치 수열을 출력한다. 파보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
2) 입력은 파보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13 을 출력하며 된다.

입력설명
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.

출력설명
첫 줄에 피보나치 수열을 출력합니다.

입력예제 1              출력예제 1
10                     1 1 2 3 5 8 13 21 34 55

import java.util.Scanner;

public class Test {
    static int[] fibo;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        fibo = new int[n+1];
        DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    private static int DFS(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1) {
            return fibo[n]=1;
        } else if (n == 2) {
            return fibo[n]=1;
        } else {
            return fibo[n]=DFS(n - 2) + DFS(n - 1);
        }
    }


}

2회차 문제풀이
    
import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    static int[] arr;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        arr = new int[n + 1];

        DFS(n);

        for (int i = 1; i < n + 1; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static int DFS(int n) {

        if (arr[n] > 0) {
            return arr[n];
        }
        if (n == 1) {
            return arr[n] = 1;
        }
        if (n == 2) {
            return arr[n] = 1;
        } else {
            return arr[n] = DFS(n - 2) + DFS(n - 1);
        }
    }

}
//DFS(10) -- DFS(8) + DFS(9) ----> 21 + DFS(9) ---> 21 + 34 = 55
//DFS(8) -- DFS(6) + DFS(7) ----> 8 + DFS(7) ---> 8 + 13 = 21
//DFS(6) -- DFS(4) + DFS(5) ----> 3 + DFS(5) --> 3 + 5 = 8
//DFS(4) -- DFS(2) + DFS(3) ----> 1 + 2 = 3
//DFS(2) -- return 1
//DFS(3) -- DFS(1) + DFS(2) ---> 1 + 1 = 2
//DFS(1) -- return 1
//DFS(5) -- DFS(3) + DFS(4)  ---> 2 + 3 = 5
//DFS(7) -- DFS(5) + DFS(6) ----> 5 + 8 = 13
//DFS(9) --- DFS(7) + DFS(8) ---> 13 + 21 = 34



