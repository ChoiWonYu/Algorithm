package BOJ.measureMultiplePrime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prime {
    static boolean isPrime(int num){
        int count=0;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                count+=2;
            }
        }
        return num!=1&&count==0;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int min=Integer.parseInt(br.readLine());
        int max=Integer.parseInt(br.readLine());
        int minPrime=max;
        int sum=0;

        for(int i=min;i<=max;i++){
            if(isPrime(i)){
                sum+=i;
                if(minPrime>i)minPrime=i;
            }
        }

        if(sum==0){
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(minPrime);
    }
}
