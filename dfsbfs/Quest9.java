package dfsbfs;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 7-9. Tree 말단 노드까지의 가장 짧은 경로 - DFS
 */
public class Quest9 {
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

        System.out.println(dfs(root, 0));
    }

    private static int dfs(Node node, int level) {
        if (node.lt == null && node.rt == null) {;
            return level;
        } else {
            return Math.min(dfs(node.lt, level + 1), dfs(node.rt, level + 1));
        }
    }
}
