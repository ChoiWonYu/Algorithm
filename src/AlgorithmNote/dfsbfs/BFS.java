package AlgorithmNote.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
  static Node root;

  public static void Bfs(Node node) {
    Queue<Node> Q = new LinkedList();
    Q.add(node);
    int L=0;
    while (!Q.isEmpty()) {
      int len=Q.size();
      System.out.print(L+" : ");
      for (int i = 0; i < len; i++) {
        Node cur = Q.poll();
        System.out.print(cur.data+" ");
        if(cur.lt!=null)Q.offer(cur.lt);
        if(cur.rt!=null)Q.offer(cur.rt);
      }
      L++;
      System.out.println();
    }
  }

  public static void main(String[] args) {
    root=new Node<Integer>(1);
    root.lt=new Node<Integer>(2);
    root.rt=new Node<Integer>(3);
    root.lt.lt=new Node<Integer>(4);
    root.lt.rt=new Node<Integer>(5);
    root.rt.lt=new Node<Integer>(6);
    root.rt.rt=new Node<Integer>(7);
    Bfs(root);
  }
}
