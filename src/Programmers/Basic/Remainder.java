package Programmers.Basic;

public class Remainder {
    public static int solution(int n) {
        int answer = 0;
        for(int i=2;i<n;i++){
            if(n%i==1) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int result=solution(12);
        System.out.println(result);
    }

}
