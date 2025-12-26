설명

N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.

현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,

가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.

C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.


입력

첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.

둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.


출력

첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.

  
예시 입력 1                                 예시 출력 1

5 3                                        3
1 2 8 4 9


import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int c = input.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);

        System.out.println(solution(n,c,arr));
    }

    public static int count(int[] arr, int mid) {
        int eq = arr[0]; //전 좌표
        int cnt = 1; //말의 갯수

        for (int i = 1; i <arr.length; i++) {
            if (arr[i] - eq >= mid) {
                cnt++;
                eq = arr[i];
            }
        }
        return cnt;
    }


    public static int solution(int n, int c, int[] arr) {
        int answer = 0;

        int lt = 1;
        int rt = arr[n-1];


        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }
}

2회차 문제풀이

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); //몇개의 마구간이 있는지
        int c = input.nextInt(); //몇개의 말을 배치할지

        int[] arr = new int[n]; //마구간 저장 배열

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr); //결정 알고리즘을 위해 정렬

        int lt = 1; //최소
        int rt = arr[n - 1] - arr[0]; //최대
        int answer = 0; //정답값 저장

        while (lt <= rt) {

            int mid = (lt + rt) / 2; //말의 최대거리 임의 지정
            int count = 1; //말 저장 횟수 처음말 저장 해야하기 때문에 1로시작한다
            int eq = arr[0]; //말 처음 배치 위치


            for (int i = 1; i < n; i++) {
                if (arr[i] - eq >= mid) { //여러말을 배치할때 하나의 거리만이라도 임의의 거리(mid)값과
                                          //일치하면 되고 나머지는 임의의 거리보다 크면 되기 때문이다.
                    eq = arr[i];
                    count++;
                }
            }

            if (count == c) { //최댓값을 찾기 때문에 lt = mid+1 한다
                answer = mid;
                lt = mid + 1;
            } else if (count < c) {
                rt = mid - 1;
            } else if(count > c){
                answer = mid;
                lt = mid + 1;
            }

        }
        System.out.println(answer);
    }

}



