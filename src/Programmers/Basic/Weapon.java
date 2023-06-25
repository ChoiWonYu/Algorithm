package Programmers.Basic;

public class Weapon {
    public static int getDivisor(int num){

        int cnt=0;
        if(Math.sqrt(num)%1==0)cnt++;
        for(int i=1;i<Math.sqrt(num);i++){
            if(num%i==0)cnt+=2;
        }
        return cnt;
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;
        while(number>0){
            int d=getDivisor(number);
            answer+=(d<=limit?d:power);
            number--;
        }
        return answer;
    }

    public static void main(String[] args){
        int result=solution(10,3,2);
        System.out.println(result);
    }
}
