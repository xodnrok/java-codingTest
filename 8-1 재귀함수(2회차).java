자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작석하세요.

입력설명 
첫 번째 줄은 정수 N(3<=N<=10)이 입력된다.

출력설명
철째 줄에 추력한다.

입력예제 1      출력예제1
3              1 2 3

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

    public static void DFS(int n) {

        if (n == 0) {
            return;
        } else {
            DFS(n - 1);
            System.out.print(n +" ");
        }


    }


}


2회차 풀이

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    static int n;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        n = input.nextInt(); //사용자가 입력한 값

        DFS(1);
    }

    private static void DFS(int num) {
        if (num == n) { //입력한 값과 같으면 입력한 숫자 출력하고 종료
            System.out.print(num);
        } else { //입력한 값과 다르다면 그 값을 출력하고 다시 DFS 메서드에 +1해서 넘긴다.
            System.out.print(num + " ");
            DFS(num+1);
        }
    }

}
