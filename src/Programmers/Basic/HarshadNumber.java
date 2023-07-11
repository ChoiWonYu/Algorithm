package Programmers.Basic;

public class HarshadNumber {
    public static boolean solution(int x) {
        String num=Integer.toString(x);
        int sum=0;
        for(int i=0;i<num.length();i++){
            sum+=Integer.parseInt(num.substring(i,i+1));
        }
        return x%sum==0?true:false;
    }

    public static void main(String[] args) {
        boolean result=solution(10);
        System.out.println(result);
    }
}
