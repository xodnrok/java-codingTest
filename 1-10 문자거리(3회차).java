설명

한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 

입력

첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.

문자열의 길이는 100을 넘지 않는다.


출력

첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

예시 입력 1                                 예시 출력 1
  
teachermode e                              1 0 1 2 1 0 1 2 2 1 0






import java.util.*;
class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String s = input.next();
        char t = input.next().charAt(0);

        int[] answer = new int[s.length()];
        int p = 1000;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        p = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        for (int i : answer) {
            System.out.print(i+" ");
        }
    }
}

2회차 풀이 

import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String s = input.next();
        char t = input.next().charAt(0);

        int[] arr = new int[s.length()];
        Arrays.fill(arr, 100);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                for (int j = 0; j < s.length(); j++) {
                    if (arr[j] > Math.abs(i - j)) {
                        arr[j] = Math.abs(i - j);
                    }
                }

                for (int j = s.length() - 1; j >= 0; j--) {
                    if (arr[j] > Math.abs(i - j)) {
                        arr[j] = Math.abs(i - j);
                    }
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }


    }
}

two pass 알고리즘 사용(1회차와 동일한 알고리즘)


import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String s = input.next();
        char t = input.next().charAt(0);


        int[] answer = new int[s.length()];
        char[] arr = s.toCharArray();

        int p = 100;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t) {
                p = 0;
                answer[i] = 0;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 100;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == t) {
                p = 0;
                answer[i] = 0;
            } else {
                p++;
                if (answer[i] > p) {
                    answer[i] = p;
                }
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}


3회차풀이

 import java.util.*;


class Main {



    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        String s = input.next(); // 문자열
        char t = input.next().charAt(0); // 문자 (char로 받음)

        // 정답을 저장할 배열 (문자열의 길이만큼)
        int[] answer = new int[s.length()];

        // 문자열 길이가 100을 넘지 않으므로 초기 거리는 무조건 100보다 큰 수로 설정
        int count = 1000;

        // 1. 왼쪽에서 오른쪽으로 탐색
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                count = 0; // 타겟 문자를 만나면 거리는 0
            } else {
                count++;   // 아니면 거리가 1씩 증가
            }
            answer[i] = count;
        }

        count = 1000; // 거리를 다시 큰 수로 초기화

        // 2. 오른쪽에서 왼쪽으로 탐색
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                count = 0;
            } else {
                count++;
                // 기존에 저장된 값(왼쪽에서 잰 거리)과
                // 현재 값(오른쪽에서 잰 거리) 중 더 작은 값을 저장
                answer[i] = Math.min(answer[i], count);
            }
        }


        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
            if (i < answer.length - 1) {
                System.out.print(" "); // 마지막 숫자가 아닐 때만 공백 출력
            }
        }
    }

}


3회차 틀린 풀이

 import java.util.*;


class Main {



    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        String s = input.next(); //문자열
        String t = input.next(); //문자

        int count = 1;

        List<Integer> list = new ArrayList<>();//정답 저장

        String[] split = s.split("");

        //왼쪽에서 시작
        for (int i = 0; i < split.length; i++) {

            if (split[i].equals(t)) {
                list.add(0);
                count = 1;
            } else {
                list.add(count);
                count++;
            }
        }

        count = 1;

        //오른쪽에서 시작
        for (int i = split.length - 1; i >= 0; i--) {

            if (split[i].equals(t)) {
                count = 1;
            } else {

                if (list.get(i) > count) {
                    list.remove(i);
                    list.add(i,count);
                    count++;
                }
            }
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }

}






