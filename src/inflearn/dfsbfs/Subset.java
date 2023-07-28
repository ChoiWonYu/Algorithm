package inflearn.dfsbfs;

public class Subset {
  static int n;
  static int[] ch;

  public static void DFS(int num){
    if(num==n+1) {
      StringBuilder sb=new StringBuilder();
      for(int i=1;i<=n;i++){
        if(ch[i]==1)sb.append(i).append(" ");
      }
      if(sb.length()>0)System.out.println(sb.toString());
      return;
    }
    ch[num]=1;
    DFS(num+1);
    ch[num]=0;
    DFS(num+1);
  }

  public static void main(String[] args) {
    n=3;
    ch=new int[n+1];
    DFS(1);
  }
}
