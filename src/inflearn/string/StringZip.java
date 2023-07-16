package inflearn.string;

import java.util.*;

public class StringZip {
    public static String solution(String s){
        StringBuilder sb=new StringBuilder();
        int cnt=0;
        int i=0;
        while(i<s.length()){
            char targetCh=s.charAt(i++);
            while(i<s.length()&&s.charAt(i)==targetCh) {
                cnt++;
                i++;
            }
            sb.append(targetCh);
            if(cnt!=0)sb.append(cnt+1);
            cnt=0;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String result=solution(sc.next());
        System.out.println(result);
    }
}
