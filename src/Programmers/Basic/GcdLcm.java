package Programmers.Basic;

public class GcdLcm {
    public static int GCD(int a,int b){
        if(b==0)return a;
        return GCD(b,a%b);
    }

    public int[] solution(int n, int m) {
        int d=GCD(n,m);
        int mu=n*m/d;
        int[] answer = new int[] {d,mu};
        return answer;
    }

    public static void main(String[] args) {

    }
}
