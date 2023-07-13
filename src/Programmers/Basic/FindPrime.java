package Programmers.Basic;

import java.util.*;

public class FindPrime {
    static boolean isPrime(int n){
        if(n==1)return false;
        for(int i=2;i<=Math.sqrt(n);i++)if(n%i==0)return false;
        return true;
    }

    public static int solution(int n) {
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++)arr[i]=i+1;

        return Arrays.stream(arr)
                .filter(FindPrime::isPrime).toArray()
                .length;

    }
}
