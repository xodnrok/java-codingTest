설명

지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.

DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.

순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는

1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.

지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.

고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.

그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.


입력

첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.

다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.

부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.


출력

첫 번째 줄부터 DVD의 최소 용량 크기를 출력하세요.


예시 입력 1                                         예시 출력 1

9 3                                                17
1 2 3 4 5 6 7 8 9


import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println(solution(n,m,arr));
    }

    public static int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;

        for (int i : arr) {
            if (sum + i > capacity) {
                cnt++;
                sum = i;
            } else {
                sum += i;
            }
        }

        return cnt;
    }

    public static int solution(int n, int m, int[] arr) {

        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }
}


2회차 틀린 오답

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    
    static int lt;
    static int rt;
    static int n;
    static int m;
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        n = input.nextInt();//총 몇개의 곡인지

        m = input.nextInt();//몇 개의 디스크로 곡을 담을지
        
        int[] arr = new int[n]; //곡 담을 배열

        int sum = 0;
        
        for (int i = 0; i < n; i++) {

            arr[i] = input.nextInt();

            sum += arr[i];

        }
        
        lt = n;
        rt = sum;
        
        solution(arr, m);
    }
    
    private static void solution(int[] arr, int m) {

        while (lt <= rt) {

            int sum = 0; // 음반 합 더하기
            int count = 0; //디스크 사용 횟수
            
            int mid = (lt + rt) / 2; //중앙값 찾기 (디스크 크기)

            for (int i = 0; i < n; i++) {

                sum += arr[i];
                
                if (sum > mid) {

                    sum -= arr[i];

                    sum = 0;

                    count++;

                }

            }

            if (count == m) {

                System.out.println(mid);
                break;

            } else if (count > m) {
                lt = mid + 1;
            } else if (count < m) {
                rt = mid - 1;
            }

        }
        
    }

}


2회차 정답

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    static int lt;
    static int rt;
    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        n = input.nextInt();//총 몇개의 곡인지

        m = input.nextInt();//몇 개의 디스크로 곡을 담을지

        int[] arr = new int[n]; //곡 담을 배열

        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {

            arr[i] = input.nextInt();
            max = Math.max(max, arr[i]);
            sum += arr[i];

        }

        lt = max;
        rt = sum;

        solution(arr, m);
    }


    private static void solution(int[] arr, int m) {

        int answer = 0;

        while (lt <= rt) {

            int sum = 0; // 음반 합 더하기
            int count = 1; //디스크 사용 횟수

            int mid = (lt + rt) / 2; //중앙값 찾기 (디스크 크기)

            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    sum = arr[i];
                    count++;
                } else {
                    sum += arr[i];
                }
            }

            if (count <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);

    }

}



