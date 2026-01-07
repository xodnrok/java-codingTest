이진트리 순회(넓이우선탐색 : 레벨탐색)

아래 그림과 같은 이즌트리를 레벨탐색 연습하세요.

                          1
                  2              3

            4          5     6       7

      레벨 탐색 순회 출력 : 1 2 3 4 5 6 7


      import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Node {

    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}


class Main {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.lt = new Node(2);
        node.rt = new Node(3);

        node.lt.lt = new Node(4);
        node.lt.rt = new Node(5);

        node.rt.lt = new Node(6);
        node.rt.rt = new Node(7);

        BFS(node);
    }

    private static void BFS(Node node) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(node);
        int level = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                Node findNode = deque.poll();

                System.out.print(findNode.data + " ");
                if (findNode.lt != null) {
                    deque.offer(findNode.lt);
                }
                if (findNode.rt != null) {
                    deque.offer(findNode.rt);
                }
            }
        }
    }
}

2회차 풀이

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Node {

    int data;
    Node lt;
    Node rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}

class Main {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.lt = new Node(2);
        node.rt = new Node(3);

        node.lt.lt = new Node(4);
        node.lt.rt = new Node(5);

        node.rt.lt = new Node(6);
        node.rt.rt = new Node(7);

        BFS(node);
    }

    private static void BFS(Node node) {

        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(node);

        while (!deque.isEmpty()) {

            Node poll = deque.pollFirst();
            System.out.print(poll.data + " ");

            if (poll.lt != null) {
                deque.addLast(poll.lt);
            }

            if (poll.rt != null) {
                deque.addLast(poll.rt);
            }

        }


    }

}
