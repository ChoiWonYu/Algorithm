package BOJ.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Recursion {
    static int cnt=0;
    public static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int result,n=Integer.parseInt(br.readLine());
        String input;
        for(int i=0;i<n;i++){
            cnt=0;
            input=br.readLine();
            result = isPalindrome(input);
            sb.append(result).append(" ").append(cnt);
            sb.append("\n");
        }

        System.out.println(sb);

    }

}
