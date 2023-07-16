package inflearn.string;

import java.util.*;

public class Password {
    public static String solution(String s,int n){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            String pw=s.substring(i*7,i*7+7);
            pw=pw.replace('*','0').replace('#','1');
            sb.append((char)Integer.parseInt(pw,2));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        String result=solution(s,n);
        System.out.println(result);
    }

}
