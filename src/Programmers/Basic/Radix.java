package Programmers.Basic;

public class Radix {
    public static int solution(int n) {
        String radix=Integer.toString(n,3);
        StringBuilder sb=new StringBuilder();
        for(int i=radix.length()-1;i>=0;i--){
            sb.append(radix.substring(i,i+1));
        }
        int reverse=Integer.parseInt(sb.toString(),3);
        return reverse;
    }

    public static void main(String[] args){
        int result=solution(125);
        System.out.println(result);
    }

}
