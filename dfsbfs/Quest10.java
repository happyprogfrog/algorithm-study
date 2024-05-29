package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 7-10. Tree 말단 노드까지의 가장 짧은 경로 - BFS
 */
public class Quest10 {
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
          / \
         4   5
        */
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(bfs(root));
    }

    private static int bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node now = q.poll();
                if (now.lt == null && now.rt == null) {
                    return level;
                }

                if (now.lt != null) {
                    q.offer(now.lt);
                }

                if (now.rt != null) {
                    q.offer(now.rt);
                }
            }
            level++;
        }
        return 0;
    }
}
