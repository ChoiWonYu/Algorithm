package Programmers.Basic;

public class Cola {
    public static int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a){
            answer+=(n/a*b);
            n=(n/a*b)+n%a;
        }
        return answer;
    }
    public static void main(String[]args){
        int result=solution(3,1,20);
        System.out.println(result);
    }
}
