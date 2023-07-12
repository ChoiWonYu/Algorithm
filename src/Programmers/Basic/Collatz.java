package Programmers.Basic;

public class Collatz {
    public static long ifEven(long num){
        return num/2;
    }

    public static long ifNotEven(long num){
        return num*3+1;
    }


    public static int solution(int num) {
        int cnt=0;
        long n=num;
        while(cnt<500){
            if(n==1)return cnt;

            if( n%2==0){
                n=ifEven(n);
            }
            else n=ifNotEven(n);

            cnt++;

        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
