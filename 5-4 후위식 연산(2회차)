설명

후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.

만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.


입력

첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.

식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.


출력

연산한 결과를 출력합니다.


예시 입력 1                 예시 출력 1

352+*9-                    12


import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Stream;


class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str = input.next();
        char[] arr = str.toCharArray();

        Deque<String> deque = new ArrayDeque<>();


        for (Character c : arr) {
            if (c == '+') {
                Integer num1 = Integer.valueOf(deque.pop());
                Integer num2 = Integer.valueOf(deque.pop());
                int num = num2 + num1;
                deque.push(String.valueOf(num));
            }else if(c == '-') {
                Integer num1 = Integer.valueOf(deque.pop());
                Integer num2 = Integer.valueOf(deque.pop());
                int num = num2 - num1;
                deque.push(String.valueOf(num));
            }else if(c == '/') {
                Integer num1 = Integer.valueOf(deque.pop());
                Integer num2 = Integer.valueOf(deque.pop());
                int num = num2 / num1;
                deque.push(String.valueOf(num));
            } else if (c == '*') {
                Integer num1 = Integer.valueOf(deque.pop());
                Integer num2 = Integer.valueOf(deque.pop());
                int num = num2 * num1;
                deque.push(String.valueOf(num));
            } else {
                deque.push(String.valueOf(c));
            }
        }
        System.out.println(deque.getFirst());
    }
}



import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>(); //해당 숫자 저장할 스택 생성

        String request = input.next();// 사용자 입력값 저장

        for (int i = 0; i < request.length(); i++) {
            if (request.charAt(i) == '+') {

                Integer num1 = deque.removeFirst(); //첫번째 값 꺼내기
                Integer num2 = deque.removeFirst(); //두번째 값 꺼내기

                int sum = num1 + num2; //두개의 값을더한다

                deque.addFirst(sum); //더한 두개의 값 결과를 다시 스택에 넣는다.
            } else if ((request.charAt(i) == '-')) {

                Integer num1 = deque.removeFirst(); //첫번째 값 꺼내기
                Integer num2 = deque.removeFirst(); //두번째 값 꺼내기

                int sub = num2 - num1; //두개의 값을뺀다

                deque.addFirst(sub); //뺀 두개의 값 결과를 다시 스택에 넣는다.

            } else if ((request.charAt(i) == '*')) {
                Integer num1 = deque.removeFirst(); //첫번째 값 꺼내기
                Integer num2 = deque.removeFirst(); //두번째 값 꺼내기

                int kob = num1 * num2; //두개의 곱한다

                deque.addFirst(kob); //곱한 두개의 값 결과를 다시 스택에 넣는다.

            } else if ((request.charAt(i) == '/')) {

                Integer num1 = deque.removeFirst(); //첫번째 값 꺼내기
                Integer num2 = deque.removeFirst(); //두번째 값 꺼내기

                int sum = num2 / num1; //두개의 값을나눈다.

                deque.addFirst(sum); //나눈 두개의 값 결과를 다시 스택에 넣는다.
            } else {
                deque.addFirst(Integer.valueOf(String.valueOf(request.charAt(i))));
            }
        }

        Integer answer = deque.removeFirst();
        System.out.println(answer);
    }
}


