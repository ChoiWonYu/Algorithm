package inflearn.array;

import java.util.Scanner;

public class ReversePrime {
    public static boolean isPrime(int n){
        if(n==1)return false;
        for(int i=2;i<=Math.sqrt(n);i++)if(n%i==0)return false;
        return true;
    }

    public static String solution(String[] arr){
        StringBuilder answer=new StringBuilder();
        for(String s:arr){
            StringBuilder sb=new StringBuilder();
            int n=Integer.parseInt(sb.append(s).reverse().toString());
            if(isPrime(n))answer.append(n+" ");
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String result=solution(sc.nextLine().split(" "));
        System.out.println(result);
    }
}
