package BOJ.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CantorianSet {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input=br.readLine())!=null) {
            int len=(int)Math.pow(3,Integer.parseInt(input));
            char[] charArr = new char[len];

            Arrays.fill(charArr, '-');

            setCantorian(charArr,0,len-1);

            for(char c:charArr)sb.append(c);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void setCantorian(char[] input,int s,int e) {
        int interval=(e-s+1)/3;
        Arrays.fill(input,s+interval,s+interval*2,' ');

        if(interval<=1)return;

        for (int i = 0; i < 3; i++) {
            setCantorian(input,s+interval*i,s+interval*(i+1)-1);
        }

    }
}
