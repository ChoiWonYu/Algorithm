package inflearn.dfsbfs;

public class Binary {

  public static void Binary(int n){
    if(n==0)return;
    Binary(n/2);
    System.out.println(n%2);
  }

  public static void main(String[] args) {
    Binary(11);
  }

}
