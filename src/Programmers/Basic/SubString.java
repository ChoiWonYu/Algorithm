package Programmers.Basic;

public class SubString {
    public static int solution(String t, String p) {
        int cnt=0;
        int l=p.length();
        int i=0;
        while(i+l<=t.length()){
            if(Long.parseLong(t.substring(i,i+l))<=Long.parseLong(p))cnt++;
            i++;
        }
        return cnt;
    }
    public static void main(String[] args){
String t="111";
String p="12";

System.out.println(solution(t,p));
    }
}
