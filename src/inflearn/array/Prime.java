package inflearn.array;

import java.util.Scanner;

public class Prime {
    public static int solution(int n) {
        int[]arr=new int[n+1];
        int cnt=0;
        for(int i=2;i<=n;i++){
            if(arr[i]==0)cnt++;
            for(int j=i;j<=n;j+=i)arr[j]=1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int result=solution(sc.nextInt());
        System.out.println(result);
    }
}
