package BOJ.measureMultiplePrime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Colonnade {
    static int gcd(int a, int b){
        if(b==0)return a;
        else return gcd(b,a%b);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<T;i++){
            Integer num=Integer.parseInt(br.readLine());
            arr.add(num);
        }

        Collections.sort(arr);
        int minGap=arr.get(1)-arr.get(0);
        for(int i=0;i<T;i++){
            if(i>0) {
                minGap=gcd(minGap,Math.abs(arr.get(i)-arr.get(i-1)));
            };
        }
        System.out.println((arr.get(arr.size()-1)-arr.get(0))/minGap-T+1);
    }
}
