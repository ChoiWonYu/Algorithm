package BOJ.measureMultiplePrime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCM {
    public static long GCD(long l,long r) {

        if (r == 0) return l;
        else return GCD(r, l % r);
    }
    public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        long l=Long.parseLong(st.nextToken());
        long r=Long.parseLong(st.nextToken());

        System.out.println(r*l/GCD(l,r));
    }
}
