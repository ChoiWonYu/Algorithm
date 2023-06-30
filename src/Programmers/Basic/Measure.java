package Programmers.Basic;

public class Measure {
    public static int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            if(i%Math.sqrt(i)==0){
                answer-=i;
            }
            else answer+=i;
        }
        return answer;
    }

    public static void main(String[]args){
        int result=solution(24,27);
        System.out.println(result);
    }
}
