package AlgorithmNote.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class TreeRouteBFS {

  static Node root;

  public static int Bfs(Node root) {
    Queue<Node> Q = new LinkedList<>();
    Q.offer(root);
    int level = 0;
    while (!Q.isEmpty()) {
      int len = Q.size();
      for (int i = 0; i < len; i++) {
        Node cur = Q.poll();
        if (cur.lt == null && cur.rt == null) {
          return level;
        }
        if (cur.lt != null) {
          Q.offer(cur.lt);
        }
        if (cur.rt != null) {
          Q.offer(cur.rt);
        }
      }
      level++;
    }
    return -1;
  }

  public static void main(String[] args) {
    root = new Node<Integer>(1);
    root.lt = new Node<Integer>(2);
    root.rt = new Node<Integer>(3);
    root.lt.lt = new Node<Integer>(4);
    root.lt.rt = new Node<Integer>(5);
    System.out.println(Bfs(root));
  }

}
