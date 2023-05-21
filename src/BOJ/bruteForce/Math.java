package BOJ.bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Math {


    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        double a=Double.parseDouble(st.nextToken());
        double b=Double.parseDouble(st.nextToken());
        double c=Double.parseDouble(st.nextToken());
        double d=Double.parseDouble(st.nextToken());
        double e=Double.parseDouble(st.nextToken());
        double f=Double.parseDouble(st.nextToken());

        StringBuilder result=new StringBuilder();
        for(int x=-999;x<1000;x++){
            for(int y=-999;y<1000;y++){
                if(a*x+b*y==c&&d*x+e*y==f){
                    result.append(x).append(' ').append(y);
                    break;
                }
            }
        }
        System.out.println(result.toString());
    }

}
