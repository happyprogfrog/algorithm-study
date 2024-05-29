package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 7-7. 이진트리 순회 - 넓이우선탐색(레벨탐색)
 */
public class Quest7 {
    private static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
            this.lt = null;
            this.rt = null;
        }
    }

    public static void main(String[] args) {
        /*
               1
            /     \
           2       3
          / \     / \
         4   5   6   7
        */
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        bfs(root);
    }

    private static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print("level " + level + ": ");
            for (int i = 0; i < len; i++) {
                Node now = q.poll();
                System.out.print(now.data + " ");

                if (now.lt != null) q.offer(now.lt);
                if (now.rt != null) q.offer(now.rt);
            }
            level++;
            System.out.println();
        }
    }
}
