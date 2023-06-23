package Programmers.Basic;

public class DivideString {
    public static int solution(String s) {
        int answer = 0;
        char targetChar='?';
        int targetCount=0;
        int otherCount=0;
        for(int i=0;i<s.length();i++){
            if(targetChar=='?') {
                targetChar = s.charAt(i);
                targetCount=1;
                otherCount=0;
                continue;
            }
            if(targetChar!=s.charAt(i))otherCount++;
            else if(targetChar==s.charAt(i))targetCount++;
            if(targetCount==otherCount) {
                answer++;
                targetChar='?';
            }
        }

        return targetChar=='?'?answer:answer+1;
    }

    public static void main(String[] args){
        int result=solution("aaabbaccccabba");
        System.out.println(result);
    }
}
