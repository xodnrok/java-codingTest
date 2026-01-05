이진트리 순회(깊이 우선 탐색)


                      1
            2                     3
    4            5          6          7


전위순회출력: 1 2 4 5 3 6 7
중위순회출력: 4 2 5 1 6 3 7
후위순회출력: 4 5 2 6 7 3 1


import java.util.Scanner;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

class Main {

    Node root;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);

        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        DFS(root);
    }
    public static void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            DFS(root.lt);
            DFS(root.rt);
            System.out.print(root.data + " ");
        }
    }
}

2회차 문제풀이

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Node {

    int data; //내가 가지고 있는 값
    Node lt; //왼쪽 값
    Node rt; //오른쪽 주소

    public Node(int data, Node lt, Node rt) {
        this.data = data;
        this.lt = lt;
        this.rt = rt;
    }

    public Node(int data) {
        this.data = data;
    }
}


class Main {

    public static void main(String[] args) {

        Node node = new Node(1,  //실제 루트 값
                new Node(2, new Node(4), new Node(5)),  //lt 에 대한 생성자
                new Node(3, new Node(6), new Node(7))); //rt에 대한 생성자

        DFS(node);
    }

    private static void DFS(Node node) {
        if (node == null) {
            return;
        }
        DFS(node.lt);
        DFS(node.rt);
        System.out.print(node.data);
    }
}
