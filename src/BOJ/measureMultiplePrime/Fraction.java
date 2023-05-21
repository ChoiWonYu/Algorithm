package BOJ.measureMultiplePrime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fraction {
    public static int GCD(int l,int r) {
        if (r == 0) return l;
        else return GCD(r, l % r);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        int c=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());

        int e=d*a+b*c;
        int f=b*d;

       int g=GCD(e,f);

       e/=g;
       f/=g;

        StringBuilder sb=new StringBuilder();
        sb.append(e).append(' ').append(f);

        System.out.println(sb.toString());
    }
}
