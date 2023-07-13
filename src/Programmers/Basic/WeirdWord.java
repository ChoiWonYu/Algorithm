package Programmers.Basic;

import java.util.Arrays;

public class WeirdWord {
    public static String solution(String s) {
        StringBuilder sb=new StringBuilder();
        StringBuilder wsb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char targetCh=s.charAt(i);
            if(targetCh==' '){
                sb.append(' ');
            }
            else{
                int cnt=0;
                while(targetCh!=' '&i<s.length()){
                    targetCh=s.charAt(i);
                    if(cnt%2==0)wsb.append(Character.toUpperCase(targetCh));
                    else wsb.append(Character.toLowerCase(targetCh));
                    i+=1;
                    cnt++;
                }
                i-=1;
                sb.append(wsb.toString());
                wsb.delete(0,wsb.length());
            }
        }
        return sb.toString();
}

    public static void main(String[] args) {
        String result=solution("try hello world");
        System.out.println(result);
    }
}
