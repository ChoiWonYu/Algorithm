package inflearn.dfsbfs;

public class Fibonacci {
  static int[] fibo;
  public static int Fib(int n) {
    if(fibo[n]>0)return fibo[n];
    if(n==1||n==2) {
      fibo[n]=1;
      return 1;
    }
    fibo[n]=Fib(n - 1) + Fib(n - 2);
    return fibo[n];
  }

  public static void main(String[] args) {
    int n=5;
    fibo = new int[n+1];
    Fib(5);
    for (int i = 1; i <= n; i++) {
      System.out.print(fibo[i]+" ");
    }
  }

}
