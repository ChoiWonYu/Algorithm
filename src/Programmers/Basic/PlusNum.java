package Programmers.Basic;

public class PlusNum {
    public static int solution(int[] numbers) {
        int answer=45;
        for(int i:numbers){
            answer-=i;
        }
        return answer;
    }

    public static void main(String[]args){
        int []nums={5,8,4,0,6,7,9};
    int result=solution(nums);
    System.out.println(result);
    }
}
