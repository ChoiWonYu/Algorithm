package Programmers.Basic;

public class GcdLcm {
    public static int Divisor(int a,int b){
        int n=0;
        while(b!=0){
            n=b;
            b=a%b;
            a=n;
        }
        return a;
    }

    public int[] solution(int n, int m) {
        int d=Divisor(n,m);
        int mu=n*m/d;
        int[] answer = new int[] {d,mu};
        return answer;
    }

    public static void main(String[] args) {

    }
}
