package Programmers.Basic;

public class CalculatePrice {
    public static long solution(int price, int money, int count) {
        long answer = 0;
        for(int i=1;i<=count;i++){
            answer+=i*price;
        }
        return answer<=money?0:answer-money;
    }

    public static void main(String[] args){
        long result=solution(3,20,4);
        System.out.println(result);

    }


}
