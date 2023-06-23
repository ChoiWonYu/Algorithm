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
                answer++;
                targetCount=1;
                continue;
            }

            if(targetChar!=s.charAt(i))otherCount++;
            else if(targetChar==s.charAt(i))targetCount++;

            if(targetCount==otherCount) {
                targetChar='?';
                targetCount=0;
                otherCount=0;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int result=solution("banana");
        System.out.println(result);
    }
}
