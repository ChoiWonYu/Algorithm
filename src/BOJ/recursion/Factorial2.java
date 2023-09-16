package BOJ.recursion;

import java.util.*;

public class Factorial2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        long result=fact(n);

        System.out.println(result);
    }

    public static long fact(int n){
        if(n==1||n==0)return 1;

        return n*fact(n-1);
    }
}
