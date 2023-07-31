package AlgorithmNote.dfsbfs;

public class TreeRouteDFS {
  static Node root;

  public static int Dfs(int L, Node root) {
    if(root.lt==null&&root.rt==null)return L;
    return Math.min(Dfs(L+1,root.lt),Dfs(L+1,root.rt));
  }

  public static void main(String[] args) {
    root=new Node<Integer>(1);
    root.lt=new Node<Integer>(2);
    root.rt=new Node<Integer>(3);
    root.lt.lt=new Node<Integer>(4);
    root.lt.rt=new Node<Integer>(5);
    System.out.println(Dfs(0,root));
  }

}
