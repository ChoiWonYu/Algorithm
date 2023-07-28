package AlgorithmNote.dfsbfs;

import java.util.*;

class Node<T>{
  T data;
  Node lt,rt;
  public Node(T val){
    data=val;
    lt=rt=null;
  }
}

public class DFS {
  static Node<Integer> root;

  public static void dfs(Node n) {
    if(n==null)return;
    dfs(n.lt);
    System.out.println(n.data);
    dfs(n.rt);
  }

  public static void main(String[] args) {
    root=new Node<Integer>(1);
    root.lt=new Node<Integer>(2);
    root.rt=new Node<Integer>(3);
    root.lt.lt=new Node<Integer>(4);
    root.lt.rt=new Node<Integer>(5);
    root.rt.lt=new Node<Integer>(6);
    root.rt.rt=new Node<Integer>(7);
    dfs(root);
  }
}
