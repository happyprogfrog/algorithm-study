package dfsbfs;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 7-5. 이진트리 순회 - 깊이우선탐색(전위/중위/후위 순회)
 */
public class Quest5 {
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

        dfs(root);
    }

    private static void dfs(Node node) {
        if (node == null) {
            return;
        }

        // System.out.print(node.data + " ");
        dfs(node.lt);
        // System.out.print(node.data + " ");
        dfs(node.rt);
        // System.out.print(node.data + " ");
    }
}
