자연수 N이 주어지면 1부터N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.

입력설명
첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.

출력설명
첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
단 공집합은 출력하지 않습니다.

입력예제 1              출력예제1
3                      1 2 3
                       1 2
                       1 3
                       1
                       2 3
                       2
                       3


import java.util.Scanner;

public class Test {
    static int n;
    static int[] ch;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        ch = new int[n + 1];
        DFS(1);
    }

    private static void DFS(int L) {
        if (L == n+1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }
            if (!tmp.isEmpty()) {
                System.out.println(tmp);
            }
        } else {
            ch[L] = 1; //왼쪽
            DFS(L + 1);
            ch[L] = 0; //오른쪽
            DFS(L + 1);
        }
    }

}

2회차 문제 풀이

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    static int[] arr;
    static int n;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt(); // 사용자 입력 값

        arr = new int[n + 1]; //인덱스의 값을 숫자로 사용하기 때문에 n+1 했음

        DFS(1);

    }

    private static void DFS(int i) {

        if (i > n) {
//            String answer = ""; //정답 출력 변수  성능최적화를 위해 문자가 계속 바뀌므로 스트링빌더 사용하는게 좋다.
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == 1) {
//                    answer += j + " ";
                    sb.append(j + " ");
                }
            }
            if (!sb.isEmpty()) {
                System.out.println(sb);
            }

        } else {
            arr[i] = 1; //이 숫자를 넣기 때문에 1을 줌
            DFS(i + 1); //다음 숫자도 넣을지 말지 체크

            arr[i] = 0; //이 숫자를 빼기 때문에 0을줌
            DFS(i + 1); //해당 숫자를 빼고 나서 다음 숫자 넣을지 말지 체크

        }
    }

}


                     
